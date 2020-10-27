package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.charset.Charset;
import p009e.p010a.p011a.p012a.C0681a;

class zzqc extends zzqb {
    protected final byte[] zzawe;

    zzqc(byte[] bArr) {
        if (bArr != null) {
            this.zzawe = bArr;
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzps) || size() != ((zzps) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzqc)) {
            return obj.equals(this);
        }
        zzqc zzqc = (zzqc) obj;
        int zzne = zzne();
        int zzne2 = zzqc.zzne();
        if (zzne == 0 || zzne2 == 0 || zzne == zzne2) {
            return zza((zzps) zzqc, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzawe.length;
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzre.zza(i, this.zzawe, zznf(), i3);
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzawe, zznf(), size(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzpr zzpr) throws IOException {
        zzpr.zza(this.zzawe, zznf(), size());
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzps zzps, int i, int i2) {
        if (i2 > zzps.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzps.size()) {
            throw new IllegalArgumentException(C0681a.m311a(59, "Ran off end of other: 0, ", i2, ", ", zzps.size()));
        } else if (!(zzps instanceof zzqc)) {
            return zzps.zzc(0, i2).equals(zzc(0, i2));
        } else {
            zzqc zzqc = (zzqc) zzps;
            return zztx.zza(this.zzawe, zznf(), zzqc.zzawe, zzqc.zznf(), i2) == -1;
        }
    }

    public byte zzak(int i) {
        return this.zzawe[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzal(int i) {
        return this.zzawe[i];
    }

    public final zzps zzc(int i, int i2) {
        int zzb = zzps.zzb(0, i2, size());
        return zzb == 0 ? zzps.zzavx : new zzpx(this.zzawe, zznf(), zzb);
    }

    public final boolean zznd() {
        int zznf = zznf();
        return zztz.zzf(this.zzawe, zznf, size() + zznf);
    }

    /* access modifiers changed from: protected */
    public int zznf() {
        return 0;
    }
}
