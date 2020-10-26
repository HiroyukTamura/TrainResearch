// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

final class zzi implements Callable<String>
{
    private /* synthetic */ SharedPreferences zzaXK;
    private /* synthetic */ String zzaXL;
    private /* synthetic */ String zzaXP;
    
    zzi(final SharedPreferences zzaXK, final String zzaXL, final String zzaXP) {
        this.zzaXK = zzaXK;
        this.zzaXL = zzaXL;
        this.zzaXP = zzaXP;
    }
}
