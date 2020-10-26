// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public enum zzang
{
    zzagQ, 
    zzagR;
    
    public static zzang zzby(final String anotherString) {
        if ("GZIP".equalsIgnoreCase(anotherString)) {
            return zzang.zzagR;
        }
        return zzang.zzagQ;
    }
}
