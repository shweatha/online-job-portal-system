
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aniru
 */
@WebServlet(urlPatterns = {"/Application"})
public class Application extends HttpServlet {

    static int count;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Register","root","admin");
            String CompanyName = request.getParameter("cname");
            String Posts = request.getParameter("Posts");
            ps = con.prepareStatement("select Count as PostCount from JobPost where CompanyName='"+CompanyName+"'and Post = '"+Posts+"'");
            rs = ps.executeQuery();
            while(rs.next()){
            count = rs.getInt("PostCount");
             }
            count = count+1;
            ps = con.prepareStatement("update JobPost set Count = '"+count+"' where CompanyName='"+CompanyName+"'and Post = '"+Posts+"' ");
            ps.executeUpdate();
            RequestDispatcher rd = request.getRequestDispatcher("Resumeupload.html");
            rd.forward(request,response);  
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
}
