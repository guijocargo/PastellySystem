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
import model.DetReservaBean;
import model.ReservaBean;

/**
 *
 * @author fp0520111062
 */
public class DetReservaDao extends DetReservaBean{
    
    private Connection conexao;
    private PreparedStatement comandoSQL;
    
    public void incluir() throws SQLException, ClassNotFoundException {
        
        String sql = "INSERT INTO T_DetReserva ("
                + "CodMesa,CodReserva)"
                + "VALUES(?,?)";
        
        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        
        comandoSQL.setInt(1, getCodMesa());
        comandoSQL.setInt(2, getCodReserva());
        
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }
    
    public void altera() throws SQLException, ClassNotFoundException {
        
        String sql = "UPDATE T_DetReserva SET "
                + "CodMesa=?, "
                + "CodReserva=?, "
                + " WHERE CodReserva = ?";
        
        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        
        comandoSQL.setInt(1, getCodMesa());
        comandoSQL.setInt(2, getCodReserva());
        
        comandoSQL.execute();
        comandoSQL.close();
        this.conexao.close();
    }
    
        public boolean excluir() throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM T_DetReserva "
                + "WHERE CodReserva = ?";
        
        try {
            this.conexao = ConnectionFactory.getConnection();
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, this.getCodReserva());
            boolean apagou = comandoSQL.execute();
            comandoSQL.close();
            this.conexao.close();
            return apagou;
        } catch (SQLException e) {
            throw e;
        }
        catch(ClassNotFoundException e){
            throw e;
        }
    }
        
      public ArrayList<ReservaBean> pesquisar() throws SQLException, ClassNotFoundException{
        ReservaBean reservaRetorno = null;
        String sql = "SELECT * T_DetReserva WHERE NOME LIKE ?";   
        ArrayList<ReservaBean> listaReserva = new ArrayList<ReservaBean>();
        
        this.conexao = ConnectionFactory.getConnection();
        comandoSQL = conexao.prepareStatement(sql);
        
        
        ResultSet rs = comandoSQL.executeQuery();
        
        while(rs.next()){
            reservaRetorno = new ReservaBean();
            //reservaRetorno = setDtReserva(rs.getDate("DTRESERVA"));
            //reservaRetorno = setCodReserva(rs.getInt("CODRESERVA"));
            
            
            
            listaReserva.add(reservaRetorno);
        }
        
        //return reservaRetorno;
        return null;
    }
}
