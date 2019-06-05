/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.controller;

import com.ims.dao.CourseDao;
import com.ims.model.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raishin
 */
public class coursecontroller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response,String msg)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>IMS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+request.getContextPath() + "</h1>");
            out.println("<h3>"+msg+"</h3>");
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
        if(request.getRequestURI().equals(request.getContextPath()+"/Admin/Course/Add")){
            RequestDispatcher rd=request.getRequestDispatcher("/addcourse.jsp");
            rd.forward(request, response);
        }
        
        else if(request.getRequestURI().equals(request.getContextPath()+"/Admin/Course/Display")){
                //fetch data from dataset to display
                ArrayList<Course> al= CourseDao.selectAll();
                // send data to display page
                request.setAttribute("coursedata",al);
                //dispatch display page
                request.getRequestDispatcher("/Displaycourse.jsp").forward(request, response);
            
            }
        
        else if(request.getRequestURI().equals(request.getContextPath()+"/Admin/Course/Edit")){
            int id = Integer.parseInt(request.getParameter("id"));
            Course cm = CourseDao.selectById(id);
            request.setAttribute("course",cm);
            request.getRequestDispatcher("/Editcourse.jsp").forward(request,response);
        }
        
        else if(request.getRequestURI().equals(request.getContextPath()+"/Admin/Course/Delete")){
            int id=Integer.parseInt(request.getParameter("id"));
            if(CourseDao.delete(id)){
                 response.sendRedirect(request.getContextPath()+"/Admin/Course/Display");
            }
            else
                processRequest(request,response,"<Strong>Record Not Deleted.</Strong>");
        }
        
         else if(uri.equals(cp+"/Course/Detail")){
            int id=Integer.parseInt(request.getParameter("id"));
            request.setAttribute("coursedetails", CourseDao.selectById(id));
            request.getRequestDispatcher("/coursedetail.jsp").forward(request, response);
            
            //diaplay part
            //fetch data from dataset to display
              
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
//        processRequest(request, response);
        if(request.getRequestURI().equals(request.getContextPath()+"/Admin/Course/Add")){
            //form field to object field values mapping
            Course cm = new Course();
            cm.setTitle(request.getParameter("ctitle"));
            cm.setDuration(request.getParameter("cduration"));
            cm.setPrice(Double.parseDouble(request.getParameter("cprice")));
            cm.setDetail(request.getParameter("cdetail"));
            
            if(CourseDao.insert(cm)){
//                RequestDispatcher rd=request.getRequestDispatcher("/addcourse.jsp");
//                rd.forward(request, response);
            // creates form resubmission problem 
            //instead use sendRdirect which redirects to a page as new get request
            response.sendRedirect(request.getContextPath()+"/Admin/Course/Display");
            }
            else{
                processRequest(request,response,"Record not inserted...");
            }
        }
        
       else if(request.getRequestURI().equals(request.getContextPath()+"/Admin/Course/Update")){
            //form field to object field values mapping
            Course cm = new Course();
            cm.setId(Integer.parseInt(request.getParameter("cid")));
            cm.setTitle(request.getParameter("ctitle"));
            cm.setDuration(request.getParameter("cduration"));
            cm.setPrice(Double.parseDouble(request.getParameter("cprice")));
            cm.setDetail(request.getParameter("cdetail"));
            if(CourseDao.update(cm)){
                response.sendRedirect(request.getContextPath()+"/Admin/Course/Display");
                
            }
            else{
                processRequest(request,response,"<Strong>Record Update failed..</Strong>");
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
