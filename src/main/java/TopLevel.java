import java.util.concurrent.TimeUnit;

public class TopLevel {

    public static void main(String[] args) throws InterruptedException {
        VectorCollection vectorCollection = new VectorCollection(80);
        VectorSphereDisplay vectorSphereDisplay = new VectorSphereDisplay(vectorCollection);

        Double angle = 0.1;
        for (int i = 1; i<500; i++) {
            TimeUnit.MILLISECONDS.sleep(500);

            AdjustVectorsByRepulsion.rotateAroundZ(angle);

            AdjustVectorsByRepulsion.moveThem(vectorCollection);
            vectorSphereDisplay.repaint();

        }
    }
}


