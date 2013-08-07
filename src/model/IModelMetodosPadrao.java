/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author Guilherme
 */
public interface IModelMetodosPadrao {
    
    public void incluir() throws SQLException, ClassNotFoundException, ParseException;
    
    public void alterar() throws SQLException, ClassNotFoundException, ParseException;
    
    public boolean excluir() throws SQLException, ClassNotFoundException;
    
}
