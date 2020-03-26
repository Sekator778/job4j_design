package myio;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> noValue = Optional.empty();
        Optional<String> value = Optional.of("ABCDEF");

        if (noValue.isPresent()) {
            System.out.println("no output");
        } else {
            System.out.println("noValue is emtpy");
        }
        if (value.isPresent()) {
            System.out.println("vslue present string: " + value.get());
        }

    }
}
