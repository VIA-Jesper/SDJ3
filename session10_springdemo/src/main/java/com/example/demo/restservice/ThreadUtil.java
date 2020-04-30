package com.example.demo.restservice;

public class ThreadUtil {
    public static void silentSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
