// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import javax.annotation.Nullable;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class Preconditions
{
    private Preconditions() {
    }
    
    private static String badElementIndex(final int n, final int n2, final String s) {
        if (n < 0) {
            return format("%s (%s) must not be negative", s, n);
        }
        if (n2 < 0) {
            throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(n2).toString());
        }
        return format("%s (%s) must be less than size (%s)", s, n, n2);
    }
    
    private static String badPositionIndex(final int n, final int n2, final String s) {
        if (n < 0) {
            return format("%s (%s) must not be negative", s, n);
        }
        if (n2 < 0) {
            throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(n2).toString());
        }
        return format("%s (%s) must not be greater than size (%s)", s, n, n2);
    }
    
    private static String badPositionIndexes(final int i, final int j, final int n) {
        if (i < 0 || i > n) {
            return badPositionIndex(i, n, "start index");
        }
        if (j < 0 || j > n) {
            return badPositionIndex(j, n, "end index");
        }
        return format("end index (%s) must not be less than start index (%s)", j, i);
    }
    
    public static void checkArgument(final boolean b) {
        if (!b) {
            throw new IllegalArgumentException();
        }
    }
    
    public static void checkArgument(final boolean b, @Nullable final Object obj) {
        if (!b) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }
    
    public static void checkArgument(final boolean b, @Nullable final String s, @Nullable final Object... array) {
        if (!b) {
            throw new IllegalArgumentException(format(s, array));
        }
    }
    
    public static int checkElementIndex(final int n, final int n2) {
        return checkElementIndex(n, n2, "index");
    }
    
    public static int checkElementIndex(final int n, final int n2, @Nullable final String s) {
        if (n < 0 || n >= n2) {
            throw new IndexOutOfBoundsException(badElementIndex(n, n2, s));
        }
        return n;
    }
    
    public static <T> T checkNotNull(final T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }
    
    public static <T> T checkNotNull(final T t, @Nullable final Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }
    
    public static <T> T checkNotNull(final T t, @Nullable final String s, @Nullable final Object... array) {
        if (t == null) {
            throw new NullPointerException(format(s, array));
        }
        return t;
    }
    
    public static int checkPositionIndex(final int n, final int n2) {
        return checkPositionIndex(n, n2, "index");
    }
    
    public static int checkPositionIndex(final int n, final int n2, @Nullable final String s) {
        if (n < 0 || n > n2) {
            throw new IndexOutOfBoundsException(badPositionIndex(n, n2, s));
        }
        return n;
    }
    
    public static void checkPositionIndexes(final int n, final int n2, final int n3) {
        if (n < 0 || n2 < n || n2 > n3) {
            throw new IndexOutOfBoundsException(badPositionIndexes(n, n2, n3));
        }
    }
    
    public static void checkState(final boolean b) {
        if (!b) {
            throw new IllegalStateException();
        }
    }
    
    public static void checkState(final boolean b, @Nullable final Object obj) {
        if (!b) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
    
    public static void checkState(final boolean b, @Nullable final String s, @Nullable final Object... array) {
        if (!b) {
            throw new IllegalStateException(format(s, array));
        }
    }
    
    static String format(String value, @Nullable final Object... array) {
        value = String.valueOf(value);
        final StringBuilder sb = new StringBuilder(value.length() + array.length * 16);
        int beginIndex = 0;
        int i;
        for (i = 0; i < array.length; ++i) {
            final int index = value.indexOf("%s", beginIndex);
            if (index == -1) {
                break;
            }
            sb.append(value.substring(beginIndex, index));
            sb.append(array[i]);
            beginIndex = index + 2;
        }
        sb.append(value.substring(beginIndex));
        if (i < array.length) {
            sb.append(" [");
            sb.append(array[i]);
            for (int j = i + 1; j < array.length; ++j) {
                sb.append(", ");
                sb.append(array[j]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
