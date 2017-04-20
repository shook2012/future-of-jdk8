package annotations;

import org.junit.Test;

/**
 * Created by fangyt on 2017/4/20.
 * 语言新特性-6扩展注解的支持
 */
public class AnnotationTest {

    @Test
    public void  testAnnotation1(){
        Hint hint = Person1.class.getAnnotation(Hint.class);
        System.out.println(hint);                   // null

        Hints hints1 = Person1.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);  // 2

        Hint[] hints2 = Person2.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);          // 2
    }

}

@Hints({@Hint("hint1"), @Hint("hint2")})
class Person1 {}

@Hint("hint1")
@Hint("hint2")
class Person2 {}
