package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04Delay {
    public static void main(String[] args) {

        // You can set property by request like this
        // Here there work on different thread to get result
        System.setProperty("reactor.bufferSize.x","9");

        Flux.range(1,100)
                .log()
                // here the item has a limit range of 32 and request time is 75%
                // The element that are passed uses schedular to pass
//                so when the element is passed they get executed without going into subscribe
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        // You won't be able to see the output you put sleep to main thread and let Flux.subscribe to execute
        Util.sleep(60);
    }
}
