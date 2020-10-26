// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.util.Pair;
import android.support.annotation.WorkerThread;
import android.content.SharedPreferences$Editor;
import com.google.android.gms.common.internal.zzbo;

public final class zzcga
{
    private final long zzaiB;
    private /* synthetic */ zzcfw zzbrF;
    private String zzbrH;
    private final String zzbrI;
    private final String zzbrJ;
    
    private zzcga(final zzcfw zzbrF, final String obj, final long zzaiB) {
        this.zzbrF = zzbrF;
        zzbo.zzcF(obj);
        zzbo.zzaf(zzaiB > 0L);
        this.zzbrH = String.valueOf(obj).concat(":start");
        this.zzbrI = String.valueOf(obj).concat(":count");
        this.zzbrJ = String.valueOf(obj).concat(":value");
        this.zzaiB = zzaiB;
    }
    
    @WorkerThread
    private final void zzma() {
        this.zzbrF.zzjC();
        final long currentTimeMillis = this.zzbrF.zzkq().currentTimeMillis();
        final SharedPreferences$Editor edit = this.zzbrF.zzaix.edit();
        edit.remove(this.zzbrI);
        edit.remove(this.zzbrJ);
        edit.putLong(this.zzbrH, currentTimeMillis);
        edit.apply();
    }
    
    @WorkerThread
    private final long zzmc() {
        return this.zzbrF.zzyF().getLong(this.zzbrH, 0L);
    }
    
    @WorkerThread
    public final void zzf(final String s, long long1) {
        this.zzbrF.zzjC();
        if (this.zzmc() == 0L) {
            this.zzma();
        }
        String s2;
        if ((s2 = s) == null) {
            s2 = "";
        }
        long1 = this.zzbrF.zzaix.getLong(this.zzbrI, 0L);
        if (long1 <= 0L) {
            final SharedPreferences$Editor edit = this.zzbrF.zzaix.edit();
            edit.putString(this.zzbrJ, s2);
            edit.putLong(this.zzbrI, 1L);
            edit.apply();
            return;
        }
        int n;
        if ((this.zzbrF.zzwB().zzzt().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / (long1 + 1L)) {
            n = 1;
        }
        else {
            n = 0;
        }
        final SharedPreferences$Editor edit2 = this.zzbrF.zzaix.edit();
        if (n != 0) {
            edit2.putString(this.zzbrJ, s2);
        }
        edit2.putLong(this.zzbrI, long1 + 1L);
        edit2.apply();
    }
    
    @WorkerThread
    public final Pair<String, Long> zzmb() {
        this.zzbrF.zzjC();
        this.zzbrF.zzjC();
        final long zzmc = this.zzmc();
        long abs;
        if (zzmc == 0L) {
            this.zzma();
            abs = 0L;
        }
        else {
            abs = Math.abs(zzmc - this.zzbrF.zzkq().currentTimeMillis());
        }
        if (abs < this.zzaiB) {
            return null;
        }
        if (abs > this.zzaiB << 1) {
            this.zzma();
            return null;
        }
        final String string = this.zzbrF.zzyF().getString(this.zzbrJ, (String)null);
        final long long1 = this.zzbrF.zzyF().getLong(this.zzbrI, 0L);
        this.zzma();
        if (string == null || long1 <= 0L) {
            return zzcfw.zzbri;
        }
        return (Pair<String, Long>)new Pair((Object)string, (Object)long1);
    }
}
