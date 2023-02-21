package com.rp.sec05.Assignment;

import com.rp.courseutil.Util;

public class Ass01OrderService {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        orderService.orderStream().subscribe(revenueService.setRevenueService());
        orderService.orderStream().subscribe(inventoryService.setInventoryService());

        revenueService.getRevenueService()
                .subscribe(Util.subscriber("Revenue Service"));
        inventoryService.getInventoryService()
                        .subscribe(Util.subscriber("Inventory Service"));


        Util.sleep(10);
    }

}
