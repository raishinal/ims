/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.controller;

import com.ims.dao.BlogDao;
import com.ims.dao.CourseDao;
import com.ims.dao.UserDao;
import com.ims.utils.PassEncrypt;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raishin
 */
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
         String uri=request.getRequestURI();
        String cp=request.getContextPath();
        
        if(uri.equals(cp+"/login")){
          
           
            request.getRequestDispatcher("/login.jsp").forward(request, response);
              try{
            if(request.getParameter("action").equalsIgnoreCase("failure")){
            request.setAttribute("error", "Username or password did not match");
              request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
            }
              catch(Exception e)
              {
                  System.out.println(e);
              }
        }
        else if(uri.equals(cp+"/logout")){
        HttpSession session=request.getSession(false);
        if(session!=null){
        session.invalidate();
        //invalidates existing user session
        }
        response.sendRedirect(cp+"/login?action=logout");
        
    }
        else if(uri.equals(cp+"/Home")){
            request.setAttribute("blogdata",BlogDao.selectAll());
            request.setAttribute("coursedata",CourseDao.selectAll());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
       
        else if(uri.equals(cp+"/About")){
            request.getRequestDispatcher("/about.jsp").forward(request, response);
        }
        else if(uri.equals(cp+"/Courses")){
            //fetch course list from database
            request.setAttribute("courselist",CourseDao.selectAll());
            request.getRequestDispatcher("/courses.jsp").forward(request, response);
        }
        else if(uri.equals(cp+"/Contact")){
            request.getRequestDispatcher("/contact.jsp").forward(request, response);
        }
        else if(uri.equals(cp+"/Calenders")){
            request.getRequestDispatcher("/calenders.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uri=request.getRequestURI();
        String cp=request.getContextPath();
        
        if(uri.equals(cp+"/login")){
            String user=request.getParameter("user");
            String pass=PassEncrypt.crypt(request.getParameter("pass").trim());
            if(UserDao.validateUser(user,pass)){
                //login is successful
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                // session is set for new user
                //redirect logined in user to admindashboard page
                response.sendRedirect(cp+"/Admin/Dashboard");
            }
            else{
                       response.sendRedirect(cp+"/login?action=failure");
                        }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
