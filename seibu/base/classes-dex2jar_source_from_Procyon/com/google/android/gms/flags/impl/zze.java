// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zze implements Callable<Integer>
{
    private /* synthetic */ SharedPreferences zzaXK;
    private /* synthetic */ String zzaXL;
    private /* synthetic */ Integer zzaXN;
    
    zze(final SharedPreferences zzaXK, final String zzaXL, final Integer zzaXN) {
        this.zzaXK = zzaXK;
        this.zzaXL = zzaXL;
        this.zzaXN = zzaXN;
    }
}
