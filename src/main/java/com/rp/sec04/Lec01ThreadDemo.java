package com.rp.sec04;

import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink ->{
                        threadName("create");
                        fluxSink.next(1);
        })
                .doOnNext(i -> threadName("next:" + i));

        Runnable runnable = () -> flux.subscribe(i -> threadName("sub:" + 1));

        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }
    }

    public static void threadName(String message){
        System.out.println(message + " \t\tThread: " + Thread.currentThread().getName());
    }

}
