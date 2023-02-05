package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArray {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("A", "n", "k", "i", "t");

        Flux.fromIterable(strings).subscribe(Util.onNext());

        Integer[] arr = {1,2,3,4};

        Flux.fromArray(arr).subscribe(Util.onNext());
    }

}
