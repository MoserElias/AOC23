package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Day2 {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Day2/sample.txt"));
            //BufferedReader reader = new BufferedReader(new FileReader("src/Day2/input.txt"));
            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

                //init the integer values
                final int redCap = 12;
                final int greenCap = 13;
                final int blueCap = 14;

                //get the game id -> save into integer variable, game id goes from 1 to 100
                String[] parts = line.split(" ");
                String gameInfo = parts[1].trim();

                //extract the game id
                String currentGameId = gameInfo.substring(0, gameInfo.length() - 1);
                int currentGameIdInt = Integer.parseInt(currentGameId);

                //get the number of red, green and blue values
                //build a substring from the line, which only contains the values
                String key = ":";
                int start = line.indexOf(key) + key.length();
                String values = line.substring(start);
                String[] valuesArray = values.split(";");

                int error = 0;
                for (String part : valuesArray) {

                    int blue = 0;
                    int green = 0;
                    int red = 0;

                    part = part.trim();
                    System.out.println(part);
                    String[] subParts = part.split(",");
                    for (String subPart : subParts) {
                        subPart = subPart.trim();
                        String[] colorAndValue = subPart.split(" ");
                        int value = Integer.parseInt(colorAndValue[0]);
                        String color = colorAndValue[1];
                        switch (color) {
                            case "red":
                                red += value;
                                break;
                            case "green":
                                green += value;
                                break;
                            case "blue":
                                blue += value;
                                break;
                        }
                    }
                    //check the values and the cap
                    if (red > redCap || green > greenCap || blue > blueCap) {
                        error = 1;
                        break;
                    }
                }
                if (error == 0) {
                    sum += currentGameIdInt;
                }
            }
            System.out.println("Sum: " + sum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
