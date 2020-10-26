// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public final class adl implements Cloneable
{
    private static final adm zzcsq;
    private int mSize;
    private boolean zzcsr;
    private int[] zzcss;
    private adm[] zzcst;
    
    static {
        zzcsq = new adm();
    }
    
    adl() {
        this(10);
    }
    
    private adl(int idealIntArraySize) {
        this.zzcsr = false;
        idealIntArraySize = idealIntArraySize(idealIntArraySize);
        this.zzcss = new int[idealIntArraySize];
        this.zzcst = new adm[idealIntArraySize];
        this.mSize = 0;
    }
    
    private static int idealIntArraySize(int n) {
        final int n2 = n << 2;
        n = 4;
        int n3;
        while (true) {
            n3 = n2;
            if (n >= 32) {
                break;
            }
            if (n2 <= (1 << n) - 12) {
                n3 = (1 << n) - 12;
                break;
            }
            ++n;
        }
        return n3 / 4;
    }
    
    private final int zzcz(final int n) {
        final int mSize = this.mSize;
        int i = 0;
        int n2 = mSize - 1;
        while (i <= n2) {
            final int n3 = i + n2 >>> 1;
            final int n4 = this.zzcss[n3];
            if (n4 < n) {
                i = n3 + 1;
            }
            else {
                final int n5 = n3;
                if (n4 <= n) {
                    return n5;
                }
                n2 = n3 - 1;
            }
        }
        return ~i;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof adl)) {
                return false;
            }
            final adl adl = (adl)o;
            if (this.mSize != adl.mSize) {
                return false;
            }
            final int[] zzcss = this.zzcss;
            final int[] zzcss2 = adl.zzcss;
            while (true) {
                for (int mSize = this.mSize, i = 0; i < mSize; ++i) {
                    if (zzcss[i] != zzcss2[i]) {
                        final int n = 0;
                        if (n != 0) {
                            final adm[] zzcst = this.zzcst;
                            final adm[] zzcst2 = adl.zzcst;
                            final int mSize2 = this.mSize;
                            int j = 0;
                            while (true) {
                                while (j < mSize2) {
                                    if (!zzcst[j].equals(zzcst2[j])) {
                                        final int n2 = 0;
                                        if (n2 == 0) {
                                            return false;
                                        }
                                        return true;
                                    }
                                    else {
                                        ++j;
                                    }
                                }
                                final int n2 = 1;
                                continue;
                            }
                        }
                        return false;
                    }
                }
                final int n = 1;
                continue;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        int n = 17;
        for (int i = 0; i < this.mSize; ++i) {
            n = (n * 31 + this.zzcss[i]) * 31 + this.zzcst[i].hashCode();
        }
        return n;
    }
    
    public final boolean isEmpty() {
        return this.mSize == 0;
    }
    
    final int size() {
        return this.mSize;
    }
    
    final void zza(final int n, final adm adm) {
        final int zzcz = this.zzcz(n);
        if (zzcz >= 0) {
            this.zzcst[zzcz] = adm;
            return;
        }
        final int n2 = ~zzcz;
        if (n2 < this.mSize && this.zzcst[n2] == adl.zzcsq) {
            this.zzcss[n2] = n;
            this.zzcst[n2] = adm;
            return;
        }
        if (this.mSize >= this.zzcss.length) {
            final int idealIntArraySize = idealIntArraySize(this.mSize + 1);
            final int[] zzcss = new int[idealIntArraySize];
            final adm[] zzcst = new adm[idealIntArraySize];
            System.arraycopy(this.zzcss, 0, zzcss, 0, this.zzcss.length);
            System.arraycopy(this.zzcst, 0, zzcst, 0, this.zzcst.length);
            this.zzcss = zzcss;
            this.zzcst = zzcst;
        }
        if (this.mSize - n2 != 0) {
            System.arraycopy(this.zzcss, n2, this.zzcss, n2 + 1, this.mSize - n2);
            System.arraycopy(this.zzcst, n2, this.zzcst, n2 + 1, this.mSize - n2);
        }
        this.zzcss[n2] = n;
        this.zzcst[n2] = adm;
        ++this.mSize;
    }
    
    final adm zzcx(int zzcz) {
        zzcz = this.zzcz(zzcz);
        if (zzcz < 0 || this.zzcst[zzcz] == adl.zzcsq) {
            return null;
        }
        return this.zzcst[zzcz];
    }
    
    final adm zzcy(final int n) {
        return this.zzcst[n];
    }
}
