// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public final class zzamu extends zzamh
{
    private final zzalk zzaeh;
    
    zzamu(final zzamj zzamj) {
        super(zzamj);
        this.zzaeh = new zzalk();
    }
    
    @Override
    protected final void zzjD() {
        this.zzkt().zzjA().zza(this.zzaeh);
        final zzaot zzkx = this.zzkx();
        final String zzjG = zzkx.zzjG();
        if (zzjG != null) {
            this.zzaeh.setAppName(zzjG);
        }
        final String zzjH = zzkx.zzjH();
        if (zzjH != null) {
            this.zzaeh.setAppVersion(zzjH);
        }
    }
    
    public final zzalk zzkW() {
        this.zzkD();
        return this.zzaeh;
    }
}
