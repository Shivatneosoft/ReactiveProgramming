package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class lec07MonoFromFuture {
    public static void main(String[] args) {
        Mono.fromFuture(getName())
                .subscribe(Util.onNext());

        // Here you can get result by add sleep; to the main thread
        // As the object is Future the output will be executing irrespective of main thread running
        // if main thread ends early then there is no result

        Util.sleep(2);
    }
    public static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(()-> Util.faker().name().fullName());
    }
}
