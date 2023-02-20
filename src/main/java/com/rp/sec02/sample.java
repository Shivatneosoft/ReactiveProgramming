package com.rp.sec02;

import java.util.stream.Stream;

public class sample {
    public static void main(String[] args) {
//        Stream<Integer> stream = Stream.of(1, 2, 3);
        for (int j = 0; j < 10; j++) {
            Stream<Integer> stream = Stream.of(1, 2, 3);
            System.out.println(stream);
            stream.forEach(System.out::println);
        }
//        System.out.println(i);
    }
}
