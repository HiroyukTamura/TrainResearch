/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.e;
import androidx.constraintlayout.b.a.f;
import java.util.ArrayList;

public class q {
    private int a;
    private int b;
    private int c;
    private int d;
    private ArrayList<a> e = new ArrayList();

    public q(f object) {
        this.a = ((f)object).n();
        this.b = ((f)object).o();
        this.c = ((f)object).p();
        this.d = ((f)object).r();
        object = ((f)object).D();
        int n2 = ((ArrayList)object).size();
        for (int i2 = 0; i2 < n2; ++i2) {
            e e2 = (e)((ArrayList)object).get(i2);
            this.e.add(new a(e2));
        }
    }

    public void a(f f2) {
        this.a = f2.n();
        this.b = f2.o();
        this.c = f2.p();
        this.d = f2.r();
        int n2 = this.e.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.e.get(i2).a(f2);
        }
    }

    public void b(f f2) {
        f2.f(this.a);
        f2.g(this.b);
        f2.h(this.c);
        f2.i(this.d);
        int n2 = this.e.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.e.get(i2).b(f2);
        }
    }

    static class a {
        private e a;
        private e b;
        private int c;
        private e.b d;
        private int e;

        public a(e e2) {
            this.a = e2;
            this.b = e2.g();
            this.c = e2.e();
            this.d = e2.f();
            this.e = e2.h();
        }

        /*
         * Enabled aggressive block sorting
         */
        public void a(f f2) {
            int n2;
            this.a = f2.a(this.a.d());
            if (this.a != null) {
                this.b = this.a.g();
                this.c = this.a.e();
                this.d = this.a.f();
                n2 = this.a.h();
            } else {
                this.b = null;
                n2 = 0;
                this.c = 0;
                this.d = e.b.b;
            }
            this.e = n2;
        }

        public void b(f f2) {
            f2.a(this.a.d()).a(this.b, this.c, this.d, this.e);
        }
    }

}

