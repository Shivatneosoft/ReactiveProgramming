package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {

    public static void main(String[] args) {
        // share = publish().refcount(1)
        //refcount is used to make the subscripber run if the have input number of subscriber.
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount(2);

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleep(5);

        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleep(30);
        //here, sam will wait for mike to watch the movie together
    }

    public static Stream<String> getMovie() {
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
