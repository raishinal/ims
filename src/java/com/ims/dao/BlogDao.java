/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.model.Blog;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Raishin
 */
public class BlogDao {
     private static Connection conn=null;
    private static String url="jdbc:mysql://localhost:3306/ims";
    private static String user="root";
    private static String pass="";
    
    
    public static void connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(url, user, pass);
        
    }
     public static boolean insert(Blog blog){
        boolean inserted=false;
        if(conn==null){
           try{
            connect(); //creates mysql database connection
           }
           catch(Exception e){
               System.out.println(e);}
        }
        try{
            String sql="insert into blog_table(title,author,category,date,article,image) values(?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, blog.getTitle());
            ps.setString(2, blog.getAuthor());
            ps.setString(3, blog.getCategory());
            ps.setDate(4,Date.valueOf(blog.getDate()));
            ps.setString(5, blog.getArticle());
            ps.setString(6, blog.getImage());
            if(ps.executeUpdate()>0){
                inserted =true;
            }
        }
           catch(SQLException e){
               System.out.println(e);
           }
           finally{
               if(conn!=null){
                   try {
                       conn.close();
                       conn=null;
                   } catch (SQLException ex) {
                       System.out.println(ex);
                   }
               }
           }
        return inserted;
}
     
        
     public static ArrayList<Blog> selectAll(){
        ArrayList<Blog> al=new ArrayList();
        if(conn==null){
            try{
            connect();
        }
            catch(ClassNotFoundException |SQLException ce){
                System.out.println(ce);
            }
        }
        String sql ="select * from blog_table";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Blog bl= new Blog();
                //database table field to object field mapping
               bl.setId(rs.getInt("id"));
               bl.setTitle(rs.getString("title"));
               bl.setAuthor(rs.getString("author"));
               bl.setCategory(rs.getString("category"));
               bl.setDate(rs.getDate("date").toLocalDate());
               bl.setArticle(rs.getString("article"));
               bl.setImage(rs.getString("image"));
                al.add(bl);
               
            }
        }
        catch(SQLException se){
            System.out.println(se);
        }
         finally{
               if(conn!=null){
                   try {
                       conn.close();
                       conn=null;
                   } catch (SQLException ex) {
                       System.out.println(ex);
                   }
               }
           }
       
        return al;
    }
     
     
      public static Blog selectById(int id){
        Blog blog=null;
         if(conn==null){
            try{
            connect();
        }
            catch(ClassNotFoundException |SQLException ce){
                System.out.println(ce);
            }
        }
         String sql="select * from blog_table where id=?";
          try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
             if(rs.next()){
                blog=new Blog(rs.getInt("id"),rs.getString("title"),rs.getString("author"),rs.getString("category")
                        ,rs.getString("article"),rs.getDate("date").toLocalDate(),rs.getString("image"));
                
            }   
          }
          catch(SQLException e){
              System.out.println(e);
          }
          finally{
               if(conn!=null){
                   try {
                       conn.close();
                       conn=null;
                   }
                   catch (SQLException ex) {
                       System.out.println(ex);
                   }
               }
           }

        return blog;
    }
    
       
        
         public static boolean delete(int id){
        boolean status=false;
        if(conn==null){
           try{
            connect(); //creates mysql database connection
           }
           catch(Exception e){
               System.out.println(e);}
        }
        try{
        String sql="delete from blog_table where id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1, id);
        if(ps.executeUpdate()>0){
            status=true;
        }
    }
        catch(SQLException e){
            System.out.println(e);
        }
         finally{
               if(conn!=null){
                   try {
                       conn.close();
                       conn=null;
                   } catch (SQLException ex) {
                       System.out.println(ex);
                   }
               }
           }
        return status;
    }
         
       
}
