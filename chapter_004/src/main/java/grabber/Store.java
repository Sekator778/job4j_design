package grabber;


import java.util.List;
import java.util.function.Predicate;

/**
 * Хранилище.
 *
 * Наш проект будет хранить данные в базе Postgresql. Связь с базой будет осуществляться через интерфейс
 * Интерфейс позволяют избавиться от прямой зависимости.
 * На первом этапе можно использовать MemStore - хранения данных в памяти.
 */

public interface Store {
    /**
     * Метод save - сохраняет объявление в базе.
     */
    void save(Post post);

    /**
     * Метод get - позволяет извлечь объявление из базы.
     */
    List<Post> get(Predicate<Post> filter);
}