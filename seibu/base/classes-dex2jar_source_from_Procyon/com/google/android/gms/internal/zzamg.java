// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzl;
import com.google.android.gms.common.util.zze;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzbo;

public class zzamg
{
    private final zzamj zzafJ;
    
    protected zzamg(final zzamj zzafJ) {
        zzbo.zzu(zzafJ);
        this.zzafJ = zzafJ;
    }
    
    private final void zza(final int n, final String s, final Object o, final Object o2, final Object o3) {
        zzaoc zzkF = null;
        if (this.zzafJ != null) {
            zzkF = this.zzafJ.zzkF();
        }
        if (zzkF != null) {
            final String s2 = zzans.zzahg.get();
            if (Log.isLoggable(s2, n)) {
                Log.println(n, s2, zzc(s, o, o2, o3));
            }
            if (n >= 5) {
                zzkF.zzb(n, s, o, o2, o3);
            }
        }
        else {
            final String s3 = zzans.zzahg.get();
            if (Log.isLoggable(s3, n)) {
                Log.println(n, s3, zzc(s, o, o2, o3));
            }
        }
    }
    
    protected static String zzc(String s, final Object o, final Object o2, final Object o3) {
        String str = s;
        if (s == null) {
            str = "";
        }
        final String zzi = zzi(o);
        final String zzi2 = zzi(o2);
        final String zzi3 = zzi(o3);
        final StringBuilder sb = new StringBuilder();
        s = "";
        if (!TextUtils.isEmpty((CharSequence)str)) {
            sb.append(str);
            s = ": ";
        }
        String str2 = s;
        if (!TextUtils.isEmpty((CharSequence)zzi)) {
            sb.append(s);
            sb.append(zzi);
            str2 = ", ";
        }
        s = str2;
        if (!TextUtils.isEmpty((CharSequence)zzi2)) {
            sb.append(str2);
            sb.append(zzi2);
            s = ", ";
        }
        if (!TextUtils.isEmpty((CharSequence)zzi3)) {
            sb.append(s);
            sb.append(zzi3);
        }
        return sb.toString();
    }
    
    public static boolean zzhM() {
        return Log.isLoggable((String)zzans.zzahg.get(), 2);
    }
    
    private static String zzi(final Object o) {
        if (o == null) {
            return "";
        }
        if (o instanceof String) {
            return (String)o;
        }
        if (o instanceof Boolean) {
            if (o == Boolean.TRUE) {
                return "true";
            }
            return "false";
        }
        else {
            if (o instanceof Throwable) {
                return ((Throwable)o).toString();
            }
            return o.toString();
        }
    }
    
    protected final Context getContext() {
        return this.zzafJ.getContext();
    }
    
    public final void zza(final String s, final Object o) {
        this.zza(2, s, o, null, null);
    }
    
    public final void zza(final String s, final Object o, final Object o2) {
        this.zza(2, s, o, o2, null);
    }
    
    public final void zza(final String s, final Object o, final Object o2, final Object o3) {
        this.zza(3, s, o, o2, o3);
    }
    
    public final void zzb(final String s, final Object o) {
        this.zza(3, s, o, null, null);
    }
    
    public final void zzb(final String s, final Object o, final Object o2) {
        this.zza(3, s, o, o2, null);
    }
    
    public final void zzb(final String s, final Object o, final Object o2, final Object o3) {
        this.zza(5, s, o, o2, o3);
    }
    
    public final void zzbo(final String s) {
        this.zza(2, s, null, null, null);
    }
    
    public final void zzbp(final String s) {
        this.zza(3, s, null, null, null);
    }
    
    public final void zzbq(final String s) {
        this.zza(4, s, null, null, null);
    }
    
    public final void zzbr(final String s) {
        this.zza(5, s, null, null, null);
    }
    
    public final void zzbs(final String s) {
        this.zza(6, s, null, null, null);
    }
    
    public final void zzc(final String s, final Object o) {
        this.zza(4, s, o, null, null);
    }
    
    public final void zzc(final String s, final Object o, final Object o2) {
        this.zza(5, s, o, o2, null);
    }
    
    public final void zzd(final String s, final Object o) {
        this.zza(5, s, o, null, null);
    }
    
    public final void zzd(final String s, final Object o, final Object o2) {
        this.zza(6, s, o, o2, null);
    }
    
    public final void zze(final String s, final Object o) {
        this.zza(6, s, o, null, null);
    }
    
    protected final zzalx zzkA() {
        return this.zzafJ.zzkI();
    }
    
    protected final zzamu zzkB() {
        return this.zzafJ.zzkB();
    }
    
    protected final zzano zzkC() {
        return this.zzafJ.zzkC();
    }
    
    public final zzamj zzkp() {
        return this.zzafJ;
    }
    
    protected final zze zzkq() {
        return this.zzafJ.zzkq();
    }
    
    protected final zzaoc zzkr() {
        return this.zzafJ.zzkr();
    }
    
    protected final zzank zzks() {
        return this.zzafJ.zzks();
    }
    
    protected final zzl zzkt() {
        return this.zzafJ.zzkt();
    }
    
    public final GoogleAnalytics zzku() {
        return this.zzafJ.zzkG();
    }
    
    protected final zzaly zzkv() {
        return this.zzafJ.zzkv();
    }
    
    protected final zzanp zzkw() {
        return this.zzafJ.zzkw();
    }
    
    protected final zzaot zzkx() {
        return this.zzafJ.zzkx();
    }
    
    protected final zzaog zzky() {
        return this.zzafJ.zzky();
    }
    
    protected final zzanb zzkz() {
        return this.zzafJ.zzkJ();
    }
}
