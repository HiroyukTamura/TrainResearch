// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.base;

import javax.annotation.Nullable;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import com.google.common.annotations.Beta;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public final class Throwables
{
    private Throwables() {
    }
    
    @Beta
    public static List<Throwable> getCausalChain(Throwable cause) {
        Preconditions.checkNotNull(cause);
        final ArrayList<Throwable> list = new ArrayList<Throwable>(4);
        while (cause != null) {
            list.add(cause);
            cause = cause.getCause();
        }
        return (List<Throwable>)Collections.unmodifiableList((List<?>)list);
    }
    
    public static Throwable getRootCause(Throwable t) {
        while (true) {
            final Throwable cause = t.getCause();
            if (cause == null) {
                break;
            }
            t = cause;
        }
        return t;
    }
    
    public static String getStackTraceAsString(final Throwable t) {
        final StringWriter out = new StringWriter();
        t.printStackTrace(new PrintWriter(out));
        return out.toString();
    }
    
    public static RuntimeException propagate(final Throwable cause) {
        propagateIfPossible(Preconditions.checkNotNull(cause));
        throw new RuntimeException(cause);
    }
    
    public static <X extends Throwable> void propagateIfInstanceOf(@Nullable final Throwable obj, final Class<X> clazz) throws X, Throwable {
        if (obj != null && clazz.isInstance(obj)) {
            throw clazz.cast(obj);
        }
    }
    
    public static void propagateIfPossible(@Nullable final Throwable t) {
        propagateIfInstanceOf(t, Error.class);
        propagateIfInstanceOf(t, RuntimeException.class);
    }
    
    public static <X extends Throwable> void propagateIfPossible(@Nullable final Throwable t, final Class<X> clazz) throws X, Throwable {
        propagateIfInstanceOf(t, (Class<Throwable>)clazz);
        propagateIfPossible(t);
    }
    
    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@Nullable final Throwable t, final Class<X1> clazz, final Class<X2> clazz2) throws X1, X2, Throwable {
        Preconditions.checkNotNull(clazz2);
        propagateIfInstanceOf(t, clazz);
        propagateIfPossible(t, clazz2);
    }
}
