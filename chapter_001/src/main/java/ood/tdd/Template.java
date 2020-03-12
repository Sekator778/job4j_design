package ood.tdd;

import java.util.Map;

/**
 * generator
 */
public interface Template {
    /**
     * генератор строк на основе данных из мапы
     * @param template - стринг
     * @param data - мапа с ключами и данними для замены
     * @return - готовая стринга
     */
    String generate(String template, Map<String, String> data);
}
