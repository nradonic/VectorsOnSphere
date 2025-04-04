import java.util.Random;

public class ArrowVector {

    static int seed = 42;
    int age = 0;
    private Double x = 0.0;
    private Double y = 0.0;
    private Double z = 0.0;

    private Double dX = 0.0;
    private Double dY = 0.0;
    private Double dZ = 0.0;

    static Random random = new Random(seed);

    public ArrowVector() {
        generateRandomXYZ();
    }

    public ArrowVector(int seed) {
        random = new Random(seed);
        generateRandomXYZ();
    }

    public ArrowVector(Double x, Double y, Double z) {
        Double scale = magnitude(x, y, z);
        this.x = x / scale;
        this.y = y / scale;
        this.z = z / scale;
    }

    public ArrowVector(ArrowVector oldArrowVector) {
        this(oldArrowVector.getX(), oldArrowVector.getY(), oldArrowVector.getZ());
        this.dX = oldArrowVector.getdX();
        this.dY = oldArrowVector.getdY();
        this.dZ = oldArrowVector.getdZ();
        this.age = 0;
    }

    public ArrowVector(ArrowVector v1, ArrowVector v2) {
        this(v1.getX() - v2.getX(), v1.getY() - v2.getY(), v1.getZ() - v2.getZ());
    }

    private void generateRandomXYZ() {
        double bias = 5.0;
        Double xTemp = random.nextDouble() * 2 - 1 + bias;
        Double yTemp = random.nextDouble() * 2 - 1 + bias;
        Double zTemp = random.nextDouble() * 2 - 1 + bias;
        Double scale = magnitude(xTemp, yTemp, zTemp);
        x = xTemp / scale;
        y = yTemp / scale;
        z = zTemp / scale;
    }

    private Double magnitude(Double x, Double y, Double z) {
        double k = x * x + y * y + z * z;
        return Math.sqrt(k);
    }

    public Double magnitude() {
        double k = x * x + y * y + z * z;
        return Math.sqrt(k);
    }

    public Double getY() {
        return y;
    }

    public Double getX() {
        return x;
    }

    public Double getZ() {
        return z;
    }

    public void deltas(Double dx, Double dy, Double dz) {
        dX = dx;
        dY = dy;
        dZ = dz;
    }

    public void adjust(Double scale) {

        Double xTemp = x + dX * scale;
        Double yTemp = y + dY * scale;
        Double zTemp = z + dZ * scale;
        Double normalize = magnitude(xTemp, yTemp, zTemp);
        x = xTemp / normalize;
        y = yTemp / normalize;
        z = zTemp / normalize;
    }

    public ArrowVector getInverseNormalizedDifference() {
        Double k = magnitude(x, y, z);
        if (k != 0.0 && x != 0.0) {
            x = x / k/k;
        }
        if (k != 0.0 && y != 0.0) {
            y = y / k/k;
        }
        if (k != 0.0 && z != 0.0) {
            z = z / k/k;
        }
        return this;
    }

    public boolean ageEqZero(){
        return age == 0;
    }

    public void ageSetGTZero(){
        age = 1;
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