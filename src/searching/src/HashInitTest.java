/**
 * BST:
 * Elapsed time: 0.799s
 * the 7577
 * distinct = 11060
 * words    = 141608
 *
 * ArrayST:
 * Elapsed time: 1.601s
 * the 7577
 * distinct = 11060
 * words    = 141608
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/*
Vilken av dessa är en bra startstorlek för modulus array:
3014 = 2 * 11 * 137
4711 = 7 * 673
4712 = 2 * 2 * 2 * 19 * 31
4713 = 3 * 1571

Om man vill minimera kollisionerna vill man hålla antalet gemensamma delare
mellan m och varje hashtal lågt. Låga primtal kommer över lag vara gemensamma
delare till fler hashar. Om indatan är helt slumpad är det inte så stor skillnad
mellan 4711, 4712 och 4713. 3014 är överlag sämmre då det är ett mindre tal och
man vill att skillnaden mellan n och m ska vara större.
Vid indata som har en dragning, tex att många tal är jämna blir snabbt 4712 sämre
än 4711 och 4713
*/

// Small program to test modulus hashing of integers
public class HashInitTest {

    public static void main(String[] args) throws IOException{
        // m is the number of "buckets"
        int m = 3014;
        // multiple is used to force a "tilt" in the values
        int multiple = 2;

        HashST<String, Integer> bst = new HashST<>();

        // Generate 2000 ints
        int[] nummer = new int[2000];
        Random rr = new Random();
        rr.setSeed(1237871263);
        for (int i = 0; i < nummer.length; i++) {
            nummer[i] = rr.nextInt(4000)*multiple;
        }

        // Count hash hits in each index
        int[] count = new int[m];
        int over = 0;
        for (int i : nummer) {
            int hash = (i & 0x7fffffff) % m;
            // Count collisions
            if (count[hash] > 1) {
                over++;
            }
            count[hash]++;
        }

        // Count zeros
        int zeros = 0;
        for (int i = 0; i < m; i++)  {
            if (count[i] == 0) {
                zeros++;
            }
        }

        // Print result
        System.out.println((zeros - (m-2000))/(double)m);
        System.out.println("Collisions: " + over);

    }
}
