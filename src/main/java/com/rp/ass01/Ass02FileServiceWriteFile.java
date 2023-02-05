package com.rp.ass01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.io.FileWriter;
import java.io.IOException;

public class Ass02FileServiceWriteFile {
    public static void main(String[] args) {
        writeFile("William Sydney Porter").subscribe(data->{
            System.out.println(data);
        });
    }

    public static Mono<String> writeFile(String line) {
        System.out.println("Ass02FileServiceWriteFile.writeFile");
        return Mono.fromSupplier(()->{
            System.out.println("Getting Files");
            try {
                FileWriter file = new FileWriter("S:\\React\\Programming Learning\\Reactor\\src\\main\\resources\\sample.txt");
                file.write(line);
                file.close();
                return "Successfull file write";
            } catch (IOException e) {
                return "Error in writing file";
            }
        });
    }
}
