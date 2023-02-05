package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {

        //here the synchronousSink is used to produce continuous output
        Flux.generate(synchronousSink -> {
            System.out.println("Emmiting");
            synchronousSink.next(Util.faker().name().fullName());

            //synchronousSink.error is used to throw error
//            synchronousSink.error(new Throwable("Error"));

            //synchronousSink.complete is used to let the method now that now they have to stop
//            synchronousSink.complete();
        })

                //here take helps to pass only 3 element and let the synchronousSink to stop
                .take(3)
                .subscribe(Util.subscriber());
    }
}
