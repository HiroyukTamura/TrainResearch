// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.os.Parcel;
import java.util.List;
import java.util.Map;
import android.os.IBinder;

public final class zzanz extends zzed implements zzany
{
    zzanz(final IBinder binder) {
        super(binder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }
    
    @Override
    public final void zza(final Map map, final long n, final String s, final List<zzane> list) throws RemoteException {
        final Parcel zzZ = this.zzZ();
        zzZ.writeMap(map);
        zzZ.writeLong(n);
        zzZ.writeString(s);
        zzZ.writeTypedList((List)list);
        this.zzb(1, zzZ);
    }
    
    @Override
    public final void zzkk() throws RemoteException {
        this.zzb(2, this.zzZ());
    }
}
