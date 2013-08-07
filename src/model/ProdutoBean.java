package model;

import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Julio
 */
public class ProdutoBean implements IModelMetodosPadrao {

    private int codigo;
    private String descricao;
    private double preco;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public ProdutoBean() {
    }

    public ProdutoBean(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto:"
                + "\n   Codigo: " + ((codigo !=0) ? (codigo) : ("'"))
                + "\n   Descricao: " + descricao 
                + "\n   Preco: " + preco;
    }

    @Override
    public void incluir() throws SQLException, ClassNotFoundException, ParseException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException, ParseException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
