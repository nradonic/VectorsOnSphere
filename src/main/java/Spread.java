public class Spread {
        public static Tuple2D minimumAngle(Vectors vectors) {

        Double minimumCP = 2 * Math.PI;
        Double maximumCP = 0.0;


        for (ArrowVector arrowVector1 : vectors) {
            minimumCP = 2 * Math.PI;
            for (ArrowVector arrowVector2 : vectors) {
                if (arrowVector1 == arrowVector2) {
                    continue;
                }
                Double cA = calculateAngle(arrowVector1, arrowVector2);
                minimumCP = Math.min(cA, minimumCP);
            }
            maximumCP = Math.max(minimumCP, maximumCP);
        }
        return new Tuple2D(180 * minimumCP / Math.PI, 180 * maximumCP / Math.PI);
    }

    private static Double calculateAngle(ArrowVector vector1, ArrowVector vector2) {

        double angle = Math.acos(dotProduct(vector1, vector2) / vector1.magnitude() / vector2.magnitude());
        return angle;
    }

    public static Double dotProduct(ArrowVector vector1, ArrowVector vector2) {
        return vector1.getX() * vector2.getX() + vector1.getY() * vector2.getY() + vector1.getZ() * vector2.getZ();
    }


    public static Double norm(ArrowVector arrowVector) {
        Double result = Math.sqrt(
                arrowVector.getX() * arrowVector.getX() +
                        arrowVector.getY() * arrowVector.getY() +
                        arrowVector.getZ() * arrowVector.getZ());

        return result;
    }
}
