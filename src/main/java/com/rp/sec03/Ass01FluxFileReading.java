package com.rp.sec03;

import com.rp.courseutil.Util;
import com.sun.source.tree.WhileLoopTree;
import reactor.core.publisher.Flux;
import reactor.core.publisher.MonoSink;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ass01FluxFileReading {

    public static void main(String[] args) {

        Flux.create(fluxSink ->{
                    try {
                        Scanner file = new Scanner(new File("S:\\React\\Programming Learning\\Reactor\\src\\main\\resources\\final.txt"));
                        while (file.hasNextLine()){
                            fluxSink.next(file.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    fluxSink.complete();
                }
            )
                .subscribe(Util.utilSubscriber());

    }

}
