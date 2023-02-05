package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {
        //A counter can be introduced and used just like in below code.
        Flux.generate(
                        ()->1,
                        (counter,sink)->{
                            String country = Util.faker().country().name();
                            sink.next(country);
                            if(counter >=10 || country.equalsIgnoreCase("canada"))
                                sink.complete();
                            return counter+1;
                        }
                )
                .subscribe(Util.subscriber());
    }
}
