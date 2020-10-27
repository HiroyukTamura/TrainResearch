package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.nio.charset.Charset;
import p009e.p010a.p011a.p012a.C0681a;

class zzfp extends zzfm {
    protected final byte[] zzrp;

    zzfp(byte[] bArr) {
        if (bArr != null) {
            this.zzrp = bArr;
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzff) || size() != ((zzff) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzfp)) {
            return obj.equals(this);
        }
        zzfp zzfp = (zzfp) obj;
        int zzar = zzar();
        int zzar2 = zzfp.zzar();
        if (zzar == 0 || zzar2 == 0 || zzar == zzar2) {
            return zza((zzff) zzfp, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzrp.length;
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzgk.zza(i, this.zzrp, zzas(), i3);
    }

    public final zzff zza(int i, int i2) {
        int zzb = zzff.zzb(0, i2, size());
        return zzb == 0 ? zzff.zzri : new zzfi(this.zzrp, zzas(), zzb);
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzrp, zzas(), size(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfc zzfc) throws IOException {
        zzfc.zza(this.zzrp, zzas(), size());
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzff zzff, int i, int i2) {
        if (i2 > zzff.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzff.size()) {
            throw new IllegalArgumentException(C0681a.m311a(59, "Ran off end of other: 0, ", i2, ", ", zzff.size()));
        } else if (!(zzff instanceof zzfp)) {
            return zzff.zza(0, i2).equals(zza(0, i2));
        } else {
            zzfp zzfp = (zzfp) zzff;
            byte[] bArr = this.zzrp;
            byte[] bArr2 = zzfp.zzrp;
            int zzas = zzas() + i2;
            int zzas2 = zzas();
            int zzas3 = zzfp.zzas();
            while (zzas2 < zzas) {
                if (bArr[zzas2] != bArr2[zzas3]) {
                    return false;
                }
                zzas2++;
                zzas3++;
            }
            return true;
        }
    }

    public final boolean zzaq() {
        int zzas = zzas();
        return zzjc.zzc(this.zzrp, zzas, size() + zzas);
    }

    /* access modifiers changed from: protected */
    public int zzas() {
        return 0;
    }

    public byte zzh(int i) {
        return this.zzrp[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzi(int i) {
        return this.zzrp[i];
    }
}
