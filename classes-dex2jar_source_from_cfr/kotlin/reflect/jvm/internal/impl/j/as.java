/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;

public abstract class as {
    public static final as d;
    public static final a e;

    static {
        e = new a(null);
        d = new as(){

            public Void a(w w2) {
                j.b(w2, "key");
                return null;
            }

            @Override
            public boolean a() {
                return true;
            }

            @Override
            public /* synthetic */ ap b(w w2) {
                return (ap)((Object)this.a(w2));
            }

            public String toString() {
                return "Empty TypeSubstitution";
            }
        };
    }

    public h a(h h2) {
        j.b(h2, "annotations");
        return h2;
    }

    public w a(w w2, ba ba2) {
        j.b(w2, "topLevelType");
        j.b((Object)ba2, "position");
        return w2;
    }

    public boolean a() {
        return false;
    }

    public abstract ap b(w var1);

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public final au f() {
        au au2 = au.a(this);
        j.a((Object)au2, "TypeSubstitutor.create(this)");
        return au2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

