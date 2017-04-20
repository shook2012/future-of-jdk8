package annotations;

import java.lang.annotation.*;

/**
 * Created by fangyt on 2017/4/20.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Repeatable(Hints.class)
public @interface Hint {
    String value();
}
