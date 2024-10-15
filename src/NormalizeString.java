

import java.util.*;

public class NormalizeString {
    public static String normalize(String input) {
        // Step 1: Remove leading and trailing spaces
        input = input.trim();

        // Step 2: Remove special characters, keep alphanumeric and spaces
        input = input.replaceAll("[^a-zA-Z0-9\\s]", "");

        // Step 3: Replace multiple spaces with a single space
        input = input.replaceAll("\\s+", " ");

        // Step 4: Convert to camel case
        String[] words = input.split(" ");
        StringBuilder camelCaseString = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                camelCaseString.append(Character.toUpperCase(word.charAt(0)));
                camelCaseString.append(word.substring(1).toLowerCase());
                camelCaseString.append(" ");
            }
        }

        // Return the final camel case string after removing trailing spaces
        return camelCaseString.toString().trim();
    }

    public static void main(String[] args) {
        String input = " Hello! World@ This is a Test!. ";
        System.out.println(normalize(input)); // Output: "Hello World This Is A Test"
    }
}
