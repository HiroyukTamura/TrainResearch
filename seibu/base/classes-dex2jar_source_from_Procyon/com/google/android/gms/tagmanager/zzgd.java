// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.content.res.Configuration;
import android.content.ComponentCallbacks2;

final class zzgd implements ComponentCallbacks2
{
    private /* synthetic */ TagManager zzbGX;
    
    zzgd(final TagManager zzbGX) {
        this.zzbGX = zzbGX;
    }
    
    public final void onConfigurationChanged(final Configuration configuration) {
    }
    
    public final void onLowMemory() {
    }
    
    public final void onTrimMemory(final int n) {
        if (n == 20) {
            this.zzbGX.dispatch();
        }
    }
}
