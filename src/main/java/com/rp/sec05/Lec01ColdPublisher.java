package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec01ColdPublisher {
    public static void main(String[] args) {

        //Cold Publisher means Instead of continuing the stream,
        //second subcriber request to start the stream again

        //In this case, the mike will start the movie
        //from the beginning instead of watching movie with sam

        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1));

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleep(5);

        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleep(30);

        //Example is netflix movie.
        //if one user is in midway of the movie,
        //That do not effect you
        //you can start from the first

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
