package ood.srp;

import java.util.function.Predicate;

public class ReportAccouterXML extends ReportAccounter {

    public ReportAccouterXML(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employer> filter) {
        String output = super.generate(filter);
        output += "Output to XML file";
        return output;
    }
}
