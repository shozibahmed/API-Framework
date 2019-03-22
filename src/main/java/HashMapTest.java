import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

    //A Map is an object that maps keys and values. A map cannot contain duplicate keys.
    //Three main implementations of map interfaces: Hasmap, treemap, and linkedhasmap.
    //Hasmap does not follow order
    //its not an order collection which means it does not return the keys and values in the same order in which they have been inserted into the hasmap
    public static void main(String[] args) {
        HasMap1();
        HasMap2();
        emptyMethod();
        CheckMap();
        copyMethod();
    }

    public static void HasMap1() {
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

        //Adding the elements Hapmap
        hmap.put(1, "abir");
        hmap.put(3, "yusuf");
        hmap.put(5, "Mim");
        hmap.put(2, "Arafat");
        hmap.put(40, "Munni");
        hmap.put(7, "mostafa");
//Getting a set of keys-values paris
        Set set = hmap.entrySet();
        //Obtaning an iterrator for the entry set
        Iterator itr = set.iterator();
        //while loop
        while (itr.hasNext()) {
            //
            Map.Entry map1 = (Map.Entry) itr.next();
            System.out.println("Key is: " + map1.getKey() + "&Value is: " + map1.getValue());
        }
    }

    public static void HasMap2() {
        System.out.println("**********************************");
        HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();
        hmap2.put(1, "abir");
        hmap2.put(5, "Mim");
        hmap2.put(2, "Arafat");
        hmap2.put(40, "Munni");
        hmap2.put(7, "mostafa");
        hmap2.put(0, "muktar");
        //for loop
        System.out.println("for loop");
        for (Map.Entry ab : hmap2.entrySet()) {
            System.out.println("Key: " + ab.getKey() + "& value: " + ab.getValue());

        }
        //While Loop
        System.out.println("While loop");
        Iterator itre = hmap2.entrySet().iterator();
        while (itre.hasNext()) {
            Map.Entry abc = (Map.Entry) itre.next();
            System.out.println("Key: " + abc.getKey() + " &value: " + abc.getValue());
        }
        Set set = hmap2.entrySet();
    }

    public static void emptyMethod() {
        System.out.println("**************************");
        HashMap<Integer, String> emp = new HashMap<Integer, String>();
        System.out.println("Is HasMap Empty  " + emp.isEmpty());
        emp.put(1, "abir");
        emp.put(5, "Mim");
        emp.put(2, "Arafat");
        emp.put(40, "Munni");
        emp.put(7, "mostafa");

        System.out.println("Is empty " + emp.isEmpty());
    }

    //Check if a particular key exits in hasmap
    public static void CheckMap() {

        HashMap<Integer, String> che = new HashMap<Integer, String>();
        che.put(1, "abir");
        che.put(5, "Mim");
        che.put(2, "Arafat");
        che.put(40, "Munni");
        che.put(7, "mostafa");

        System.out.println("*******Before Exit********");
        boolean ab = che.containsKey(5);
        System.out.println(ab);

        boolean ab1 = che.containsKey(2);
        System.out.println(ab1);

        boolean ab2 = che.containsKey(45);
        System.out.println(ab2);

        System.out.println("******After checking*******" + che);

    }

    public static void copyMethod() {
        System.out.println("****************************");
        HashMap<Integer, String> che = new HashMap<Integer, String>();
        che.put(1, "abir");
        che.put(5, "Mim");
        che.put(2, "Arafat");
        che.put(40, "Munni");
        che.put(7, "mostafa");

        Map<Integer, String> map2 = new HashMap<Integer, String>();
        map2.put(10, "ab");
        map2.put(8, "bc");

        //cpoying one hasmap to another hasmap
        //method: putAll()
        map2.putAll(che);
        // che.putAll(map2);
        System.out.println("Hasmap 2 contains: " + map2);

    }
}