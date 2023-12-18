package com.hexaware.services;
import java.util.Locale;

public class AddressFormatter {
    public String formatAddress(String street, String city, String state, String zipCode) {
        String formattedStreet = capitalizeWords(street);
        String formattedCity = capitalizeWords(city);
        String formattedState = state.toUpperCase(Locale.ROOT); // Make state uppercase
        String formattedZip = formatZipCode(zipCode); // Format the zip code
        
        return formattedStreet + ", " + formattedCity + ", " + formattedState + " " + formattedZip;
    }

    private String capitalizeWords(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        
        String[] words = input.toLowerCase().split(" ");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1);
                result.append(capitalizedWord).append(" ");
            }
        }
        return result.toString().trim();
    }

    private String formatZipCode(String zipCode) {
        // Assuming zip code is in the format "123456" or "12345-6789"
        if (zipCode == null || zipCode.isEmpty()) {
            return "";
        }
        if (zipCode.length() > 5) {
            return zipCode.substring(0, 5) + "-" + zipCode.substring(5);
        }
        return zipCode;
    }
}
