package com.hexaware.services;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[{]};:'\",<.>/?";

    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure the password contains at least one character from each category
        password.append(UPPER.charAt(random.nextInt(UPPER.length())));
        password.append(LOWER.charAt(random.nextInt(LOWER.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

        // Fill the rest of the password length randomly
        for (int i = 4; i < length; i++) {
            String allChars = UPPER + LOWER + DIGITS + SPECIAL_CHARS;
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle the password characters
        return shuffle(password.toString());
    }

    private static String shuffle(String str) {
        char[] characters = str.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = (int) (Math.random() * characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }

   
}
