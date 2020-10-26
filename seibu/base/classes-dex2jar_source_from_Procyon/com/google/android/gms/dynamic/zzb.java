// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.dynamic;

import java.util.Iterator;
import android.os.Bundle;

final class zzb implements zzo<Object>
{
    private /* synthetic */ zza zzaSv;
    
    zzb(final zza zzaSv) {
        this.zzaSv = zzaSv;
    }
    
    @Override
    public final void zza(final LifecycleDelegate lifecycleDelegate) {
        this.zzaSv.zzaSr = (T)lifecycleDelegate;
        final Iterator iterator = this.zzaSv.zzaSt.iterator();
        while (iterator.hasNext()) {
            iterator.next().zzb(this.zzaSv.zzaSr);
        }
        this.zzaSv.zzaSt.clear();
        zza.zza(this.zzaSv, (Bundle)null);
    }
}
