package com.rp.sec02;

import com.rp.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscribe {
    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference();
        Flux.range(1,20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("Subscribed");
                        atomicReference.set(s);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Subscriber " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("Error :" + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed :");
                    }
                });

        atomicReference.get().request(3);
        // Using AtomicReference I can make the input limited using request
        Util.sleep(3);
        atomicReference.get().request(4);
        Util.sleep(3);
        atomicReference.get().cancel();
        // Once the Command of Cancel is hit we can not access the data
        // even if you request again it won't run
        Util.sleep(2);
        atomicReference.get().request(3);
    }
}
