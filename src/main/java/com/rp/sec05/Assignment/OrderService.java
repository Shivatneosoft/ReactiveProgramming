package com.rp.sec05.Assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Objects;

public class OrderService {

    private Flux<PurchaseOrder> flux = null;

    private Flux<PurchaseOrder> getOrderStream(){
        return Flux.interval(Duration.ofMillis(100))
                .map(i-> new PurchaseOrder());
    }

    public Flux<PurchaseOrder> orderStream(){
        if(Objects.isNull(flux))
            flux = getOrderStream();
        return flux;
    }

}
