package theMorseChallenge;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRunner {

    @Test
    public void testConvertAToMorse() {
        Converter converter = new Converter();
        String input = "A";
        String expected = "*-";
        String actual = converter.convertToMorse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertMorseToA() {
        Converter converter = new Converter();
        String input = "*-";
        String expected = "A";
        String actual = converter.convertToEnglish(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToMorseWithSpaceIncluded() {
        Converter converter = new Converter();
        String input = "HELLO FRIEND";
        String expected = "**** * *-** *-** ---   **-* *-* ** * -* -**";
        String actual = converter.convertToMorse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToEnglishWithSpace() {
        Converter converter = new Converter();
        String input = "**** * *-** *-** ---   **-* *-* ** * -* -**";
        String expected = "HELLO  FRIEND";
        String actual = converter.convertToEnglish(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testWithNotAcceptableCharacterToEnglish() {
        Converter converter = new Converter();
        String input = "=";
        String expected = "";   //har inte deklarerat = som accepterat för isMorse därför går loopen om igen istället för att ge exception
        String actual = converter.convertToEnglish(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testNotEnglishCharacter() {
        Converter converter = new Converter();
        String input = "ö";
        String expected = "null";  //har inte deklarerat ö i boolean isEnglish därför går loopen om istället för att ge exception
        String actual = converter.convertToMorse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testUpperCaseEnglish() {
        Converter converter = new Converter();
        String input = "hello";
        String expected = "**** * *-** *-** ---";
        String actual = converter.convertToMorse(input); //testar min toUpperCase här
        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleNumbersInRow() {
        Converter converter = new Converter();
        String input = "12345";
        String expected = "*---- **--- ***-- ****- *****";  //Viktigt att min convertToMorse metod delar upp min string i char för att presentera resultatet med space!
        String actual = converter.convertToMorse(input);
        assertEquals(expected, actual);
    }
}

