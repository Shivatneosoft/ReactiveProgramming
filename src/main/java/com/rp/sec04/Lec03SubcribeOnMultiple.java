package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Lec03SubcribeOnMultiple {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink ->{
                    threadName("create");
                    for (int i = 0; i < 20; i++) {
                        fluxSink.next(i);
                    }
                })
                .doOnNext(i -> threadName("next:" + i));

        Runnable runnable = () -> flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(i -> threadName("sub:" + 1));

        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }

        Util.sleep(5);
    }

    public static void threadName(String message){
        System.out.println(message + " \t\tThread: " + Thread.currentThread().getName());
    }

}
