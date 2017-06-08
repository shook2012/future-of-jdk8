package net.sk.others;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by fangyt on 2017/6/8.
 */
public class ParallelArrays {

    public static void main( String[] args ) {
        long[] arrayOfLong = new long[20000];

        Arrays.parallelSetAll(arrayOfLong,index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(10).forEach(System.out::println);

        System.out.println("-----------------");

        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(System.out::println);
        System.out.println();

        Arrays.stream(arrayOfLong).parallel().max().ifPresent(System.out::println);
    }
}
