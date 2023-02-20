package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec05HotAutoConnect {
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

    public static void main(String[] args) {
        // to Stop the flux to subscriber again use autoconnect
        // if sam joins the movielate then he has to continue rather than start
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
//                .autoConnect(1); // get start with there is sam
                .autoConnect(0); //when you don't want to wait for sam

        Util.sleep(3);

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleep(5);

        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleep(30);
    }
}
