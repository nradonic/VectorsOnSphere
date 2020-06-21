import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class VectorSphereDisplay extends JFrame {
    String emptyLabel = "Vectors On A Sphere - Spread By Repulsion";
    VectorCollection vectorCollection ;

    VectorSphereDisplay(VectorCollection vectorCollection) {
        this.vectorCollection = vectorCollection;

        JFrame jFrame = this;
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel1 = new JPanel();


        Dimension d = new Dimension(1500,1500);

        jFrame.setTitle(emptyLabel);

        Border s = BorderFactory.createBevelBorder(1);
        jPanel1.setBorder(s);

        jFrame.getContentPane().add(jPanel1);

        jFrame.setMinimumSize(d);
        jFrame.pack();

        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    public void paint(Graphics g){
        DrawArrowVectorsAs2DProjections.drawArrowVectors(g, vectorCollection);
    }
}
