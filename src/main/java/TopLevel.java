import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class TopLevel {
//    static Logger logger = Logger.getLogger(TopLevel.class.getName());
    static Vectors accumulatedVectors = new Vectors(0);

    static VectorSphereDisplay vectorSphereDisplay = new VectorSphereDisplay(accumulatedVectors);

    public static void main(String[] args) throws InterruptedException {
        Vectors vectors = new Vectors(40);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                vectorSphereDisplay.setVectors(accumulatedVectors);
            }
        });


        int i = 0;
        do {
            TimeUnit.MILLISECONDS.sleep(100);
            i++;
            boolean nextGen = vectorSphereDisplay.getNextGeneration();
//            logger.info("NextGen: " + nextGen);

            if (nextGen || i == 1) {
                AdjustVectorsByRepulsion.moveThem(vectors);
                CopyAllVectorsToDisplayBlock.copyAllVectorsToDisplayBlock(vectors, accumulatedVectors);
            }
            int tempVectorCount =  vectorSphereDisplay.vectorCount();
            if (vectors.size()!=tempVectorCount){
                vectors = new Vectors(tempVectorCount);
                accumulatedVectors.clear();
            }
            vectorSphereDisplay.annotateTitle(Spread.minimumAngle(vectors).toString());
            vectorSphereDisplay.repaint();
        } while (true);
    }
}


