// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzaoq extends zzamg implements zzanj<zzaor>
{
    private final zzaor zzaiH;
    
    public zzaoq(final zzamj zzamj) {
        super(zzamj);
        this.zzaiH = new zzaor();
    }
    
    @Override
    public final void zzd(final String anObject, final int zzaiJ) {
        if ("ga_sessionTimeout".equals(anObject)) {
            this.zzaiH.zzaiJ = zzaiJ;
            return;
        }
        this.zzd("int configuration name not recognized", anObject);
    }
    
    @Override
    public final void zze(final String anObject, final boolean b) {
        final int n = 1;
        final int n2 = 1;
        int zzaiK = 1;
        if ("ga_autoActivityTracking".equals(anObject)) {
            final zzaor zzaiH = this.zzaiH;
            if (!b) {
                zzaiK = 0;
            }
            zzaiH.zzaiK = zzaiK;
            return;
        }
        if ("ga_anonymizeIp".equals(anObject)) {
            final zzaor zzaiH2 = this.zzaiH;
            int zzaiL;
            if (b) {
                zzaiL = n;
            }
            else {
                zzaiL = 0;
            }
            zzaiH2.zzaiL = zzaiL;
            return;
        }
        if ("ga_reportUncaughtExceptions".equals(anObject)) {
            final zzaor zzaiH3 = this.zzaiH;
            int zzaiM;
            if (b) {
                zzaiM = n2;
            }
            else {
                zzaiM = 0;
            }
            zzaiH3.zzaiM = zzaiM;
            return;
        }
        this.zzd("bool configuration name not recognized", anObject);
    }
    
    @Override
    public final void zzl(final String s, final String s2) {
        this.zzaiH.zzaiN.put(s, s2);
    }
    
    @Override
    public final void zzm(final String s, final String s2) {
        if ("ga_trackingId".equals(s)) {
            this.zzaiH.zzado = s2;
            return;
        }
        if ("ga_sampleFrequency".equals(s)) {
            try {
                this.zzaiH.zzaiI = Double.parseDouble(s2);
                return;
            }
            catch (NumberFormatException ex) {
                this.zzc("Error parsing ga_sampleFrequency value", s2, ex);
                return;
            }
        }
        this.zzd("string configuration name not recognized", s);
    }
}
