/*
 * Decompiled with CFR 0.139.
 */
package androidx.lifecycle;

import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.g;
import androidx.lifecycle.j;
import androidx.lifecycle.o;

public class CompositeGeneratedAdaptersObserver
implements f {
    private final e[] a;

    CompositeGeneratedAdaptersObserver(e[] arre) {
        this.a = arre;
    }

    @Override
    public void a(j j2, g.a a2) {
        int n2;
        o o2 = new o();
        e[] arre = this.a;
        int n3 = arre.length;
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            arre[n2].a(j2, a2, false, o2);
        }
        arre = this.a;
        n3 = arre.length;
        for (n2 = n4; n2 < n3; ++n2) {
            arre[n2].a(j2, a2, true, o2);
        }
    }
}

