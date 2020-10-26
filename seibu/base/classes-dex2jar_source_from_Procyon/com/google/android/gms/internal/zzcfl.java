// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.util.Pair;
import com.google.android.gms.common.util.zze;
import android.util.Log;
import com.google.android.gms.common.internal.zzbo;
import android.content.Context;
import com.google.android.gms.measurement.AppMeasurement;
import android.text.TextUtils;

public final class zzcfl extends zzchj
{
    private final String zzaIb;
    private final long zzboC;
    private final char zzbqL;
    private final zzcfn zzbqM;
    private final zzcfn zzbqN;
    private final zzcfn zzbqO;
    private final zzcfn zzbqP;
    private final zzcfn zzbqQ;
    private final zzcfn zzbqR;
    private final zzcfn zzbqS;
    private final zzcfn zzbqT;
    private final zzcfn zzbqU;
    
    zzcfl(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzaIb = zzcem.zzxf();
        this.zzboC = zzcem.zzwP();
        if (super.zzwH().zzln()) {
            zzcem.zzxE();
            this.zzbqL = 'C';
        }
        else {
            zzcem.zzxE();
            this.zzbqL = 'c';
        }
        this.zzbqM = new zzcfn(this, 6, false, false);
        this.zzbqN = new zzcfn(this, 6, true, false);
        this.zzbqO = new zzcfn(this, 6, false, true);
        this.zzbqP = new zzcfn(this, 5, false, false);
        this.zzbqQ = new zzcfn(this, 5, true, false);
        this.zzbqR = new zzcfn(this, 5, false, true);
        this.zzbqS = new zzcfn(this, 4, false, false);
        this.zzbqT = new zzcfn(this, 3, false, false);
        this.zzbqU = new zzcfn(this, 2, false, false);
    }
    
    private static String zza(final boolean b, String s, final Object o, final Object o2, final Object o3) {
        String str = s;
        if (s == null) {
            str = "";
        }
        final String zzc = zzc(b, o);
        final String zzc2 = zzc(b, o2);
        final String zzc3 = zzc(b, o3);
        final StringBuilder sb = new StringBuilder();
        s = "";
        if (!TextUtils.isEmpty((CharSequence)str)) {
            sb.append(str);
            s = ": ";
        }
        String str2 = s;
        if (!TextUtils.isEmpty((CharSequence)zzc)) {
            sb.append(s);
            sb.append(zzc);
            str2 = ", ";
        }
        s = str2;
        if (!TextUtils.isEmpty((CharSequence)zzc2)) {
            sb.append(str2);
            sb.append(zzc2);
            s = ", ";
        }
        if (!TextUtils.isEmpty((CharSequence)zzc3)) {
            sb.append(s);
            sb.append(zzc3);
        }
        return sb.toString();
    }
    
