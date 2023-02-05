package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxOperator {
    public static void main(String[] args) {
        //".map" here is used to perform action that may or may not include the use of input
        //so to use map you need to initialize the input as a variable
        //In this case, i is used to define the input
        Flux.range(1,10)
                .map(i-> i+i)
                .subscribe(Util.subscriber());

        System.out.println();

        //".filter" here is used to perform action like Vendind sorting coin
        // only input will suitable given condition will be passed
        Flux.range(1,10)
                .filter(i-> i%2==0)
                .subscribe(Util.subscriber());

        System.out.println();

        // .take here allow only number of element that is given in as a parameter
        Flux.range(1,10)
                .take(3)
                .subscribe(Util.subscriber());

        System.out.println();

        //.log here is used to get information about the method that
        // is hit during the transaction between the upper and lower method
        Flux.range(1,10)
                .log()
                .subscribe(Util.subscriber());

        System.out.println();
    }
}
