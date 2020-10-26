// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.flags.impl;

import android.util.Log;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.dynamic.zzn;
import android.content.Context;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.zzcad;

@DynamiteApi
public class FlagProviderImpl extends zzcad
{
    private SharedPreferences zzBT;
    private boolean zzuH;
    
    public FlagProviderImpl() {
        this.zzuH = false;
    }
    
    @Override
    public boolean getBooleanFlagValue(final String s, final boolean b, final int n) {
        if (!this.zzuH) {
            return b;
        }
        return zzb.zza(this.zzBT, s, b);
    }
    
    @Override
    public int getIntFlagValue(final String s, final int i, final int n) {
        if (!this.zzuH) {
            return i;
        }
        return zzd.zza(this.zzBT, s, i);
    }
    
    @Override
    public long getLongFlagValue(final String s, final long l, final int n) {
        if (!this.zzuH) {
            return l;
        }
        return zzf.zza(this.zzBT, s, l);
    }
    
    @Override
    public String getStringFlagValue(final String s, final String s2, final int n) {
        if (!this.zzuH) {
            return s2;
        }
        return zzh.zza(this.zzBT, s, s2);
    }
    
    @Override
    public void init(final IObjectWrapper objectWrapper) {
        final Context context = zzn.zzE(objectWrapper);
        if (this.zzuH) {
            return;
        }
        try {
            this.zzBT = zzj.zzaW(context.createPackageContext("com.google.android.gms", 0));
            this.zzuH = true;
        }
        catch (PackageManager$NameNotFoundException ex2) {}
        catch (Exception ex) {
            final String value = String.valueOf(ex.getMessage());
            String concat;
            if (value.length() != 0) {
                concat = "Could not retrieve sdk flags, continuing with defaults: ".concat(value);
            }
            else {
                concat = new String("Could not retrieve sdk flags, continuing with defaults: ");
            }
            Log.w("FlagProviderImpl", concat);
        }
    }
}
