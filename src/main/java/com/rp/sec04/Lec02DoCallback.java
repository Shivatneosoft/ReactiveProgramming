package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02DoCallback {
    public static void main(String[] args) {

        //When you run this program you will see
        //1. doFirst function run from down to up
        //2. doOnSubscribe run for up to down as the it works from publisher to subscriber
        //3. doOnRequest work immediately before the Subscribe
        //4. Then the element are created
        //5. Evreytime the doNext in Subscribe is hit, the doOnNext is hit here too
        //6. doterminate works when it hit
        //7. doOnComplete is hit before the OnComplete function is Subcription
        //7. doOnError is hot when there is an error just before OnError function in subcription
        // Sequence of doOnComplete and doTerminate is followed
        // by the sequence in which code is enter
        //8. doFinally is hit at the end
        //9. Finally the sout from the Creation is hit.

        Flux.create(fluxSink -> {
                    System.out.println("Creating");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.error(new Throwable("Error"));
            fluxSink.complete();
                    System.out.println("complete");
        })
                .doFirst(()-> System.out.println("doFirst 1"))
                .doOnSubscribe(s-> System.out.println("doOnSubscribe 1 : " + s))
                .doOnNext(o-> System.out.println("doOnNext : " + o))
                .doFirst(()-> System.out.println("doFirst 2"))
                .doFinally(signalType -> System.out.println("doFinally : " + signalType))
                .doOnComplete(()-> System.out.println("doOnComplete"))
                .doOnTerminate(()-> System.out.println("doOnTerminate"))
                .doOnSubscribe(s-> System.out.println("doOnSubscribe 2 : " + s))
                .doOnError(error->System.out.println("doOnError : " + error.getMessage()))
                .doOnRequest(r-> System.out.println("doOnRequest : " + r))
                .doOnCancel(()-> System.out.println("doOnCancel"))
                .doFirst(()-> System.out.println("doFirst 3"))
                .doOnDiscard(Object.class,d-> System.out.println("doOnDiscard : " + d))
                .take(2)
                .doFinally(signalType -> System.out.println("doFinally : " + signalType))
                .subscribe(Util.subscriber());

    }
}
