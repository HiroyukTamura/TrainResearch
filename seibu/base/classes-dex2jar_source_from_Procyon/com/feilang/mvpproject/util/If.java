// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import android.support.annotation.NonNull;
import java.io.Serializable;

public class If<T> implements Serializable
{
    private final T reference;
    
    If(final T reference) {
        this.reference = reference;
    }
    
    public static <T> If<T> of(final T t) {
        return new If<T>(t);
    }
    
    public void present(@NonNull final Consumer<? super T> consumer) {
        if (this.reference != null) {
            consumer.accept(this.reference);
        }
    }
    
    public interface Consumer<T>
    {
        void accept(final T p0);
    }
}
