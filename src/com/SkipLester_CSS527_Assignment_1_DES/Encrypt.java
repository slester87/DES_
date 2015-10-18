package com.SkipLester_CSS527_Assignment_1_DES;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by shaun on 10/12/2015.
 */
public class Encrypt {

    /**
     * @param inputFile  the file to be encrypted
     * @param keyFile    the file with the key to use for the encryption
     * @param outputFile the file in which to store the decrypted file
     * @param encrypt_decrypt       encryption vs decryption
     */
    public Encrypt(String inputFile, String keyFile, String outputFile, String encrypt_decrypt) {
        try {

            FileInputStream fis = new FileInputStream(inputFile);
            FileInputStream keyfis = new FileInputStream(keyFile);
            byte[] theKey = new byte[8];
            keyfis.read(theKey);
            FileOutputStream fos = new FileOutputStream(outputFile);
            byte[][] roundKeys = KeySchedule.getRoundKeys(theKey);
            byte[] buffer = new byte[8];
            byte[] theCipher = null;
            int bytesRead = fis.read(buffer);
            while (bytesRead == 8) {
//                    theMessage = Helper.readBytes(input);
                theCipher = Helper.cipher(buffer, roundKeys, encrypt_decrypt);
                bytesRead = fis.read(buffer);
                fos.write(theCipher);
            }
            switch (bytesRead) {
                case 1:
                    bytesRead = 1;
                    buffer[1] = 07;
                    buffer[2] = 07;
                    buffer[3] = 07;
                    buffer[4] = 07;
                    buffer[5] = 07;
                    buffer[6] = 07;
                    buffer[7] = 07;
                    theCipher = Helper.cipher(buffer, roundKeys, encrypt_decrypt);
                    fos.write(theCipher);
                    break;
                case 2:
                    bytesRead = 2;
                    buffer[2] = 06;
                    buffer[3] = 06;
                    buffer[4] = 06;
                    buffer[5] = 06;
                    buffer[6] = 06;
                    buffer[7] = 06;
                    theCipher = Helper.cipher(buffer, roundKeys, encrypt_decrypt);
                    fos.write(theCipher);
                    break;
                case 3:
                    bytesRead = 3;
                    buffer[3] = 05;
                    buffer[4] = 05;
                    buffer[5] = 05;
                    buffer[6] = 05;
                    buffer[7] = 05;
                    theCipher = Helper.cipher(buffer, roundKeys, encrypt_decrypt);
                    fos.write(theCipher);
                    break;
                case 4:
                    bytesRead = 4;
                    buffer[4] = 04;
                    buffer[5] = 04;
                    buffer[6] = 04;
                    buffer[7] = 04;
                    theCipher = Helper.cipher(buffer, roundKeys, encrypt_decrypt);
                    fos.write(theCipher);
                    break;
                case 5:
                    bytesRead = 5;
                    buffer[5] = 03;
                    buffer[6] = 03;
                    buffer[7] = 03;
                    theCipher = Helper.cipher(buffer, roundKeys, encrypt_decrypt);
                    fos.write(theCipher);
                    break;
                case 6:
                    bytesRead = 6;
                    buffer[6] = 02;
                    buffer[7] = 02;
                    theCipher = Helper.cipher(buffer, roundKeys, encrypt_decrypt);
                    fos.write(theCipher);
                    break;
                case 7:
                    bytesRead = 7;
                    buffer[7] = 01;
                    theCipher = Helper.cipher(buffer, roundKeys, encrypt_decrypt);
                    fos.write(theCipher);
                    break;
                case 8:
                    bytesRead = 8; //shouldn't get here afaik
                    theCipher = Helper.cipher(buffer, roundKeys, encrypt_decrypt);
                    fos.write(theCipher);
                    break;
            }
            fis.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }




    }


}
