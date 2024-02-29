package theMorseChallenge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Converter converter = new Converter();
        Scanner scan = new Scanner(System.in);

        try {
        while (true) {
            System.out.print("Please enter a text in English or in Morse to translate it, use *- for Morse. Exit the program by writing exit: ");
            String input = scan.nextLine();

            boolean isEnglish = input.matches("[a-zA-Z0-9?!\\s/]+"); //space är också tillåtet. en typ av felhantering för att nå rätt metoder beroende på user input.
            boolean isMorse = input.matches("[-*\\s/]+");

            if (isMorse) {
                String englishResult = converter.convertToEnglish(input);
                System.out.println("English for " + input + " is: " + englishResult);
            } else if (isEnglish) {
                String morseResult = converter.convertToMorse(input);
                System.out.println("Morse for " + input + " is: " + morseResult);
            }
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program!");
                break;
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong, please try again and use only the characters *- for morse and only English alphabet");
        }
    }
}