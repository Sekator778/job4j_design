package ood.ocp;

import java.util.function.Predicate;

public class ReportAccouterXML implements ReportImp {
    private final ReportAccounter reportAccounter;

    public ReportAccouterXML(Store store) {
        reportAccounter = new ReportAccounter(store);
    }

    public String generate(Predicate<Employer> filter) {
        String output = reportAccounter.generate(filter);
        output += "Output to XML file";
        return output;
    }
}
