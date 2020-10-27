package kotlinx.coroutines.internal;

import kotlin.TypeCastException;

/* renamed from: kotlinx.coroutines.internal.d */
public class C2546d<T> {

    /* renamed from: a */
    private Object[] f4177a = new Object[16];

    /* renamed from: b */
    private int f4178b;

    /* renamed from: c */
    private int f4179c;

    /* renamed from: a */
    public final void mo35551a(T t) {
        Object[] objArr = this.f4177a;
        int i = this.f4179c;
        objArr[i] = t;
        int length = (objArr.length - 1) & (i + 1);
        this.f4179c = length;
        int i2 = this.f4178b;
        if (length == i2) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[(length2 << 1)];
            Object[] unused = ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, i2, 0, 10, (Object) null);
            Object[] objArr3 = this.f4177a;
            int length3 = objArr3.length;
            int i3 = this.f4178b;
            Object[] unused2 = ArraysKt___ArraysJvmKt.copyInto$default(objArr3, objArr2, length3 - i3, 0, i3, 4, (Object) null);
            this.f4177a = objArr2;
            this.f4178b = 0;
            this.f4179c = length2;
        }
    }

    /* renamed from: a */
    public final boolean mo35552a() {
        return this.f4178b == this.f4179c;
    }

    /* renamed from: b */
    public final T mo35553b() {
        int i = this.f4178b;
        if (i == this.f4179c) {
            return null;
        }
        T[] tArr = this.f4177a;
        T t = tArr[i];
        tArr[i] = null;
        this.f4178b = (i + 1) & (tArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }
}
