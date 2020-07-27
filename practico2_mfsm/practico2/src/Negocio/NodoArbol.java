package Negocio;
public class NodoArbol {
    private NodoArbol hD, hI;
    private int cod;
    public NodoArbol(int cod){
        this.cod=cod;
        hD=null;
        hI=null;
    }

    public NodoArbol gethD() {
        return hD;
    }

    public void sethD(NodoArbol hD) {
        this.hD = hD;
    }

    public NodoArbol gethI() {
        return hI;
    }

    public void sethI(NodoArbol hI) {
        this.hI = hI;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}