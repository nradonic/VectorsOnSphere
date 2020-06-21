import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrowVectorTest {
    int nonRandomSeed = 42;
    ArrowVector arrowVector = new ArrowVector(nonRandomSeed);

    @Test
    public void testNonRandomVector() {
        Assertions.assertEquals(0.6964162635506213, arrowVector.getX());
        Assertions.assertEquals(0.6539742849060032, arrowVector.getY());
        Assertions.assertEquals(0.2955029992129915, arrowVector.getZ());

    }

    @Test
    public void testInitializedVector() {
        ArrowVector arrowVector2 = new ArrowVector(1.0,2.0,3.0);

        Assertions.assertEquals(0.2672612419124244, arrowVector2.getX());
        Assertions.assertEquals(0.5345224838248488, arrowVector2.getY());
        Assertions.assertEquals(0.8017837257372732, arrowVector2.getZ());

    }

    @Test
    public void testDuplicatedVector() {
        ArrowVector arrowVector3 = new ArrowVector(arrowVector);

        Assertions.assertEquals(arrowVector.getX(), arrowVector3.getX());
        Assertions.assertEquals(arrowVector.getY(), arrowVector3.getY());
        Assertions.assertEquals(arrowVector.getZ(), arrowVector3.getZ());

    }


}