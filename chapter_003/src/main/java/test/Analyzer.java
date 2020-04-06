package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Sekator  : mail sekator778@gmail.com
 * данный клас показывает нам измениения в списке
 * тоесть берем список оттуда содержимое и сравниваем до и после
 * каких то действий со списком
 */

public class Analyzer {
    /**
     *1е всех текущих(на данный момент активных) юзеров в мапу по номеру и имени
     * 2е вытаскиваем с предыдущего листа юзера
     * и по его айди пытаемся достать чето с карты
     * 3 если его нету то нулл а значит юзера делейт
     * 4 если юзера нейм и юзера ранее того же по айди нейм не еквуалс значит чейндж по имени
     * 5. подсчитываем количество сейчас без ранее и без удаленных = скоко добавили
     * @param previous лист до изменений
     * @param current - лист на данное время
     * @return класс инфо с заполнеными полями с п5 п4 п3
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, User> temp = new HashMap<>();
        current.forEach(user ->
                temp.put(user.id, user));
        previous.forEach(previousUser -> {
            User user = temp.get(previousUser.id);
            if (user == null) {
                info.deleted++;
            } else if (!Objects.equals(user.name, previousUser.name)) {
                info.changed++;
            }
        });
        info.added = current.size() - (previous.size() - info.deleted);
        return info;

    }

    /**
     * some user
     */
    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * class for checked
     * have 3 fields
     */
    public static class Info {
        int added;
        int changed;
        int deleted;
    }

}