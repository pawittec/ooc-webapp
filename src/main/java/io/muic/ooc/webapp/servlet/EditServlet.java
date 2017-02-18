package io.muic.ooc.webapp.servlet;

import io.muic.ooc.webapp.service.SQLService;
import io.muic.ooc.webapp.service.SecurityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class EditServlet extends HttpServlet {

    private SecurityService securityService;
    private SQLService sql = new SQLService("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/sys");
    private String oldUser = "";

    public void setSecurityManager(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        oldUser = request.getParameter("username");
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/edit.jsp");
        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        System.out.println(user);
        System.out.println(oldUser);
        sql.updateData(user,oldUser);
        response.sendRedirect("/");
    }
}
