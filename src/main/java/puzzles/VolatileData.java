package puzzles;

import java.util.LinkedHashMap;
import java.util.Map;

public class VolatileData {

    private volatile Map<String,String> map = new LinkedHashMap<>();
    public VolatileData() {
        map.put("A", "a");
    }

    public String get(String key) {
        return map.get(key);
    }

}
