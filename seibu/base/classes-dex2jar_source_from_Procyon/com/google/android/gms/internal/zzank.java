// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.HashSet;
import android.text.TextUtils;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.util.zzr;
import com.google.android.gms.common.internal.zzbo;
import java.util.Set;

public final class zzank
{
    private final zzamj zzadj;
    private volatile Boolean zzagU;
    private String zzagV;
    private Set<Integer> zzagW;
    
    protected zzank(final zzamj zzadj) {
        zzbo.zzu(zzadj);
        this.zzadj = zzadj;
    }
    
    public static boolean zzlo() {
        return zzans.zzahf.get();
    }
    
    public static int zzlp() {
        return zzans.zzahC.get();
    }
    
    public static long zzlq() {
        return zzans.zzahn.get();
    }
    
    public static long zzlr() {
        return zzans.zzahq.get();
    }
    
    public static int zzls() {
        return zzans.zzahs.get();
    }
    
    public static int zzlt() {
        return zzans.zzaht.get();
    }
    
    public static String zzlu() {
        return zzans.zzahv.get();
    }
    
    public static String zzlv() {
        return zzans.zzahu.get();
    }
    
    public static String zzlw() {
        return zzans.zzahw.get();
    }
    
    public static long zzly() {
        return zzans.zzahK.get();
    }
    
    public final boolean zzln() {
        Label_0123: {
            if (this.zzagU != null) {
                break Label_0123;
            }
            synchronized (this) {
                if (this.zzagU == null) {
                    final ApplicationInfo applicationInfo = this.zzadj.getContext().getApplicationInfo();
                    final String zzsf = zzr.zzsf();
                    if (applicationInfo != null) {
                        final String processName = applicationInfo.processName;
                        this.zzagU = (processName != null && processName.equals(zzsf));
                    }
                    if ((this.zzagU == null || !this.zzagU) && "com.google.android.gms.analytics".equals(zzsf)) {
                        this.zzagU = Boolean.TRUE;
                    }
                    if (this.zzagU == null) {
                        this.zzagU = Boolean.TRUE;
                        this.zzadj.zzkr().zzbs("My process not in the list of running processes");
                    }
                }
                // monitorexit(this)
                return this.zzagU;
            }
        }
    }
    
    public final Set<Integer> zzlx() {
        final String s = zzans.zzahF.get();
        Label_0103: {
            if (this.zzagW != null && this.zzagV != null && this.zzagV.equals(s)) {
                break Label_0103;
            }
            final String[] split = TextUtils.split(s, ",");
            final HashSet<Integer> zzagW = new HashSet<Integer>();
            final int length = split.length;
            int n = 0;
        Label_0085_Outer:
            while (true) {
                Label_0092: {
                    if (n >= length) {
                        break Label_0092;
                    }
                    final String s2 = split[n];
                    while (true) {
                        try {
                            zzagW.add(Integer.parseInt(s2));
                            ++n;
                            continue Label_0085_Outer;
                            return this.zzagW;
                            this.zzagV = s;
                            this.zzagW = zzagW;
                            return this.zzagW;
                        }
                        catch (NumberFormatException ex) {
                            continue;
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
}
