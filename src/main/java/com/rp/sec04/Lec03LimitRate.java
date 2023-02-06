package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03LimitRate {
    public static void main(String[] args) {
        Flux.range(1,500)
                .log()
                // When there is no limitRate, request is unbounded
                // When there is limitRate, request is 75% of requested item
//                .limitRate(100)
                // When there is limitRate with 2 parameter, Then the limit value is 1st parameter and request is 2nd Parameter
//                .limitRate(100,95)
                // When there is limitRate with 2 parameter and both are equal, Then the limit value is 1st parameter and request is 75%
//                .limitRate(100,100)
                // When there is limitRate with 2 parameter with 2nd parameter being 0, Then the limit value and request is 1st parameter
                .limitRate(100,0)
                .subscribe(Util.subscriber());
    }
}
