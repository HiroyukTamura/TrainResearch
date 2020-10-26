// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.iid;

import java.security.NoSuchAlgorithmException;
import java.security.KeyPairGenerator;
import java.security.KeyPair;

public final class zza
{
    public static KeyPair zzvJ() {
        try {
            final KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
            instance.initialize(2048);
            return instance.generateKeyPair();
        }
        catch (NoSuchAlgorithmException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
}
