package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import p009e.p010a.p011a.p012a.C0681a;

final class zzebg extends zzebf {
    private final byte[] buffer;
    private int pos;
    private int zzajl;
    private final InputStream zzhtx;
    private int zzhty;
    private int zzhtz;
    private int zzhua;
    private int zzhub;
    private zzebj zzhuc;

    private zzebg(InputStream inputStream, int i) {
        super();
        this.zzhub = Integer.MAX_VALUE;
        this.zzhuc = null;
        zzecg.zza(inputStream, "input");
        this.zzhtx = inputStream;
        this.buffer = new byte[i];
        this.zzajl = 0;
        this.pos = 0;
        this.zzhua = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzbdq() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.zzajl
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.pos = r1
            return r0
        L_0x006b:
            long r0 = r5.zzbdn()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebg.zzbdq():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzbdr() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.zzajl
            if (r1 == r0) goto L_0x00b8
            byte[] r2 = r11.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.pos = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b8
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0025
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0022:
            long r2 = (long) r0
            goto L_0x00b5
        L_0x0025:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0036
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r2 = r9
            goto L_0x00b5
        L_0x0036:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0044
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0022
        L_0x0044:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005b
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0057:
            long r1 = r1 ^ r3
            r2 = r1
            r1 = r0
            goto L_0x00b5
        L_0x005b:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006d:
            long r3 = r3 ^ r5
        L_0x006e:
            r2 = r3
            goto L_0x00b5
        L_0x0070:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0083
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0057
        L_0x0083:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0096
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006d
        L_0x0096:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b3
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b8
            goto L_0x006e
        L_0x00b3:
            r1 = r0
            goto L_0x006e
        L_0x00b5:
            r11.pos = r1
            return r2
        L_0x00b8:
            long r0 = r11.zzbdn()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebg.zzbdr():long");
    }

