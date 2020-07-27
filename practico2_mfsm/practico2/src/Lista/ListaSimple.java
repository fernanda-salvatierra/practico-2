package Lista;
import Negocio.Nodo;
import java.util.Iterator;

public class ListaSimple {
    private Nodo refPri;
    public ListaSimple(){
        this.refPri=null;
    }
    public Nodo getRefPri() {
        return refPri;
    }
    public void setRefPri(Nodo refPri) {
        this.refPri = refPri;
    }
    public boolean estaVacia(){
        return this.refPri==null;
    }
    /*public void insertarOrd(int dato, String detalle){
        Nodo n = new Nodo(dato, detalle);
        if(estaVacia()){
            this.refPri = n;
        }else {
            Nodo X = this.refPri;
            if(n.getCod()< this.refPri.getCod()){
                n.setRefNodo(refPri);
                this.refPri=n;
            }else 
                do{
                    if(X.getRefNodo()==null){ //Último nodo
                        X.setRefNodo(n);
                    }else if(n.getCod() < X.getRefNodo().getCod()){ //Comparar si n es menor a ref de X
                        n.setRefNodo(X.getRefNodo());
                        X.setRefNodo(n);
                        break;
                    }
                    X = X.getRefNodo();
                }while(X != null);
                //}while(X.getRefNodo() != null);
        }
    }*/
    public void insertarOrdenado(int cod, String detalle){
        Nodo nn = new Nodo(cod, detalle);
        if(estaVacia()){
            this.refPri = nn;
        }else if(cod < this.refPri.getCod()){
             nn.setRefNodo(this.refPri);
             this.refPri = nn;
        }else{
            Nodo p = refPri;
            boolean sw = false;
            while(p.getRefNodo() != null){
                if(nn.getCod() < p.getRefNodo().getCod()){
                    sw = true;
                    nn.setRefNodo(p.getRefNodo());
                    p.setRefNodo(nn);
                    break;
                }else p = p.getRefNodo();
            }
            if(sw == false){
                p.setRefNodo(nn);
            }
        }
    }
    public void EliminarSegunCod(int b){
        if(!estaVacia()){
            Nodo X=this.refPri;
            if(b<=this.refPri.getCod()){
                if(b==this.refPri.getCod()){
                    this.refPri=this.refPri.getRefNodo();
                    while(X.getRefNodo()!=null && b==X.getRefNodo().getCod()){
                        X.setRefNodo(X.getRefNodo().getRefNodo());
                    }
                }
            }else while(X.getRefNodo()!=null && b>=X.getRefNodo().getCod()){
                if(b==X.getRefNodo().getCod()){
                    X.setRefNodo(X.getRefNodo().getRefNodo());
                }else X=X.getRefNodo();
            }
        }
    }
    public void EliminarNodo2(int b){
        if(estaVacia()){
            //System.out.println("No existen nodos en la lista para borrar");
        }else{
            Nodo X=this.refPri;
            if(b<=this.refPri.getCod()){
                if(b==this.refPri.getCod()){
                    do{
                        this.refPri=this.refPri.getRefNodo();
                    }while(b==this.refPri.getCod());
                    //System.out.println("Todos los nodo con código "+refPri.getCod()+" han sido eliminados");
                }//else System.out.println("No existe un nodo con código "+b);
            }else {
                boolean F=true;
                while(F && X.getRefNodo()!=null){
                    if(b<=X.getRefNodo().getCod()){
                        if(b==X.getRefNodo().getCod()){
                            //System.out.println("Se encontraron nodo(s) con código "+X.getRefNodo().getCod());
                            int i=0;
                            while(b==X.getRefNodo().getCod()){
                                X.setRefNodo(X.getRefNodo().getRefNodo());
                                i++;
                                if(X.getRefNodo()==null){break;}
                            }
                            //System.out.println("Se borraron "+i+" nodo(s)");
                        }//else System.out.println("No existe un nodo con código "+b);
                        F=false;
                    }else X=X.getRefNodo();
                }
                //if(F){ System.out.println("El código "+b+" sobrepasa al código de mayor valor en la lista");}
            }
        }
    }
    public void EliminarNodo3(int o){
        if(estaVacia()){
            System.out.println("No existen nodos en la lista para borrar");
        }else{
            if(o==1){
                System.out.println("Se encontró un nodo con código "+this.refPri.getCod());
                this.refPri=this.refPri.getRefNodo();
                System.out.println("Se borró el nodo");
            }else{
                Nodo X=this.refPri;
                while(X.getRefNodo().getRefNodo()!= null && o>2){
                    X = X.getRefNodo();
                    o--;
                }
                if(o==2 && X.getRefNodo()!=null){
                    System.out.println("Se encontró un nodo con código "+X.getRefNodo());
                    X.setRefNodo(X.getRefNodo().getRefNodo());
                    System.out.println("Se borró el nodo");
                }else System.out.println("No existe un nodo en esa posición");
            }
        }
    }
    public void EliminarNodo1a(int b){
        if(!estaVacia()){
            if(b<=this.refPri.getCod()){
                if(b==this.refPri.getCod()){
                    this.refPri=this.refPri.getRefNodo();
                }
            }else{
                Nodo X=this.refPri;
                while(X.getRefNodo()!=null){
                    if(b<=X.getRefNodo().getCod()){
                        if(b==X.getRefNodo().getCod()){
                            X.setRefNodo(X.getRefNodo().getRefNodo());
                        }
                    }else X=X.getRefNodo();
                }
            }
        }
    }
    public void EliminarNodo2a(int b){
        if(!estaVacia()){
            if(b<=this.refPri.getCod()){
                while(b==this.refPri.getCod()){
                    this.refPri=this.refPri.getRefNodo();
                }
            }else{
                Nodo X=this.refPri;
                boolean F=true;
                while(X.getRefNodo()!=null && F){
                    if(b<=X.getRefNodo().getCod() && F){
                            while(b==X.getRefNodo().getCod()){
                                X.setRefNodo(X.getRefNodo().getRefNodo());
                                if(X.getRefNodo()==null){break;}
                            }
                        F = false;
                    }else X=X.getRefNodo();
                }
            }
        }
    }
    public void EliminarNodo3a(int o){
        if(!estaVacia()){
            if(o==1){
                this.refPri=this.refPri.getRefNodo();
            }else{
                Nodo X=this.refPri;
                while(X.getRefNodo().getRefNodo()!= null && o>2){
                    X = X.getRefNodo();
                    o--;
                }
                if(o==2 && X.getRefNodo()!=null){
                    X.setRefNodo(X.getRefNodo().getRefNodo());
                }
            }
        }
    }
    public void EliminarPrimer(){
        if(!estaVacia()){
            refPri=refPri.getRefNodo();
        }
    }
    public void Elim(int b){
        if(!estaVacia()){
            if(b==this.refPri.getCod()){
                this.refPri=this.refPri.getRefNodo();
            }else{
                Nodo X = this.refPri;
                while(X.getRefNodo()!=null){
                
                }
            }
        }
    }
    public int Tamanio(){
        if(estaVacia()){
            return 0;
        }else{
            Nodo X=this.refPri;
            int t=1;
            while(X.getRefNodo()!=null){
                t++;
                X=X.getRefNodo();
            }
            return t;
        }
    }
    public int NodosPares(){
        if(estaVacia()){
            return 0;
        }else{
            Nodo X=this.refPri;
            int p=0;
            while(X!=null){
                p= (X.getCod() %2)==0 ? p+1:p;
                X=X.getRefNodo();
            }
            return p;
        }
    }
    public double Promedio(){
        if(!estaVacia()){
            double i=0,S=0;
            Nodo X =this.refPri;
            do{
                i++;
                S+=X.getCod();
                X=X.getRefNodo();
            }while(X!=null);
            return Math.round(S/i*100.0)/100.0;
        }else return 0;
    }
    public int SumaIntervalo(int a, int b){
        if(!estaVacia()){
            Nodo X=this.refPri;
            while(X!=null){
                if(a<=X.getCod()){
                    break;
                }
                X=X.getRefNodo();
            }
            int S=0;
            while(X!=null){
                if(b<X.getCod()){
                    break;
                }
                S+=X.getCod();
                X=X.getRefNodo();
            }
            return S;
        }else return 0;
    }
    public void EliminarUltimo(){
        if(!estaVacia()){
            if(this.refPri.getRefNodo()==null){
                this.refPri=null;
            }else{
                Nodo X=this.refPri;
                while(X.getRefNodo().getRefNodo()!=null){
                    X=X.getRefNodo();
                }
                X.setRefNodo(null);
            }
        }
    }
    public void EliminarPares(){
        if(!estaVacia()){
            while(this.refPri!=null && this.refPri.getCod()%2==0){
                this.refPri = this.refPri.getRefNodo()==null? null:this.refPri.getRefNodo();
            }
            Nodo X = this.refPri;
            while(X!=null){
                while(X.getRefNodo()!=null && X.getRefNodo().getCod()%2==0){
                    X.setRefNodo(X.getRefNodo().getRefNodo());
                }
                X=X.getRefNodo();
            }    
        }
    }
    public int ContarPrimos(){
        if(estaVacia()){
            return 0;
        }else{
            Nodo X=this.refPri;
            int p=0;
            while(X!=null){
                p= Primo(X.getCod()) ? p+1:p;
                X=X.getRefNodo();
            }
            return p;
        }
    }
    public boolean Primo(int x){
        if(x>1){
            double s = Math.round(Math.sqrt(x));
            for (int i=2;i<=s;i++) {
                if(x%i==0){return false;}
            }
        }
        return true;
    }
    public boolean Encontrar(int n){
        if(!estaVacia()){
            Nodo X = this.refPri;
            while(X!=null){
                if(n==X.getCod()){
                    return true;
                }
                X=X.getRefNodo();
            }
        }
        return false;
    }
}