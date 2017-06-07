package net.sk.optionals;

import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by fangyt on 2017/4/20.
 *
 * Java 8引入了一个新的叫做java.util.Optional 的类来缓解这个问题
 * Optional类的目的并不是完全取代null, 它的目的是设计更易理解的API。通过Optional，可以从方法签名就知道这个函数有可能返回一个缺失的值，这样强制你处理这些缺失值的情况。
 */
public class OptionalTest {
    private Computer computer;

    private Optional<Computer> optComputer;
    @Before
    public void setUp(){
        optComputer = Optional.ofNullable(computer);
        computer = new Computer();
    }

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

    @Test
    public void testOptional(){
        /*System.out.println(computer.getSoundcard().getUsb().getVersion()); //NPE

        if(computer != null){
            Soundcard soundcard = computer.getSoundcard();
            if(soundcard != null){
                USB usb = soundcard.getUsb();
                if(usb != null){
                    System.out.println(usb.getVersion());
                }
            }
        }*/

        System.out.println(computer.getSoundcard());

        // Grovvy -> ?.的操作符: computer?.getSoundcard()?.getUSB()?.getVersion()

        /**
         * 使用Optional类来实现传统的空指针检测
         */
        System.out.println(optComputer.flatMap(Computer::getSoundcard).flatMap(Soundcard::getUsb).map(USB::getVersion).orElse("defaultVersion"));


    }


    /*@Data
    class Computer {
        private Soundcard soundcard;
    }
    @Data
    class Soundcard {
        private USB usb;
    }
    @Data
    class USB {
        private String version;
    }*/

    @Data
    class Computer {
        private Optional<Soundcard> soundcard;
    }
    @Data
    class Soundcard {
    private Optional<USB> usb;
    }
    @Data
    class USB {
    private String version;
    }

}
