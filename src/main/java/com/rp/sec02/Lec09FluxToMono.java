package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec09FluxToMono {
    public static void main(String[] args) {

        //The Next Command Allow only 1 item to pass for there next method;
        Flux.range(1,10)
                .next()
                .subscribe(Util.onNext(),Util.onError(),Util.onComplete());


        //Here filter is add, so only the element Greater then 3 is allowed
        //And then next is use to pass only one element
        Flux.range(1,10)
                .filter(i-> i>3)
                .next()
                .subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        //Here next() is use to pass one element first
        //And then filter is added
        //if the passed element satisfy the filter then the result is passed ahead
        Flux.range(1,10)
                .next()
                .filter(i-> i>3)
                .subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}
