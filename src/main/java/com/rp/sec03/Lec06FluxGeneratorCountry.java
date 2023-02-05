package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06FluxGeneratorCountry {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    String s = Util.faker().country().name();
            synchronousSink.next(s);
            if (s.equalsIgnoreCase("canada"))
                synchronousSink.complete();
        })
//                .take(5)
                .subscribe(Util.subscriber());
    }
}
