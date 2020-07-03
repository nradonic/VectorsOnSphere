public class ArrowVectorCalculations {

    private Double dX = 0.0;
    private Double dY = 0.0;
    private Double dZ = 0.0;

    Double v1X = 0.0;
    Double v1Y = 0.0;
    Double v1Z = 0.0;

    private ArrowVector arrowVector;
    int collectionScaling = 0;

    ArrowVectorCalculations(ArrowVector v1, int collectionScaling) {
        arrowVector = v1;
        this.collectionScaling = collectionScaling;
    }

    public void calculateVectorCorrections(ArrowVector v2) {
        if (arrowVector == v2) {
            return;
        }

        ArrowVector diff = new ArrowVector(arrowVector, v2);

        ArrowVector inverseDifference = diff.getInverseNormalizedDifference();


        dX += inverseDifference.getX();
        dY += inverseDifference.getY();
        dZ += inverseDifference.getZ();
    }


    private Double normalizeSize(Double x, Double y, Double z) {
        Double k = x * x + y * y + z * z;
        return k * collectionScaling;
    }

    public ArrowVector getArrowVector() {
        return arrowVector;
    }

    public Double getdX() {
        return dX;
    }

    public Double getdY() {
        return dY;
    }

    public Double getdZ() {
        return dZ;
    }

    public ArrowVector unitDifferenceVector() {
        ArrowVector arrowVector = new ArrowVector(dX, dY, dZ);
        return arrowVector;
    }
}