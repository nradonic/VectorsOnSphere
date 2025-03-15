import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.logging.Logger;


public class VectorSphereDisplay extends JFrame {
    static Logger logger = Logger.getLogger(VectorSphereDisplay.class.getName());

    String emptyLabel = "Vectors On A Sphere - Neighbors Angle Spread By Repulsion";
    Vectors vectors;

    static Double rotationAngle = 0.0;
    static Double rotationRate = Math.PI / 100; // at 10 frames/sec

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
        rotationAngle += rotationRate;
        if (rotationAngle > 2 * Math.PI) { rotationAngle = -2 * Math.PI + rotationAngle; }
        vectorPanel.setAngle(controls.getAngle() + rotationAngle );

        return controls.getNextGeneration();
    }

    public int vectorCount(){
        return controls.vectorCount();
    }
}
