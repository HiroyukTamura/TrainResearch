// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.Set;
import com.google.android.gms.common.api.Api;
import java.util.Map;
import com.google.android.gms.common.api.Status;

public final class zzbev
{
    public static final Status zzaFj;
    private static final zzbbe<?>[] zzaFk;
    private final Map<Api.zzc<?>, Api.zze> zzaDF;
    final Set<zzbbe<?>> zzaFl;
    private final zzbex zzaFm;
    
    static {
        zzaFj = new Status(8, "The connection to Google Play services was lost");
        zzaFk = new zzbbe[0];
    }
    
    public zzbev(final Map<Api.zzc<?>, Api.zze> zzaDF) {
        this.zzaFl = Collections.synchronizedSet((Set<zzbbe<?>>)Collections.newSetFromMap((Map<T, Boolean>)new WeakHashMap<Object, Boolean>()));
        this.zzaFm = new zzbew(this);
        this.zzaDF = zzaDF;
    }
    
    public final void release() {
        final zzbbe<?>[] array = this.zzaFl.toArray(zzbev.zzaFk);
        for (int length = array.length, i = 0; i < length; ++i) {
            final zzbbe<?> zzbbe = array[i];
            zzbbe.zza((zzbex)null);
            zzbbe.zzpo();
            if (zzbbe.zzpB()) {
                this.zzaFl.remove(zzbbe);
            }
        }
    }
    
    final void zzb(final zzbbe<? extends Result> zzbbe) {
        this.zzaFl.add(zzbbe);
        zzbbe.zza(this.zzaFm);
    }
    
    public final void zzqM() {
        final zzbbe<?>[] array = this.zzaFl.toArray(zzbev.zzaFk);
        for (int length = array.length, i = 0; i < length; ++i) {
            array[i].zzs(zzbev.zzaFj);
        }
    }
}
