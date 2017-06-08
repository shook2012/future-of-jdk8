package net.sk.others;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by fangyt on 2017/6/7.
 */
public class Base64Test {

    @Test
    public void testBase64(){
        final String text = "Base64 finally in Java 8!";

        final String encoded = Base64.getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);
        final String decoded = new String(
                Base64.getDecoder().decode(encoded),
                StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}
