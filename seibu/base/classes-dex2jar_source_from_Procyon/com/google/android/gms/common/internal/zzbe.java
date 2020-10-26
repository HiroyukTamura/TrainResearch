// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.support.annotation.Nullable;

public final class zzbe
{
    public static boolean equal(@Nullable final Object o, @Nullable final Object obj) {
        return o == obj || (o != null && o.equals(obj));
    }
    
    public static zzbg zzt(final Object o) {
        return new zzbg(o, null);
    }
}
