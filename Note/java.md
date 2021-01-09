# java

## java数组初始化

```java
//动态初始化
int[] arr = new int[3];
//静态初始化
int[] arr = {1, 2, …};
//完整格式初始化(推荐)
int[] arr = new int[]{1, 2, …};
// int[] arr = new int[3]{1, 2, 3};   错误，不是java语句
```

## java switch语句实现

switch语句底层实现用的是跳转表。跳转表是一个映射表，存储了可能的值以及要跳转到的地址，所以执行语句的时候直接找到对应的语句，执行相应代码块，与语句的声明顺序没有任何关系

```java
    int type = 9;
    switch (type) {
        default:
            System.out.println("default");
            break;
        case 0:
            System.out.println("case 0");
            break;
        case 1:
            System.out.println("case 1");
            break;
        //  如果有case 9语句，则输出为"case 9"
        /*    case 9:
            System.out.println("case 9");
            break;*/
        case 10:
            System.out.println("case 10");
            break;
    }
    // 没有case 9语句，则输出为"default"
    // 如果default没有break，则继续执行，接着输出,直到遇到break，也就是输出"default case 0"
```

## AtomicInteger

高并发的情况下，i++无法保证原子性，往往会出现问题，所以引入AtomicInteger类，保证原子操作。

```java
    AtomicInteger atomicInteger = new AtomicInteger(1);
    System.out.println(atomicInteger.getAndIncrement());  //输出1，先get再自增
    System.out.println(atomicInteger.incrementAndGet()); //输出3，先自增再get
```

## List<Integer>、Integer[]、int[] 转换

```java
    int[] data = {4,5,6,7,8};

    // int[]转List<Integer>
    List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());

    // int[]转Integer[]
    Integer[] integers1 = Arrays.stream(data).boxed().toArray(Integer[]::new);

    //List<Integer> 转int[]
    int[] arr1 = list1.stream().mapToInt(Integer::intValue).toArray();

    //List<Integer> 转Integer[]
    Integer[] integers2 = list1.toArray(new Integer[0]);

    //Integer[] 转int[]
    int[] arr2 = Arrays.stream(integers1).mapToInt(Integer::intValue).toArray();

    //Integer[] 转 List<Integer>
    List<Integer> list2 = Arrays.asList(integers1);
```

## int 数组逆序排序

```java
    //法1
    List<Integer> tmp = Arrays.stream(nums).boxed().collect(Collectors.toList());
    tmp.sort(Comparator.reverseOrder());
    //list.sort(Comparator.comparingInt(Integer::intValue).reversed());
    //personList.sort(Comparator.comparingInt(Person::getAge));
    int[] newNums = tmp.stream().mapToInt(i->i).toArray();

    //法2 低效
    List<Integer> tmp = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
    Collections.reverse(tmp);
    int[] newNums = tmp.stream().mapToInt(i->i).toArray();
```


## java包装类型缓存

Boolean：(全部缓存)

Byte：(全部缓存)

Character(<= 127缓存)

Short(-128 — 127缓存)

Long(-128 — 127缓存)

Float(没有缓存)

Doulbe(没有缓存)

```java
        System.out.println(Integer.valueOf("127")==Integer.valueOf("127"));  //true
        System.out.println(Integer.valueOf("128")==Integer.valueOf("128"));  //false

        System.out.println(Integer.valueOf("-128")==Integer.valueOf("-128"));  //true
        System.out.println(Integer.valueOf("-129")==Integer.valueOf("-129"));  //false
```

## Array、Arrays

## Collection

collection

```text
Collection      接口的接口  对象的集合
    List    子接口  按进入先后有序保存  可重复
        LinkedList  接口实现类  链表  插入删除  没有同步  线程不安全
        ArrayList   接口实现类  数组  随机访问  没有同步  线程不安全
        Vector      接口实现类  数组            同步     线程安全
            Stack
    Set     子接口  仅接收一次，并做内部排序，值不能重复
        HashSet
        LinkedHashSet
        TreeSet
```

Java 集合中的Queue继承自Collection接口，Deque, LinkedList, PriorityQueue, BlockingQueue等类都实现了它。

