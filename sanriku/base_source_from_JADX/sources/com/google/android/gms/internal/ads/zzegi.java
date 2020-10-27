package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class zzegi implements zzbf {
    private static zzegr zzcr = zzegr.zzn(zzegi.class);
    private String type;
    private long zzavy;
    private zzbi zziic;
    boolean zziie;
    private boolean zziif;
    private ByteBuffer zziig;
    private long zziih;
    private long zziii = -1;
    private zzegl zziij;
    private ByteBuffer zziik = null;

    protected zzegi(String str) {
        this.type = str;
        this.zziif = true;
        this.zziie = true;
    }

    private final synchronized void zzbin() {
        if (!this.zziif) {
            try {
                zzegr zzegr = zzcr;
                String valueOf = String.valueOf(this.type);
                zzegr.zzig(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.zziig = this.zziij.zzh(this.zziih, this.zziii);
                this.zziif = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String getType() {
        return this.type;
    }

    public final void zza(zzbi zzbi) {
        this.zziic = zzbi;
    }

    public final void zza(zzegl zzegl, ByteBuffer byteBuffer, long j, zzbe zzbe) throws IOException {
        long position = zzegl.position();
        this.zziih = position;
        this.zzavy = position - ((long) byteBuffer.remaining());
        this.zziii = j;
        this.zziij = zzegl;
        zzegl.zzfc(zzegl.position() + j);
        this.zziif = false;
        this.zziie = false;
        zzbio();
    }

    public final synchronized void zzbio() {
        zzbin();
        zzegr zzegr = zzcr;
        String valueOf = String.valueOf(this.type);
        zzegr.zzig(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        if (this.zziig != null) {
            ByteBuffer byteBuffer = this.zziig;
            this.zziie = true;
            byteBuffer.rewind();
            zzg(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zziik = byteBuffer.slice();
            }
            this.zziig = null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzg(ByteBuffer byteBuffer);
}
