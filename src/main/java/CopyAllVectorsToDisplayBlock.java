public class CopyAllVectorsToDisplayBlock {

    static void copyAllVectorsToDisplayBlock(Vectors v1, Vectors v2) {
        for (ArrowVector arrowVector : v1) {
            ArrowVector arrowVector1 = new ArrowVector(arrowVector);
            arrowVector1.deltas(arrowVector.getdX(), arrowVector.getdY(), arrowVector.getdZ());
            v2.add(arrowVector1);
        }
        if (v2.size() > 50 * v1.size()) {
            int k = (int) Math.min(v1.size(), v2.size());
            for (int i = 0; i < k; i++) {
                v2.remove(0);
            }
        }
    }
}
