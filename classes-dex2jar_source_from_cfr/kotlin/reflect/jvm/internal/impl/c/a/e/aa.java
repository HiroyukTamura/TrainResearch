/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.e;

public final class aa
extends Enum<aa> {
    public static final /* enum */ aa a;
    public static final /* enum */ aa b;
    private static final /* synthetic */ aa[] c;

    static {
        aa aa2;
        aa aa3;
        a = aa2 = new aa();
        b = aa3 = new aa();
        c = new aa[]{aa2, aa3};
    }

    public static aa valueOf(String string2) {
        return Enum.valueOf(aa.class, string2);
    }

    public static aa[] values() {
        return (aa[])c.clone();
    }
}

