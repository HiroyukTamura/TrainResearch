// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.data;

import android.net.Uri;
import android.database.CharArrayBuffer;
import java.util.Arrays;
import com.google.android.gms.common.internal.zzbe;
import com.google.android.gms.common.internal.zzbo;

public class zzc
{
    protected final DataHolder zzaCX;
    protected int zzaFx;
    private int zzaFy;
    
    public zzc(final DataHolder dataHolder, final int n) {
        this.zzaCX = zzbo.zzu(dataHolder);
        this.zzar(n);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b2;
        final boolean b = b2 = false;
        if (o instanceof zzc) {
            final zzc zzc = (zzc)o;
            b2 = b;
            if (zzbe.equal(zzc.zzaFx, this.zzaFx)) {
                b2 = b;
                if (zzbe.equal(zzc.zzaFy, this.zzaFy)) {
                    b2 = b;
                    if (zzc.zzaCX == this.zzaCX) {
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    protected final boolean getBoolean(final String s) {
        return this.zzaCX.zze(s, this.zzaFx, this.zzaFy);
    }
    
    protected final byte[] getByteArray(final String s) {
        return this.zzaCX.zzg(s, this.zzaFx, this.zzaFy);
    }
    
    protected final float getFloat(final String s) {
        return this.zzaCX.zzf(s, this.zzaFx, this.zzaFy);
    }
    
    protected final int getInteger(final String s) {
        return this.zzaCX.zzc(s, this.zzaFx, this.zzaFy);
    }
    
    protected final long getLong(final String s) {
        return this.zzaCX.zzb(s, this.zzaFx, this.zzaFy);
    }
    
    protected final String getString(final String s) {
        return this.zzaCX.zzd(s, this.zzaFx, this.zzaFy);
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[] { this.zzaFx, this.zzaFy, this.zzaCX });
    }
    
    public boolean isDataValid() {
        return !this.zzaCX.isClosed();
    }
    
    protected final void zza(final String s, final CharArrayBuffer charArrayBuffer) {
        this.zzaCX.zza(s, this.zzaFx, this.zzaFy, charArrayBuffer);
    }
    
    protected final void zzar(final int zzaFx) {
        zzbo.zzae(zzaFx >= 0 && zzaFx < this.zzaCX.zzaFG);
        this.zzaFx = zzaFx;
        this.zzaFy = this.zzaCX.zzat(this.zzaFx);
    }
    
    public final boolean zzcv(final String s) {
        return this.zzaCX.zzcv(s);
    }
    
    protected final Uri zzcw(String zzd) {
        zzd = this.zzaCX.zzd(zzd, this.zzaFx, this.zzaFy);
        if (zzd == null) {
            return null;
        }
        return Uri.parse(zzd);
    }
    
    protected final boolean zzcx(final String s) {
        return this.zzaCX.zzh(s, this.zzaFx, this.zzaFy);
    }
}
