package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        // The ".interval" method is used to run every given interval of time.
        // But in order to make sure this work the main Thread or the current
        // thread need to live a little longer

        Util.sleep(9);
    }
}
