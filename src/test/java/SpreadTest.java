import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpreadTest {
    ArrowVector arrowVectorX = new ArrowVector(1.0, 0.0, 0.0);
    ArrowVector arrowVectorY = new ArrowVector(0.0, 1.0, 0.0);
    ArrowVector arrowVectorZ = new ArrowVector(0.0, 0.0, 1.0);
    ArrowVector arrowVectorMid = new ArrowVector(1.0, 1.0, 1.0);

    Vectors vectors = new Vectors(0);

    @BeforeEach
    void setUp() {

    }

    @Test
    public void lengthOne() {
        Double expected = 1.0;
        assertEquals(expected, Spread.norm(arrowVectorX));
        assertEquals(expected, Spread.norm(arrowVectorY));
        assertEquals(expected, Spread.norm(arrowVectorZ));
        assertTrue(Math.abs(expected - Spread.norm(arrowVectorMid)) < 0.00001);
    }

    @Test
    public void crossproductOne() {
        Double expected = 1.0;
        vectors.add(arrowVectorX);
        vectors.add(arrowVectorY);
        Double result = Spread.calculateMean(vectors);
        assertTrue(Math.abs(expected - result) < 0.00001);

        vectors.add(arrowVectorZ);
        result = Spread.calculateMean(vectors);
        assertTrue(Math.abs(expected - result) < 0.00001);


        vectors.add(arrowVectorMid);
        expected = 0.9082482904638631;
        result = Spread.calculateMean(vectors);
        assertTrue(Math.abs(expected - result) < 0.00001);

    }
}