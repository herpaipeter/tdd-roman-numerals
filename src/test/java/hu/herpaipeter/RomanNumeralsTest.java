package hu.herpaipeter;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RomanNumeralsTest {

    @Test
    void zeroAndNegativeThrowsException() {
        RomanNumerals romans = new RomanNumerals();
        assertThrows(NumberFormatException.class, () -> {
            romans.getRomanFormat(0);
        });
        assertThrows(NumberFormatException.class, () -> {
            romans.getRomanFormat(-1);
        });
    }

    @Test
    void oneIsI() {
        RomanNumerals romans = new RomanNumerals();
        String rNum = romans.getRomanFormat(1);
        assertEquals("I", rNum);
    }

    @Test
    void twoIsII() {
        RomanNumerals romans = new RomanNumerals();
        String rNum = romans.getRomanFormat(2);
        assertEquals("II", rNum);
    }

    @Test
    void elevenIsXI() {
        RomanNumerals romans = new RomanNumerals();
        String rNum = romans.getRomanFormat(11);
        assertEquals("XI", rNum);
    }

    @Test
    void twenty() {
        RomanNumerals romans = new RomanNumerals();
        String rNum = romans.getRomanFormat(20);
        assertEquals("XX", rNum);
    }

    @Test
    void longUnder100() {
        RomanNumerals romans = new RomanNumerals();
        String rNum = romans.getRomanFormat(89);
        assertEquals("LXXXIX", rNum);
    }

    @Test
    void over100() {
        RomanNumerals romans = new RomanNumerals();
        String rNum = romans.getRomanFormat(189);
        assertEquals("CLXXXIX", rNum);
    }

    @Test
    void over1000() {
        RomanNumerals romans = new RomanNumerals();
        String rNum = romans.getRomanFormat(2489);
        assertEquals("MMCDLXXXIX", rNum);
    }

    @Test
    void zerosInTheMiddle() {
        RomanNumerals romans = new RomanNumerals();
        String rNum = romans.getRomanFormat(2009);
        assertEquals("MMIX", rNum);
    }

    @Test
    void roman3999() {
        RomanNumerals romans = new RomanNumerals();
        String rNum = romans.getRomanFormat(3999);
        assertEquals("MMMCMXCIX", rNum);
    }

    @Test
    void lastValidNumberIs4999() {
        RomanNumerals romans = new RomanNumerals();
        String rNum = romans.getRomanFormat(4999);
        assertEquals("MMMMCMXCIX", rNum);
    }

    @Test
    void over4999ThrowsException() {
        RomanNumerals romans = new RomanNumerals();
        assertThrows(NumberFormatException.class, () -> {
            romans.getRomanFormat(5000);
        });
    }
}
