package net.sk.others;

import net.sk.methodreference.Person;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by fangyt on 2017/6/7.
 * @link http://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/
 */
public class ScriptEngineManagerTest {

    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName( "JavaScript" );
        System.out.println( engine.getClass().getName() );
        System.out.println( "Result1:" + engine.eval( "print('hello,java 8')" ) );


        ScriptEngine nashorn = manager.getEngineByName( "nashorn" );
        System.out.println( nashorn.getClass().getName());
        System.out.println("Result2:" + nashorn.eval(new FileReader("E:\\samfan\\atwork\\future-of-jdk8\\src\\main\\java\\net\\sk\\others\\hello.js")));


        Invocable invocable = (Invocable) nashorn;
        Object result = invocable.invokeFunction("fun1", "吕洞宾");
        System.out.println(result);
        System.out.println(result.getClass());

        invocable.invokeFunction("fun2", new Date());
        // [object java.util.Date]

        invocable.invokeFunction("fun2", LocalDateTime.now());
        // [object java.time.LocalDateTime]

        invocable.invokeFunction("fun2", new Person());
        // [object net.sk.methodreference.Person]


    }

    public static String fun1(String name) {
        System.out.format("Hi there from Java, %s", name);
        return " greetings from javaaaaaaaaaaaaaaaa";
    }

    public static void fun2(Object object) {
        System.out.println("function2:" + object.getClass());
    }
}
