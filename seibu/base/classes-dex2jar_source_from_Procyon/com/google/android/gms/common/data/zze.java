// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.data;

import java.util.HashMap;
import android.content.ContentValues;

final class zze extends zza
{
    zze(final String[] array, final String s) {
        super(array, null, null);
    }
    
    @Override
    public final zza zza(final ContentValues contentValues) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }
    
    @Override
    public final zza zza(final HashMap<String, Object> hashMap) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }
}
