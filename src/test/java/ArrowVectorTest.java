import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrowVectorTest {
    int nonRandomSeed = 42;
    ArrowVector arrowVector = new ArrowVector(nonRandomSeed);

    @Test
    public void testNonRandomVector() {
        ArrowVector arrowVector = new ArrowVector(nonRandomSeed);
        var k = arrowVector.magnitude();
        Assertions.assertEquals(1.0, k, 0.00000001);
    }

    @Test
    public void testInitializedVector() {
        ArrowVector arrowVector2 = new ArrowVector(1.0, 2.0, 3.0);

        Assertions.assertEquals(0.2672612419124244, arrowVector2.getX(), 0.00000001);
        Assertions.assertEquals(0.5345224838248488, arrowVector2.getY(), 0.00000001);
        Assertions.assertEquals(0.8017837257372732, arrowVector2.getZ(), 0.00000001);

    }

    @Test
    public void testDuplicatedVector() {
        ArrowVector arrowVector3 = new ArrowVector(arrowVector);

        Assertions.assertEquals(arrowVector.getX(), arrowVector3.getX(), 0.00000001);
        Assertions.assertEquals(arrowVector.getY(), arrowVector3.getY(), 0.00000001);
        Assertions.assertEquals(arrowVector.getZ(), arrowVector3.getZ(), 0.00000001);

    }


}