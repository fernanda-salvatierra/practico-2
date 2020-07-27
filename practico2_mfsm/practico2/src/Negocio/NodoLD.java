/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Pferd
 */
public class NodoLD {
    private int dato;
    private NodoLD refD, refI;
    public NodoLD(int dato){
        this.dato =dato;
        this.refD =null;
        this.refI =null;
    }
    public int getDato() {
        return dato;
    }
    public void setDato(int dato) {
        this.dato = dato;
    }
    public NodoLD getRefD() {
        return refD;
    }
    public void setRefD(NodoLD refD) {
        this.refD = refD;
    }
    public NodoLD getRefI() {
        return refI;
    }
    public void setRefI(NodoLD refI) {
        this.refI = refI;
    }
}
