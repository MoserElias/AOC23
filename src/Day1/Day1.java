package Day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day1 {
    public static void main(String[] args) {
        String fileName = "src/Day1/input.txt";
        ///String fileName = "src/Day1/sample.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int sum = 0;
            //iterate over the lines from the string
            while ((line = br.readLine()) != null) {
                //iterate over the string
                String number = "";

                int index = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        number += line.charAt(i);
                        index = i;
                        break;
                    }
                }

                for (int i = line.length() - 1; i >= 0; i--) {
                    if (Character.isDigit(line.charAt(i)) && i != index) {
                        number += line.charAt(i);
                        break;
                    }
                }

                if (number.length() == 1) {
                    number += number.charAt(0);
                }

                //Debug
                System.out.println(number);

                if(number.length() == 2) {
                    sum += Integer.parseInt(number);
                }
            }
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
