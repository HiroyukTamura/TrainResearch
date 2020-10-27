package p009e.p028d.p030b.p054b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.PorterDuff;
import android.util.Log;
import java.io.EOFException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.C1110L;
import kotlinx.coroutines.C1111a0;
import kotlinx.coroutines.C2496E;
import kotlinx.coroutines.C2498G;
import kotlinx.coroutines.C2499H;
import kotlinx.coroutines.C2533g0;
import kotlinx.coroutines.C2579p;
import kotlinx.coroutines.C2608y;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.internal.C2561p;
import kotlinx.coroutines.internal.C2562q;
import p009e.p010a.p011a.p012a.C0681a;
import p042j.C2068f;
import p042j.C2089w;
import p042j.p118B.C2060b;

/* renamed from: e.d.b.b.a */
public final class C1532a {
    /* renamed from: a */
    public static int m2119a(int i, int i2) {
        int i3 = i ^ (i2 * 4);
        int i4 = (i3 ^ (i3 >>> 16)) * -2048144789;
        int i5 = (i4 ^ (i4 >>> 13)) * -1028477387;
        return i5 ^ (i5 >>> 16);
    }

    /* renamed from: a */
    public static int m2120a(int i, Object obj) {
        return m2145b(i, obj != null ? obj.hashCode() : 0);
    }

