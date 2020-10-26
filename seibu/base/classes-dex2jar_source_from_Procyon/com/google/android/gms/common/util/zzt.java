// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import java.util.regex.Pattern;

public final class zzt
{
    private static final Pattern zzaJY;
    
    static {
        zzaJY = Pattern.compile("\\$\\{(.*?)\\}");
    }
    
    public static boolean zzcL(final String s) {
        return s == null || s.trim().isEmpty();
    }
}
