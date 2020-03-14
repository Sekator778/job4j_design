package ood.srp;

import java.util.function.Predicate;

//запись1</td> <td>запись2</td> <td>запись3</td> <td>запись4
public class ReportIT {
    private Store store;

    public ReportIT(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<table> <tr> <td>");
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());

        for (Employer employer : store.findBy(filter)) {
            text.append("<tr>")
                    .append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append("</tr>")
                    .append("</td> <tr> </table>")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}