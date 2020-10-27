package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

public class zzegh extends zzegj implements zzbf {
    private String type;
    private long zzavy;
    private zzbi zziic;
    private boolean zziid;

    public zzegh(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void zza(zzbi zzbi) {
        this.zziic = zzbi;
    }

    public final void zza(zzegl zzegl, long j, zzbe zzbe) throws IOException {
        this.zziij = zzegl;
        long position = zzegl.position();
        this.zziio = position;
        this.zzbdj = position - ((long) ((this.zziid || 8 + j >= 4294967296L) ? 16 : 8));
        zzegl.zzfc(zzegl.position() + j);
        this.zzarx = zzegl.position();
        this.zziim = zzbe;
    }

    public final void zza(zzegl zzegl, ByteBuffer byteBuffer, long j, zzbe zzbe) throws IOException {
        this.zzavy = zzegl.position() - ((long) byteBuffer.remaining());
        this.zziid = byteBuffer.remaining() == 16;
        zza(zzegl, j, zzbe);
    }
}
