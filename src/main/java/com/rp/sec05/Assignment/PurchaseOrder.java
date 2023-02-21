package com.rp.sec05.Assignment;

import com.rp.courseutil.Util;
import jdk.jfr.Category;
import lombok.Data;

@Data
public class PurchaseOrder {

    private String item;

    private Double price;

    private String category;

    private Integer quantity;

    public PurchaseOrder(){
        this.item = Util.faker().commerce().productName();
        this.price = Double.valueOf(Util.faker().commerce().price());
        this.category = Util.faker().random().nextBoolean() ? "Food" : "Clothes";
        this.quantity = Util.faker().random().nextInt(1,10);
    }

}
