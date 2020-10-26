/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.webview;

import a.b.c;
import javax.a.a;
import jp.co.jreast.jreastapp.commuter.common.q;
import jp.co.jreast.jreastapp.commuter.m.d;
import jp.co.jreast.jreastapp.commuter.m.f;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.u;
import jp.co.jreast.jreastapp.commuter.webview.b;
import jp.co.jreast.jreastapp.commuter.webview.j;

public final class k
implements c<j> {
    private final a<b> a;
    private final a<d> b;
    private final a<jp.co.jreast.jreastapp.commuter.m.b> c;
    private final a<f> d;
    private final a<q> e;
    private final a<u> f;
    private final a<p> g;
    private final a<jp.co.jreast.jreastapp.commuter.e.a> h;

    public k(a<b> a2, a<d> a3, a<jp.co.jreast.jreastapp.commuter.m.b> a4, a<f> a5, a<q> a6, a<u> a7, a<p> a8, a<jp.co.jreast.jreastapp.commuter.e.a> a9) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
        this.d = a5;
        this.e = a6;
        this.f = a7;
        this.g = a8;
        this.h = a9;
    }

    public static j a(a<b> a2, a<d> a3, a<jp.co.jreast.jreastapp.commuter.m.b> a4, a<f> a5, a<q> a6, a<u> a7, a<p> a8, a<jp.co.jreast.jreastapp.commuter.e.a> a9) {
        return new j(a2.b(), a3.b(), a4.b(), a5.b(), a6.b(), a7.b(), a8.b(), a9.b());
    }

    public static k b(a<b> a2, a<d> a3, a<jp.co.jreast.jreastapp.commuter.m.b> a4, a<f> a5, a<q> a6, a<u> a7, a<p> a8, a<jp.co.jreast.jreastapp.commuter.e.a> a9) {
        return new k(a2, a3, a4, a5, a6, a7, a8, a9);
    }

    public j a() {
        return k.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

