package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec02HotShare {
    public static void main(String[] args) {
        //hot share means second publisher will continue with the first publisher
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                // here the method share() make the program a hot share
                .share();


        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleep(5);

        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleep(30);
        //In this case, Mike will follow Sam, as they both are in movie theater
        //which cannot work with multiple individual
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
