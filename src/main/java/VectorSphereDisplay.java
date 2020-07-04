import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.logging.Logger;


public class VectorSphereDisplay extends JFrame {
    static Logger logger = Logger.getLogger(VectorSphereDisplay.class.getName());

    String emptyLabel = "Vectors On A Sphere - Spread By Repulsion";
    Vectors vectors;

    static boolean nextGeneration = false;
    static boolean continuous = false;
    static Double angle = 0.0;

    static Controls controls = new Controls();
    VectorDisplay vectorPanel;

    VectorSphereDisplay(Vectors vectors) {
        setLayout(new BorderLayout());
        annotateTitle(emptyLabel);

        this.vectors = vectors;
        vectorPanel = new VectorDisplay(vectors);

        add(controls, BorderLayout.NORTH);

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BorderLayout());

        jPanel1.add(vectorPanel,BorderLayout.CENTER);

        Border s = BorderFactory.createLineBorder(Color.GREEN);
        jPanel1.setBorder(s);

        Dimension d = new Dimension(1000, 1000);

        add(jPanel1, BorderLayout.CENTER);

        setMinimumSize(d);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        validate();
        pack();

        this.setVisible(true);

    }

    public void setVectors(Vectors vectors) {
        this.vectors = vectors;
    }

    public void annotateTitle(String s) {
        this.setTitle(emptyLabel + " " + s);
    }

    public boolean getNextGeneration() {
//        logger.info("getNextGen");
        vectorPanel.setAngle(controls.getAngle());

        return controls.getNextGeneration();
    }

    public int vectorCount(){
        return controls.vectorCount();
    }
}