    private static String zzc(final boolean b, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Integer) {
            value = value;
        }
        if (value instanceof Long) {
            if (!b) {
                return String.valueOf(value);
            }
            if (Math.abs((long)value) < 100L) {
                return String.valueOf(value);
            }
            String s;
            if (String.valueOf(value).charAt(0) == '-') {
                s = "-";
            }
            else {
                s = "";
            }
            final String value2 = String.valueOf(Math.abs((long)value));
            return new StringBuilder(String.valueOf(s).length() + 43 + String.valueOf(s).length()).append(s).append(Math.round(Math.pow(10.0, value2.length() - 1))).append("...").append(s).append(Math.round(Math.pow(10.0, value2.length()) - 1.0)).toString();
        }
        else {
            if (value instanceof Boolean) {
                return String.valueOf(value);
            }
            if (value instanceof Throwable) {
                final Throwable t = (Throwable)value;
                String str;
                if (b) {
                    str = t.getClass().getName();
                }
                else {
                    str = t.toString();
                }
                value = new StringBuilder(str);
                final String zzea = zzea(AppMeasurement.class.getCanonicalName());
                final String zzea2 = zzea(zzcgl.class.getCanonicalName());
                final StackTraceElement[] stackTrace = t.getStackTrace();
                for (int length = stackTrace.length, i = 0; i < length; ++i) {
                    final StackTraceElement obj = stackTrace[i];
                    if (!obj.isNativeMethod()) {
                        final String className = obj.getClassName();
                        if (className != null) {
                            final String zzea3 = zzea(className);
                            if (zzea3.equals(zzea) || zzea3.equals(zzea2)) {
                                ((StringBuilder)value).append(": ");
                                ((StringBuilder)value).append(obj);
                                break;
                            }
                        }
                    }
                }
                return ((StringBuilder)value).toString();
            }
            if (value instanceof zzcfo) {
                return ((zzcfo)value).zzbqZ;
            }
            if (b) {
                return "-";
            }
            return String.valueOf(value);
        }
    }
    
    protected static Object zzdZ(final String s) {
        if (s == null) {
            return null;
        }
        return new zzcfo(s);
    }
    
    private static String zzea(final String s) {
        String s2;
        if (TextUtils.isEmpty((CharSequence)s)) {
            s2 = "";
        }
        else {
            final int lastIndex = s.lastIndexOf(46);
            s2 = s;
            if (lastIndex != -1) {
                return s.substring(0, lastIndex);
            }
        }
        return s2;
    }
    
    protected final void zza(int n, final boolean b, final boolean b2, final String s, final Object o, final Object o2, final Object o3) {
        if (!b && this.zzz(n)) {
            this.zzk(n, zza(false, s, o, o2, o3));
        }
        if (!b2 && n >= 5) {
            zzbo.zzu(s);
            final zzcgg zzyR = this.zzboe.zzyR();
            if (zzyR == null) {
                this.zzk(6, "Scheduler not set. Not logging error/warn");
            }
            else {
                if (!zzyR.isInitialized()) {
                    this.zzk(6, "Scheduler not initialized. Not logging error/warn");
                    return;
                }
                if (n < 0) {
                    n = 0;
                }
                int index = n;
                if (n >= 9) {
                    index = 8;
                }
                final String value = String.valueOf("2");
                final char char1 = "01VDIWEA?".charAt(index);
                final char zzbqL = this.zzbqL;
                final long zzboC = this.zzboC;
                final String value2 = String.valueOf(zza(true, s, o, o2, o3));
                String s2;
                if ((s2 = new StringBuilder(String.valueOf(value).length() + 23 + String.valueOf(value2).length()).append(value).append(char1).append(zzbqL).append(zzboC).append(":").append(value2).toString()).length() > 1024) {
                    s2 = s.substring(0, 1024);
                }
                zzyR.zzj(new zzcfm(this, s2));
            }
        }
    }
    
    @Override
    protected final void zzjD() {
    }
    
    protected final void zzk(final int n, final String s) {
        Log.println(n, this.zzaIb, s);
    }
    
    public final zzcfn zzyA() {
        return this.zzbqR;
    }
    
    public final zzcfn zzyB() {
        return this.zzbqS;
    }
    
    public final zzcfn zzyC() {
        return this.zzbqT;
    }
    
    public final zzcfn zzyD() {
        return this.zzbqU;
    }
    
    public final String zzyE() {
        final Pair<String, Long> zzmb = super.zzwG().zzbrj.zzmb();
        if (zzmb == null || zzmb == zzcfw.zzbri) {
            return null;
        }
        final String value = String.valueOf(String.valueOf(zzmb.second));
        final String s = (String)zzmb.first;
        return new StringBuilder(String.valueOf(value).length() + 1 + String.valueOf(s).length()).append(value).append(":").append(s).toString();
    }
    
    public final zzcfn zzyx() {
        return this.zzbqM;
    }
    
    public final zzcfn zzyy() {
        return this.zzbqN;
    }
    
    public final zzcfn zzyz() {
        return this.zzbqP;
    }
    
    protected final boolean zzz(final int n) {
        return Log.isLoggable(this.zzaIb, n);
    }
}
