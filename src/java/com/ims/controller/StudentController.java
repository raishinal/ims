/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.controller;

import com.ims.dao.StudentDao;
import com.ims.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.tribes.util.Arrays;

/**
 *
 * @author Raishin
 */
public class StudentController extends HttpServlet {
public static String check;
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
            out.println("<title>Servlet StudentController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentController at " + request.getContextPath() + "</h1>");
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
      
        ArrayList<Student> al= StudentDao.selectAll();
                // send data to display page
                request.setAttribute("studentdata",al);
                
        String uri=request.getRequestURI();
            String cp = request.getContextPath();
            if(uri.equals(cp+"/Admin/Student/Add")){
                request.getRequestDispatcher("/student.jsp").forward(request,response);
                     
             
            }
       
            
            else if(request.getRequestURI().equals(request.getContextPath()+"/Admin/Student/Display")){
                //fetch data from dataset to display
              al= StudentDao.selectAll();
                // send data to display page
                request.setAttribute("studentdata",al);
                //dispatch display page
                request.getRequestDispatcher("/student.jsp").forward(request, response);
            
            }
            
            else if(request.getRequestURI().equals(request.getContextPath()+"/Admin/Student/Edit")){
            int id = Integer.parseInt(request.getParameter("id"));
            Student cm = StudentDao.selectById(id);
            request.setAttribute("studentedit",cm);
            request.getRequestDispatcher("/student.jsp").forward(request,response);
        }
        
        else if(request.getRequestURI().equals(request.getContextPath()+"/Admin/Student/Delete")){
            int id=Integer.parseInt(request.getParameter("id"));
            if(StudentDao.delete(id)){
                 response.sendRedirect(request.getContextPath()+"/Admin/Student/Display");
            }
            else
                processRequest(request,response,"<Strong>Record Not Deleted.</Strong>");
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
        if(uri.equals(cp+"/Admin/Student/Add")){
            Student st = new Student();
            
            if(null==request.getParameter("sid")){
                System.out.println("Insert operation");
            }
            else{
                st.setId(Integer.parseInt(request.getParameter("sid")));
                System.out.println("Update"+st.getId());   
            }
            st.setName(request.getParameter("sname"));
            st.setAddress(request.getParameter("saddress"));
            st.setGender(request.getParameter("sgender"));
            st.setDob(LocalDate.parse(request.getParameter("sdob")));
            st.setHobbies(Arrays.toString(request.getParameterValues("shobbies")));
            st.setPhone(Long.parseLong(request.getParameter("sphone")));
            st.setCountry(request.getParameter("scountry"));
            st.setEmail(request.getParameter("semail")); 
            if(StudentDao.insertOrUpdate(st)){
//                RequestDispatcher rd=request.getRequestDispatcher("/addcourse.jsp");
//                rd.forward(request, response);
            // creates form resubmission problem 
            //instead use sendRdirect which redirects to a page as new get request
            response.sendRedirect(request.getContextPath()+"/Admin/Student/Display");
            }
            else{
                processRequest(request,response,"<Strong>Record Not Inserted.</Strong>");
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
