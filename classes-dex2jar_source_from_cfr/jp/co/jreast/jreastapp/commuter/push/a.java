/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.push;

import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nj\u0002\b\u000f\u00a8\u0006\u0010"}, d2={"Ljp/co/jreast/jreastapp/commuter/push/PushKeys;", "", "notifyGroupId", "", "key", "titleResId", "", "urlPath", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getNotifyGroupId", "getTitleResId", "()I", "getUrlPath", "MAMORAIL", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a
extends Enum<a> {
    public static final /* enum */ a a;
    private static final /* synthetic */ a[] b;
    private final String c;
    private final String d;
    private final int e;
    private final String f;

    static {
        a a2;
        a = a2 = new a("jp.co.jreast.jreastapp.fcm.mamorail", "32130001", 2131558524, "ks01/GatePassageNotice/member/noticeHistory?user_id=%uid%");
        b = new a[]{a2};
    }

    protected a(String string3, String string4, int n3, String string5) {
        j.b(string3, "notifyGroupId");
        j.b(string4, "key");
        j.b(string5, "urlPath");
        this.c = string3;
        this.d = string4;
        this.e = n3;
        this.f = string5;
    }

    public static a valueOf(String string2) {
        return Enum.valueOf(a.class, string2);
    }

    public static a[] values() {
        return (a[])b.clone();
    }

    public final String a() {
        return this.d;
    }

    public final int b() {
        return this.e;
    }

    public final String c() {
        return this.f;
    }
}

