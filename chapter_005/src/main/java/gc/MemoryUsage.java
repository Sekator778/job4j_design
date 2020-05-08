package gc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Демонстрация работы GC
 * ни в какую не мог инициализировать GC
 * пока не усыпил
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

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start main");
        info();
        for (int i = 0; i < 3; i++) {
            User user = new User("First");
            user = null;

        }
        System.gc();
        Thread.sleep(100);
        System.out.println("finish main");
        info();

    }

    public static class User {
        public String name;

        public User(String name) {
            this.name = name;
//            a();
        }

        /**
         * StackOverflow
         */
        private void a() {
            a();
        }

        @Override
        public String toString() {
            return "User{" + "name='" + name + '\'' + '}';
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println(String.format("destroy object %s", this));
        }
    }
}
