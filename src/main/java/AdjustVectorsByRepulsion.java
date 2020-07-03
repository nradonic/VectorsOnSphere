import java.util.ArrayList;

public class AdjustVectorsByRepulsion {

    static Vectors vectors;
    static final Double scale = 0.10;

    public static void moveThem(Vectors vectors) {
        AdjustVectorsByRepulsion.vectors = vectors;
        ArrayList<ArrowVectorCalculations> arrowVectorCalculationsList = new ArrayList<>();

        for (ArrowVector v1 : AdjustVectorsByRepulsion.vectors) {
            arrowVectorCalculationsList.add(calculateForcing(v1));
        }

        for (ArrowVectorCalculations avc : arrowVectorCalculationsList) {
            ArrowVector unitDiff = avc.unitDifferenceVector();
            avc.getArrowVector().deltas(unitDiff.getX(), unitDiff.getY(), unitDiff.getZ());
            avc.getArrowVector().adjust(scale);

        }
    }

    private static ArrowVectorCalculations calculateForcing(ArrowVector v1) {
        ArrowVectorCalculations avc = new ArrowVectorCalculations(v1, AdjustVectorsByRepulsion.vectors.size());
        for (ArrowVector v2 : AdjustVectorsByRepulsion.vectors) {
            avc.calculateVectorCorrections(v2);
        }
        return avc;
    }

    public static void rotateAroundZ(Double angle) {
        if (vectors == null) {
            return;
        }
        for (ArrowVector av : vectors) {
            av.deltas(av.getZ() * Math.cos(angle), 0.0, -av.getX() * Math.sin(angle));
            av.adjust(scale);
        }
    }
}
