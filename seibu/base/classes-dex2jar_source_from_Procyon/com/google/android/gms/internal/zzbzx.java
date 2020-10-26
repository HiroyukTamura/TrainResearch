// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzbzx extends zzbzu<Integer>
{
    public zzbzx(final int n, final String s, final Integer n2) {
        super(0, s, n2, null);
    }
    
    private final Integer zzc(final zzcac zzcac) {
        try {
            return zzcac.getIntFlagValue(this.getKey(), this.zzdI(), this.getSource());
        }
        catch (RemoteException ex) {
            return this.zzdI();
        }
    }
}
