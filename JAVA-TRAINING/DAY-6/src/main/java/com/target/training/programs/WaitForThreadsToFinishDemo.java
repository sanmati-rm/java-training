package com.target.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitForThreadsToFinishDemo {

    static void print(String msg,int limit){
        for(int i=0;i<=limit;i++){
            log.debug("msg = {}, i={}", msg,i);
        }
    }

    @SneakyThrows
    public static void main(String[] args) {

        Thread t1,t2;

        t1= new Thread(() -> print("Hello",10));
        t2= new Thread(() -> print("Hi",20));

        t1.start();
        t2.start();

        log.debug("Sanmati");

        t1.join();
        t2.join();

        log.debug("End of main");


    }
}
