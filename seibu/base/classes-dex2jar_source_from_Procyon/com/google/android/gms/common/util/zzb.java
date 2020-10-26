// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import java.util.Arrays;
import java.util.ArrayList;

public final class zzb
{
    public static <T> ArrayList<T> zza(final T[] array) {
        final int length = array.length;
        final ArrayList list = new ArrayList<T>(length);
        for (int i = 0; i < length; ++i) {
            list.add(array[i]);
        }
        return (ArrayList<T>)list;
    }
    
    public static void zza(final StringBuilder sb, final double[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(array[i]));
        }
    }
    
    public static void zza(final StringBuilder sb, final float[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(array[i]));
        }
    }
    
    public static void zza(final StringBuilder sb, final long[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(array[i]));
        }
    }
    
    public static <T> void zza(final StringBuilder sb, final T[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(array[i].toString());
        }
    }
    
    public static void zza(final StringBuilder sb, final String[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("\"").append(array[i]).append("\"");
        }
    }
    
    public static void zza(final StringBuilder sb, final boolean[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(array[i]));
        }
    }
    
    public static byte[] zza(final byte[]... array) {
        if (array.length == 0) {
            return new byte[0];
        }
        int i = 0;
        int newLength = 0;
        while (i < array.length) {
            newLength += array[i].length;
            ++i;
        }
        final byte[] copy = Arrays.copyOf(array[0], newLength);
        int length = array[0].length;
        for (int j = 1; j < array.length; ++j) {
            final byte[] array2 = array[j];
            System.arraycopy(array2, 0, copy, length, array2.length);
            length += array2.length;
        }
        return copy;
    }
    
    public static Integer[] zza(final int[] array) {
        Integer[] array2;
        if (array == null) {
            array2 = null;
        }
        else {
            final int length = array.length;
            final Integer[] array3 = new Integer[length];
            int n = 0;
            while (true) {
                array2 = array3;
                if (n >= length) {
                    break;
                }
                array3[n] = array[n];
                ++n;
            }
        }
        return array2;
    }
}
