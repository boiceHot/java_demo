package com.boicehot.asynchronous.api;

import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class TestAsynchronous {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 1);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 2);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 3);
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.allOf(future1, future2, future3).thenApplyAsync(t -> {
            Integer integer = 0, integer1 = 0, integer2 = 0;
            try {
                integer = future1.get();
                integer1 = future2.get();
                integer2 = future3.get();
                System.out.println(String.format("%s-%s-%s", integer, integer1, integer2));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return integer + integer1 + integer2;
        });
        System.out.println(integerCompletableFuture.get());
        CompletableFuture.supplyAsync(System::currentTimeMillis).thenAccept(System.out::println);
        CompletableFuture.supplyAsync(() -> null).thenAcceptAsync(t -> System.out.println(String.format("%s success", t)));
    }
}