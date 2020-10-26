// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzc implements Callable<Boolean>
{
    private /* synthetic */ SharedPreferences zzaXK;
    private /* synthetic */ String zzaXL;
    private /* synthetic */ Boolean zzaXM;
    
    zzc(final SharedPreferences zzaXK, final String zzaXL, final Boolean zzaXM) {
        this.zzaXK = zzaXK;
        this.zzaXL = zzaXL;
        this.zzaXM = zzaXM;
    }
}
