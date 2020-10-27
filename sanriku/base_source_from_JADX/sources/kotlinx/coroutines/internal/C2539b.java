package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002\u001a1\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00072\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006H\b\u001a!\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u0010H\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\b\b\u0002\u0010\u0014\u001a\u00020\tH\u0010\u001a\u0018\u0010\u0015\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"4\u0010\u0002\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006¨\u0006\u0018"}, mo21739d2 = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, mo21740k = 2, mo21741mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.internal.b */
public final class C2539b {

    /* renamed from: a */
    private static final int f4161a = m4419a(Throwable.class, -1);

    /* renamed from: b */
    private static final ReentrantReadWriteLock f4162b = new ReentrantReadWriteLock();

    /* renamed from: c */
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> f4163c = new WeakHashMap<>();

    /* renamed from: kotlinx.coroutines.internal.b$a */
    /* compiled from: com.android.tools.r8.jetbrains.kotlin-style lambda group */
    static final class C2540a extends Lambda implements Function1 {

        /* renamed from: b */
        public static final C2540a f4164b = new C2540a(0);

        /* renamed from: c */
        public static final C2540a f4165c = new C2540a(1);

        /* renamed from: a */
        public final /* synthetic */ int f4166a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C2540a(int i) {
            super(1);
            this.f4166a = i;
        }

        public final Object invoke(Object obj) {
            int i = this.f4166a;
            if (i == 0) {
                Throwable th = (Throwable) obj;
                return null;
            } else if (i == 1) {
                Throwable th2 = (Throwable) obj;
                return null;
            } else {
                throw null;
            }
        }
    }

