package com.example.randomstring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * REST controller providing endpoints for the Random String API.
 */
@RestController
public class RandomStringController {

    private static final int DEFAULT_LENGTH = 10;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CHARACTERS_LENGTH = CHARACTERS.length();

    /**
     * Home endpoint that returns information about available endpoints.
     *
     * @return Map containing welcome message and endpoint information
     */
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to the Random String API");
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("/random-string", "Returns a random string");
        response.put("endpoints", endpoints);
        
        return response;
    }

    /**
     * Endpoint that returns a random string.
     *
     * @return Map containing the randomly generated string
     */
    @GetMapping("/random-string")
    public Map<String, String> randomString() {
        Map<String, String> response = new HashMap<>();
        response.put("random_string", generateRandomString(DEFAULT_LENGTH));
        return response;
    }

    /**
     * Generates a random string of the specified length.
     *
     * @param length The length of the random string to generate
     * @return A random string containing alphanumeric characters
     */
    private String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = ThreadLocalRandom.current().nextInt(CHARACTERS_LENGTH);
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}
