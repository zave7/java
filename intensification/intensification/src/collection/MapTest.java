package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("1", "test");
        map.put("1", "test2");
        map.put("2", "test3");
        map.put("3", "test4");
        map.put("4", "test5");


        System.out.println(map.size());
        System.out.println(map.get("1"));

        Set<String> keys = map.keySet();

        for( String str : keys) {
            System.out.println("iter : " + map.get(str));
        }

        Iterator<String> iter = keys.iterator();

        while( iter.hasNext()) {
            String key = iter.next();
            String s = map.get(key);
            System.out.println("iter : " + s);
        }
    }

}
