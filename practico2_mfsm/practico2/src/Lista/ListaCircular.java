package Lista;
import Negocio.NodoLD;
public class ListaCircular {
    private NodoLD pLC;
    public ListaCircular(){
        this.pLC =null;
    }
    public NodoLD getpLC() {
        return pLC;
    }
    public void setpLC(NodoLD pLC) {
        this.pLC = pLC;
    }
    public boolean estaVacia(){
        return this.pLC==null? true:false;
    }
    public void InsertarD(int x){
        NodoLD N= new NodoLD(x);
        if(estaVacia()){
            this.pLC=N;
            this.pLC.setRefD(this.pLC);
            this.pLC.setRefI(this.pLC);
        }else{
            this.pLC.getRefD().setRefI(N);
            N.setRefD(this.pLC.getRefD());
            this.pLC.setRefD(N);
            N.setRefI(this.pLC);
        }
    }
    public void InsertarI(int x){
        NodoLD N= new NodoLD(x);
        if(estaVacia()){
            this.pLC=N;
            this.pLC.setRefD(this.pLC);
            this.pLC.setRefI(this.pLC);
        }else{
            this.pLC.getRefI().setRefD(N);
            N.setRefI(this.pLC.getRefI());
            this.pLC.setRefI(N);
            N.setRefD(this.pLC);
        }
    }
    public void Eliminar(){
        if(!estaVacia()){
            if(this.pLC.getRefD()==this.pLC){
                this.pLC=null;
            }else{
                this.pLC=this.pLC.getRefI();
                this.pLC.setRefD(this.pLC.getRefD().getRefD());
                this.pLC.getRefD().setRefI(this.pLC);
            }
        }
    }
    public int Tamanio(){
        int t=0;
        if(this.pLC!=null){
            NodoLD X= this.pLC;
            do{
                t++;
                X=X.getRefD();
            }while(X!=this.pLC);
        }
        return t;
    }
}
