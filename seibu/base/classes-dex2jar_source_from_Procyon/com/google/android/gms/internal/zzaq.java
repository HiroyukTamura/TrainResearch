// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;
import java.io.ByteArrayOutputStream;

public final class zzaq extends ByteArrayOutputStream
{
    private final zzae zzap;
    
    public zzaq(final zzae zzap, final int a) {
        this.zzap = zzap;
        this.buf = this.zzap.zzb(Math.max(a, 256));
    }
    
    private final void zzc(final int n) {
        if (this.count + n <= this.buf.length) {
            return;
        }
        final byte[] zzb = this.zzap.zzb(this.count + n << 1);
        System.arraycopy(this.buf, 0, zzb, 0, this.count);
        this.zzap.zza(this.buf);
        this.buf = zzb;
    }
    
    @Override
    public final void close() throws IOException {
        this.zzap.zza(this.buf);
        this.buf = null;
        super.close();
    }
    
    public final void finalize() {
        this.zzap.zza(this.buf);
    }
    
    @Override
    public final void write(final int b) {
        synchronized (this) {
            this.zzc(1);
            super.write(b);
        }
    }
    
    @Override
    public final void write(final byte[] b, final int off, final int len) {
        synchronized (this) {
            this.zzc(len);
            super.write(b, off, len);
        }
    }
}
