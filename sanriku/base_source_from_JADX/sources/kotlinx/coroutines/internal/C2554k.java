package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.C2496E;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\b\u0000\u0018\u0000 /*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0013J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010#J3\u0010&\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010'R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u0013\u0010)\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b)\u0010\u0013R\u0016\u0010*\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0013\u0010.\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, mo21739d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.internal.k */
public final class C2554k<E> {

    /* renamed from: e */
    private static final AtomicReferenceFieldUpdater f4189e;

    /* renamed from: f */
    private static final AtomicLongFieldUpdater f4190f;
    @JvmField

    /* renamed from: g */
    public static final C2563r f4191g = new C2563r("REMOVE_FROZEN");

    /* renamed from: h */
    public static final C2555a f4192h = new C2555a((DefaultConstructorMarker) null);
    private volatile Object _next = null;
    private volatile long _state = 0;

    /* renamed from: a */
    private final int f4193a;

    /* renamed from: b */
    private AtomicReferenceArray f4194b = new AtomicReferenceArray(this.f4195c);

    /* renamed from: c */
    private final int f4195c;

    /* renamed from: d */
    private final boolean f4196d;

    /* renamed from: kotlinx.coroutines.internal.k$a */
    public static final class C2555a {
        public /* synthetic */ C2555a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final long mo35572a(long j, long j2) {
            return j & (j2 ^ -1);
        }
    }

    /* renamed from: kotlinx.coroutines.internal.k$b */
    public static final class C2556b {
        @JvmField

        /* renamed from: a */
        public final int f4197a;

        public C2556b(int i) {
            this.f4197a = i;
        }
    }

    static {
        Class<C2554k> cls = C2554k.class;
        f4189e = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        f4190f = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }

    public C2554k(int i, boolean z) {
        this.f4195c = i;
        this.f4196d = z;
        boolean z2 = true;
        this.f4193a = i - 1;
        if (this.f4193a <= 1073741823) {
            if (!((this.f4195c & this.f4193a) != 0 ? false : z2)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: a */
    public final int mo35566a(E e) {
        E e2 = e;
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((j & 1152921503533105152L) >> 30);
            int i3 = this.f4193a;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (this.f4196d || this.f4194b.get(i2 & i3) == null) {
                if (f4190f.compareAndSet(this, j, f4192h.mo35572a(j, 1152921503533105152L) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                    this.f4194b.set(i2 & i3, e2);
                    C2554k kVar = this;
                    while ((kVar._state & 1152921504606846976L) != 0) {
                        kVar = kVar.mo35570d();
                        Object obj = kVar.f4194b.get(kVar.f4193a & i2);
                        if (!(obj instanceof C2556b) || ((C2556b) obj).f4197a != i2) {
                            kVar = null;
                            continue;
                        } else {
                            kVar.f4194b.set(kVar.f4193a & i2, e2);
                            continue;
                        }
                        if (kVar == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
            } else {
                int i4 = this.f4195c;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    return 1;
                }
            }
        }
        return 1;
    }

    /* renamed from: a */
    public final boolean mo35567a() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f4190f.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    /* renamed from: b */
    public final int mo35568b() {
        long j = this._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    /* renamed from: c */
    public final boolean mo35569c() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.C2554k<E> mo35570d() {
        /*
            r12 = this;
        L_0x0000:
            long r2 = r12._state
            r6 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r0 = r2 & r6
            r4 = 0
            int r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x000d
            goto L_0x001a
        L_0x000d:
            long r8 = r2 | r6
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f4190f
            r1 = r12
            r4 = r8
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x0000
            r2 = r8
        L_0x001a:
            java.lang.Object r0 = r12._next
            kotlinx.coroutines.internal.k r0 = (kotlinx.coroutines.internal.C2554k) r0
            if (r0 == 0) goto L_0x0021
            return r0
        L_0x0021:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f4189e
            r1 = 0
            kotlinx.coroutines.internal.k r4 = new kotlinx.coroutines.internal.k
            int r5 = r12.f4195c
            int r5 = r5 * 2
            boolean r8 = r12.f4196d
            r4.<init>(r5, r8)
            r8 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r8 = r8 & r2
            r5 = 0
            long r8 = r8 >> r5
            int r5 = (int) r8
            r8 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r8 = r8 & r2
            r10 = 30
            long r8 = r8 >> r10
            int r9 = (int) r8
        L_0x0040:
            int r8 = r12.f4193a
            r10 = r5 & r8
            r8 = r8 & r9
            if (r10 == r8) goto L_0x0060
            java.util.concurrent.atomic.AtomicReferenceArray r8 = r12.f4194b
            java.lang.Object r8 = r8.get(r10)
            if (r8 == 0) goto L_0x0050
            goto L_0x0055
        L_0x0050:
            kotlinx.coroutines.internal.k$b r8 = new kotlinx.coroutines.internal.k$b
            r8.<init>(r5)
        L_0x0055:
            java.util.concurrent.atomic.AtomicReferenceArray r10 = r4.f4194b
            int r11 = r4.f4193a
            r11 = r11 & r5
            r10.set(r11, r8)
            int r5 = r5 + 1
            goto L_0x0040
        L_0x0060:
            kotlinx.coroutines.internal.k$a r5 = f4192h
            long r8 = r5.mo35572a(r2, r6)
            r4._state = r8
            r0.compareAndSet(r12, r1, r4)
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C2554k.mo35570d():kotlinx.coroutines.internal.k");
    }

    /* renamed from: e */
    public final Object mo35571e() {
        while (true) {
            long j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return f4191g;
            }
            int i = (int) ((j & 1073741823) >> 0);
            int i2 = this.f4193a;
            int i3 = ((int) ((1152921503533105152L & j) >> 30)) & i2;
            int i4 = i2 & i;
            if (i3 == i4) {
                return null;
            }
            Object obj = this.f4194b.get(i4);
            if (obj == null) {
                if (this.f4196d) {
                    return null;
                }
            } else if (obj instanceof C2556b) {
                return null;
            } else {
                long j2 = ((long) ((i + 1) & 1073741823)) << 0;
                Object obj2 = obj;
                if (f4190f.compareAndSet(this, j, f4192h.mo35572a(j, 1073741823) | j2)) {
                    this.f4194b.set(this.f4193a & i, (Object) null);
                    return obj2;
                } else if (this.f4196d) {
                    C2554k kVar = this;
                    while (true) {
                        long j3 = kVar._state;
                        int i5 = (int) ((j3 & 1073741823) >> 0);
                        if (C2496E.m4305a()) {
                            if (!(i5 == i)) {
                                throw new AssertionError();
                            }
                        }
                        if ((j3 & 1152921504606846976L) != 0) {
                            kVar = kVar.mo35570d();
                        } else {
                            if (f4190f.compareAndSet(kVar, j3, j2 | f4192h.mo35572a(j3, 1073741823))) {
                                kVar.f4194b.set(kVar.f4193a & i5, (Object) null);
                                kVar = null;
                            } else {
                                continue;
                            }
                        }
                        if (kVar == null) {
                            return obj2;
                        }
                    }
                }
            }
        }
    }
}
