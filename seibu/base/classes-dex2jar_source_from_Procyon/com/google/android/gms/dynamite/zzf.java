// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamite;

import android.content.Context;

final class zzf implements zzd
{
    @Override
    public final zzi zza(final Context context, final String s, final zzh zzh) throws zzc {
        final zzi zzi = new zzi();
        zzi.zzaSU = zzh.zzE(context, s);
        if (zzi.zzaSU != 0) {
            zzi.zzaSV = zzh.zzb(context, s, false);
        }
        else {
            zzi.zzaSV = zzh.zzb(context, s, true);
        }
        if (zzi.zzaSU == 0 && zzi.zzaSV == 0) {
            zzi.zzaSW = 0;
            return zzi;
        }
        if (zzi.zzaSV >= zzi.zzaSU) {
            zzi.zzaSW = 1;
            return zzi;
        }
        zzi.zzaSW = -1;
        return zzi;
    }
}
