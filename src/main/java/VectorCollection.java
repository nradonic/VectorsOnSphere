import java.util.ArrayList;

public class VectorCollection extends ArrayList<ArrowVector> {

    VectorCollection(int i) {
        for (int index = 0; index < i; index++) {
            this.add(new ArrowVector());
        }
        int a = 1;
    }
}
