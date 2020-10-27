package kotlinx.coroutines.internal;

import kotlin.jvm.internal.LongCompanionObject;

/* renamed from: kotlinx.coroutines.internal.s */
public final class C2564s {
    /* renamed from: a */
    public static final int m4464a() {
        return C2565t.m4470a();
    }

    /* renamed from: a */
    public static final long m4466a(String str, long j, long j2, long j3) {
        String a = C2565t.m4471a(str);
        if (a == null) {
            return j;
        }
        Long longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(a);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (j2 <= longValue && j3 >= longValue) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + a + '\'').toString());
    }

    /* renamed from: a */
    public static final String m4468a(String str) {
        return C2565t.m4471a(str);
    }

    /* renamed from: a */
    public static final boolean m4469a(String str, boolean z) {
        String a = C2565t.m4471a(str);
        return a != null ? Boolean.parseBoolean(a) : z;
    }

    /* renamed from: a */
    public static /* synthetic */ int m4465a(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return (int) m4466a(str, (long) i, (long) i2, (long) i3);
    }

    /* renamed from: a */
    public static /* synthetic */ long m4467a(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = LongCompanionObject.MAX_VALUE;
        }
        return m4466a(str, j, j4, j3);
    }
}
