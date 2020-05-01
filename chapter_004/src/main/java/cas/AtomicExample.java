package cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 *
 */

public class AtomicExample {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInt = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        IntStream.range(0, 1000).forEach(i -> executor.submit(atomicInt::incrementAndGet));
        executor.awaitTermination(100, TimeUnit.MILLISECONDS);
        System.out.println(atomicInt.get());    // => 1000
        executor.shutdown();
    }
}
