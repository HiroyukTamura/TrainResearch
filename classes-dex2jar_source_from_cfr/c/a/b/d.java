/*
 * Decompiled with CFR 0.139.
 */
package c.a.b;

import c.ae;
import java.util.LinkedHashSet;
import java.util.Set;

public final class d {
    private final Set<ae> a = new LinkedHashSet<ae>();

    public void a(ae ae2) {
        synchronized (this) {
            this.a.add(ae2);
            return;
        }
    }

    public void b(ae ae2) {
        synchronized (this) {
            this.a.remove(ae2);
            return;
        }
    }

    public boolean c(ae ae2) {
        synchronized (this) {
            boolean bl2 = this.a.contains(ae2);
            return bl2;
        }
    }
}

