package com.SkipLester_CSS527_Assignment_1_DES;

/**
 * Created by shaun on 10/17/2015.
 */
public class KeySchedule {

    static final int[] PC1 = {
            57, 49, 41, 33, 25, 17,  9,
            1, 58, 50, 42, 34, 26, 18,
            10,  2, 59, 51, 43, 35, 27,
            19, 11,  3, 60, 52, 44, 36,
            63, 55, 47, 39, 31, 23, 15,
            7, 62, 54, 46, 38, 30, 22,
            14,  6, 61, 53, 45, 37, 29,
            21, 13,  5, 28, 20, 12,  4
    };
    static final int[] PC2 = {
            14, 17, 11, 24,  1,  5,
            3, 28, 15,  6, 21, 10,
            23, 19, 12,  4, 26,  8,
            16,  7, 27, 20, 13,  2,
            41, 52, 31, 37, 47, 55,
            30, 40, 51, 45, 33, 48,
            44, 49, 39, 56, 34, 53,
            46, 42, 50, 36, 29, 32
    };

    static final int[] SHIFTS = {
            //r1, r2,...,r16
            1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
    };
    public static byte[][] getRoundKeys(byte[] theKey) throws Exception {
        int roundKeySize = PC1.length;
        System.out.print("The number of bits in this key is " + roundKeySize);
        int numOfSubKeys = SHIFTS.length;
        byte[] roundKey = Helper.selectBits(theKey,PC1);
        //cut the initial key in half
        int halfKeySize = roundKeySize / 2;
        byte[] c = Helper.selectBits(roundKey, 0, halfKeySize);
        byte[] d = Helper.selectBits(roundKey, halfKeySize, halfKeySize);
        byte[][] subkeys = new byte[numOfSubKeys][]; //16 bytes = 48 bits
        System.out.println("\n The number of keys is " + subkeys.length);
        for(int i = 0; i < numOfSubKeys; i++){
            c = Helper.rotateLeft(c,halfKeySize,SHIFTS[i]);
            d = Helper.rotateLeft(d, halfKeySize, SHIFTS[i]);
            byte[] cd = Helper.concatenateBits(c, halfKeySize, d, halfKeySize);
            subkeys[i] = Helper.selectBits(cd,PC2);

        }

        return subkeys;
    }
}
