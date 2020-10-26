// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.util.Log;

public final class zzba implements zzdk
{
    private int zzagX;
    
    public zzba() {
        this.zzagX = 5;
    }
    
    @Override
    public final void e(final String s) {
        if (this.zzagX <= 6) {
            Log.e("GoogleTagManager", s);
        }
    }
    
    @Override
    public final void setLogLevel(final int zzagX) {
        this.zzagX = zzagX;
    }
    
    @Override
    public final void v(final String s) {
        if (this.zzagX <= 2) {
            Log.v("GoogleTagManager", s);
        }
    }
    
    @Override
    public final void zzaC(final String s) {
        if (this.zzagX <= 3) {
            Log.d("GoogleTagManager", s);
        }
    }
    
    @Override
    public final void zzaS(final String s) {
        if (this.zzagX <= 4) {
            Log.i("GoogleTagManager", s);
        }
    }
    
    @Override
    public final void zzaT(final String s) {
        if (this.zzagX <= 5) {
            Log.w("GoogleTagManager", s);
        }
    }
    
    @Override
    public final void zzb(final String s, final Throwable t) {
        if (this.zzagX <= 6) {
            Log.e("GoogleTagManager", s, t);
        }
    }
    
    @Override
    public final void zzc(final String s, final Throwable t) {
        if (this.zzagX <= 5) {
            Log.w("GoogleTagManager", s, t);
        }
    }
}
