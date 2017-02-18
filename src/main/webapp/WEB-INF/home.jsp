<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<html>
<form method="post">

<table border="2">
   <tr>
        <td>ID</td>
        <td>Username</td>
        <td>Password</td>
        <td> stuff <td>
   </tr>
   <%
   try
   {
       Class.forName("com.mysql.jdbc.Driver");
       String url="jdbc:mysql://localhost:3306/sys";
       String username="root";
       String password="PinyapatpawiT24";
       String query="SELECT * FROM sys.palm;";
       Connection conn=DriverManager.getConnection(url, username, password);
       Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(query);
       while(rs.next())
       {
   %>
        <tr>
        <% String s = rs.getString("Username"); %>
          <td><%=rs.getInt("id") %></td>
          <td><%=rs.getString("username") %></td>
          <td><%=rs.getString("password") %></td>
        <td>




        <form action="/edit?" method="get">
            <input type="hidden" name="username"  value="<%=s%>">
            <input type="submit" value="Edit">
        </form>

        <form action="delete?" method="get">
            <input type="hidden" name="username"  value="<%=s%>">
            <input type="submit" value="Delete">
        </form>
        </td>
        </tr>
   <%
       }
   %>
   </table>
   <%
        rs.close();
        stmt.close();
        conn.close();
   }
   catch(Exception e)
   {
        e.printStackTrace();
   }
   %>

</form>
<form action="/login" method="get">
            <input type="submit" value="log out">
        </form>
</html>
