package com.rp.sec02.helper;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getnameList(int count){
        List<String> names = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            names.add(generateName());
        }
        return names;
    }

    public static Flux<String> getNameFlux(int count){
        return Flux.range(0,count)
                .map(i-> generateName());
    }

    private static String generateName(){
        Util.sleep(1);
        return Util.faker().name().fullName();
    }

}
