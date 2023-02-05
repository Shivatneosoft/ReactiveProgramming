package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateError {
    public static void main(String[] args) {

        //same FluxCreate Program
        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                System.out.println("Emitting :"+country);
                fluxSink.next(country);
            }
            //to see the output difference uncomment only one while condition
            //here you get only 3 output but the loop continue to pass all the element
            while (!country.equalsIgnoreCase("canada"));
            //here you get only 3 output and the loop also pass 3 element
//            while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
            fluxSink.complete();
        })
                .take(3)
                .subscribe(Util.subscriber());

    }
}
