import javax.swing.*;

//    static Logger logger = Logger.getLogger(TopLevel.class.getName());
static Vectors accumulatedVectors = new Vectors(0);

static VectorSphereDisplay vectorSphereDisplay = new VectorSphereDisplay(accumulatedVectors);

public static void main(String[] args) throws InterruptedException {
    Vectors vectors = new Vectors(40);
    SwingUtilities.invokeLater(() -> vectorSphereDisplay.setVectors(accumulatedVectors));


    int i = 0;
    do {
        vectorSphereDisplay.setIgnoreRepaint( true ) ;
        TimeUnit.MILLISECONDS.sleep(100);
        i++;
        boolean nextGen = vectorSphereDisplay.getNextGeneration();
//            logger.info("NextGen: " + nextGen);

        if (nextGen || i == 1) {
            AdjustVectorsByRepulsion.moveThem(vectors);
            CopyAllVectorsToDisplayBlock.copyAllVectorsToDisplayBlock(vectors, accumulatedVectors);
        }
        int tempVectorCount = vectorSphereDisplay.vectorCount();
        if (vectors.size() != tempVectorCount) {
            vectors = new Vectors(tempVectorCount);
            accumulatedVectors.clear();
        }
        Tuple2D k = Spread.minimumAngle(vectors);
        vectorSphereDisplay.annotateTitle(String.format("%3.3f", k.one()) + " : " + String.format("%3.3f", k.two()));
        vectorSphereDisplay.setIgnoreRepaint( false ) ;
        vectorSphereDisplay.repaint();
    } while (true);
}


