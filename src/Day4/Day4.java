package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {

    public static void main(String[] args) {
        try {
            // Read double numbers from the Cardboard
            // 1 + 1 + 2 + 4 = 8
            //BufferedReader reader = new BufferedReader(new FileReader("src/Day4/sample.txt"));
            BufferedReader reader = new BufferedReader(new FileReader("src/Day4/input.txt"));
            String line = "";
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String string1 = parts[0].trim();
                    string1 = string1.replaceFirst("^Card\\s+\\d+:", "").trim();
                    String string2 = parts[1].trim();

                    //print the two strings
                    System.out.println(string1);
                    System.out.println(string2);

                    //parse first string part
                    String[] numberStrings = string1.split("\\s+");
                    int[] numbers = new int[numberStrings.length];
                    for (int i = 0; i < numberStrings.length; i++) {
                        numbers[i] = Integer.parseInt(numberStrings[i]);
                    }

                    //parse second string part
                    String[] numbersString2 = string2.split("\\s+");
                    int[] numbers2 = new int[numbersString2.length];
                    for (int i = 0; i < numbersString2.length; i++) {
                        numbers2[i] = Integer.parseInt(numbersString2[i]);
                    }

                    List<Integer> doubles = new ArrayList<>();
                    for (int num : numbers) {
                        if (Arrays.stream(numbers2).anyMatch(x -> x == num)) {
                            doubles.add(num);
                        }
                    }

                    System.out.println(doubles);

                    int lastAddition = 0;
                    if (!doubles.isEmpty()) {
                        for (int i = 0; i < doubles.size(); i++) {
                            if (lastAddition == 0) {
                                lastAddition = 1;
                            } else {
                                lastAddition = lastAddition * 2;
                            }
                        }
                        System.out.println("Points: " + lastAddition);
                    }
                    sum += lastAddition;
                } else {
                    System.out.println("error");
                }
            }
            System.out.println(sum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
