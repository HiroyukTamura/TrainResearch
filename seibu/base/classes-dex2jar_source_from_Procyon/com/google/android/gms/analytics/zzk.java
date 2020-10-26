// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import java.util.Iterator;
import java.util.ArrayList;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.util.zze;
import java.util.List;

public class zzk<T extends zzk>
{
    private final zzl zzaea;
    protected final zzi zzaeb;
    private final List<Object> zzaec;
    
    protected zzk(final zzl zzaea, final zze zze) {
        zzbo.zzu(zzaea);
        this.zzaea = zzaea;
        this.zzaec = new ArrayList<Object>();
        final zzi zzaeb = new zzi(this, zze);
        zzaeb.zzjy();
        this.zzaeb = zzaeb;
    }
    
    protected void zza(final zzi zzi) {
    }
    
    protected final void zzd(final zzi zzi) {
        final Iterator<Object> iterator = this.zzaec.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }
    
    public zzi zzjj() {
        final zzi zzjp = this.zzaeb.zzjp();
        this.zzd(zzjp);
        return zzjp;
    }
    
    protected final zzl zzjz() {
        return this.zzaea;
    }
}
