package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.ConnectionFactory;
import model.UserBean;

/**
 * 
 * @author Guilherme
 */
public class UserDao extends UserBean {

    private Connection connection;
    private PreparedStatement comandoSQL;
    //private final String DATABASE = "fp0520111068"; //Tecnico
    private final String DATABASE = "matryuska"; //Guilherme

    /**
     * 
     * @throws ClassNotFoundException 
     * @throws SQLException 
     * @see ConnectionFactory.getConnection
     */
    public UserDao() throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public UserDao(int codigo, String login, String password, int nivel)
            throws ClassNotFoundException, SQLException {
        super(codigo, login, password, nivel);
        this.connection = ConnectionFactory.getConnection();
    }
    
    public UserDao(UserBean bean) throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
        this.setCodigo(bean.getCodigo());
        this.setLogin(bean.getLogin());
        this.setNivel(bean.getNivel());
        this.setPassword(bean.getPassword());
    }

    /**
     * 
     * @return True se o login foi bem sucedido, caso contrario retorna False
     * @throws SQLException Se um erro ocorreu nos objetos statement ou rs
     * @see java.sql.PreparedStatement
     * @see java.sql.ResultSet
     */
    public boolean Logar() throws SQLException {
        boolean returnValue = false;

        comandoSQL = connection.prepareStatement("SELECT * "
                + "FROM t_usuario WHERE LoginUsuario=? AND SenhaUsuario=?");
        comandoSQL.setString(1, getLogin());
        comandoSQL.setString(2, getPassword());
        
        ResultSet rs = comandoSQL.executeQuery();
        if (rs.first()) {
            setCodigo(rs.getInt("codUsuario"));
            setNivel(rs.getInt("nivelUsuario"));
            returnValue = true;
        }
        rs.close();

        return returnValue;
    }
    
    public void alterar() throws ParseException, SQLException {

        String sql = "UPDATE T_Usuario SET "
                + "LoginUsuario=?,"
                + "SenhaUsuario=?,"
                + "NivelUsuario=?,"
                + "WHERE CodUsuario = ?";
        
        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setString(1, getLogin());
        comandoSQL.setString(2, getPassword());
        comandoSQL.setInt(3, getNivel());
        comandoSQL.setInt(4, getCodigo());

        comandoSQL.execute();
        comandoSQL.close();
        connection.close();

    }

    public List<UserBean> pesquisar() throws SQLException {
        UserBean usuariosRetorno;
        ArrayList<UserBean> listaUsuarios = new ArrayList<UserBean>();
        String sql = "select * from t_usuario";

        comandoSQL = connection.prepareStatement(sql);

        ResultSet rs = comandoSQL.executeQuery();

        while (rs.next()) {
            usuariosRetorno = new UserBean();
            
            usuariosRetorno.setCodigo(rs.getInt("CodUsuario"));
            usuariosRetorno.setLogin(rs.getString("LoginUsuario"));
            usuariosRetorno.setPassword(rs.getString("SenhaUsuario"));
            usuariosRetorno.setNivel(rs.getInt("NivelUsuario"));

            listaUsuarios.add(usuariosRetorno);
        }

        rs.close();
        comandoSQL.close();
        connection.close();

        return listaUsuarios;
    }
}