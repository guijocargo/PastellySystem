/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.crypto.Data;
import model.ConnectionFactory;
import model.VendaBean;

/**
 *
 * @author Felipe
 */
public class VendaDao extends VendaBean {

    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Data data;

    public VendaDao() throws ClassNotFoundException, SQLException {
        this.conexao = ConnectionFactory.getConnection();
    }

    public VendaDao(int numVenda, int codCli, Date dataVenda, String nomeCliente)
            throws ClassNotFoundException, SQLException {
        super(numVenda, codCli, dataVenda, nomeCliente);
        this.conexao = ConnectionFactory.getConnection();
    }
    
    public VendaDao(VendaBean bean) throws ClassNotFoundException, SQLException {
        this.conexao = ConnectionFactory.getConnection();
        this.setCodCli(bean.getCodCli());
        this.setDataVenda(bean.getDataVenda());
        this.setNumVenda(bean.getNumVenda());
    }

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO T_Venda (CodVenda, CodCliente, DataVenda) "
                + "VALUES (?,?,?)";
        
        this.conexao = ConnectionFactory.getConnection();

        comandoSQL = conexao.prepareStatement(sql);

        comandoSQL.setInt(1, this.getNumVenda());
        comandoSQL.setInt(2, this.getCodCli());
        comandoSQL.setDate(3, new java.sql.Date(this.getDataVenda().getTime()));

        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {

        String sql = "UPDATE T_Venda SET"
                + "CodCliente = ?, "
                + "DataVenda = ?, "
                + "WHERE CodVenda = ?";

        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getCodCli());
        comandoSQL.setDate(2, new java.sql.Date(this.getDataVenda().getTime()));
        comandoSQL.setInt(3, this.getNumVenda());

        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM T_Venda "
                + "WHERE NUMVENDA = ?";

        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getNumVenda());
        boolean apagou = comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
        return apagou;
    }
    
    public ArrayList<VendaDao> pesquisar(VendaDao venda) throws SQLException, ClassNotFoundException{
        VendaDao vendaRetorno = null;
        String sql = "";
        
        if(venda.getNumVenda() > 0){
            sql = "SELECT codVenda, t_venda.codcliente, t_cliente.nomeCliente, "
                    + "dataVenda, FROM t_venda INNER JOIN t_cliente "
                    + "ON t_venda.codcliente = t_cliente.codcliente "
                    + "where codVenda = ?";
        } else{
            sql = "SELECT codVenda, t_venda.codcliente, t_cliente.nomeCliente, "
                    + "dataVenda, FROM t_venda INNER JOIN t_cliente "
                    + "ON t_venda.codcliente = t_cliente.codcliente";
        }
        
        ArrayList<VendaDao> listaVendas = new ArrayList<VendaDao>();
        
        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        
        if(venda.getNumVenda() > 0){
            comandoSQL.setInt(1, venda.getNumVenda());
        }
        ResultSet rs = comandoSQL.executeQuery();
        
        while(rs.next()){
            vendaRetorno = new VendaDao();
            vendaRetorno.setNumVenda(rs.getInt("codvenda"));
            vendaRetorno.setCodCli(rs.getInt("codcliente"));
            vendaRetorno.setNomeCliente(rs.getString("nomecliente"));
            vendaRetorno.setDataVenda(rs.getDate("datavenda"));
            
            listaVendas.add(vendaRetorno);
        }
        
        rs.close();
        
        comandoSQL.close();
        this.conexao.close();
        
        return listaVendas;
    }
}
