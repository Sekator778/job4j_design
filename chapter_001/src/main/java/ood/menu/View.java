package ood.menu;

import java.util.List;

/**
 * основной класс тут он формирует меню из строк записей
 * имеем поле recordStart - это всегда верхнее поле от которого стартуем
 * output - куда кидаем все эти строки
 */
public class View {
    private Record recordStart;
    private Output output;

    public View(Record record, Output output) {
        this.recordStart = record;
        this.output = output;
    }

    /**
     * главная логика на подобии Files.walkFileTree()
     * для стрима из записей выводим разделитель и имя записи
     * и каждый раз проверяем есть ли еще лист !!!!!!
     * тут самый важный момент если есть спускаемся и обрабатываем этот вложенный лист
     *
     * @param records лист вложенных записей в записи
     * @param delimiter - разделитель просто для вида
     */
    public void nestedRecord(List<Record> records, String delimiter) {
        records.forEach(record -> {
            output.output(delimiter + record.getName());
            if (record.getNestedRecords() != null) {
                nestedRecord(record.getNestedRecords(), delimiter + delimiter);
            }
        });
    }

    /**
     * начало выводим имя первого и по его списку стартуем перебор дерева
     */
    public void init() {
        output.output(recordStart.getName());
        String delimiter = "---- ";
        nestedRecord(recordStart.getNestedRecords(), delimiter);
    }
}
