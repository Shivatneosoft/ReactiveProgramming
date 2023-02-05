package com.rp.ass01;

import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class Ass03FileServiceReadFile {
    public static void main(String[] args) {
        readingFile().subscribe(data->{
            System.out.println(data);
        });
    }

    public static Mono<String> readingFile(){
        System.out.println("Reading File");
        return Mono.fromSupplier(()->{
            Scanner file = null;
            try {
                file = new Scanner(new File("S:\\React\\Programming Learning\\Reactor\\src\\main\\resources\\\\sample.txt"));
                System.out.println("File read Successfully, Here it begin \n");
                while(file.hasNextLine())
                    System.out.println(file.nextLine());
                return "Done";
            } catch (FileNotFoundException e) {
                return("Cannot read file");
            }
        });
    }
}
