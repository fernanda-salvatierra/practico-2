package Negocio;
public class Nodo {
    private int Cod;
    private String detalle;
    private Nodo refNodo;
    public Nodo(){
        this.Cod = -1;
        this.detalle = "";
        this.refNodo = null;
    }
    public Nodo(int Cod, String detalle) {
        this.Cod = Cod;
        this.detalle = detalle;
        this.refNodo = null;
    }
    public int getCod() {
        return Cod;
    }
    public void setCod(int Cod) {
        this.Cod = Cod;
    }
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public Nodo getRefNodo() {
        return refNodo;
    }
    public void setRefNodo(Nodo refNodo) {
        this.refNodo = refNodo;
    }
    public String getDato(){
        return this.Cod+", "+this.detalle;
    }
}