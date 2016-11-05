package puzzles;

import java.util.LinkedHashMap;
import java.util.Map;

public class VolatileCache {
    private volatile Map<String, String> map;

    public VolatileCache() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("A", "a");
        this.map = map;
    }

    public String get(String key) {
        return map.get(key);
    }
}
