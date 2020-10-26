// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Arrays;
import com.google.android.gms.common.internal.zzbe;
import android.support.annotation.Nullable;

public final class aae
{
    private String zzakv;
    
    public aae(@Nullable final String zzakv) {
        this.zzakv = zzakv;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o instanceof aae && zzbe.equal(this.zzakv, ((aae)o).zzakv);
    }
    
    @Nullable
    public final String getToken() {
        return this.zzakv;
    }
    
    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.zzakv });
    }
    
    @Override
    public final String toString() {
        return zzbe.zzt(this).zzg("token", this.zzakv).toString();
    }
}
