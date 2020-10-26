// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

public final class zzs
{
    public static String[] zzc(final Set<Scope> set) {
        zzbo.zzb(set, "scopes can't be null.");
        final Scope[] array = set.toArray(new Scope[set.size()]);
        zzbo.zzb(array, "scopes can't be null.");
        final String[] array2 = new String[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i].zzpp();
        }
        return array2;
    }
}
