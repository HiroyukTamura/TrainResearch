// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamite;

import android.content.Context;

final class zzb implements zzd
{
    @Override
    public final zzi zza(final Context context, final String s, final zzh zzh) throws zzc {
        final zzi zzi = new zzi();
        zzi.zzaSV = zzh.zzb(context, s, true);
        if (zzi.zzaSV != 0) {
            zzi.zzaSW = 1;
        }
        else {
            zzi.zzaSU = zzh.zzE(context, s);
            if (zzi.zzaSU != 0) {
                zzi.zzaSW = -1;
                return zzi;
            }
        }
        return zzi;
    }
}
