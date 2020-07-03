import java.awt.*;

public class DrawArrowVectorsAs2DProjections {

    static void drawArrowVectors(Graphics g, Vectors vectors, Double angle) {
        int headerWidth = 50;
        g.clearRect(0, 2*headerWidth, g.getClipBounds().width, g.getClipBounds().height);
        int length = (g.getClipBounds().width - headerWidth) / 5;

        for (ArrowVector v : vectors) {
            paintAsVector(g, headerWidth, length, v, angle);
        }
    }

    private static void paintAsVector(Graphics g, int headerWidth, int length, ArrowVector v, Double angle) {

        int centerX = length * 5/2 + headerWidth / 2;
        int centerY = length * 5/2 + headerWidth;
        Double rotatedX = rotate(v, angle);
        Double rotatedDx = rotateDx(v, angle);
        int x = (int) (rotatedX * length);
        int y = (int) (v.getY() * length);
        int dX = (int) (rotatedDx * length);
        int dY = (int) (v.getdY() * length);


        g.setColor(calculateColorForVector(v));
        g.drawLine(centerX, centerY, centerX + x, centerY + y);
        g.drawOval(centerX + x, centerY + y, 10, 10);
        g.drawLine(centerX + x, centerY + y, (int) (centerX + x + dX), (int) (centerY + y + dY));
        g.drawOval((int) (centerX + x + dX), (int) (centerY + y + dY), 5, 5);
    }

    static Color calculateColorForVector(ArrowVector v) {
        int colorRangeHalf = 128;
        int r = (int) (v.getX() * colorRangeHalf + colorRangeHalf);
        int g = (int) (v.getY() * colorRangeHalf + colorRangeHalf);
        int b = (int) (v.getZ() * colorRangeHalf + colorRangeHalf);
        return new Color(r, g, b);
    }

    static private Double rotate(ArrowVector v, Double angle) {

        Double x = v.getX();
        Double z = v.getZ();
        Double newX = z * Math.sin(angle) + x * Math.cos(angle);
        return newX;
    }

    static private Double rotateDx(ArrowVector v, Double angle) {

        Double x = v.getdX();
        Double z = v.getdZ();
        Double newX = z * Math.sin(angle) + x * Math.cos(angle);
        return newX;
    }
}