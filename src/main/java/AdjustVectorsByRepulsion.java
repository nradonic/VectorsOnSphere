import java.util.ArrayList;

public class AdjustVectorsByRepulsion {

    static VectorCollection vectorCollection;

    public static void moveThem(VectorCollection vectors) {
        vectorCollection = vectors;
        ArrayList<ArrowVectorCalculations> arrowVectorCalculations = new ArrayList<>();

        for (ArrowVector v1 : vectorCollection) {
            ArrowVectorCalculations av = new ArrowVectorCalculations(v1, vectorCollection.size());
            for (ArrowVector v2 : vectorCollection) {
                av.calculateVectorCorrections(v2);
            }
            arrowVectorCalculations.add(av);
        }

        for (ArrowVectorCalculations avc : arrowVectorCalculations) {
            avc.getArrowVector().adjust(avc.getdX(), avc.getdY(), avc.getdZ());
        }
        int a = 1;
    }

    public static void rotateAroundZ(Double angle){
        if (vectorCollection == null) {
            return;
        }
        for (ArrowVector av : vectorCollection) {
            av.adjust(av.getZ() * Math.cos(angle), 0.0, -av.getX() * Math.sin(angle));
        }
    }
}
