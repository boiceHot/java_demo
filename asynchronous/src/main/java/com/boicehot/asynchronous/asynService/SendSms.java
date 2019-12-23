package com.boicehot.asynchronous.asynService;

import org.springframework.stereotype.Service;
import javax.validation.constraints.NotBlank;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

@Service
public class SendSms {

    private ForkJoinPool forkJoinPool = new ForkJoinPool(15);

    public void send(@NotBlank String mobile, @NotBlank String content){
//        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        forkJoinPool.submit(() -> CompletableFuture.runAsync(() -> {
            // sendSms 异步发送短信
        }));
    }
}