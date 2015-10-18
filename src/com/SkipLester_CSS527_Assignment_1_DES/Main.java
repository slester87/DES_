package com.SkipLester_CSS527_Assignment_1_DES;


import javax.crypto.KeyGenerator;

public class Main {

    public static void main(String[] args) {
        //parse the input
        if(args.length < 3){
            System.out.println("Usage:");
            System.out.println("./des genkey password outputFile");
            System.out.println("or");
            System.out.println("./des encrypt/decrypt inputFile keyFile outputFile mode");

        }
        if(args[0].equalsIgnoreCase("genkey")){
            new GenKey(args[1], args[2]);
        }else if(args[0].equalsIgnoreCase("encrypt")){
            new Encrypt(args[1],args[2],args[3],args[0]);
        }else if(args[0].equalsIgnoreCase("decrypt")) {
            new Encrypt(args[1],args[2],args[3],args[0]);
        }
    }
//    public static int genkey(String password, String outputFile){
//        int retval = -1;
//
//        return retval;
//    }
//    public static int encrypt(String inputFile, String keyFile, String outputFile, String mode ){
//        int retval = -1;
//
//        return retval;
//    }
//    public static int decrypt(String inputFile, String keyFile, String outputFile, String mode ){
//        int retval = -1;
//
//
//        return retval;
//    }
}