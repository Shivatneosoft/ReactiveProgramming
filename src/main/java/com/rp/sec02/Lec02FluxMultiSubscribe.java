package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxMultiSubscribe {
    public static void main(String[] args) {

        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

        Flux<Integer> even = integerFlux.filter(data -> data % 2 == 0);

        integerFlux.subscribe(data-> System.out.println("Sub 1 : " + data));

        even.subscribe(data-> System.out.println("Sub 2 : " + data));


    }
}
