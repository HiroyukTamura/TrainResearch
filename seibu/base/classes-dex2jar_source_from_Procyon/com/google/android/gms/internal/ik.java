// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class ik
{
    @NonNull
    public static <T> T zzu(@Nullable final T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }
}
