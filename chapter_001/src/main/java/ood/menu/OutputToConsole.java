package ood.menu;

/**
 * переопределяем метод интерфейса для вывода в консоль
 */
public class OutputToConsole implements Output {
    @Override
    public void output(String string) {
        System.out.println(string);
    }
}
