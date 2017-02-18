package io.muic.ooc.webapp.servlet;

import io.muic.ooc.webapp.service.SQLService;
import io.muic.ooc.webapp.service.SecurityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by palm on 2/17/2017 AD.
 */
public class RegisterServlet extends HttpServlet {

    private SecurityService securityService;
    private SQLService sql = new SQLService("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/sys");

    public void setSecurityManager(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/reg.jsp");
        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        if(!user.equals("")) {
            sql.writeData(user, pass);
            response.sendRedirect("/");
        }
        else{
            String error = "Username cannot be empty";
            System.out.println("ERROR");
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/reg.jsp");
            rd.include(request, response);
        }
    }
}
