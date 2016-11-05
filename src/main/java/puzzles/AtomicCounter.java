package puzzles;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    public int inc() {
        return counter.getAndIncrement();
    }
}
