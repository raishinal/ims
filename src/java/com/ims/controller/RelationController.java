/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.controller;

import com.ims.dao.CourseDao;
import com.ims.dao.RelationDao;
import com.ims.dao.StudentDao;
import com.ims.model.Course;
import com.ims.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raishin
 */
public class RelationController extends HttpServlet {

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
            out.println("<title>Servlet RelationController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RelationController at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);

        if(request.getParameter("action").equalsIgnoreCase("add")){
            // display courses and students
             ArrayList<Course> alc =CourseDao.selectAll();
             ArrayList<Student> als =StudentDao.selectAll();
             
             request.setAttribute("courses", alc);
             request.setAttribute("students",als);
             // display relation table data
             request.setAttribute("studentcourse", RelationDao.selectAll());
             request.getRequestDispatcher("/studentcourse.jsp").forward(request, response);
             
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

    if(request.getParameter("action").equalsIgnoreCase("save")){
        int sid=Integer.parseInt(request.getParameter("rstudent"));
        int cid=Integer.parseInt(request.getParameter("rcourse"));
        
        if(RelationDao.insert(sid,cid)){
            System.out.println("relation added");
            response.sendRedirect(request.getContextPath()+"/Relation?action=add");
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
