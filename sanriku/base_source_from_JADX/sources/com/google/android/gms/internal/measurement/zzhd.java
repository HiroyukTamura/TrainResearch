package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;
import p009e.p010a.p011a.p012a.C0681a;

class zzhd extends zzha {
    protected final byte[] zzb;

    zzhd(byte[] bArr) {
        if (bArr != null) {
            this.zzb = bArr;
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgt) || zza() != ((zzgt) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzhd)) {
            return obj.equals(this);
        }
        zzhd zzhd = (zzhd) obj;
        int zzd = zzd();
        int zzd2 = zzhd.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza((zzgt) zzhd, 0, zza());
        }
        return false;
    }

    public byte zza(int i) {
        return this.zzb[i];
    }

    public int zza() {
        return this.zzb.length;
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzie.zza(i, this.zzb, zze(), i3);
    }

    public final zzgt zza(int i, int i2) {
        int zzb2 = zzgt.zzb(0, i2, zza());
        return zzb2 == 0 ? zzgt.zza : new zzgw(this.zzb, zze(), zzb2);
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgq zzgq) throws IOException {
        zzgq.zza(this.zzb, zze(), zza());
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzgt zzgt, int i, int i2) {
        if (i2 > zzgt.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzgt.zza()) {
            throw new IllegalArgumentException(C0681a.m311a(59, "Ran off end of other: 0, ", i2, ", ", zzgt.zza()));
        } else if (!(zzgt instanceof zzhd)) {
            return zzgt.zza(0, i2).equals(zza(0, i2));
        } else {
            zzhd zzhd = (zzhd) zzgt;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzhd.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzhd.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i) {
        return this.zzb[i];
    }

    public final boolean zzc() {
        int zze = zze();
        return zzlc.zza(this.zzb, zze, zza() + zze);
    }

    /* access modifiers changed from: protected */
    public int zze() {
        return 0;
    }
}
