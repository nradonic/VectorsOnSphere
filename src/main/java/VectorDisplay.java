import javax.swing.*;
import java.awt.*;

public class VectorDisplay extends JPanel {

    Vectors vectors;
    private Double angle;

    VectorDisplay(Vectors vectors) {
        setMinimumSize(new Dimension(500, 500));
        setBorder(BorderFactory.createLineBorder(Color.CYAN));
        this.vectors = vectors;
    }

    void drawArrowVectors(Graphics g) {
        int headerWidth = 50;
        g.clearRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
        int length = (Math.min(g.getClipBounds().width, g.getClipBounds().height)) / 5;

        for (ArrowVector v : vectors) {
            paintAsVector(g, headerWidth, length, v, angle);
        }
    }

    private void paintAsVector(Graphics g, int headerWidth, int length, ArrowVector v, Double angle) {
        final int ovalRadius = 5;
        final int vectorLengthToDisplayScaling = 2;
        int centerX = g.getClipBounds().width / 2;
        int centerY = length * 2 + headerWidth;
        Double rotatedX = rotate(v, angle);
        Double rotatedDx = rotateDx(v, angle);
        int x = (int) (rotatedX * length * vectorLengthToDisplayScaling);
        int y = (int) (v.getY() * length * vectorLengthToDisplayScaling);
        int dX = (int) (rotatedDx * ovalRadius);//length);
        int dY = (int) (v.getdY() * ovalRadius);//length);

        g.setColor(calculateColorForVector(v));
        if(v.ageEqZero()) {
            g.drawLine(centerX, centerY, centerX + x, centerY + y);
        }
        g.drawOval(centerX + x - ovalRadius, centerY + y - ovalRadius,
                2 * ovalRadius, 2 * ovalRadius);
        g.drawOval((int) (centerX + x + dX - ovalRadius / 2.0), (int) (centerY + y + dY - ovalRadius / 2.0),
                ovalRadius, ovalRadius);
    }

    Color calculateColorForVector(ArrowVector v) {
        int colorRangeHalf = 128;
        int r = (int) (v.getX() * colorRangeHalf + colorRangeHalf);
        int g = (int) (v.getY() * colorRangeHalf + colorRangeHalf);
        int b = (int) (v.getZ() * colorRangeHalf + colorRangeHalf);
        return new Color(r, g, b);
    }

    private Double rotate(ArrowVector v, Double angle) {

        Double x = v.getX();
        Double z = v.getZ();
        Double newX = z * Math.sin(angle) + x * Math.cos(angle);
        return newX;
    }

    private Double rotateDx(ArrowVector v, Double angle) {

        Double x = v.getdX();
        Double z = v.getdZ();
        Double newX = z * Math.sin(angle) + x * Math.cos(angle);
        return newX;
    }

    public void paint(Graphics g) {
        drawArrowVectors(g);
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }
}
