package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Запомните правило, если в проекте используется логгер,
 * то для вывода ошибок или отладочной информации нужно использовать только логгер.
 */
public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        String name = "Alexandr Nikolaichuck";
        int age = 39;
        LOG.debug("User info name: {}, age: {}", name, age);
        boolean rsl = true;
        char ch = 7;
        byte bt = -128;
        short st = 8;
        int i = 32;
        float fl = 7.0f;
        double d = 1.123d;
        long lg = 23456789122345L;
        LOG.info("This a {} primitive type char {}, byte {}, our beloved integer" +
                " {}, редко используемый float {} с точкой дабл {}, большой лонгггг" +
                " {} говрящий да или нет boolean {}", st, ch, bt, i, fl, d, lg, rsl);
        exceptionToLog();

    }
    public static void exceptionToLog() {
        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            LOG.error("Exception on Log example ", e);
        }
    }
}