// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzbzy extends zzbzu<Long>
{
    public zzbzy(final int n, final String s, final Long n2) {
        super(0, s, n2, null);
    }
    
    private final Long zzd(final zzcac zzcac) {
        try {
            return zzcac.getLongFlagValue(this.getKey(), this.zzdI(), this.getSource());
        }
        catch (RemoteException ex) {
            return this.zzdI();
        }
    }
}
