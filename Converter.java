package theMorseChallenge;

import java.util.HashMap;

public class Converter {
    private final HashMap<Character, String> englishToMorse;
    private final HashMap<String, Character> morseToEnglish;
    public Converter() {
        englishToMorse = new HashMap<>();
        morseToEnglish = new HashMap<>();
        englishToMorse.put('A', "*-");
        englishToMorse.put('B', "-***");
        englishToMorse.put('C', "-*-*");
        englishToMorse.put('D', "-**");
        englishToMorse.put('E', "*");
        englishToMorse.put('F', "**-*");
        englishToMorse.put('G', "--*");
        englishToMorse.put('H', "****");
        englishToMorse.put('I', "**");
        englishToMorse.put('J', "*---");
        englishToMorse.put('K', "-*-");
        englishToMorse.put('L', "*-**");
        englishToMorse.put('M', "--");
        englishToMorse.put('N', "-*");
        englishToMorse.put('O', "---");
        englishToMorse.put('P', "*--*");
        englishToMorse.put('Q', "--*-");
        englishToMorse.put('R', "*-*");
        englishToMorse.put('S', "***");
        englishToMorse.put('T', "-");
        englishToMorse.put('U', "**-");
        englishToMorse.put('V', "***-");
        englishToMorse.put('W', "*--");
        englishToMorse.put('X', "-**-");
        englishToMorse.put('Y', "-*--");
        englishToMorse.put('Z', "--**");
        englishToMorse.put('0', "-----");
        englishToMorse.put('1', "*----");
        englishToMorse.put('2', "**---");
        englishToMorse.put('3', "***--");
        englishToMorse.put('4', "****-");
        englishToMorse.put('5', "*****");
        englishToMorse.put('6', "-****");
        englishToMorse.put('7', "--***");
        englishToMorse.put('8', "---**");
        englishToMorse.put('9', "----*");
        englishToMorse.put('.', "*-*-*-");
        englishToMorse.put(',', "--**--");
        englishToMorse.put('?', "**--**");
        englishToMorse.put('!', "-*-*--");
        englishToMorse.put(' ', " ");       //felhantering för att space ska vara accepterat

        englishToMorse.forEach((key, value) -> morseToEnglish.put(value, key));
    }

    public String convertToMorse(String english) {
        StringBuilder theMorse = new StringBuilder();
        for (char myChar : english.toUpperCase().toCharArray()) {  //felhantering för att kunna ta emot både stora + små bokstäver
            theMorse.append(englishToMorse.get(myChar)).append(" "); // vill presentera resultatet med både space mellan orden samt mellan alla morse-tecken
        }
        return theMorse.toString().trim(); //tar bort space i slutet av mening bl.a
    }

    public String convertToEnglish(String morse) {
        StringBuilder theEnglish = new StringBuilder();
        for (String morseChar : morse.split(" ")) { //delar upp morsetexten till morsetecken
            if (morseChar.isEmpty()) { //
                theEnglish.append(" "); // söker efter space och lägger till ett space igen eftersom vi ovan delade upp tecknen vid space
            } else if (morseToEnglish.containsKey(morseChar)) {
                theEnglish.append(morseToEnglish.get(morseChar));
            }
        }
        return theEnglish.toString(); // måste sätta toString för att metoden är en public String och kräver den returtypen
    }
}
