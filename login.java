/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anirudh
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String emails = request.getParameter("email");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PrintWriter out = response.getWriter();
        try{              
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Register","root","admin");
             out.println("Connection Successfull");
             String i="select * from Registration";
             st = con.createStatement();
             rs = st.executeQuery(i);
             while(rs.next()){
                 String username = rs.getString("Username");
                 String userpass = rs.getString("Userpassword");
                 
                 if(username.equals(user) && userpass.equals(pass)){
                     response.sendRedirect("welcome.html");
                 }   
             }
                
                response.sendRedirect("error_page.html");                      
        }
        catch(Exception e){
            System.out.println(e);
            }
    }
}

    

    
