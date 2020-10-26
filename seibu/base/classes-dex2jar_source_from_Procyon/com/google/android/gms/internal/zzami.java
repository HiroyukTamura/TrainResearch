// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.zze;

public final class zzami
{
    public static final String VERSION;
    public static final String zzafL;
    
    static {
        VERSION = String.valueOf(zze.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        final String value = String.valueOf(zzami.VERSION);
        String concat;
        if (value.length() != 0) {
            concat = "ma".concat(value);
        }
        else {
            concat = new String("ma");
        }
        zzafL = concat;
    }
}
