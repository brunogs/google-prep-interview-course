package misc.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

record Data(String val, int time){}

public class TimeMap {

    private Map<String, List<Data>> multimap;

    public TimeMap() {
        this.multimap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Data> values = multimap.getOrDefault(key, new ArrayList<>());
        values.add(new Data(value, timestamp));
        multimap.put(key, values);
    }

    /*
    the expected approach using a binary search
    the tricky is not to use the list index as the timestamp as I did
    instead we create sequential items in the list and then apply a binary search and store the values with timestamp lower or equal
     */
    public String get(String key, int timestamp) {
        var values = multimap.get(key);
        if (values == null) {
            return "";
        }

        int last = values.size()-1;

        int start = 0; //0
        int end = last; //14

        Integer greater = null;

        while (start <= end) {
            int middle = (start + end) / 2; //7

            if (values.get(middle).time() <= timestamp) {
                greater = greater == null ? middle : Math.max(greater, middle);
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        if (greater != null) {
            return values.get(greater).val();
        }
        return "";
    }
}
