package srp;

import ood.srp.Employer;
import ood.srp.MemStore;
import ood.srp.ReportIT;
import ood.srp.ReportITPDF;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestReportITPDF {
    MemStore store = new MemStore();

    @Test
    public void whenGeneratedForITtoPDF() {
        Calendar now = Calendar.getInstance();
        Employer worker1 = new Employer("Ivan", now, now, 100);
        Employer worker2 = new Employer("Smith", now, now, 500);
        store.add(worker1);
        store.add(worker2);
        ReportIT engine = new ReportITPDF(store);
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
                .append(System.lineSeparator())
                .append("Compile file to PDF");
        assertThat(engine.generate(employer -> employer.getSalary() >= 0), is(expect.toString()));
    }
}
