package com.rp.sec04;

import com.rp.courseutil.Util;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class Lec05Error {
    public static void main(String[] args) {
        Flux.range(1,10)
                .log()
                .map(i-> 10/(5-i))  // this is give error when i = 5

                // This will return the value "-1" whenever there is an error but that will be the last value passed
//                .onErrorReturn(-1)

                // We use this to pass a method with a dynamic input, but the input ends there
//                .onErrorResume(e->fallBack())

                // Use this when you still want to continue after error occur
                .onErrorContinue((i,err)->{})

                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallBack() {
        return Mono.fromSupplier(()->Util.faker().random().nextInt(100,200));
    }
}
