package test.example;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {

        // Creating an empty HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();

        // Mapping string values to int keys
        hashMap.put(10, "Geeks");
        hashMap.put(15, "4");
        hashMap.put(20, "Geeks");
        hashMap.put(25, "Welcomes");
        hashMap.put(30, "You");

        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hashMap);

        // Checking for the Value 'Geeks'
        System.out.println("Is the value 'Geeks' present? " + hashMap.containsValue("Geeks"));

        // Checking for the Value 'World'
        System.out.println("Is the value 'World' present? " + hashMap.containsValue("World"));
    }
}