package Pilas;
import Negocio.Nodo;
public class Pila {
    private Nodo cima;
    public Pila() {
        this.cima = null;
    }
    public void insertar(int cod, String detalle){
        Nodo n = new Nodo(cod,detalle);
        if(this.cima != null){
            n.setRefNodo(this.cima);
        }
        this.cima = n;
    }
    public void Eliminar(){
        if(!estaVacia()){
            this.cima = this.cima.getRefNodo();
        }
    }
    public String sacarDatos(){
        String ss = "Cod: "+this.cima.getCod()+", Detalle: "+this.cima.getDetalle();
        if(!estaVacia()){
            this.cima = this.cima.getRefNodo();
        }
        return ss;
    }
    public boolean estaVacia(){
        if(this.cima == null){
            return true;
        }else{
            return false;
        }
    }
    
    public Nodo getCima(){
        return this.cima;
    }
}
