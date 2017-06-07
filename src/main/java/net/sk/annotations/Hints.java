package net.sk.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fangyt on 2017/4/20.
 *
 *  ElementType.TYPE_USE和ElementType.TYPE_PARAMETER是两个新增加的元素类型，用来描述注解的适用场景。
 */
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Hints {
    Hint[] value();
}
