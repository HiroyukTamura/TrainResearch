// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzbo;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import com.google.android.gms.common.util.zze;
import java.util.List;
import java.util.Map;

public final class zzi
{
    private final zzk zzadQ;
    private boolean zzadR;
    private long zzadS;
    private long zzadT;
    private long zzadU;
    private long zzadV;
    private long zzadW;
    private boolean zzadX;
    private final Map<Class<? extends zzj>, zzj> zzadY;
    private final List<zzo> zzadZ;
    private final zze zzvw;
    
    private zzi(final zzi zzi) {
        this.zzadQ = zzi.zzadQ;
        this.zzvw = zzi.zzvw;
        this.zzadS = zzi.zzadS;
        this.zzadT = zzi.zzadT;
        this.zzadU = zzi.zzadU;
        this.zzadV = zzi.zzadV;
        this.zzadW = zzi.zzadW;
        this.zzadZ = new ArrayList<zzo>(zzi.zzadZ);
        this.zzadY = new HashMap<Class<? extends zzj>, zzj>(zzi.zzadY.size());
        for (final Map.Entry<Class<? extends zzj>, zzj> entry : zzi.zzadY.entrySet()) {
            final zzj zzc = zzc((Class<zzj>)entry.getKey());
            entry.getValue().zzb(zzc);
            this.zzadY.put(entry.getKey(), zzc);
        }
    }
    
    zzi(final zzk zzadQ, final zze zzvw) {
        zzbo.zzu(zzadQ);
        zzbo.zzu(zzvw);
        this.zzadQ = zzadQ;
        this.zzvw = zzvw;
        this.zzadV = 1800000L;
        this.zzadW = 3024000000L;
        this.zzadY = new HashMap<Class<? extends zzj>, zzj>();
        this.zzadZ = new ArrayList<zzo>();
    }
    
    private static <T extends zzj> T zzc(final Class<T> clazz) {
        try {
            return clazz.newInstance();
        }
        catch (InstantiationException cause) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", cause);
        }
        catch (IllegalAccessException cause2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", cause2);
        }
    }
    
    public final <T extends zzj> T zza(final Class<T> clazz) {
        return (T)this.zzadY.get(clazz);
    }
    
    public final void zza(final zzj zzj) {
        zzbo.zzu(zzj);
        final Class<? extends zzj> class1 = zzj.getClass();
        if (class1.getSuperclass() != zzj.class) {
            throw new IllegalArgumentException();
        }
        zzj.zzb(this.zzb(class1));
    }
    
    public final <T extends zzj> T zzb(final Class<T> clazz) {
        zzj zzc;
        if ((zzc = this.zzadY.get(clazz)) == null) {
            zzc = zzc((Class<zzj>)clazz);
            this.zzadY.put(clazz, zzc);
        }
        return (T)zzc;
    }
    
    public final zzi zzjp() {
        return new zzi(this);
    }
    
    public final Collection<zzj> zzjq() {
        return (Collection<zzj>)this.zzadY.values();
    }
    
    public final List<zzo> zzjr() {
        return this.zzadZ;
    }
    
    public final long zzjs() {
        return this.zzadS;
    }
    
    public final void zzjt() {
        this.zzadQ.zzjz().zze(this);
    }
    
    public final boolean zzju() {
        return this.zzadR;
    }
    
    final void zzjv() {
        this.zzadU = this.zzvw.elapsedRealtime();
        if (this.zzadT != 0L) {
            this.zzadS = this.zzadT;
        }
        else {
            this.zzadS = this.zzvw.currentTimeMillis();
        }
        this.zzadR = true;
    }
    
    final zzk zzjw() {
        return this.zzadQ;
    }
    
    final boolean zzjx() {
        return this.zzadX;
    }
    
    final void zzjy() {
        this.zzadX = true;
    }
    
    public final void zzl(final long zzadT) {
        this.zzadT = zzadT;
    }
}
