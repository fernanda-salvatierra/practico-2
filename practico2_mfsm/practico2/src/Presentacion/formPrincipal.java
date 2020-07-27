package Presentacion;
import Negocio.Nodo;
import Negocio.NodoLD;
import Negocio.NodoArbol;
import Pilas.Pila;
import Cola.Cola;
import Lista.ListaDoble;
import Lista.ListaSimple;
import Lista.ListaCircular;
import Arbol.Arbol;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
public class formPrincipal extends javax.swing.JFrame {
    private Pila objePila;
    private Cola objCola;
    private ListaSimple objLS;
    private ListaDoble objLD;
    private ListaCircular objLC;
    private Arbol objAr;
    private Font font;
    private int px,py,x0,y0;
    public int B;
    public boolean F;
    public formPrincipal() {
        initComponents();
        this.font = new Font ("Garamond", Font.BOLD , 14);
        this.objePila = new Pila();
        this.objCola = new Cola();
        this.objLS = new ListaSimple();
        this.objLD = new ListaDoble();
        this.objLC = new ListaCircular();
        this.objAr = new Arbol();
        px = 80;
        py = 100;
        x0=30;
        y0=70;
        al.setVisible(false);
        bl.setVisible(false);
        a.setVisible(false);
        b.setVisible(false);
        btn_ok.setVisible(false);
        B=0;
        F=false;
    }
    
    public void graficar(){
        Graphics dibujar = Pn.getGraphics();
        dibujar.setColor(Color.white);
        dibujar.fillRect(0, 0, Pn.getWidth(), Pn.getHeight());
        dibujar.setColor(Color.black);
        Nodo nn = this.objePila.getCima();
        int i = 0;
        dibujar.drawString("Cima->", x0-5, y0+25);
        while(nn != null){
            String dd = nn.getDato();
            dibujar.drawRect(x0+40, y0+i*35, 80, 30);
            dibujar.drawString(dd, x0+40, y0+i*35+25);
            i++;
            nn = nn.getRefNodo();
        }
    }
    public void GrafCola(){
        Graphics g = Pn.getGraphics();
        Graphics2D a = (Graphics2D) g;
        a.setStroke(new BasicStroke(3));
        g.setFont(font);
        g.setColor(Color.white);
        g.fillRect(0, 0, Pn.getWidth(), Pn.getHeight());
        g.setColor(Color.black);
        Nodo objC = this.objCola.getRefPri();
        int i = 0,b=90,h=49,r=15;
        int X=x0;
        g.setColor(Color.red);
        while(objC != null){
            X = x0+i*(b+r);
            String s = objC.getDato();
            g.drawRect(X, y0, b, h);
            g.fillRect(X+b-r, y0, r+1, h+1);
            g.drawLine(X+b, y0+h/2, X+b+r, y0+h/2);
            g.setColor(Color.black);
            g.drawString(s, X+10, y0+h/2);
            i++;
            objC = objC.getRefNodo();
            if(objC ==objCola.getRefUlt()){
                g.setColor(Color.green);
            }
        }
        g.setColor(Color.green);
        g.drawLine(X+b+r, y0+h/2, X+b+r, y0+h/2+40);
        g.drawLine(X+b+r-20, y0+h/2+40, X+b+r+20, y0+h/2+40);
        g.drawLine(X+b+r-10, y0+h/2+45, X+b+r+10, y0+h/2+45);
    }
    public void GrafLS(){
        Graphics g = Pn.getGraphics();
        Graphics2D a = (Graphics2D) g;
        a.setStroke(new BasicStroke(3));
        g.setFont(font);
        g.setColor(Color.white);
        g.fillRect(0, 0, Pn.getWidth(), Pn.getHeight());
        g.setColor(Color.black);
        Nodo objl = this.objLS.getRefPri();
        int i = 0,b=90,h=49,r=15;
        int X=x0;
        g.setColor(Color.red);
        while(objl != null){
            X = x0+i*(b+r);
            String s = objl.getDato();
            if(F && B==objl.getCod()){
                g.setColor(Color.green);
            }
            g.drawRect(X, y0, b, h);
            g.fillRect(X+b-r, y0, r+1, h+1);
            g.drawLine(X+b, y0+h/2, X+b+r, y0+h/2);
            g.setColor(Color.black);
            g.drawString(s, X+10, y0+h/2);
            i++;
            objl = objl.getRefNodo();
        }
        g.drawLine(X+b+r, y0+h/2, X+b+r, y0+h/2+40);
        g.drawLine(X+b+r-20, y0+h/2+40, X+b+r+20, y0+h/2+40);
        g.drawLine(X+b+r-10, y0+h/2+45, X+b+r+10, y0+h/2+45);
    }

