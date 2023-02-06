package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec06Timeout {
    public static void main(String[] args) {
        getOrder5Sec().log()
                // timeout is just like timebomb, it will wait for input for a
                // given moment and then exit the code
                // Or take input from the other method present in 2nd Parameter
                .timeout(Duration.ofSeconds(2), fallBack())
                .subscribe(Util.subscriber());

        Util.sleep(25);

        getOrder1Sec().log()
                // here timeout won't work as the input
                // data is incomming in every second
                .timeout(Duration.ofSeconds(2))
                .subscribe(Util.subscriber());

        Util.sleep(25);
    }
    public static Flux<Integer> getOrder5Sec(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(5));
    }
    public static Flux<Integer> getOrder1Sec(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> fallBack(){
        return Flux.range(100,10)
                .delayElements(Duration.ofMillis(200));
    }
}
