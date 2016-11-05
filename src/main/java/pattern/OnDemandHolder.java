package pattern;


public class OnDemandHolder {
    private static class LazyHolder {
        public final static OnDemandHolder instance = new OnDemandHolder();
    }

    public static OnDemandHolder getInstance() {
        return LazyHolder.instance;
    }
}
