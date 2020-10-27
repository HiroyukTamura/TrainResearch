package com.google.android.gms.internal.gtm;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzun {
    private final byte[] buffer;
    private int zzawf;
    private int zzawg = 64;
    private int zzawh = 67108864;
    private int zzawl;
    private int zzawn;
    private int zzawo = Integer.MAX_VALUE;
    private final int zzbgu;
    private final int zzbgv;
    private int zzbgw;
    private int zzbgx;
    private zzqe zzbgy;

    private zzun(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzbgu = i;
        int i3 = i2 + i;
        this.zzbgw = i3;
        this.zzbgv = i3;
        this.zzbgx = i;
    }

    private final void zzas(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzbgx;
            int i3 = i2 + i;
            int i4 = this.zzawo;
            if (i3 > i4) {
                zzas(i4 - i2);
                throw zzuv.zzsa();
            } else if (i <= this.zzbgw - i2) {
                this.zzbgx = i2 + i;
            } else {
                throw zzuv.zzsa();
            }
        } else {
            throw zzuv.zzsb();
        }
    }

    public static zzun zzj(byte[] bArr, int i, int i2) {
        return new zzun(bArr, 0, i2);
    }

    public static zzun zzk(byte[] bArr) {
        return zzj(bArr, 0, bArr.length);
    }

    private final void zzoe() {
        int i = this.zzbgw + this.zzawl;
        this.zzbgw = i;
        int i2 = this.zzawo;
        if (i > i2) {
            int i3 = i - i2;
            this.zzawl = i3;
            this.zzbgw = i - i3;
            return;
        }
        this.zzawl = 0;
    }

    private final byte zzof() throws IOException {
        int i = this.zzbgx;
        if (i != this.zzbgw) {
            byte[] bArr = this.buffer;
            this.zzbgx = i + 1;
            return bArr[i];
        }
        throw zzuv.zzsa();
    }

    private final zzqe zzru() throws IOException {
        if (this.zzbgy == null) {
            this.zzbgy = zzqe.zzd(this.buffer, this.zzbgu, this.zzbgv);
        }
        int zznz = this.zzbgy.zznz();
        int i = this.zzbgx - this.zzbgu;
        if (zznz <= i) {
            this.zzbgy.zzas(i - zznz);
            this.zzbgy.zzap(this.zzawg - this.zzawf);
            return this.zzbgy;
        }
        throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", new Object[]{Integer.valueOf(zznz), Integer.valueOf(i)}));
    }

    public final int getPosition() {
        return this.zzbgx - this.zzbgu;
    }

    public final String readString() throws IOException {
        int zzoa = zzoa();
        if (zzoa < 0) {
            throw zzuv.zzsb();
        } else if (zzoa <= this.zzbgw - this.zzbgx) {
            String str = new String(this.buffer, this.zzbgx, zzoa, zzuu.UTF_8);
            this.zzbgx += zzoa;
            return str;
        } else {
            throw zzuv.zzsa();
        }
    }

    public final <T extends zzrc<T, ?>> T zza(zzsu<T> zzsu) throws IOException {
        try {
            T t = (zzrc) zzru().zza(zzsu, zzqp.zzor());
            zzao(this.zzawn);
            return t;
        } catch (zzrk e) {
            throw new zzuv("", e);
        }
    }

    public final void zza(zzuw zzuw) throws IOException {
        int zzoa = zzoa();
        if (this.zzawf < this.zzawg) {
            int zzaq = zzaq(zzoa);
            this.zzawf++;
            zzuw.zza(this);
            zzan(0);
            this.zzawf--;
            zzar(zzaq);
            return;
        }
        throw zzuv.zzsd();
    }

    public final void zza(zzuw zzuw, int i) throws IOException {
        int i2 = this.zzawf;
        if (i2 < this.zzawg) {
            this.zzawf = i2 + 1;
            zzuw.zza(this);
            zzan((i << 3) | 4);
            this.zzawf--;
            return;
        }
        throw zzuv.zzsd();
    }

    public final void zzan(int i) throws zzuv {
        if (this.zzawn != i) {
            throw new zzuv("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzao(int i) throws IOException {
        int zzni;
        int i2 = i & 7;
        if (i2 == 0) {
            zzoa();
            return true;
        } else if (i2 == 1) {
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
            return true;
        } else if (i2 == 2) {
            zzas(zzoa());
            return true;
        } else if (i2 == 3) {
            do {
                zzni = zzni();
                if (zzni == 0 || !zzao(zzni)) {
                    zzan(((i >>> 3) << 3) | 4);
                }
                zzni = zzni();
                break;
            } while (!zzao(zzni));
            zzan(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzoc();
                return true;
            }
            throw new zzuv("Protocol message tag had invalid wire type.");
        }
    }

    public final int zzaq(int i) throws zzuv {
        if (i >= 0) {
            int i2 = i + this.zzbgx;
            int i3 = this.zzawo;
            if (i2 <= i3) {
                this.zzawo = i2;
                zzoe();
                return i3;
            }
            throw zzuv.zzsa();
        }
        throw zzuv.zzsb();
    }

    public final void zzar(int i) {
        this.zzawo = i;
        zzoe();
    }

    public final void zzbz(int i) {
        zzu(i, this.zzawn);
    }

    public final int zzni() throws IOException {
        if (this.zzbgx == this.zzbgw) {
            this.zzawn = 0;
            return 0;
        }
        int zzoa = zzoa();
        this.zzawn = zzoa;
        if (zzoa != 0) {
            return zzoa;
        }
        throw new zzuv("Protocol message contained an invalid tag (zero).");
    }

    public final boolean zzno() throws IOException {
        return zzoa() != 0;
    }

    public final int zzoa() throws IOException {
        int i;
        byte zzof = zzof();
        if (zzof >= 0) {
            return zzof;
        }
        byte b = zzof & ByteCompanionObject.MAX_VALUE;
        byte zzof2 = zzof();
        if (zzof2 >= 0) {
            i = zzof2 << 7;
        } else {
            b |= (zzof2 & ByteCompanionObject.MAX_VALUE) << 7;
            byte zzof3 = zzof();
            if (zzof3 >= 0) {
                i = zzof3 << 14;
            } else {
                b |= (zzof3 & ByteCompanionObject.MAX_VALUE) << 14;
                byte zzof4 = zzof();
                if (zzof4 >= 0) {
                    i = zzof4 << 21;
                } else {
                    byte b2 = b | ((zzof4 & ByteCompanionObject.MAX_VALUE) << 21);
                    byte zzof5 = zzof();
                    byte b3 = b2 | (zzof5 << 28);
                    if (zzof5 >= 0) {
                        return b3;
                    }
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (zzof() >= 0) {
                            return b3;
                        }
                    }
                    throw zzuv.zzsc();
                }
            }
        }
        return b | i;
    }

    public final long zzob() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzof = zzof();
            j |= ((long) (zzof & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zzof & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzuv.zzsc();
    }

    public final int zzoc() throws IOException {
        return (zzof() & UByte.MAX_VALUE) | ((zzof() & UByte.MAX_VALUE) << 8) | ((zzof() & UByte.MAX_VALUE) << 16) | ((zzof() & UByte.MAX_VALUE) << 24);
    }

    public final int zzrv() {
        int i = this.zzawo;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzbgx;
    }

    public final byte[] zzt(int i, int i2) {
        if (i2 == 0) {
            return zzuz.zzbhw;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbgu + i, bArr, 0, i2);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public final void zzu(int i, int i2) {
        int i3 = this.zzbgx;
        int i4 = this.zzbgu;
        if (i > i3 - i4) {
            throw new IllegalArgumentException(C0681a.m311a(50, "Position ", i, " is beyond current ", this.zzbgx - this.zzbgu));
        } else if (i >= 0) {
            this.zzbgx = i4 + i;
            this.zzawn = i2;
        } else {
            throw new IllegalArgumentException(C0681a.m309a(24, "Bad position ", i));
        }
    }
}
