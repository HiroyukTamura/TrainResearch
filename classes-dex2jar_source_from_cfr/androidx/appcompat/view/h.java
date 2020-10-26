/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.animation.Interpolator
 */
package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.h.x;
import androidx.core.h.y;
import androidx.core.h.z;
import java.util.ArrayList;
import java.util.Iterator;

public class h {
    final ArrayList<x> a = new ArrayList();
    y b;
    private long c = -1L;
    private Interpolator d;
    private boolean e;
    private final z f = new z(){
        private boolean b = false;
        private int c = 0;

        void a() {
            this.c = 0;
            this.b = false;
            h.this.b();
        }

        @Override
        public void a(View view) {
            if (this.b) {
                return;
            }
            this.b = true;
            if (h.this.b != null) {
                h.this.b.a(null);
            }
        }

        @Override
        public void b(View view) {
            int n2;
            this.c = n2 = this.c + 1;
            if (n2 == h.this.a.size()) {
                if (h.this.b != null) {
                    h.this.b.b(null);
                }
                this.a();
            }
        }
    };

    public h a(long l2) {
        if (!this.e) {
            this.c = l2;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public h a(x x2) {
        if (!this.e) {
            this.a.add(x2);
        }
        return this;
    }

    public h a(x x2, x x3) {
        this.a.add(x2);
        x3.b(x2.a());
        this.a.add(x3);
        return this;
    }

    public h a(y y2) {
        if (!this.e) {
            this.b = y2;
        }
        return this;
    }

    public void a() {
        if (this.e) {
            return;
        }
        for (x x2 : this.a) {
            if (this.c >= 0L) {
                x2.a(this.c);
            }
            if (this.d != null) {
                x2.a(this.d);
            }
            if (this.b != null) {
                x2.a(this.f);
            }
            x2.c();
        }
        this.e = true;
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if (!this.e) {
            return;
        }
        Iterator<x> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next().b();
        }
        this.e = false;
    }

}

