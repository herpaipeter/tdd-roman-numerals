package hu.herpaipeter;

import java.util.Map;
import static java.util.Map.entry;

public class RomanNumerals {

    private final static Map<Integer, String> conversions =
            Map.ofEntries(
                    entry(1, "I"),
                    entry(2, "II"),
                    entry(3, "III"),
                    entry(4, "IV"),
                    entry(5, "V"),
                    entry(6, "VI"),
                    entry(7, "VII"),
                    entry(8, "VIII"),
                    entry(9, "IX"),
                    entry(10, "X"),
                    entry(20, "XX"),
                    entry(30, "XXX"),
                    entry(40, "XL"),
                    entry(50, "L"),
                    entry(60, "LX"),
                    entry(70, "LXX"),
                    entry(80, "LXXX"),
                    entry(90, "XC"),
                    entry(100, "C"),
                    entry(200, "CC"),
                    entry(300, "CCC"),
                    entry(400, "CD"),
                    entry(500, "D"),
                    entry(600, "DC"),
                    entry(700, "DCC"),
                    entry(800, "DCCC"),
                    entry(900, "CM"),
                    entry(1000, "M"),
                    entry(2000, "MM"),
                    entry(3000, "MMM"),
                    entry(4000, "MMMM")
            );

    public String getRomanFormat(int arabic) {
        validate(arabic);

        StringBuilder result = new StringBuilder();
        for (int place = 1000; 0 < arabic; place /= 10) {
            int arabicPlaceRounded = (arabic / place) * place;
            result.append(0 < arabicPlaceRounded ? conversions.get(arabicPlaceRounded) : "");
            arabic %= place;
        }
        return result.toString();
    }

    private static void validate(int arabic) {
        if (arabic <= 0 || 4999 < arabic)
            throw new NumberFormatException();
    }
}
