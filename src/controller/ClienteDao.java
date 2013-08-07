package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
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
    private final String DATABASE = "matryuska"; //Guilherme

    public ClienteDao() throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public ClienteDao(String nome, String celular, String dataCadastro,
            String telefone, int codigo, int codigoUsuario)
            throws ClassNotFoundException, SQLException {
        super(nome, celular, dataCadastro, telefone, codigo, codigoUsuario);
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

    @Override
    public void incluir() throws SQLException, ClassNotFoundException, ParseException {

        String sql = "INSERT INTO T_Cliente (NomeCliente, FoneCliente, "
                + "CelCliente, DataCadastroCliente, CodUsuario)"
                + "VALUES(?,?,?,?,?)";

        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setString(1, getNome());
        comandoSQL.setString(2, getTelefone());
        comandoSQL.setString(3, getCelular());
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date) f.parse(getDataCadastro());
        comandoSQL.setDate(4, new java.sql.Date(date.getTime()));
        comandoSQL.setInt(5, getcodigoUsuario());

        comandoSQL.execute();
        comandoSQL.close();
        connection.close();
    }

    @Override
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

    @Override
    public boolean excluir() throws SQLException {

        String sql = "DELETE FROM T_Cliente WHERE CodCliente = ?";
        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setInt(1, getCodigo());
        boolean apagou = comandoSQL.execute();
        comandoSQL.close();
        connection.close();
        return apagou;

    }

    public ArrayList<ClienteBean> pesquisar() throws SQLException {
        ClienteBean clientesRetorno;
        ArrayList<ClienteBean> listaClientes = new ArrayList<ClienteBean>();
        String sql = "select * from t_cliente";

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
    
    public ArrayList<ClienteDao> pesquisar(ClienteDao cliente)
            throws SQLException, ClassNotFoundException{
        
        ClienteDao clientesRetorno = null;
        String sql = "SELECT * FROM pc_produto WHERE NomeCliente LIKE ?";
        
        ArrayList<ClienteDao> listaCliente = new ArrayList<ClienteDao>();
        
        connection = ConnectionFactory.getConnection();
        comandoSQL = connection.prepareStatement(sql);
        
        comandoSQL.setString(1, "%" + cliente.getNome() + "%");
        
        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()){
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            String date = f.format(rs.getDate("DataCadastroCliente"));
            clientesRetorno.setDataCadastro(date);
            clientesRetorno.setCodigo(rs.getInt("CodCliente"));
            clientesRetorno.setNome(rs.getString("NomeCliente"));
            clientesRetorno.setCelular(rs.getString("CelCliente"));
            clientesRetorno.setTelefone(rs.getString("FoneCliente"));
            clientesRetorno.setCodigoUsuario(rs.getInt("CodUsuario"));
            
            listaCliente.add(clientesRetorno);
        }
        
        rs.close();
        
        comandoSQL.close();
        connection.close();
        
        return listaCliente;
    }

    public ArrayList<ClienteBean> pesquisar(String[] auxQuery) throws SQLException, ParseException {
        ClienteBean clientesRetorno;
        ArrayList<ClienteBean> listaClientes = new ArrayList<ClienteBean>();
        String sql = "select * from t_cliente where " + auxQuery[0] + " "
                + auxQuery[1];
        for (int i = 0; i < auxQuery.length - 2; i++) {
            sql += " ?";
        }

        comandoSQL = connection.prepareStatement(sql);

        for (int i = 2; i < auxQuery.length; i++) {
            if (auxQuery[0].equals("DataCadastroClietne")) {
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date date = (java.sql.Date) f.parse(auxQuery[i]);
                comandoSQL.setDate(i - 1, date);
            } else {
                comandoSQL.setString(i - 1, auxQuery[i]);
            }
        }

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

    public DefaultComboBoxModel comboModel() throws SQLException, Exception {
        DefaultComboBoxModel returnModel = null;

        ArrayList<ClienteBean> listaClientes = new ArrayList<ClienteBean>();
        String sql = "select * from t_cliente";

        comandoSQL = connection.prepareStatement(sql);

        ResultSet rs = comandoSQL.executeQuery();

        while (rs.next()) {
            ClienteBean clientesRetorno = new ClienteBean();

            clientesRetorno.setCodigo(rs.getInt("CodCliente"));
            clientesRetorno.setNome(rs.getString("NomeCliente"));

            listaClientes.add(clientesRetorno);
        }

        rs.close();
        comandoSQL.close();
        connection.close();

        Object[] model = new Object[listaClientes.size()];
        for (int i = 0; i < listaClientes.size(); i++) {
            String item = "";
            int j = listaClientes.get(i).getCodigo();
            if (j < 10) {
                item = "00" + listaClientes.get(i).getCodigo() + " - "
                        + listaClientes.get(i).getNome();
            } else if (j > 9 && j < 100) {
                item = "0" + listaClientes.get(i).getCodigo() + " - "
                        + listaClientes.get(i).getNome();
            } else {
                item = listaClientes.get(i).getCodigo() + " - "
                        + listaClientes.get(i).getNome();
            }
            model[i] = item;
        }

        returnModel = new DefaultComboBoxModel(model);

        return returnModel;
    }
}
