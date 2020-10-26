/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/LocalCacheKeys;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "DELAYED_KANTO_IMAGE", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class j
extends Enum<j> {
    public static final /* enum */ j a;
    private static final /* synthetic */ j[] b;
    private final String c;

    static {
        j j2;
        a = j2 = new j("delayed_kanto_image");
        b = new j[]{j2};
    }

    protected j(String string3) {
        kotlin.e.b.j.b(string3, "key");
        this.c = string3;
    }

    public static j valueOf(String string2) {
        return Enum.valueOf(j.class, string2);
    }

    public static j[] values() {
        return (j[])b.clone();
    }

    public final String a() {
        return this.c;
    }
}

