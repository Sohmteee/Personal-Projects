package SubStrings;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> createSubStrings(int number) {
        String string = String.valueOf(number);
        List<String> sub = new ArrayList<>();

        int n = 1;

        while (n < string.length()) {
            for (int i = 0; i < string.length(); i++) {
                if (i + n <= string.length())
                    sub.add(string.substring(i, i + n));
            }
            n++;
        }
        sub.add(string);

        return sub;
    }

    public static void main(String[] args) {
        int n = 23195;

        System.out.println("Substrings of " + n + ": " + createSubStrings(n));
    }
}
