// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ReadOnlyBufferException;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;

public final class adh
{
    private final ByteBuffer zzcsn;
    
    private adh(final ByteBuffer zzcsn) {
        (this.zzcsn = zzcsn).order(ByteOrder.LITTLE_ENDIAN);
    }
    
    private adh(final byte[] array, final int offset, final int length) {
        this(ByteBuffer.wrap(array, offset, length));
    }
    
    public static adh zzI(final byte[] array) {
        return zzc(array, 0, array.length);
    }
    
    public static int zzJ(final byte[] array) {
        return zzcv(array.length) + array.length;
    }
    
    private static int zza(final CharSequence charSequence, final byte[] array, int i, int j) {
        final int length = charSequence.length();
        final int n = 0;
        int n2;
        char char1;
        for (n2 = i + j, j = n; j < length && j + i < n2; ++j) {
            char1 = charSequence.charAt(j);
            if (char1 >= '\u0080') {
                break;
            }
            array[i + j] = (byte)char1;
        }
        if (j == length) {
            return i + length;
        }
        i += j;
        while (j < length) {
            final char char2 = charSequence.charAt(j);
            Label_0123: {
                if (char2 < '\u0080' && i < n2) {
                    final int n3 = i + 1;
                    array[i] = (byte)char2;
                    i = n3;
                }
                else if (char2 < '\u0800' && i <= n2 - 2) {
                    final int n4 = i + 1;
                    array[i] = (byte)(char2 >>> 6 | 0x3C0);
                    i = n4 + 1;
                    array[n4] = (byte)((char2 & '?') | 0x80);
                }
                else if ((char2 < '\ud800' || '\udfff' < char2) && i <= n2 - 3) {
                    final int n5 = i + 1;
                    array[i] = (byte)(char2 >>> 12 | 0x1E0);
                    final int n6 = n5 + 1;
                    array[n5] = (byte)((char2 >>> 6 & 0x3F) | 0x80);
                    i = n6 + 1;
                    array[n6] = (byte)((char2 & '?') | 0x80);
                }
                else {
                    if (i <= n2 - 4) {
                        int n7 = j;
                        if (j + 1 != charSequence.length()) {
                            ++j;
                            final char char3 = charSequence.charAt(j);
                            if (Character.isSurrogatePair(char2, char3)) {
                                final int codePoint = Character.toCodePoint(char2, char3);
                                final int n8 = i + 1;
                                array[i] = (byte)(codePoint >>> 18 | 0xF0);
                                i = n8 + 1;
                                array[n8] = (byte)((codePoint >>> 12 & 0x3F) | 0x80);
                                final int n9 = i + 1;
                                array[i] = (byte)((codePoint >>> 6 & 0x3F) | 0x80);
                                i = n9 + 1;
                                array[n9] = (byte)((codePoint & 0x3F) | 0x80);
                                break Label_0123;
                            }
                            n7 = j;
                        }
                        throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(n7 - 1).toString());
                    }
                    throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(char2).append(" at index ").append(i).toString());
                }
            }
            ++j;
        }
        return i;
    }
    
    private static void zza(final CharSequence charSequence, final ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
                return;
            }
            catch (ArrayIndexOutOfBoundsException cause) {
                final BufferOverflowException ex = new BufferOverflowException();
                ex.initCause(cause);
                throw ex;
            }
        }
        zzb(charSequence, byteBuffer);
    }
    
    private final void zzaO(long n) throws IOException {
        while ((0xFFFFFFFFFFFFFF80L & n) != 0x0L) {
            this.zzcs(((int)n & 0x7F) | 0x80);
            n >>>= 7;
        }
        this.zzcs((int)n);
    }
    
    public static int zzaP(final long n) {
        if ((0xFFFFFFFFFFFFFF80L & n) == 0x0L) {
            return 1;
        }
        if ((0xFFFFFFFFFFFFC000L & n) == 0x0L) {
            return 2;
        }
        if ((0xFFFFFFFFFFE00000L & n) == 0x0L) {
            return 3;
        }
        if ((0xFFFFFFFFF0000000L & n) == 0x0L) {
            return 4;
        }
        if ((0xFFFFFFF800000000L & n) == 0x0L) {
            return 5;
        }
        if ((0xFFFFFC0000000000L & n) == 0x0L) {
            return 6;
        }
        if ((0xFFFE000000000000L & n) == 0x0L) {
            return 7;
        }
        if ((0xFF00000000000000L & n) == 0x0L) {
            return 8;
        }
        if ((Long.MIN_VALUE & n) == 0x0L) {
            return 9;
        }
        return 10;
    }
    
    private final void zzaQ(final long n) throws IOException {
        if (this.zzcsn.remaining() < 8) {
            throw new adi(this.zzcsn.position(), this.zzcsn.limit());
        }
        this.zzcsn.putLong(n);
    }
    
    private static long zzaR(final long n) {
        return n << 1 ^ n >> 63;
    }
    
    public static int zzb(int zzct, final adp adp) {
        zzct = zzct(zzct);
        final int zzLV = adp.zzLV();
        return zzct + (zzLV + zzcv(zzLV));
    }
    
    private static int zzb(final CharSequence seq) {
        int n = 0;
        int length;
        int i;
        for (length = seq.length(), i = 0; i < length && seq.charAt(i) < '\u0080'; ++i) {}
        int n2 = length;
        while (true) {
            while (i < length) {
                final char char1 = seq.charAt(i);
                if (char1 < '\u0800') {
                    n2 += '\u007f' - char1 >>> 31;
                    ++i;
                }
                else {
                    while (i < seq.length()) {
                        final char char2 = seq.charAt(i);
                        int n3;
                        if (char2 < '\u0800') {
                            n += '\u007f' - char2 >>> 31;
                            n3 = i;
                        }
                        else {
                            final int n4 = n + 2;
                            n3 = i;
                            n = n4;
                            if ('\ud800' <= char2) {
                                n3 = i;
                                n = n4;
                                if (char2 <= '\udfff') {
                                    if (Character.codePointAt(seq, i) < 65536) {
                                        throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i).toString());
                                    }
                                    n3 = i + 1;
                                    n = n4;
                                }
                            }
                        }
                        i = n3 + 1;
                    }
                    n2 += n;
                    if (n2 < length) {
                        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(n2 + 4294967296L).toString());
                    }
                    return n2;
                }
            }
            continue;
        }
    }
    
    private static void zzb(final CharSequence charSequence, final ByteBuffer byteBuffer) {
        for (int length = charSequence.length(), i = 0; i < length; ++i) {
            final char char1 = charSequence.charAt(i);
            if (char1 < '\u0080') {
                byteBuffer.put((byte)char1);
            }
            else if (char1 < '\u0800') {
                byteBuffer.put((byte)(char1 >>> 6 | 0x3C0));
                byteBuffer.put((byte)((char1 & '?') | 0x80));
            }
            else {
                if (char1 >= '\ud800' && '\udfff' >= char1) {
                    int n = i;
                    if (i + 1 != charSequence.length()) {
                        ++i;
                        final char char2 = charSequence.charAt(i);
                        if (Character.isSurrogatePair(char1, char2)) {
                            final int codePoint = Character.toCodePoint(char1, char2);
                            byteBuffer.put((byte)(codePoint >>> 18 | 0xF0));
                            byteBuffer.put((byte)((codePoint >>> 12 & 0x3F) | 0x80));
                            byteBuffer.put((byte)((codePoint >>> 6 & 0x3F) | 0x80));
                            byteBuffer.put((byte)((codePoint & 0x3F) | 0x80));
                            continue;
                        }
                        n = i;
                    }
                    throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(n - 1).toString());
                }
                byteBuffer.put((byte)(char1 >>> 12 | 0x1E0));
                byteBuffer.put((byte)((char1 >>> 6 & 0x3F) | 0x80));
                byteBuffer.put((byte)((char1 & '?') | 0x80));
            }
        }
    }
    
    public static int zzc(final int n, final byte[] array) {
        return zzct(n) + zzJ(array);
    }
    
    public static adh zzc(final byte[] array, final int n, final int n2) {
        return new adh(array, 0, n2);
    }
    
    public static int zzcr(final int n) {
        if (n >= 0) {
            return zzcv(n);
        }
        return 10;
    }
    
    private final void zzcs(final int n) throws IOException {
        final byte b = (byte)n;
        if (!this.zzcsn.hasRemaining()) {
            throw new adi(this.zzcsn.position(), this.zzcsn.limit());
        }
        this.zzcsn.put(b);
    }
    
    public static int zzct(final int n) {
        return zzcv(n << 3);
    }
    
    public static int zzcv(final int n) {
        if ((n & 0xFFFFFF80) == 0x0) {
            return 1;
        }
        if ((n & 0xFFFFC000) == 0x0) {
            return 2;
        }
        if ((0xFFE00000 & n) == 0x0) {
            return 3;
        }
        if ((0xF0000000 & n) == 0x0) {
            return 4;
        }
        return 5;
    }
    
    public static int zzcw(final int n) {
        return n << 1 ^ n >> 31;
    }
    
    public static int zze(final int n, final long n2) {
        return zzct(n) + zzaP(n2);
    }
    
    public static int zzf(final int n, final long n2) {
        return zzct(n) + zzaP(zzaR(n2));
    }
    
    public static int zzhQ(final String s) {
        final int zzb = zzb(s);
        return zzb + zzcv(zzb);
    }
    
    public static int zzm(final int n, final String s) {
        return zzct(n) + zzhQ(s);
    }
    
    public static int zzs(final int n, final int n2) {
        return zzct(n) + zzcr(n2);
    }
    
    public final void zzK(final byte[] src) throws IOException {
        final int length = src.length;
        if (this.zzcsn.remaining() >= length) {
            this.zzcsn.put(src, 0, length);
            return;
        }
        throw new adi(this.zzcsn.position(), this.zzcsn.limit());
    }
    
    public final void zzLM() {
        if (this.zzcsn.remaining() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
    
    public final void zza(final int n, final double value) throws IOException {
        this.zzt(n, 1);
        this.zzaQ(Double.doubleToLongBits(value));
    }
    
    public final void zza(final int n, final long n2) throws IOException {
        this.zzt(n, 0);
        this.zzaO(n2);
    }
    
    public final void zza(final int n, final adp adp) throws IOException {
        this.zzt(n, 2);
        this.zzb(adp);
    }
    
    public final void zzb(final int n, final long n2) throws IOException {
        this.zzt(n, 0);
        this.zzaO(n2);
    }
    
    public final void zzb(final int n, final byte[] array) throws IOException {
        this.zzt(n, 2);
        this.zzcu(array.length);
        this.zzK(array);
    }
    
    public final void zzb(final adp adp) throws IOException {
        this.zzcu(adp.zzLU());
        adp.zza(this);
    }
    
    public final void zzc(int floatToIntBits, final float value) throws IOException {
        this.zzt(floatToIntBits, 5);
        floatToIntBits = Float.floatToIntBits(value);
        if (this.zzcsn.remaining() < 4) {
            throw new adi(this.zzcsn.position(), this.zzcsn.limit());
        }
        this.zzcsn.putInt(floatToIntBits);
    }
    
    public final void zzc(final int n, final long n2) throws IOException {
        this.zzt(n, 1);
        this.zzaQ(n2);
    }
    
    public final void zzcu(int n) throws IOException {
        while ((n & 0xFFFFFF80) != 0x0) {
            this.zzcs((n & 0x7F) | 0x80);
            n >>>= 7;
        }
        this.zzcs(n);
    }
    
    public final void zzd(final int n, final long n2) throws IOException {
        this.zzt(n, 0);
        this.zzaO(zzaR(n2));
    }
    
    public final void zzk(int n, final boolean b) throws IOException {
        final int n2 = 0;
        this.zzt(n, 0);
        n = n2;
        if (b) {
            n = 1;
        }
        final byte b2 = (byte)n;
        if (!this.zzcsn.hasRemaining()) {
            throw new adi(this.zzcsn.position(), this.zzcsn.limit());
        }
        this.zzcsn.put(b2);
    }
    
    public final void zzl(int zzcv, final String s) throws IOException {
        this.zzt(zzcv, 2);
        Label_0156: {
            int position;
            try {
                zzcv = zzcv(s.length());
                if (zzcv != zzcv(s.length() * 3)) {
                    break Label_0156;
                }
                position = this.zzcsn.position();
                if (this.zzcsn.remaining() < zzcv) {
                    throw new adi(zzcv + position, this.zzcsn.limit());
                }
            }
            catch (BufferOverflowException cause) {
                final adi adi = new adi(this.zzcsn.position(), this.zzcsn.limit());
                adi.initCause(cause);
                throw adi;
            }
            this.zzcsn.position(position + zzcv);
            zza(s, this.zzcsn);
            final int position2 = this.zzcsn.position();
            this.zzcsn.position(position);
            this.zzcu(position2 - position - zzcv);
            this.zzcsn.position(position2);
            return;
        }
        this.zzcu(zzb(s));
        zza(s, this.zzcsn);
    }
    
    public final void zzr(final int n, final int n2) throws IOException {
        this.zzt(n, 0);
        if (n2 >= 0) {
            this.zzcu(n2);
            return;
        }
        this.zzaO(n2);
    }
    
    public final void zzt(final int n, final int n2) throws IOException {
        this.zzcu(n << 3 | n2);
    }
}
