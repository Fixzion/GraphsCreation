import javax.swing.*;
import java.awt.*;

public class MaxiProyecto extends JFrame {
    public DibujaGrafo panel;

    MaxiProyecto(){
        setTitle("MaxiProyecto con Grafos");
        setSize(500,500);
        IniciaObjetos();
    }

    private void IniciaObjetos(){
        panel = new DibujaGrafo();
            add(panel);

        setLayout(new GridLayout());
    }
    public static void main(String[] args) {
        MaxiProyecto fr = new MaxiProyecto();
        fr.setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        fr.setSize(screenSize);
        fr.setResizable(true);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
