import java.util.concurrent.TimeUnit;

public class TopLevel {

    public static void main(String[] args) throws InterruptedException {
        Vectors vectors = new Vectors(50);
        Vectors accumulatedVectors = new Vectors(0);

        VectorSphereDisplay vectorSphereDisplay = new VectorSphereDisplay(accumulatedVectors);
        Double angle = 0.0;
        for (int i = 1; i < 1000; i++) {
            TimeUnit.MILLISECONDS.sleep(100);

            AdjustVectorsByRepulsion.rotateAroundZ(angle);

            AdjustVectorsByRepulsion.moveThem(vectors);
            Double minimumAngle = Spread.minimumAngle(vectors);
            copyAllVectorsToDisplayBlock(vectors, accumulatedVectors);
            vectorSphereDisplay.annotateTitle(minimumAngle.toString());
            vectorSphereDisplay.repaint();

        }
    }

    private static void copyAllVectorsToDisplayBlock(Vectors v1, Vectors v2) {
        for (ArrowVector arrowVector : v1) {
            v2.add(new ArrowVector(arrowVector));
        }
        if (v2.size() > 20 * v1.size()) {
            int k = (int) Math.min(v1.size(), v2.size());
            for (int i = 0; i < k; i++) {
                v2.remove(0);
            }
        }
    }
}


