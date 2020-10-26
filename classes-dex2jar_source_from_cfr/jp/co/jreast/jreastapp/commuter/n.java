/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import android.os.Handler;
import jp.co.jreast.jreastapp.commuter.a;

public final class n
implements c<Handler> {
    private final a a;

    public n(a a2) {
        this.a = a2;
    }

    public static Handler a(a a2) {
        return n.c(a2);
    }

    public static n b(a a2) {
        return new n(a2);
    }

    public static Handler c(a a2) {
        return f.a(a2.B(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public Handler a() {
        return n.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

