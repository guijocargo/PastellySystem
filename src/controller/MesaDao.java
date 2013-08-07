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
import javax.swing.DefaultComboBoxModel;
import model.ConnectionFactory;
import model.MesaBean;

/**
 *
 * @author USER
 */
public class MesaDao extends MesaBean {
    private Connection connection;
    private PreparedStatement comandoSQL;
    //private final String DATABASE = "fp0520111068"; //Tecnico
    private final String DATABASE = "matryuska"; //Guilherme

    public MesaDao() throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public MesaDao(int codMesa, int lugaresMesa) throws ClassNotFoundException,
            SQLException {
        super(codMesa, lugaresMesa);
        this.connection = ConnectionFactory.getConnection();
    }
    
    public MesaDao(MesaBean bean) throws ClassNotFoundException, SQLException {
        this.connection = ConnectionFactory.getConnection();
        this.setCodMesa(bean.getCodMesa());
        this.setLugaresMesa(bean.getLugaresMesa());
    }
    
    public DefaultComboBoxModel comboModel() throws SQLException, Exception {
        DefaultComboBoxModel returnModel = null;
        
        ArrayList<MesaBean> listaMesas = new ArrayList<MesaBean>();
        String sql = "select * from t_mesa";
        
        comandoSQL = connection.prepareStatement(sql);
        
        ResultSet rs = comandoSQL.executeQuery();
        
        while (rs.next()) {
            MesaBean mesasRetorno = new MesaBean();
            
            mesasRetorno.setCodMesa(rs.getInt("CodMesa"));
            mesasRetorno.setLugaresMesa(rs.getInt("QtdeLugaresMesa"));
            
            listaMesas.add(mesasRetorno);
        }
        
        rs.close();
        comandoSQL.close();
        connection.close();
        
        Object[] model =  new Object[listaMesas.size()];
        for (int i = 0; i < listaMesas.size(); i++) {
            String item = "";
            int j = listaMesas.get(i).getCodMesa();
            if (j < 10) {
                item = "0" + listaMesas.get(i).getCodMesa() + " ("
                        + listaMesas.get(i).getLugaresMesa() +")";
            } else {
                item = listaMesas.get(i).getCodMesa() + " ("
                        + listaMesas.get(i).getLugaresMesa() + ")";
            }
            model[i] = item;
        }
        
        returnModel = new DefaultComboBoxModel(model);
        
        return returnModel;
    }
}