### List

```java
public interface List<E> extends Collection<E>
```

```text
常用方法：
add、addAll、copyOf
clear、remove、removeAll、removeIf(collection中)、replaceAll、retainAll
isEmpty、size
get、indexOf(无效返回-1)、lastIndexOf(无效返回-1)、contains、containsAll
set、
sort、
toArray
stream(collection中)、iterator、listIterator
```

### Queue

```java
public interface Queue<E> extends Collection<E>
```

```text
add、offer(当超出队列界限的时候，add方法是抛出异常让你处理，offer方法是直接返回false)
element(源码调用的getFirst)、peek
poll(会删除，没有返回null)、remove​
```

### stack

```java
Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess
public class Stack<E> extends Vector<E>
```

```text
常用方法：
empty、
push、pop(remove)、peek
search(索引从1开始，没有返回-1)
```

### ArrayList

```java
public class ArrayList<E>
extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, Serializable
```

```text
常用方法：
clone(浅拷贝)
ensureCapacity(ArrayList指定list的最小容量)、subList
forEach
trimToSize
```

### LinkedList

```java
public class LinkedList<E>
extends AbstractSequentialList<E>
implements List<E>, Deque<E>, Cloneable, Serializable
```

```text
addFirst、addLast、clone(浅拷贝)、offerFirst、offerLast
getFirst、getLast、peekFirst、peekLast、
pollFirst、pollLast、removeFirst、removeFirstOccurrence、removeLast、removeLastOccurrence​、
push、pop
```

### PriorityQueue

```java
public class PriorityQueue<E>
extends AbstractQueue<E>
implements Serializable

All Implemented Interfaces:
Serializable, Iterable<E>, Collection<E>, Queue<E>
```

```text
每次取出队列中最小的元素
PriorityQueue​(int initialCapacity, Comparator<? super E> comparator)
add、offer、
clear、remove、removeAll、removeIf、
```

### HashSet

### LinkedHashSet

### TreeSet

## Map

```text
Map    接口  键值对的集合
    Hashtable  接口实现类   同步       线程安全
    HashMap    接口实现类   没有同步   线程不安全
    LinkedHashMap
    TreeMap
    IdentityHashMap
```

### HashMap

