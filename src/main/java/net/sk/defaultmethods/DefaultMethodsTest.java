package net.sk.defaultmethods;

import org.junit.Test;

/**
 * Created by fangyt on 2017/4/20.
 * 语言新特性-2.接口的默认与静态方法
 */
public class DefaultMethodsTest {


    @Test
    public void testDefaultMethod1(){
        //default method
        FormulaImpl formula = new FormulaImpl();
        System.out.println(formula.pow(4));
    }

    @Test
    public void testDefaultMethod2(){
        //static method
        System.out.println(Formula.getInstance().pow(5));

        System.out.println(Formula.pow3(5));
    }


    @Test
    public void testDefaultMethod3(){
        FormulaImpl formula = new FormulaImpl();
        System.out.println(formula.calculate(200));

        //lambdas
        System.out.println(calculate(number -> number * 200));
    }

    private double calculate(Formula formula){
        return formula.calculate(200);
    }

}
