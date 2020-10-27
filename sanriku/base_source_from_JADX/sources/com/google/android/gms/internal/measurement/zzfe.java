package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzfe {
    @NullableDecl
    public static <T> T zza(Iterator<? extends T> it, @NullableDecl T t) {
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }
}
