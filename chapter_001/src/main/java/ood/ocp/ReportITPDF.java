package ood.ocp;

import java.util.function.Predicate;

public class ReportITPDF implements ReportImp {
    private final ReportIT reportIT;

    public ReportITPDF(Store store) {
        this.reportIT = new ReportIT(store);
    }

    public String generate(Predicate<Employer> filter) {
        String output = reportIT.generate(filter);
        output += "Compile file to PDF";
        return output;
    }
}

