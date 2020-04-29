package ood.srp;

import ood.ocp.Employer;

import java.util.Comparator;

public class NameComparator implements Comparator<Employer> {

    @Override
    public int compare(Employer o1, Employer o2) {
        return (int) (o2.getSalary() - o1.getSalary());
    }
}
