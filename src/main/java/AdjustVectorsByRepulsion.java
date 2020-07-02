import java.util.ArrayList;

public class AdjustVectorsByRepulsion {

    static Vectors vectors;

    public static void moveThem(Vectors vectors) {
        AdjustVectorsByRepulsion.vectors = vectors;
        ArrayList<ArrowVectorCalculations> arrowVectorCalculations = new ArrayList<>();

        for (ArrowVector v1 : AdjustVectorsByRepulsion.vectors) {
            ArrowVectorCalculations av = new ArrowVectorCalculations(v1, AdjustVectorsByRepulsion.vectors.size());
            for (ArrowVector v2 : AdjustVectorsByRepulsion.vectors) {
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
        if (vectors == null) {
            return;
        }
        for (ArrowVector av : vectors) {
            av.adjust(av.getZ() * Math.cos(angle), 0.0, -av.getX() * Math.sin(angle));
        }
    }
}
