/*
 * Decompiled with CFR 0.139.
 */
package androidx.lifecycle;

import androidx.a.a.b.b;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import java.util.Iterator;
import java.util.Map;

public class n<T>
extends p<T> {
    private b<LiveData<?>, a<?>> e = new b();

    @Override
    public <S> void a(LiveData<S> object) {
        if ((object = this.e.b((LiveData<?>)object)) != null) {
            ((a)object).b();
        }
    }

    public <S> void a(LiveData<S> object, q<? super S> q2) {
        a<S> a2 = new a<S>((LiveData<S>)object, (q<S>)q2);
        if ((object = this.e.a((LiveData<?>)object, a2)) != null && ((a)object).b != q2) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (object != null) {
            return;
        }
        if (this.e()) {
            a2.a();
        }
    }

    @Override
    protected void c() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> iterator = this.e.iterator();
        while (iterator.hasNext()) {
            iterator.next().getValue().a();
        }
    }

    @Override
    protected void d() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> iterator = this.e.iterator();
        while (iterator.hasNext()) {
            iterator.next().getValue().b();
        }
    }

    private static class a<V>
    implements q<V> {
        final LiveData<V> a;
        final q<? super V> b;
        int c = -1;

        a(LiveData<V> liveData, q<? super V> q2) {
            this.a = liveData;
            this.b = q2;
        }

        void a() {
            this.a.a((V)this);
        }

        @Override
        public void a(V v2) {
            if (this.c != this.a.b()) {
                this.c = this.a.b();
                this.b.a(v2);
            }
        }

        void b() {
            this.a.b((V)this);
        }
    }

}

