package com.rp.sec05.Assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class InventoryService {

    Map<String, Integer> inventoryDataBase = new HashMap<>();

    public InventoryService() {
        inventoryDataBase.put("Food",100);
        inventoryDataBase.put("Clothes",100);
    }

    public Consumer<PurchaseOrder> setInventoryService(){
        return purchaseOrder -> inventoryDataBase.computeIfPresent(purchaseOrder.getCategory(), (k,v)-> v - purchaseOrder.getQuantity());
    }

    public Flux<String> getInventoryService(){
        return Flux.interval(Duration.ofSeconds(2))
                .map(i-> inventoryDataBase.toString());
    }

}
