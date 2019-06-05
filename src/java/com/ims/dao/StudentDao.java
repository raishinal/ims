/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.model.Student;
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
public class StudentDao {
     private static Connection conn=null;
    private static String url="jdbc:mysql://localhost:3306/ims";
    private static String user="root";
    private static String pass="";
    
    
    public static void connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(url, user, pass);
        
    }
    public static boolean insertOrUpdate(Student st){
        boolean insert=false,inserted=false;
        if(st.getId()==0){
            insert=true;
        }
        if(conn==null){
           try{
            connect(); //creates mysql database connection
           }
           catch(Exception e){
               System.out.println(e);}
        }
        try{
            PreparedStatement ps=null;
            if(insert){
            String sql="insert into student_table(name,address,gender,dob,hobbies,phone,country,email) values(?,?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            //mapping
            ps.setString(1, st.getName());
            ps.setString(2, st.getAddress());
            ps.setString(3, st.getGender());
            ps.setDate(4,java.sql.Date.valueOf(st.getDob()));
            ps.setString(5,st.getHobbies());
            ps.setLong(6,st.getPhone());
            ps.setString(7,st.getCountry());
            ps.setString(8,st.getEmail());
            }
            else{
                String sql="update student_table set name=?,address=?,gender=?,dob=?,hobbies=?,phone=?,country=?,email=? where id=?";
            ps=conn.prepareStatement(sql);
            //mapping
            ps.setString(1, st.getName());
            ps.setString(2, st.getAddress());
            ps.setString(3, st.getGender());
            ps.setDate(4,java.sql.Date.valueOf(st.getDob()));;
            ps.setString(5, st.getHobbies());
            ps.setLong(6, st.getPhone());
            ps.setString(7, st.getCountry());
            ps.setString(8, st.getEmail());
            ps.setInt(9, st.getId());
            }
            
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
    
    public static ArrayList<Student> selectAll(){
        ArrayList<Student> al=new ArrayList();
        if(conn==null){
            try{
            connect();
        }
            catch(ClassNotFoundException |SQLException ce){
                System.out.println(ce);
            }
        }
        String sql ="select * from student_table";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Student st = new Student();
                //database table field to object field mapping
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setAddress(rs.getString("address"));
                st.setGender(rs.getString("gender"));
                st.setDob(rs.getDate("dob").toLocalDate());
                st.setHobbies(rs.getString("hobbies"));
                st.setPhone(rs.getLong("phone"));
                st.setCountry(rs.getString("country"));
                st.setEmail(rs.getString("email"));
                
                al.add(st);
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
    
      public static Student selectById(int id){
        Student st=null;
         if(conn==null){
            try{
            connect();
        }
            catch(ClassNotFoundException |SQLException ce){
                System.out.println(ce);
            }
        }
         String sql="select * from student_table where id=?";
          try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
             if(rs.next()){
                st=new Student(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getString("gender")
                        ,rs.getString("hobbies"),rs.getLong("phone"),rs.getString("country"),rs.getString("email"),rs.getDate("dob").toLocalDate());
                
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

        return st;
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
        String sql="delete from student_table where id=?";
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
