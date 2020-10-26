// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzf;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.internal.zzd;

public final class zzcfk extends zzd<zzcfd>
{
    public zzcfk(final Context context, final Looper looper, final zzf zzf, final zzg zzg) {
        super(context, looper, 93, zzf, zzg, null);
    }
    
    @NonNull
    @Override
    protected final String zzdb() {
        return "com.google.android.gms.measurement.START";
    }
    
    @NonNull
    @Override
    protected final String zzdc() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
