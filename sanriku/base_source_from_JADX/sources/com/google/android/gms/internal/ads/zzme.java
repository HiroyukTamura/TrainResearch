package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import p009e.p010a.p011a.p012a.C0681a;

final class zzme {
    private final zzjo zzaqn;
    private final zzjm[] zzbcb;
    private zzjm zzbcc;

    public zzme(zzjm[] zzjmArr, zzjo zzjo) {
        this.zzbcb = zzjmArr;
        this.zzaqn = zzjo;
    }

    public final void release() {
        zzjm zzjm = this.zzbcc;
        if (zzjm != null) {
            zzjm.release();
            this.zzbcc = null;
        }
    }

    public final zzjm zza(zzjl zzjl, Uri uri) throws IOException, InterruptedException {
        zzjm zzjm = this.zzbcc;
        if (zzjm != null) {
            return zzjm;
        }
        zzjm[] zzjmArr = this.zzbcb;
        int length = zzjmArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzjm zzjm2 = zzjmArr[i];
            try {
                if (zzjm2.zza(zzjl)) {
                    this.zzbcc = zzjm2;
                    zzjl.zzgp();
                    break;
                }
                zzjl.zzgp();
                i++;
            } catch (EOFException unused) {
            } catch (Throwable th) {
                zzjl.zzgp();
                throw th;
            }
        }
        zzjm zzjm3 = this.zzbcc;
        if (zzjm3 != null) {
            zzjm3.zza(this.zzaqn);
            return this.zzbcc;
        }
        String zza = zzov.zza((Object[]) this.zzbcb);
        throw new zzmz(C0681a.m313a(C0681a.m336b(zza, 58), "None of the available extractors (", zza, ") could read the stream."), uri);
    }
}
