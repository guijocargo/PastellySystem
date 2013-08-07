package model;

import java.sql.SQLException;
import java.util.Date;

public class VendaBean implements IModelMetodosPadrao {

    private int numVenda;
    private int codCli;
    private Date dataVenda;
    public String nomeCliente;
    public String obs;

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getNumVenda() {
        return numVenda;
    }

    public void setNumVenda(int numVenda) {
        this.numVenda = numVenda;
    }

    public VendaBean() {
    }

    public VendaBean(int numVenda, int codCli, Date dataVenda, String nomeCliente) {
        this.numVenda = numVenda;
        this.codCli = codCli;
        this.dataVenda = dataVenda;
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "Venda:"
                + "\n Número da Venda: " + getNumVenda()
                + "\n Código do Cliente: " + getCodCli()
                + "\n Data da Venda: " + getDataVenda();
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