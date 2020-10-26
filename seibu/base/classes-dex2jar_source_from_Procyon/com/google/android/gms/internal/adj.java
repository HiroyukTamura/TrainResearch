// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public abstract class adj<M extends adj<M>> extends adp
{
    protected adl zzcso;
    
    public M zzLN() throws CloneNotSupportedException {
        final adj adj = (adj)super.zzLO();
        adn.zza(this, adj);
        return (M)adj;
    }
    
    public final <T> T zza(final adk<M, T> adk) {
        if (this.zzcso != null) {
            final adm zzcx = this.zzcso.zzcx(adk.tag >>> 3);
            if (zzcx != null) {
                return zzcx.zzb(adk);
            }
        }
        return null;
    }
    
    @Override
    public void zza(final adh adh) throws IOException {
        if (this.zzcso != null) {
            for (int i = 0; i < this.zzcso.size(); ++i) {
                this.zzcso.zzcy(i).zza(adh);
            }
        }
    }
    
    protected final boolean zza(final adg adg, final int n) throws IOException {
        final int position = adg.getPosition();
        if (!adg.zzcm(n)) {
            return false;
        }
        final int n2 = n >>> 3;
        final adr adr = new adr(n, adg.zzp(position, adg.getPosition() - position));
        adm zzcx = null;
        if (this.zzcso == null) {
            this.zzcso = new adl();
        }
        else {
            zzcx = this.zzcso.zzcx(n2);
        }
        adm adm = zzcx;
        if (zzcx == null) {
            adm = new adm();
            this.zzcso.zza(n2, adm);
        }
        adm.zza(adr);
        return true;
    }
    
    @Override
    protected int zzn() {
        int n = 0;
        int n3;
        if (this.zzcso != null) {
            int n2 = 0;
            while (true) {
                n3 = n2;
                if (n >= this.zzcso.size()) {
                    break;
                }
                n2 += this.zzcso.zzcy(n).zzn();
                ++n;
            }
        }
        else {
            n3 = 0;
        }
        return n3;
    }
}
