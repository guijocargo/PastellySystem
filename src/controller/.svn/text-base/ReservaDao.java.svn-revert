/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.ConnectionFactory;
import model.ReservaBean;

/**
 *
 * @author Felipe
 */
public class ReservaDao extends ReservaBean {

    private Connection conexao;
    private PreparedStatement comandoSQL;
    private Date data;
    private Time time;

    public ReservaDao() throws ClassNotFoundException, SQLException {
        this.conexao = ConnectionFactory.getConnection();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO T_Teste(CODIGO, DIA)"
                + "VALUES(1,?)";
        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = new Date(getDtReserva().getTime());
        comandoSQL.setString(2, sdf.format(data));

        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    public void incluir() throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO T_Reserva ("
                + "DataReserva,CodUsuario,HoraInicio,HoraFim,CodCliente,CodDetReserva"
                + "VALUES(?,?,?,?,?,?)";

        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = new Date(getDtReserva().getTime());
        comandoSQL.setString(1, sdf.format(data));

        comandoSQL.setInt(2, getCodUsuario());

        SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm");
        time = new Time(getHoraInicio().getTime());
        comandoSQL.setString(3, sdf1.format(time));

        time = new Time(getHoraFim().getTime());
        comandoSQL.setString(4, sdf1.format(time));

        comandoSQL.setInt(5, getCodCli());

        comandoSQL.setInt(6, getCodDetReserva());

        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    public void altera() throws SQLException, ClassNotFoundException {
        String sql = "set dateformat dmy "
                + "UPDATE T_Reserva SET "
                + "DataReserva=?, "
                + "CodUsuario=?, "
                + "HoraInicio=?, "
                + "HoraFim=?, "
                + "CodCliente=?, "
                + "CodDetReserva=? "
                + " WHERE CodReserva = ?";

        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = new Date(getDtReserva().getTime());
        comandoSQL.setString(1, sdf.format(data));

        comandoSQL.setInt(2, getCodUsuario());

        SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm");
        time = new Time(getHoraInicio().getTime());
        comandoSQL.setString(3, sdf1.format(time));

        time = new Time(getHoraFim().getTime());
        comandoSQL.setString(4, sdf1.format(time));

        comandoSQL.setInt(5, getCodCli());

        comandoSQL.setInt(6, getCodDetReserva());

        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }

    public boolean excluir() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM T_Reserva "
                + "WHERE CodReserva = ?";
        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, this.getCodReserva());
        boolean apagou = comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
        return apagou;
    }

    public ArrayList<ReservaDao> pesquisar(ReservaDao reserva) throws SQLException, ClassNotFoundException {
        ReservaDao reservaRetorno = null;
        String sql = "SELECT * T_Reserva WHERE NOME LIKE ?";

        ArrayList<ReservaDao> listaReserva = new ArrayList<ReservaDao>();

        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);

        comandoSQL.setInt(1, reserva.getCodCli());

        ResultSet rs = comandoSQL.executeQuery();

        while (rs.next()) {
            reservaRetorno = new ReservaDao();
            //reservaRetorno = setDtReserva(rs.getDate("DTRESERVA"));
            //reservaRetorno = setCodReserva(rs.getInt("CODRESERVA"));



            listaReserva.add(reservaRetorno);
        }

        //return reservaRetorno;
        return null;
    }
}
