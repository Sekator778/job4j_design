package ood.ocp;

import java.util.function.Predicate;

public interface ReportImp {
    String generate(Predicate<Employer> filter);
}
