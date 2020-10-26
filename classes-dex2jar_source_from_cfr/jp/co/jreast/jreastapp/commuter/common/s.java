/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/ToresugoCharacters;", "", "resId", "", "lineName", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getResId", "()I", "KEIKO", "KEITO", "MUSASHIMARU", "NEX", "SAICHAN", "SOUKICHI", "TOKADON", "UCHIBO", "YOSSUI", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class s
extends Enum<s> {
    public static final /* enum */ s a;
    public static final /* enum */ s b;
    public static final /* enum */ s c;
    public static final /* enum */ s d;
    public static final /* enum */ s e;
    public static final /* enum */ s f;
    public static final /* enum */ s g;
    public static final /* enum */ s h;
    public static final /* enum */ s i;
    private static final /* synthetic */ s[] j;
    private final int k;

    static {
        s s2;
        s s3;
        s s4;
        s s5;
        s s6;
        s s7;
        s s8;
        s s9;
        s s10;
        a = s9 = new s(2131165431, "\u4eac\u8449\u7dda");
        b = s7 = new s(2131165432, "\u4eac\u6d5c\u6771\u5317\u7dda");
        c = s5 = new s(2131165434, "\u6b66\u8535\u91ce\u7dda");
        d = s2 = new s(2131165435, "\u6210\u7530\u30a8\u30af\u30b9\u30d7\u30ec\u30b9");
        e = s6 = new s(2131165438, "\u57fc\u4eac\u7dda");
        f = s8 = new s(2131165439, "\u7dcf\u6b66\u7dda");
        g = s4 = new s(2131165440, "\u6771\u6d77\u9053\u7dda");
        h = s3 = new s(2131165441, "\u5185\u623f\u7dda");
        i = s10 = new s(2131165443, "\u6a2a\u9808\u8cc0\u7dda");
        j = new s[]{s9, s7, s5, s2, s6, s8, s4, s3, s10};
    }

    protected s(int n3, String string3) {
        j.b(string3, "lineName");
        this.k = n3;
    }

    public static s valueOf(String string2) {
        return Enum.valueOf(s.class, string2);
    }

    public static s[] values() {
        return (s[])j.clone();
    }

    public final int a() {
        return this.k;
    }
}

