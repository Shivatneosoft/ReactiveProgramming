package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Lec04PublishOn {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink ->{
                    threadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                    }
                })
                .doOnNext(i -> threadName("next:" + i));

        flux
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i-> threadName("next2: " +i))
                .subscribeOn(Schedulers.parallel())
                .subscribe(i -> threadName("sub:" + i));

        Util.sleep(5);


    }

    public static void threadName(String message){
        System.out.println(message + " \t\tThread: " + Thread.currentThread().getName());
    }

}
