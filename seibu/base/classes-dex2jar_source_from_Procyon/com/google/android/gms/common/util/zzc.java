// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import android.util.Base64;

public final class zzc
{
    public static String encode(final byte[] array) {
        if (array == null) {
            return null;
        }
        return Base64.encodeToString(array, 0);
    }
    
    public static String zzg(final byte[] array) {
        if (array == null) {
            return null;
        }
        return Base64.encodeToString(array, 10);
    }
    
    public static String zzh(final byte[] array) {
        if (array == null) {
            return null;
        }
        return Base64.encodeToString(array, 11);
    }
}
