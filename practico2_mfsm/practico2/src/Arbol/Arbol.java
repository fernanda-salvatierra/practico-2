package Arbol;
import Negocio.NodoArbol;

public class Arbol {
    private NodoArbol raiz;
    public Arbol(){
        this.raiz=null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    public void Insertar(int n){
        NodoArbol N= new NodoArbol(n);
        if(this.raiz==null){
            this.raiz=N;
        }else Insertar(this.raiz, N);
    }
    public void Insertar(NodoArbol X,NodoArbol N){
        if(N.getCod() > X.getCod()){
            if(X.gethD() == null){
                X.sethD(N);
            }else Insertar(X.gethD(),N);
        }else if(X.gethI() == null){
            X.sethI(N);
        }else Insertar(X.gethI(),N);
    }
    public void InOrden(){
        InOrden(this.raiz);
    }
    private void InOrden(NodoArbol X){
        if(X.gethI()!=null){
            InOrden(X.gethI());
        }
        System.out.println(X.getCod());
        if(X.gethD()!=null){
            InOrden(X.gethD());
        }
    }
    public boolean Eliminar(int n){
        if(this.raiz.getCod()== n){
            if(raiz.gethD()!=null && raiz.gethI()!=null){   //Ambos NO null
                NodoArbol aux = raiz.gethD(), v = raiz.gethI();
                while(v.gethD()!=null){ v=v.gethD(); }
                v.sethD(aux);
                raiz=raiz.gethI();
            }else if(raiz.gethD() == null){  raiz=raiz.gethI();
            }else if(raiz.gethI()==null){    raiz=raiz.gethD();
            }else raiz=null;
            return true;
        }
        if (n>raiz.getCod() && raiz.gethD()!= null){
            return Encontrar(raiz, raiz.gethD(), n);
        }else if(raiz.gethI()!= null){
            return Encontrar(raiz, raiz.gethI(), n);
        }else return false;
    }
    public boolean Encontrar(NodoArbol padre,NodoArbol X,int n){
        if(X.getCod()== n){
            boolean d = padre.gethD()==X?true:false;
            Eliminar(padre, X, n, d);
            return true;
        }
        padre=X;
        if (n>X.getCod() && X.gethD()!= null){
            return Encontrar(padre, X.gethD(), n);
        }else if(X.gethI()!= null){
            return Encontrar(padre, X.gethI(), n);
        }else return false;
    }
    public void Eliminar(NodoArbol padre, NodoArbol X, int n,boolean d){
        if(X.gethD()!=null && X.gethI()!=null){ //Hijos NO null
            
            NodoArbol aux = X.gethD();
            NodoArbol v=X.gethI();
            while(v.gethD()!=null){ v=v.gethD(); }
            v.sethD(aux);
            
            if(d){
                padre.sethD(X.gethI());
            }else padre.sethI(X.gethI()); 
            
        }else if(X.gethD()!=null){ //Izquierda no existe, Derecha sí
            if(d){
                padre.sethD(X.gethD());
            }else padre.sethI(X.gethD()); 
            
        }else if(X.gethI()!=null){  //Der no existe, Izq sí
            if(d){
                padre.sethD(X.gethI());
            }else padre.sethI(X.gethI()); 
            
        }else{                      //Ambos null
            if(d){ padre.sethD(null); }else padre.sethI(null); 
        }
    }
}
