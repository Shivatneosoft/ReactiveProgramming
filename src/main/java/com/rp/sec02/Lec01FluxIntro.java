package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.io.Serializable;

public class Lec01FluxIntro {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.just(1, 2, 3, 4, "a", Util.faker().name().firstName());

        flux.subscribe(Util.onNext());
    }
}
