/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.webview;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewErrorType;", "", "message", "", "actionText", "(Ljava/lang/String;III)V", "getActionText", "()I", "getMessage", "NONE", "WEBVIEW", "BEACON", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class f
extends Enum<f> {
    public static final /* enum */ f a;
    public static final /* enum */ f b;
    public static final /* enum */ f c;
    private static final /* synthetic */ f[] d;
    private final int e;
    private final int f;

    static {
        f f2;
        f f3;
        f f4;
        a = f3 = new f(-1, -1);
        b = f4 = new f(2131558475, 2131558555);
        c = f2 = new f(2131558476, 2131558566);
        d = new f[]{f3, f4, f2};
    }

    protected f(int n3, int n4) {
        this.e = n3;
        this.f = n4;
    }

    public static f valueOf(String string2) {
        return Enum.valueOf(f.class, string2);
    }

    public static f[] values() {
        return (f[])d.clone();
    }

    public final int a() {
        return this.e;
    }

    public final int b() {
        return this.f;
    }
}

