/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.common;

import kotlin.Metadata;
import kotlin.e.b.g;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\f"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/StationType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEPARTURE", "ARRIVAL", "VIA1", "VIA2", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class r
extends Enum<r> {
    public static final /* enum */ r a;
    public static final /* enum */ r b;
    public static final /* enum */ r c;
    public static final /* enum */ r d;
    public static final a e;
    private static final /* synthetic */ r[] f;
    private final int g;

    static {
        r r2;
        r r3;
        r r4;
        r r5;
        a = r3 = new r(0);
        b = r4 = new r(1);
        c = r5 = new r(2);
        d = r2 = new r(3);
        f = new r[]{r3, r4, r5, r2};
        e = new a(null);
    }

    protected r(int n3) {
        this.g = n3;
    }

    public static r valueOf(String string2) {
        return Enum.valueOf(r.class, string2);
    }

    public static r[] values() {
        return (r[])f.clone();
    }

    public final int a() {
        return this.g;
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/StationType$Companion;", "", "()V", "getName", "", "value", "", "app_productRelease"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final String a(int n2) {
            switch (n2) {
                default: {
                    return "\u51fa\u767a";
                }
                case 3: {
                    return "\u7d4c\u75312";
                }
                case 2: {
                    return "\u7d4c\u75311";
                }
                case 1: 
            }
            return "\u5230\u7740";
        }
    }

}

