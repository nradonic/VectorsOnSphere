import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;


public class VectorSphereDisplay extends JFrame {
    static Logger logger = Logger.getLogger(VectorSphereDisplay.class.getName());

    String emptyLabel = "Vectors On A Sphere - Spread By Repulsion";
    Vectors vectors;

    Double rotation = 0.0;

    static boolean nextGeneration = false;
    static boolean continuous = false;
    static Double angle = 0.0;

    VectorSphereDisplay(Vectors vectors) {
        this.vectors = vectors;

//        JFrame jFrame = this;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));

        Dimension d = new Dimension(1500, 1500);

        annotateTitle(emptyLabel);

        Border s = BorderFactory.createBevelBorder(1);
        jPanel1.setBorder(s);

        jPanel1.add(buttons());
        this.getContentPane().add(jPanel1);

        this.setMinimumSize(d);
        this.revalidate();
        this.pack();


        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private JPanel buttons() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JButton button1 = new JButton("Next");
        button1.addActionListener(actionListener);

        JButton button2 = new JButton("Continuous");
        button2.addActionListener(actionListener2);

        jPanel.add(button1);
        jPanel.add(button2);

        JSlider slider = new JSlider(0, 365, 90);

        slider.setMajorTickSpacing(30);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(e -> sliderChanged(slider));
        jPanel.add(slider);

        return jPanel;
    }

    public void sliderChanged(JSlider slider) {

        Double angle = (double)slider.getValue();
        rotation = angle / 180 * Math.PI;
    }

    public double getAngle(){
        return angle;
    }

    public void setRotation(Double angle) {
        int k = (int) (angle / (2 * Math.PI));
        rotation = angle - k * (2 * Math.PI);

    }

    public void annotateTitle(String s) {
        this.setTitle(emptyLabel + " " + s);
    }

    public void paint(Graphics g) {
        DrawArrowVectorsAs2DProjections.drawArrowVectors(g, vectors, rotation);
    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//            logger.info("Next");
            nextGeneration = true;
            continuous = false;
        }
    };

    ActionListener actionListener2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//            logger.info("Continuous");
            continuous = !continuous;
        }
    };

    public boolean getNextGeneration() {
//        logger.info("getNextGen");

        boolean result = nextGeneration;
        if (continuous == false) {
            nextGeneration = false;
        }
        if (continuous) {
            nextGeneration = true;
            result = true;
        }
        return result;
    }
}
