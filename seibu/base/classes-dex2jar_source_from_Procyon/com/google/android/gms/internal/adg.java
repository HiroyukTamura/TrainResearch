// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class adg
{
    private final byte[] buffer;
    private int zzcse;
    private int zzcsf;
    private int zzcsg;
    private int zzcsh;
    private int zzcsi;
    private int zzcsj;
    private int zzcsk;
    private int zzcsl;
    private int zzcsm;
    
    private adg(final byte[] buffer, final int n, final int n2) {
        this.zzcsj = Integer.MAX_VALUE;
        this.zzcsl = 64;
        this.zzcsm = 67108864;
        this.buffer = buffer;
        this.zzcse = n;
        this.zzcsf = n + n2;
        this.zzcsh = n;
    }
    
    public static adg zzH(final byte[] array) {
        return zzb(array, 0, array.length);
    }
    
    private final void zzLJ() {
        this.zzcsf += this.zzcsg;
        final int zzcsf = this.zzcsf;
        if (zzcsf > this.zzcsj) {
            this.zzcsg = zzcsf - this.zzcsj;
            this.zzcsf -= this.zzcsg;
            return;
        }
        this.zzcsg = 0;
    }
    
    private final byte zzLL() throws IOException {
        if (this.zzcsh == this.zzcsf) {
            throw ado.zzLQ();
        }
        return this.buffer[this.zzcsh++];
    }
    
    public static adg zzb(final byte[] array, final int n, final int n2) {
        return new adg(array, 0, n2);
    }
    
    private final void zzcq(final int n) throws IOException {
        if (n < 0) {
            throw ado.zzLR();
        }
        if (this.zzcsh + n > this.zzcsj) {
            this.zzcq(this.zzcsj - this.zzcsh);
            throw ado.zzLQ();
        }
        if (n <= this.zzcsf - this.zzcsh) {
            this.zzcsh += n;
            return;
        }
        throw ado.zzLQ();
    }
    
    public final int getPosition() {
        return this.zzcsh - this.zzcse;
    }
    
    public final byte[] readBytes() throws IOException {
        final int zzLF = this.zzLF();
        if (zzLF < 0) {
            throw ado.zzLR();
        }
        if (zzLF == 0) {
            return ads.zzcsI;
        }
        if (zzLF > this.zzcsf - this.zzcsh) {
            throw ado.zzLQ();
        }
        final byte[] array = new byte[zzLF];
        System.arraycopy(this.buffer, this.zzcsh, array, 0, zzLF);
        this.zzcsh += zzLF;
        return array;
    }
    
    public final String readString() throws IOException {
        final int zzLF = this.zzLF();
        if (zzLF < 0) {
            throw ado.zzLR();
        }
        if (zzLF > this.zzcsf - this.zzcsh) {
            throw ado.zzLQ();
        }
        final String s = new String(this.buffer, this.zzcsh, zzLF, adn.UTF_8);
        this.zzcsh += zzLF;
        return s;
    }
    
    public final int zzLA() throws IOException {
        if (this.zzcsh == this.zzcsf) {
            return this.zzcsi = 0;
        }
        this.zzcsi = this.zzLF();
        if (this.zzcsi == 0) {
            throw new ado("Protocol message contained an invalid tag (zero).");
        }
        return this.zzcsi;
    }
    
    public final long zzLB() throws IOException {
        return this.zzLG();
    }
    
    public final int zzLC() throws IOException {
        return this.zzLF();
    }
    
    public final boolean zzLD() throws IOException {
        return this.zzLF() != 0;
    }
    
    public final long zzLE() throws IOException {
        final long zzLG = this.zzLG();
        return -(zzLG & 0x1L) ^ zzLG >>> 1;
    }
    
    public final int zzLF() throws IOException {
        int zzLL = this.zzLL();
        if (zzLL < 0) {
            final int n = zzLL & 0x7F;
            final byte zzLL2 = this.zzLL();
            if (zzLL2 >= 0) {
                return n | zzLL2 << 7;
            }
            final int n2 = n | (zzLL2 & 0x7F) << 7;
            final byte zzLL3 = this.zzLL();
            if (zzLL3 >= 0) {
                return n2 | zzLL3 << 14;
            }
            final int n3 = n2 | (zzLL3 & 0x7F) << 14;
            final byte zzLL4 = this.zzLL();
            if (zzLL4 >= 0) {
                return n3 | zzLL4 << 21;
            }
            final byte zzLL5 = this.zzLL();
            final int n4 = zzLL = (n3 | (zzLL4 & 0x7F) << 21 | zzLL5 << 28);
            if (zzLL5 < 0) {
                for (int i = 0; i < 5; ++i) {
                    zzLL = n4;
                    if (this.zzLL() >= 0) {
                        return zzLL;
                    }
                }
                throw ado.zzLS();
            }
        }
        return zzLL;
    }
    
    public final long zzLG() throws IOException {
        int i = 0;
        long n = 0L;
        while (i < 64) {
            final byte zzLL = this.zzLL();
            n |= (long)(zzLL & 0x7F) << i;
            if ((zzLL & 0x80) == 0x0) {
                return n;
            }
            i += 7;
        }
        throw ado.zzLS();
    }
    
    public final int zzLH() throws IOException {
        return (this.zzLL() & 0xFF) | (this.zzLL() & 0xFF) << 8 | (this.zzLL() & 0xFF) << 16 | (this.zzLL() & 0xFF) << 24;
    }
    
    public final long zzLI() throws IOException {
        return ((long)this.zzLL() & 0xFFL) << 8 | ((long)this.zzLL() & 0xFFL) | ((long)this.zzLL() & 0xFFL) << 16 | ((long)this.zzLL() & 0xFFL) << 24 | ((long)this.zzLL() & 0xFFL) << 32 | ((long)this.zzLL() & 0xFFL) << 40 | ((long)this.zzLL() & 0xFFL) << 48 | ((long)this.zzLL() & 0xFFL) << 56;
    }
    
    public final int zzLK() {
        if (this.zzcsj == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzcsj - this.zzcsh;
    }
    
    public final void zza(final adp adp) throws IOException {
        final int zzLF = this.zzLF();
        if (this.zzcsk >= this.zzcsl) {
            throw ado.zzLT();
        }
        final int zzcn = this.zzcn(zzLF);
        ++this.zzcsk;
        adp.zza(this);
        this.zzcl(0);
        --this.zzcsk;
        this.zzco(zzcn);
    }
    
    public final void zza(final adp adp, final int n) throws IOException {
        if (this.zzcsk >= this.zzcsl) {
            throw ado.zzLT();
        }
        ++this.zzcsk;
        adp.zza(this);
        this.zzcl(n << 3 | 0x4);
        --this.zzcsk;
    }
    
    public final void zzcl(final int n) throws ado {
        if (this.zzcsi != n) {
            throw new ado("Protocol message end-group tag did not match expected tag.");
        }
    }
    
    public final boolean zzcm(final int n) throws IOException {
        switch (n & 0x7) {
            default: {
                throw new ado("Protocol message tag had invalid wire type.");
            }
            case 0: {
                this.zzLF();
                return true;
            }
            case 1: {
                this.zzLI();
                return true;
            }
            case 2: {
                this.zzcq(this.zzLF());
                return true;
            }
            case 3: {
                int zzLA;
                do {
                    zzLA = this.zzLA();
                } while (zzLA != 0 && this.zzcm(zzLA));
                this.zzcl(n >>> 3 << 3 | 0x4);
                return true;
            }
            case 4: {
                return false;
            }
            case 5: {
                this.zzLH();
                return true;
            }
        }
    }
    
    public final int zzcn(int zzcsj) throws ado {
        if (zzcsj < 0) {
            throw ado.zzLR();
        }
        zzcsj += this.zzcsh;
        final int zzcsj2 = this.zzcsj;
        if (zzcsj > zzcsj2) {
            throw ado.zzLQ();
        }
        this.zzcsj = zzcsj;
        this.zzLJ();
        return zzcsj2;
    }
    
    public final void zzco(final int zzcsj) {
        this.zzcsj = zzcsj;
        this.zzLJ();
    }
    
    public final void zzcp(final int n) {
        this.zzq(n, this.zzcsi);
    }
    
    public final byte[] zzp(final int n, final int n2) {
        if (n2 == 0) {
            return ads.zzcsI;
        }
        final byte[] array = new byte[n2];
        System.arraycopy(this.buffer, this.zzcse + n, array, 0, n2);
        return array;
    }
    
    final void zzq(final int n, int zzcsh) {
        if (n > this.zzcsh - this.zzcse) {
            zzcsh = this.zzcsh;
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(n).append(" is beyond current ").append(zzcsh - this.zzcse).toString());
        }
        if (n < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(n).toString());
        }
        this.zzcsh = this.zzcse + n;
        this.zzcsi = zzcsh;
    }
}
