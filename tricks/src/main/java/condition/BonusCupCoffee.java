package condition;

public class BonusCupCoffee {
    public static int countCup(int count, int n) {
        int bonusCup = count / n;
        return (count + bonusCup);
    }
}