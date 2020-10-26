// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzq;
import android.view.View;
import android.content.Context;
import com.google.android.gms.dynamic.zzp;

public final class zzbv extends zzp<zzbb>
{
    private static final zzbv zzaIv;
    
    static {
        zzaIv = new zzbv();
    }
    
    private zzbv() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }
    
    public static View zzc(final Context context, final int n, final int n2) throws zzq {
        return zzbv.zzaIv.zzd(context, n, n2);
    }
    
    private final View zzd(final Context context, final int i, final int j) throws zzq {
        try {
            return zzn.zzE(this.zzaS(context).zza(zzn.zzw(context), new zzbt(i, j, null)));
        }
        catch (Exception ex) {
            throw new zzq(new StringBuilder(64).append("Could not get button with size ").append(i).append(" and color ").append(j).toString(), ex);
        }
    }
}
