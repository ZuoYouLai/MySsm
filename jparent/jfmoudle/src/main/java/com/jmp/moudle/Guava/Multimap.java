package com.jmp.moudle.Guava;


        import com.google.common.collect.ArrayListMultimap;
        import com.google.common.collect.ListMultimap;

        import java.util.Map;

/**
 *  最常使用的是ListMultimap 和 SetMultimap, keys分别map到List和Set
 *  当我们的数据结构为:
 *      Map<String,List<T> 进行插入初始化判断是一件比较麻烦的事情,用guava这个数据结构可以解决这个初始化的操作
 *
 *      Api :
         put(K, V)：添加键到单个值的映射
         putAll(K, Iterable<V>)：依次添加键到多个值的映射
         remove(K, V)：移除键到值的映射；如果有这样的键值并成功移除，返回true
         removeAll(K)：清除键对应的所有值，返回的集合包含所有之前映射到K的值，但修改这个集合就不会影响Multimap了
         replaceValues(K, Iterable<V>)：清除键对应的所有值，并重新把key关联到Iterable中的每个元素。返回的集合包含所有之前映射到K的值
 *
 */
public class Multimap {

    public static void main(String[] args) {
        ListMultimap<String, String> listMultimap = ArrayListMultimap.create();

        for(int k=0;k<10;k++) {
            listMultimap.put("No.1", "k" + k);
        }

        for (int z=0;z<5;z++) {
            listMultimap.put("No.2", "z" + z);
        }

        //遍历的操作
        for (Map.Entry<String, String> entry : listMultimap.entries()) {
            System.err.println("key = "+entry.getKey()+"  --->  value = "+entry.getValue());
        }

        //判断键是否存在
        if (listMultimap.containsKey("No.2")) {
            System.err.println("键值包含 : No.2");
        }

        //”键-单个值映射”的个数
        System.err.println(listMultimap.size());

        //不同键的个数
        System.err.println(listMultimap.keySet().size());

    }
}
