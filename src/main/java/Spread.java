public class Spread {
    public static Double calculateMean(Vectors vectors) {

        Double sumCPs = 0.0;

        for (ArrowVector arrowVector1 : vectors) {
            for (ArrowVector arrowVector2 : vectors) {
                if (arrowVector1 == arrowVector2) {
                    continue;
                }
                sumCPs += crossProduct(arrowVector1, arrowVector2);
            }
        }
        Double meanAngle = Math.acos(sumCPs / (vectors.size() - 1) / vectors.size());
        return meanAngle;
    }


    public static Double minimumAngle(Vectors vectors) {

        Double minimumCP = 1.0;

        for (ArrowVector arrowVector1 : vectors) {
            for (ArrowVector arrowVector2 : vectors) {
                if (arrowVector1 == arrowVector2) {
                    continue;
                }
                minimumCP = Math.min(
                        crossProduct(arrowVector1, arrowVector2),
                        minimumCP);
            }
        }
        return minimumCP;
    }


    public static Double crossProduct(ArrowVector arrowVectorA, ArrowVector arrowVectorB) {

        Double x = (arrowVectorA.getY() * arrowVectorB.getZ() -
                arrowVectorA.getZ() * arrowVectorB.getY());

        Double y = (arrowVectorA.getZ() * arrowVectorB.getX() -
                arrowVectorA.getX() * arrowVectorB.getZ());

        Double z = (arrowVectorA.getX() * arrowVectorB.getY() -
                arrowVectorA.getY() * arrowVectorB.getX());

        Double result = Math.sqrt(x * x + y * y + z * z);

        return result;
    }

    public static Double norm(ArrowVector arrowVector) {
        Double result = Math.sqrt(
                arrowVector.getX() * arrowVector.getX() +
                        arrowVector.getY() * arrowVector.getY() +
                        arrowVector.getZ() * arrowVector.getZ());

        return result;
    }
}
