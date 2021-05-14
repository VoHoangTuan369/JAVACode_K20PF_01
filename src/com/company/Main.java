package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future> listFuture = new ArrayList<Future>();

        for (int i = 1; i <= 10; i++) {
            MyRunnable myRunnable = new MyRunnable("Runnable " + i);
            Future future = executorService.submit(myRunnable);
            listFuture.add(future);
        }
        for (Future future : listFuture) {
            try {
                System.out.println(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}

