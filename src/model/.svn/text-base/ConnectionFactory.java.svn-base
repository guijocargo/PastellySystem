package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String PATH = "localhost";
    private static final String DATABASE = "dbmatryuska";
    private static final String USER = "root";
    private static final String PASS = "root";
    /*
    private static final String PATH = "sepultura.fprestes.com.br";
    private static final String DATABASE = "fp0520111068";
    private static final String USER = "fp0520111068";
    private static final String PASS = "A12345678a";*/

    public static String getDATABASE() {
        return DATABASE;
    }

    public static String getPASS() {
        return PASS;
    }

    public static String getPATH() {
        return PATH;
    }

    public static String getUSER() {
        return USER;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + PATH + "/"
                + DATABASE, USER, PASS);

        return connection;

    }
}