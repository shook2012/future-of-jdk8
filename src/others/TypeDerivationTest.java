package others;

import org.junit.Test;

/**
 * Created by fangyt on 2017/4/20.
 */
public class TypeDerivationTest {
    @Test
    public void typeDerivationTest(){
        Value< String > value = new Value<>();
        value.getOrDefault( "22", Value.defaultValue() );
    }
}
