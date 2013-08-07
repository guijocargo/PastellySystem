package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ConnectionFactory;
import model.UserBean;

public class UserDao extends UserBean {

    private Connection connection;
    //private final String DATABASE = "fp0520111068"; //Tecnico
    private final String DATABASE = "dbMatryuska"; //Guilherme

    public UserDao() throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public boolean Login() throws SQLException {
        boolean returnValue = false;

        PreparedStatement statement = connection.prepareStatement("SELECT * "
                + "FROM t_usuario WHERE LoginUsuario=? AND SenhaUsuario=?");
        statement.setString(1, getLogin());
        statement.setString(2, getPassword());
        ResultSet rs = statement.executeQuery();
        if (rs.first()) {
            setCodigo(rs.getInt("codUsuario"));
            setNivel(rs.getInt("nivelUsuario"));
            returnValue = true;
        }
        rs.close();

        return returnValue;
    }

    public UserBean getById(String login) {
        UserBean user = new UserBean();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from User where email = ?");
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user.setLogin(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int getNivel(UserBean userBean) throws SQLException {
        int returnValue = 0;

        PreparedStatement statement = connection.prepareStatement("SELECT "
                + "NivelUsuario FROM t_usuario WHERE LoginUsuario=?");
        statement.setString(1, userBean.getLogin());
        ResultSet rs = statement.executeQuery();
        rs.next();
        returnValue = rs.getInt(1);
        rs.close();

        return returnValue;
    }
}