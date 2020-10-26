/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class f
implements Runnable {
    static final ThreadLocal<f> a = new ThreadLocal();
    static Comparator<b> e = new Comparator<b>(){

        public int a(b b2, b b3) {
            int n2;
            RecyclerView recyclerView = b2.d;
            int n3 = 1;
            int n4 = recyclerView == null ? 1 : 0;
            if (n4 != (n2 = b3.d == null)) {
                if (b2.d == null) {
                    return 1;
                }
                return -1;
            }
            if (b2.a != b3.a) {
                n4 = n3;
                if (b2.a) {
                    n4 = -1;
                }
                return n4;
            }
            n4 = b3.b - b2.b;
            if (n4 != 0) {
                return n4;
            }
            n4 = b2.c - b3.c;
            if (n4 != 0) {
                return n4;
            }
            return 0;
        }

        @Override
        public /* synthetic */ int compare(Object object, Object object2) {
            return this.a((b)object, (b)object2);
        }
    };
    ArrayList<RecyclerView> b = new ArrayList();
    long c;
    long d;
    private ArrayList<b> f = new ArrayList();

    f() {
    }

    private RecyclerView.x a(RecyclerView recyclerView, int n2, long l2) {
        RecyclerView.x x2;
        block6 : {
            if (f.a(recyclerView, n2)) {
                return null;
            }
            RecyclerView.p p2 = recyclerView.e;
            recyclerView.m();
            x2 = p2.a(n2, false, l2);
            if (x2 == null) break block6;
            if (x2.p() && !x2.n()) {
                p2.a(x2.a);
                break block6;
            }
            p2.a(x2, false);
        }
        return x2;
        finally {
            recyclerView.b(false);
        }
    }

    private void a() {
        int n2;
        int n3;
        Object object;
        int n4 = this.b.size();
        int n5 = 0;
        for (n3 = 0; n3 < n4; ++n3) {
            object = this.b.get(n3);
            n2 = n5;
            if (object.getWindowVisibility() == 0) {
                ((RecyclerView)object).C.a((RecyclerView)object, false);
                n2 = n5 + object.C.d;
            }
            n5 = n2;
        }
        this.f.ensureCapacity(n5);
        n3 = 0;
        for (n5 = 0; n5 < n4; ++n5) {
            RecyclerView recyclerView = this.b.get(n5);
            if (recyclerView.getWindowVisibility() != 0) continue;
            a a2 = recyclerView.C;
            int n6 = Math.abs(a2.a) + Math.abs(a2.b);
            for (n2 = 0; n2 < a2.d * 2; n2 += 2) {
                if (n3 >= this.f.size()) {
                    object = new b();
                    this.f.add((b)object);
                } else {
                    object = this.f.get(n3);
                }
                int n7 = a2.c[n2 + 1];
                boolean bl2 = n7 <= n6;
                ((b)object).a = bl2;
                ((b)object).b = n6;
                ((b)object).c = n7;
                ((b)object).d = recyclerView;
                ((b)object).e = a2.c[n2];
                ++n3;
            }
        }
        Collections.sort(this.f, e);
    }

    private void a(RecyclerView recyclerView, long l2) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.x && recyclerView.g.c() != 0) {
            recyclerView.c();
        }
        a a2 = recyclerView.C;
        a2.a(recyclerView, true);
        if (a2.d != 0) {
            int n2;
            try {
                androidx.core.d.a.a("RV Nested Prefetch");
                recyclerView.D.a(recyclerView.m);
                n2 = 0;
            }
            catch (Throwable throwable) {
                androidx.core.d.a.a();
                throw throwable;
            }
            do {
                if (n2 >= a2.d * 2) break;
                this.a(recyclerView, a2.c[n2], l2);
                n2 += 2;
            } while (true);
            androidx.core.d.a.a();
            return;
        }
    }

    private void a(b object, long l2) {
        long l3 = ((b)object).a ? Long.MAX_VALUE : l2;
        object = this.a(((b)object).d, ((b)object).e, l3);
        if (object != null && ((RecyclerView.x)object).b != null && ((RecyclerView.x)object).p() && !((RecyclerView.x)object).n()) {
            this.a((RecyclerView)((RecyclerView.x)object).b.get(), l2);
        }
    }

    static boolean a(RecyclerView recyclerView, int n2) {
        int n3 = recyclerView.g.c();
        for (int i2 = 0; i2 < n3; ++i2) {
            RecyclerView.x x2 = RecyclerView.e(recyclerView.g.d(i2));
            if (x2.c != n2 || x2.n()) continue;
            return true;
        }
        return false;
    }

    private void b(long l2) {
        for (int i2 = 0; i2 < this.f.size(); ++i2) {
            b b2 = this.f.get(i2);
            if (b2.d == null) {
                return;
            }
            this.a(b2, l2);
            b2.a();
        }
    }

    void a(long l2) {
        this.a();
        this.b(l2);
    }

    public void a(RecyclerView recyclerView) {
        this.b.add(recyclerView);
    }

    void a(RecyclerView recyclerView, int n2, int n3) {
        if (recyclerView.isAttachedToWindow() && this.c == 0L) {
            this.c = recyclerView.getNanoTime();
            recyclerView.post((Runnable)this);
        }
        recyclerView.C.a(n2, n3);
    }

    public void b(RecyclerView recyclerView) {
        this.b.remove(recyclerView);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        block6 : {
            int n2;
            long l2;
            try {
                androidx.core.d.a.a("RV Prefetch");
                boolean bl2 = this.b.isEmpty();
                if (bl2) break block6;
                n2 = this.b.size();
                l2 = 0L;
            }
            catch (Throwable throwable) {
                this.c = 0L;
                androidx.core.d.a.a();
                throw throwable;
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                RecyclerView recyclerView = this.b.get(i2);
                long l3 = l2;
                if (recyclerView.getWindowVisibility() == 0) {
                    l3 = Math.max(recyclerView.getDrawingTime(), l2);
                }
                l2 = l3;
            }
            if (l2 != 0L) {
                this.a(TimeUnit.MILLISECONDS.toNanos(l2) + this.d);
                this.c = 0L;
                androidx.core.d.a.a();
                return;
            }
        }
        this.c = 0L;
        androidx.core.d.a.a();
    }

    static class a
    implements RecyclerView.i.a {
        int a;
        int b;
        int[] c;
        int d;

        a() {
        }

        void a() {
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            this.d = 0;
        }

        void a(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }

        void a(RecyclerView recyclerView, boolean bl2) {
            this.d = 0;
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            RecyclerView.i i2 = recyclerView.n;
            if (recyclerView.m != null && i2 != null && i2.p()) {
                if (bl2) {
                    if (!recyclerView.f.d()) {
                        i2.a(recyclerView.m.a(), this);
                    }
                } else if (!recyclerView.w()) {
                    i2.a(this.a, this.b, recyclerView.D, this);
                }
                if (this.d > i2.x) {
                    i2.x = this.d;
                    i2.y = bl2;
                    recyclerView.e.b();
                }
            }
        }

        boolean a(int n2) {
            if (this.c != null) {
                int n3 = this.d;
                for (int i2 = 0; i2 < n3 * 2; i2 += 2) {
                    if (this.c[i2] != n2) continue;
                    return true;
                }
            }
            return false;
        }

        @Override
        public void b(int n2, int n3) {
            if (n2 >= 0) {
                if (n3 >= 0) {
                    int n4 = this.d * 2;
                    if (this.c == null) {
                        this.c = new int[4];
                        Arrays.fill(this.c, -1);
                    } else if (n4 >= this.c.length) {
                        int[] arrn = this.c;
                        this.c = new int[n4 * 2];
                        System.arraycopy(arrn, 0, this.c, 0, arrn.length);
                    }
                    this.c[n4] = n2;
                    this.c[n4 + 1] = n3;
                    ++this.d;
                    return;
                }
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
    }

    static class b {
        public boolean a;
        public int b;
        public int c;
        public RecyclerView d;
        public int e;

        b() {
        }

        public void a() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

}

