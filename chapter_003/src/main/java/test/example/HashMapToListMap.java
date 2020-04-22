package test.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapToListMap {

    public static void main(String[] args) {
        Map<String, Integer> citiesWithCodes = new HashMap<>();
        citiesWithCodes.put("Berlin", 49);
        citiesWithCodes.put("Frankfurt", 49);
        citiesWithCodes.put("Hamburg", 49);
        citiesWithCodes.put("Cologne", 49);
        citiesWithCodes.put("Salzburg", 43);
        citiesWithCodes.put("Vienna", 43);
        citiesWithCodes.put("Zurich", 41);
        citiesWithCodes.put("Bern", 41);
        citiesWithCodes.put("Interlaken", 41);


        Map<Integer, List<String>> result = citiesWithCodes.entrySet().stream().collect(Collectors.groupingBy(
                Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(result);
    }

}