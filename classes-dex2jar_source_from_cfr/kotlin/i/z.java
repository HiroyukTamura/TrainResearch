/*
 * Decompiled with CFR 0.139.
 */
package kotlin.i;

import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2={"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
final class z {
    public static final String a;
    public static final z b;

    static {
        b = new z();
        String string2 = System.getProperty("line.separator");
        if (string2 == null) {
            j.a();
        }
        a = string2;
    }

    private z() {
    }
}

