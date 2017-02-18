package io.muic.ooc.webapp.service;

import java.sql.*;

/**
 * Created by palm on 2/17/2017 AD.
 */
public class SQLService {


    enum TestTableColumns {
        id,username,password;
    }

    private final String jdbcDriverStr;
    private final String jdbcURL;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public SQLService(String jdbcDriverStr, String jdbcURL) {
        this.jdbcDriverStr = jdbcDriverStr;
        this.jdbcURL = jdbcURL;
    }

    public void deleteData(String oldUser) {
        try {
            Class.forName(jdbcDriverStr);

            connection = DriverManager.getConnection(jdbcURL + "?useSSL=false", "root", "PinyapatpawiT24");

            preparedStatement = connection.prepareStatement("delete from palm where username = '"+oldUser+"'");

            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateData(String user,String oldUser) {
        try {
            Class.forName(jdbcDriverStr);

            connection = DriverManager.getConnection(jdbcURL + "?useSSL=false", "root", "PinyapatpawiT24");

            preparedStatement = connection.prepareStatement("update palm set username = '"+user +"' where username = '"+oldUser+"'");

            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeData(String username, String password) {
        try {
            Class.forName(jdbcDriverStr);

            connection = DriverManager.getConnection(jdbcURL + "?useSSL=false", "root", "PinyapatpawiT24");

            preparedStatement = connection.prepareStatement("insert into palm (username,password) values (?,?);");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean getData(String user, String pass){
        try {
            Class.forName(jdbcDriverStr);

            connection = DriverManager.getConnection(jdbcURL + "?useSSL=false", "root", "PinyapatpawiT24");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sys.palm;");
            System.out.println(user);
            System.out.println(pass);
            while (rs.next()) {
                String cu = rs.getString("username");
                String cp = rs.getString("password");
                System.out.println(cu);
                System.out.println(cp);
                if (user.equals(cu)&&user.equals(cp)){
                    return true;
                }
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean editData(String user, String pass){
        try {
            Class.forName(jdbcDriverStr);

            connection = DriverManager.getConnection(jdbcURL + "?useSSL=false", "root", "PinyapatpawiT24");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sys.palm;");
            System.out.println(user);
            System.out.println(pass);
            while (rs.next()) {
                String cu = rs.getString("username");
                String cp = rs.getString("password");
                System.out.println(cu);
                System.out.println(cp);
                if (user.equals(cu)&&user.equals(cp)){
                    return true;
                }
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



}
