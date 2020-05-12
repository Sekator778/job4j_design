package gc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Демонстрация работы GC
 */

public class MemoryUsage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryUsage.class);


    public static void info() {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("--- statistic [mB] ---");
        System.out.println("Max memory = " + runtime.maxMemory() / mb);
        System.out.println("Total memory = " + runtime.totalMemory() / mb);
        System.out.println("Free memory = " + runtime.freeMemory() / mb);
        System.out.println("Used memory = " + (runtime.totalMemory() - runtime.freeMemory()) / mb);

    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Start main");
        info();
        int count = 0;
        long memory = 0;
        for (int k = 0; k < 500000; k++) {

            for (int i = 0; i < 17; i++) {
                memory = (runtime.freeMemory() / 1024);
//            System.out.println(String.format("object before %s",  memory));
                User user = new User("Bob");
                memory = (runtime.freeMemory() / 1024);
//            System.out.println(String.format("object count %s, memory free %s", ++count,  memory));
                user = null;

            }
            System.gc();
//            Thread.sleep(100);
            System.out.println("finish main");
            info();
//            Thread.sleep(200);
        }

    }

}
