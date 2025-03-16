public class CopyAllVectorsToDisplayBlock {
    static int maxBufferDepth = 49;

    static void copyAllVectorsToDisplayBlock(Vectors currentAV, Vectors accumulatedAV) {
        boolean clipBuffer = accumulatedAV.size() > maxBufferDepth * currentAV.size();
        agePreviousVectors(currentAV, accumulatedAV);

        for (ArrowVector arrowVector : currentAV) {
            ArrowVector arrowVector1 = new ArrowVector(arrowVector);
            accumulatedAV.add(arrowVector1);
            if (clipBuffer) {
                accumulatedAV.removeFirst();
            }
        }
    }

    static void agePreviousVectors(Vectors currentAV, Vectors accumulatedAV) {
        for (int indexAV = accumulatedAV.size() - 1;
             indexAV >= Math.max(accumulatedAV.size() - currentAV.size() - 1, 0);
             indexAV--) {
            accumulatedAV.get(indexAV).ageSetGTZero();
        }
    }
}
