// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;

final class zzgb implements zzb
{
    private /* synthetic */ TagManager zzbGX;
    
    zzgb(final TagManager zzbGX) {
        this.zzbGX = zzbGX;
    }
    
    @Override
    public final void zzp(final Map<String, Object> map) {
        final Object value = map.get("event");
        if (value != null) {
            this.zzbGX.zzfu(value.toString());
        }
    }
}
