package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Part2 {

    public static int wordToNumber(String word) {
        switch (word) {
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
        }
        return 0;
    }


    public static void main(String[] args) throws Exception {
        ArrayList<String> numbersList = new ArrayList<>();
        numbersList.add("one");
        numbersList.add("two");
        numbersList.add("three");
        numbersList.add("four");
        numbersList.add("five");
        numbersList.add("six");
        numbersList.add("seven");
        numbersList.add("eight");
        numbersList.add("nine");
        numbersList.add("ten");
        numbersList.add("zero");

        //String fileName = "src/Day1/samplePartTwo.txt";
        String fileName = "src/Day1/inputPartTwo.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int sum = 0;
            for (String line : br.lines().toList()) {
                //for every line reset the array
                int[] numbersResult = new int[line.length()];
                Arrays.fill(numbersResult, -1); //init array with -1
                System.out.println("Current Line: " + line + ": ");

                //write any numbers into the array which are represented by words
                for (String number : numbersList) {
                    int pos = -1;
                    // Keep searching for the number in the line until no more occurrences are found
                    while ((pos = line.indexOf(number, pos + 1)) != -1) {
                        System.out.println(number + " at position " + pos);
                        numbersResult[pos] = wordToNumber(number);
                    }
                }

                //write any numbers into the array which are represented by digits
                //keep in mind not to overwrite any numbers which are already in the array
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        int number = Character.getNumericValue(line.charAt(i));
                        if (numbersResult[i] == -1) {
                            System.out.println(number + " at position " + i);
                            numbersResult[i] = number;
                        }
                    }
                }

                System.out.println(Arrays.toString(numbersResult));

                //calculate the sum of the array,
                //only 2 numbers and take the first and the last number
                String firstDigit = "";
                String lastDigit = "";

                for (int i = 0; i < numbersResult.length; i++) {
                    if (numbersResult[i] != -1) {
                        firstDigit += numbersResult[i];
                        break;
                    }
                }
                for (int i = numbersResult.length - 1; i >= 0; i--) {
                    if (numbersResult[i] != -1) {
                        lastDigit += numbersResult[i];
                        break;
                    }
                }
                if (firstDigit.isEmpty()) firstDigit = "0";
                if (lastDigit.isEmpty()) lastDigit = "0";
                String number = firstDigit + lastDigit;
                System.out.println(number);
                sum += Integer.parseInt(number);
            }
            System.out.println("Sum " + sum);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}