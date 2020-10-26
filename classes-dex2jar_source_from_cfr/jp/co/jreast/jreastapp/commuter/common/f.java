/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/LineIconPosition;", "", "(Ljava/lang/String;I)V", "TOP", "MIDDLE", "BOTTOM", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class f
extends Enum<f> {
    public static final /* enum */ f a;
    public static final /* enum */ f b;
    public static final /* enum */ f c;
    private static final /* synthetic */ f[] d;

    static {
        f f2;
        f f3;
        f f4;
        a = f3 = new f();
        b = f4 = new f();
        c = f2 = new f();
        d = new f[]{f3, f4, f2};
    }

    public static f valueOf(String string2) {
        return Enum.valueOf(f.class, string2);
    }

    public static f[] values() {
        return (f[])d.clone();
    }
}

