package ood.srp;

import java.util.function.Predicate;

public class ReportITPDF extends ReportIT {
    public ReportITPDF(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        String output = super.generate(filter);
        output += "Compile file to PDF";
        return output;
    }
}

