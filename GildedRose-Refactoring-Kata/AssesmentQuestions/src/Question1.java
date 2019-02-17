import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Question1 {
    public static void main(String[] args) {

        String a1[] = null;
        String b1[] = null;

        System.out.printf("sameContents(%s, %s) = %b\n",
                Arrays.toString(a1), Arrays.toString(b1),
                sameContents(a1, b1)
        );

        String a2[] = null;
        String b2[] = {};

        System.out.printf("sameContents(%s, %s) = %b\n",
                Arrays.toString(a2), Arrays.toString(b2),
                sameContents(a2, b2)
        );

        String a3[] = null;
        String b3[] = {"a", "b", "a"};

        System.out.printf("sameContents(%s, %s) = %b\n",
                Arrays.toString(a3), Arrays.toString(b3),
                sameContents(a3, b3)
        );

        String a4[] = {};
        String b4[] = {"a", "a", "b"};

        System.out.printf("sameContents(%s, %s) = %b\n",
                Arrays.toString(a4), Arrays.toString(b4),
                sameContents(a4, b4)
        );

        String a5[] = {"a", "b", "a"};
        String b5[] = {"a", "a", "b","a"};

        System.out.printf("sameContents(%s, %s) = %b\n",
                Arrays.toString(a5), Arrays.toString(b5),
                sameContents(a5, b5)
        );

        String a6[] = {"a", "b", "a"};
        String b6[] = {"a", "b", "a"};

        System.out.printf("sameContents(%s, %s) = %b\n",
                Arrays.toString(a6), Arrays.toString(b6),
                sameContents(a6, b6)
        );

        String a7[] = {"b", "b", "a"};
        String b7[] = {"a", "a", "b"};

        System.out.printf("sameContents(%s, %s) = %b\n",
                Arrays.toString(a7), Arrays.toString(b7),
                sameContents(a7, b7)
        );

        String a8[] = {"a", "b", "a","a"};
        String b8[] = {"a", "a", "b"};

        System.out.printf("sameContents(%s, %s) = %b\n",
                Arrays.toString(a8), Arrays.toString(b8),
                sameContents(a8, b8)
        );

        String a9[] = {"a", "b", "a","a"};
        String b9[] = {"a", "b", "a","b"};

        System.out.printf("sameContents(%s, %s) = %b\n",
                Arrays.toString(a9), Arrays.toString(b9),
                sameContents(a9, b9)
        );

        String a10[] = {"a", "b", "a","e","f"};
        String b10[] = {"g", "h", "b","e","f"};

        System.out.printf("sameContents(%s, %s) = %b\n",
                Arrays.toString(a10), Arrays.toString(b10),
                sameContents(a10, b10)
        );

    }

    /**
     * The following routine checks if two arrays have the same contents (strings) in any order.
     * It clearly has problems.
     * Identify the bugs, explicitely in your implementation's comments and correct the implementation.
     */
    static boolean sameContents(String[] a, String[] b) {
        boolean aEmpty = (a == null || a.length == 0);
        boolean bEmpty = (b == null || b.length == 0);

        // First check for the empty cases
        if (aEmpty && bEmpty) {
            return true;
        } else if (aEmpty || bEmpty) {
            return false;
        }

        // make sure they have equal lengths
        if (a.length != b.length) {
            return false;
        }

        // now check that they have the same contents with the same frequencies
        Map<String, Integer> aFrequencyMap = calculateFrequency(a);
        Map<String, Integer> bFrequencyMap = calculateFrequency(b);

        return aFrequencyMap.equals(bFrequencyMap);

    }

    static Map<String, Integer> calculateFrequency(String[] inputArray) {
        // Initialize a HashMap or SortedMap, some implementation of a map
        Map<String, Integer> stringFrequencyMap = new HashMap<>();

        // loop over all the strings in ou array inputList
        for (String str : inputArray) {
            // check if my string already exists as a key in my stringFrequencyMap
            if (stringFrequencyMap.containsKey(str)) {
                // increment the value corresponding to that key (string value)
                // 1. get the current value (as an int)
                int count = stringFrequencyMap.get(str);
                // 2. increment that value
                count++;
                // 3. overwrite the old count with the new count
                stringFrequencyMap.put(str, count);
            } else {
                // add a new entry in our map with a key equal to the string and a value of 1
                stringFrequencyMap.put(str, 1);
            }
        }

        // return the stringFrequencyMap
        return stringFrequencyMap;
    }

    /*
           keys   |  frequency
           "a"    |     2
           "b"    |     1
     */

}
