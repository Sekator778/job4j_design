package srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import ood.srp.*;
import org.junit.Test;

import java.util.Calendar;

public class ReportEngineTest {
    MemStore store = new MemStore();

    @Test
    public void whenOldGenerated() {
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedSortSalaryDownAndWithoutHired() {
        Calendar now = Calendar.getInstance();
        Employer worker1 = new Employer("Ivan", now, now, 100);
        Employer worker2 = new Employer("Smith", now, now, 500);
        Employer worker3 = new Employer("Zinaida", now, now, 60);

        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportSalary engine = new ReportSalary(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(employer -> employer.getSalary() >= 0), is(expect.toString()));
    }

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

    @Test
    public void whenGeneratedForIT() {
        Calendar now = Calendar.getInstance();
        Employer worker1 = new Employer("Ivan", now, now, 100);
        Employer worker2 = new Employer("Smith", now, now, 500);
        store.add(worker1);
        store.add(worker2);
        ReportIT engine = new ReportIT(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<table> <tr> <td>")
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append("<tr>")
                .append(worker1.getName()).append(";")
                .append(worker1.getHired()).append(";")
                .append(worker1.getFired()).append(";")
                .append(worker1.getSalary()).append(";")
                .append("</tr>")
                .append("</td> <tr> </table>")
                .append(System.lineSeparator())
                .append("<tr>")
                .append(worker2.getName()).append(";")
                .append(worker2.getHired()).append(";")
                .append(worker2.getFired()).append(";")
                .append(worker2.getSalary()).append(";")
                .append("</tr>")
                .append("</td> <tr> </table>")
                .append(System.lineSeparator());
        assertThat(engine.generate(employer -> employer.getSalary() >= 0), is(expect.toString()));
    }
}
