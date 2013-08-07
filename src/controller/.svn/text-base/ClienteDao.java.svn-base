package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.ClienteBean;
import model.ConnectionFactory;

/**
 *
 * @author Ítalo
 */
public class ClienteDao extends ClienteBean {

    private Connection connection;
    private PreparedStatement comandoSQL;
    //private final String DATABASE = "fp0520111068"; //Tecnico
    private final String DATABASE = "dbMatryuska"; //Guilherme

    public ClienteDao() throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public ClienteDao(ClienteBean bean) throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
        this.setCodigo(bean.getCodigo());
        this.setCelular(bean.getCelular());
        this.setCodigoUsuario(bean.getcodigoUsuario());
        this.setDataCadastro(bean.getDataCadastro());
        this.setNome(bean.getNome());
        this.setTelefone(bean.getTelefone());
    }

    public void incluir() throws ParseException, SQLException {

        String sql = "INSERT INTO T_Cliente (NomeCliente, FoneCliente, "
                + "CelCliente, DataCadastroCliente, CodUsuario)"
                + "VALUES(?,?,?,?,?)";

        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date) f.parse(getDataCadastro());
        
        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setString(1, getNome());
        comandoSQL.setString(2, getTelefone());
        comandoSQL.setString(3, getCelular());
        comandoSQL.setDate(4, new java.sql.Date(date.getTime()));
        comandoSQL.setInt(5, getcodigoUsuario());

        comandoSQL.execute();
        comandoSQL.close();
        connection.close();
    }

    public void alterar() throws ParseException, SQLException {

        String sql = "UPDATE T_Cliente SET "
                + "NomeCliente=?,"
                + "FoneCliente=?,"
                + "CelCliente=?,"
                + "DataCadastroCliente=?,"
                + "CodUsuario=? "
                + "WHERE CodCliente = ?";

        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date) f.parse(getDataCadastro());
        
        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setString(1, getNome());
        comandoSQL.setString(2, getCelular());
        comandoSQL.setString(3, getTelefone());
        comandoSQL.setDate(4, new java.sql.Date(date.getTime()));
        comandoSQL.setInt(5, getcodigoUsuario());
        comandoSQL.setInt(6, getCodigo());

        comandoSQL.execute();
        comandoSQL.close();
        connection.close();

    }

    public void excluir() throws SQLException {

        String sql = "DELETE FROM T_Cliente WHERE CodCliente = ?";
        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setInt(1, getCodigo());
        comandoSQL.execute();
        comandoSQL.close();
        connection.close();

    }

    public ArrayList<ClienteBean> pesquisar() throws SQLException {
        ClienteBean clientesRetorno = null;
        ArrayList<ClienteBean> listaClientes = new ArrayList<ClienteBean>();
        String sql = "SELECT * FROM T_Cliente";

        comandoSQL = connection.prepareStatement(sql);

        ResultSet rs = comandoSQL.executeQuery();

        while (rs.next()) {
            clientesRetorno = new ClienteBean();
            
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            String date = f.format(rs.getDate("DataCadastroCliente"));
            clientesRetorno.setDataCadastro(date);
            clientesRetorno.setCodigo(rs.getInt("CodCliente"));
            clientesRetorno.setNome(rs.getString("NomeCliente"));
            clientesRetorno.setCelular(rs.getString("CelCliente"));
            clientesRetorno.setTelefone(rs.getString("FoneCliente"));
            clientesRetorno.setCodigoUsuario(rs.getInt("CodUsuario"));

            listaClientes.add(clientesRetorno);
        }

        rs.close();
        comandoSQL.close();
        connection.close();

        return listaClientes;

    }
}
