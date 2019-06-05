/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.model.Course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Raishin
 */
public class CourseDao {
    private static Connection conn=null;
    private static String url="jdbc:mysql://localhost:3306/ims";
    private static String user="root";
    private static String pass="";
    public static void connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(url, user, pass);
        
    }
    public static boolean insert(Course cm){
        boolean inserted=false;
        if(conn==null){
           try{
            connect(); //creates mysql database connection
           }
           catch(Exception e){
               System.out.println(e);}
        }
        try{
            String sql="insert into course_table(title,duration,price,detail) values(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            //mapping
            ps.setString(1, cm.getTitle());
            ps.setString(2, cm.getDuration());
            ps.setDouble(3, cm.getPrice());
            ps.setString(4,cm.getDetail());
            
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
    
    public static ArrayList<Course> selectAll(){
        ArrayList<Course> al=new ArrayList();
        if(conn==null){
            try{
            connect();
        }
            catch(ClassNotFoundException |SQLException ce){
                System.out.println(ce);
            }
        }
        String sql ="select * from course_table";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Course cm = new Course();
                //database table field to object field mapping
                cm.setId(rs.getInt("id"));
                cm.setTitle(rs.getString("title"));
                cm.setDuration(rs.getString("duration"));
                cm.setPrice(rs.getDouble("price"));
                cm.setDetail(rs.getString("detail"));
                
                al.add(cm);
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
    
    public static Course selectById(int id){
        Course cm=null;
         if(conn==null){
            try{
            connect();
        }
            catch(ClassNotFoundException |SQLException ce){
                System.out.println(ce);
            }
        }
         String sql="select * from course_table where id=?";
          try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
             if(rs.next()){
                cm=new Course(rs.getInt("id"),rs.getString("title"),rs.getString("duration"),rs.getDouble("price"),rs.getString("detail"));
                
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

        return cm;
    }
    
    public static boolean update(Course cm){
        boolean inserted=false;
        if(conn==null){
           try{
            connect(); //creates mysql database connection
           }
           catch(Exception e){
               System.out.println(e);}
        }
        try{
            String sql="update course_table set title=?,duration=?,price=?,detail=? where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            //mapping
            ps.setString(1, cm.getTitle());
            ps.setString(2, cm.getDuration());
            ps.setDouble(3, cm.getPrice());
            ps.setString(4, cm.getDetail());
            
            ps.setInt(5, cm.getId());
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
        String sql="delete from course_table where id=?";
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
