// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.utils;

import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.Cipher;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import android.util.Log;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;
import java.security.Key;

public class AES
{
    private static final String AES = "AES";
    private static final int DefaultKeySize;
    private static final String ECB = "AES/ECB/PKCS5Padding";
    
    static {
        DefaultKeySize = KeySize.Key128bit.size();
    }
    
    public static Key convertToKey(final String s) {
        final byte[] decode = Base64.decode(s, 0);
        return new SecretKeySpec(decode, 0, decode.length, "DES");
    }
    
    public static byte[] decrypt(final String s, final String s2) {
        try {
            return decrypt(s, convertToKey(s2));
        }
        catch (Exception ex) {
            Log.e("decrypt", ex.getLocalizedMessage(), (Throwable)ex);
            return null;
        }
    }
    
    public static byte[] decrypt(final String s, final Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] decrypt = null;
        if (!StringUtils.isNullSpace(s)) {
            decrypt = decrypt;
            if (key != null) {
                decrypt = decrypt(Base64.decode(s, 0), key);
            }
        }
        return decrypt;
    }
    
    public static byte[] decrypt(final byte[] input, final Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] doFinal;
        final byte[] array = doFinal = null;
        if (input != null) {
            doFinal = array;
            if (input.length > 0) {
                doFinal = array;
                if (key != null) {
                    final Cipher instance = Cipher.getInstance("AES");
                    instance.init(2, key);
                    doFinal = instance.doFinal(input);
                }
            }
        }
        return doFinal;
    }
    
    public static byte[] decryptECB(final String s, final Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] decryptECB = null;
        if (!StringUtils.isNullSpace(s)) {
            decryptECB = decryptECB;
            if (key != null) {
                decryptECB = decryptECB(s.getBytes(), key);
            }
        }
        return decryptECB;
    }
    
    public static byte[] decryptECB(final byte[] input, final Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] doFinal;
        final byte[] array = doFinal = null;
        if (input != null) {
            doFinal = array;
            if (input.length > 0) {
                doFinal = array;
                if (key != null) {
                    final Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    instance.init(2, key);
                    doFinal = instance.doFinal(input);
                }
            }
        }
        return doFinal;
    }
    
    public static String encrypt(String encodeToString, final String s) {
        try {
            encodeToString = Base64.encodeToString(encrypt(encodeToString, convertToKey(s)), 0);
            return encodeToString;
        }
        catch (Exception ex) {
            Log.e("encrypt", ex.getLocalizedMessage());
            return null;
        }
    }
    
    public static byte[] encrypt(final int i, final Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return encrypt(String.valueOf(i), key);
    }
    
    public static byte[] encrypt(final String s, final Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] encrypt = null;
        if (!StringUtils.isNullSpace(s)) {
            encrypt = encrypt;
            if (key != null) {
                encrypt = encrypt(s.getBytes(), key);
            }
        }
        return encrypt;
    }
    
    public static byte[] encrypt(final byte[] input, final Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] doFinal;
        final byte[] array = doFinal = null;
        if (input != null) {
            doFinal = array;
            if (input.length > 0) {
                doFinal = array;
                if (key != null) {
                    final Cipher instance = Cipher.getInstance("AES");
                    instance.init(1, key);
                    doFinal = instance.doFinal(input);
                }
            }
        }
        return doFinal;
    }
    
    public static byte[] encryptECB(final String s, final Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] encryptECB = null;
        if (!StringUtils.isNullSpace(s)) {
            encryptECB = encryptECB;
            if (key != null) {
                encryptECB = encryptECB(s.getBytes(), key);
            }
        }
        return encryptECB;
    }
    
    public static byte[] encryptECB(final byte[] input, final Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] doFinal;
        final byte[] array = doFinal = null;
        if (input != null) {
            doFinal = array;
            if (input.length > 0) {
                doFinal = array;
                if (key != null) {
                    final Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    instance.init(1, key);
                    doFinal = instance.doFinal(input);
                }
            }
        }
        return doFinal;
    }
    
    public static Key generateKey() throws NoSuchAlgorithmException {
        return generateKey(jp.co.ncdc.apppot.stew.utils.AES.DefaultKeySize);
    }
    
    private static Key generateKey(final int keysize) throws NoSuchAlgorithmException {
        Key generateKey = null;
        if (validateKeySize(keysize)) {
            final KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(keysize, SecureRandom.getInstance("SHA1PRNG"));
            generateKey = instance.generateKey();
        }
        return generateKey;
    }
    
    public static Key generateKey(final String s) throws NoSuchAlgorithmException {
        Key key = null;
        if (validateKeyString(s)) {
            key = new SecretKeySpec(s.getBytes(), "AES");
        }
        return key;
    }
    
    public static Key generateKey(final KeySize keySize) throws NoSuchAlgorithmException {
        return generateKey(keySize.size());
    }
    
    public static String generateStringKey() {
        try {
            return Base64.encodeToString(generateKey().getEncoded(), 0);
        }
        catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }
    
    private static boolean validateKeySize(final int n) {
        boolean b = false;
        if (n == KeySize.Key128bit.size() || n == KeySize.Key192bit.size() || n == KeySize.Key256bit.size()) {
            b = true;
        }
        return b;
    }
    
    private static boolean validateKeyString(final String s) {
        boolean b = false;
        if (!StringUtils.isNullSpace(s)) {
            b = b;
            if (validateKeySize(s.length())) {
                b = true;
            }
        }
        return b;
    }
    
    public enum KeySize
    {
        Key128bit(128), 
        Key192bit(192), 
        Key256bit(256);
        
        private final int keySize;
        
        private KeySize(final int keySize) {
            this.keySize = keySize;
        }
        
        public int size() {
            return this.keySize;
        }
    }
}
