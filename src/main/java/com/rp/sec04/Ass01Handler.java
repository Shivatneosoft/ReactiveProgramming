package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Ass01Handler {
    public static void main(String[] args) {
        //Here we generated the name of the country
        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                // we convert the Object into String
                .map(Object::toString)
                //we pass the string to check the country is canada or not
                .handle((country, synchronousSink)-> {
                    synchronousSink.next(country);
                    if("canada".equalsIgnoreCase(country))
                        synchronousSink.complete();
                })
                // we displayed the output
                .subscribe(Util.subscriber());



    }
}
