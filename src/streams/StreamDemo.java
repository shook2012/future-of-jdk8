package streams;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by fangyt on 2017/3/23.
 *
 *  1.代码简洁函数式编程写出的代码简洁且意图明确，使用stream接口让你从此告别for循环。
 *  2.多核友好，Java函数式编程使得编写并行程序从未如此简单，你需要的全部就是调用一下parallel()方法。
 */
public class StreamDemo {

    private List<String> strings = new ArrayList<>();


    @Before
    public void setUp(){
        strings.add("ddd2");
        strings.add("aaa2");
        strings.add("bbb1");
        strings.add("aaa1");
        strings.add("bbb3");
        strings.add("ccc");
        strings.add("bbb2");
        strings.add("ddd1");
    }

    @After
    public void tearUp(){
        strings = null;
    }

    /**
     *  1.无存储。stream不是一种数据结构，它只是某种数据源的一个视图，数据源可以是一个数组，Java容器或I/O channel等。
     *  2.为函数式编程而生。对stream的任何修改都不会修改背后的数据源，比如对stream执行过滤操作并不会删除被过滤的元素，而是会产生一个不包含被过滤元素的新stream。
     *  3.惰式执行。stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
     *  4.可消费性。stream只能被“消费”一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。
     *
     *
     *  一个流管道 包含一个流来源、0 或多个中间操作，以及一个终止操作
     *  流来源有一种称为 Spliterator 的抽象来描述  Collection
     *  Collection.streams()	使用一个集合的元素创建一个流。
     *  Stream.of(T...)	使用传递给工厂方法的参数创建一个流。
     *  Stream.of(T[])	使用一个数组的元素创建一个流。
     *  Stream.empty()	创建一个空流。
     *  Stream.iterate(T first, BinaryOperator<T> f)	创建一个包含序列 first, f(first), f(f(first)), ... 的无限流
     *  Stream.iterate(T first, Predicate<T> filter, BinaryOperator<T> f)	（仅限 Java 9）类似于 Stream.iterate(T first, BinaryOperator<T> f)，但流在测试预期返回 false 的第一个元素上终止。
     *  Stream.generate(Supplier<T> f)	使用一个生成器函数创建一个无限流。
     *  IntStream.range(lower, upper)	创建一个由下限到上限（不含）之间的元素组成的 IntStream。
     *  IntStream.rangeClosed(lower, upper)	创建一个由下限到上限（含）之间的元素组成的 IntStream。
     *  BufferedReader.lines()	创建一个有来自 BufferedReader 的行组成的流。
     *  BitSet.streams()	创建一个由 BitSet 中的设置位的索引组成的 IntStream。
     *  Stream.chars()	创建一个与 String 中的字符对应的 IntStream。
     *
     *  中间操作:
     * filter(Predicate<T>)	与预期匹配的流的元素
     * map(Function<T, U>)	将提供的函数应用于流的元素的结果
     * flatMap(Function<T, Stream<U>>	将提供的流处理函数应用于流元素后获得的流元素
     * distinct()	已删除了重复的流元素
     * sorted()	按自然顺序排序的流元素
     * Sorted(Comparator<T>)	按提供的比较符排序的流元素
     * limit(long)	截断至所提供长度的流元素
     * skip(long)	丢弃了前 N 个元素的流元素
     *
     * 终止流操作:
     *  forEach(Consumer<T> action)	将提供的操作应用于流的每个元素。
     *  toArray()	使用流的元素创建一个数组。
     *  reduce(...)	将流的元素聚合为一个汇总值。
     *  collect(...)	将流的元素聚合到一个汇总结果容器中。
     *  min(Comparator<T>)	通过比较符返回流的最小元素。
     *  max(Comparator<T>)	通过比较符返回流的最大元素。
     *  count()	返回流的大小。
     *  {any,all,none}Match(Predicate<T>)	返回流的任何/所有元素是否与提供的预期相匹配。
     *  findFirst()	返回流的第一个元素（如果有）。
     *  findAny()	返回流的任何元素（如果有）。
     *
     *
     *
     *  规约操作（reduction operation）又被称作折叠操作（fold），是通过某个连接动作将所有元素汇总成一个汇总结果的过程。
     *  元素求和、求最大值或最小值、求出元素总个数、将所有元素转换成一个列表或集合，都属于规约操作。
     *  Stream类库有两个通用的规约操作reduce()和collect()，也有一些为简化书写而设计的专用规约操作，比如sum()、max()、min()、count()等。
     *
     */



    @Test
    public void testFilter(){
        strings.stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

    }

    @Test
    public void testSorted(){
        strings.stream()
                .sorted()
                .forEach(System.out::println);;

    }

    @Test
    public void testMapping(){
        strings .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
    }

    @Test
    public void testMatching(){
        boolean anyStartsWithA = strings
                .stream()
                .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA = strings
                .stream()
                .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ = strings
                .stream()
                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true

    }

    @Test
    public void testCount(){
        // counting
        long startsWithB = strings
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();

        System.out.println(startsWithB);    // 3
    }

    @Test
    public void testReducing(){
        // reducing
        Optional<String> reduced =
                strings
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);

        //reducing2
        // 找出最长的单词
        Stream<String> stream = Stream.of("hello", "java", "8");
        Optional<String> longest = stream.reduce((s1, s2) -> s1.length()>=s2.length() ? s1 : s2);
        //Optional<String> longest = stream.max((s1, s2) -> s1.length()-s2.length());
        System.out.println(longest.get());
    }
    @Test
    public void testForEach(){
        // forEach
        strings
        .stream()
        .sorted()
        .forEach(System.out::println);

        System.out.println(strings);
    }

    @Test
    public void testCollect() {
        Stream<String> stream = Stream.of("hello", "java", "8");

        //List<String> list = stream.collect(Collectors.toList()); // (1)

        //Set<String> set = stream.collect(Collectors.toSet()); // (2)

        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length)); // (3)
        System.out.println(map);
    }
}
