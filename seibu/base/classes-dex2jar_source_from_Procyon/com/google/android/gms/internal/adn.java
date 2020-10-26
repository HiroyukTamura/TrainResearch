// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Arrays;
import java.nio.charset.Charset;

public final class adn
{
    private static Charset ISO_8859_1;
    protected static final Charset UTF_8;
    public static final Object zzcsw;
    
    static {
        UTF_8 = Charset.forName("UTF-8");
        adn.ISO_8859_1 = Charset.forName("ISO-8859-1");
        zzcsw = new Object();
    }
    
    public static boolean equals(final float[] a, final float[] a2) {
        if (a == null || a.length == 0) {
            return a2 == null || a2.length == 0;
        }
        return Arrays.equals(a, a2);
    }
    
    public static boolean equals(final int[] a, final int[] a2) {
        if (a == null || a.length == 0) {
            return a2 == null || a2.length == 0;
        }
        return Arrays.equals(a, a2);
    }
    
    public static boolean equals(final long[] a, final long[] a2) {
        if (a == null || a.length == 0) {
            return a2 == null || a2.length == 0;
        }
        return Arrays.equals(a, a2);
    }
    
    public static boolean equals(final Object[] array, final Object[] array2) {
        final boolean b = false;
        int length;
        if (array == null) {
            length = 0;
        }
        else {
            length = array.length;
        }
        int length2;
        if (array2 == null) {
            length2 = 0;
        }
        else {
            length2 = array2.length;
        }
        int n = 0;
        int n2 = 0;
        boolean b4;
        while (true) {
            if (n2 < length && array[n2] == null) {
                ++n2;
            }
            else {
                while (n < length2 && array2[n] == null) {
                    ++n;
                }
                boolean b2;
                if (n2 >= length) {
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                boolean b3;
                if (n >= length2) {
                    b3 = true;
                }
                else {
                    b3 = false;
                }
                if (b2 && b3) {
                    b4 = true;
                    break;
                }
                b4 = b;
                if (b2 != b3) {
                    break;
                }
                b4 = b;
                if (!array[n2].equals(array2[n])) {
                    break;
                }
                ++n;
                ++n2;
            }
        }
        return b4;
    }
    
    public static boolean equals(final boolean[] a, final boolean[] a2) {
        if (a == null || a.length == 0) {
            return a2 == null || a2.length == 0;
        }
        return Arrays.equals(a, a2);
    }
    
    public static int hashCode(final float[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        return Arrays.hashCode(a);
    }
    
    public static int hashCode(final int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        return Arrays.hashCode(a);
    }
    
    public static int hashCode(final long[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        return Arrays.hashCode(a);
    }
    
    public static int hashCode(final Object[] array) {
        int n = 0;
        int length;
        if (array == null) {
            length = 0;
        }
        else {
            length = array.length;
        }
        int n2;
        for (int i = 0; i < length; ++i, n = n2) {
            final Object o = array[i];
            n2 = n;
            if (o != null) {
                n2 = n * 31 + o.hashCode();
            }
        }
        return n;
    }
    
    public static int hashCode(final boolean[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        return Arrays.hashCode(a);
    }
    
    public static void zza(final adj adj, final adj adj2) {
        if (adj.zzcso != null) {
            adj2.zzcso = (adl)adj.zzcso.clone();
        }
    }
    
    public static boolean zza(final byte[][] array, final byte[][] array2) {
        final boolean b = false;
        int length;
        if (array == null) {
            length = 0;
        }
        else {
            length = array.length;
        }
        int length2;
        if (array2 == null) {
            length2 = 0;
        }
        else {
            length2 = array2.length;
        }
        int n = 0;
        int n2 = 0;
        boolean b4;
        while (true) {
            if (n2 < length && array[n2] == null) {
                ++n2;
            }
            else {
                while (n < length2 && array2[n] == null) {
                    ++n;
                }
                boolean b2;
                if (n2 >= length) {
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                boolean b3;
                if (n >= length2) {
                    b3 = true;
                }
                else {
                    b3 = false;
                }
                if (b2 && b3) {
                    b4 = true;
                    break;
                }
                b4 = b;
                if (b2 != b3) {
                    break;
                }
                b4 = b;
                if (!Arrays.equals(array[n2], array2[n])) {
                    break;
                }
                ++n;
                ++n2;
            }
        }
        return b4;
    }
    
    public static int zzc(final byte[][] array) {
        int n = 0;
        int length;
        if (array == null) {
            length = 0;
        }
        else {
            length = array.length;
        }
        int n2;
        for (int i = 0; i < length; ++i, n = n2) {
            final byte[] a = array[i];
            n2 = n;
            if (a != null) {
                n2 = n * 31 + Arrays.hashCode(a);
            }
        }
        return n;
    }
}
