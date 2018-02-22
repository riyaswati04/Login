package com.connection;

import java.io.*;

import java.lang.reflect.Type;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;




public class Connect1 extends HttpServlet{
	 public static String n;
	 public String count;
	 public static int c=0;
	 private static final long serialVersionUID = 1L;
	 public static List<Conversion> Search;
         public ArrayList<Conversion> conv1 = new ArrayList<Conversion>();
       
      

	    public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  

	       // response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	        //System.out.println("Enter java");
	        n=request.getParameter("t");
	        //count=request.getParameter("rowadd");
	        
	        n.trim();int i=0;
	        n=n.replace(" ","+");
	        
	           con();

	        response.setContentType("application/json");
	        response.setCharacterEncoding("utf-8");
	        response.getWriter().write(new Gson().toJson(conv1));
	        out.close();
		  
	      /* response.setContentType("text/html");  
	        PrintWriter out1= response.getWriter(); 
	        HttpSession session = request.getSession(false);
	       RequestDispatcher rd=request.getRequestDispatcher("connect1.jsp");  
           rd.forward(request,response);  
           out1.close();
  */
	       
	    }

   public String getHTML(String urlToRead) throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlToRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
         result.append(line);
      }
      rd.close();
      return result.toString();
   }
   

   public void con() 
   {
	   String jstring="";
	 try {
		 jstring=getHTML("http://www.omdbapi.com/?apikey=7af96006&s=%22"+n+"%22");
	 } catch(Exception e) {
		 e.printStackTrace();	
	 }
	 
 	   Gson gson=new Gson();	  
	   System.out.println(jstring);	   
	   Find f=gson.fromJson(jstring,Find.class);
	   Search=f.getsearch();
	  // for(Conversion cc:Search){
		//   System.out.println(cc);}
	   //Conversion c1=new Conversion();
	   Connection conn = null;
       PreparedStatement pst = null;
       ResultSet rs = null;

       String url = "jdbc:mysql://localhost:3306/";
       String dbName = "signup";
       String driver = "com.mysql.jdbc.Driver";
       String userName = "root";
       String password = "perfois@123";
       try {
           Class.forName(driver).newInstance();
           conn = DriverManager.getConnection(url + dbName, userName, password);
           int z=0;
           //pst = conn.prepareStatement("truncate moviedetails");
           //pst.executeUpdate();
           for(Conversion c1:Search) {
        	  //if(c!=0  z>c)
        		//    break;
        	   //else
        		 //  z++;
           pst = conn.prepareStatement("insert into moviedetails(Title,Year,imdbID,Type,Poster) values(?,?,?,?,?)");
           pst.setString(1, c1.getTitle());
           pst.setString(2, c1.getYear());
           pst.setString(3, c1.imdbID());
           pst.setString(4, c1.getType());
           pst.setString(5,c1.getPoster());

           pst.executeUpdate();
           
          //Rendering
           			String query = "Select * from moviedetails where title like '%"+n+"%' limit 10;";
           			 
           			
         	       pst=conn.prepareStatement(query);
        	       rs=pst.executeQuery();
                   conv1.clear();
                       int i=0;
        	       while (rs.next()) {
        	         Conversion c=new Conversion(rs.getString("Title"),rs.getString("Year"),rs.getString("imdbID"),rs.getString("Type"),rs.getString("Poster"));
        	         String title=rs.getString("Title");
        	         String year=rs.getString("Year");
        	         String imdbid=rs.getString("imdbID");
        	         String type=rs.getString("Type");
        	         String poster=rs.getString("Poster");
        	         String row="Title="+title+" ,Year="+year+" ,imdbID="+imdbid+" ,Type="+type+" ,Poster="+poster;
        	         System.out.println(row);
        	         conv1.add(c);
                         i++;
        	      }

		System.out.println("size is     "+conv1.size()+" and i is = "+i);
           }
           

       } catch (Exception e) {
           System.out.println(e);
       } finally {
           if (conn != null) {
               try {
                   conn.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if (pst != null) {
               try {
                   pst.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if (rs != null) {
               try {
                   rs.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
       }


	   return;
   }
}
	
