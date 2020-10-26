// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class CollectPreconditions
{
    static void checkEntryNotNull(final Object obj, final Object obj2) {
        if (obj == null) {
            final String value = String.valueOf(String.valueOf(obj2));
            throw new NullPointerException(new StringBuilder(value.length() + 24).append("null key in entry: null=").append(value).toString());
        }
        if (obj2 == null) {
            final String value2 = String.valueOf(String.valueOf(obj));
            throw new NullPointerException(new StringBuilder(value2.length() + 26).append("null value in entry: ").append(value2).append("=null").toString());
        }
    }
    
    static int checkNonnegative(final int i, String value) {
        if (i < 0) {
            value = String.valueOf(String.valueOf(value));
            throw new IllegalArgumentException(new StringBuilder(value.length() + 40).append(value).append(" cannot be negative but was: ").append(i).toString());
        }
        return i;
    }
    
    static void checkRemove(final boolean b) {
        Preconditions.checkState(b, (Object)"no calls to next() since the last call to remove()");
    }
}
