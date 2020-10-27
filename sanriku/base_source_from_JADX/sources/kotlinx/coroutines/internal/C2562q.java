package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: kotlinx.coroutines.internal.q */
public final class C2562q {

    /* renamed from: a */
    private static final String f4204a;

    static {
        Object obj;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m4628constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4628constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m4631exceptionOrNullimpl(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f4204a = (String) obj;
        try {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.m4628constructorimpl(Class.forName("kotlinx.coroutines.internal.q").getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.m4628constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m4631exceptionOrNullimpl(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        String str = (String) obj2;
    }

    /* renamed from: a */
    public static final <E extends Throwable> E m4461a(E e) {
        E cause = e.getCause();
        if (cause != null) {
            boolean z = true;
            if (!(!Intrinsics.areEqual((Object) cause.getClass(), (Object) e.getClass()))) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else if (m4463a(stackTrace[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return cause;
                }
            }
        }
        return e;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public static final /* synthetic */ java.lang.Throwable m4462a(java.lang.Throwable r11, kotlin.coroutines.jvm.internal.CoroutineStackFrame r12) {
        /*
            java.lang.Throwable r0 = r11.getCause()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x003a
            java.lang.Class r3 = r0.getClass()
            java.lang.Class r4 = r11.getClass()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x003a
            java.lang.StackTraceElement[] r3 = r11.getStackTrace()
            int r4 = r3.length
            r5 = 0
        L_0x001c:
            if (r5 >= r4) goto L_0x002b
            r6 = r3[r5]
            boolean r6 = m4463a((java.lang.StackTraceElement) r6)
            if (r6 == 0) goto L_0x0028
            r4 = 1
            goto L_0x002c
        L_0x0028:
            int r5 = r5 + 1
            goto L_0x001c
        L_0x002b:
            r4 = 0
        L_0x002c:
            if (r4 == 0) goto L_0x0033
            kotlin.Pair r0 = kotlin.TuplesKt.m4300to(r0, r3)
            goto L_0x0040
        L_0x0033:
            java.lang.StackTraceElement[] r0 = new java.lang.StackTraceElement[r2]
            kotlin.Pair r0 = kotlin.TuplesKt.m4300to(r11, r0)
            goto L_0x0040
        L_0x003a:
            java.lang.StackTraceElement[] r0 = new java.lang.StackTraceElement[r2]
            kotlin.Pair r0 = kotlin.TuplesKt.m4300to(r11, r0)
        L_0x0040:
            java.lang.Object r3 = r0.component1()
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.lang.Object r0 = r0.component2()
            java.lang.StackTraceElement[] r0 = (java.lang.StackTraceElement[]) r0
            java.lang.Throwable r4 = kotlinx.coroutines.internal.C2539b.m4420a(r3)
            if (r4 == 0) goto L_0x0158
            java.lang.String r5 = r4.getMessage()
            java.lang.String r6 = r3.getMessage()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            r5 = r5 ^ r1
            if (r5 == 0) goto L_0x0063
            goto L_0x0158
        L_0x0063:
            java.util.ArrayDeque r5 = new java.util.ArrayDeque
            r5.<init>()
            java.lang.StackTraceElement r6 = r12.getStackTraceElement()
            if (r6 == 0) goto L_0x006f
            goto L_0x007b
        L_0x006f:
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r12 = r12.getCallerFrame()
            if (r12 == 0) goto L_0x007f
            java.lang.StackTraceElement r6 = r12.getStackTraceElement()
            if (r6 == 0) goto L_0x006f
        L_0x007b:
            r5.add(r6)
            goto L_0x006f
        L_0x007f:
            boolean r12 = r5.isEmpty()
            if (r12 == 0) goto L_0x0087
            goto L_0x0158
        L_0x0087:
            r12 = -1
            if (r3 == r11) goto L_0x00ee
            int r11 = r0.length
            r6 = 0
        L_0x008c:
            if (r6 >= r11) goto L_0x009a
            r7 = r0[r6]
            boolean r7 = m4463a((java.lang.StackTraceElement) r7)
            if (r7 == 0) goto L_0x0097
            goto L_0x009b
        L_0x0097:
            int r6 = r6 + 1
            goto L_0x008c
        L_0x009a:
            r6 = -1
        L_0x009b:
            int r6 = r6 + r1
            int r11 = r0.length
            int r11 = r11 - r1
            if (r11 < r6) goto L_0x00ee
        L_0x00a0:
            r7 = r0[r11]
            java.lang.Object r8 = r5.getLast()
            java.lang.StackTraceElement r8 = (java.lang.StackTraceElement) r8
            int r9 = r7.getLineNumber()
            int r10 = r8.getLineNumber()
            if (r9 != r10) goto L_0x00de
            java.lang.String r9 = r7.getMethodName()
            java.lang.String r10 = r8.getMethodName()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x00de
            java.lang.String r9 = r7.getFileName()
            java.lang.String r10 = r8.getFileName()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x00de
            java.lang.String r7 = r7.getClassName()
            java.lang.String r8 = r8.getClassName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x00de
            r7 = 1
            goto L_0x00df
        L_0x00de:
            r7 = 0
        L_0x00df:
            if (r7 == 0) goto L_0x00e4
            r5.removeLast()
        L_0x00e4:
            r7 = r0[r11]
            r5.addFirst(r7)
            if (r11 == r6) goto L_0x00ee
            int r11 = r11 + -1
            goto L_0x00a0
        L_0x00ee:
            java.lang.StackTraceElement r11 = new java.lang.StackTraceElement
            java.lang.String r0 = "\b\b\b(Coroutine boundary"
            java.lang.String r6 = "\b"
            r11.<init>(r0, r6, r6, r12)
            r5.addFirst(r11)
            java.lang.StackTraceElement[] r11 = r3.getStackTrace()
            java.lang.String r0 = f4204a
            int r3 = r11.length
            r6 = 0
        L_0x0102:
            if (r6 >= r3) goto L_0x0114
            r7 = r11[r6]
            java.lang.String r7 = r7.getClassName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0111
            goto L_0x0115
        L_0x0111:
            int r6 = r6 + 1
            goto L_0x0102
        L_0x0114:
            r6 = -1
        L_0x0115:
            if (r6 != r12) goto L_0x012d
            java.lang.StackTraceElement[] r11 = new java.lang.StackTraceElement[r2]
            java.lang.Object[] r11 = r5.toArray(r11)
            if (r11 == 0) goto L_0x0125
            java.lang.StackTraceElement[] r11 = (java.lang.StackTraceElement[]) r11
            r4.setStackTrace(r11)
            goto L_0x0157
        L_0x0125:
            kotlin.TypeCastException r11 = new kotlin.TypeCastException
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.Array<T>"
            r11.<init>(r12)
            throw r11
        L_0x012d:
            int r12 = r5.size()
            int r12 = r12 + r6
            java.lang.StackTraceElement[] r12 = new java.lang.StackTraceElement[r12]
            r0 = 0
        L_0x0135:
            if (r0 >= r6) goto L_0x013e
            r3 = r11[r0]
            r12[r0] = r3
            int r0 = r0 + 1
            goto L_0x0135
        L_0x013e:
            java.util.Iterator r11 = r5.iterator()
        L_0x0142:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0154
            java.lang.Object r0 = r11.next()
            java.lang.StackTraceElement r0 = (java.lang.StackTraceElement) r0
            int r3 = r6 + r2
            r12[r3] = r0
            int r2 = r2 + r1
            goto L_0x0142
        L_0x0154:
            r4.setStackTrace(r12)
        L_0x0157:
            r11 = r4
        L_0x0158:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C2562q.m4462a(java.lang.Throwable, kotlin.coroutines.jvm.internal.CoroutineStackFrame):java.lang.Throwable");
    }

    /* renamed from: a */
    public static final boolean m4463a(StackTraceElement stackTraceElement) {
        return StringsKt__StringsJVMKt.startsWith$default(stackTraceElement.getClassName(), "\b\b\b", false, 2, (Object) null);
    }
}
