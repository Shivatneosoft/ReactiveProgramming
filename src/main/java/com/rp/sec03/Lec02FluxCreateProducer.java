package com.rp.sec03;

import com.rp.courseutil.Util;
import com.rp.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateProducer {

    public static void main(String[] args) {
        //This is class that produce name using faker and implements Consumer<FluxSink<String>>.
        NameProducer nameProducer = new NameProducer();

        //Here the element is added in Flux
        //But it won.t work until the NameProducer produce the name
        Flux.create(nameProducer)
                .subscribe(Util.subscriber());

        //The name is been produced and the flux is triggered to run
        nameProducer.produce();
        //Multiple produce will result to multiple trigger
        nameProducer.produce();
        nameProducer.produce();
        nameProducer.produce();
        nameProducer.produce();
        nameProducer.produce();
    }
}
