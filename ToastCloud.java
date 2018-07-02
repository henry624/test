import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ToastCloud extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
Connection con = null;
Statement stmt = null;
ResultSet rs = null;

res.setContentType("text/html; charset=euc-kr");
PrintWriter out = res.getWriter();

try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(
"jdbc:mysql://192.168.0.5:13306/rep_test", "repl", "1qaz@WSX");

stmt = con.createStatement();

rs = stmt.executeQuery("SELECT name,det,addr FROM student_tb");

out.println("<HTML><HEAD><TITLE>Kimdongho  Member</TITLE></HEAD>");
out.println("<BODY>");
out.println("<UL>");
while(rs.next()) {
out.println("<LI>"+rs.getString("name")+" "+rs.getString("det")+" "+rs.getString("addr"));
}
out.println("</UL>");
out.println("</BODY></HTML>");
}

catch(ClassNotFoundException e) {
out.println("WAS1 Couldn't load database driver: " + e.getMessage());
}
catch(SQLException e) {
out.println("SQLException caught: " + e.getMessage());
}
finally {


try {
if (con != null) con.close();
}
catch (SQLException ignored) { }
}
}
}