    private final int zzbds() throws IOException {
        int i = this.pos;
        if (this.zzajl - i < 4) {
            zzfx(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    private final long zzbdt() throws IOException {
        int i = this.pos;
        if (this.zzajl - i < 8) {
            zzfx(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zzbdu() {
        int i = this.zzajl + this.zzhty;
        this.zzajl = i;
        int i2 = this.zzhua + i;
        int i3 = this.zzhub;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzhty = i4;
            this.zzajl = i - i4;
            return;
        }
        this.zzhty = 0;
    }

    private final byte zzbdv() throws IOException {
        if (this.pos == this.zzajl) {
            zzfx(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzfx(int i) throws IOException {
        if (zzfy(i)) {
            return;
        }
        if (i > (this.zzhtu - this.zzhua) - this.pos) {
            throw zzeco.zzbfm();
        }
        throw zzeco.zzbfg();
    }

    private final boolean zzfy(int i) throws IOException {
        do {
            int i2 = this.pos;
            int i3 = i2 + i;
            int i4 = this.zzajl;
            if (i3 > i4) {
                int i5 = this.zzhtu;
                int i6 = this.zzhua;
                if (i > (i5 - i6) - i2 || i6 + i2 + i > this.zzhub) {
                    return false;
                }
                if (i2 > 0) {
                    if (i4 > i2) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                    }
                    this.zzhua += i2;
                    this.zzajl -= i2;
                    this.pos = 0;
                }
                InputStream inputStream = this.zzhtx;
                byte[] bArr2 = this.buffer;
                int i7 = this.zzajl;
                int read = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.zzhtu - this.zzhua) - i7));
                if (read == 0 || read < -1 || read > this.buffer.length) {
                    String valueOf = String.valueOf(this.zzhtx.getClass());
                    StringBuilder sb = new StringBuilder(valueOf.length() + 91);
                    sb.append(valueOf);
                    sb.append("#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zzajl += read;
                    zzbdu();
                }
            } else {
                throw new IllegalStateException(C0681a.m310a(77, "refillBuffer() called when ", i, " bytes were already available in buffer"));
            }
        } while (this.zzajl < i);
        return true;
    }

    private final byte[] zzfz(int i) throws IOException {
        if (i == 0) {
            return zzecg.zzhtn;
        }
        if (i >= 0) {
            int i2 = this.zzhua;
            int i3 = this.pos;
            int i4 = i2 + i3 + i;
            if (i4 - this.zzhtu <= 0) {
                int i5 = this.zzhub;
                if (i4 <= i5) {
                    int i6 = this.zzajl - i3;
                    int i7 = i - i6;
                    if (i7 >= 4096 && i7 > this.zzhtx.available()) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.buffer, this.pos, bArr, 0, i6);
                    this.zzhua += this.zzajl;
                    this.pos = 0;
                    this.zzajl = 0;
                    while (i6 < i) {
                        int read = this.zzhtx.read(bArr, i6, i - i6);
                        if (read != -1) {
                            this.zzhua += read;
                            i6 += read;
                        } else {
                            throw zzeco.zzbfg();
                        }
                    }
                    return bArr;
                }
                zzgb((i5 - i2) - i3);
                throw zzeco.zzbfg();
            }
            throw zzeco.zzbfm();
        }
        throw zzeco.zzbfh();
    }

    private final byte[] zzg(int i, boolean z) throws IOException {
        byte[] zzfz = zzfz(i);
        if (zzfz != null) {
            return zzfz;
        }
        int i2 = this.pos;
        int i3 = this.zzajl;
        int i4 = i3 - i2;
        this.zzhua += i3;
        this.pos = 0;
        this.zzajl = 0;
        List<byte[]> zzga = zzga(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i4);
        for (byte[] next : zzga) {
            System.arraycopy(next, 0, bArr, i4, next.length);
            i4 += next.length;
        }
        return bArr;
    }

    private final List<byte[]> zzga(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zzhtx.read(bArr, i2, min - i2);
                if (read != -1) {
                    this.zzhua += read;
                    i2 += read;
                } else {
                    throw zzeco.zzbfg();
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzgb(int i) throws IOException {
        int i2 = this.zzajl;
        int i3 = this.pos;
        if (i <= i2 - i3 && i >= 0) {
            this.pos = i3 + i;
        } else if (i >= 0) {
            int i4 = this.zzhua;
            int i5 = this.pos;
            int i6 = i4 + i5 + i;
            int i7 = this.zzhub;
            if (i6 <= i7) {
                this.zzhua = i4 + i5;
                int i8 = this.zzajl - i5;
                this.zzajl = 0;
                this.pos = 0;
                while (i8 < i) {
                    try {
                        long j = (long) (i - i8);
                        long skip = this.zzhtx.skip(j);
                        if (skip >= 0 && skip <= j) {
                            if (skip == 0) {
                                break;
                            }
                            i8 += (int) skip;
                        } else {
                            String valueOf = String.valueOf(this.zzhtx.getClass());
                            StringBuilder sb = new StringBuilder(valueOf.length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        }
                    } catch (Throwable th) {
                        this.zzhua += i8;
                        zzbdu();
                        throw th;
                    }
                }
                this.zzhua += i8;
                zzbdu();
                if (i8 < i) {
                    int i9 = this.zzajl;
                    int i10 = i9 - this.pos;
                    this.pos = i9;
                    while (true) {
                        zzfx(1);
                        int i11 = i - i10;
                        int i12 = this.zzajl;
                        if (i11 > i12) {
                            i10 += i12;
                            this.pos = i12;
                        } else {
                            this.pos = i11;
                            return;
                        }
                    }
                }
            } else {
                zzgb((i7 - i4) - i5);
                throw zzeco.zzbfg();
            }
        } else {
            throw zzeco.zzbfh();
        }
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzbdt());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzbds());
    }

    public final String readString() throws IOException {
        int zzbdq = zzbdq();
        if (zzbdq > 0 && zzbdq <= this.zzajl - this.pos) {
            String str = new String(this.buffer, this.pos, zzbdq, zzecg.UTF_8);
            this.pos += zzbdq;
            return str;
        } else if (zzbdq == 0) {
            return "";
        } else {
            if (zzbdq > this.zzajl) {
                return new String(zzg(zzbdq, false), zzecg.UTF_8);
            }
            zzfx(zzbdq);
            String str2 = new String(this.buffer, this.pos, zzbdq, zzecg.UTF_8);
            this.pos += zzbdq;
            return str2;
        }
    }

    public final int zzbcy() throws IOException {
        if (zzbdo()) {
            this.zzhtz = 0;
            return 0;
        }
        int zzbdq = zzbdq();
        this.zzhtz = zzbdq;
        if ((zzbdq >>> 3) != 0) {
            return zzbdq;
        }
        throw zzeco.zzbfj();
    }

    public final long zzbcz() throws IOException {
        return zzbdr();
    }

    public final long zzbda() throws IOException {
        return zzbdr();
    }

    public final int zzbdb() throws IOException {
        return zzbdq();
    }

    public final long zzbdc() throws IOException {
        return zzbdt();
    }

    public final int zzbdd() throws IOException {
        return zzbds();
    }

    public final boolean zzbde() throws IOException {
        return zzbdr() != 0;
    }

    public final String zzbdf() throws IOException {
        byte[] bArr;
        int zzbdq = zzbdq();
        int i = this.pos;
        if (zzbdq <= this.zzajl - i && zzbdq > 0) {
            bArr = this.buffer;
            this.pos = i + zzbdq;
        } else if (zzbdq == 0) {
            return "";
        } else {
            if (zzbdq <= this.zzajl) {
                zzfx(zzbdq);
                bArr = this.buffer;
                this.pos = zzbdq;
            } else {
                bArr = zzg(zzbdq, false);
            }
            i = 0;
        }
        return zzefk.zzo(bArr, i, zzbdq);
    }

    public final zzeaq zzbdg() throws IOException {
        int zzbdq = zzbdq();
        int i = this.zzajl;
        int i2 = this.pos;
        if (zzbdq <= i - i2 && zzbdq > 0) {
            zzeaq zzh = zzeaq.zzh(this.buffer, i2, zzbdq);
            this.pos += zzbdq;
            return zzh;
        } else if (zzbdq == 0) {
            return zzeaq.zzhtf;
        } else {
            byte[] zzfz = zzfz(zzbdq);
            if (zzfz != null) {
                return zzeaq.zzu(zzfz);
            }
            int i3 = this.pos;
            int i4 = this.zzajl;
            int i5 = i4 - i3;
            this.zzhua += i4;
            this.pos = 0;
            this.zzajl = 0;
            List<byte[]> zzga = zzga(zzbdq - i5);
            byte[] bArr = new byte[zzbdq];
            System.arraycopy(this.buffer, i3, bArr, 0, i5);
            for (byte[] next : zzga) {
                System.arraycopy(next, 0, bArr, i5, next.length);
                i5 += next.length;
            }
            return zzeaq.zzv(bArr);
        }
    }

    public final int zzbdh() throws IOException {
        return zzbdq();
    }

    public final int zzbdi() throws IOException {
        return zzbdq();
    }

    public final int zzbdj() throws IOException {
        return zzbds();
    }

    public final long zzbdk() throws IOException {
        return zzbdt();
    }

    public final int zzbdl() throws IOException {
        return zzebf.zzfw(zzbdq());
    }

    public final long zzbdm() throws IOException {
        return zzebf.zzfh(zzbdr());
    }

    /* access modifiers changed from: package-private */
    public final long zzbdn() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzbdv = zzbdv();
            j |= ((long) (zzbdv & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zzbdv & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzeco.zzbfi();
    }

    public final boolean zzbdo() throws IOException {
        return this.pos == this.zzajl && !zzfy(1);
    }

    public final int zzbdp() {
        return this.zzhua + this.pos;
    }

    public final void zzfs(int i) throws zzeco {
        if (this.zzhtz != i) {
            throw zzeco.zzbfk();
        }
    }

    public final boolean zzft(int i) throws IOException {
        int zzbcy;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzajl - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzeco.zzbfi();
            }
            while (i3 < 10) {
                if (zzbdv() < 0) {
                    i3++;
                }
            }
            throw zzeco.zzbfi();
            return true;
        } else if (i2 == 1) {
            zzgb(8);
            return true;
        } else if (i2 == 2) {
            zzgb(zzbdq());
            return true;
        } else if (i2 == 3) {
            do {
                zzbcy = zzbcy();
                if (zzbcy == 0 || !zzft(zzbcy)) {
                    zzfs(((i >>> 3) << 3) | 4);
                }
                zzbcy = zzbcy();
                break;
            } while (!zzft(zzbcy));
            zzfs(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzgb(4);
                return true;
            }
            throw zzeco.zzbfl();
        }
    }

    public final int zzfu(int i) throws zzeco {
        if (i >= 0) {
            int i2 = this.zzhua + this.pos + i;
            int i3 = this.zzhub;
            if (i2 <= i3) {
                this.zzhub = i2;
                zzbdu();
                return i3;
            }
            throw zzeco.zzbfg();
        }
        throw zzeco.zzbfh();
    }

    public final void zzfv(int i) {
        this.zzhub = i;
        zzbdu();
    }
}
