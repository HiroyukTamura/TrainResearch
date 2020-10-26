// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;
import com.google.android.gms.common.internal.zzbo;
import java.io.ByteArrayOutputStream;

final class zzaof
{
    private int zzaiu;
    private ByteArrayOutputStream zzaiv;
    private /* synthetic */ zzaoe zzaiw;
    
    public zzaof(final zzaoe zzaiw) {
        this.zzaiw = zzaiw;
        this.zzaiv = new ByteArrayOutputStream();
    }
    
    public final byte[] getPayload() {
        return this.zzaiv.toByteArray();
    }
    
    public final boolean zze(final zzanx zzanx) {
        zzbo.zzu(zzanx);
        if (this.zzaiu + 1 > zzank.zzlt()) {
            return false;
        }
        final String zza = this.zzaiw.zza(zzanx, false);
        if (zza == null) {
            this.zzaiw.zzkr().zza(zzanx, "Error formatting hit");
            return true;
        }
        final byte[] bytes = zza.getBytes();
        final int length = bytes.length;
        if (length > zzank.zzlp()) {
            this.zzaiw.zzkr().zza(zzanx, "Hit size exceeds the maximum size limit");
            return true;
        }
        int n = length;
        if (this.zzaiv.size() > 0) {
            n = length + 1;
        }
        if (this.zzaiv.size() + n > zzans.zzahE.get()) {
            return false;
        }
        try {
            if (this.zzaiv.size() > 0) {
                this.zzaiv.write(zzaoe.zzait);
            }
            this.zzaiv.write(bytes);
            ++this.zzaiu;
            return true;
        }
        catch (IOException ex) {
            this.zzaiw.zze("Failed to write payload when batching hits", ex);
            return true;
        }
    }
    
    public final int zzlT() {
        return this.zzaiu;
    }
}
