//Todo: HASHMAPS

import java.util.*;

public class HashMapsexample {
    public static void main(String[] args) {

        //~ Hashmaps are used to store key-value pairs
        //! It is a dynamic data structure which stores data in a key-value pair
        //* Hashmap<Key, Value>
            
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);

        System.out.println(map);
        System.out.println(map.get("one"));

        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        map.remove("two");
        System.out.println(map);
        System.out.println(map.containsKey("one"));
        System.out.println(map.containsValue(1));

        map.clear();
        System.out.println(map);
        System.out.println(map.isEmpty());
        System.out.println(map.containsKey("one"));
        System.out.println(map.containsValue(1));
        System.out.println(map.size());

    }
}