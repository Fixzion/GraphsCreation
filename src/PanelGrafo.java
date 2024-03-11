import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Objects;

public class DibujaGrafo extends JPanel{
    private Image mapa;
    private static int x,x2;
    private int y,y2;
    private int dx, dy;
    private ArrayList<Nodo> nodos;
    private ArrayList<Arco> arcos = new ArrayList<>();
    private Nodo nodoSeleccionado;
    private Point posicionInicial;
    private Line2D arco;
    private int DraggX, DraggY;
    //private final JLabel pRaton;
    private String NumNodo;
    DibujaGrafo(){
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.nodos = new ArrayList<Nodo>();

        //pRaton = new JLabel("Posición del mouse: (0,0)");
        //add(pRaton)
        // ;
        setOpaque(false);

        addMouseListener (new MouseAdapter(){
            //Método para obtener coordenadas del mouse al dar click'
            public void mouseClicked(MouseEvent e){
                x2 = x;
                y2 = y;

                x = e.getX();
                y = e.getY();
                repaint();


                Nodo n = new Nodo();
                n.setNodo(new Ellipse2D.Double(x,y,20,20));
                n.setNumero(String.valueOf(DibujaGrafo.this.nodos.size() + 1));

                System.out.println("Has creado un nodo en las coordenadas:"+x+", "+y);
                DibujaGrafo.this.nodos.add(n);

                repaint();
            }
            public void mousePressed(MouseEvent e){

                for(Nodo n : DibujaGrafo.this.nodos){
                    if(n.getNodo().contains(e.getPoint())){
                        nodoSeleccionado = n;
                        posicionInicial = e.getPoint();
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                        break;
                    }
                }
            }
            public void mouseReleased(MouseEvent e){
               nodoSeleccionado = null;
               posicionInicial = null;
               setCursor(new Cursor (Cursor.DEFAULT_CURSOR));
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e1) {
               if(nodoSeleccionado != null){
                   dx = e1.getX()-posicionInicial.x;
                   dy = e1.getY()-posicionInicial.y;

                   nodoSeleccionado.movimiento(dx, dy);
                   posicionInicial = e1.getPoint();

                   repaint();
               }
            }
            public void mouseMoved(MouseEvent e2) {
                //Cambia las coordenadas del la etiqueta (arriba del panel), en las encuentra el mouse
                //pRaton.setText("Mouse moved to (" + e2.getX() + ", " + e2.getY() + ")");

                for (Nodo n : DibujaGrafo.this.nodos) {
                    if (n.getNodo().contains(e2.getPoint())) {
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                        break;
                    }
                    setCursor(Cursor.getDefaultCursor());
                }
            }
        });
    }
    public void paintComponent(Graphics g){
        setOpaque(false);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        mapa = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Imágenes/mapa.jpg"))).getImage();
        g.drawImage(mapa, 0, 0, getWidth(), getHeight(), this);

        /*for (Nodo nodo : nodos) {
            g2.fill((Ellipse2D) nodo.getNodo());
            g2.drawString(nodo.getNumero(), dx, dy);
        }
        for (Nodo nodo : nodos) {
            //g2.draw((Line2D) arcos.get(i).getArco());
            g2.fill((Ellipse2D) nodo.getNodo());
            g2.drawString(nodo.getNumero(), dx, dy);
            g2.draw(arco);
        }
        for(int i=0; i< arcos.size(); i++){

        }*/


        for (int i = 0; i < nodos.size(); i++) {
            // Obtiene la forma del nodo
            Ellipse2D nodo = nodos.get(i).getNodo();
            // Dibuja la elipse
            g2.fill(nodo);
        }
    }
}

