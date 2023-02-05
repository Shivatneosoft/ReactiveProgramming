package com.rp.sec02;

import com.rp.courseutil.Util;
import com.rp.sec02.helper.NameGenerator;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {

        List<String> namesList = NameGenerator.getnameList(5);
        System.out.println(namesList);

        NameGenerator.getNameFlux(5)
                .subscribe(Util.onNext());
    }
}
