package Presentacion;
import Arbol.Arbol;
import Lista.ListaDoble;
import Lista.ListaSimple;
import Lista.ListaCircular;
public class clsPrincipal {
    public static void main(String[] args) {
        Arbol obj = new Arbol();
        obj.Insertar(50);
        obj.Insertar(40);
        obj.Insertar(60);
        obj.Insertar(45);
        obj.Insertar(30);
        obj.Insertar(20);
        obj.Insertar(25);
        obj.Insertar(35);
        obj.Insertar(42);
        obj.Insertar(70);
        obj.Insertar(80);
        obj.Insertar(55);
        obj.Insertar(58);
        obj.Insertar(69);
        obj.Insertar(79);
        //obj.Eliminar(40);
        System.out.println(obj.Eliminar(50));
        
        obj.InOrden();
        //obj.InOrden();
        obj.Insertar(4); 
    }
}