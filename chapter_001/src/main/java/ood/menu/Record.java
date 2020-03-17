package ood.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * наши записи а именно строки меню
 * сама строка и внутри себя еще вложеный список что от
 * нее идет как бы
 */
public class Record {
    private String name;
    private List<Record> nestedRecords;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Record> getNestedRecords() {
        return nestedRecords;
    }

    public void setNestedRecords(List<Record> nestedRecords) {
        this.nestedRecords = nestedRecords;
    }

    public Record(String name, List<Record> nestedRecords) {
        this.name = name;
        this.nestedRecords = nestedRecords;
    }
}
