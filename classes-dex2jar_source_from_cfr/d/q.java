/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package d;

import d.p;
import javax.annotation.Nullable;

final class q {
    @Nullable
    static p a;
    static long b;

    private q() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static p a() {
        synchronized (q.class) {
            if (a != null) {
                p p2 = a;
                a = p2.f;
                p2.f = null;
                b -= 8192L;
                return p2;
            }
            return new p();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void a(p p2) {
        if (p2.f == null && p2.g == null) {
            if (p2.d) {
                return;
            }
            synchronized (q.class) {
                if (b + 8192L > 65536L) {
                    return;
                }
                b += 8192L;
                p2.f = a;
                p2.c = 0;
                p2.b = 0;
                a = p2;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}

