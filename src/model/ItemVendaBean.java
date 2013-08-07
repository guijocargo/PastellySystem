package model;

import java.sql.SQLException;

public class ItemVendaBean implements IModelMetodosPadrao {

    private int numVenda;
    private int codPro;
    private String descricao;
    private int quantidade;
    private double preco;
    private double subtotal;

    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumVenda() {
        return numVenda;
    }

    public void setNumVenda(int numVenda) {
        this.numVenda = numVenda;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public ItemVendaBean() {
    }

    public ItemVendaBean(int numVenda, int codPro, String descricao, int quantidade,
            double preco, double subtotal) {
        this.numVenda = numVenda;
        this.codPro = codPro;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.subtotal = subtotal;
    }

    //@Override
    public String tostString() {
        return " \nItem:"
                + "\nNúmero da Venda: " + getNumVenda()
                + "\nCódigo do Produto: " + getCodPro()
                + "\nDescrição: " + getDescricao()
                + "\nOuantidade: " + getQuantidade()
                + "\nPreço Unitario: " + getPreco()
                + "\n Subtotal: " + getSubtotal() + "\n";
    }

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supportes yet.");
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supportes yet.");
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}