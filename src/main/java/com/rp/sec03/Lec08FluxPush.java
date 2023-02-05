package com.rp.sec03;

import com.rp.courseutil.Util;
import com.rp.sec02.helper.NameGenerator;
import com.rp.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {
    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();
        // .push Method are user just like create
        // but the only problem is, it's not thread safe
        // which means output of the given code might produce 8 or 9 or 10 result
        Flux.push(nameProducer)
                .subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

    }
}
