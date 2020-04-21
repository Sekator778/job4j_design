package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.InputStream;
import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Предположим, что нам нужно в консоль выводить сообщение раз в 10 секунд.
 */
public class AlertRabbit {
    public static void main(String[] args) {
        try {
            //1. Конфигурирование.
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            //2. Создание задачи.
            //quartz каждый раз создает объект с типом org.quartz.Job.
            // Вам нужно создать класс реализующий этот интерфейс.
            //Внутри этого класса нужно описать требуемые действия.
            // В нашем случае - это вывод на консоль текста.
            JobDetail job = newJob(Rabbit.class).build();
            //3. Создание расписания.
            //Конструкция выше настраивает периодичность запуска.
            // В нашем случае, мы будем запускать задачу через 10 секунд и делать это бесконечно.
            SimpleScheduleBuilder times = simpleSchedule()
                    .withIntervalInSeconds(new Rabbit().load())
                    .repeatForever();
            //4. Задача выполняется через триггер.
            Trigger trigger = newTrigger()
                    .startNow()
                    .withSchedule(times)
                    .build();
            //5. Загрузка задачи и триггера в планировщик
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

    public static class Rabbit implements Job {
        @Override
        public void execute(JobExecutionContext context) {
            System.out.println("Rabbit runs here ...");
        }

        public int load() {
            int result;
            try (InputStream in = Rabbit.class.getClassLoader().getResourceAsStream("rabbit.properties")) {
                Properties config = new Properties();
                config.load(in);
                result = Integer.parseInt(config.getProperty("delay"));
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            return result;
        }
    }
}