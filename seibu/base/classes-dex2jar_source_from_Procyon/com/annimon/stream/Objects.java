// 
// Decompiled by Procyon v0.5.36
// 

package com.annimon.stream;

import java.util.Comparator;

public final class Objects
{
    private Objects() {
    }
    
    public static <T> int compare(final T t, final T t2, final Comparator<? super T> comparator) {
        if (t == t2) {
            return 0;
        }
        return comparator.compare(t, t2);
    }
    
    public static int compareInt(final int n, final int n2) {
        if (n < n2) {
            return -1;
        }
        if (n == n2) {
            return 0;
        }
        return 1;
    }
    
    public static int compareLong(final long n, final long n2) {
        if (n < n2) {
            return -1;
        }
        if (n == n2) {
            return 0;
        }
        return 1;
    }
    
    public static boolean equals(final Object o, final Object obj) {
        return o == obj || (o != null && o.equals(obj));
    }
    
    public static int hash(final Object... array) {
        int n = 0;
        int n2;
        if (array == null) {
            n2 = 0;
        }
        else {
            int n3 = 1;
            final int length = array.length;
            while (true) {
                n2 = n3;
                if (n >= length) {
                    break;
                }
                n3 = n3 * 31 + hashCode(array[n]);
                ++n;
            }
        }
        return n2;
    }
    
    public static int hashCode(final Object o) {
        if (o != null) {
            return o.hashCode();
        }
        return 0;
    }
    
    public static <T> T requireNonNull(final T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }
    
    public static <T> T requireNonNull(final T t, final String s) {
        if (t == null) {
            throw new NullPointerException(s);
        }
        return t;
    }
    
    public static String toString(final Object o, String string) {
        if (o != null) {
            string = o.toString();
        }
        return string;
    }
}
