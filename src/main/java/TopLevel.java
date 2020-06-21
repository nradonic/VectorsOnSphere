import java.util.concurrent.TimeUnit;

public class TopLevel {

    public static void main(String[] args) throws InterruptedException {
        VectorCollection vectorCollection = new VectorCollection(800);
        VectorSphereDisplay vectorSphereDisplay = new VectorSphereDisplay(vectorCollection);

        for (int i = 1; i<500; i++) {
            TimeUnit.MILLISECONDS.sleep(500);

            AdjustVectorsByRepulsion.rotateAroundZ();
            AdjustVectorsByRepulsion.moveThem(vectorCollection);
            vectorSphereDisplay.repaint();

        }
    }

}


