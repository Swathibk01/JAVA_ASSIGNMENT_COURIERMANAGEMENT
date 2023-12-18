package com.hexaware.services;

public class AddressComparator {

    public boolean areAddressesSimilar(String address1, String address2) {
        // Convert both addresses to lowercase for case-insensitive comparison
        String lowerAddress1 = address1.toLowerCase();
        String lowerAddress2 = address2.toLowerCase();

        // Remove whitespace and punctuation to compare the addresses
        String cleanAddress1 = lowerAddress1.replaceAll("\\s+", "").replaceAll("[^a-zA-Z0-9]", "");
        String cleanAddress2 = lowerAddress2.replaceAll("\\s+", "").replaceAll("[^a-zA-Z0-9]", "");

        // Compare the cleaned addresses
        return cleanAddress1.equals(cleanAddress2);
    }
}