    /**
     *
     * @param x
     * @param n
     * @return
     */
    public boolean EncontrarNodo(int x,int n){
        return (x==n)? true:false;
    }
    public void GrafLD(){
        Graphics g = Pn.getGraphics();
        Graphics2D a = (Graphics2D) g;
        ListaDoble objAux =new ListaDoble();
        objAux.setpLD(this.objLD.getpLD());
        objAux.irPri();
        
        a.setStroke(new BasicStroke(3));
        g.setFont(font);
        g.setColor(Color.white);
        g.fillRect(0, 0, Pn.getWidth(), Pn.getHeight());
        g.setColor(Color.black);
        
        NodoLD nLDPri = objAux.getpLD();
        int i = 0,b=90,h=49,r=15;
        int X=x0;
        /*Nulo Izquierdo*/
        g.setColor(Color.red);
        g.drawLine(X-r, y0+2*h/3, X-r, y0+2*h/3+40);
        g.drawLine(X-r-20, y0+2*h/3+40, X-r+20, y0+2*h/3+40);
        g.drawLine(X-r-10, y0+2*h/3+45, X-r+10, y0+2*h/3+45);
        
        while(nLDPri != null){
            if(nLDPri == this.objLD.getpLD()){
                g.setColor(Color.blue);
            }else g.setColor(Color.black);
            X = x0+i*(b+r);
            String s = ""+nLDPri.getDato();
            g.drawRect(X, y0, b, h);
            
            /*Cuadros laterales*/
            g.setColor(Color.red);
            g.fillRect(X, y0, r+1, h+1);
            g.setColor(Color.black);
            g.fillRect(X+b-r, y0, r+1, h+1);
            
            /*Lineas de referencia*/
            g.drawLine(X+b, y0+h/3, X+b+r, y0+h/3);
            g.setColor(Color.red);
            g.drawLine(X, y0+2*h/3, X-r+2, y0+2*h/3);
            
            g.setColor(Color.black);
            g.drawString(s, X+20, y0+h/2);
            i++;
            nLDPri = nLDPri.getRefD();
        }
        /*Nulo Derecho*/
        g.drawLine(X+b+r, y0+h/3, X+b+r, y0+h/2+40);
        g.drawLine(X+b+r-20, y0+h/2+40, X+b+r+20, y0+h/2+40);
        g.drawLine(X+b+r-10, y0+h/2+45, X+b+r+10, y0+h/2+45);
    }
    
