package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class lec08MonoFromRunnable {
    public static void main(String[] args) {

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        ()->{
                            System.out.println("Operation Completed. Sending report");
                        });

    }

    public static Runnable timeConsumingProcess(){
        return ()->{
            Util.sleep(3);
            System.out.println("Operation Started");
        };
    }
}
