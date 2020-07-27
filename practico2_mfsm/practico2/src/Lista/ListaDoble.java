package Lista;
import Negocio.NodoLD;
public class ListaDoble {
    private NodoLD pLD;
    public ListaDoble(){
        this.pLD = null;
    }
    public NodoLD getpLD() {
        return pLD;
    }
    public void setpLD(NodoLD pLD) {
        this.pLD = pLD;
    }
    public boolean estaVacia(){
        return this.pLD==null? true:false;
    }
    public void InsertIzq(int dato){
        NodoLD N= new NodoLD(dato);
        if(this.pLD==null){
            this.pLD =N;
        }else if(this.pLD.getRefI() == null){
            N.setRefD(this.pLD);
            this.pLD.setRefI(N);
        }else {
            (this.pLD.getRefI()).setRefD(N);
            N.setRefI(this.pLD.getRefI());
            N.setRefD(this.pLD);
            this.pLD.setRefI(N);
        }
    }
    public void InsertDer(int dato){
        NodoLD N= new NodoLD(dato);
        if(this.pLD==null){
            this.pLD =N;
        }else if(this.pLD.getRefD() == null){
            N.setRefI(this.pLD);
            this.pLD.setRefD(N);
        }else {
            N.setRefD(this.pLD.getRefD());
            this.pLD.getRefD().setRefI(N);
            this.pLD.setRefD(N);
            N.setRefI(this.pLD);
        }
    }
    public boolean moverDer(){
        if(!estaVacia()){
            if(this.pLD.getRefD()!=null){
                this.pLD=this.pLD.getRefD();
                return true;
            }
        }
        return false;
    }
    public boolean moverIzq(){
        if(!estaVacia()){
            if(this.pLD.getRefI()!=null){
                this.pLD=this.pLD.getRefI();
                return true;
            }
        }
        return false;
    }
    public void irPri(){
        while(moverIzq()){}
    }
    public void irUlt(){
        while(moverDer()){}
    }
    public void Eliminar(){
        if(!estaVacia()){
            if(!moverIzq()){
                if(moverDer()){
                    this.pLD.setRefI(null);
                }else this.pLD = null;
            }else{
                this.pLD.setRefD(this.pLD.getRefD().getRefD());
            }
        }
    }
    public void I(NodoLD X){
        while(X.getRefI()!=null){
            X=X.getRefI();
        }
    }
    public void D(NodoLD X){
        while(X.getRefD()!=null){
            X=X.getRefD();
        }
    }
    public void InsertarOrd(int i){
        NodoLD N = new NodoLD(i);
        if(estaVacia()){
            this.pLD=N;
        }else{
            NodoLD X = this.pLD;
            if(N.getDato()>X.getDato()){
                while(X.getRefD()!=null && N.getDato()>X.getRefD().getDato()){
                    X=X.getRefD();
                }
                if(X.getRefD()!=null){
                    N.setRefD(X.getRefD());
                    X.getRefD().setRefI(N);
                }
                X.setRefD(N);
                N.setRefI(X);
            }else if(N.getDato()<X.getDato()){
                while(X.getRefI()!=null && N.getDato()<X.getRefI().getDato()){
                    X=X.getRefI();
                }
                if(X.getRefI()!=null){
                    N.setRefI(X.getRefI());
                    X.getRefI().setRefD(N);
                }
                X.setRefI(N);
                N.setRefD(X);
            }else {
                if(this.pLD.getRefD()!=null){
                    N.setRefD(this.pLD.getRefD());
                    this.pLD.getRefD().setRefI(N);
                }
                this.pLD.setRefD(N);
                N.setRefI(this.pLD);
            }
        }
    }
    public int Tamanio(){
        int t=0;
        if(!estaVacia()){
            t=1;
            NodoLD X = this.pLD;
            while(X.getRefI()!=null){
                X=X.getRefI();
            }
            while(X.getRefD()!=null){
                t++;
                X=X.getRefD();
            }
        }
        return t;
    }
}