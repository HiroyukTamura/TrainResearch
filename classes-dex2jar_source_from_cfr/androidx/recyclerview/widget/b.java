/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class b {
    final b a;
    final a b;
    final List<View> c;

    b(b b2) {
        this.a = b2;
        this.b = new a();
        this.c = new ArrayList<View>();
    }

    private int f(int n2) {
        int n3;
        if (n2 < 0) {
            return -1;
        }
        int n4 = this.a.a();
        for (int i2 = n2; i2 < n4; i2 += n3) {
            n3 = n2 - (i2 - this.b.e(i2));
            if (n3 != 0) continue;
            while (this.b.c(i2)) {
                ++i2;
            }
            return i2;
        }
        return -1;
    }

    private void g(View view) {
        this.c.add(view);
        this.a.c(view);
    }

    private boolean h(View view) {
        if (this.c.remove((Object)view)) {
            this.a.d(view);
            return true;
        }
        return false;
    }

    void a() {
        this.b.a();
        for (int i2 = this.c.size() - 1; i2 >= 0; --i2) {
            this.a.d(this.c.get(i2));
            this.c.remove(i2);
        }
        this.a.b();
    }

    void a(int n2) {
        View view = this.a.b(n2 = this.f(n2));
        if (view == null) {
            return;
        }
        if (this.b.d(n2)) {
            this.h(view);
        }
        this.a.a(n2);
    }

    void a(View view) {
        int n2 = this.a.a(view);
        if (n2 < 0) {
            return;
        }
        if (this.b.d(n2)) {
            this.h(view);
        }
        this.a.a(n2);
    }

    void a(View view, int n2, ViewGroup.LayoutParams layoutParams, boolean bl2) {
        n2 = n2 < 0 ? this.a.a() : this.f(n2);
        this.b.a(n2, bl2);
        if (bl2) {
            this.g(view);
        }
        this.a.a(view, n2, layoutParams);
    }

    void a(View view, int n2, boolean bl2) {
        n2 = n2 < 0 ? this.a.a() : this.f(n2);
        this.b.a(n2, bl2);
        if (bl2) {
            this.g(view);
        }
        this.a.a(view, n2);
    }

    void a(View view, boolean bl2) {
        this.a(view, -1, bl2);
    }

    int b() {
        return this.a.a() - this.c.size();
    }

    int b(View view) {
        int n2 = this.a.a(view);
        if (n2 == -1) {
            return -1;
        }
        if (this.b.c(n2)) {
            return -1;
        }
        return n2 - this.b.e(n2);
    }

    View b(int n2) {
        n2 = this.f(n2);
        return this.a.b(n2);
    }

    int c() {
        return this.a.a();
    }

    View c(int n2) {
        int n3 = this.c.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            View view = this.c.get(i2);
            RecyclerView.x x2 = this.a.b(view);
            if (x2.d() != n2 || x2.n() || x2.q()) continue;
            return view;
        }
        return null;
    }

    boolean c(View view) {
        return this.c.contains((Object)view);
    }

    View d(int n2) {
        return this.a.b(n2);
    }

    void d(View view) {
        int n2 = this.a.a(view);
        if (n2 >= 0) {
            this.b.a(n2);
            this.g(view);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("view is not a child, cannot hide ");
        stringBuilder.append((Object)view);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    void e(int n2) {
        n2 = this.f(n2);
        this.b.d(n2);
        this.a.c(n2);
    }

    void e(View view) {
        int n2 = this.a.a(view);
        if (n2 >= 0) {
            if (this.b.c(n2)) {
                this.b.b(n2);
                this.h(view);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trying to unhide a view that was not hidden");
            stringBuilder.append((Object)view);
            throw new RuntimeException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("view is not a child, cannot hide ");
        stringBuilder.append((Object)view);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    boolean f(View view) {
        int n2 = this.a.a(view);
        if (n2 == -1) {
            this.h(view);
            return true;
        }
        if (this.b.c(n2)) {
            this.b.d(n2);
            this.h(view);
            this.a.a(n2);
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.toString());
        stringBuilder.append(", hidden list:");
        stringBuilder.append(this.c.size());
        return stringBuilder.toString();
    }

    static class a {
        long a = 0L;
        a b;

        a() {
        }

        private void b() {
            if (this.b == null) {
                this.b = new a();
            }
        }

        void a() {
            this.a = 0L;
            if (this.b != null) {
                this.b.a();
            }
        }

        void a(int n2) {
            if (n2 >= 64) {
                this.b();
                this.b.a(n2 - 64);
                return;
            }
            this.a |= 1L << n2;
        }

        void a(int n2, boolean bl2) {
            if (n2 >= 64) {
                this.b();
                this.b.a(n2 - 64, bl2);
                return;
            }
            boolean bl3 = (this.a & Long.MIN_VALUE) != 0L;
            long l2 = (1L << n2) - 1L;
            this.a = this.a & l2 | (l2 & this.a) << 1;
            if (bl2) {
                this.a(n2);
            } else {
                this.b(n2);
            }
            if (bl3 || this.b != null) {
                this.b();
                this.b.a(0, bl3);
            }
        }

        void b(int n2) {
            if (n2 >= 64) {
                if (this.b != null) {
                    this.b.b(n2 - 64);
                    return;
                }
            } else {
                this.a &= 1L << n2;
            }
        }

        boolean c(int n2) {
            if (n2 >= 64) {
                this.b();
                return this.b.c(n2 - 64);
            }
            return (this.a & 1L << n2) != 0L;
        }

        boolean d(int n2) {
            if (n2 >= 64) {
                this.b();
                return this.b.d(n2 - 64);
            }
            long l2 = 1L << n2;
            boolean bl2 = (this.a & l2) != 0L;
            this.a &= l2;
            this.a = this.a & --l2 | Long.rotateRight(l2 & this.a, 1);
            if (this.b != null) {
                if (this.b.c(0)) {
                    this.a(63);
                }
                this.b.d(0);
            }
            return bl2;
        }

        int e(int n2) {
            if (this.b == null) {
                if (n2 >= 64) {
                    return Long.bitCount(this.a);
                }
                return Long.bitCount(this.a & (1L << n2) - 1L);
            }
            if (n2 < 64) {
                return Long.bitCount(this.a & (1L << n2) - 1L);
            }
            return this.b.e(n2 - 64) + Long.bitCount(this.a);
        }

        public String toString() {
            if (this.b == null) {
                return Long.toBinaryString(this.a);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b.toString());
            stringBuilder.append("xx");
            stringBuilder.append(Long.toBinaryString(this.a));
            return stringBuilder.toString();
        }
    }

    static interface b {
        public int a();

        public int a(View var1);

        public void a(int var1);

        public void a(View var1, int var2);

        public void a(View var1, int var2, ViewGroup.LayoutParams var3);

        public View b(int var1);

        public RecyclerView.x b(View var1);

        public void b();

        public void c(int var1);

        public void c(View var1);

        public void d(View var1);
    }

}

