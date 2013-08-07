/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author USER
 */
public class MesaBean {

    private int codMesa;
    private int lugaresMesa;

    public int getCodMesa() {
        return codMesa;
    }

    public void setCodMesa(int codMesa) {
        this.codMesa = codMesa;
    }

    public int getLugaresMesa() {
        return lugaresMesa;
    }

    public void setLugaresMesa(int lugaresMesa) {
        this.lugaresMesa = lugaresMesa;
    }

    public MesaBean() {
    }

    public MesaBean(int codMesa, int lugaresMesa) {
        this.codMesa = codMesa;
        this.lugaresMesa = lugaresMesa;
    }
}