    public void GrafLC(){
        Graphics g = Pn.getGraphics();
        if(this.objLC.getpLC()!=null){
            Graphics2D a = (Graphics2D) g;

            a.setStroke(new BasicStroke(3));
            g.setFont(font);
            g.setColor(Color.white);
            g.fillRect(0, 0, Pn.getWidth(), Pn.getHeight());
            g.setColor(Color.black);

            NodoLD nLCPri = objLC.getpLC();
            int i = 0,b=90,h=49,r=15;
            int X=x0;
            /*Nulo Izquierdo*/
            g.setColor(Color.red);
            g.drawLine(X-r, y0+2*h/3, X-r, y0+4*h/3);
            g.setColor(Color.black);
            g.drawLine(X-r, y0+h/3, X, y0+h/3);
            g.drawLine(X-r, y0+h/3, X-r, y0-h/3);

            do{
                if(nLCPri == this.objLC.getpLC()){
                    g.setColor(Color.blue);
                }else g.setColor(Color.black);
                X = x0+i*(b+r);
                String s = ""+nLCPri.getDato();
                g.drawRect(X, y0, b, h);

                /*Cuadros laterales*/
                g.setColor(Color.red);
                g.fillRect(X, y0, r+1, h+1);
                g.setColor(Color.black);
                g.fillRect(X+b-r, y0, r+1, h+1);

                /*Lineas de referencia*/
                g.drawLine(X+b, y0+h/3, X+b+r, y0+h/3);
                g.setColor(Color.red);
                g.drawLine(X, y0+2*h/3, X-r+2, y0+2*h/3);

                g.setColor(Color.black);
                g.drawString(s, X+20, y0+h/2);
                i++;
                nLCPri = nLCPri.getRefD();
            }while(nLCPri != this.objLC.getpLC());
            /*Nulo Derecho*/
            g.drawLine(X+b+r, y0+h/3, X+b+r, y0-h/3);
            g.drawLine(X+b+r, y0-h/3, x0-r, y0-h/3);

            g.setColor(Color.red);
            g.drawLine(X+b+3, y0+2*h/3, X+b+r, y0+2*h/3);
            g.drawLine(X+b+r, y0+2*h/3, X+b+r, y0+4*h/3);
            g.drawLine(X+b+r, y0+4*h/3, x0-r, y0+4*h/3);
        }else{
            g.setColor(Color.white);
            g.fillRect(0, 0, Pn.getWidth(), Pn.getHeight());
        }
    }
    