    /* renamed from: a */
    public static <T> int m2122a(T[] tArr, int i) {
        for (T a : tArr) {
            i = m2120a(i, (Object) a);
        }
        return m2119a(i, tArr.length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r1, (r0 = r2.getResourceId(r3, 0)));
     */
    @androidx.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList m2123a(android.content.Context r1, android.content.res.TypedArray r2, @androidx.annotation.StyleableRes int r3) {
        /*
            boolean r0 = r2.hasValue(r3)
            if (r0 == 0) goto L_0x0014
            r0 = 0
            int r0 = r2.getResourceId(r3, r0)
            if (r0 == 0) goto L_0x0014
            android.content.res.ColorStateList r1 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r1, r0)
            if (r1 == 0) goto L_0x0014
            return r1
        L_0x0014:
            android.content.res.ColorStateList r1 = r2.getColorStateList(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p009e.p028d.p030b.p054b.C1532a.m2123a(android.content.Context, android.content.res.TypedArray, int):android.content.res.ColorStateList");
    }

    /* renamed from: a */
    public static PorterDuff.Mode m2124a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* renamed from: a */
    public static <T> T m2125a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static final <T> Object m2126a(Object obj, Continuation<? super T> continuation) {
        if (obj instanceof C2579p) {
            Result.Companion companion = Result.Companion;
            Throwable th = ((C2579p) obj).f4218a;
            if (C2496E.m4308d() && (continuation instanceof CoroutineStackFrame)) {
                th = C2562q.m4462a(th, (CoroutineStackFrame) continuation);
            }
            obj = ResultKt.createFailure(th);
        } else {
            Result.Companion companion2 = Result.Companion;
        }
        return Result.m4628constructorimpl(obj);
    }

    /* renamed from: a */
    public static final <T, R> Object m2127a(C2561p<? super T> pVar, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        Object c;
        pVar.mo35529j();
        if (function2 != null) {
            try {
                obj = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, pVar);
            } catch (Throwable th) {
                obj = new C2579p(th, false, 2);
            }
            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() || (c = pVar.mo21846c(obj)) == C2533g0.f4150b) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            if (!(c instanceof C2579p)) {
                return C2533g0.m4406b(c);
            }
            Throwable th2 = ((C2579p) c).f4218a;
            Continuation<T> continuation = pVar.f4203d;
            if (C2496E.m4308d() && (continuation instanceof CoroutineStackFrame)) {
                th2 = C2562q.m4462a(th2, (CoroutineStackFrame) continuation);
            }
            throw th2;
        }
        throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    /* renamed from: a */
    public static final String m2128a(byte b) {
        return new String(new char[]{C2060b.m3457a()[(b >> 4) & 15], C2060b.m3457a()[b & 15]});
    }

    /* renamed from: a */
    public static final String m2129a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    /* renamed from: a */
    public static String m2130a(String str) {
        int indexOf = str.indexOf(46);
        int indexOf2 = indexOf >= 0 ? str.indexOf(46, indexOf + 1) : -1;
        int indexOf3 = str.indexOf(45);
        int length = str.length();
        if (indexOf2 >= 0) {
            length = Math.min(length, indexOf2);
        }
        if (indexOf3 >= 0) {
            length = Math.min(length, indexOf3);
        }
        return str.substring(0, length);
    }

    /* renamed from: a */
    public static <T> String m2131a(Iterator<T> it, String str) {
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static final String m2132a(Continuation<?> continuation) {
        Object obj;
        if (continuation instanceof C2498G) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m4628constructorimpl(continuation + '@' + m2147b(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4628constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r2 = Result.m4631exceptionOrNullimpl(obj);
        String str = obj;
        if (r2 != null) {
            str = continuation.getClass().getName() + '@' + m2147b(continuation);
        }
        return (String) str;
    }

    /* renamed from: a */
    public static /* synthetic */ C1110L m2133a(C1111a0 a0Var, boolean z, boolean z2, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return a0Var.mo21830a(z, z2, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
    }

    /* renamed from: a */
    public static final void m2134a(int i, String str, Throwable th) {
        int min;
        Intrinsics.checkParameterIsNotNull(str, "message");
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            StringBuilder c = C0681a.m340c(str, "\n");
            c.append(Log.getStackTraceString(th));
            str = c.toString();
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, 10, i3, false, 4, (Object) null);
            if (indexOf$default == -1) {
                indexOf$default = length;
            }
            while (true) {
                min = Math.min(indexOf$default, i3 + 4000);
                String substring = str.substring(i3, min);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Log.println(i2, "OkHttp", substring);
                if (min >= indexOf$default) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    /* renamed from: a */
    public static final void m2135a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    /* renamed from: a */
    public static void m2136a(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            j = Math.max(j, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 0});
        ofInt.setDuration(j);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }

    /* renamed from: a */
    public static <T> void m2137a(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    /* renamed from: a */
    public static void m2138a(String str, String str2) {
        boolean z = str != null && !"4.6".equals(str) && !m2130a("4.6").equals(m2130a(str));
        boolean z2 = !"4.6".equals(str2) && !m2130a("4.6").equals(m2130a(str2));
        if (z) {
            System.err.printf("ANTLR Tool version %s used for code generation does not match the current runtime version %s", new Object[]{str, "4.6"});
        }
        if (z2) {
            System.err.printf("ANTLR Runtime version %s used for parser compilation does not match the current runtime version %s", new Object[]{str2, "4.6"});
        }
    }

    /* renamed from: a */
    public static void m2139a(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    /* renamed from: a */
    public static final void m2140a(CoroutineContext coroutineContext, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.f4096j);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else {
                C2608y.m4554a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                ExceptionsKt__ExceptionsKt.addSuppressed(runtimeException, th);
                th = runtimeException;
            }
            C2608y.m4554a(coroutineContext, th);
        }
    }

    /* renamed from: a */
    public static final <R, T> void m2141a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        try {
            Continuation<Unit> intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, r, continuation));
            Result.Companion companion = Result.Companion;
            C2499H.m4321a(intercepted, Result.m4628constructorimpl(Unit.INSTANCE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m4628constructorimpl(ResultKt.createFailure(th)));
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m2142a(C1111a0 a0Var, CancellationException cancellationException, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            a0Var.mo21832a(cancellationException);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
    }

    /* renamed from: a */
    public static final boolean m2143a(C2068f fVar) {
        Intrinsics.checkParameterIsNotNull(fVar, "$this$isProbablyUtf8");
        try {
            C2068f fVar2 = new C2068f();
            fVar.mo29136a(fVar2, 0, RangesKt___RangesKt.coerceAtMost(fVar.size(), 64));
            for (int i = 0; i < 16; i++) {
                if (fVar2.mo29152c()) {
                    return true;
                }
                int p = fVar2.mo29176p();
                if (Character.isISOControl(p) && !Character.isWhitespace(p)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static final boolean m2144a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(bArr, "a");
        Intrinsics.checkParameterIsNotNull(bArr2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static int m2145b(int i, int i2) {
        int i3 = i2 * -862048943;
        int i4 = i ^ (((i3 >>> 17) | (i3 << 15)) * 461845907);
        return (((i4 >>> 19) | (i4 << 13)) * 5) - 430675100;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, (r0 = r2.getResourceId(r3, 0)));
     */
    @androidx.annotation.Nullable
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable m2146b(android.content.Context r1, android.content.res.TypedArray r2, @androidx.annotation.StyleableRes int r3) {
        /*
            boolean r0 = r2.hasValue(r3)
            if (r0 == 0) goto L_0x0014
            r0 = 0
            int r0 = r2.getResourceId(r3, r0)
            if (r0 == 0) goto L_0x0014
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r0)
            if (r1 == 0) goto L_0x0014
            return r1
        L_0x0014:
            android.graphics.drawable.Drawable r1 = r2.getDrawable(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p009e.p028d.p030b.p054b.C1532a.m2146b(android.content.Context, android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    /* renamed from: b */
    public static final String m2147b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    /* renamed from: c */
    public static final <T> Object m2148c(Object obj) {
        Throwable r0 = Result.m4631exceptionOrNullimpl(obj);
        return r0 == null ? obj : new C2579p(r0, false, 2);
    }

    /* renamed from: a */
    public static final int m2121a(C2089w wVar, int i) {
        int i2;
        Intrinsics.checkParameterIsNotNull(wVar, "$this$segment");
        int[] i3 = wVar.mo29254i();
        int i4 = i + 1;
        int length = wVar.mo29255j().length;
        Intrinsics.checkParameterIsNotNull(i3, "$this$binarySearch");
        int i5 = length - 1;
        int i6 = 0;
        while (true) {
            if (i6 <= i5) {
                i2 = (i6 + i5) >>> 1;
                int i7 = i3[i2];
                if (i7 >= i4) {
                    if (i7 <= i4) {
                        break;
                    }
                    i5 = i2 - 1;
                } else {
                    i6 = i2 + 1;
                }
            } else {
                i2 = (-i6) - 1;
                break;
            }
        }
        return i2 >= 0 ? i2 : i2 ^ -1;
    }
}
