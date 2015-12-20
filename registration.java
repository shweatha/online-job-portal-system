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
@WebServlet(urlPatterns = {"/Registration"})
public class Registration extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String emails = request.getParameter("email");
        String user = request.getParameter("name");
        String pass = request.getParameter("password");        
        Connection con = null;
        
        //ResultSet rs = null;
        PrintWriter out = response.getWriter();
        try{              
            // out.println("\n"+email+"\n"+user+"\n"+pass);
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Register","root","admin");
             out.println("Connection Successfull");
             String i="INSERT INTO Registration"+"(Email_id,Username,Userpassword)values"+"(?,?,?)";
             PreparedStatement st = con.prepareStatement(i);
            // rs = st.executeQuery(i);
             /*while(rs.next()){
                 String email_id = rs.getString("Email_id");
                 String user_name = rs.getString("Username");
                 String User_pass = rs.getString("Userpassword");
                 out.println("\n"+email_id);
                         
             }*/
             
             st.setString(1,emails);
             st.setString(2,user);
             st.setString(3,pass);
             st.executeUpdate();
             out.println("Statement created");
             out.println("Database updated successfully");              
        
        }
        catch(Exception e){
            System.out.println(e);
            }
    }
}

    

    
