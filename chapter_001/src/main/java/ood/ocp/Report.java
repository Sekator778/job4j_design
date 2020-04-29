package ood.ocp;

import java.util.function.Predicate;

public class Report {
    public String report(ReportImp report, Predicate<Employer> filter) {
       return report.generate(filter);
    }
}
