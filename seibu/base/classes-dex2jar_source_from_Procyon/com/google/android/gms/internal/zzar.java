// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;

public class zzar extends zzp<String>
{
    private final zzv<String> zzaD;
    
    public zzar(final int n, final String s, final zzv<String> zzaD, final zzu zzu) {
        super(n, s, zzu);
        this.zzaD = zzaD;
    }
    
    @Override
    protected final zzt<String> zza(final zzn zzn) {
        try {
            final String s = new String(zzn.data, zzam.zza(zzn.zzy));
            return zzt.zza(s, zzam.zzb(zzn));
        }
        catch (UnsupportedEncodingException ex) {
            final String s = new String(zzn.data);
            return zzt.zza(s, zzam.zzb(zzn));
        }
    }
}
