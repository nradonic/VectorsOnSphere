import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TopLevel {
    static Logger logger = Logger.getLogger(TopLevel.class.getName());

    public static void main(String[] args) throws InterruptedException {
        Vectors vectors = new Vectors(100);
        Vectors accumulatedVectors = new Vectors(0);

        VectorSphereDisplay vectorSphereDisplay = new VectorSphereDisplay(accumulatedVectors);
        Double angle = 0.1;
        int i = 0;
        do {
            TimeUnit.MILLISECONDS.sleep(200);
            i++;
            boolean nextGen = vectorSphereDisplay.getNextGeneration();
//            logger.info("NextGen: " + nextGen);

            if (nextGen || i==1) {
                AdjustVectorsByRepulsion.moveThem(vectors);
                copyAllVectorsToDisplayBlock(vectors, accumulatedVectors);
            }
            vectorSphereDisplay.setRotation(vectorSphereDisplay.rotation);
            vectorSphereDisplay.annotateTitle(Spread.minimumAngle(vectors).toString());
            vectorSphereDisplay.repaint();
        } while (true);
    }

    private static void copyAllVectorsToDisplayBlock(Vectors v1, Vectors v2) {
        for (ArrowVector arrowVector : v1) {
            ArrowVector arrowVector1 = new ArrowVector(arrowVector);
            arrowVector1.deltas(arrowVector.getdX(), arrowVector.getdY(), arrowVector.getdZ());
            v2.add(arrowVector1);
        }
        if (v2.size() > 50 * v1.size()) {
            int k = (int) Math.min(v1.size(), v2.size());
            for (int i = 0; i < k; i++) {
                v2.remove(0);
            }
        }
    }
}


