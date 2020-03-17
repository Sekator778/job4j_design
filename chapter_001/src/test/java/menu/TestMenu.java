package menu;

import ood.menu.OutputToList;
import ood.menu.Record;
import ood.menu.View;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestMenu {
    @Test
    public void whenTestOneString() {
        Record record1 = new Record("record1", null);
        List<Record> menu1 = List.of(record1);
        Record startMenu = new Record("Start menu", menu1);
        View view = new View(startMenu, new OutputToList());
        new OutputToList().clear();
        view.init();
        List<String> expect = List.of("Start menu", "---- record1");
        assertThat(new OutputToList().viewList(), is(expect));
    }

    @Test
    public void whenTestNestedString() {
        Record record3 = new Record("record3", null);
        List<Record> menu3 = List.of(record3);

        Record record2 = new Record("record2", menu3);
        List<Record> menu2 = List.of(record2, record2, record2);

        Record record1 = new Record("record1", menu2);
        List<Record> menu1 = List.of(record1);

        Record startMenu = new Record("Start menu", menu1);

        View view = new View(startMenu, new OutputToList());
        view.init();
        List<String> expect = List.of("Start menu", "---- record1", "---- ---- record2", "---- ---- ---- ---- record3", "---- ---- record2", "---- ---- ---- ---- record3", "---- ---- record2", "---- ---- ---- ---- record3");

        assertThat(new OutputToList().viewList(), is(expect));
    }
}
