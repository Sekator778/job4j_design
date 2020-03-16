package srp;

import ood.srp.Employer;
import ood.srp.MemStore;
import ood.srp.ReportAccounter;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestReportForAccount {
    MemStore store = new MemStore();
    @Test
    public void whenGeneratedSalaryInDollar() {
        Calendar now = Calendar.getInstance();
        Employer worker1 = new Employer("Ivan", now, now, 100);
        Employer worker2 = new Employer("Smith", now, now, 500);
        Employer worker3 = new Employer("Zinaida", now, now, 60);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportAccounter engine = new ReportAccounter(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append("4.0").append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append("19.0").append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append("2.0").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(employer -> true), is(expect.toString()));
    }
}
