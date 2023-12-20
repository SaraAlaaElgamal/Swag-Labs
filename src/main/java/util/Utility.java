package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utility {
    public static int generateRandomInt(int max) {
        Random random = new Random();
        return random.nextInt(max) + 1;
    }
    public static List<Integer> generateNonRepeatingRandomNumbers(int max, int count) {
        if (count > max) {
            throw new IllegalArgumentException("Cannot generate more numbers than the range (1-6).");
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, count);
    }
    public static int[] generateNumbers(int start, int end) {
        int[] numbers = new int[end - start + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = start + i;
        }
        return numbers;
    }
    public static float stringToFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            // Handle the exception
            return -1f; // or throw your own exception
        }
    }
}

