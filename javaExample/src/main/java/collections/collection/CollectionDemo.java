package collections.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单列集合Collection共有方法（List, Set, Deque）,以List接口的ArrayList为例
 *   int size();	获取集合大小
 *   boolean isEmpty();	判断是否为空
 *   boolean add(E var1);	向集合增加元素
 *   boolean addAll(Collection<? extends E> var1);	添加一个集合的全部元素
 *   boolean contains(Object v);	判断元素v是否包含在集合中
 *   boolean containsAll(Collection<?> var1);	判断是否包含另一个集合的元素
 *   Object[] toArray();	将集合转换为数组
 */
public class CollectionDemo {
    public void demo0(){
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

    }
}
