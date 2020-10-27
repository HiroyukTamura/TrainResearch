package kotlinx.coroutines;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.p130u0.C2594b;

/* renamed from: kotlinx.coroutines.v */
public final class C2606v {

    /* renamed from: a */
    private static final boolean f4278a;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r0.equals("on") != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r0.equals("") != false) goto L_0x0033;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.C2564s.m4468a(r0)
            if (r0 != 0) goto L_0x0009
            goto L_0x0033
        L_0x0009:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L_0x002b
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L_0x0022
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L_0x0037
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0037
            r0 = 0
            goto L_0x0034
        L_0x0022:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0037
            goto L_0x0033
        L_0x002b:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0037
        L_0x0033:
            r0 = 1
        L_0x0034:
            f4278a = r0
            return
        L_0x0037:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C2606v.<clinit>():void");
    }

    /* renamed from: a */
    public static final String m4551a(CoroutineContext coroutineContext) {
        C2609z zVar;
        if (!C2496E.m4307c() || (zVar = (C2609z) coroutineContext.get(C2609z.f4281b)) == null) {
            return null;
        }
        C2490A a = (C2490A) coroutineContext.get(C2490A.f4089b);
        return "coroutine" + '#' + zVar.mo35636o();
    }

    /* renamed from: a */
    public static final CoroutineContext m4552a(C2492B b, CoroutineContext coroutineContext) {
        CoroutineContext plus = b.getCoroutineContext().plus(coroutineContext);
        CoroutineContext plus2 = C2496E.m4307c() ? plus.plus(new C2609z(C2496E.m4306b().incrementAndGet())) : plus;
        return (plus == C2502K.m4330a() || plus.get(ContinuationInterceptor.Key) != null) ? plus2 : plus2.plus(C2502K.m4330a());
    }

    /* renamed from: a */
    public static final C1120x m4553a() {
        return f4278a ? C2594b.f4252g : C2573m.f4214b;
    }
}
