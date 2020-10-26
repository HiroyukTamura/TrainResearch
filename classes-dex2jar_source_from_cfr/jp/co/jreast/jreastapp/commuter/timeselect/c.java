/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package jp.co.jreast.jreastapp.commuter.timeselect;

import android.os.Handler;
import javax.a.a;
import jp.co.jreast.jreastapp.commuter.timeselect.b;

public final class c
implements a.b.c<b> {
    private final a<jp.co.jreast.jreastapp.commuter.d.a> a;
    private final a<Handler> b;

    public c(a<jp.co.jreast.jreastapp.commuter.d.a> a2, a<Handler> a3) {
        this.a = a2;
        this.b = a3;
    }

    public static b a(a<jp.co.jreast.jreastapp.commuter.d.a> a2, a<Handler> a3) {
        return new b(a2.b(), a3.b());
    }

    public static c b(a<jp.co.jreast.jreastapp.commuter.d.a> a2, a<Handler> a3) {
        return new c(a2, a3);
    }

    public b a() {
        return c.a(this.a, this.b);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