```java
        /*
         * 常用方法：compute、computeIfAbsent、computeIfPresent、merge
         * containsKey、containsValue、get、
         * put、putAll、clear、remove、isEmpty、size
         * entrySet(可进行流操作)、keySet、Values(返回map中所有的value组成的集合)，三者都是map的view，remove等操作会影响原集合
         */

        Map<String, String> map = new HashMap<>();
        /* 清空map中的数据 */
        map.clear();
        map.put("key1", "value");
        map.put("key2", null);
        map.put(null, null);
        System.out.println(map);

        List<String> list = map.entrySet().stream().filter(entry -> "key1".equals(entry.getValue()))
            .map(Map.Entry::getValue).collect(Collectors.toList());
        /*
        * compute
        * 1、key有值，value有值，map中的value更新为新值，返回新value
        * 2、key为null或者有值，value为null，该key对应的map映射为新的value，返回新value
        * 3、key不存在，map添加该对key、value，返回新value
        * 4、如果新value为null，则删除对应的key、value，
        * If the remapping function returns null, the mapping is removed (or remains absent if initially absent).
        */
        map.compute("key1", (key, value) -> value + " new compute value1");
        map.compute("key2", (key, value) -> value + " new compute value2");
        map.compute(null, (key, value) -> value + " new compute null");
        map.compute("key3", (key, value) -> value + " new compute value3");
        map.compute("new key", (key, value) -> {
            if (value == null) {
                value = "null value " + 0;
            } else {
                value = value + 1;
            }
            return value;
        });
        System.out.println(map);
        map.compute("key2", (key, value) -> null);
        System.out.println(map);
        /*
         * computeIfAbsent
         * 1、key有值，value有值，map中的值不做改变，返回原value
         * 2、key为null或者有值，value为null，该key对应的map映射为新的value，返回新value
         * 3、key不存在，map添加该对key、value，返回新value
         * 4、新value为null，对原map不起作用，
         * If the specified key is not already associated with a value (or is mapped to null),
         * attempts to compute its value using the given mapping function and enters it into this map unless null.
         * If the mapping function returns null, no mapping is recorded.
         */
        map.clear();
        map.put("key1", "value1");
        map.put("key2", null);
        map.put(null, null);
        System.out.println(map);
        map.computeIfAbsent("key1", key -> " computeIfAbsent new value1");
        map.computeIfAbsent("key2", key -> " computeIfAbsent new value2");
        map.computeIfAbsent(null, key -> " computeIfAbsent new value null");
        map.computeIfAbsent("key3", key -> " computeIfAbsent new value3");
        System.out.println(map);
        map.computeIfAbsent("key2", key -> null);
        map.computeIfAbsent("key4", key -> null);
        System.out.println(map);

        /*
         * computeIfPresent
         * 1、key有值或为null，value有有效值，map中的value更新为新value，如果新value为null，则删除对应key、value
         * 2、key为null或者有值，value为null，map不更新，返回null
         * 3、key不存在，map不更新，返回null
         * If the value for the specified key is present and non-null,
         * attempts to compute a new mapping given the key and its current mapped value.
         * If the remapping function returns null, the mapping is removed
         */
        map.clear();
        map.put("key1", "value1");
        map.put("key2", null);
        map.put(null, "");
        System.out.println(map);
        map.computeIfPresent("key1", (key, value) -> value + " computeIfPresent new value1");
        map.computeIfPresent("key2", (key, value) -> value + " computeIfPresent new value2");
        map.computeIfPresent(null, (key, value) -> value + " computeIfPresent new value null"); //如果原value无效，则不更新
        map.computeIfPresent("key3", (key, value) -> value + " computeIfPresent new value3");
        System.out.println(map);
        map.computeIfPresent("key2", (key, value) -> null);
        System.out.println(map);

        /*
        * merge
        * newValue不能为空
        * 如果原value为null，直接更新为新value，不用remappingFunction返回的值
        * remappingFunction返回null，删除map中对应的key、value
        * If the specified key is not already associated with a value or is associated with null,
        * associates it with the given non-null value.
        * Otherwise, replaces the associated value with the results of the given remapping function,
        * or removes if the result is null.
        */
        map.clear();
        map.put("key1", "value1");
        map.put("key2", null);
        map.put(null, "");
        System.out.println(map);
        map.merge("key1", " merge new value1", (oldValue, newValue) -> oldValue + newValue);
        map.merge("key2", " merge new value2", (oldValue, newValue) -> "return merge new value2");
        map.merge(null, " merge new value null", (oldValue, newValue) -> oldValue + newValue);
        map.merge("key3", " merge new value3", (oldValue, newValue) -> oldValue + newValue);
        System.out.println(map);
        //map.merge("key2", null, (oldValue, newValue) -> newValue); //java.lang.NullPointerException
        map.merge("key2", "new value2", (oldValue, newValue) -> null);
        System.out.println(map);

        System.out.println();
        map.clear();
        map.put("key1", "value1");
        map.put("key2", "value1");
        map.put("key3", "value1");

        map.put("key4", "value2");
        map.put("key5", "value2");
        map.put("key6", "value2");
        Set<String> keySet = map.keySet();
        Collection<String> values = map.values();
        System.out.println(map);
        System.out.println(keySet);
        System.out.println(values);

        /* remove value时，找到map中第一个value为对应值得key、value，并将其删除 */
        System.out.println();
        values.remove("value1");
        System.out.println(map);
        System.out.println(keySet);
        System.out.println(values);

        System.out.println();
        keySet.remove("key4");
        System.out.println(map);
        System.out.println(keySet);
        System.out.println(values);
```

### TreeMap

```java
public class TreeMap<K,V> extends AbstractMap<K,V> implements NavigableMap<K,V>, Cloneable, java.io.Serializable
public interface NavigableMap<K,V> extends SortedMap<K,V>
```

```java
双方都
```

### LinkedHashMap

