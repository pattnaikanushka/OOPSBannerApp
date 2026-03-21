// ...existing code...
import java.util.HashMap;

public class UseCase8 {
    public static HashMap<Character, String[]> createCharacterMap() {
        HashMap<Character, String[]> charMap = new HashMap<>();

        charMap.put('O', new String[]{
                " ***** ",
                "*     *",
                "*     *",
                "*     *",
                "*     *",
                "*     *",
                " ***** "
        });
        charMap.put('P', new String[]{
                "****** ",
                "*     *",
                "*     *",
                "****** ",
                "*      ",
                "*      ",
                "*      "
        });
        charMap.put('S', new String[]{
                " ***** ",
                "*      ",
                "*      ",
                " ***** ",
                "      *",
                "      *",
                " ***** "
        });

        return charMap;
    }

    public static void displayBanner(String message, HashMap<Character, String[]> charMap) {
        // determine pattern height and character width from available map entries
        int patternHeight = 0;
        int charWidth = 0;
        for (String[] pattern : charMap.values()) {
            if (pattern != null && pattern.length > 0) {
                patternHeight = pattern.length;
                charWidth = pattern[0].length();
                break;
            }
        }
        if (patternHeight == 0) return;

        for (int line = 0; line < patternHeight; line++) {
            for (int i = 0; i < message.length(); i++) {
                char ch = Character.toUpperCase(message.charAt(i));
                String[] pattern = charMap.get(ch);
                if (pattern != null && line < pattern.length) {
                    System.out.print(pattern[line]);
                } else {
                    // print blank space of charWidth when pattern missing
                    for (int s = 0; s < charWidth; s++) System.out.print(' ');
                }
                System.out.print(' '); // spacing between characters
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashMap<Character, String[]> charMap = createCharacterMap();
        String message = "OOPS";
        displayBanner(message, charMap);
    }
}