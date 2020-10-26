// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzq;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.internal.zzz;

public final class zzbfw extends zzz<zzbfz>
{
    public zzbfw(final Context context, final Looper looper, final zzq zzq, final GoogleApiClient.ConnectionCallbacks connectionCallbacks, final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, zzq, connectionCallbacks, onConnectionFailedListener);
    }
    
    public final String zzdb() {
        return "com.google.android.gms.common.service.START";
    }
    
    @Override
    protected final String zzdc() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}
