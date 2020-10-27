package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzbc implements zzbe {
    private static Logger zzcp = Logger.getLogger(zzbc.class.getName());
    private ThreadLocal<ByteBuffer> zzcq = new zzbb(this);

    public final zzbf zza(zzegl zzegl, zzbi zzbi) throws IOException {
        int read;
        long j;
        zzegl zzegl2 = zzegl;
        zzbi zzbi2 = zzbi;
        long position = zzegl.position();
        this.zzcq.get().rewind().limit(8);
        do {
            read = zzegl2.read(this.zzcq.get());
            if (read == 8) {
                this.zzcq.get().rewind();
                long zza = zzbg.zza(this.zzcq.get());
                byte[] bArr = null;
                if (zza >= 8 || zza <= 1) {
                    String zzf = zzbg.zzf(this.zzcq.get());
                    if (zza == 1) {
                        this.zzcq.get().limit(16);
                        zzegl2.read(this.zzcq.get());
                        this.zzcq.get().position(8);
                        j = zzbg.zzc(this.zzcq.get()) - 16;
                    } else {
                        j = zza == 0 ? zzegl.size() - zzegl.position() : zza - 8;
                    }
                    if ("uuid".equals(zzf)) {
                        this.zzcq.get().limit(this.zzcq.get().limit() + 16);
                        zzegl2.read(this.zzcq.get());
                        bArr = new byte[16];
                        for (int position2 = this.zzcq.get().position() - 16; position2 < this.zzcq.get().position(); position2++) {
                            bArr[position2 - (this.zzcq.get().position() - 16)] = this.zzcq.get().get(position2);
                        }
                        j -= 16;
                    }
                    long j2 = j;
                    zzbf zza2 = zza(zzf, bArr, zzbi2 instanceof zzbf ? ((zzbf) zzbi2).getType() : "");
                    zza2.zza(zzbi2);
                    this.zzcq.get().rewind();
                    zza2.zza(zzegl, this.zzcq.get(), j2, this);
                    return zza2;
                }
                Logger logger = zzcp;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder(80);
                sb.append("Plausibility check failed: size < 8 (size = ");
                sb.append(zza);
                sb.append("). Stop parsing!");
                logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                return null;
            }
        } while (read >= 0);
        zzegl2.zzfc(position);
        throw new EOFException();
    }

    public abstract zzbf zza(String str, byte[] bArr, String str2);
}
