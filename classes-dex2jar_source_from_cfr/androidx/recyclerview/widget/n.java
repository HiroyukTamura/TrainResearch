/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;

class n {
    final b a;
    a b;

    n(b b2) {
        this.a = b2;
        this.b = new a();
    }

    View a(int n2, int n3, int n4, int n5) {
        int n6 = this.a.a();
        int n7 = this.a.b();
        int n8 = n3 > n2 ? 1 : -1;
        View view = null;
        while (n2 != n3) {
            View view2 = this.a.a(n2);
            int n9 = this.a.a(view2);
            int n10 = this.a.b(view2);
            this.b.a(n6, n7, n9, n10);
            if (n4 != 0) {
                this.b.a();
                this.b.a(n4);
                if (this.b.b()) {
                    return view2;
                }
            }
            View view3 = view;
            if (n5 != 0) {
                this.b.a();
                this.b.a(n5);
                view3 = view;
                if (this.b.b()) {
                    view3 = view2;
                }
            }
            n2 += n8;
            view = view3;
        }
        return view;
    }

    boolean a(View view, int n2) {
        this.b.a(this.a.a(), this.a.b(), this.a.a(view), this.a.b(view));
        if (n2 != 0) {
            this.b.a();
            this.b.a(n2);
            return this.b.b();
        }
        return false;
    }

    static class a {
        int a = 0;
        int b;
        int c;
        int d;
        int e;

        a() {
        }

        int a(int n2, int n3) {
            if (n2 > n3) {
                return 1;
            }
            if (n2 == n3) {
                return 2;
            }
            return 4;
        }

        void a() {
            this.a = 0;
        }

        void a(int n2) {
            this.a = n2 | this.a;
        }

        void a(int n2, int n3, int n4, int n5) {
            this.b = n2;
            this.c = n3;
            this.d = n4;
            this.e = n5;
        }

        boolean b() {
            if ((this.a & 7) != 0 && (this.a & this.a(this.d, this.b) << 0) == 0) {
                return false;
            }
            if ((this.a & 112) != 0 && (this.a & this.a(this.d, this.c) << 4) == 0) {
                return false;
            }
            if ((this.a & 1792) != 0 && (this.a & this.a(this.e, this.b) << 8) == 0) {
                return false;
            }
            return (this.a & 28672) == 0 || (this.a & this.a(this.e, this.c) << 12) != 0;
        }
    }

    static interface b {
        public int a();

        public int a(View var1);

        public View a(int var1);

        public int b();

        public int b(View var1);
    }

}

