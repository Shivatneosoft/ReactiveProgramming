package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec07DefaultIfEmpty {
    public static void main(String[] args) {
        getOrder()
                .filter(i-> i > 10)
                // if there is no value to pass then the given input in "defaultIfEmpty" will be passed
                .defaultIfEmpty(-100)
                .subscribe(Util.subscriber());
    }
    public static Flux<Integer> getOrder(){
        return Flux.range(1,10);
    }
}
