// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.SharedPreferences$Editor;
import android.text.TextUtils;
import com.google.android.gms.analytics.zzl;
import android.content.SharedPreferences;

public final class zzaog extends zzamh
{
    private final zzaoi zzaiA;
    private SharedPreferences zzaix;
    private long zzaiy;
    private long zzaiz;
    
    protected zzaog(final zzamj zzamj) {
        super(zzamj);
        this.zzaiz = -1L;
        this.zzaiA = new zzaoi(this, "monitoring", zzans.zzahT.get(), null);
    }
    
    public final void zzbz(final String s) {
        zzl.zzjC();
        this.zzkD();
        final SharedPreferences$Editor edit = this.zzaix.edit();
        if (TextUtils.isEmpty((CharSequence)s)) {
            edit.remove("installation_campaign");
        }
        else {
            edit.putString("installation_campaign", s);
        }
        if (!edit.commit()) {
            this.zzbr("Failed to commit campaign data");
        }
    }
    
    @Override
    protected final void zzjD() {
        this.zzaix = this.getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }
    
    public final long zzlU() {
        zzl.zzjC();
        this.zzkD();
        if (this.zzaiy == 0L) {
            final long long1 = this.zzaix.getLong("first_run", 0L);
            if (long1 != 0L) {
                this.zzaiy = long1;
            }
            else {
                final long currentTimeMillis = this.zzkq().currentTimeMillis();
                final SharedPreferences$Editor edit = this.zzaix.edit();
                edit.putLong("first_run", currentTimeMillis);
                if (!edit.commit()) {
                    this.zzbr("Failed to commit first run time");
                }
                this.zzaiy = currentTimeMillis;
            }
        }
        return this.zzaiy;
    }
    
    public final zzaoo zzlV() {
        return new zzaoo(this.zzkq(), this.zzlU());
    }
    
    public final long zzlW() {
        zzl.zzjC();
        this.zzkD();
        if (this.zzaiz == -1L) {
            this.zzaiz = this.zzaix.getLong("last_dispatch", 0L);
        }
        return this.zzaiz;
    }
    
    public final void zzlX() {
        zzl.zzjC();
        this.zzkD();
        final long currentTimeMillis = this.zzkq().currentTimeMillis();
        final SharedPreferences$Editor edit = this.zzaix.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.zzaiz = currentTimeMillis;
    }
    
    public final String zzlY() {
        zzl.zzjC();
        this.zzkD();
        final String string = this.zzaix.getString("installation_campaign", (String)null);
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        return string;
    }
    
    public final zzaoi zzlZ() {
        return this.zzaiA;
    }
}