    public void GrafArbol(){
        Graphics G = Pn.getGraphics();
        Graphics2D a = (Graphics2D) G;
        a.setStroke(new BasicStroke(3));
        G.setColor(Color.white);
        G.fillRect(0, 0, Pn.getWidth(), Pn.getHeight());
        GrafArbol(this.objAr.getRaiz(),Pn.getWidth()/2,50,100,50);
    }
    public void GrafArbol(NodoArbol N,int x,int y,int dx,int dy){
        if(N.gethI()!=null){
            GrafArbol(N.gethI(),x-dx,y+dy,(int)(dx*0.6),(int)(dy*0.9));
        }
        GrafNodoAr(N,x,y,dx,dy);
        if(N.gethD()!=null){
            GrafArbol(N.gethD(),x+dx,y+dy,(int)(dx*0.6),(int)(dy*0.9));
        }
    }
    public void GrafNodoAr(NodoArbol N,int x, int y,int dx, int dy){
        Graphics G = Pn.getGraphics();
        Graphics2D a = (Graphics2D) G;
        G.setFont(font);
        a.setStroke(new BasicStroke(3));
        G.setColor(Color.black);
        G.drawOval(x, y, 40, 40);
        G.drawString(""+N.getCod(), x+10, y+22);
        G.setColor(Color.red);
        G.drawLine(x, y+15, x-dx, y+dy);
        G.drawLine(x+38, y+15, x+30+dx, y+dy);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        txt_Codigo = new javax.swing.JTextField();
        txt_detalle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Pn = new javax.swing.JPanel();
        a = new javax.swing.JTextField();
        b = new javax.swing.JTextField();
        al = new javax.swing.JLabel();
        bl = new javax.swing.JLabel();
        btn_ok = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        MCola = new javax.swing.JMenu();
        C_ins = new javax.swing.JMenuItem();
        C_sacar = new javax.swing.JMenuItem();
        MLista = new javax.swing.JMenu();
        L_insertar = new javax.swing.JMenuItem();
        L_eliminarNodo = new javax.swing.JMenuItem();
        L_eliminarXcod = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        LS_tamanio = new javax.swing.JMenuItem();
        LS_nodosPares = new javax.swing.JMenuItem();
        LS_promedio = new javax.swing.JMenuItem();
        LS_sumaIntervalo = new javax.swing.JMenuItem();
        LS_eliminarUlt = new javax.swing.JMenuItem();
        ElimPar = new javax.swing.JMenuItem();
        LS_ContarPrimos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        LD_EncontrarValor = new javax.swing.JMenuItem();
        MLD = new javax.swing.JMenu();
        LD_InsertDer = new javax.swing.JMenuItem();
        LD_InsertIzq = new javax.swing.JMenuItem();
        LD_insertOrd = new javax.swing.JMenuItem();
        LD_moverDer = new javax.swing.JMenuItem();
        LD_moverIzq = new javax.swing.JMenuItem();
        LD_eliminar = new javax.swing.JMenuItem();
        LD_Tamanio = new javax.swing.JMenuItem();
        MLC = new javax.swing.JMenu();
        LC_insertD = new javax.swing.JMenuItem();
        LC_insertI = new javax.swing.JMenuItem();
        LC_eliminar = new javax.swing.JMenuItem();
        LC_tamanio = new javax.swing.JMenuItem();
        MArbol = new javax.swing.JMenu();
        A_insertar = new javax.swing.JMenuItem();
        A_eliminar = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estructuras de Datos");
        setBackground(new java.awt.Color(102, 102, 102));
        setMinimumSize(new java.awt.Dimension(800, 494));
        setPreferredSize(new java.awt.Dimension(800, 494));
        setResizable(false);

        txt_Codigo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txt_detalle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Detalle:");

        Pn.setBackground(new java.awt.Color(255, 255, 255));
        Pn.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout PnLayout = new javax.swing.GroupLayout(Pn);
        Pn.setLayout(PnLayout);
        PnLayout.setHorizontalGroup(
            PnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PnLayout.setVerticalGroup(
            PnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        al.setText("Desde:");

        bl.setText("Hasta:");

        btn_ok.setText("Listo");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        jMenu1.setText("Menú");

        jMenuItem4.setText("Graficar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pilas");

        jMenuItem1.setText("Insetar Pila");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Sacar dato pila");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Esta vacia");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        MCola.setText("Cola");

        C_ins.setText("Insertar");
        C_ins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_insActionPerformed(evt);
            }
        });
        MCola.add(C_ins);

        C_sacar.setText("Eliminar");
        C_sacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_sacarActionPerformed(evt);
            }
        });
        MCola.add(C_sacar);

        jMenuBar1.add(MCola);

        MLista.setText("Lista");

        L_insertar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        L_insertar.setText("Insertar");
        L_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_insertarActionPerformed(evt);
            }
        });
        MLista.add(L_insertar);

        L_eliminarNodo.setText("Eliminar Nodo");
        L_eliminarNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_eliminarNodoActionPerformed(evt);
            }
        });
        MLista.add(L_eliminarNodo);

        L_eliminarXcod.setText("Eliminar por Código");
        L_eliminarXcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L_eliminarXcodActionPerformed(evt);
            }
        });
        MLista.add(L_eliminarXcod);

        jSeparator1.setToolTipText("Práctico");
        MLista.add(jSeparator1);

        LS_tamanio.setText("Tamaño");
        LS_tamanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LS_tamanioActionPerformed(evt);
            }
        });
        MLista.add(LS_tamanio);

        LS_nodosPares.setText("N° de Nodos Pares");
        LS_nodosPares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LS_nodosParesActionPerformed(evt);
            }
        });
        MLista.add(LS_nodosPares);

        LS_promedio.setText("Promedio");
        LS_promedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LS_promedioActionPerformed(evt);
            }
        });
        MLista.add(LS_promedio);

        LS_sumaIntervalo.setText("Suma en intervalo");
        LS_sumaIntervalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LS_sumaIntervaloActionPerformed(evt);
            }
        });
        MLista.add(LS_sumaIntervalo);

        LS_eliminarUlt.setText("Eliminar Último Nodo");
        LS_eliminarUlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LS_eliminarUltActionPerformed(evt);
            }
        });
        MLista.add(LS_eliminarUlt);

        ElimPar.setText("Eliminar Pares");
        ElimPar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElimParActionPerformed(evt);
            }
        });
        MLista.add(ElimPar);

        LS_ContarPrimos.setText("Contar Primos");
        LS_ContarPrimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LS_ContarPrimosActionPerformed(evt);
            }
        });
        MLista.add(LS_ContarPrimos);
        MLista.add(jSeparator2);

        LD_EncontrarValor.setText("Buscar Nodo");
        LD_EncontrarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LD_EncontrarValorActionPerformed(evt);
            }
        });
        MLista.add(LD_EncontrarValor);

        jMenuBar1.add(MLista);

        MLD.setText("Lista Doble");

        LD_InsertDer.setText("Insertar Derecha");
        LD_InsertDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LD_InsertDerActionPerformed(evt);
            }
        });
        MLD.add(LD_InsertDer);

        LD_InsertIzq.setText("Insertar Izquierda");
        LD_InsertIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LD_InsertIzqActionPerformed(evt);
            }
        });
        MLD.add(LD_InsertIzq);

        LD_insertOrd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        LD_insertOrd.setText("Insertar Ordenado");
        LD_insertOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LD_insertOrdActionPerformed(evt);
            }
        });
        MLD.add(LD_insertOrd);

        LD_moverDer.setText("Mover Derecha");
        LD_moverDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LD_moverDerActionPerformed(evt);
            }
        });
        MLD.add(LD_moverDer);

        LD_moverIzq.setText("Mover Izquierda");
        LD_moverIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LD_moverIzqActionPerformed(evt);
            }
        });
        MLD.add(LD_moverIzq);

        LD_eliminar.setText("Eliminar");
        LD_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LD_eliminarActionPerformed(evt);
            }
        });
        MLD.add(LD_eliminar);

        LD_Tamanio.setText("Tamaño");
        LD_Tamanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LD_TamanioActionPerformed(evt);
            }
        });
        MLD.add(LD_Tamanio);

        jMenuBar1.add(MLD);

        MLC.setText("Lista CIrcular");

        LC_insertD.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_MASK));
        LC_insertD.setText("Insertar Derecha");
        LC_insertD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LC_insertDActionPerformed(evt);
            }
        });
        MLC.add(LC_insertD);

        LC_insertI.setText("Insertar Izquierda");
        LC_insertI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LC_insertIActionPerformed(evt);
            }
        });
        MLC.add(LC_insertI);

        LC_eliminar.setText("Eliminar");
        LC_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LC_eliminarActionPerformed(evt);
            }
        });
        MLC.add(LC_eliminar);

        LC_tamanio.setText("Tamaño");
        LC_tamanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LC_tamanioActionPerformed(evt);
            }
        });
        MLC.add(LC_tamanio);

        jMenuBar1.add(MLC);

        MArbol.setText("Arbol");

        A_insertar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LESS, java.awt.event.InputEvent.ALT_MASK));
        A_insertar.setText("Insertar");
        A_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A_insertarActionPerformed(evt);
            }
        });
        MArbol.add(A_insertar);

        A_eliminar.setText("Eliminar");
        A_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A_eliminarActionPerformed(evt);
            }
        });
        MArbol.add(A_eliminar);

        jMenuBar1.add(MArbol);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(486, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bl)
                        .addGap(18, 18, 18)
                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(al)
                        .addGap(18, 18, 18)
                        .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_Codigo)
                    .addComponent(txt_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(al))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bl))
                        .addGap(18, 18, 18)
                        .addComponent(btn_ok)))
                .addGap(18, 18, 18)
                .addComponent(Pn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        graficar();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int cod = Integer.parseInt(txt_Codigo.getText());
        String ss = txt_detalle.getText();
        this.objePila.insertar(cod, ss);
        graficar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        String ss = this.objePila.sacarDatos();
        JOptionPane.showMessageDialog(this, ss);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void C_insActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_insActionPerformed
        int c = Integer.parseInt(txt_Codigo.getText());
        String D = txt_detalle.getText();
        this.objCola.insertar(c, D);
        GrafCola();
    }//GEN-LAST:event_C_insActionPerformed

    private void C_sacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_sacarActionPerformed
        objCola.sacar();
        GrafCola();
    }//GEN-LAST:event_C_sacarActionPerformed

    private void L_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_insertarActionPerformed
        int cod = Integer.parseInt(txt_Codigo.getText());
        String D = txt_detalle.getText();
        this.objLS.insertarOrdenado(cod, D);
        GrafLS();
    }//GEN-LAST:event_L_insertarActionPerformed

    private void L_eliminarNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_eliminarNodoActionPerformed
        this.objLS.EliminarPrimer();
        GrafLS();
    }//GEN-LAST:event_L_eliminarNodoActionPerformed

    private void L_eliminarXcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L_eliminarXcodActionPerformed
        this.objLS.EliminarSegunCod(Integer.parseInt(txt_Codigo.getText()));
        GrafLS();
    }//GEN-LAST:event_L_eliminarXcodActionPerformed

    private void LS_tamanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LS_tamanioActionPerformed
        JOptionPane.showMessageDialog(this, "La lista tiene "+objLS.Tamanio()+" nodos.");
    }//GEN-LAST:event_LS_tamanioActionPerformed

    private void LS_nodosParesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LS_nodosParesActionPerformed
        JOptionPane.showMessageDialog(this, "La lista tiene "+objLS.NodosPares()+" nodos pares.");
    }//GEN-LAST:event_LS_nodosParesActionPerformed

    private void LS_promedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LS_promedioActionPerformed
        JOptionPane.showMessageDialog(this, "El promedio de todos los codigos de la lista es "+objLS.Promedio());
    }//GEN-LAST:event_LS_promedioActionPerformed

    private void LS_sumaIntervaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LS_sumaIntervaloActionPerformed
        al.setVisible(true);
        bl.setVisible(true);
        a.setVisible(true);
        b.setVisible(true);
        btn_ok.setVisible(true);
    }//GEN-LAST:event_LS_sumaIntervaloActionPerformed

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        int A= Integer.parseInt(a.getText()), B= Integer.parseInt(b.getText());
        int S = this.objLS.SumaIntervalo(A, B);
        JOptionPane.showMessageDialog(this, "La suma de los nodos entre "+A+" y "+B+" es "+S);
    }//GEN-LAST:event_btn_okActionPerformed

    private void LS_eliminarUltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LS_eliminarUltActionPerformed
        this.objLS.EliminarUltimo();
        GrafLS();
    }//GEN-LAST:event_LS_eliminarUltActionPerformed

    private void ElimParActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElimParActionPerformed
        this.objLS.EliminarPares();
        GrafLS();
    }//GEN-LAST:event_ElimParActionPerformed

    private void LS_ContarPrimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LS_ContarPrimosActionPerformed
        JOptionPane.showMessageDialog(this, "Hay "+objLS.ContarPrimos()+" números primos en la lista.");
        GrafLS();
    }//GEN-LAST:event_LS_ContarPrimosActionPerformed

    private void LD_InsertIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LD_InsertIzqActionPerformed
        int d = Integer.parseInt(txt_Codigo.getText());
        this.objLD.InsertIzq(d);
        GrafLD();
    }//GEN-LAST:event_LD_InsertIzqActionPerformed

    private void LD_moverDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LD_moverDerActionPerformed
        if(this.objLD.moverDer()){
            JOptionPane.showMessageDialog(this, "El puntero se movió a la derecha.");
            GrafLD();
        }else JOptionPane.showMessageDialog(this, "No se puede mover a la derecha.");
    }//GEN-LAST:event_LD_moverDerActionPerformed

    private void LD_moverIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LD_moverIzqActionPerformed
        if(this.objLD.moverIzq()){
            JOptionPane.showMessageDialog(this, "El puntero se movió a la izquierda.");
            GrafLD();
        }else JOptionPane.showMessageDialog(this, "No se puede mover a la izquierda.");
    }//GEN-LAST:event_LD_moverIzqActionPerformed

    private void LD_InsertDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LD_InsertDerActionPerformed
        int d = Integer.parseInt(txt_Codigo.getText());
        this.objLD.InsertDer(d);
        GrafLD();
    }//GEN-LAST:event_LD_InsertDerActionPerformed

    private void LD_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LD_eliminarActionPerformed
        this.objLD.Eliminar();
        GrafLD();
    }//GEN-LAST:event_LD_eliminarActionPerformed

    private void LD_insertOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LD_insertOrdActionPerformed
        this.objLD.InsertarOrd(Integer.parseInt(txt_Codigo.getText()));
        GrafLD();
    }//GEN-LAST:event_LD_insertOrdActionPerformed

    private void LD_EncontrarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LD_EncontrarValorActionPerformed
        B=Integer.parseInt(txt_Codigo.getText());
        F= this.objLS.Encontrar(B);
        GrafLS();
        if(!F){
            JOptionPane.showMessageDialog(this, "No se encontró ningún nodo con ese código.");
        }else JOptionPane.showMessageDialog(this, "Se encontraron nodos con el código"+B+".");
    }//GEN-LAST:event_LD_EncontrarValorActionPerformed

    private void LD_TamanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LD_TamanioActionPerformed
        JOptionPane.showMessageDialog(this, "La lista tiene "+objLD.Tamanio()+" nodos.");
    }//GEN-LAST:event_LD_TamanioActionPerformed

    private void A_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A_insertarActionPerformed
        int cod=Integer.parseInt(txt_Codigo.getText());
        this.objAr.Insertar(cod);
        GrafArbol();
    }//GEN-LAST:event_A_insertarActionPerformed

    private void LC_insertDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LC_insertDActionPerformed
        int cod=Integer.parseInt(txt_Codigo.getText());
        this.objLC.InsertarD(cod);
        GrafLC();
    }//GEN-LAST:event_LC_insertDActionPerformed

    private void LC_insertIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LC_insertIActionPerformed
        int cod=Integer.parseInt(txt_Codigo.getText());
        this.objLC.InsertarI(cod);
        GrafLC();
    }//GEN-LAST:event_LC_insertIActionPerformed

    private void LC_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LC_eliminarActionPerformed
        this.objLC.Eliminar();
        GrafLC();
    }//GEN-LAST:event_LC_eliminarActionPerformed

    private void LC_tamanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LC_tamanioActionPerformed
        JOptionPane.showMessageDialog(this, "La lista tiene "+objLC.Tamanio()+" nodos.");
    }//GEN-LAST:event_LC_tamanioActionPerformed

    private void A_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A_eliminarActionPerformed
        this.objAr.Eliminar(Integer.parseInt(txt_Codigo.getText()));
        GrafArbol();
    }//GEN-LAST:event_A_eliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem A_eliminar;
    private javax.swing.JMenuItem A_insertar;
    private javax.swing.JMenuItem C_ins;
    private javax.swing.JMenuItem C_sacar;
    private javax.swing.JMenuItem ElimPar;
    private javax.swing.JMenuItem LC_eliminar;
    private javax.swing.JMenuItem LC_insertD;
    private javax.swing.JMenuItem LC_insertI;
    private javax.swing.JMenuItem LC_tamanio;
    private javax.swing.JMenuItem LD_EncontrarValor;
    private javax.swing.JMenuItem LD_InsertDer;
    private javax.swing.JMenuItem LD_InsertIzq;
    private javax.swing.JMenuItem LD_Tamanio;
    private javax.swing.JMenuItem LD_eliminar;
    private javax.swing.JMenuItem LD_insertOrd;
    private javax.swing.JMenuItem LD_moverDer;
    private javax.swing.JMenuItem LD_moverIzq;
    private javax.swing.JMenuItem LS_ContarPrimos;
    private javax.swing.JMenuItem LS_eliminarUlt;
    private javax.swing.JMenuItem LS_nodosPares;
    private javax.swing.JMenuItem LS_promedio;
    private javax.swing.JMenuItem LS_sumaIntervalo;
    private javax.swing.JMenuItem LS_tamanio;
    private javax.swing.JMenuItem L_eliminarNodo;
    private javax.swing.JMenuItem L_eliminarXcod;
    private javax.swing.JMenuItem L_insertar;
    private javax.swing.JMenu MArbol;
    private javax.swing.JMenu MCola;
    private javax.swing.JMenu MLC;
    private javax.swing.JMenu MLD;
    private javax.swing.JMenu MLista;
    private javax.swing.JPanel Pn;
    private javax.swing.JTextField a;
    private javax.swing.JLabel al;
    private javax.swing.JTextField b;
    private javax.swing.JLabel bl;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JTextField txt_detalle;
    // End of variables declaration//GEN-END:variables
}
