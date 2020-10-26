// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzbzz extends zzbzu<String>
{
    public zzbzz(final int n, final String s, final String s2) {
        super(0, s, s2, null);
    }
    
    private final String zze(final zzcac zzcac) {
        try {
            return zzcac.getStringFlagValue(this.getKey(), this.zzdI(), this.getSource());
        }
        catch (RemoteException ex) {
            return this.zzdI();
        }
    }
}
