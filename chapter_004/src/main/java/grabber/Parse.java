package grabber;

import java.util.List;

/**
 *Извлечение данных с сайта.
 *
 * Операция извлечения данных с  сайта описывается отдельным интерфейсом.
 *
 * Этот компонент позволяет собрать короткое описание всех объявлений, а так же загрузить детали по каждому объявлению.
 *
 * list(link) - этот метод загружает список объявлений по ссылке типа - https://www.sql.ru/forum/job-offers/1
 *
 * detail(link) - этот метод загружает детали объявления по ссылке типа - https://www.sql.ru/forum/1323839/razrabotchik-java-g-kazan
 *
 * Описание компонента через интерфейс позволяет расширить наш проект.
 *
 * Например, осуществить сбор данных с других площадок: SqlRuParse, HhRuParse, SuperJobParse.
 */

public interface Parse {
    List<Post> list(String link);

    Post detail(String link);
}
