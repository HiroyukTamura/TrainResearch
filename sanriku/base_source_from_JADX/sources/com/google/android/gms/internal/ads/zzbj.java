package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzbj extends zzegi {
    private ByteBuffer zzcs;

    public zzbj(String str) {
        super(str);
    }

    public final void zzg(ByteBuffer byteBuffer) {
        this.zzcs = byteBuffer;
        byteBuffer.position(byteBuffer.remaining() + byteBuffer.position());
    }
}
