/*
 * Decompiled with CFR 0.139.
 */
package b.a.c;

import b.a.e.h.a;

public final class b {
    public static RuntimeException a(Throwable throwable) {
        throw a.a(throwable);
    }

    public static void b(Throwable throwable) {
        if (!(throwable instanceof VirtualMachineError)) {
            if (!(throwable instanceof ThreadDeath)) {
                if (!(throwable instanceof LinkageError)) {
                    return;
                }
                throw (LinkageError)throwable;
            }
            throw (ThreadDeath)throwable;
        }
        throw (VirtualMachineError)throwable;
    }
}

