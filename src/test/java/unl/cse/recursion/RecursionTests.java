package unl.cse.recursion;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class RecursionTests {
    @Test
    void isPalindromeTest() {
        Palindrome palindromeTester = new Palindrome();
        assertTrue(palindromeTester.isPalindrome("tacocat"));
        assertTrue(palindromeTester.isPalindrome("mom"));
        assertTrue(palindromeTester.isPalindrome("dad"));
        assertTrue(palindromeTester.isPalindrome("lol"));
        assertTrue(palindromeTester.isPalindrome("a"));
        assertTrue(palindromeTester.isPalindrome(""));
        assertTrue(palindromeTester.isPalindrome("aaaa"));
        assertTrue(palindromeTester.isPalindrome("live evil"));
        assertTrue(palindromeTester.isPalindrome("graarg"));
        assertTrue(palindromeTester.isPalindrome("madam"));
        assertTrue(palindromeTester.isPalindrome("radar"));
        assertTrue(palindromeTester.isPalindrome("reviver"));
        assertTrue(palindromeTester.isPalindrome("rotator"));
        assertTrue(palindromeTester.isPalindrome("1010101010101"));

        assertFalse(palindromeTester.isPalindrome("Bourke"));
        assertFalse(palindromeTester.isPalindrome("CSCE156"));
        assertFalse(palindromeTester.isPalindrome("Java"));
        assertFalse(palindromeTester.isPalindrome("tac ocat"));
        assertFalse(palindromeTester.isPalindrome("WebGrader"));
        assertFalse(palindromeTester.isPalindrome("This, most certainly, is not a palindromic sentence."));
    }

    @Test
    void pellNumberTest() {
        assertTimeout(Duration.ofSeconds(60), () -> {
            assertEquals(BigInteger.valueOf(1), PellNumbers.PellNumber(1));
            assertEquals(BigInteger.valueOf(2), PellNumbers.PellNumber(2));
            assertEquals(BigInteger.valueOf(5), PellNumbers.PellNumber(3));
            assertEquals(BigInteger.valueOf(12), PellNumbers.PellNumber(4));
            assertEquals(BigInteger.valueOf(985), PellNumbers.PellNumber(9));
            assertEquals(BigInteger.valueOf(15994428), PellNumbers.PellNumber(20));

            assertEquals(new BigInteger("66992092050551637663438906713182313772"), PellNumbers.PellNumber(100));
            assertEquals(new BigInteger("21093096734545788527500836634727099588489384390319004814017810623293211815789" +
                            "209911283798336840541227810827362247961462076340236731742628764087168306758128066643738616268" +
                            "857975982438181087665615915626282432004505944399554607844270641892800758687636009968274277222" +
                            "295140088568054131815535180156183128363609909859421735474877635959333893583537947135921530940" +
                            "258496573995974651586025272"),
                    PellNumbers.PellNumber(1000));
            assertEquals(new BigInteger("57582184532906785293777829954840254162930685491127185215437992984021607144389" +
                            "2297440763538244388702558773203675583398926090031865726959212909172272001117459665245717927477" +
                            "1161189503230929793540801662005078203227497856565383743430795146861082399982194609383725267843" +
                            "8263679665813881624796372875508570120377798631607586460933092846758126152613055661402864335558" +
                            "8623899186155596704034309833246303069272268159030566793794161054557600061640199911503659346894" +
                            "4773498982296960921022373429226260619235005143240934249788786657731086739591595441108608775191" +
                            "9346501643973115802048412185689540696829741377379995519304758757937050080281109170336026123180" +
                            "0444868985121173081393350307071539871580541558915330543952140639950439116213430257787263502393" +
                            "3454561917529043962226463194500591072542867756539720689357690167053203104873727961224316594081" +
                            "9545306414229147583130126048527155410190534814263066950"),
                    PellNumbers.PellNumber(2310));
        }, "Did you forget to memoize Pell?");
    }
}