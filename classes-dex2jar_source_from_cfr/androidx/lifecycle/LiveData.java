/*
 * Decompiled with CFR 0.139.
 */
package androidx.lifecycle;

import androidx.a.a.b.b;
import androidx.lifecycle.f;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.j;
import androidx.lifecycle.q;
import java.util.Map;

public abstract class LiveData<T> {
    static final Object b = new Object();
    final Object a = new Object();
    int c = 0;
    volatile Object d = b;
    private androidx.a.a.b.b<q<? super T>, LiveData<T>> e = new androidx.a.a.b.b();
    private volatile Object f = b;
    private int g = -1;
    private boolean h;
    private boolean i;
    private final Runnable j = new Runnable(){

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void run() {
            Object object;
            Object object2 = LiveData.this.a;
            synchronized (object2) {
                object = LiveData.this.d;
                LiveData.this.d = LiveData.b;
            }
            LiveData.this.b(object);
        }
    };

    private static void a(String string2) {
        if (androidx.a.a.a.a.a().b()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot invoke ");
        stringBuilder.append(string2);
        stringBuilder.append(" on a background");
        stringBuilder.append(" thread");
        throw new IllegalStateException(stringBuilder.toString());
    }

    private void b(LiveData<T> liveData) {
        if (!((b)liveData).d) {
            return;
        }
        if (!((b)((Object)liveData)).a()) {
            ((b)((Object)liveData)).a(false);
            return;
        }
        if (((b)liveData).e >= this.g) {
            return;
        }
        ((b)liveData).e = this.g;
        ((b)liveData).c.a(this.f);
    }

    public T a() {
        Object object = this.f;
        if (object != b) {
            return (T)object;
        }
        return null;
    }

    void a(LiveData<T> liveData) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            LiveData<T> liveData2;
            block5 : {
                this.i = false;
                if (liveData != null) {
                    this.b((T)liveData);
                    liveData2 = null;
                } else {
                    b.d d2 = this.e.c();
                    do {
                        liveData2 = liveData;
                        if (!d2.hasNext()) break block5;
                        this.b((b)((Map.Entry)d2.next()).getValue());
                    } while (!this.i);
                    liveData2 = liveData;
                }
            }
            liveData = liveData2;
        } while (this.i);
        this.h = false;
    }

    public void a(j j2, q<? super T> object) {
        LiveData.a("observe");
        if (j2.g().a() == g.b.a) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(j2, object);
        if ((object = (b)((Object)this.e.a((q<T>)object, lifecycleBoundObserver))) != null && !((b)object).a(j2)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (object != null) {
            return;
        }
        j2.g().a(lifecycleBoundObserver);
    }

    public void a(q<? super T> object) {
        LiveData.a("observeForever");
        a a2 = new a(object);
        object = (b)((Object)this.e.a((q<T>)object, a2));
        if (object != null && object instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (object != null) {
            return;
        }
        a2.a(true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    protected void a(T t2) {
        Object object = this.a;
        // MONITORENTER : object
        boolean bl2 = this.d == b;
        this.d = t2;
        // MONITOREXIT : object
        if (!bl2) {
            return;
        }
        androidx.a.a.a.a.a().b(this.j);
    }

    int b() {
        return this.g;
    }

    public void b(q<? super T> object) {
        LiveData.a("removeObserver");
        object = (b)((Object)this.e.b((q<T>)object));
        if (object == null) {
            return;
        }
        ((b)object).b();
        ((b)object).a(false);
    }

    protected void b(T t2) {
        LiveData.a("setValue");
        ++this.g;
        this.f = t2;
        this.a((T)null);
    }

    protected void c() {
    }

    protected void d() {
    }

    public boolean e() {
        return this.c > 0;
    }

    class LifecycleBoundObserver
    extends LiveData<T>
    implements f {
        final j a;

        LifecycleBoundObserver(j j2, q<? super T> q2) {
            super(q2);
            this.a = j2;
        }

        @Override
        public void a(j j2, g.a a2) {
            if (this.a.g().a() == g.b.a) {
                LiveData.this.b(this.c);
                return;
            }
            this.a(this.a());
        }

        @Override
        boolean a() {
            return this.a.g().a().a(g.b.d);
        }

        boolean a(j j2) {
            return this.a == j2;
        }

        void b() {
            this.a.g().b(this);
        }
    }

    private class a
    extends LiveData<T> {
        a(q<? super T> q2) {
            super(q2);
        }

        @Override
        boolean a() {
            return true;
        }
    }

    private abstract class b {
        final q<? super T> c;
        boolean d;
        int e = -1;

        b(q<? super T> q2) {
            this.c = q2;
        }

        void a(boolean bl2) {
            if (bl2 == this.d) {
                return;
            }
            this.d = bl2;
            int n2 = LiveData.this.c;
            int n3 = 1;
            n2 = n2 == 0 ? 1 : 0;
            LiveData liveData = LiveData.this;
            int n4 = liveData.c;
            if (!this.d) {
                n3 = -1;
            }
            liveData.c = n4 + n3;
            if (n2 != 0 && this.d) {
                LiveData.this.c();
            }
            if (LiveData.this.c == 0 && !this.d) {
                LiveData.this.d();
            }
            if (this.d) {
                LiveData.this.a(this);
            }
        }

        abstract boolean a();

        boolean a(j j2) {
            return false;
        }

        void b() {
        }
    }

}

