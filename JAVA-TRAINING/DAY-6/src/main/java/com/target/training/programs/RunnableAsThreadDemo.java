package com.target.training.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableAsThreadDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i =0;i<=10;i++){
                log.debug("Inside thread {} value of i is {}",Thread.currentThread().getName(),i);
        }
    });

        t1.start();


}

}
