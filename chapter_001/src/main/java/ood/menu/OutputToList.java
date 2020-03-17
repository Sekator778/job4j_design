package ood.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * вывод добавлением строк в лист
 */
public class OutputToList implements Output {
    private static List<String> records = new ArrayList<>();

    @Override
    public void output(String string) {
        records.add(string);
    }

    /**
     * получаем лист ну чтоб класс закрытые поля
     * тоесть типа гетера
     * @return лист строк
     */
    public List<String> viewList() {
        return records;
    }

    /**
     * ????????????7
     * тут вопрос тесты падали так как лист был 1н и тот же
     * почему я пробовал создавать новый екземпляр класса
     * а он всеравно тот же подтягивал лист
     * тут его в 0 лист
     */
    public void clear() {
        records.clear();
    }
}
