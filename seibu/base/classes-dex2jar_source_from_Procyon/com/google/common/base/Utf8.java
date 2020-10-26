// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.Beta;

@Beta
@GwtCompatible
public final class Utf8
{
    private Utf8() {
    }
    
    public static int encodedLength(final CharSequence charSequence) {
        final int length;
        final int n = length = charSequence.length();
        int n2 = 0;
        int n3;
        int n4;
        while (true) {
            n3 = n2;
            n4 = length;
            if (n2 >= n) {
                break;
            }
            n3 = n2;
            n4 = length;
            if (charSequence.charAt(n2) >= '\u0080') {
                break;
            }
            ++n2;
        }
        int n5;
        while (true) {
            n5 = n4;
            if (n3 >= n) {
                break;
            }
            final char char1 = charSequence.charAt(n3);
            if (char1 >= '\u0800') {
                n5 = n4 + encodedLengthGeneral(charSequence, n3);
                break;
            }
            n4 += '\u007f' - char1 >>> 31;
            ++n3;
        }
        if (n5 < n) {
            throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(n5 + 4294967296L).toString());
        }
        return n5;
    }
    
    private static int encodedLengthGeneral(final CharSequence seq, int i) {
        final int length = seq.length();
        int n = 0;
        while (i < length) {
            final char char1 = seq.charAt(i);
            int n2;
            if (char1 < '\u0800') {
                n += '\u007f' - char1 >>> 31;
                n2 = i;
            }
            else {
                final int n3 = n + 2;
                n2 = i;
                n = n3;
                if ('\ud800' <= char1) {
                    n2 = i;
                    n = n3;
                    if (char1 <= '\udfff') {
                        if (Character.codePointAt(seq, i) < 65536) {
                            throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i).toString());
                        }
                        n2 = i + 1;
                        n = n3;
                    }
                }
            }
            i = n2 + 1;
        }
        return n;
    }
    
    public static boolean isWellFormed(final byte[] array) {
        return isWellFormed(array, 0, array.length);
    }
    
    public static boolean isWellFormed(final byte[] array, int i, int n) {
        n += i;
        Preconditions.checkPositionIndexes(i, n, array.length);
        while (i < n) {
            if (array[i] < 0) {
                return isWellFormedSlowPath(array, i, n);
            }
            ++i;
        }
        return true;
    }
    
    private static boolean isWellFormedSlowPath(final byte[] array, int i, final int n) {
        final boolean b = false;
    Label_0164_Outer:
        while (i < n) {
            final int n2 = i + 1;
            final byte b2 = array[i];
            if (b2 < 0) {
                if (b2 < -32) {
                    boolean b3 = b;
                    if (n2 == n) {
                        return b3;
                    }
                    b3 = b;
                    if (b2 < -62) {
                        return b3;
                    }
                    final int n3 = i = n2 + 1;
                    if (array[n2] > -65) {
                        i = n3;
                        return false;
                    }
                    continue Label_0164_Outer;
                }
                else if (b2 < -16) {
                    boolean b3 = b;
                    if (n2 + 1 >= n) {
                        return b3;
                    }
                    final int n4 = n2 + 1;
                    final byte b4 = array[n2];
                    i = n4;
                    if (b4 > -65) {
                        return false;
                    }
                    if (b2 == -32) {
                        i = n4;
                        if (b4 < -96) {
                            return false;
                        }
                    }
                    if (b2 == -19) {
                        i = n4;
                        if (-96 <= b4) {
                            return false;
                        }
                    }
                    i = n4 + 1;
                    b3 = b;
                    if (array[n4] <= -65) {
                        continue Label_0164_Outer;
                    }
                    return b3;
                }
                else {
                    boolean b3 = b;
                    if (n2 + 2 >= n) {
                        return b3;
                    }
                    final int n5 = n2 + 1;
                    final byte b5 = array[n2];
                    i = n5;
                    if (b5 > -65) {
                        return false;
                    }
                    i = n5;
                    if ((b2 << 28) + (b5 + 112) >> 30 != 0) {
                        return false;
                    }
                    final int n6 = n5 + 1;
                    b3 = b;
                    if (array[n5] > -65) {
                        return b3;
                    }
                    final int n7 = i = n6 + 1;
                    if (array[n6] > -65) {
                        return false;
                    }
                    i = n7;
                }
                while (true) {
                    continue Label_0164_Outer;
                    continue;
                }
            }
            i = n2;
        }
        return true;
    }
}
