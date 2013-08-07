package model;

import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Guilherme
 */
public class ClienteBean implements IModelMetodosPadrao {

    private String nome;
    private String celular;
    private String dataCadastro;
    private String telefone;
    private int codigo;
    private int codigoUsuario;

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getcodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ClienteBean() {
    }

    public ClienteBean(String nome, String celular, String dataCadastro, String telefone, int codigo, int codigoUsuario) {
        this.nome = nome;
        this.celular = celular;
        this.dataCadastro = dataCadastro;
        this.telefone = telefone;
        this.codigo = codigo;
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public String toString() {
        return "Cliente:"
                + "\n   Codigo: " + ((codigo !=0) ? (codigo) : ("'"))
                + "\n   Nome: " + nome
                + "\n   Data de Cadastro: " + dataCadastro
                + "\n   Telefone: " + telefone
                + "\n   Celular: " + celular;
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
