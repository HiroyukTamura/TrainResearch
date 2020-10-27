package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzebk extends zzear {
    private static final Logger logger = Logger.getLogger(zzebk.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzhui = zzefi.zzbhh();
    zzebn zzhuj;

    static class zza extends zzebk {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = 0;
                    this.position = 0;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void writeTag(int i, int i2) throws IOException {
            zzgh((i << 3) | i2);
        }

        public final void zza(int i, zzeaq zzeaq) throws IOException {
            writeTag(i, 2);
            zzah(zzeaq);
        }

        public final void zza(int i, zzedo zzedo) throws IOException {
            writeTag(1, 3);
            zzac(2, i);
            writeTag(3, 2);
            zzg(zzedo);
            writeTag(1, 4);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzedo zzedo, zzeek zzeek) throws IOException {
            writeTag(i, 2);
            zzeag zzeag = (zzeag) zzedo;
            int zzbcf = zzeag.zzbcf();
            if (zzbcf == -1) {
                zzbcf = zzeek.zzau(zzeag);
                zzeag.zzfk(zzbcf);
            }
            zzgh(zzbcf);
            zzeek.zza(zzedo, this.zzhuj);
        }

        public final void zzab(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzgg(i2);
        }

        public final void zzac(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzgh(i2);
        }

        public final void zzae(int i, int i2) throws IOException {
            writeTag(i, 5);
            zzgj(i2);
        }

        public final void zzah(zzeaq zzeaq) throws IOException {
            zzgh(zzeaq.size());
            zzeaq.zza((zzear) this);
        }

        public final void zzb(int i, zzeaq zzeaq) throws IOException {
            writeTag(1, 3);
            zzac(2, i);
            zza(3, zzeaq);
            writeTag(1, 4);
        }

        public final int zzbdy() {
            return this.limit - this.position;
        }

        public final void zzd(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzfi(long j) throws IOException {
            if (!zzebk.zzhui || zzbdy() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzefi.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzefi.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzfk(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i2 = i + 1;
                this.position = i2;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i3 = i2 + 1;
                this.position = i3;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i6 = i5 + 1;
                this.position = i6;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i7 = i6 + 1;
                this.position = i7;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i8 = i7 + 1;
                this.position = i8;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzg(zzedo zzedo) throws IOException {
            zzgh(zzedo.zzbex());
            zzedo.zzb(this);
        }

        public final void zzgg(int i) throws IOException {
            if (i >= 0) {
                zzgh(i);
            } else {
                zzfi((long) i);
            }
        }

        public final void zzgh(int i) throws IOException {
            if (!zzebk.zzhui || zzean.zzbcl() || zzbdy() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzefi.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzefi.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzefi.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzefi.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzefi.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzefi.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzefi.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzefi.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzefi.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void zzgj(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzh(int i, long j) throws IOException {
            writeTag(i, 0);
            zzfi(j);
        }

        public final void zzh(int i, boolean z) throws IOException {
            writeTag(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        public final void zzhr(String str) throws IOException {
            int i = this.position;
            try {
                int zzgm = zzebk.zzgm(str.length() * 3);
                int zzgm2 = zzebk.zzgm(str.length());
                if (zzgm2 == zzgm) {
                    int i2 = i + zzgm2;
                    this.position = i2;
                    int zza = zzefk.zza(str, this.buffer, i2, zzbdy());
                    this.position = i;
                    zzgh((zza - i) - zzgm2);
                    this.position = zza;
                    return;
                }
                zzgh(zzefk.zza(str));
                this.position = zzefk.zza(str, this.buffer, this.position, zzbdy());
            } catch (zzefo e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        public final void zzi(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzj(int i, long j) throws IOException {
            writeTag(i, 1);
            zzfk(j);
        }

        public final void zzk(int i, String str) throws IOException {
            writeTag(i, 2);
            zzhr(str);
        }

        public final void zzk(byte[] bArr, int i, int i2) throws IOException {
            zzgh(i2);
            write(bArr, 0, i2);
        }
    }

    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zzb(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebk.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    private zzebk() {
    }

    public static int zza(int i, zzect zzect) {
        int zzgk = zzgk(i);
        int zzbex = zzect.zzbex();
        return zzgm(zzbex) + zzbex + zzgk;
    }

    public static int zza(zzect zzect) {
        int zzbex = zzect.zzbex();
        return zzgm(zzbex) + zzbex;
    }

    static int zza(zzedo zzedo, zzeek zzeek) {
        zzeag zzeag = (zzeag) zzedo;
        int zzbcf = zzeag.zzbcf();
        if (zzbcf == -1) {
            zzbcf = zzeek.zzau(zzeag);
            zzeag.zzfk(zzbcf);
        }
        return zzgm(zzbcf) + zzbcf;
    }

    public static int zzaf(int i, int i2) {
        return zzgl(i2) + zzgk(i);
    }

    public static int zzag(int i, int i2) {
        return zzgm(i2) + zzgk(i);
    }

    public static int zzah(int i, int i2) {
        return zzgm(zzgr(i2)) + zzgk(i);
    }

    public static int zzai(int i, int i2) {
        return zzgk(i) + 4;
    }

    public static int zzai(zzeaq zzeaq) {
        int size = zzeaq.size();
        return zzgm(size) + size;
    }

    public static int zzaj(int i, int i2) {
        return zzgk(i) + 4;
    }

    public static int zzak(int i, int i2) {
        return zzgl(i2) + zzgk(i);
    }

    public static int zzb(int i, float f) {
        return zzgk(i) + 4;
    }

    public static int zzb(int i, zzect zzect) {
        int zzag = zzag(2, i);
        return zza(3, zzect) + zzag + (zzgk(1) << 1);
    }

    public static int zzb(int i, zzedo zzedo) {
        return zzh(zzedo) + zzgk(3) + zzag(2, i) + (zzgk(1) << 1);
    }

    static int zzb(int i, zzedo zzedo, zzeek zzeek) {
        return zzgk(i) + zza(zzedo, zzeek);
    }

    public static int zzbt(boolean z) {
        return 1;
    }

    public static int zzc(double d) {
        return 8;
    }

    public static int zzc(int i, double d) {
        return zzgk(i) + 8;
    }

    public static int zzc(int i, zzeaq zzeaq) {
        int zzgk = zzgk(i);
        int size = zzeaq.size();
        return zzgm(size) + size + zzgk;
    }

    @Deprecated
    static int zzc(int i, zzedo zzedo, zzeek zzeek) {
        int zzgk = zzgk(i) << 1;
        zzeag zzeag = (zzeag) zzedo;
        int zzbcf = zzeag.zzbcf();
        if (zzbcf == -1) {
            zzbcf = zzeek.zzau(zzeag);
            zzeag.zzfk(zzbcf);
        }
        return zzgk + zzbcf;
    }

    public static int zzd(int i, zzeaq zzeaq) {
        int zzag = zzag(2, i);
        return zzc(3, zzeaq) + zzag + (zzgk(1) << 1);
    }

    public static int zzfl(long j) {
        return zzfm(j);
    }

    public static int zzfm(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzfn(long j) {
        return zzfm(zzfq(j));
    }

    public static int zzfo(long j) {
        return 8;
    }

    public static int zzfp(long j) {
        return 8;
    }

    private static long zzfq(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzg(float f) {
        return 4;
    }

    public static int zzgk(int i) {
        return zzgm(i << 3);
    }

    public static int zzgl(int i) {
        if (i >= 0) {
            return zzgm(i);
        }
        return 10;
    }

    public static int zzgm(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzgn(int i) {
        return zzgm(zzgr(i));
    }

    public static int zzgo(int i) {
        return 4;
    }

    public static int zzgp(int i) {
        return 4;
    }

    public static int zzgq(int i) {
        return zzgl(i);
    }

    private static int zzgr(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzgs(int i) {
        return zzgm(i);
    }

    public static int zzh(zzedo zzedo) {
        int zzbex = zzedo.zzbex();
        return zzgm(zzbex) + zzbex;
    }

    public static int zzhs(String str) {
        int i;
        try {
            i = zzefk.zza(str);
        } catch (zzefo unused) {
            i = str.getBytes(zzecg.UTF_8).length;
        }
        return zzgm(i) + i;
    }

    public static int zzi(int i, boolean z) {
        return zzgk(i) + 1;
    }

    @Deprecated
    public static int zzi(zzedo zzedo) {
        return zzedo.zzbex();
    }

    public static int zzk(int i, long j) {
        return zzfm(j) + zzgk(i);
    }

    public static int zzl(int i, long j) {
        return zzfm(j) + zzgk(i);
    }

    public static int zzl(int i, String str) {
        return zzhs(str) + zzgk(i);
    }

    public static int zzm(int i, long j) {
        return zzfm(zzfq(j)) + zzgk(i);
    }

    public static int zzn(int i, long j) {
        return zzgk(i) + 8;
    }

    public static int zzo(int i, long j) {
        return zzgk(i) + 8;
    }

    public static zzebk zzw(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzx(byte[] bArr) {
        int length = bArr.length;
        return zzgm(length) + length;
    }

    public abstract void writeTag(int i, int i2) throws IOException;

    public final void zza(int i, float f) throws IOException {
        zzae(i, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i, zzeaq zzeaq) throws IOException;

    public abstract void zza(int i, zzedo zzedo) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzedo zzedo, zzeek zzeek) throws IOException;

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzefo zzefo) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzefo);
        byte[] bytes = str.getBytes(zzecg.UTF_8);
        try {
            zzgh(bytes.length);
            zzi(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb(e);
        } catch (zzb e2) {
            throw e2;
        }
    }

    public abstract void zzab(int i, int i2) throws IOException;

    public abstract void zzac(int i, int i2) throws IOException;

    public final void zzad(int i, int i2) throws IOException {
        zzac(i, zzgr(i2));
    }

    public abstract void zzae(int i, int i2) throws IOException;

    public abstract void zzah(zzeaq zzeaq) throws IOException;

    public final void zzb(double d) throws IOException {
        zzfk(Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, double d) throws IOException {
        zzj(i, Double.doubleToRawLongBits(d));
    }

    public abstract void zzb(int i, zzeaq zzeaq) throws IOException;

    public abstract int zzbdy();

    public final void zzbdz() {
        if (zzbdy() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzbs(boolean z) throws IOException {
        zzd(z ? (byte) 1 : 0);
    }

    public abstract void zzd(byte b) throws IOException;

    public final void zzf(float f) throws IOException {
        zzgj(Float.floatToRawIntBits(f));
    }

    public abstract void zzfi(long j) throws IOException;

    public final void zzfj(long j) throws IOException {
        zzfi(zzfq(j));
    }

    public abstract void zzfk(long j) throws IOException;

    public abstract void zzg(zzedo zzedo) throws IOException;

    public abstract void zzgg(int i) throws IOException;

    public abstract void zzgh(int i) throws IOException;

    public final void zzgi(int i) throws IOException {
        zzgh(zzgr(i));
    }

    public abstract void zzgj(int i) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzh(int i, boolean z) throws IOException;

    public abstract void zzhr(String str) throws IOException;

    public final void zzi(int i, long j) throws IOException {
        zzh(i, zzfq(j));
    }

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(int i, String str) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzk(byte[] bArr, int i, int i2) throws IOException;
}
