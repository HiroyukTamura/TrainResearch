/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/LinkType;", "", "(Ljava/lang/String;I)V", "WEBVIEW", "SYSTEM", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class i
extends Enum<i> {
    public static final /* enum */ i a;
    public static final /* enum */ i b;
    private static final /* synthetic */ i[] c;

    static {
        i i2;
        i i3;
        a = i2 = new i();
        b = i3 = new i();
        c = new i[]{i2, i3};
    }

    public static i valueOf(String string2) {
        return Enum.valueOf(i.class, string2);
    }

    public static i[] values() {
        return (i[])c.clone();
    }
}

