package puzzles;

import java.util.LinkedList;
import java.util.List;

public class IsThisImmutable {
    private List<String> x = new LinkedList<>();
    private final int y;

    public IsThisImmutable() {
        x.add("foo");
        y = 2;
    }
}
