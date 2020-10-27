package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

final class zzeed extends zzeaq {
    static final int[] zziba = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzibb;
    /* access modifiers changed from: private */
    public final zzeaq zzibc;
    /* access modifiers changed from: private */
    public final zzeaq zzibd;
    private final int zzibe;
    private final int zzibf;

    private zzeed(zzeaq zzeaq, zzeaq zzeaq2) {
        this.zzibc = zzeaq;
        this.zzibd = zzeaq2;
        int size = zzeaq.size();
        this.zzibe = size;
        this.zzibb = zzeaq2.size() + size;
        this.zzibf = Math.max(zzeaq.zzbcs(), zzeaq2.zzbcs()) + 1;
    }

    /* synthetic */ zzeed(zzeaq zzeaq, zzeaq zzeaq2, zzeeg zzeeg) {
        this(zzeaq, zzeaq2);
    }

    static zzeaq zza(zzeaq zzeaq, zzeaq zzeaq2) {
        if (zzeaq2.size() == 0) {
            return zzeaq;
        }
        if (zzeaq.size() == 0) {
            return zzeaq2;
        }
        int size = zzeaq2.size() + zzeaq.size();
        if (size < 128) {
            return zzb(zzeaq, zzeaq2);
        }
        if (zzeaq instanceof zzeed) {
            zzeed zzeed = (zzeed) zzeaq;
            if (zzeaq2.size() + zzeed.zzibd.size() < 128) {
                return new zzeed(zzeed.zzibc, zzb(zzeed.zzibd, zzeaq2));
            } else if (zzeed.zzibc.zzbcs() > zzeed.zzibd.zzbcs() && zzeed.zzbcs() > zzeaq2.zzbcs()) {
                return new zzeed(zzeed.zzibc, new zzeed(zzeed.zzibd, zzeaq2));
            }
        }
        return size >= zzhg(Math.max(zzeaq.zzbcs(), zzeaq2.zzbcs()) + 1) ? new zzeed(zzeaq, zzeaq2) : new zzeef((zzeeg) null).zzc(zzeaq, zzeaq2);
    }

    private static zzeaq zzb(zzeaq zzeaq, zzeaq zzeaq2) {
        int size = zzeaq.size();
        int size2 = zzeaq2.size();
        byte[] bArr = new byte[(size + size2)];
        zzeaq.zza(bArr, 0, 0, size);
        zzeaq2.zza(bArr, 0, size, size2);
        return zzeaq.zzv(bArr);
    }

    static int zzhg(int i) {
        int[] iArr = zziba;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeaq)) {
            return false;
        }
        zzeaq zzeaq = (zzeaq) obj;
        if (this.zzibb != zzeaq.size()) {
            return false;
        }
        if (this.zzibb == 0) {
            return true;
        }
        int zzbcu = zzbcu();
        int zzbcu2 = zzeaq.zzbcu();
        if (zzbcu != 0 && zzbcu2 != 0 && zzbcu != zzbcu2) {
            return false;
        }
        zzeei zzeei = new zzeei(this, (zzeeg) null);
        zzebb zzebb = (zzebb) zzeei.next();
        zzeei zzeei2 = new zzeei(zzeaq, (zzeeg) null);
        zzebb zzebb2 = (zzebb) zzeei2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = zzebb.size() - i;
            int size2 = zzebb2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? zzebb.zza(zzebb2, i2, min) : zzebb2.zza(zzebb, i, min))) {
                return false;
            }
            i3 += min;
            int i4 = this.zzibb;
            if (i3 < i4) {
                if (min == size) {
                    zzebb = (zzebb) zzeei.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    zzebb2 = (zzebb) zzeei2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final int size() {
        return this.zzibb;
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(toByteArray(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzear zzear) throws IOException {
        this.zzibc.zza(zzear);
        this.zzibd.zza(zzear);
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzibe;
        if (i4 <= i5) {
            this.zzibc.zzb(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.zzibd.zzb(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.zzibc.zzb(bArr, i, i2, i6);
            this.zzibd.zzb(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    /* renamed from: zzbcn */
    public final zzeaz iterator() {
        return new zzeeg(this);
    }

    public final boolean zzbcp() {
        int zzg = this.zzibc.zzg(0, 0, this.zzibe);
        zzeaq zzeaq = this.zzibd;
        return zzeaq.zzg(zzg, 0, zzeaq.size()) == 0;
    }

    public final zzebf zzbcq() {
        return new zzebg(new zzeeh(this));
    }

    /* access modifiers changed from: protected */
    public final int zzbcs() {
        return this.zzibf;
    }

    /* access modifiers changed from: protected */
    public final boolean zzbct() {
        return this.zzibb >= zzhg(this.zzibf);
    }

    public final byte zzfo(int i) {
        zzeaq.zzaa(i, this.zzibb);
        return zzfp(i);
    }

    /* access modifiers changed from: package-private */
    public final byte zzfp(int i) {
        int i2 = this.zzibe;
        return i < i2 ? this.zzibc.zzfp(i) : this.zzibd.zzfp(i - i2);
    }

    /* access modifiers changed from: protected */
    public final int zzg(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzibe;
        if (i4 <= i5) {
            return this.zzibc.zzg(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzibd.zzg(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzibd.zzg(this.zzibc.zzg(i, i2, i6), 0, i3 - i6);
    }

    /* access modifiers changed from: protected */
    public final int zzh(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzibe;
        if (i4 <= i5) {
            return this.zzibc.zzh(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzibd.zzh(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzibd.zzh(this.zzibc.zzh(i, i2, i6), 0, i3 - i6);
    }

    public final zzeaq zzz(int i, int i2) {
        int zzi = zzeaq.zzi(i, i2, this.zzibb);
        if (zzi == 0) {
            return zzeaq.zzhtf;
        }
        if (zzi == this.zzibb) {
            return this;
        }
        int i3 = this.zzibe;
        if (i2 <= i3) {
            return this.zzibc.zzz(i, i2);
        }
        if (i >= i3) {
            return this.zzibd.zzz(i - i3, i2 - i3);
        }
        zzeaq zzeaq = this.zzibc;
        return new zzeed(zzeaq.zzz(i, zzeaq.size()), this.zzibd.zzz(0, i2 - this.zzibe));
    }
}
