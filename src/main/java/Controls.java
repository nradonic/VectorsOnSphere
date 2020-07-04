import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;

public class Controls extends JPanel {
    static Logger logger = Logger.getLogger(Controls.class.getName());

    Double rotation = 0.0;

    static boolean nextGeneration = false;
    static boolean continuous = false;
    static Double angle = 0.0;
    JButton button1;
    JButton button2;
    JSlider slider;

    static int vectorCount = 5;
    static JTextField jTextField;

    Controls() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        Border border = BorderFactory.createLineBorder(Color.CYAN);
        this.setBorder(border);

        jTextField = new JTextField();
        jTextField.setHorizontalAlignment(SwingConstants.CENTER);
        jTextField.setFont(new Font("SansSerif", Font.BOLD, 20));
        jTextField.setText(Integer.toString(vectorCount));

        jTextField.addKeyListener(keyListener);

        add(jTextField);

        button1 = new JButton("Next");
        button1.addActionListener(actionListener);

        button2 = new JButton("Continuous");
        button2.addActionListener(actionListener2);

        add(button1);
        add(button2);

        slider = new JSlider(0, 365, 90);

        slider.setMajorTickSpacing(30);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(e -> sliderChanged(slider));

        Dimension k = new Dimension(700, 50);
        slider.setPreferredSize(k);
        add(slider);

    }

    public void sliderChanged(JSlider slider) {

        Double angle = (double) slider.getValue();
        rotation = angle / 180 * Math.PI;
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

    public double getAngle() {
        return rotation;
    }

    public void setRotation(Double angle) {
        int k = (int) (angle / (2 * Math.PI));
        rotation = angle - k * (2 * Math.PI);
    }

    public KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent evt) {
            if (evt == null) {
                return;
            }
            clearBadText();
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (evt == null) {
                return;
            }
            clearBadText();
        }

        @Override
        public void keyReleased(KeyEvent evt) {
            if (evt == null) {
                return;
            }
            clearBadText();
        }
    };

    private void clearBadText() {
        String text = jTextField.getText().replaceAll("\\D", "");
        if (!text.isEmpty()) {
            vectorCount = Integer.valueOf(text);
        }
        if (text.isEmpty()) {
            vectorCount = 4;
        }
    }

    public int vectorCount(){
        return vectorCount;
    }
}
