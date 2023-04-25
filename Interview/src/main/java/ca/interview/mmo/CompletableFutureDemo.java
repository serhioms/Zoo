package ca.interview.mmo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class CompletableFutureDemo {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        executorService.submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }

    @Test
    public void testHelloStatic() throws Exception {
        Future<String> completableFuture = CompletableFuture.completedFuture("Hello");
        String result = completableFuture.get();
        assertEquals("Hello", result);
    }

    @Test
    public void testHelloAsynch() throws Exception {
        Future<String> completableFuture = calculateAsync();
        String result = completableFuture.get();
        assertEquals("Hello", result);
    }

    @Test
    public void testApply() throws Exception {
        CompletableFuture<String> completableFuture  = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future = completableFuture.thenApply(s -> s + " World");
        assertEquals("Hello World", future.get());
    }

    AtomicInteger  someStateVaribale = new AtomicInteger();

    public void process() {
        System.out.println(Thread.currentThread() + " Process");
        someStateVaribale.set(100);
    }
    @Test
    public void completableFutureRunAsync() {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> process());
        runAsync.join();
        assertEquals(100, someStateVaribale.get());
    }

}
