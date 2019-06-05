/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.model.StudentCourseDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raishin
 */
public class RelationDao {
    private static Connection conn=null;
    private static final String url="jdbc:mysql://localhost:3306/ims";
    private static final String user="root";
    private static final String pass="";
    public static void connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(url, user, pass);
        
    }
    public static boolean insert(int sid, int cid){
        boolean inserted=false;
        try {
            
            connect();
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(RelationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            String sql="insert into student_course (sid,cid) value(?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, sid);
            ps.setInt(2, cid);
            
            if(ps.executeUpdate()>0){
                inserted=true;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return inserted;
    }
    
     public static ArrayList<StudentCourseDTO> selectAll(){
        ArrayList<StudentCourseDTO> all=new ArrayList();
        if(conn==null){
            try{
            connect();
        }
            catch(ClassNotFoundException |SQLException ce){
                System.out.println(ce);
            }
        }
        try{
              String sql ="select sc.id, s.name, s.phone, s.email, c.title, c.duration, c.price from student_course sc, student_table s, course_table c "
                      + "where sc.sid=s.id and sc.cid=c.id order by sc.id asc" ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                all.add(new StudentCourseDTO(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7)));
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
       
        return all;
    }
}
