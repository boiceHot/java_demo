package com.boicehot.asynchronous.asynService;

import org.springframework.stereotype.Service;
import javax.validation.constraints.NotBlank;
import java.util.concurrent.CompletableFuture;

@Service
public class SendSms {

    public void send(@NotBlank String mobile, @NotBlank String content){
        CompletableFuture.runAsync(() -> {
            // sendSms 异步发送短信
        });
    }
}