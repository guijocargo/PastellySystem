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
import model.ConnectionFactory;
import model.ProdutoBean;

/**
 *
 * @author Júlio
 */
public class ProdutoDao extends ProdutoBean {

    private Connection connection;
    private PreparedStatement comandoSQL;
    //private final String DATABASE = "fp0520111068"; //Tecnico
    private final String DATABASE = "matryuska"; //Guilherme

    public ProdutoDao() throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public ProdutoDao(String descricao, double preco)
            throws ClassNotFoundException, SQLException {
        super(descricao, preco);
        this.connection = ConnectionFactory.getConnection();
    }

    public ProdutoDao(ProdutoBean bean)
            throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
        this.setCodigo(bean.getCodigo());
        this.setDescricao(bean.getDescricao());
        this.setPreco(bean.getPreco());
    }

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO T_Produto (DescProduto, PrecoProduto)"
                + "VALUES(?,?)";
        
        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setString(1, getDescricao());
        comandoSQL.setDouble(2, getPreco());

        comandoSQL.execute();
        comandoSQL.close();
        connection.close();
        
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        
        String sql = "UPDATE T_Produto SET "
                + "DescProduto=?, "
                + "PrecoProduto=?"
                + "WHERE CodProduto=?";
        
        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setString(1, getDescricao());
        comandoSQL.setDouble(2, getPreco());
        comandoSQL.setInt(3, getCodigo());

        comandoSQL.execute();
        comandoSQL.close();
        connection.close();
        
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        
        String sql = "DELETE FROM T_Produto WHERE CodProduto=?";
        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setInt(1, getCodigo());
        boolean apagou = comandoSQL.execute();
        comandoSQL.close();
        connection.close();
        return apagou;
        
    }
    
    public ArrayList<ProdutoBean> pesquisar() throws SQLException {
        ProdutoBean produtosRetorno = null;
        ArrayList<ProdutoBean> listaProdutos = new ArrayList<ProdutoBean>();
        String sql = "select * from t_produto";

        comandoSQL = connection.prepareStatement(sql);

        ResultSet rs = comandoSQL.executeQuery();

        while (rs.next()) {
            produtosRetorno = new ProdutoBean();
            
            produtosRetorno.setCodigo(rs.getInt("CodProduto"));
            produtosRetorno.setDescricao(rs.getString("DescProduto"));
            produtosRetorno.setPreco(rs.getFloat("PrecoProduto"));

            listaProdutos.add(produtosRetorno);
        }

        rs.close();
        comandoSQL.close();
        connection.close();

        return listaProdutos;

    }
    
    public ArrayList<ProdutoDao> pesquisar(ProdutoDao produto)
            throws SQLException, ClassNotFoundException{
        
        ProdutoDao produtoRetorno = null;
        String sql = "SELECT * FROM pc_produto WHERE DESCRICAO LIKE ?";
        
        ArrayList<ProdutoDao> listaProduto = new ArrayList<ProdutoDao>();
        
        connection = ConnectionFactory.getConnection();
        comandoSQL = connection.prepareStatement(sql);
        
        comandoSQL.setString(1, "%" + produto.getDescricao() + "%");
        
        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()){
            produtoRetorno = new ProdutoDao();
            produtoRetorno.setCodigo(rs.getInt("CODPRO"));
            produtoRetorno.setDescricao(rs.getString("DESCRICAO"));
            produtoRetorno.setPreco(rs.getDouble("PRECOUNIT"));
            
            listaProduto.add(produtoRetorno);
        }
        
        rs.close();
        
        comandoSQL.close();
        connection.close();
        
        return listaProduto;
    }
}
