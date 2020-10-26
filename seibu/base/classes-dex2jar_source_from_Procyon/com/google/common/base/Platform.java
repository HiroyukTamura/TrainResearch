// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import java.lang.ref.WeakReference;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class Platform
{
    private Platform() {
    }
    
    static <T extends Enum<T>> Optional<T> getEnumIfPresent(final Class<T> clazz, final String s) {
        final WeakReference<? extends Enum<?>> weakReference = Enums.getEnumConstants(clazz).get(s);
        if (weakReference == null) {
            return Optional.absent();
        }
        return Optional.of(clazz.cast(weakReference.get()));
    }
    
    static CharMatcher precomputeCharMatcher(final CharMatcher charMatcher) {
        return charMatcher.precomputedInternal();
    }
    
    static long systemNanoTime() {
        return System.nanoTime();
    }
}
