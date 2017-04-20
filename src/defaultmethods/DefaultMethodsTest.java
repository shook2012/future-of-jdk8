package defaultmethods;

import org.junit.Test;

/**
 * Created by fangyt on 2017/4/20.
 * 语言新特性-2.接口的默认与静态方法
 */
public class DefaultMethodsTest {


    @Test
    public void testDefaultMethod1(){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
    }

}
