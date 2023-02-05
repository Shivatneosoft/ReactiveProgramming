package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class lec05MonoFromSupplier {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = ()-> getname();
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono
                .subscribe(
                        Util.onNext()
                );
        Callable<String> stringCallable = ()->getname();
        Mono.fromCallable(stringCallable)
                .subscribe(Util.onNext()
                );

    }
    public static String getname(){
        System.out.println("Generating Name");
        return Util.faker().name().fullName();
    }
}
