import java.util.Random;

public class ArrowVector {

    static int seed = 42;
    private Double x;
    private Double y;
    private Double z;

    static Random random = new Random(seed);

    public ArrowVector() {
        generateRandomXYZ();
    }

    private void generateRandomXYZ() {
        Double xTemp = random.nextDouble() * 2 - 1;
        Double yTemp = random.nextDouble() * 2 - 1;
        Double zTemp = random.nextDouble() * 2 - 1;
        Double scale = normalizeSize(xTemp, yTemp, zTemp);
        x = xTemp / scale;
        y = yTemp / scale;
        z = zTemp / scale;
    }

    private Double normalizeSize(Double x, Double y, Double z) {
        Double k = x * x + y * y + z * z;
        return Math.sqrt(k);
    }

    ArrowVector(int seed) {
        this.seed = seed;
        random = new Random(seed);
        generateRandomXYZ();
    }

    ArrowVector(Double x, Double y, Double z) {
        Double scale = normalizeSize(x, y, z);
        this.x = x / scale;
        this.y = y / scale;
        this.z = z / scale;
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

    ArrowVector(ArrowVector oldArrowVector) {
        this.x = oldArrowVector.getX();
        this.y = oldArrowVector.getY();
        this.z = oldArrowVector.getZ();
    }

    public void adjust(Double dx, Double dy, Double dz) {
        Double k = 0.1;
        Double xTemp = x + dx * k;
        Double yTemp = y + dy * k;
        Double zTemp = z + dz * k;
        Double scale = normalizeSize(xTemp, yTemp, zTemp);
        x = xTemp / scale;
        y = yTemp / scale;
        z = zTemp / scale;
    }

    public ArrowVector(ArrowVector v1, ArrowVector v2) {
        x = v1.getX() - v2.getX();
        y = v1.getY() - v2.getY();
        z = v1.getZ() - v2.getZ();
    }

    public ArrowVector getInverseNormalizedDifference() {
        Double k = normalizeSize(x, y, z);
        if (k != 0.0 && x != 0.0) {
            x = x / k;
        }
        if (k != 0.0 && y != 0.0) {
            y = y / k;
        }
        if (k != 0.0 && z != 0.0) {
            z = z / k;
        }
        return this;
    }
}