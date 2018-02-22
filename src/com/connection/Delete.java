package com.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Delete extends HttpServlet
{
	public static String n;

	public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
			
	//public  String s;	
	Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    n=request.getParameter("x");

	 String url = "jdbc:mysql://localhost:3306/";
     String dbName = "signup";
     String driver = "com.mysql.jdbc.Driver";
     String userName = "root";
     String password = "perfois@123";
     try {
         Class.forName(driver).newInstance();
         conn = DriverManager.getConnection(url + dbName, userName, password);
         pst = conn.prepareStatement("delete from moviedetails where imdbID='"+n+"'");
         pst.executeUpdate();
         }
     catch(Exception e)
     {
    	 System.out.println("error");
     }
}}
