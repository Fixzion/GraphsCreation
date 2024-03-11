import java.awt.geom.*;
public class Nodo {
    private Ellipse2D nodo;
    private Line2D ap;
    private int x,y;
    private String numero;
    Nodo(){}
    //Objetos dibujados en el panel
    public Ellipse2D getNodo() {
        return nodo;
    }
    public void setNodo(Ellipse2D nodo) {
        this.nodo = nodo;
    }
    public Line2D getAp() {return ap;}
    public void setAp(Line2D ap) {this.ap = ap;}

//Valores que se guardan dentro de cada objeto
    public int getX() {
    return x;
}
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void movimiento(int dx, int dy){
        if (nodo instanceof Ellipse2D & ap instanceof Line2D){
            Ellipse2D ellipse = (Ellipse2D) nodo;
            ellipse.setFrame(ellipse.getX()+dx, ellipse.getY()+dy, ellipse.getWidth(),ellipse.getHeight());

            Line2D Linea = (Line2D) ap;
            Linea.setLine(Linea.getX1()+dx, Linea.getY1()+dy, Linea.getX2(),Linea.getY2());
        }
    }
    /*public void movimientoAp(int dx, int dy, int dy2, int dx2){
        if (ap instanceof Line2D){
            Line2D Linea = (Line2D) ap;
            Linea.setLine(Linea.getX1()+dx, Linea.getY1()+dy, Linea.getX2(),Linea.getY2());
        }
    }*/
}
