package session09;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

public class KeySetViewDemo {
    public static void main(String[] args) {
        Map<String, String>map = new ConcurrentHashMap<>();
        map.put("Java","Java");
        map.put("Java EE","Java EE");
        map.put("Spring","Spring");
        Set keySet = map.keySet();
        System.out.println(keySet);
    }
}
