/*
 * Decompiled with CFR 0.139.
 */
package c.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e
extends RuntimeException {
    private static final Method a;
    private IOException b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Method method;
        block2 : {
            try {
                method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
                break block2;
            }
            catch (Exception exception) {}
            method = null;
        }
        a = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.b = iOException;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(IOException iOException, IOException iOException2) {
        if (a == null) return;
        try {
            a.invoke(iOException, iOException2);
            return;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return;
        }
    }

    public IOException a() {
        return this.b;
    }

    public void a(IOException iOException) {
        this.a(iOException, this.b);
        this.b = iOException;
    }
}

