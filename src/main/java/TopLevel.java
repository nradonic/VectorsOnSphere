import java.util.concurrent.TimeUnit;

public class TopLevel {

    public static void main(String[] args) throws InterruptedException {
        Vectors vectors = new Vectors(128);
        VectorSphereDisplay vectorSphereDisplay = new VectorSphereDisplay(vectors);

        Double angle = 0.1;
        for (int i = 1; i<500; i++) {
            TimeUnit.MILLISECONDS.sleep(500);

            AdjustVectorsByRepulsion.rotateAroundZ(angle);

            AdjustVectorsByRepulsion.moveThem(vectors);
            Double minimumAngle = Spread.minimumAngle(vectors);
            vectorSphereDisplay.annotateTitle(minimumAngle.toString());
            vectorSphereDisplay.repaint();

        }
    }
}


