/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.ConnectionFactory;
import model.ReservaBean;

/**
 *
 * @author Felipe
 */
public class ReservaDao extends ReservaBean {

    private Connection connection;
    private PreparedStatement comandoSQL;
    //private final String DATABASE = "fp0520111068"; //Tecnico
    private final String DATABASE = "matryuska"; //Guilherme

    public ReservaDao() throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public ReservaDao(int CodReserva, int CodCli, int CodUsuario, String DtReserva, 
            String HoraInicio, String HoraFim, int CodDetReserva) 
            throws ClassNotFoundException, SQLException {        
        super(CodReserva, CodCli, CodUsuario, DtReserva, HoraInicio, HoraFim);
        this.connection = ConnectionFactory.getConnection();
    }
    
    public ReservaDao(ReservaBean bean) throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
        this.setCodCli(bean.getCodCli());
        this.setCodReserva(bean.getCodReserva());
        this.setCodUsuario(bean.getCodUsuario());
        this.setDtReserva(bean.getDtReserva());
        this.setHoraFim(bean.getHoraFim());
        this.setHoraInicio(bean.getHoraInicio());
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO T_Teste(CODIGO, DIA)"
                + "VALUES(1,?)";
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Date date = new Date(getDtReserva().getTime());
        
        comandoSQL = connection.prepareStatement(sql);
        //comandoSQL.setString(2, sdf.format(date));

        comandoSQL.execute();
        comandoSQL.close();
        connection.close();
    }

    public void incluir() throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO T_Reserva (codReserva, DataReserva, CodUsuario,"
                + "HoraInicio, HoraFim, CodCliente)"
                + "VALUES(?,?,?,?,?,?)";
        
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = new Date(getDtReserva().getTime());
        
        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setInt(1, getCodReserva());
        comandoSQL.setString(2, getDtReserva());
        comandoSQL.setInt(3, getCodUsuario());
        comandoSQL.setString(4, getHoraInicio());
        comandoSQL.setString(5, getHoraFim());
        comandoSQL.setInt(6, getCodCli());

        comandoSQL.execute();
        comandoSQL.close();
        connection.close();
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
                + "WHERE CodReserva=?";

//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = new Date(getDtReserva().getTime());
        
        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setString(1, getDtReserva());
        comandoSQL.setInt(2, getCodUsuario());
        comandoSQL.setString(3, getHoraInicio());
        comandoSQL.setString(4, getHoraFim());
        comandoSQL.setInt(5, getCodCli());

        comandoSQL.execute();
        comandoSQL.close();
        connection.close();
    }

    public boolean excluir() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM T_Reserva WHERE CodReserva=?";
        
        comandoSQL = connection.prepareStatement(sql);
        comandoSQL.setInt(1, this.getCodReserva());
        boolean apagou = comandoSQL.execute();
        comandoSQL.close();
        connection.close();
        return apagou;
    }
    
    // TODO Arrumar metodo!
