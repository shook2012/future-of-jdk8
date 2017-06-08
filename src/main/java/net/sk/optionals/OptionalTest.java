package net.sk.optionals;

import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by fangyt on 2017/4/20.
 *
 * Java 8引入了一个新的叫做java.util.Optional 的类来缓解这个问题
 *
 * Optional的目的不是替换你代码里面的每个null，它可以帮助你设计出更好的API。
 * 使用者通过方法签名就能知道是否有一个可选的值。
 * 另外，Optional通过强迫主动处理空指针情况，可以保护代码不出现NullPointException
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
    map        //如果有值，为其执行调用mapping函数得到返回值。如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional。
    flatMap   //如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional
    orElse
    orElseGet
    orElseThrow

    */

    @Test
    public void testOptional1(){
        Optional<String> emptyOptional = Optional.empty();
        String str = "test";
        String nullStr = null;

        Optional<String>  optStr = Optional.of(str); //require not null value
        //Optional<String>  optStr1 = Optional.of(nullStr); //NPE  Objects.requireNonNull


        Optional<String>  nullOptStr = Optional.ofNullable(nullStr); //null value is available

        System.out.println(optStr.isPresent());
        System.out.println(nullOptStr.isPresent());

        optStr.ifPresent(System.out::println);
        nullOptStr.ifPresent(System.out::println);

        /*System.out.println(emptyOptional.get());*/

        //如果有值orElse方法会返回Optional实例，否则返回传入的错误信息。
        System.out.println(nullOptStr.orElse("There is no value present!"));
        System.out.println(optStr.orElse("There is some value!"));

        //orElseGet与orElse类似，区别在于传入的默认值。
        //orElseGet接受lambda表达式生成默认值。
        System.out.println(nullOptStr.orElseGet(() -> "Default Value"));
        System.out.println(optStr.orElseGet(() -> "Default Value"));

        try {
            //orElseThrow与orElse方法类似，区别在于返回值。
            //orElseThrow抛出由传入的lambda表达式/方法生成异常。
            nullOptStr.orElseThrow(ValueAbsentException::new);
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }


    }

    @Test
    public void testOptional2(){
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


    class ValueAbsentException extends Throwable {

        public ValueAbsentException() {
            super();
        }

        public ValueAbsentException(String msg) {
            super(msg);
        }

        @Override
        public String getMessage() {
            return "No value present in the Optional instance";
        }
    }
}
