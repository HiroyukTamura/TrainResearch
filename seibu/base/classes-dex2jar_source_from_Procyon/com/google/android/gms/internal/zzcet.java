// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.util.zze;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import android.content.Context;

public final class zzcet extends zzchj
{
    private long zzbpC;
    private String zzbpD;
    
    zzcet(final zzcgl zzcgl) {
        super(zzcgl);
    }
    
    @Override
    protected final void zzjD() {
        final Calendar instance = Calendar.getInstance();
        this.zzbpC = TimeUnit.MINUTES.convert(instance.get(16) + instance.get(15), TimeUnit.MILLISECONDS);
        final Locale default1 = Locale.getDefault();
        final String value = String.valueOf(default1.getLanguage().toLowerCase(Locale.ENGLISH));
        final String value2 = String.valueOf(default1.getCountry().toLowerCase(Locale.ENGLISH));
        this.zzbpD = new StringBuilder(String.valueOf(value).length() + 1 + String.valueOf(value2).length()).append(value).append("-").append(value2).toString();
    }
    
    public final long zzyq() {
        this.zzkD();
        return this.zzbpC;
    }
    
    public final String zzyr() {
        this.zzkD();
        return this.zzbpD;
    }
}
