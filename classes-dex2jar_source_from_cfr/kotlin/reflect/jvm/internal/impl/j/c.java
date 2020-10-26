/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.Collection;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.i.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;

public abstract class c
implements an {
    private final f<a> a;

    public c(i i2) {
        j.b(i2, "storageManager");
        this.a = i2.a((kotlin.e.a.a)new kotlin.e.a.a<a>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final a b() {
                return new a(this.a());
            }
        }, c.a, (kotlin.e.a.b)new kotlin.e.a.b<a, kotlin.w>(){

            @Override
            public final void a(a a2) {
                j.b(a2, "supertypes");
                Object object = this.g().a(this, a2.b(), (kotlin.e.a.b<? super an, ? extends Iterable<? extends w>>)new kotlin.e.a.b<an, Collection<? extends w>>(){

                    @Override
                    public final Collection<w> a(an an2) {
                        j.b(an2, "it");
                        return this.a(an2, false);
                    }
                }, (kotlin.e.a.b<? super w, kotlin.w>)new kotlin.e.a.b<w, kotlin.w>(){

                    @Override
                    public final void a(w w2) {
                        j.b(w2, "it");
                        this.a(w2);
                    }
                });
                boolean bl2 = object.isEmpty();
                Collection<Object> collection = null;
                if (bl2) {
                    object = this.h();
                    object = object != null ? m.a(object) : null;
                    if (object == null) {
                        object = m.a();
                    }
                    object = (Collection)object;
                }
                this.g().a(this, (Collection<? extends w>)object, (kotlin.e.a.b<? super an, ? extends Iterable<? extends w>>)new kotlin.e.a.b<an, Collection<? extends w>>(){

                    @Override
                    public final Collection<w> a(an an2) {
                        j.b(an2, "it");
                        return this.a(an2, true);
                    }
                }, (kotlin.e.a.b<? super w, kotlin.w>)new kotlin.e.a.b<w, kotlin.w>(){

                    @Override
                    public final void a(w w2) {
                        j.b(w2, "it");
                        this.b(w2);
                    }
                });
                if (object instanceof List) {
                    collection = object;
                }
                object = collection != null ? collection : m.k((Iterable)object);
                a2.a((List<? extends w>)object);
            }

        });
    }

    private final Collection<w> a(an object, boolean bl2) {
        Object object2 = !(object instanceof c) ? null : object;
        object2 = (c)object2;
        if (object2 != null && (object2 = m.b(((a)((c)object2).a.a()).b(), (Iterable)((c)object2).a(bl2))) != null) {
            return (Collection)object2;
        }
        object = object.k_();
        j.a(object, "supertypes");
        return object;
    }

    protected abstract Collection<w> a();

    protected Collection<w> a(boolean bl2) {
        return m.a();
    }

    protected void a(w w2) {
        j.b(w2, "type");
    }

    protected void b(w w2) {
        j.b(w2, "type");
    }

    protected abstract aq g();

    protected w h() {
        return null;
    }

    public List<w> j() {
        return ((a)this.a.a()).a();
    }

    public /* synthetic */ Collection k_() {
        return this.j();
    }

    private static final class a {
        private List<? extends w> a;
        private final Collection<w> b;

        public a(Collection<? extends w> collection) {
            j.b(collection, "allSupertypes");
            this.b = collection;
            this.a = m.a(p.a);
        }

        public final List<w> a() {
            return this.a;
        }

        public final void a(List<? extends w> list) {
            j.b(list, "<set-?>");
            this.a = list;
        }

        public final Collection<w> b() {
            return this.b;
        }
    }

}

