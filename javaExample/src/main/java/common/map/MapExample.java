package common.map;

import java.util.*;

/**
 * Map:无序，key不可重复
 */
class MapTest{
    public void testMapCommon(){
        System.out.println("------------------------   testMapCommon   ------------------------");
        //Map<String, String> stringStringMap = new HashMap<>();
        //Map<String, String> stringStringMap = new Hashtable<>(); //线程安全
        Map<String, String> stringStringMap = new TreeMap<>();
        stringStringMap.put("k2", "v2"); //put方法返回值是对应k原始值，如果k原来不存在，返回null
        stringStringMap.put("k1", "v1");
        stringStringMap.put("k3", "v3");
        stringStringMap.put("k1", "v1_modify");//k1存在，覆盖原来的"v1"，并且返回k1键原来的值

        //
        Set<String> keysSet = stringStringMap.keySet();
        for (String key : keysSet){
            System.out.println(key + ":" + stringStringMap.get(key));
        }

        System.out.println("\n");
        stringStringMap.remove("k2");
        Set<Map.Entry<String, String>> entrys = stringStringMap.entrySet();
        for (Map.Entry<String, String> entry : entrys) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("\nstringStringMap.containsKey(\"k1\")--->" + stringStringMap.containsKey("k1"));
        System.out.println("stringStringMap.containsValue(\"v1_modify\")--->" + stringStringMap.containsValue("v1_modify"));
    }

    /**
     * HashMap的值和键都可以为null， 而Hashtable和TreeMap的值和键都不能为null
     */
    public void testDistinct(){
        System.out.println("\n------------------------   testAdd    ------------------------");


        //Map<String, String> stringStringMap = new Hashtable<>();  //Hashtable值和键都不能为null
        //Map<String, String> stringStringMap = new TreeMap<>();    //TreeMap值和键都不能为null
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put(null, null);
        System.out.println("stringStringMap.get(null)--->" + stringStringMap.get(null));
    }

    public void t2(){
        System.out.println("------------------------   testAdd    ------------------------");
    }
}

public class MapExample {
    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.testMapCommon();
        mapTest.testDistinct();

    }
}
