package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;
import kotlin.UByte;
import p009e.p010a.p011a.p012a.C0681a;

final class zzjv implements zzka {
    private final byte[] zzaod = new byte[8];
    private final Stack<zzjx> zzaoe = new Stack<>();
    private final zzkf zzaof = new zzkf();
    private zzjz zzaog;
    private int zzaoh;
    private int zzaoi;
    private long zzaoj;

    zzjv() {
    }

    private final long zza(zzjl zzjl, int i) throws IOException, InterruptedException {
        zzjl.readFully(this.zzaod, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.zzaod[i2] & UByte.MAX_VALUE));
        }
        return j;
    }

    public final void reset() {
        this.zzaoh = 0;
        this.zzaoe.clear();
        this.zzaof.reset();
    }

    public final void zza(zzjz zzjz) {
        this.zzaog = zzjz;
    }

    public final boolean zzb(zzjl zzjl) throws IOException, InterruptedException {
        String str;
        int zzam;
        int zza;
        zzoh.checkState(this.zzaog != null);
        while (true) {
            if (this.zzaoe.isEmpty() || zzjl.getPosition() < this.zzaoe.peek().zzaom) {
                if (this.zzaoh == 0) {
                    long zza2 = this.zzaof.zza(zzjl, true, false, 4);
                    if (zza2 == -2) {
                        zzjl.zzgp();
                        while (true) {
                            zzjl.zza(this.zzaod, 0, 4);
                            zzam = zzkf.zzam(this.zzaod[0]);
                            if (zzam != -1 && zzam <= 4) {
                                zza = (int) zzkf.zza(this.zzaod, zzam, false);
                                if (this.zzaog.zzak(zza)) {
                                    break;
                                }
                            }
                            zzjl.zzae(1);
                        }
                        zzjl.zzae(zzam);
                        zza2 = (long) zza;
                    }
                    if (zza2 == -1) {
                        return false;
                    }
                    this.zzaoi = (int) zza2;
                    this.zzaoh = 1;
                }
                if (this.zzaoh == 1) {
                    this.zzaoj = this.zzaof.zza(zzjl, false, true, 8);
                    this.zzaoh = 2;
                }
                int zzaj = this.zzaog.zzaj(this.zzaoi);
                if (zzaj == 0) {
                    zzjl.zzae((int) this.zzaoj);
                    this.zzaoh = 0;
                } else if (zzaj == 1) {
                    long position = zzjl.getPosition();
                    this.zzaoe.add(new zzjx(this.zzaoi, this.zzaoj + position));
                    this.zzaog.zzd(this.zzaoi, position, this.zzaoj);
                    this.zzaoh = 0;
                    return true;
                } else if (zzaj == 2) {
                    long j = this.zzaoj;
                    if (j <= 8) {
                        this.zzaog.zzc(this.zzaoi, zza(zzjl, (int) j));
                        this.zzaoh = 0;
                        return true;
                    }
                    long j2 = this.zzaoj;
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j2);
                    throw new zzhi(sb.toString());
                } else if (zzaj == 3) {
                    long j3 = this.zzaoj;
                    if (j3 <= 2147483647L) {
                        zzjz zzjz = this.zzaog;
                        int i = this.zzaoi;
                        int i2 = (int) j3;
                        if (i2 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i2];
                            zzjl.readFully(bArr, 0, i2);
                            str = new String(bArr);
                        }
                        zzjz.zza(i, str);
                        this.zzaoh = 0;
                        return true;
                    }
                    long j4 = this.zzaoj;
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j4);
                    throw new zzhi(sb2.toString());
                } else if (zzaj == 4) {
                    this.zzaog.zza(this.zzaoi, (int) this.zzaoj, zzjl);
                    this.zzaoh = 0;
                    return true;
                } else if (zzaj == 5) {
                    long j5 = this.zzaoj;
                    if (j5 == 4 || j5 == 8) {
                        zzjz zzjz2 = this.zzaog;
                        int i3 = this.zzaoi;
                        int i4 = (int) this.zzaoj;
                        long zza3 = zza(zzjl, i4);
                        zzjz2.zza(i3, i4 == 4 ? (double) Float.intBitsToFloat((int) zza3) : Double.longBitsToDouble(zza3));
                        this.zzaoh = 0;
                        return true;
                    }
                    long j6 = this.zzaoj;
                    StringBuilder sb3 = new StringBuilder(40);
                    sb3.append("Invalid float size: ");
                    sb3.append(j6);
                    throw new zzhi(sb3.toString());
                } else {
                    throw new zzhi(C0681a.m309a(32, "Invalid element type ", zzaj));
                }
            } else {
                this.zzaog.zzal(this.zzaoe.pop().zzaoi);
                return true;
            }
        }
    }
}
