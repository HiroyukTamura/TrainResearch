// 
// Decompiled by Procyon v0.5.36
// 

package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzd
{
    private static volatile boolean zzcrP;
    private static final Class<?> zzcrQ;
    static final zzd zzcrR;
    private final Map<Object, Object> zzcrS;
    
    static {
        zzd.zzcrP = false;
        zzcrQ = zzLs();
        zzcrR = new zzd(true);
    }
    
    zzd() {
        this.zzcrS = new HashMap<Object, Object>();
    }
    
    zzd(final boolean b) {
        this.zzcrS = Collections.emptyMap();
    }
    
    private static Class<?> zzLs() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        }
        catch (ClassNotFoundException ex) {
            return null;
        }
    }
}
