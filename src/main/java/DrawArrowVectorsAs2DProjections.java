import java.awt.*;

public class DrawArrowVectorsAs2DProjections {

    static void drawArrowVectors(Graphics g, Vectors vectors) {
        g.clearRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
        int headerWidth = 30;
        int length = (g.getClipBounds().width - headerWidth) / 2;

        for (ArrowVector v : vectors) {
            paintAsVector(g, headerWidth, length, v);
        }
    }

    private static void paintAsVector(Graphics g, int headerWidth, int length, ArrowVector v) {
//        if (v.getZ() > 0) {
            int centerX = length + headerWidth / 2;
            int centerY = length + headerWidth;
            int x = (int) (v.getX() * length);
            int y = (int) (v.getY() * length);
            g.setColor(calculateColorForVector(v));
            g.drawLine(centerX, centerY, centerX + x, centerY + y);
            g.drawOval(centerX + x, centerY + y, 10, 10);
//        }
    }

    static Color calculateColorForVector(ArrowVector v) {
        int colorRangeHalf = 128;
        int r = (int) (v.getX() * colorRangeHalf + colorRangeHalf);
        int g = (int) (v.getY() * colorRangeHalf + colorRangeHalf);
        int b = (int) (v.getZ() * colorRangeHalf + colorRangeHalf);
        if (v.getZ() < 0) {
            r = 0;
            g = 0;
            b = 0;
        }
        return new Color(r, g, b);
    }
}