package com.rp.ass01;

import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ass04FileServiceFile {
    public static void main(String[] args) {
        createfile().subscribe();
        writeFile().subscribe();
        readFile().subscribe();
    }
    
    public static Mono<String> createfile(){
        System.out.println("Creating file");
        return Mono.fromSupplier(()-> {
            try {
                File file = new File("S:\\React\\Programming Learning\\Reactor\\src\\main\\resources\\final.txt");
                file.createNewFile();
                return ("File Created Successfull");
            } catch (IOException e) {
                return ("File Created Failed");
            }
        });
    }

    public static Mono<String> writeFile(){
        System.out.println("Writing File");
        return Mono.fromSupplier(()->{
            FileWriter file = null;
            try {
                file = new FileWriter("S:\\React\\Programming Learning\\Reactor\\src\\main\\resources\\final.txt");
                file.write("This is me, Suvankar Biswas \n");
                file.write("O. Hendry's real name was William Sydney Porter");
                file.close();
                return "File writing Completed";
            } catch (IOException e) {
                return "Writing File Failed";
            }
        });
    }

    public static Mono<String> readFile(){
        System.out.println("Reading file");
        return Mono.fromSupplier(()->{
            Scanner file = null;
            try {
                file = new Scanner(new File("S:\\React\\Programming Learning\\Reactor\\src\\main\\resources\\final.txt"));
                while (file.hasNextLine())
                    System.out.println(file.nextLine());
                return "File reading Completed";
            } catch (FileNotFoundException e) {
                return ("Error in file reading");
            }
        });
    }
}
