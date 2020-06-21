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
        if (arrowVector == v2){
            return;
        }
        Double deltaX = v1X - v2.getX();
        Double deltaY = v1Y - v2.getY();
        Double deltaZ = v1Z - v2.getZ();
        Double scale = normalizeSize(deltaX, deltaY, deltaZ);
        dX += deltaX / scale;
        dY += deltaY / scale;
        dZ += deltaZ / scale;
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
}
