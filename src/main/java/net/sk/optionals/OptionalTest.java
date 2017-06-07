package net.sk.optionals;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by fangyt on 2017/4/20.
 */
public class OptionalTest {

    // wrong exp

    /*
    Optional<User> user = ......
    if (user.isPresent()) {
        return user.getOrders();
    } else {
        return Collections.emptyList();
    }

    empty
    of
    ofNullable
    get
    isPresent
    ifPresent
    filter
    map
    flatMap
    orElse
    orElseGet
    orElseThrow

    */
    @Test
    public void testOptional1(){
        String s = null;
        Optional<String> stringOptional = Optional.ofNullable(s);

        System.out.println(stringOptional.map(String::hashCode).orElse(0));

    }

}
