package net.sk.defaultmethods;

/**
 * Created by fangyt on 2017/5/26.
 */
public class FormulaImpl implements Formula,Formula2 {

    @Override
    public double calculate(int number) {
        return number * 100;
    }

    @Override
    public double pow(int number) {
        return Math.pow(number,2);
    }

}
