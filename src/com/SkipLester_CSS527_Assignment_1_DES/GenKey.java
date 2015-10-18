package com.SkipLester_CSS527_Assignment_1_DES;
import java.io.*;
import java.security.MessageDigest; // Using only to hash the password and derive the key from the hash
/**
 * Created by shaun on 10/12/2015.
 */
public class GenKey {

    /**
     * @param password the string seed for the encryption key
     * @param outputFile the file where the DES encryption key will be stored
     */
    public GenKey(String password, String outputFile){
        //Creates a DES encryption key from the password and stores it in the file input as the outputFile
        try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(password.getBytes("UTF-8"));
                byte[] hashedKey = md.digest();
                byte[] initialKey = new byte[8];
                System.out.println("Hallo matey hashedlkey.length = " + hashedKey.length);
                for(int i = 0; i < 8 ; i++ ){
                    initialKey[i] = hashedKey[(hashedKey.length-1)*i%hashedKey.length];
//                    initialKey[i]=
                }
                for(int i = 0; i < 8; i++) {
                    for(int j = 0; j < 8; j++) {
                        System.out.print(j);
                    }
                    System.out.print(" ");
                }
                System.out.println();
                for(int i = 0; i < initialKey.length; i++){
                    System.out.print(Helper.byteToBits(initialKey[i]) + " ");
                }
                System.out.print("\n");
                for(int i = 0; i < initialKey.length; i++) {
                System.out.print(initialKey[i]+"\n");
                }
//                System.out.println(initialKey);
                File output = new File(outputFile);
                FileOutputStream fos = new FileOutputStream(output);
                fos.write(initialKey);
                fos.close();




        } catch (Exception e){
            e.printStackTrace();
            return;
        }


    }


}
