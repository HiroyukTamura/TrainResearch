package com.google.android.gms.internal.ads;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdod<T> implements Serializable {
    zzdod() {
    }

    public static <T> zzdod<T> zzz(@NullableDecl T t) {
        return t == null ? zzdnw.zzhdq : new zzdoi(t);
    }

    @NullableDecl
    public abstract T zzavo();
}
