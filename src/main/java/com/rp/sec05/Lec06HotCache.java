package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec06HotCache {
    public static void main(String[] args) {
        //cache = publish().replay()
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                //this will replay the input element in the next subscribe
//                .cache();

                //this will replay only 2 last input element in the next subscribe
                .cache(2);

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleep(10);

        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleep(30);
    }
    public static Stream<String> getMovie(){
        System.out.println("Getting the movie seq");
        return Stream.of(
                "Scene 01",
                "Scene 02",
                "Scene 03",
                "Scene 04",
                "Scene 05",
                "Scene 06",
                "Scene 07"
        );
    }
}
