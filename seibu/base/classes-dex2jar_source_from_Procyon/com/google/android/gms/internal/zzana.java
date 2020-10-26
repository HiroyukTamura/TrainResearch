// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public enum zzana
{
    zzagG, 
    zzagH, 
    zzagI, 
    zzagJ, 
    zzagK, 
    zzagL;
    
    public static zzana zzbx(final String anotherString) {
        if ("BATCH_BY_SESSION".equalsIgnoreCase(anotherString)) {
            return zzana.zzagH;
        }
        if ("BATCH_BY_TIME".equalsIgnoreCase(anotherString)) {
            return zzana.zzagI;
        }
        if ("BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(anotherString)) {
            return zzana.zzagJ;
        }
        if ("BATCH_BY_COUNT".equalsIgnoreCase(anotherString)) {
            return zzana.zzagK;
        }
        if ("BATCH_BY_SIZE".equalsIgnoreCase(anotherString)) {
            return zzana.zzagL;
        }
        return zzana.zzagG;
    }
}