//    public ArrayList<ReservaBean> pesquisar() throws SQLException, ClassNotFoundException{
//        ReservaBean reservaRetorno;
//        String sql = "SELECT * T_Reserva WHERE NOME LIKE ?";   
//        ArrayList<ReservaBean> listaReserva = new ArrayList<ReservaBean>();
//        
//        comandoSQL = connection.prepareStatement(sql);
//        
//        
//        ResultSet rs = comandoSQL.executeQuery();
//        
//        while(rs.next()){
//            reservaRetorno = new ReservaBean();
//            //reservaRetorno = setDtReserva(rs.getDate("DtReserva"));
//            //reservaRetorno = setCodReserva(rs.getInt("CODRESERVA"));
//            listaReserva.add(reservaRetorno);
//        }
//        
//        //return reservaRetorno;
//        return null;
//    }
//
//    // TODO Arrumar metodo!
//    public ArrayList<ReservaDao> pesquisar(ReservaDao reserva) throws SQLException, ClassNotFoundException {
//        ReservaDao reservaRetorno;
//        String sql = "SELECT * T_Reserva WHERE NOME LIKE ?";
//
//        ArrayList<ReservaDao> listaReserva = new ArrayList<ReservaDao>();
//
//        comandoSQL = connection.prepareStatement(sql);
//
//        comandoSQL.setInt(1, reserva.getCodCli());
//
//        ResultSet rs = comandoSQL.executeQuery();
//
//        while (rs.next()) {
//            reservaRetorno = new ReservaDao();
//            //reservaRetorno = setDtReserva(rs.getDate("DTRESERVA"));
//            //reservaRetorno = setCodReserva(rs.getInt("CODRESERVA"));
//            listaReserva.add(reservaRetorno);
//        }
//
//        //return reservaRetorno;
//        return null;
//    }
    
        public ArrayList<ReservaBean> pesquisar() throws SQLException/*, Exception*/ {
        ReservaBean reservaRetorno;
        ArrayList<ReservaBean> listaReserva = new ArrayList<ReservaBean>();
        String sql = "select * from t_reserva";
//        String sql = "select t_reserva.codreserva, t_reserva.datareserva, t_reserva.codusuario,"
//        +"t_reserva.horainicio, t_reserva.horafim, t_cliente.nomecliente from t_reserva, t_cliente"
//        +"where t_reserva.codcliente = t_cliente.codcliente";
        
        comandoSQL = connection.prepareStatement(sql);
        
        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()) {
            reservaRetorno = new ReservaBean();
            
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            String date = f.format(rs.getDate("DataReserva"));
            
            reservaRetorno.setCodReserva(rs.getInt("CodReserva"));
            reservaRetorno.setDtReserva(rs.getString("DataReserva"));
            reservaRetorno.setCodUsuario(rs.getInt(1));
            reservaRetorno.setHoraInicio(rs.getString("HoraInicio"));
            reservaRetorno.setHoraFim(rs.getString("HoraFim"));
            reservaRetorno.setCodCli(rs.getInt("CodCliente"));
            
            
            listaReserva.add(reservaRetorno);
        }
        
        rs.close();
        comandoSQL.close();
        connection.close();
        
        return listaReserva;
        
    }
    
        public ArrayList<ReservaBean> ultimoRegistro() throws SQLException, ClassNotFoundException{
        ReservaBean codigoRetorno = null;
        ArrayList<ReservaBean> ultimoCodigo = new ArrayList<ReservaBean>();
        //String ultimoCodigo;
        //String sql = "select max(codvenda) from T_Reserva";
        String sql = "SELECT codreserva FROM t_reserva ORDER BY codreserva DESC LIMIT 1";
        
        comandoSQL = connection.prepareStatement(sql);
        ResultSet rs = comandoSQL.executeQuery();
        
        while(rs.next()){
                codigoRetorno = new ReservaBean();
                codigoRetorno.setCodReserva(rs.getInt("codreserva"));
                ultimoCodigo.add(codigoRetorno);
        }
        
        rs.close();
        comandoSQL.close();
        connection.close();
        
        return ultimoCodigo;
    }
        
        public ArrayList<ReservaDao> pesquisarPorData(ReservaDao reserva) throws SQLException, ClassNotFoundException{
        
        ReservaDao reservaRetorno = null;
        String sql = "SELECT * FROM t_reserva WHERE datareserva = ?";
        
        ArrayList<ReservaDao> listaReservas = new ArrayList<ReservaDao>();
        
        this.connection = ConnectionFactory.getConnection();
        comandoSQL = connection.prepareStatement(sql);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        String data = sdfData.format(reserva.getDtReserva().toString());
        comandoSQL.setString(1, reserva.getDtReserva());
        
        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()){
            reservaRetorno = new ReservaDao();
            reservaRetorno.setCodCli(rs.getInt("codcliente"));
            reservaRetorno.setCodReserva(rs.getInt("codreserva"));
            reservaRetorno.setCodUsuario(rs.getInt(1)); // REVER AKI  <----
            reservaRetorno.setDtReserva(rs.getString("datareserva"));
            reservaRetorno.setHoraInicio(rs.getString("horainicio"));
            reservaRetorno.setHoraFim(rs.getString("horafim"));
            
            listaReservas.add(reservaRetorno);
        }
        
        rs.close();
        
        comandoSQL.close();
        this.connection.close();
        
        return listaReservas;
    }
        
        public ArrayList<ReservaDao> pesquisarPorCliente(ReservaDao reserva) throws SQLException, ClassNotFoundException{
        
        ReservaDao reservaRetorno = null;
        String sql = "SELECT * FROM t_reserva WHERE codcliente = ?";
        
        ArrayList<ReservaDao> listaReservas = new ArrayList<ReservaDao>();
        
        this.connection = ConnectionFactory.getConnection();
        comandoSQL = connection.prepareStatement(sql);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        String data = sdfData.format(reserva.getDtReserva().toString());
        comandoSQL.setInt(1, reserva.getCodCli());
        
        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()){
            reservaRetorno = new ReservaDao();
            reservaRetorno.setCodCli(rs.getInt("codcliente"));
            reservaRetorno.setCodReserva(rs.getInt("codreserva"));
            reservaRetorno.setCodUsuario(rs.getInt(1)); // REVER AKI  <----
            reservaRetorno.setDtReserva(rs.getString("datareserva"));
            reservaRetorno.setHoraInicio(rs.getString("horainicio"));
            reservaRetorno.setHoraFim(rs.getString("horafim"));
            
            listaReservas.add(reservaRetorno);
        }
        
        rs.close();
        
        comandoSQL.close();
        this.connection.close();
        
        return listaReservas;
    }
}
