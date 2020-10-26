// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

public final class zzl
{
    public static String zza(final byte[] array, int n, final int n2, final boolean b) {
        if (array == null || array.length == 0 || n2 <= 0 || n2 > array.length) {
            return null;
        }
        final StringBuilder sb = new StringBuilder((n2 + 16 - 1) / 16 * 57);
        int n3 = 0;
        int i = n2;
        n = 0;
        while (i > 0) {
            if (n == 0) {
                if (n2 < 65536) {
                    sb.append(String.format("%04X:", n3));
                }
                else {
                    sb.append(String.format("%08X:", n3));
                }
            }
            else if (n == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", array[n3] & 0xFF));
            --i;
            ++n;
            if (n == 16 || i == 0) {
                sb.append('\n');
                n = 0;
            }
            ++n3;
        }
        return sb.toString();
    }
}
