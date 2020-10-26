// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import android.support.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.zzbo;
import java.util.Random;
import android.content.Context;

public final class zzai
{
    private final Context mContext;
    private final Random zzAO;
    private final String zzbDw;
    
    public zzai(final Context context, final String s) {
        this(context, s, new Random());
    }
    
    @VisibleForTesting
    private zzai(final Context context, final String s, final Random zzAO) {
        this.mContext = zzbo.zzu(context);
        this.zzbDw = zzbo.zzu(s);
        this.zzAO = zzAO;
    }
    
    private final SharedPreferences zzAW() {
        final Context mContext = this.mContext;
        final String value = String.valueOf("_gtmContainerRefreshPolicy_");
        final String value2 = String.valueOf(this.zzbDw);
        String concat;
        if (value2.length() != 0) {
            concat = value.concat(value2);
        }
        else {
            concat = new String(value);
        }
        return mContext.getSharedPreferences(concat, 0);
    }
    
    private final long zzg(final long n, long n2) {
        final SharedPreferences zzAW = this.zzAW();
        final long max = Math.max(0L, zzAW.getLong("FORBIDDEN_COUNT", 0L));
        n2 = (long)(max / (float)(Math.max(0L, zzAW.getLong("SUCCESSFUL_COUNT", 0L)) + max + 1L) * (n2 - n));
        return (long)((n2 + n) * this.zzAO.nextFloat());
    }
    
    public final long zzAS() {
        return 43200000L + this.zzg(7200000L, 259200000L);
    }
    
    public final long zzAT() {
        return 3600000L + this.zzg(600000L, 86400000L);
    }
    
    @SuppressLint({ "CommitPrefEdits" })
    public final void zzAU() {
        final SharedPreferences zzAW = this.zzAW();
        final long long1 = zzAW.getLong("FORBIDDEN_COUNT", 0L);
        final long long2 = zzAW.getLong("SUCCESSFUL_COUNT", 0L);
        final SharedPreferences$Editor edit = zzAW.edit();
        long min;
        if (long1 == 0L) {
            min = 3L;
        }
        else {
            min = Math.min(10L, 1L + long1);
        }
        final long max = Math.max(0L, Math.min(long2, 10L - min));
        edit.putLong("FORBIDDEN_COUNT", min);
        edit.putLong("SUCCESSFUL_COUNT", max);
        edit.apply();
    }
    
    @SuppressLint({ "CommitPrefEdits" })
    public final void zzAV() {
        final SharedPreferences zzAW = this.zzAW();
        final long long1 = zzAW.getLong("SUCCESSFUL_COUNT", 0L);
        final long long2 = zzAW.getLong("FORBIDDEN_COUNT", 0L);
        final long min = Math.min(10L, long1 + 1L);
        final long max = Math.max(0L, Math.min(long2, 10L - min));
        final SharedPreferences$Editor edit = zzAW.edit();
        edit.putLong("SUCCESSFUL_COUNT", min);
        edit.putLong("FORBIDDEN_COUNT", max);
        edit.apply();
    }
}
