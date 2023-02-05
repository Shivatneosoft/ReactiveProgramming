package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class lec03MonoSubcribe {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l/1);

        mono.subscribe(
                System.out::println,
                data-> System.out.println(data.getMessage()),
                () -> System.out.println("Data Processed Successfull")
        );
    }
}
