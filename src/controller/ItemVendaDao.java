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
import model.ConnectionFactory;
import model.ItemVendaBean;

/**
 *
 * @author Felipe
 */
public class ItemVendaDao extends ItemVendaBean {

    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Date data;

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO t_detvenda"
                + "(codVenda, codproduto, qtdProduto, precoproduto)"
                + " VALUES "
                + "(?,?,?,?)";
        // Usando c rhtodo estatico criado em. BancoSql
        this.conexao = ConnectionFactory.getConnection();
        //Aplicandc a instrttgac sql nc PrecaredStatement
        comandoSQL = conexao.prepareStatement(sql);
        //Preenchendc os pararetrcs
        comandoSQL.setInt(1, getNumVenda());
        comandoSQL.setInt(2, getCodPro());
        comandoSQL.setInt(3, getQuantidade());
        comandoSQL.setDouble(4, getPreco());
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {

        String sql = "UPDATE t_detvenda SET "
                + "codproduto = ?, "
                + "qtdProduto = ?, "
                + "precoProduto = ? "
                + "WHERE codVenda = ?";
        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getCodPro());
        comandoSQL.setInt(2, this.getQuantidade());
        comandoSQL.setDouble(3, this.getPreco());
        comandoSQL.setInt(4, this.getNumVenda());
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();

    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {

        String sql = "DELETE FROM t_detvenda WHERE CODVENDA = ?";

        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getNumVenda());
        boolean apagou = comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
        return apagou;
    }

    public ArrayList<ItemVendaDao> pesquisar(ItemVendaDao item) throws SQLException, ClassNotFoundException {
        ItemVendaDao itemRetorno = null;
        String sql = "";

        if (item.getCodPro() > 0) {
            sql = "SELECT codvenda, t_detvenda.codproduto, t_produto.descProduto, "
                    + "t_detvenda.qtdproduto, t_detvenda.preco, "
                    + "(t_detvenda.qtdProduto* t_detvenda.preco) AS Subtotal "
                    + "FROM t_detvenda INNER JOIN t_produto ON t_detVenda.cod"
                    + "produto = t_produto.codproduto "
                    + "Where t_detvenda.codVenda = ? and t_detvenda.codproduto - ?";
        } else {
            sql = "SELECT codvenda, t_detvenda.codproduto, t_produto.descProduto, "
                    + "t_detvenda.qtdproduto, t_detvenda.precoproduto, "
                    + "(t_detvenda.qtdProduto* t_detvenda.precoproduto) AS Subtotal "
                    + "FROM t_detvenda INNER JOIN t_produto ON t_detVenda.cod"
                    + "produto = t_produto.codproduto "
                    + "Where t_detvenda.codVenda = ?";
        }

        ArrayList<ItemVendaDao> listaltens = new ArrayList<ItemVendaDao>();

        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);

        if (item.getCodPro() > 0) {
            comandoSQL.setInt(1, item.getNumVenda());
            comandoSQL.setInt(2, item.getCodPro());
        } else {
            comandoSQL.setInt(1, item.getNumVenda());
        }
        ResultSet rs = comandoSQL.executeQuery();

        while (rs.next()) {
            itemRetorno = new ItemVendaDao();
            itemRetorno.setNumVenda(rs.getInt("codvenda"));
            itemRetorno.setCodPro(rs.getInt("codproduto"));
            itemRetorno.setDescricao(rs.getString("descproduto"));
            itemRetorno.setQuantidade(rs.getInt("qtdproduto"));
            itemRetorno.setPreco(rs.getDouble("precoproduto"));
            itemRetorno.setSubtotal(rs.getDouble("subtotal"));

            listaltens.add(itemRetorno);
        }

        rs.close();

        comandoSQL.close();
        this.conexao.close();

        return listaltens;
    }
}