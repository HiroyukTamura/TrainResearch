// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.FilterInputStream;

final class zzaj extends FilterInputStream
{
    private int zzaz;
    
    private zzaj(final InputStream in) {
        super(in);
        this.zzaz = 0;
    }
    
    @Override
    public final int read() throws IOException {
        final int read = super.read();
        if (read != -1) {
            ++this.zzaz;
        }
        return read;
    }
    
    @Override
    public final int read(final byte[] b, int read, final int len) throws IOException {
        read = super.read(b, read, len);
        if (read != -1) {
            this.zzaz += read;
        }
        return read;
    }
}
