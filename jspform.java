import java.io.IOException;    
import java.io.PrintWriter;    
import java.sql.*;    
import javax.servlet.ServletException;    
import javax.servlet.annotation.WebServlet;    
import javax.servlet.http.HttpServlet;    
import javax.servlet.http.HttpServletRequest;    
import javax.servlet.http.HttpServletResponse;    
public class jspform extends HttpServlet {    
    private static final long jspform = 1L;     
    public jspform() {    
        super();       
    }    
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
        response.getWriter().append("Served at: ").append(request.getContextPath());    
    }    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
            
        PrintWriter pw;    
        response.setContentType("text/html");    
        pw=response.getWriter();    
            
            
        String name=request.getParameter("name");    
        String registration=request.getParameter("registration");    
        String grade=request.getParameter("grade");    
        String phone_nomber=request.getParameter("phone_nomber");    
        String email=request.getParameter("email");    
        String gender=request.getParameter("gender");    
        String course=request.getParameter("course");    
         
        {    
            Class.forName("com.mysql.jdbc.Driver");    
            String url="jdbc:mysql://localhost:3306/bcapracticals";    
            String user="root";    
            String password="admin";    
                
            Connection con=DriverManager.getConnection(url, user, password);    
            String query="Insert into bcs(name,registration,grade,phone_nomber,email,gender) values (?,?,?,?,?,?);";    
            PreparedStatement pstmt=con.prepareStatement(query);    
            pstmt.setString(1, name);    
            pstmt.setString(2, registration);    
            pstmt.setString(3,grade);    
            pstmt.setString(4, phone_nomber);    
            pstmt.setString(5, email);    
            pstmt.setString(6,gender);    
                
            int x=pstmt.executeUpdate();    
                
            if(x==1)    
            {    
            pw.println("Values Inserted Successfully");    
            }    
                
        }       
        pw.close();    
    }    
    
} 