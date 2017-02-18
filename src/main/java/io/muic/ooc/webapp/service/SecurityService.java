/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.muic.ooc.webapp.service;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author gigadot
 */
public class SecurityService {
    private SQLService sql = new SQLService("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/sys");
    
    private Map<String, String> userCredentials = new HashMap<String, String>() {{
        put("admin", "123456");
        put("muic", "1111");
    }};
    
    public boolean isAuthorized(HttpServletRequest request) {
        String username = (String) request.getSession()
                .getAttribute("username");
        // do checking
        System.out.println(username);
       return (username != null );
    }
    
    public boolean authenticate(String username, String password, HttpServletRequest request) {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        boolean check = sql.getData(user,pass);
        return check;
    }
    
    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }
    
}
