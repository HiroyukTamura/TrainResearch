// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Map;

public final class zzn
{
    public final byte[] data;
    private int statusCode;
    private long zzA;
    public final Map<String, String> zzy;
    public final boolean zzz;
    
    public zzn(final int statusCode, final byte[] data, final Map<String, String> zzy, final boolean zzz, final long zzA) {
        this.statusCode = statusCode;
        this.data = data;
        this.zzy = zzy;
        this.zzz = zzz;
        this.zzA = zzA;
    }
    
    public zzn(final byte[] array, final Map<String, String> map) {
        this(200, array, map, false, 0L);
    }
}
