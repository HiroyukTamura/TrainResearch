// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.util.Pair;
import java.util.UUID;
import android.content.SharedPreferences$Editor;
import com.google.android.gms.common.internal.zzbo;

public final class zzaoi
{
    private final String mName;
    private final long zzaiB;
    private /* synthetic */ zzaog zzaiC;
    
    private zzaoi(final zzaog zzaiC, final String mName, final long zzaiB) {
        this.zzaiC = zzaiC;
        zzbo.zzcF(mName);
        zzbo.zzaf(zzaiB > 0L);
        this.mName = mName;
        this.zzaiB = zzaiB;
    }
    
    private final void zzma() {
        final long currentTimeMillis = this.zzaiC.zzkq().currentTimeMillis();
        final SharedPreferences$Editor edit = this.zzaiC.zzaix.edit();
        edit.remove(this.zzme());
        edit.remove(this.zzmf());
        edit.putLong(this.zzmd(), currentTimeMillis);
        edit.commit();
    }
    
    private final long zzmc() {
        return this.zzaiC.zzaix.getLong(this.zzmd(), 0L);
    }
    
    private final String zzmd() {
        return String.valueOf(this.mName).concat(":start");
    }
    
    private final String zzme() {
        return String.valueOf(this.mName).concat(":count");
    }
    
    private final String zzmf() {
        return String.valueOf(this.mName).concat(":value");
    }
    
    public final void zzbA(final String s) {
        if (this.zzmc() == 0L) {
            this.zzma();
        }
        String s2;
        if ((s2 = s) == null) {
            s2 = "";
        }
        while (true) {
            while (true) {
                synchronized (this) {
                    final long long1 = this.zzaiC.zzaix.getLong(this.zzme(), 0L);
                    if (long1 <= 0L) {
                        final SharedPreferences$Editor edit = this.zzaiC.zzaix.edit();
                        edit.putString(this.zzmf(), s2);
                        edit.putLong(this.zzme(), 1L);
                        edit.apply();
                        return;
                    }
                    if ((UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (long1 + 1L)) {
                        final int n = 1;
                        final SharedPreferences$Editor edit2 = this.zzaiC.zzaix.edit();
                        if (n != 0) {
                            edit2.putString(this.zzmf(), s2);
                        }
                        edit2.putLong(this.zzme(), long1 + 1L);
                        edit2.apply();
                        return;
                    }
                }
                final int n = 0;
                continue;
            }
        }
    }
    
    public final Pair<String, Long> zzmb() {
        final long zzmc = this.zzmc();
        long abs;
        if (zzmc == 0L) {
            abs = 0L;
        }
        else {
            abs = Math.abs(zzmc - this.zzaiC.zzkq().currentTimeMillis());
        }
        if (abs < this.zzaiB) {
            return null;
        }
        if (abs > this.zzaiB << 1) {
            this.zzma();
            return null;
        }
        final String string = this.zzaiC.zzaix.getString(this.zzmf(), (String)null);
        final long long1 = this.zzaiC.zzaix.getLong(this.zzme(), 0L);
        this.zzma();
        if (string == null || long1 <= 0L) {
            return null;
        }
        return (Pair<String, Long>)new Pair((Object)string, (Object)long1);
    }
}
