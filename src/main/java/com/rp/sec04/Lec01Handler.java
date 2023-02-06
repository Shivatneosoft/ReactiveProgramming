package com.rp.sec04;

public class Lec01Handler {
    public static void main(String[] args) {

        // handler used as filter and map
//        Flux.range(1,20)
//                .handle((integer, synchronousSink) ->{
//                    if (integer % 2 == 0) // filter
//                        synchronousSink.next(integer);
//                    else
//                        synchronousSink.next(integer + "a"); // map
//                })
//                .subscribe(Util.subscriber());

//        Flux.range(1,20)
//                .handle((integer, synchronousSink) -> {
//                    if(integer == 7) // filter
//                        synchronousSink.complete();
//                    else
//                        synchronousSink.next(integer);
//                })
//                .subscribe(Util.subscriber());

    }
}
