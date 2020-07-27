package Cola;
import Negocio.Nodo;
public class Cola {
    private Nodo refPri, refUlt;
    public Cola(){
        this.refPri = null;
        this.refUlt = null;
    }
    public Nodo getRefPri() {
        return refPri;
    }
    public void setRefPri(Nodo refPri) {
        this.refPri = refPri;
    }
    public Nodo getRefUlt() {
        return refUlt;
    }
    public void setRefUlt(Nodo refUlt) {
        this.refUlt = refUlt;
    }
    public boolean estaVacia(){
        return this.refPri == null;
    }
    public void insertar(int x, String D){
        Nodo nAux = new Nodo(x, D);
        if(estaVacia()){
            this.refPri = nAux;
        }else this.refUlt.setRefNodo(nAux);
        this.refUlt = nAux;
    }
    public void sacar(){
        if(!estaVacia()){
            this.refPri = this.refPri.getRefNodo();
        }
    }
}