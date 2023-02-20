package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec04HotReCountRestart {
    public static void main(String[] args) {
        //Here Mike will get the movie from the start as the subcriber will subcribe
        //to all the element before the other subcriber has requested the element
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount();

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
