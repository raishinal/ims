/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.controller;

import com.ims.dao.UserDao;
import com.ims.model.User;
import com.ims.utils.PassEncrypt;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Raishin
 */
@MultipartConfig(fileSizeThreshold=1024*1024*2, //2 MB
        maxFileSize=1024*1024*10,               //10 MB
        maxRequestSize=1024*1024*50)            //50MB
public class UserController extends HttpServlet {

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
            out.println("<title>Servlet UserController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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
                  ArrayList<User> al= UserDao.selectAll();
                // send data to display page
                request.setAttribute("userdata",al);
        if(request.getParameter("action").equalsIgnoreCase("add")){
            
            request.getRequestDispatcher("/adminregistration.jsp").forward(request, response);
            
            //diaplay part
            //fetch data from dataset to display
              
        }
        else if(request.getRequestURI().equals(request.getContextPath()+"/Admin/Course/Display")){
                
             al= UserDao.selectAll();
                // send data to display page
                request.setAttribute("userdata",al);
                //dispatch display page
                request.getRequestDispatcher("/userregistration.jsp").forward(request, response);
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
        
          if(request.getRequestURI().equals(request.getContextPath()+"/RegisterUser/Add")){
          User user = new User();
          boolean uploaded=false;
          if(request.getParameter("upass").equals(request.getParameter("ucpass"))){
          user.setUpass(PassEncrypt.crypt(request.getParameter("upass")));
          
          }
          else{
              request.setAttribute("error_pass", "Password did not match...");
              request.getRequestDispatcher("/userregistration.jsp").forward(request, response);
          }
          String uploadDir = request.getServletContext().getRealPath("/");
          System.out.println(uploadDir);
           File imageDir = new File(uploadDir+"UserImage");
          if(!imageDir.exists()){
              imageDir.mkdir();
          }
         for(Part part :request.getParts()){
             if(part.getName().equals("uimage")){
                 // this is my file part
                 String fileName = getFileName(part);
                 fileName=new File(fileName).getName();
                 // file is uploaded here
                 part.write(imageDir+ File.separator + fileName);
                 uploaded = true;
                 System.out.println("upload success");
                 user.setImage(fileName);
             }
         }
         //form field to boject field mapping
          user.setFname(request.getParameter("ufname"));
          user.setUname(request.getParameter("uname"));
          user.setAuthority(request.getParameter("uauthority"));
          user.setActive(request.getParameter("uactive"));
          user.setGender(request.getParameter("ugender"));
         if(UserDao.insert(user)){
             response.sendRedirect(request.getContextPath()+"/RegisterUser?action=add");
         }
         else{
             processRequest(request,response);
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

    private String getFileName(Part part){
        String contentDisp = part.getHeader("content-disposition");
        String[] items=contentDisp.split(";");
        for(String s: items){
            if(s.trim().startsWith("filename")){
                return s.substring(s.indexOf("=")+ 2,s.length()-1);  
            }
        }
        return "";
    }
}
