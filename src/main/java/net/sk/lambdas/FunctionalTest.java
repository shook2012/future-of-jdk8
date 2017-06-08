package net.sk.lambdas;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by fangyt on 2017/6/5.
 */
public class FunctionalTest {

    private List<String> strings = new ArrayList<>();
    private HashMap<Integer, String> map = new HashMap<>();
    private static String HELLO_STRING = "hello, java 8";

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
        //map.put(3, "three");
    }

    /**
     *
     */
    @Test
    public void testFunction(){
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("1","value1");
        hashMap.put("2","value2");
        //hashMap.put("3","value3");

        hashMap.computeIfAbsent("3",t ->  map.get(Integer.valueOf(t)) );
        System.out.println(hashMap);
    }

    /**
     *
     */
    @Test
    public void testPredicate(){
        List<Student> maleList = new School().getPersonList(student -> "男".equals(student.getGender()));
        System.out.println(maleList);

        Predicate<Student> femalePredicate = student ->  "女".equals(student.getGender());
        List<Student> femaleList1 = new School().getPersonList2(femalePredicate);


        List<Student> femaleList2 = new School().getPersonList2(student -> "女".equals(student.getGender()));
        System.out.println(femaleList2);
    }

    /**
     *
     */
    @Test
    public void testConsumer(){
        Consumer<String> c = str -> { System.out.println(str);};
        strings.stream().forEach(c);

        //c.accept(HELLO_STRING);
    }

    /**
     * CompletableFuture, 里面的很多方法的入参都用到的Supplier
     */
    @Test
    public void testSupplier(){
        Supplier<Student> supplier = Student::new;
        Student student = supplier.get();

        System.out.println(student.getGender());
    }








}
