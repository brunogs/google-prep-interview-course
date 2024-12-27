package misc.binary_search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TimeMapSimplest {

    private Map<String, String[]> multimap;

    public TimeMapSimplest() {
        this.multimap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        String[] values = multimap.getOrDefault(key, new String[timestamp]);
        
        if (timestamp > values.length - 1) {
            values = Arrays.copyOf(values, timestamp);
        }
        values[timestamp-1] = value;

        multimap.put(key, values);
    }

    public String get(String key, int timestamp) {
        var values = multimap.get(key);
        if (values == null) {
            return "";
        }

        int last = values.length-1;
        if (last < timestamp) {
            return values[last];
        }

        if (values[timestamp-1] != null) {
            return values[timestamp-1];
        }

        // it works but is not so good
        for (int i = timestamp-1; i > 0; i--) {
            if (values[i] != null) {
                return values[i];
            }
        }

        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */