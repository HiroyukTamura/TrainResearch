/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.f;
import androidx.constraintlayout.b.a.g;
import androidx.constraintlayout.b.c;
import java.util.ArrayList;

public class r
extends f {
    protected ArrayList<f> aw = new ArrayList();

    @Override
    public void E() {
        super.E();
        if (this.aw == null) {
            return;
        }
        int n2 = this.aw.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f2 = this.aw.get(i2);
            f2.b(this.t(), this.u());
            if (f2 instanceof g) continue;
            f2.E();
        }
    }

    public void N() {
        this.E();
        if (this.aw == null) {
            return;
        }
        int n2 = this.aw.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f2 = this.aw.get(i2);
            if (!(f2 instanceof r)) continue;
            ((r)f2).N();
        }
    }

    public g T() {
        f f2 = this.k();
        g g2 = this instanceof g ? (g)this : null;
        while (f2 != null) {
            f f3 = f2.k();
            if (f2 instanceof g) {
                g2 = (g)f2;
            }
            f2 = f3;
        }
        return g2;
    }

    public void U() {
        this.aw.clear();
    }

    @Override
    public void a(c c2) {
        super.a(c2);
        int n2 = this.aw.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.aw.get(i2).a(c2);
        }
    }

    @Override
    public void b(int n2, int n3) {
        super.b(n2, n3);
        n3 = this.aw.size();
        for (n2 = 0; n2 < n3; ++n2) {
            this.aw.get(n2).b(this.v(), this.w());
        }
    }

    public void b(f f2) {
        this.aw.add(f2);
        if (f2.k() != null) {
            ((r)f2.k()).c(f2);
        }
        f2.a_(this);
    }

    public void c(f f2) {
        this.aw.remove(f2);
        f2.a_(null);
    }

    @Override
    public void g() {
        this.aw.clear();
        super.g();
    }
}

