package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec08SwitchIfEmpty {
    public static void main(String[] args) {
        getOrder()
                .filter(i-> i > 10)
                // if there is no value to pass then the given
                // method in "defaultIfEmpty" will be used to pass the value
                .switchIfEmpty(fallBack())
                .subscribe(Util.subscriber());
    }
    public static Flux<Integer> getOrder(){
        return Flux.range(1,10);
    }

    public static Flux<Integer> fallBack(){
        return Flux.range(20,10);
    }
}
