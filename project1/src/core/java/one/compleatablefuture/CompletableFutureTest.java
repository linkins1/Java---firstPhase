package core.java.one.compleatablefuture;


import java.io.File;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<Integer> Future = CompletableFuture.supplyAsync(() -> 1);
        Future.thenApply(x -> x + 1).
                thenAcceptAsync(System.out::println);
        Future.thenCompose(x -> java.util.concurrent.CompletableFuture.supplyAsync(() -> x + 2)).
                thenAccept(System.out::println);

        CompletableFuture.supplyAsync(() -> getValue()).
                thenApply(x -> x + 1).
                exceptionally(th -> 91).
                thenAccept(System.out::println);

    }

    public static int getValue() {
        blowUp();
        return 5;
    }

    public static void blowUp() {
        throw new RuntimeException();
    }
}
