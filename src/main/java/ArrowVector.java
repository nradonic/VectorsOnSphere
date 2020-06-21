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

    public void adjust(Double dx, Double dy, Double dz){
        Double xTemp = x+dx;
        Double yTemp = y+dy;
        Double zTemp = z+dz;
        Double scale = normalizeSize(xTemp, yTemp, zTemp);
        x = xTemp / scale;
        y = yTemp / scale;
        z = zTemp / scale;
    }
}
