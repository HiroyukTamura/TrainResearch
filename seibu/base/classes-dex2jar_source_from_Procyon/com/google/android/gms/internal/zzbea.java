// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import android.os.Looper;
import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.NonNull;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.Set;

public final class zzbea
{
    private final Set<zzbdw<?>> zzauB;
    
    public zzbea() {
        this.zzauB = Collections.newSetFromMap(new WeakHashMap<zzbdw<?>, Boolean>());
    }
    
    public static <L> zzbdy<L> zza(@NonNull final L l, @NonNull final String s) {
        zzbo.zzb(l, "Listener must not be null");
        zzbo.zzb(s, "Listener type must not be null");
        zzbo.zzh(s, "Listener type must not be empty");
        return new zzbdy<L>(l, s);
    }
    
    public static <L> zzbdw<L> zzb(@NonNull final L l, @NonNull final Looper looper, @NonNull final String s) {
        zzbo.zzb(l, "Listener must not be null");
        zzbo.zzb(looper, "Looper must not be null");
        zzbo.zzb(s, "Listener type must not be null");
        return new zzbdw<L>(looper, l, s);
    }
    
    public final void release() {
        final Iterator<zzbdw<?>> iterator = this.zzauB.iterator();
        while (iterator.hasNext()) {
            iterator.next().clear();
        }
        this.zzauB.clear();
    }
    
    public final <L> zzbdw<L> zza(@NonNull final L l, @NonNull final Looper looper, @NonNull final String s) {
        final zzbdw<Object> zzb = zzb((Object)l, looper, s);
        this.zzauB.add(zzb);
        return (zzbdw<L>)zzb;
    }
}
