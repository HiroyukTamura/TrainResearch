// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import java.util.Iterator;

final class zzm implements Runnable
{
    private /* synthetic */ zzi zzaej;
    private /* synthetic */ zzl zzaek;
    
    zzm(final zzl zzaek, final zzi zzaej) {
        this.zzaek = zzaek;
        this.zzaej = zzaej;
    }
    
    @Override
    public final void run() {
        this.zzaej.zzjw().zza(this.zzaej);
        final Iterator iterator = this.zzaek.zzaee.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        zzl.zza(this.zzaek, this.zzaej);
    }
}
