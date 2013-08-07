package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    /* Constantes para a conexao com o Banco de Dados, descomentar e comentar
     * conforme necessidade
     */
    
    private static final String PATH = "localhost";
    private static final String DATABASE = "matryuska";
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

    /**
     * 
     * @return Uma interface Connection para se conectar com o Banco de Dados
     * @throws ClassNotFoundException Se a classe com.mysql.jdbc.Driver nao for 
     * encontrada
     * @throws SQLException Se ocorrer um erro de acesso ao Banco de Dados
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + PATH + "/"
                + DATABASE, USER, PASS);

        return connection;
    }
}