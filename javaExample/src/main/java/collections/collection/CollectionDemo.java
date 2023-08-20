package collections.collection;

import java.util.*;

public class CollectionDemo {
    /**
     * Collection共有方法（List, Set, Deque）,以List接口的ArrayList为例
     *
     *   int size();	获取集合大小
     *   boolean isEmpty();	判断是否为空
     *   boolean add(E var1);	向集合增加元素
     *   boolean addAll(Collection<? extends E> var1);	添加一个集合的全部元素
     *   boolean remove(Object var1);	向集合移除元素
     *   boolean removeAll(Collection<?> var1);	删除一个集合的全部元素
     *   boolean contains(Object v);	判断元素v是否包含在集合中
     *   boolean containsAll(Collection<?> var1);	判断是否包含另一个集合的元素
     *   Object[] toArray();	将集合转换为数组
     *   void clear();	清空集合
     *   default Stream<E> stream();	转换为Stream流
     *   default Stream<E> parallelStream();	转换为Stream并行流
     */
    public void CollectionCommomMethod(){
        System.out.println("-----------------------------------   Collection接口方法  ----------------------------------- ");
        List<String> stringList = new ArrayList<>();

        stringList.add("1");
        stringList.add("2");
        stringList.add("1");

        Set<String> stringSet = new HashSet<>();
        stringSet.add("4");
        stringSet.add("5");

        stringList.addAll(stringSet);
        int size = stringList.size();
        System.out.println("【1】size():" + size);
        System.out.println("【2】isEmpty():" + stringList.isEmpty());
        System.out.println("【3】contains(\"4\"):" + stringList.contains("4"));


        Set<String> stringSetTmp = new HashSet<>();
        stringSetTmp.add("2");
        stringSetTmp.add("5");
        System.out.println("【4】contains(stringSetTmp):" + stringList.containsAll(stringSetTmp));
        System.out.println("【5】contains(stringSet):" + stringList.containsAll(stringSet));

        Object[] strings = stringList.toArray();
        System.out.println("【6】strings:" + strings);

        stringList.removeAll(stringSetTmp);
        System.out.println("【7】stringList:" + stringList);

        //只会删除第一个指定的元素
        stringList.remove("1");
        System.out.println("【8】stringList:" + stringList);

        stringList.clear();
        System.out.println("【9】stringList:" + stringList);

    }

    /**
    * List共有方法,以List接口的ArrayList为例
     *
    *  void add(int index, E element)：将指定的元素插入此列表中的指定位置（可选操作）。
    *  boolean addAll(int index, Collection<? extends E> c)：将指定集合中的所有元素插入到此列表中的指定位置。
    *  E get(int index)：返回此列表中指定位置的元素。
    *  int indexOf(Object o)：返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素，则返回-1。
    *  int lastIndexOf(Object o)：返回此列表中指定元素的最后一次出现的索引，如果此列表不包含元素，则返回-1。
    *  E remove(int index)：删除该列表中指定位置的元素（可选操作）,返回值为删除的元素
    *  E set(int index, E element)：用指定的元素（可选操作）替换此列表中指定位置的元素。
    *  List subList(int fromIndex, int toIndex)：返回从fromIndex到toIndex位置上的子集合。[fromIndex, toIndex)
    */
    public void ListCommomMethod(){
        System.out.println("\n-----------------------------------   List接口方法  ----------------------------------- ");
        List<String> stringList = new ArrayList<>();

        stringList.add("1");
        stringList.add("2");
        stringList.add("3");

        stringList.add(2, "a");
        System.out.println("【1】stringList:" + stringList);

        Set<String> stringSetTmp = new HashSet<>();
        stringSetTmp.add("b");
        stringSetTmp.add("c");
        stringSetTmp.add("a");
        stringList.addAll(1, stringSetTmp);
        System.out.println("【2】stringList:" + stringList);

        System.out.println("【3】stringList.get(2):" + stringList.get(2));
        System.out.println("【4】stringList.indexOf(\"a\"):" + stringList.indexOf("a"));
        System.out.println("【5】stringList.lastIndexOf(\"a\"):" + stringList.lastIndexOf("a"));

        String resRemove = stringList.remove(3);
        System.out.println("【6】stringList:" + stringList + " , resRemove:" + resRemove);

        String resSet = stringList.set(5, "x");
        System.out.println("【7】stringList:" + stringList + " , resSet:" + resSet);




        List<String> subList = stringList.subList(2, 4);
        System.out.println("【9】subList:" + subList);

        stringList.forEach((s) -> System.out.println(s));
    }


    /**
     * Set共有方法,以List接口的ArrayList为例
     *
     *  void add(int index, E element)：将指定的元素插入此列表中的指定位置（可选操作）。
     *  boolean addAll(int index, Collection<? extends E> c)：将指定集合中的所有元素插入到此列表中的指定位置。
     *  E get(int index)：返回此列表中指定位置的元素。
     *  int indexOf(Object o)：返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素，则返回-1。
     *  int lastIndexOf(Object o)：返回此列表中指定元素的最后一次出现的索引，如果此列表不包含元素，则返回-1。
     *  E remove(int index)：删除该列表中指定位置的元素（可选操作）,返回值为删除的元素
     *  E set(int index, E element)：用指定的元素（可选操作）替换此列表中指定位置的元素。
     *  List subList(int fromIndex, int toIndex)：返回从fromIndex到toIndex位置上的子集合。[fromIndex, toIndex)
     */
    public void SetCommomMethod() {
        System.out.println("\n-----------------------------------   Set接口方法  ----------------------------------- ");
        Set<String> stringSet = new HashSet<>();


    }


    /**
     * HashSet方法
     *
     *  void add(int index, E element)：将指定的元素插入此列表中的指定位置（可选操作）。
     *  boolean addAll(int index, Collection<? extends E> c)：将指定集合中的所有元素插入到此列表中的指定位置。
     *  E get(int index)：返回此列表中指定位置的元素。
     *  int indexOf(Object o)：返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素，则返回-1。
     *  int lastIndexOf(Object o)：返回此列表中指定元素的最后一次出现的索引，如果此列表不包含元素，则返回-1。
     *  E remove(int index)：删除该列表中指定位置的元素（可选操作）,返回值为删除的元素
     *  E set(int index, E element)：用指定的元素（可选操作）替换此列表中指定位置的元素。
     *  List subList(int fromIndex, int toIndex)：返回从fromIndex到toIndex位置上的子集合。[fromIndex, toIndex)
     */
    public void HashSetMethod() {
        System.out.println("\n-----------------------------------   Set接口方法  ----------------------------------- ");
        Set<String> stringSet = new HashSet<>();
        //stringSet.

    }
}
