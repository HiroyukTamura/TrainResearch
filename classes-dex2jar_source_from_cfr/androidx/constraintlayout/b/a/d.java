/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.e;
import androidx.constraintlayout.b.a.f;
import java.util.ArrayList;

public class d {
    protected f a;
    protected f b;
    protected f c;
    protected f d;
    protected f e;
    protected f f;
    protected f g;
    protected ArrayList<f> h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    private int o;
    private boolean p = false;
    private boolean q;

    public d(f f2, int n2, boolean bl2) {
        this.a = f2;
        this.o = n2;
        this.p = bl2;
    }

    private static boolean a(f f2, int n2) {
        return f2.l() != 8 && f2.C[n2] == f.a.c && (f2.g[n2] == 0 || f2.g[n2] == 3);
    }

    private void b() {
        int n2 = this.o * 2;
        Object object = this.a;
        Object object2 = this.a;
        boolean bl2 = false;
        boolean bl3 = false;
        while (!bl3) {
            ++this.i;
            object2 = object.ac;
            int n3 = this.o;
            Object var9_8 = null;
            object2[n3] = null;
            object.ab[this.o] = null;
            if (object.l() != 8) {
                if (this.b == null) {
                    this.b = object;
                }
                if (this.d != null) {
                    this.d.ac[this.o] = object;
                }
                this.d = object;
                if (object.C[this.o] == f.a.c && (object.g[this.o] == 0 || object.g[this.o] == 3 || object.g[this.o] == 2)) {
                    ++this.j;
                    float f2 = object.aa[this.o];
                    if (f2 > 0.0f) {
                        this.k += object.aa[this.o];
                    }
                    if (d.a((f)object, this.o)) {
                        if (f2 < 0.0f) {
                            this.l = true;
                        } else {
                            this.m = true;
                        }
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        this.h.add((f)object);
                    }
                    if (this.f == null) {
                        this.f = object;
                    }
                    if (this.g != null) {
                        this.g.ab[this.o] = object;
                    }
                    this.g = object;
                }
            }
            Object object3 = object.A[n2 + 1].c;
            object2 = var9_8;
            if (object3 != null) {
                object3 = ((e)object3).a;
                object2 = var9_8;
                if (object3.A[n2].c != null) {
                    object2 = object3.A[n2].c.a != object ? var9_8 : object3;
                }
            }
            if (object2 != null) {
                object = object2;
                continue;
            }
            bl3 = true;
        }
        this.c = object;
        object2 = this.o == 0 && this.p ? this.c : this.a;
        this.e = object2;
        boolean bl4 = bl2;
        if (this.m) {
            bl4 = bl2;
            if (this.l) {
                bl4 = true;
            }
        }
        this.n = bl4;
    }

    public void a() {
        if (!this.q) {
            this.b();
        }
        this.q = true;
    }
}

