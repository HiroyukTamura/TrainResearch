// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.Logger;

final class zzgh implements Logger
{
    @Override
    public final void error(final Exception ex) {
        zzdj.zzb("", ex);
    }
    
    @Override
    public final void error(final String s) {
        zzdj.e(s);
    }
    
    @Override
    public final int getLogLevel() {
        switch (zzdj.zzbFq) {
            default: {
                return 3;
            }
            case 5: {
                return 2;
            }
            case 3:
            case 4: {
                return 1;
            }
            case 2: {
                return 0;
            }
        }
    }
    
    @Override
    public final void info(final String s) {
        zzdj.zzaS(s);
    }
    
    @Override
    public final void setLogLevel(final int n) {
        zzdj.zzaT("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }
    
    @Override
    public final void verbose(final String s) {
        zzdj.v(s);
    }
    
    @Override
    public final void warn(final String s) {
        zzdj.zzaT(s);
    }
}
