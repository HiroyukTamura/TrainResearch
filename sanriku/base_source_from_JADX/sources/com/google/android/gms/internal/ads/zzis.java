package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

final class zzis {
    private final int zzagt;
    private float zzahf = 1.0f;
    private float zzahg = 1.0f;
    private final int zzamb;
    private final int zzamc;
    private final int zzamd;
    private final int zzame;
    private final short[] zzamf;
    private int zzamg;
    private short[] zzamh;
    private int zzami;
    private short[] zzamj;
    private int zzamk;
    private short[] zzaml;
    private int zzamm = 0;
    private int zzamn = 0;
    private int zzamo;
    private int zzamp;
    private int zzamq;
    private int zzamr;
    private int zzams = 0;
    private int zzamt;
    private int zzamu;
    private int zzamv;

    public zzis(int i, int i2) {
        this.zzagt = i;
        this.zzamb = i2;
        this.zzamc = i / 400;
        int i3 = i / 65;
        this.zzamd = i3;
        int i4 = i3 * 2;
        this.zzame = i4;
        this.zzamf = new short[i4];
        this.zzamg = i4;
        this.zzamh = new short[(i4 * i2)];
        this.zzami = i4;
        this.zzamj = new short[(i4 * i2)];
        this.zzamk = i4;
        this.zzaml = new short[(i4 * i2)];
    }

    private final int zza(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.zzamb;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i7 < i5 * i2) {
                i7 = i2;
                i5 = i9;
            }
            if (i9 * i6 > i8 * i2) {
                i6 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.zzamu = i5 / i7;
        this.zzamv = i8 / i6;
        return i7;
    }

