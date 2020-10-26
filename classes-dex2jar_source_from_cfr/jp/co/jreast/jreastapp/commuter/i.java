/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter;

import a.b.c;
import a.b.f;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.webview.b;

public final class i
implements c<b> {
    private final a a;

    public i(a a2) {
        this.a = a2;
    }

    public static b a(a a2) {
        return i.c(a2);
    }

    public static i b(a a2) {
        return new i(a2);
    }

    public static b c(a a2) {
        return f.a(a2.H(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public b a() {
        return i.a(this.a);
    }

    public /* synthetic */ Object b() {
        return this.a();
    }
}