    /* renamed from: kotlinx.coroutines.internal.b$b */
    public static final class C2541b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
        }
    }

    /* renamed from: a */
    private static final int m4419a(Class<?> cls, int i) {
        Integer num;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            int i2 = 0;
            Class<? super Object> cls2 = cls;
            while (true) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    if (!Modifier.isStatic(declaredFields[i4].getModifiers())) {
                        i3++;
                    }
                }
                i2 += i3;
                Class<? super Object> superclass = cls2.getSuperclass();
                if (superclass == null) {
                    break;
                }
                cls2 = superclass;
            }
            num = Result.m4628constructorimpl(Integer.valueOf(i2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m4628constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m4634isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: a */
    public static final <E extends java.lang.Throwable> E m4420a(E r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.C2590u
            r1 = 0
            if (r0 == 0) goto L_0x0028
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0012 }
            kotlinx.coroutines.u r9 = (kotlinx.coroutines.C2590u) r9     // Catch:{ all -> 0x0012 }
            java.lang.Throwable r9 = r9.mo35538a()     // Catch:{ all -> 0x0012 }
            java.lang.Object r9 = kotlin.Result.m4628constructorimpl(r9)     // Catch:{ all -> 0x0012 }
            goto L_0x001d
        L_0x0012:
            r9 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m4628constructorimpl(r9)
        L_0x001d:
            boolean r0 = kotlin.Result.m4634isFailureimpl(r9)
            if (r0 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r1 = r9
        L_0x0025:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            return r1
        L_0x0028:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f4162b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r2 = f4163c     // Catch:{ all -> 0x0164 }
            java.lang.Class r3 = r9.getClass()     // Catch:{ all -> 0x0164 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0164 }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ all -> 0x0164 }
            r0.unlock()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r9 = r2.invoke(r9)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            return r9
        L_0x0049:
            int r0 = f4161a
            java.lang.Class r2 = r9.getClass()
            r3 = 0
            int r2 = m4419a(r2, r3)
            if (r0 == r2) goto L_0x009e
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f4162b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            int r4 = r0.getWriteHoldCount()
            if (r4 != 0) goto L_0x0067
            int r4 = r0.getReadHoldCount()
            goto L_0x0068
        L_0x0067:
            r4 = 0
        L_0x0068:
            r5 = 0
        L_0x0069:
            if (r5 >= r4) goto L_0x0071
            r2.unlock()
            int r5 = r5 + 1
            goto L_0x0069
        L_0x0071:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r5 = f4163c     // Catch:{ all -> 0x0091 }
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0091 }
            kotlinx.coroutines.internal.b$a r6 = kotlinx.coroutines.internal.C2539b.C2540a.f4164b     // Catch:{ all -> 0x0091 }
            r5.put(r9, r6)     // Catch:{ all -> 0x0091 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0091 }
        L_0x0085:
            if (r3 >= r4) goto L_0x008d
            r2.lock()
            int r3 = r3 + 1
            goto L_0x0085
        L_0x008d:
            r0.unlock()
            return r1
        L_0x0091:
            r9 = move-exception
        L_0x0092:
            if (r3 >= r4) goto L_0x009a
            r2.lock()
            int r3 = r3 + 1
            goto L_0x0092
        L_0x009a:
            r0.unlock()
            throw r9
        L_0x009e:
            java.lang.Class r0 = r9.getClass()
            java.lang.reflect.Constructor[] r0 = r0.getConstructors()
            kotlinx.coroutines.internal.b$b r2 = new kotlinx.coroutines.internal.b$b
            r2.<init>()
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysKt.sortedWith((T[]) r0, r2)
            java.util.Iterator r0 = r0.iterator()
            r2 = r1
        L_0x00b4:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x010f
            java.lang.Object r2 = r0.next()
            java.lang.reflect.Constructor r2 = (java.lang.reflect.Constructor) r2
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.lang.Class[] r5 = r2.getParameterTypes()
            int r6 = r5.length
            if (r6 == 0) goto L_0x0106
            r7 = 2
            r8 = 1
            if (r6 == r8) goto L_0x00e8
            if (r6 == r7) goto L_0x00d0
            goto L_0x0104
        L_0x00d0:
            r6 = r5[r3]
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0104
            r4 = r5[r8]
            java.lang.Class<java.lang.Throwable> r5 = java.lang.Throwable.class
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0104
            kotlinx.coroutines.internal.a r4 = new kotlinx.coroutines.internal.a
            r4.<init>(r3, r2)
            goto L_0x010c
        L_0x00e8:
            r5 = r5[r3]
            java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x00f8
            kotlinx.coroutines.internal.a r4 = new kotlinx.coroutines.internal.a
            r4.<init>(r8, r2)
            goto L_0x010c
        L_0x00f8:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0104
            kotlinx.coroutines.internal.a r4 = new kotlinx.coroutines.internal.a
            r4.<init>(r7, r2)
            goto L_0x010c
        L_0x0104:
            r2 = r1
            goto L_0x010d
        L_0x0106:
            kotlinx.coroutines.internal.a r4 = new kotlinx.coroutines.internal.a
            r5 = 3
            r4.<init>(r5, r2)
        L_0x010c:
            r2 = r4
        L_0x010d:
            if (r2 == 0) goto L_0x00b4
        L_0x010f:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f4162b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r0.readLock()
            int r5 = r0.getWriteHoldCount()
            if (r5 != 0) goto L_0x0120
            int r5 = r0.getReadHoldCount()
            goto L_0x0121
        L_0x0120:
            r5 = 0
        L_0x0121:
            r6 = 0
        L_0x0122:
            if (r6 >= r5) goto L_0x012a
            r4.unlock()
            int r6 = r6 + 1
            goto L_0x0122
        L_0x012a:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r6 = f4163c     // Catch:{ all -> 0x0157 }
            java.lang.Class r7 = r9.getClass()     // Catch:{ all -> 0x0157 }
            if (r2 == 0) goto L_0x013b
            r8 = r2
            goto L_0x013d
        L_0x013b:
            kotlinx.coroutines.internal.b$a r8 = kotlinx.coroutines.internal.C2539b.C2540a.f4165c     // Catch:{ all -> 0x0157 }
        L_0x013d:
            r6.put(r7, r8)     // Catch:{ all -> 0x0157 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0157 }
        L_0x0142:
            if (r3 >= r5) goto L_0x014a
            r4.lock()
            int r3 = r3 + 1
            goto L_0x0142
        L_0x014a:
            r0.unlock()
            if (r2 == 0) goto L_0x0156
            java.lang.Object r9 = r2.invoke(r9)
            r1 = r9
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x0156:
            return r1
        L_0x0157:
            r9 = move-exception
        L_0x0158:
            if (r3 >= r5) goto L_0x0160
            r4.lock()
            int r3 = r3 + 1
            goto L_0x0158
        L_0x0160:
            r0.unlock()
            throw r9
        L_0x0164:
            r9 = move-exception
            r0.unlock()
            goto L_0x016a
        L_0x0169:
            throw r9
        L_0x016a:
            goto L_0x0169
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C2539b.m4420a(java.lang.Throwable):java.lang.Throwable");
    }
}
