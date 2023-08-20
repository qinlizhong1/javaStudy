package common.collection;

import java.util.*;

/**
 * Collection接口公共方法,以ArrayList为例
 */
class CollectionTest{
    public void testAdd(){
        System.out.println("------------------------   testAdd    ------------------------");
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        System.out.println("stringList--->" + stringList.toString());

        stringList.add(1, "c");//在index位置之前插入指定元素
        System.out.println("stringList.add(1, \"c\")--->" + stringList.toString());

        Set<String> stringSet = new HashSet<>();
        stringSet.add("1");
        stringSet.add("2");
        stringList.addAll(stringSet);
        System.out.println("stringList.addAll(stringSet)--->" + stringList.toString());

        stringList.addAll(2, stringSet);  //在index位置之前插入指定集合
        System.out.println("stringList.addAll(2, stringSet)--->" + stringList.toString());
    }

    public void testRemove(){
        System.out.println("\n------------------------   testRemove   ------------------------");
    }

    public void testSize(){
        System.out.println("\n------------------------   testSize   ------------------------");
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        System.out.println("stringList--->" + stringList.toString());
        System.out.println("stringList.size()--->" + stringList.size());//集合元素个数
        System.out.println("stringList.isEmpty()--->" + stringList.isEmpty());//判断集合是否为空

        stringList.clear(); //清空集合元素
        System.out.println("\nstringList.clear()之后：");
        System.out.println("stringList.size()--->" + stringList.size());
        System.out.println("stringList.isEmpty()--->" + stringList.isEmpty());
    }

    public void testIterator(){
        System.out.println("\n------------------------   testIterator   ------------------------");
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");

        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void testSearch(){
        System.out.println("\n------------------------   testSearch   ------------------------");
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("b");
        System.out.println("stringList--->" + stringList.toString());
        System.out.println("stringList.contains(\"a\")--->" + stringList.contains("a"));
        System.out.println("stringList.contains(\"1\")--->" + stringList.contains("1"));
    }

}


public class CollectionExample {
    public static void main(String[] args) {
        CollectionTest collectionTest = new CollectionTest();
        collectionTest.testAdd();
        collectionTest.testSize();
        collectionTest.testIterator();
        collectionTest.testSearch();
    }
}