    private static void zza(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr3[i8] * i10) + ((i - i10) * sArr2[i9])) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }

    private final void zza(short[] sArr, int i, int i2) {
        zzw(i2);
        int i3 = this.zzamb;
        System.arraycopy(sArr, i * i3, this.zzamj, this.zzamp * i3, i3 * i2);
        this.zzamp += i2;
    }

    private final void zzb(short[] sArr, int i, int i2) {
        int i3 = this.zzame / i2;
        int i4 = this.zzamb;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.zzamf[i7] = (short) (i8 / i5);
        }
    }

    private final void zzgf() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.zzamp;
        float f = this.zzahf / this.zzahg;
        double d = (double) f;
        int i8 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i9 = this.zzamo;
            if (i9 >= this.zzame) {
                int i10 = 0;
                while (true) {
                    int i11 = this.zzamr;
                    if (i11 > 0) {
                        int min = Math.min(this.zzame, i11);
                        zza(this.zzamh, i10, min);
                        this.zzamr -= min;
                        i10 += min;
                    } else {
                        short[] sArr = this.zzamh;
                        int i12 = this.zzagt;
                        int i13 = i12 > 4000 ? i12 / 4000 : 1;
                        if (this.zzamb == i8 && i13 == i8) {
                            i4 = zza(sArr, i10, this.zzamc, this.zzamd);
                        } else {
                            zzb(sArr, i10, i13);
                            int zza = zza(this.zzamf, 0, this.zzamc / i13, this.zzamd / i13);
                            if (i13 != i8) {
                                int i14 = zza * i13;
                                int i15 = i13 << 2;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.zzamc;
                                if (i16 < i18) {
                                    i16 = i18;
                                }
                                int i19 = this.zzamd;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.zzamb == i8) {
                                    i4 = zza(sArr, i10, i16, i17);
                                } else {
                                    zzb(sArr, i10, i8);
                                    i4 = zza(this.zzamf, 0, i16, i17);
                                }
                            } else {
                                i4 = zza;
                            }
                        }
                        int i20 = this.zzamu;
                        int i21 = i20 != 0 && this.zzams != 0 && this.zzamv <= i20 * 3 && (i20 << 1) > this.zzamt * 3 ? this.zzams : i4;
                        this.zzamt = this.zzamu;
                        this.zzams = i4;
                        if (d > 1.0d) {
                            short[] sArr2 = this.zzamh;
                            if (f >= 2.0f) {
                                i6 = (int) (((float) i21) / (f - 1.0f));
                            } else {
                                this.zzamr = (int) (((2.0f - f) * ((float) i21)) / (f - 1.0f));
                                i6 = i21;
                            }
                            zzw(i6);
                            int i22 = i6;
                            zza(i6, this.zzamb, this.zzamj, this.zzamp, sArr2, i10, sArr2, i10 + i21);
                            this.zzamp += i22;
                            i10 = i21 + i22 + i10;
                        } else {
                            int i23 = i21;
                            short[] sArr3 = this.zzamh;
                            if (f < 0.5f) {
                                i5 = (int) ((((float) i23) * f) / (1.0f - f));
                            } else {
                                this.zzamr = (int) ((((2.0f * f) - 1.0f) * ((float) i23)) / (1.0f - f));
                                i5 = i23;
                            }
                            int i24 = i23 + i5;
                            zzw(i24);
                            int i25 = this.zzamb;
                            System.arraycopy(sArr3, i10 * i25, this.zzamj, this.zzamp * i25, i25 * i23);
                            zza(i5, this.zzamb, this.zzamj, this.zzamp + i23, sArr3, i23 + i10, sArr3, i10);
                            this.zzamp += i24;
                            i10 += i5;
                        }
                    }
                    if (this.zzame + i10 > i9) {
                        break;
                    }
                    i8 = 1;
                }
                int i26 = this.zzamo - i10;
                short[] sArr4 = this.zzamh;
                int i27 = this.zzamb;
                System.arraycopy(sArr4, i10 * i27, sArr4, 0, i27 * i26);
                this.zzamo = i26;
            }
        } else {
            zza(this.zzamh, 0, this.zzamo);
            this.zzamo = 0;
        }
        float f2 = this.zzahg;
        if (f2 != 1.0f && this.zzamp != i7) {
            int i28 = this.zzagt;
            int i29 = (int) (((float) i28) / f2);
            while (true) {
                if (i29 <= 16384 && i28 <= 16384) {
                    break;
                }
                i29 /= 2;
                i28 /= 2;
            }
            int i30 = this.zzamp - i7;
            int i31 = this.zzamq + i30;
            int i32 = this.zzamk;
            if (i31 > i32) {
                int i33 = (i32 / 2) + i30 + i32;
                this.zzamk = i33;
                this.zzaml = Arrays.copyOf(this.zzaml, i33 * this.zzamb);
            }
            short[] sArr5 = this.zzamj;
            int i34 = this.zzamb;
            System.arraycopy(sArr5, i7 * i34, this.zzaml, this.zzamq * i34, i34 * i30);
            this.zzamp = i7;
            this.zzamq += i30;
            int i35 = 0;
            while (true) {
                i = this.zzamq;
                if (i35 >= i - 1) {
                    break;
                }
                while (true) {
                    i2 = this.zzamm;
                    int i36 = (i2 + 1) * i29;
                    i3 = this.zzamn;
                    if (i36 <= i3 * i28) {
                        break;
                    }
                    zzw(1);
                    int i37 = 0;
                    while (true) {
                        int i38 = this.zzamb;
                        if (i37 >= i38) {
                            break;
                        }
                        short[] sArr6 = this.zzaml;
                        int i39 = (i35 * i38) + i37;
                        short s = sArr6[i39];
                        short s2 = sArr6[i39 + i38];
                        int i40 = this.zzamm;
                        int i41 = i40 * i29;
                        int i42 = (i40 + 1) * i29;
                        int i43 = i42 - (this.zzamn * i28);
                        int i44 = i42 - i41;
                        this.zzamj[(this.zzamp * i38) + i37] = (short) ((((i44 - i43) * s2) + (s * i43)) / i44);
                        i37++;
                    }
                    this.zzamn++;
                    this.zzamp++;
                }
                int i45 = i2 + 1;
                this.zzamm = i45;
                if (i45 == i28) {
                    this.zzamm = 0;
                    zzoh.checkState(i3 == i29);
                    this.zzamn = 0;
                }
                i35++;
            }
            int i46 = i - 1;
            if (i46 != 0) {
                short[] sArr7 = this.zzaml;
                int i47 = this.zzamb;
                System.arraycopy(sArr7, i46 * i47, sArr7, 0, (i - i46) * i47);
                this.zzamq -= i46;
            }
        }
    }

    private final void zzw(int i) {
        int i2 = this.zzamp + i;
        int i3 = this.zzami;
        if (i2 > i3) {
            int i4 = (i3 / 2) + i + i3;
            this.zzami = i4;
            this.zzamj = Arrays.copyOf(this.zzamj, i4 * this.zzamb);
        }
    }

    private final void zzx(int i) {
        int i2 = this.zzamo + i;
        int i3 = this.zzamg;
        if (i2 > i3) {
            int i4 = (i3 / 2) + i + i3;
            this.zzamg = i4;
            this.zzamh = Arrays.copyOf(this.zzamh, i4 * this.zzamb);
        }
    }

    public final void setSpeed(float f) {
        this.zzahf = f;
    }

    public final void zza(float f) {
        this.zzahg = f;
    }

    public final void zza(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzamb;
        int i2 = remaining / i;
        zzx(i2);
        shortBuffer.get(this.zzamh, this.zzamo * this.zzamb, ((i * i2) << 1) / 2);
        this.zzamo += i2;
        zzgf();
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzamb, this.zzamp);
        shortBuffer.put(this.zzamj, 0, this.zzamb * min);
        int i = this.zzamp - min;
        this.zzamp = i;
        short[] sArr = this.zzamj;
        int i2 = this.zzamb;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    public final void zzfk() {
        int i;
        int i2 = this.zzamo;
        float f = this.zzahf;
        float f2 = this.zzahg;
        int i3 = this.zzamp + ((int) ((((((float) i2) / (f / f2)) + ((float) this.zzamq)) / f2) + 0.5f));
        zzx((this.zzame * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.zzame;
            int i5 = this.zzamb;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.zzamh[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.zzamo = (i * 2) + this.zzamo;
        zzgf();
        if (this.zzamp > i3) {
            this.zzamp = i3;
        }
        this.zzamo = 0;
        this.zzamr = 0;
        this.zzamq = 0;
    }

    public final int zzge() {
        return this.zzamp;
    }
}
