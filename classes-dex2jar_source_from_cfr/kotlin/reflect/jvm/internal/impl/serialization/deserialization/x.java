/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.e.b.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.f;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.y;

public final class x {
    public static final x a = new x();

    private x() {
    }

    public final b.a a(a.q q2) {
        if (q2 != null) {
            switch (y.a[q2.ordinal()]) {
                default: {
                    break;
                }
                case 4: {
                    return b.a.d;
                }
                case 3: {
                    return b.a.c;
                }
                case 2: {
                    return b.a.b;
                }
                case 1: 
            }
        }
        return b.a.a;
    }

    public final kotlin.reflect.jvm.internal.impl.a.ba a(a.aq aq2) {
        if (aq2 != null) {
            switch (y.e[aq2.ordinal()]) {
                default: {
                    break;
                }
                case 6: {
                    return az.f;
                }
                case 5: {
                    return az.e;
                }
                case 4: {
                    return az.c;
                }
                case 3: {
                    return az.b;
                }
                case 1: {
                    return az.d;
                }
                case 2: 
            }
        }
        return az.a;
    }

    public final f a(a.c.b b2) {
        if (b2 != null) {
            switch (y.f[b2.ordinal()]) {
                default: {
                    break;
                }
                case 6: 
                case 7: {
                    return f.f;
                }
                case 5: {
                    return f.e;
                }
                case 4: {
                    return f.d;
                }
                case 3: {
                    return f.c;
                }
                case 2: {
                    return f.b;
                }
                case 1: 
            }
        }
        return f.a;
    }

    public final w a(a.r r2) {
        if (r2 != null) {
            switch (y.c[r2.ordinal()]) {
                default: {
                    break;
                }
                case 4: {
                    return w.b;
                }
                case 3: {
                    return w.d;
                }
                case 2: {
                    return w.c;
                }
                case 1: 
            }
        }
        return w.a;
    }

    public final ba a(a.ac.a.b b2) {
        j.b(b2, "projection");
        switch (y.i[b2.ordinal()]) {
            default: {
                throw new m();
            }
            case 4: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Only IN, OUT and INV are supported. Actual argument: ");
                stringBuilder.append(b2);
                throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
            }
            case 3: {
                return ba.a;
            }
            case 2: {
                return ba.c;
            }
            case 1: 
        }
        return ba.b;
    }

    public final ba a(a.ag.b b2) {
        j.b(b2, "variance");
        switch (y.h[b2.ordinal()]) {
            default: {
                throw new m();
            }
            case 3: {
                return ba.a;
            }
            case 2: {
                return ba.c;
            }
            case 1: 
        }
        return ba.b;
    }
}

