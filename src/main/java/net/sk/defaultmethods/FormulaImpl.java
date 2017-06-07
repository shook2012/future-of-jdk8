package net.sk.defaultmethods;

/**
 * Created by fangyt on 2017/5/26.
 */
public class FormulaImpl implements Formula {

    @Override
    public double calculate(int number) {
        return number * 100;
    }

}
