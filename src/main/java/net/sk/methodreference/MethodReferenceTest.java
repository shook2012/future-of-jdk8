package net.sk.methodreference;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MethodReferenceTest {

    private static List<Person> personList = new ArrayList<Person>();
    private HashMap<Integer, String> map = new HashMap<>();


    /**
     * 方法引用分为4类，常用的是前两种。方法引用也受到访问控制权限的限制，可以通过在引用位置是否能够调用被引用方法来判断。
     *
     *  引用静态方法
     *
     *  引用特定对象的实例方法
     *
     *  引用特定类型的任意对象的实例方法
     *
     *  引用构造函数
     */
    @Before
    public void setUp(){
        // 方法引用::引用构造函数
        PersonFactory factory = new PersonFactory(Person::new);

        Person person1 = factory.getPerson();
        person1.setName("Kobe");

        personList.add(person1);
        Person person2 = factory.getPerson();
        person2.setName("James");
        personList.add(person2);

        Person person3 = factory.getPerson();
        person3.setName("Paul");
        personList.add(person3);
    }

    /**
     * 引用静态方法
     */
    @Test
    public void test1(){
        Person[] persons1 = personList.toArray(new Person[personList.size()]);
        System.out.println("排序前: ");
        printArray(persons1);

        // 方法引用::引用静态方法
        Arrays.sort(persons1, MethodReferenceTest::myCompare);
        System.out.println("排序后: ");
        printArray(persons1);
    }

    /**
     * 用特定对象的实例方法
     */
    @Test
     public void test2(){
        Person person = new Person();

         Person[] persons2 = personList.toArray(new Person[personList.size()]);
         System.out.println("排序前: ");
         printArray(persons2);

         // 方法引用::用特定对象的实例方法
         Arrays.sort(persons2, person::compare);
         System.out.println("排序后: ");
         printArray(persons2);
    }

    /**
     * 引用特定类型的任意对象的实例方法
     */
    @Test
    public void test3(){
        Person[] persons3 = personList.toArray(new Person[personList.size()]);
        System.out.println("排序前: ");
        printArray(persons3);

        // 方法引用::引用特定类型的任意对象的实例方法
        Arrays.sort(persons3, Person::compareTo);
        System.out.println("排序后: ");
        printArray(persons3);
    }

    public static void printArray(Person[] persons) {
        for (Person person : persons) {
            System.out.println(person.getName());
        }
        System.out.println();
    }

    public static int myCompare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }


}