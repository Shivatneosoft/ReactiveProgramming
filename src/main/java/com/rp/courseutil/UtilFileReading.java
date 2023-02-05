package com.rp.courseutil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class UtilFileReading implements Subscriber<Object> {

    private String name = null;

    UtilFileReading(String name){
        this.name = name;
    }

    UtilFileReading(){
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(o);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println((name != null) ? name + " Error : " + t.getMessage() : "Error : " + t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Complete");
    }
}
