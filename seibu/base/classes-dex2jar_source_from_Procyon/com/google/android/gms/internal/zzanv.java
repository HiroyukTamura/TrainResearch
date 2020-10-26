// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzanv implements zzanj<zzanw>
{
    private final zzamj zzafJ;
    private final zzanw zzahX;
    
    public zzanv(final zzamj zzafJ) {
        this.zzafJ = zzafJ;
        this.zzahX = new zzanw();
    }
    
    @Override
    public final void zzd(final String anObject, final int zzahZ) {
        if ("ga_dispatchPeriod".equals(anObject)) {
            this.zzahX.zzahZ = zzahZ;
            return;
        }
        this.zzafJ.zzkr().zzd("Int xml configuration name not recognized", anObject);
    }
    
    @Override
    public final void zze(final String anObject, final boolean b) {
        if ("ga_dryRun".equals(anObject)) {
            final zzanw zzahX = this.zzahX;
            int zzaia;
            if (b) {
                zzaia = 1;
            }
            else {
                zzaia = 0;
            }
            zzahX.zzaia = zzaia;
            return;
        }
        this.zzafJ.zzkr().zzd("Bool xml configuration name not recognized", anObject);
    }
    
    @Override
    public final void zzl(final String s, final String s2) {
    }
    
    @Override
    public final void zzm(final String anObject, final String zzahY) {
        if ("ga_appName".equals(anObject)) {
            this.zzahX.zzaeH = zzahY;
            return;
        }
        if ("ga_appVersion".equals(anObject)) {
            this.zzahX.zzaeI = zzahY;
            return;
        }
        if ("ga_logLevel".equals(anObject)) {
            this.zzahX.zzahY = zzahY;
            return;
        }
        this.zzafJ.zzkr().zzd("String xml configuration name not recognized", anObject);
    }
}
