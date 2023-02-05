package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class lec06SupplierRefactoring {
    public static void main(String[] args) {
        getName();
        // to make it Asynchronous
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());

        //To make it block
//        String name = getName().subscribeOn(Schedulers.boundedElastic()).block();
//        System.out.println(name);
//        getName();

        Util.sleep(4);
    }

    private static Mono<String> getName(){
        System.out.println("Enter Get Name method");

        return Mono.fromSupplier(()->{
            System.out.println("Generating Name");
            Util.sleep(3);
            return Util.FAKER.name().fullName();
        }).map(String::toUpperCase);
    }
}
