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
}