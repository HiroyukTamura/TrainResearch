/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.b.a;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.b.a.e;
import kotlin.reflect.jvm.internal.impl.b.a.f;

public interface c {
    public void a(String var1, e var2, String var3, f var4, String var5);

    public boolean a();

    public static final class a
    implements c {
        public static final a a = new a();

        private a() {
        }

        @Override
        public void a(String string2, e e2, String string3, f f2, String string4) {
            j.b(string2, "filePath");
            j.b(e2, "position");
            j.b(string3, "scopeFqName");
            j.b((Object)f2, "scopeKind");
            j.b(string4, "name");
        }

        @Override
        public boolean a() {
            return false;
        }
    }

}

