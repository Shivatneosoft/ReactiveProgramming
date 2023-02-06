package com.rp.sec04;

import com.rp.courseutil.Util;
import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.UserService;

public class Lec10Flatmap {
    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user-> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());

        Util.sleep(30);
    }
}
