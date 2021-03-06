package net.sk.lambdas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

/**
 * Created by fangyt on 2017/4/20.
 * 语言新特性- 1Lambdas表达式 & collections的一些新方法
 *
 * Java8为容器新增一些有用的方法，这些方法有些是为完善原有功能，有些是为引入函数式编程，学习和使用这些方法有助于我们写出更加简洁有效的代码．
 */
public class LambdasTest {

    private static String PREFIX = "aaa";
    private static String HELLO_STRING = "hello, java 8";

    private List<String> strings = new ArrayList<>();
    private HashMap<Integer, String> map = new HashMap<>();

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


        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
    }

    @After
    public void tearUp(){
        strings = null;
    }

    /**
     * 匿名内部类 -> Lambdas表达式
     */
    @Test
    public void testLambdas1() throws InterruptedException {
        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(HELLO_STRING);
            }
        }).start();

        new Thread(()->{
            System.out.println(HELLO_STRING);
        }).start();

        Thread.sleep(100L);
    }

    /**
     * 方法引用
     * 方法引用的唯一用途就是支持Lambda的简写
     */
    @Test
    public void testLambdas2(){
        File dirPath = new File("d:\\");

        File[] fileArray = dirPath.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        File[] files = dirPath.listFiles(File::isHidden);
    }

    /**
     * 函数式接口 Functional interface
     *
     * 要使用 Lambda 表达式，需要定义一个函数式接口，这样往往会让程序充斥着过量的仅为 Lambda 表达式服务的函数式接口。为了减少这样过量的函数式接口，
     * Java 8 在 java.util.function 中增加了不少新的函数式通用接口。例如：
     * Function<T, R>：将 T 作为输入，返回 R 作为输出，他还包含了和其他函数组合的默认方法。
     *
     * Predicate<T> ：将 T 作为输入，返回一个布尔值作为输出，该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（与、或、非）。
     *
     * Consumer<T> ：将 T 作为输入，不返回任何内容，表示在单个参数上的操作。
     *
     * Supplier<T>——没有输入，返回T
     *
     * UnaryOperator<T>——将两个T作为输入，返回一个T作为输出
     *
     *
     * 接口名	Java8 集合框架 新加入的方法
     * Collection	removeIf() spliterator() stream() parallelStream() forEach()
     * List	replaceAll() sort()
     * Map	getOrDefault() forEach() replaceAll() putIfAbsent() remove() replace() computeIfAbsent() computeIfPresent() compute() merge()
     *
     */

    /**
     *
     * HashMap computeIfAbsent  @see FunctionalTest
     */
    @Test
    public void testFunction3(){
        /**
         * 内部类
         */
        Function<Integer, String> f = new Function<Integer,String>(){
            @Override
            public String apply(Integer t) {
                return String.valueOf(t);
            }
        };
        System.out.println(f.apply(1));

        /**
         * lambdas
         */
        Function<Integer, String> f2 = (t) -> String.valueOf(t);
        System.out.println(f2.apply(2));

        /**
         * 方法引用
         */
        Function<Integer, String> f3 = String ::valueOf;
        System.out.println(f3.apply(3));

        /**
         *
         */
        Predicate<Student> boys = (student) -> "男".equals(student.getGender());
        System.out.println(boys);


        Consumer<String> c = (String x) -> { System.out.println(x);};
        strings.stream().forEach(c);

        Supplier<Student> supplier = Student::new;
        Student student = supplier.get();
        System.out.println(student.getGender());
    }


    @Test
    public void testCollections1(){
        /*
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        });
        */

        strings.forEach(str ->{
            if(str.startsWith(PREFIX)){
                System.out.println(str);
            }
        });
    }

    @Test
    public void testCollections2(){
        /*
        strings.removeIf(new Predicate<String>(){
            @Override
            public boolean test(String str){
                return str.startsWith(PREFIX);
            }
        });
        */

        strings.removeIf(str -> str.startsWith(PREFIX));
        System.out.println(strings);
    }

    @Test
    public void testCollections3(){
        /*
        strings.replaceAll(new UnaryOperator<String>(){
            @Override
            public String apply(String str){
                if(str.length() > 3)
                    return str.toUpperCase();
                return str;
            }
        });
        */
        strings.replaceAll(str -> {
            if(str.length() > 3){
                return str.toUpperCase();
            }
            return str;
        });

        System.out.println(strings);


    }
    @Test
    public void testCollections4(){
        /*
        strings.replaceAll(new UnaryOperator<String>(){
            @Override
            public String apply(String str){
                if(str.length() > 3)
                    return str.toUpperCase();
                return str;
            }
        });
        */
        strings.sort((str1, str2) -> str1.length()-str2.length());

        System.out.println(strings);


    }
    @Test
    public void testCollections5(){
        /*
         map.forEach(new BiConsumer<Integer, String>(){
            @Override
            public void accept(Integer k, String v){
                System.out.println(k + "=" + v);
            }
        });
        */
        map.forEach((k,v) -> {
            System.out.println(k + "=" + v);
        });

    }

    @Test
    public void testCollections6(){
        // 使用Map.getOrDefault()
        System.out.println(map.getOrDefault(4, "NoValue"));

        //putIfAbsent
        map.put(4,null);
        System.out.println(map);

        map.putIfAbsent(4,"four");
        System.out.println(map);

        map.putIfAbsent(4,"five");
        System.out.println(map);

        map.putIfAbsent(5,"five");
        System.out.println(map);

        //remove()
        map.remove(5,"five");
        System.out.println(map);

        //replace()
        map.replace(4,"四");
        System.out.println(map);

        //replace()
        map.replace(4,"四","肆");
        System.out.println(map);

        //replaceAll
       /*
       map.replaceAll(new BiFunction<Integer, String, String>(){
            @Override
            public String apply(Integer k, String v){
                return v.toUpperCase();
            }
        });
        */
        map.replaceAll((k, v) -> v.toUpperCase());
        System.out.println(map);


        map.merge(4,"加零",(v1,v2) -> v1 + v2);
        System.out.println(map);
        //compute()  computeIfAbsent()  computeIfPresent()
    }



}



