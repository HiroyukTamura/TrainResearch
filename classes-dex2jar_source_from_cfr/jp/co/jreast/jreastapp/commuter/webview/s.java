/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.webview;

import a.b.c;
import javax.a.a;
import jp.co.jreast.jreastapp.commuter.webview.b;
import jp.co.jreast.jreastapp.commuter.webview.r;

public final class s
implements c<r> {
    private final a<b> a;
    private final a<jp.co.jreast.jreastapp.commuter.m.b> b;

    public s(a<b> a2, a<jp.co.jreast.jreastapp.commuter.m.b> a3) {
        this.a = a2;
        this.b = a3;
    }

    public static r a(a<b> a2, a<jp.co.jreast.jreastapp.commuter.m.b> a3) {
        return new r(a2.b(), a3.b());
    }

    public static s b(a<b> a2, a<jp.co.jreast.jreastapp.commuter.m.b> a3) {
        return new s(a2, a3);
    }

    public r a() {
        return s.a(this.a, this.b);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

