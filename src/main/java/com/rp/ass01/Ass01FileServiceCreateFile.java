package com.rp.ass01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;

public class Ass01FileServiceCreateFile {
    public static void main(String[] args) {
        createFile().subscribe();
    }

    public static Mono<String> createFile(){
        System.out.println("Creating File");
        return Mono.fromSupplier(()->{
            File file = new File("S:\\React\\Programming Learning\\Reactor\\src\\main\\resources\\sample.txt");
            try {
                file.createNewFile();
                return("File Creation Successful");
            } catch (IOException e) {
                return("File Creation Failed");
            }
        });
    }
}
