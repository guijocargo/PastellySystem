/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;

/**
 *
 * @author USER
 */
public interface ITeclasPadrao {
    
    /**
     * Este metodo faz o papel de um AcceptButton e CancelButton padrao do formu
     * lario.
     * 
     * @param evt Objeto para conferir tecla pressionada pelo usuario.
     */
    public void performAction(KeyEvent evt);
    
    /**
     * Metodo responsavel por fazer a navegacao por entre os objetos do formula
     * rio com o uso das teclas Ctrl e direcionais
     * 
     * @param evt Objeto para conferir as teclas pressionada pelo usuario simul
     * taneamente
     */
    public void performNavigateAction(KeyEvent evt);
    
}
