/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Raishin
 */
public class PassEncrypt {
    private static MessageDigest digester;
    static{
        try{
            digester=MessageDigest.getInstance("MD5");
        }
        catch(NoSuchAlgorithmException e){
            System.out.println(e);
        }
    }
    public static String crypt(String str){
        if(str==null || str.length()==0){
            throw new IllegalArgumentException("String to encript cannot be null or zero lenght");
        }
        digester.update(str.getBytes());
        byte[] hash = digester.digest();
        StringBuffer encString = new StringBuffer();
        for(int i=0;i<hash.length;i++){
            if((0xff &hash[i])<0x10){
                encString.append("0");
                encString.append(Integer.toHexString((0xFF & hash[i])));
            }            
            else{
                encString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        return encString.toString();
    }
}
