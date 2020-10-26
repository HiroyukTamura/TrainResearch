/*
 * Decompiled with CFR 0.139.
 */
package androidx.h.a;

import androidx.h.a.b;
import androidx.lifecycle.j;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {
    public static <T extends j & z> a a(T t2) {
        return new b(t2, ((z)t2).i());
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

    public static interface a<D> {
        public void a(androidx.h.b.a<D> var1);

        public void a(androidx.h.b.a<D> var1, D var2);
    }

}

