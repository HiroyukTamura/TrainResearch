/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.h;

import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.j;
import kotlin.reflect.jvm.internal.impl.j.a.c;
import kotlin.reflect.jvm.internal.impl.j.an;

public final class a {
    public static final a a = new a();

    private a() {
    }

    private final boolean a(as as2, as as3, kotlin.e.a.m<? super m, ? super m, Boolean> m2) {
        if (kotlin.e.b.j.a((Object)as2, (Object)as3)) {
            return true;
        }
        if (kotlin.e.b.j.a((Object)as2.b(), (Object)as3.b())) {
            return false;
        }
        if (!this.a((m)as2, (m)as3, m2)) {
            return false;
        }
        return as2.g() == as3.g();
    }

    private final boolean a(e e2, e e3) {
        return kotlin.e.b.j.a((Object)e2.e(), (Object)e3.e());
    }

    private final boolean a(m m2, m m3, kotlin.e.a.m<? super m, ? super m, Boolean> m4) {
        m2 = m2.b();
        m3 = m3.b();
        if (!(m2 instanceof kotlin.reflect.jvm.internal.impl.a.b) && !(m3 instanceof kotlin.reflect.jvm.internal.impl.a.b)) {
            return this.a(m2, m3);
        }
        return m4.a(m2, m3);
    }

    public static /* bridge */ /* synthetic */ boolean a(a a2, kotlin.reflect.jvm.internal.impl.a.a a3, kotlin.reflect.jvm.internal.impl.a.a a4, boolean bl2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        return a2.a(a3, a4, bl2);
    }

    static /* bridge */ /* synthetic */ boolean a(a a2, as as2, as as3, kotlin.e.a.m m2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            m2 = c.a;
        }
        return a2.a(as2, as3, (kotlin.e.a.m<? super m, ? super m, Boolean>)m2);
    }

    public final boolean a(kotlin.reflect.jvm.internal.impl.a.a object, kotlin.reflect.jvm.internal.impl.a.a a2, boolean bl2) {
        kotlin.e.b.j.b(object, "a");
        kotlin.e.b.j.b(a2, "b");
        if (kotlin.e.b.j.a(object, (Object)a2)) {
            return true;
        }
        if (kotlin.e.b.j.a((Object)object.h_(), (Object)a2.h_()) ^ true) {
            return false;
        }
        if (kotlin.e.b.j.a((Object)object.b(), (Object)a2.b())) {
            return false;
        }
        Object object2 = (m)object;
        if (!kotlin.reflect.jvm.internal.impl.h.c.b((m)object2)) {
            Object object3 = a2;
            if (kotlin.reflect.jvm.internal.impl.h.c.b((m)object3)) {
                return false;
            }
            if (!this.a((m)object2, (m)object3, (kotlin.e.a.m<? super m, ? super m, Boolean>)a.a)) {
                return false;
            }
            object2 = j.a(new c.a((kotlin.reflect.jvm.internal.impl.a.a)object, a2){
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.a a;
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.a b;
                {
                    this.a = a2;
                    this.b = a3;
                }

                @Override
                public /* synthetic */ boolean a(an an2, an an3) {
                    return this.b(an2, an3);
                }

                public final boolean b(an object, an object2) {
                    kotlin.e.b.j.b(object, "c1");
                    kotlin.e.b.j.b(object2, "c2");
                    if (kotlin.e.b.j.a(object, object2)) {
                        return true;
                    }
                    object = object.d();
                    object2 = object2.d();
                    if (object instanceof as && object2 instanceof as) {
                        return a.a.a((as)object, (as)object2, (kotlin.e.a.m<? super m, ? super m, Boolean>)new kotlin.e.a.m<m, m, Boolean>(){

                            @Override
                            public /* synthetic */ Object a(Object object, Object object2) {
                                return this.a((m)object, (m)object2);
                            }

                            @Override
                            public final boolean a(m m2, m m3) {
                                return kotlin.e.b.j.a((Object)m2, (Object)this.a) && kotlin.e.b.j.a((Object)m3, (Object)this.b);
                            }
                        });
                    }
                    return false;
                }

            });
            object3 = ((j)object2).a((kotlin.reflect.jvm.internal.impl.a.a)object, a2, null, bl2 ^ true);
            kotlin.e.b.j.a(object3, "overridingUtil.isOverrid\u2026 null, !ignoreReturnType)");
            if (((j.a)object3).b() == j.a.a.a) {
                object = ((j)object2).a(a2, (kotlin.reflect.jvm.internal.impl.a.a)object, null, bl2 ^ true);
                kotlin.e.b.j.a(object, "overridingUtil.isOverrid\u2026 null, !ignoreReturnType)");
                if (((j.a)object).b() == j.a.a.a) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final boolean a(m m2, m m3) {
        if (m2 instanceof e && m3 instanceof e) {
            return this.a((e)m2, (e)m3);
        }
        if (m2 instanceof as && m3 instanceof as) {
            return a.a(this, (as)m2, (as)m3, null, 4, null);
        }
        if (m2 instanceof kotlin.reflect.jvm.internal.impl.a.a && m3 instanceof kotlin.reflect.jvm.internal.impl.a.a) {
            return a.a(this, (kotlin.reflect.jvm.internal.impl.a.a)m2, (kotlin.reflect.jvm.internal.impl.a.a)m3, false, 4, null);
        }
        Object object = m2;
        Object object2 = m3;
        if (m2 instanceof ab) {
            object = m2;
            object2 = m3;
            if (m3 instanceof ab) {
                object = ((ab)m2).f();
                object2 = ((ab)m3).f();
            }
        }
        return kotlin.e.b.j.a(object, object2);
    }

}

