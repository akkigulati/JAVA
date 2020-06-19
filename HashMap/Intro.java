import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap < String, Integer > ht = new HashMap < > ();
        ht.put("India", 135);
        ht.put("Pak", 35);
        ht.put("sl", 15);
        ht.put("china", 150);
        ht.put("ban", 45);
        System.out.println(ht.get("nepal"));
        System.out.println(ht.get("India"));
        ht.put("nepal", 20);
        System.out.println(ht.get("nepal"));
        ht.put("India", 140);
        System.out.println(ht.get("India"));
        System.out.println(ht.values());

        System.out.println(ht.containsKey("India"));
        System.out.println(ht.containsKey("China"));

        System.out.println(ht);
        System.out.println(ht.containsValue(135));

        for (String key: ht.keySet()) {
            System.out.println(key + " = " + ht.get(key));
        }
    }
}