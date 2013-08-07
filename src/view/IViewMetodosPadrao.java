/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Guilherme
 */
public interface IViewMetodosPadrao {

    /**
     * Metodo responsavel por manter sincronizado a barra de navegacao, os 
     * campos e a tabela
     * 
     * @param index Parametro para recuperar objeto na posicao<i>index</i> e
     * guarda-lo em um ArrayList
     */
    public void setData(int index);

    /**
     * Metodo responsavel por controlar o estado dos botoes de navegacao entre
     * os objetos de um ArrayList
     * 
     * @param b <b>true</b> para habilitar os botoes de volta e <b>false</b>
     * para habilitar os botoes de avanco
     */
    public void setEnabledNavigator(boolean b);

    /**
     * Metodo responsavel por controlar o estado dos botoes de operacao
     * 
     * @param b <b>true</b> para inciar operacao e <b>false</b> para finalizar
     * operacao
     */
    public void setEnabledToolBar(boolean b);

    /**
     * Metodo para permitir ou nao o uso dos campos de informacao do cliente
     * pelo usuario
     * 
     * @param b <b>true</b> para habilitar todos os campos (exceto o campo de 
     * codigo) e <b>false</b> para desabilitar todos os campos (exceto o campo
     * de codigo)
     */
    public void habilitaCampos(boolean b);

    /**
     * Metodo para <u>zerar</u> todos os campos e setar um valor para o campo de
     * codigo com o tamanho de um ArrayList
     * 
     * @param b 
     */
    public void limpaCampos();

    /**
     * Metodo para atualizar a tabela
     */
    public void atualizaTable();

    /**
     * Metodo para atualizar a barra de navegacao
     * @param novo 
     */
    public void atualizaToolbar(boolean novo);

    /**
     * Este metodo apenas inicializa os dados no Formulário
     */
    public void begin();
    
}
