/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.controller;

import com.ims.dao.BlogDao;
import com.ims.model.Blog;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
public class BlogController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param message
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response,String message)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BlogError</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>BlogController status " + message +"</h1>");
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
        if(uri.equals(cp+"/Blog/Display")){
            // display blog page from front end
        }
        else if(uri.equals(cp+"/Admin/Blog/Add")){
            // open backend addblog page
            request.getRequestDispatcher("/addblog.jsp").forward(request, response);
        }
         else if(uri.equals(cp+"/Admin/Blog/Display")){
            //fetch course list from database
            request.setAttribute("blogdata",BlogDao.selectAll());
            request.getRequestDispatcher("/displayblog.jsp").forward(request, response);
        }
        else if(uri.equals(cp+"/Blog")){
            request.setAttribute("blogdata", BlogDao.selectAll());
            request.getRequestDispatcher("/blog.jsp").forward(request, response);
        }
        else if(uri.equals(cp+"/Blog/Detail")){
            int id=Integer.parseInt(request.getParameter("id"));
            request.setAttribute("blogdetail", BlogDao.selectById(id));
            request.getRequestDispatcher("/blogdetail.jsp").forward(request, response);
            
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
        String uri=request.getRequestURI();
        String cp=request.getContextPath();
        if(uri.equals(cp+"/Admin/Blog/Add")){
       Blog blog=new Blog();
        boolean uploaded=false;
        String uploadDir = request.getServletContext().getRealPath("/");
          System.out.println(uploadDir);
             File imageDir = new File(uploadDir+"blogimage");
          if(!imageDir.exists()){
              imageDir.mkdir();
          }
          for(Part part :request.getParts()){
             if(part.getName().equals("bimage")){
                 // this is my file part
                 String fileName = getFileName(part);
                 fileName=new File(fileName).getName();
                 // file is uploaded here
                 part.write(imageDir+ File.separator + fileName);
                 uploaded = true;
                 System.out.println("upload success");
                 blog.setImage(fileName);
             }
         }
            // collet form data and add to a blog model object
            
            blog.setTitle(request.getParameter("btitle"));
            blog.setAuthor(request.getParameter("bauthor"));
            blog.setCategory(request.getParameter("bcategory"));
            blog.setArticle(request.getParameter("barticle"));
            //adding current date for date field of blog object
            blog.setDate(LocalDate.now());
            if(BlogDao.insert(blog)){
              response.sendRedirect(cp+"/Admin/Blog/Add");
            }
            else{
                processRequest(request,response,"blog not added");
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
