package com.rp.sec04.helper;

import com.rp.courseutil.Util;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Purchase {

    private String item;
    private String price;
    private int userId;

    public Purchase(int userId){
        this.userId = userId;
        this.item = Util.faker().commerce().productName();
        this.price = Util.faker().commerce().price();
    }

}
