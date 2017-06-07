package net.sk.defaultmethods;

/**
 * Created by fangyt on 2017/4/20.
 */
@FunctionalInterface
public interface  Formula {

    double calculate(int number);

    default double pow(int number) {
        return Math.pow(number,2);
    }

    static Formula getInstance(){
        return new FormulaImpl();
    }

    static double pow3(int number){
       return Math.pow(number,3);
    }
}
