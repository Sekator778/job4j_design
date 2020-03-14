package ood.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReportSalary {
    private Store store;

    public ReportSalary(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        List<Employer> list = new ArrayList<>(store.findBy(filter));
        list.sort(new NameComparator());
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        text.append(System.lineSeparator());
        for (Employer employer : list) {
            text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
