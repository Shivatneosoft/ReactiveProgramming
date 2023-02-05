package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

    public static void main(String[] args) {
        //To create a flux use ".create()" function.
        //The "fluxSink" is an interface with multiple methods

        Flux.create(fluxSink -> {

            //This is code used to print 10 element
//            for (int i = 0; i < 10; i++) {
//                // here fluxSink.next() is used to send not null element
//                fluxSink.next(Util.faker().country().name());
//            }

            //Now this is code used to print country util the country is Canada;
            String country;
            do{
                country = Util.faker().country().name();
                fluxSink.next(country);
            }
            while (!country.equalsIgnoreCase("canada"));
            //The fluxSink.complete() says the fluxSink to stop sending more element and stop here
            fluxSink.complete();

        })
                .subscribe(Util.subscriber());

    }

}
