package com.rp.sec04.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    public static Map<Integer , List<Purchase>> db = new HashMap<>();

    static {
        List<Purchase> list1 = Arrays.asList(
            new Purchase(1),
            new Purchase(1),
            new Purchase(1)
        );
        List<Purchase> list2 = Arrays.asList(
            new Purchase(2),
            new Purchase(2)
        );
        db.put(1,list1);
        db.put(2,list2);
    }

    public static Flux<Purchase> getOrders(int userId){
        return Flux.create((FluxSink<Purchase> purchaseFluxSink) -> {
           db.get(userId).forEach(purchaseFluxSink::next);
        })
                .delayElements(Duration.ofSeconds(1));
    }

}
