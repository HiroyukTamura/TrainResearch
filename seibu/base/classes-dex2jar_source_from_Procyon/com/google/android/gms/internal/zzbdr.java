// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.internal.zzbo;
import android.app.Activity;

public final class zzbdr
{
    private final Object zzaEF;
    
    public zzbdr(final Activity zzaEF) {
        zzbo.zzb(zzaEF, "Activity must not be null");
        this.zzaEF = zzaEF;
    }
    
    public final boolean zzqC() {
        return this.zzaEF instanceof FragmentActivity;
    }
    
    public final Activity zzqD() {
        return (Activity)this.zzaEF;
    }
    
    public final FragmentActivity zzqE() {
        return (FragmentActivity)this.zzaEF;
    }
}
