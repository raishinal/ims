/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.dao;

import com.ims.model.Event;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Raishin
 */
public class EventDao {
     private static Connection conn=null;
    private static String url="jdbc:mysql://localhost:3306/ims";
    private static String user="root";
    private static String pass="";
    public static void connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(url, user, pass);
        
    }
    public static boolean insert(Event e){
        boolean inserted=false;
        if(conn==null){
           try{
            connect(); //creates mysql database connection
           }
           catch(Exception es){
               System.out.println(es);}
        }
        try{
            String sql="insert into event_table(title,date,description) values(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            //mapping
            ps.setString(1, e.getTitle());
            ps.setDate(2, Date.valueOf(e.getDate()));
            ps.setString(3, e.getDescirption());
            
            if(ps.executeUpdate()>0){
                inserted =true;
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
        return inserted;
}
}
