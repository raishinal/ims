/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.model.User;
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
public class UserDao {
     private static Connection conn=null;
    private static String url="jdbc:mysql://localhost:3306/ims";
    private static String user="root";
    private static String pass="";
    
    
    public static void connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(url, user, pass);
        
    }
     public static boolean insert(User user){
        boolean inserted=false;
        if(conn==null){
           try{
            connect(); //creates mysql database connection
           }
           catch(Exception e){
               System.out.println(e);}
        }
        try{
            String sql="insert into user_table(name,username,password,authority,active,gender,image) values(?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            //mapping
            ps.setString(1, user.getFname());
            ps.setString(2, user.getUname());
            ps.setString(3, user.getUpass());
            ps.setString(4, user.getAuthority());
            ps.setString(5, user.getActive());
            ps.setString(6, user.getGender());
            ps.setString(7, user.getImage());
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
     
     public static ArrayList<User> selectAll(){
        ArrayList<User> al=new ArrayList();
        if(conn==null){
            try{
            connect();
        }
            catch(ClassNotFoundException |SQLException ce){
                System.out.println(ce);
            }
        }
        String sql ="select * from user_table";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                User user= new User();
                //database table field to object field mapping
                user.setId(rs.getInt("id"));
                user.setFname(rs.getString("name"));
                user.setUname(rs.getString("username"));
                user.setUpass(rs.getString("password"));
                user.setAuthority(rs.getString("authority"));
                user.setActive(rs.getString("active"));
                user.setGender(rs.getString("gender"));
                user.setImage(rs.getString("image"));
                
                al.add(user);
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
     
        public static User selectById(int id){
        User u=null;
         if(conn==null){
            try{
            connect();
        }
            catch(ClassNotFoundException |SQLException ce){
                System.out.println(ce);
            }
        }
         String sql="select * from user_table where id=?";
          try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
             if(rs.next()){
                u=new User(rs.getInt("id"),rs.getString("fname"),rs.getString("uname"),rs.getString("password")
                        ,rs.getString("authority"),rs.getString("status"),rs.getString("gender"),rs.getString("image"));
                
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

        return u;
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
        String sql="delete from user_table where id=?";
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
         
         public static boolean validateUser(String user,String pass){
             boolean valid=false;
          
        if(conn==null){
           try{
            connect(); //creates mysql database connection
           }
           catch(Exception e){
               System.out.println(e);}
        }
        try{
            String sql="select * from user_table where username=? and password=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            //mapping
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                valid=true;
            }
       
            if(ps.executeUpdate()>0){
               valid =true;
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
             return valid;
         }
}
