import java.util.ArrayList;

public class Vectors extends ArrayList<ArrowVector> {

    Vectors(int i) {
        this.clear();
        for (int index = 0; index < i; index++) {
            this.add(new ArrowVector());
        }
    }

    Vectors(){
        this(0);
    }
}
