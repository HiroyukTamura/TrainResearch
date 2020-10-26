/*
 * Decompiled with CFR 0.139.
 */
package androidx.lifecycle;

import androidx.lifecycle.d;
import androidx.lifecycle.f;
import androidx.lifecycle.g;
import androidx.lifecycle.j;

class FullLifecycleObserverAdapter
implements f {
    private final d a;

    FullLifecycleObserverAdapter(d d2) {
        this.a = d2;
    }

    @Override
    public void a(j j2, g.a a2) {
        switch (1.a[a2.ordinal()]) {
            default: {
                return;
            }
            case 7: {
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            }
            case 6: {
                this.a.f(j2);
                return;
            }
            case 5: {
                this.a.e(j2);
                return;
            }
            case 4: {
                this.a.d(j2);
                return;
            }
            case 3: {
                this.a.c(j2);
                return;
            }
            case 2: {
                this.a.b(j2);
                return;
            }
            case 1: 
        }
        this.a.a(j2);
    }

}

