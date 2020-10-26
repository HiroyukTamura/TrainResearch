/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.al;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.c.h;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.e.c;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.l;

public final class d
implements kotlin.reflect.jvm.internal.impl.a.b.b {
    static final /* synthetic */ l[] a;
    public static final a b;
    private static final kotlin.reflect.jvm.internal.impl.e.b f;
    private static final f g;
    private static final kotlin.reflect.jvm.internal.impl.e.a h;
    private final kotlin.reflect.jvm.internal.impl.i.f c;
    private final y d;
    private final kotlin.e.a.b<y, kotlin.reflect.jvm.internal.impl.a.m> e;

    static {
        a = new l[]{v.a(new t(v.a(d.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
        b = new a(null);
        f = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
        g = KotlinBuiltIns.FQ_NAMES.cloneable.f();
        h = kotlin.reflect.jvm.internal.impl.e.a.a(KotlinBuiltIns.FQ_NAMES.cloneable.c());
    }

    public d(final i i2, y y2, kotlin.e.a.b<? super y, ? extends kotlin.reflect.jvm.internal.impl.a.m> b2) {
        j.b(i2, "storageManager");
        j.b(y2, "moduleDescriptor");
        j.b(b2, "computeContainingDeclaration");
        this.d = y2;
        this.e = b2;
        this.c = i2.a((kotlin.e.a.a)new kotlin.e.a.a<h>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final h b() {
                h h2 = new h((kotlin.reflect.jvm.internal.impl.a.m)this.e.a(this.d), g, w.d, kotlin.reflect.jvm.internal.impl.a.f.b, (Collection<kotlin.reflect.jvm.internal.impl.j.w>)m.a(this.d.a().getAnyType()), an.a, false, i2);
                h2.a(new kotlin.reflect.jvm.internal.impl.builtins.b.a(i2, h2), al.<kotlin.reflect.jvm.internal.impl.a.d>a(), null);
                return h2;
            }
        });
    }

    public /* synthetic */ d(i i2, y y2, kotlin.e.a.b b2, int n2, g g2) {
        if ((n2 & 4) != 0) {
            b2 = 1.a;
        }
        this(i2, y2, b2);
    }

    private final h d() {
        return (h)kotlin.reflect.jvm.internal.impl.i.h.a(this.c, (Object)this, a[0]);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Collection<kotlin.reflect.jvm.internal.impl.a.e> a(kotlin.reflect.jvm.internal.impl.e.b set) {
        j.b(set, "packageFqName");
        if (j.a(set, (Object)f)) {
            set = al.a(this.d());
            do {
                return set;
                break;
            } while (true);
        }
        set = al.a();
        return set;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.e a(kotlin.reflect.jvm.internal.impl.e.a a2) {
        j.b(a2, "classId");
        if (j.a((Object)a2, (Object)h)) {
            return this.d();
        }
        return null;
    }

    @Override
    public boolean a(kotlin.reflect.jvm.internal.impl.e.b b2, f f2) {
        j.b(b2, "packageFqName");
        j.b(f2, "name");
        return j.a((Object)f2, (Object)g) && j.a((Object)b2, (Object)f);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final kotlin.reflect.jvm.internal.impl.e.a a() {
            return h;
        }
    }

}

