// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import com.google.android.gms.internal.zzaob;

public final class zzf
{
    public static String zzC(final int n) {
        return zzc("&cd", n);
    }
    
    public static String zzD(final int n) {
        return zzc("cd", n);
    }
    
    public static String zzE(final int n) {
        return zzc("&cm", n);
    }
    
    public static String zzF(final int n) {
        return zzc("cm", n);
    }
    
    public static String zzG(final int n) {
        return zzc("&pr", n);
    }
    
    public static String zzH(final int n) {
        return zzc("pr", n);
    }
    
    public static String zzI(final int n) {
        return zzc("&promo", n);
    }
    
    public static String zzJ(final int n) {
        return zzc("promo", n);
    }
    
    public static String zzK(final int n) {
        return zzc("pi", n);
    }
    
    public static String zzL(final int n) {
        return zzc("&il", n);
    }
    
    public static String zzM(final int n) {
        return zzc("il", n);
    }
    
    public static String zzN(final int n) {
        return zzc("cd", n);
    }
    
    public static String zzO(final int n) {
        return zzc("cm", n);
    }
    
    private static String zzc(final String s, final int i) {
        if (i <= 0) {
            zzaob.zzf("index out of range for prefix", s);
            return "";
        }
        return new StringBuilder(String.valueOf(s).length() + 11).append(s).append(i).toString();
    }
}
