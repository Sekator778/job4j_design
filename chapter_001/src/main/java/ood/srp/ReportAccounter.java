package ood.srp;

import java.util.function.Predicate;

public class ReportAccounter {
    private Store store;
    private final double dollar = 26.0;

    public ReportAccounter(Store store) {
        this.store = store;
    }
    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        text.append(System.lineSeparator());

        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";");
                    double salary = Math.round(employer.getSalary() / dollar);
                    text.append(salary).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
