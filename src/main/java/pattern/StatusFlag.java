package pattern;

public class StatusFlag {
    volatile boolean stop;

    public void shutdown() {
        stop = true;
    }

    public void doWork() {
        while (!stop) {
            // do stuff
        }
    }
}
