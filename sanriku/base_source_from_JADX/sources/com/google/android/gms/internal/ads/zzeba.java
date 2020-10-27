package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

class zzeba extends zzebb {
    protected final byte[] zzhtm;

    zzeba(byte[] bArr) {
        if (bArr != null) {
            this.zzhtm = bArr;
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeaq) || size() != ((zzeaq) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzeba)) {
            return obj.equals(this);
        }
        zzeba zzeba = (zzeba) obj;
        int zzbcu = zzbcu();
        int zzbcu2 = zzeba.zzbcu();
        if (zzbcu == 0 || zzbcu2 == 0 || zzbcu == zzbcu2) {
            return zza(zzeba, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzhtm.length;
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzhtm, zzbcv(), size(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzear zzear) throws IOException {
        zzear.zzi(this.zzhtm, zzbcv(), size());
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzeaq zzeaq, int i, int i2) {
        if (i2 <= zzeaq.size()) {
            int i3 = i + i2;
            if (i3 > zzeaq.size()) {
                int size = zzeaq.size();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: ");
                sb.append(i);
                sb.append(", ");
                sb.append(i2);
                sb.append(", ");
                sb.append(size);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(zzeaq instanceof zzeba)) {
                return zzeaq.zzz(i, i3).equals(zzz(0, i2));
            } else {
                zzeba zzeba = (zzeba) zzeaq;
                byte[] bArr = this.zzhtm;
                byte[] bArr2 = zzeba.zzhtm;
                int zzbcv = zzbcv() + i2;
                int zzbcv2 = zzbcv();
                int zzbcv3 = zzeba.zzbcv() + i;
                while (zzbcv2 < zzbcv) {
                    if (bArr[zzbcv2] != bArr2[zzbcv3]) {
                        return false;
                    }
                    zzbcv2++;
                    zzbcv3++;
                }
                return true;
            }
        } else {
            int size2 = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzhtm, i, bArr, i2, i3);
    }

    public final boolean zzbcp() {
        int zzbcv = zzbcv();
        return zzefk.zzm(this.zzhtm, zzbcv, size() + zzbcv);
    }

    public final zzebf zzbcq() {
        return zzebf.zzb(this.zzhtm, zzbcv(), size(), true);
    }

    /* access modifiers changed from: protected */
    public int zzbcv() {
        return 0;
    }

    public byte zzfo(int i) {
        return this.zzhtm[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzfp(int i) {
        return this.zzhtm[i];
    }

    /* access modifiers changed from: protected */
    public final int zzg(int i, int i2, int i3) {
        int zzbcv = zzbcv() + i2;
        return zzefk.zzb(i, this.zzhtm, zzbcv, i3 + zzbcv);
    }

    /* access modifiers changed from: protected */
    public final int zzh(int i, int i2, int i3) {
        return zzecg.zza(i, this.zzhtm, zzbcv() + i2, i3);
    }

    public final zzeaq zzz(int i, int i2) {
        int zzi = zzeaq.zzi(i, i2, size());
        return zzi == 0 ? zzeaq.zzhtf : new zzeax(this.zzhtm, zzbcv() + i, zzi);
    }
}
