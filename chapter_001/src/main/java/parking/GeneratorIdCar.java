package parking;

import java.util.UUID;

/**
 * у меня есть проблема при инициализации номера паркоместа
 * надо его как то генерить и отдельно номера делать
 * но пока нету
 */

public class GeneratorIdCar {
    public static void main(String[] args) {
        String uniqueID = UUID.randomUUID().toString();
//        System.out.println(uniqueID);

    }

    public GeneratorIdCar() {

    }
}
