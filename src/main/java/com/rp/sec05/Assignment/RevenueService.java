package com.rp.sec05.Assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RevenueService {

    Map<String, Double> revenueDataBase = new HashMap<>();

    public RevenueService() {
        revenueDataBase.put("Food",0.0);
        revenueDataBase.put("Clothes",0.0);
    }

    public Consumer<PurchaseOrder> setRevenueService(){
        return purchaseOrder -> revenueDataBase.computeIfPresent(purchaseOrder.getCategory(), (k,v)-> v + purchaseOrder.getPrice());
    }

    public Flux<String> getRevenueService(){
        return Flux.interval(Duration.ofSeconds(2))
                .map(i-> revenueDataBase.toString());
    }
}
