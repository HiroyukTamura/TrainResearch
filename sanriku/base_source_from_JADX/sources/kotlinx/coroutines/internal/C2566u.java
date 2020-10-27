package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.C2496E;
import kotlinx.coroutines.internal.C2567v;

/* renamed from: kotlinx.coroutines.internal.u */
public class C2566u<T extends C2567v & Comparable<? super T>> {
    private volatile int _size = 0;

    /* renamed from: a */
    private T[] f4207a;

    /* renamed from: a */
    private final void m4472a(int i, int i2) {
        T[] tArr = this.f4207a;
        if (tArr == null) {
            Intrinsics.throwNpe();
        }
        T t = tArr[i2];
        if (t == null) {
            Intrinsics.throwNpe();
        }
        T t2 = tArr[i];
        if (t2 == null) {
            Intrinsics.throwNpe();
        }
        tArr[i] = t;
        tArr[i2] = t2;
        t.setIndex(i);
        t2.setIndex(i2);
    }

    /* renamed from: b */
    private final void m4473b(int i) {
        while (i > 0) {
            T[] tArr = this.f4207a;
            if (tArr == null) {
                Intrinsics.throwNpe();
            }
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            if (t == null) {
                Intrinsics.throwNpe();
            }
            Comparable comparable = (Comparable) t;
            T t2 = tArr[i];
            if (t2 == null) {
                Intrinsics.throwNpe();
            }
            if (comparable.compareTo(t2) > 0) {
                m4472a(i, i2);
                i = i2;
            } else {
                return;
            }
        }
    }

    @PublishedApi
    /* renamed from: a */
    public final T mo35576a() {
        T[] tArr = this.f4207a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    @PublishedApi
    /* renamed from: a */
    public final void mo35578a(T t) {
        if (C2496E.m4305a()) {
            if (!(t.mo35518a() == null)) {
                throw new AssertionError();
            }
        }
        t.mo35519a(this);
        T[] tArr = this.f4207a;
        if (tArr == null) {
            tArr = new C2567v[4];
            this.f4207a = tArr;
        } else if (this._size >= tArr.length) {
            T[] copyOf = Arrays.copyOf(tArr, this._size * 2);
            Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            tArr = (C2567v[]) copyOf;
            this.f4207a = tArr;
        }
        int i = this._size;
        this._size = i + 1;
        tArr[i] = t;
        t.setIndex(i);
        m4473b(i);
    }

    /* renamed from: b */
    public final boolean mo35579b() {
        return this._size == 0;
    }

    /* renamed from: b */
    public final boolean mo35580b(T t) {
        boolean z;
        synchronized (this) {
            z = true;
            boolean z2 = false;
            if (t.mo35518a() == null) {
                z = false;
            } else {
                int index = t.getIndex();
                if (C2496E.m4305a()) {
                    if (index >= 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        throw new AssertionError();
                    }
                }
                mo35577a(index);
            }
        }
        return z;
    }

    /* renamed from: c */
    public final T mo35581c() {
        T a;
        synchronized (this) {
            a = mo35576a();
        }
        return a;
    }

    /* renamed from: d */
    public final T mo35582d() {
        T a;
        synchronized (this) {
            a = this._size > 0 ? mo35577a(0) : null;
        }
        return a;
    }

    @PublishedApi
    /* renamed from: a */
    public final T mo35577a(int i) {
        boolean z = false;
        if (C2496E.m4305a()) {
            if (!(this._size > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.f4207a;
        if (tArr == null) {
            Intrinsics.throwNpe();
        }
        this._size--;
        if (i < this._size) {
            m4472a(i, this._size);
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                if (t == null) {
                    Intrinsics.throwNpe();
                }
                Comparable comparable = (Comparable) t;
                T t2 = tArr[i2];
                if (t2 == null) {
                    Intrinsics.throwNpe();
                }
                if (comparable.compareTo(t2) < 0) {
                    m4472a(i, i2);
                    m4473b(i2);
                }
            }
            while (true) {
                int i3 = (i * 2) + 1;
                if (i3 >= this._size) {
                    break;
                }
                T[] tArr2 = this.f4207a;
                if (tArr2 == null) {
                    Intrinsics.throwNpe();
                }
                int i4 = i3 + 1;
                if (i4 < this._size) {
                    T t3 = tArr2[i4];
                    if (t3 == null) {
                        Intrinsics.throwNpe();
                    }
                    Comparable comparable2 = (Comparable) t3;
                    T t4 = tArr2[i3];
                    if (t4 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (comparable2.compareTo(t4) < 0) {
                        i3 = i4;
                    }
                }
                T t5 = tArr2[i];
                if (t5 == null) {
                    Intrinsics.throwNpe();
                }
                Comparable comparable3 = (Comparable) t5;
                T t6 = tArr2[i3];
                if (t6 == null) {
                    Intrinsics.throwNpe();
                }
                if (comparable3.compareTo(t6) <= 0) {
                    break;
                }
                m4472a(i, i3);
                i = i3;
            }
        }
        T t7 = tArr[this._size];
        if (t7 == null) {
            Intrinsics.throwNpe();
        }
        if (C2496E.m4305a()) {
            if (t7.mo35518a() == this) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        t7.mo35519a((C2566u<?>) null);
        t7.setIndex(-1);
        tArr[this._size] = null;
        return t7;
    }
}
