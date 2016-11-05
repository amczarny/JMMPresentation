package pattern;

public class CheapReadWriteLock {
    private volatile int value;

    public int getValue() { return value; }

    public synchronized int increment() {
        return value++;
    }
}
