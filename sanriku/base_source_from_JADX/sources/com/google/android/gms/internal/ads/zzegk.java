package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public abstract class zzegk extends zzegi implements zzbf {
    private int flags;
    private int version;

    protected zzegk(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.zziie) {
            zzbio();
        }
        return this.version;
    }

    /* access modifiers changed from: protected */
    public final long zzm(ByteBuffer byteBuffer) {
        this.version = zzbg.zza(byteBuffer.get());
        this.flags = zzbg.zza(byteBuffer.get()) + (zzbg.zzb(byteBuffer) << 8) + 0;
        return 4;
    }
}
