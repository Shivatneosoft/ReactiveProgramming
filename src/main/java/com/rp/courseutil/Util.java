package com.rp.courseutil;

import com.github.javafaker.Faker;

import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class Util {

    public static final Faker FAKER = Faker.instance();
    public static Consumer<Object> onNext(){
        return o-> System.out.println("Recieved :" +o );
    }

    public static Consumer<Throwable> onError(){
        return err-> System.out.println("Error :" +err.getMessage()  );
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completed");
    }

    public static Faker faker(){
        return FAKER;
    }

    public static void sleep(int i){
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static DefaultSubscriber subscriber(String name){
        return new DefaultSubscriber(name);
    }

    public static UtilFileReading utilSubscriber(String name){
        return new UtilFileReading(name);
    }

    public static DefaultSubscriber subscriber(){
        return new DefaultSubscriber();
    }

    public static UtilFileReading utilSubscriber(){
        return new UtilFileReading();
    }
}
