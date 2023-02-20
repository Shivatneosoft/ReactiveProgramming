package com.rp.sec03.helper;

import com.rp.courseutil.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {
    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        System.out.println("accept"); this.fluxSink = stringFluxSink;
    }

    public void produce(){
        this.fluxSink.next(Thread.currentThread().getName() + " : " +Util.faker().name().fullName());
    }
}
