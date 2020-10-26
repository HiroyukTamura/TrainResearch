// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzbzw extends zzbzu<Boolean>
{
    public zzbzw(final int n, final String s, final Boolean b) {
        super(0, s, b, null);
    }
    
    private final Boolean zzb(final zzcac zzcac) {
        try {
            return zzcac.getBooleanFlagValue(this.getKey(), this.zzdI(), this.getSource());
        }
        catch (RemoteException ex) {
            return this.zzdI();
        }
    }
}
