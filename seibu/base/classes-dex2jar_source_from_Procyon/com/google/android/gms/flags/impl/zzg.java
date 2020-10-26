// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzg implements Callable<Long>
{
    private /* synthetic */ SharedPreferences zzaXK;
    private /* synthetic */ String zzaXL;
    private /* synthetic */ Long zzaXO;
    
    zzg(final SharedPreferences zzaXK, final String zzaXL, final Long zzaXO) {
        this.zzaXK = zzaXK;
        this.zzaXL = zzaXL;
        this.zzaXO = zzaXO;
    }
}
