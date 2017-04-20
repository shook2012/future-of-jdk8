package defaultmethods;

/**
 * Created by fangyt on 2017/4/20.
 */
public interface  Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
