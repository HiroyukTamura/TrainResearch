package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzbb extends ThreadLocal<ByteBuffer> {
    zzbb(zzbc zzbc) {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return ByteBuffer.allocate(32);
    }
}
