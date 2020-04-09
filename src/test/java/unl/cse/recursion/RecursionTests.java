package unl.cse.recursion;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class RecursionTests {
    private static int stackDepth = 0;
    
    @BeforeAll
    static void stackDepthCounter() {
        try {
            stackDepthCounterRecurser();
        } catch (StackOverflowError ignored) { }
        stackDepth += 5;
    }

    private static void stackDepthCounterRecurser() {
        stackDepth++;
        stackDepthCounterRecurser();
    }


    /**
     * Test that the {@link Palindrome} class performs its task adequately through a wide range of strings that may or
     * may not be palindromes
     */
    @Test
    void isPalindromeTest() {
        Palindrome palindromeTester = new Palindrome();
        assertTrue(palindromeTester.isPalindrome("tacocat"), "'tacocat' is a palindrome");
        assertTrue(palindromeTester.isPalindrome("mom"), "'mom' is a palindrome");
        assertTrue(palindromeTester.isPalindrome("dad"), "'dad' is a palindrome");
        assertTrue(palindromeTester.isPalindrome("lol"), "'lol' is a palindrome");
        assertTrue(palindromeTester.isPalindrome("a"), "'a' is a palindrome");
        assertTrue(palindromeTester.isPalindrome(""), "the empty string is a palindrome");
        assertTrue(palindromeTester.isPalindrome("aaaa"), "'aaaa' is a palindrome");
        assertTrue(palindromeTester.isPalindrome("live evil"), "'live evil' is a palindrome");
        assertTrue(palindromeTester.isPalindrome("graarg"), "'graarg' is a palindrome");
        assertTrue(palindromeTester.isPalindrome("madam"), "'madam' is a palindrome");
        assertTrue(palindromeTester.isPalindrome("radar"), "'radar' is a palindrome");
        assertTrue(palindromeTester.isPalindrome("reviver"), "'reviver' is a palindrome");
        assertTrue(palindromeTester.isPalindrome("rotator"), "'rotator' is a palindrome");
        assertTrue(palindromeTester.isPalindrome("1010101010101"), "'1010101010101' is a palindrome");

        assertFalse(palindromeTester.isPalindrome("Bourke"), "'Bourke' is not a palindrome");
        assertFalse(palindromeTester.isPalindrome("CSCE156"), "'CSCE156' is not a palindrome");
        assertFalse(palindromeTester.isPalindrome("Java"), "'Java' is not a palindrome");
        assertFalse(palindromeTester.isPalindrome("tac ocat"), "'tac ocat' is not a palindrome");
        assertFalse(palindromeTester.isPalindrome("WebGrader"), "'WebGrader' is not a palindrome");
        assertFalse(palindromeTester.isPalindrome("This, most certainly, is not a palindromic sentence."),
                "'This, most certainly, is not a palindromic sentence.' speaks for itself. It's not a palindrome");
    }

    /**
     * Ensure isPalindrome is implemented recursively by attempting to force a stack overflow
     */
    @Test
    void isPalindromeRecursionTest() {
        Palindrome palindromeTester = new Palindrome();
        try {
            // double depth to allow for overflow
            palindromeTester.isPalindrome("a".repeat(stackDepth * 2));
            fail("Must implement this function using recursion");
        } catch (StackOverflowError ignored){}
    }

    /**
     * Tests the output of {@link PellNumbers} for n values between 1 and 2310. Test must complete within 60 seconds,
     * or else it will time out. This is put in place to prevent un-memoized methods from running for extended periods
     * of time
     */
    @Test
    void pellNumberTest() {
        assertTimeout(Duration.ofSeconds(60), () -> {
            assertEquals(BigInteger.valueOf(1), PellNumbers.PellNumber(1), String.format("When n = %d, Pell's number is %d", 1, 1));
            assertEquals(BigInteger.valueOf(2), PellNumbers.PellNumber(2), String.format("When n = %d, Pell's number is %d", 2, 2));
            assertEquals(BigInteger.valueOf(5), PellNumbers.PellNumber(3), String.format("When n = %d, Pell's number is %d", 3, 5));
            assertEquals(BigInteger.valueOf(12), PellNumbers.PellNumber(4), String.format("When n = %d, Pell's number is %d", 4, 12));
            assertEquals(BigInteger.valueOf(985), PellNumbers.PellNumber(9), String.format("When n = %d, Pell's number is %d", 9, 985));
            assertEquals(BigInteger.valueOf(15994428), PellNumbers.PellNumber(20), String.format("When n = %d, Pell's number is %d", 20, 15994428));

            assertEquals(new BigInteger("66992092050551637663438906713182313772"), PellNumbers.PellNumber(100));
            assertEquals(new BigInteger("21093096734545788527500836634727099588489384390319004814017810623293211815789" +
                            "209911283798336840541227810827362247961462076340236731742628764087168306758128066643738616268" +
                            "857975982438181087665615915626282432004505944399554607844270641892800758687636009968274277222" +
                            "295140088568054131815535180156183128363609909859421735474877635959333893583537947135921530940" +
                            "258496573995974651586025272"),
                    PellNumbers.PellNumber(1000), String.format("When n = %d, Pell's number is %s", 1000, "2109...272"));
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
                    PellNumbers.PellNumber(2310), String.format("When n = %d, Pell's number is %s", 2310, "575...950"));
        }, "Did you forget to memoize Pell?");
    }

    /**
     * Ensure PellNumber is implemented recursively by attempting to force a stack overflow
     */
    @Test
    void pellNumberRecursionTest() {
        try {
            PellNumbers.PellNumber(stackDepth);
            fail("Must implement this function using recursion");
        } catch (StackOverflowError ignored){}
    }
}
