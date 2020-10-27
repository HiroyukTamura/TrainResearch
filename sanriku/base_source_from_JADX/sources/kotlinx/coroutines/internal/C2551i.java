package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\f\b\u0017\u0018\u00002\u00020C:\u0005JKLMNB\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u000b\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\b¢\u0006\u0004\b\u000b\u0010\fJ4\u0010\u000f\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\rH\b¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0011\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\r2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\b¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u001a\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\f\b\u0000\u0010\u001c*\u00060\u0000j\u0002`\u00032\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00030 ¢\u0006\u0004\b!\u0010\"J \u0010$\u001a\u00060\u0000j\u0002`\u00032\n\u0010#\u001a\u00060\u0000j\u0002`\u0003H\u0010¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00052\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0002¢\u0006\u0004\b&\u0010\u0007J\r\u0010'\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\u0002J\u000f\u0010(\u001a\u00020\u0005H\u0001¢\u0006\u0004\b(\u0010\u0002J,\u0010*\u001a\u00020)2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\b¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0014¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010/J.\u00100\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001c\u0018\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\rH\b¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b2\u0010-J\u0017\u00103\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0001¢\u0006\u0004\b3\u0010-J\u000f\u00105\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J/\u0010<\u001a\u00020;2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00032\u0006\u0010:\u001a\u00020)H\u0001¢\u0006\u0004\b<\u0010=J'\u0010A\u001a\u00020\u00052\n\u0010>\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0000¢\u0006\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010/R\u0013\u0010\u0013\u001a\u00020C8F@\u0006¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0017\u0010G\u001a\u00060\u0000j\u0002`\u00038F@\u0006¢\u0006\u0006\u001a\u0004\bF\u0010-R\u0017\u0010I\u001a\u00060\u0000j\u0002`\u00038F@\u0006¢\u0006\u0006\u001a\u0004\bH\u0010-¨\u0006O"}, mo21739d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: kotlinx.coroutines.internal.i */
public class C2551i {

    /* renamed from: a */
    static final AtomicReferenceFieldUpdater f4183a;

    /* renamed from: b */
    static final AtomicReferenceFieldUpdater f4184b;

    /* renamed from: c */
    private static final AtomicReferenceFieldUpdater f4185c;
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    @PublishedApi
    /* renamed from: kotlinx.coroutines.internal.i$a */
    public static abstract class C2552a extends C2548f<C2551i> {
        @JvmField

        /* renamed from: b */
        public C2551i f4186b;
        @JvmField

        /* renamed from: c */
        public final C2551i f4187c;

        public C2552a(C2551i iVar) {
            this.f4187c = iVar;
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<C2551i> cls2 = C2551i.class;
        f4183a = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_next");
        f4184b = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_prev");
        f4185c = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_removedRef");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        if (f4183a.compareAndSet(r3, r2, ((kotlinx.coroutines.internal.C2560o) r4).f4202a) != false) goto L_0x004d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.coroutines.internal.C2551i m4434a(kotlinx.coroutines.internal.C2559n r7) {
        /*
            r6 = this;
        L_0x0000:
            java.lang.Object r0 = r6._prev
            kotlinx.coroutines.internal.i r0 = (kotlinx.coroutines.internal.C2551i) r0
            r1 = 0
            r2 = r0
        L_0x0006:
            r3 = r1
        L_0x0007:
            java.lang.Object r4 = r2._next
            if (r4 != r6) goto L_0x0018
            if (r0 != r2) goto L_0x000e
            return r2
        L_0x000e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f4184b
            boolean r0 = r1.compareAndSet(r6, r0, r2)
            if (r0 != 0) goto L_0x0017
            goto L_0x0000
        L_0x0017:
            return r2
        L_0x0018:
            boolean r5 = r6.mo35555f()
            if (r5 == 0) goto L_0x001f
            return r1
        L_0x001f:
            if (r4 != r7) goto L_0x0022
            return r2
        L_0x0022:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.C2559n
            if (r5 == 0) goto L_0x003a
            if (r7 == 0) goto L_0x0034
            r0 = r4
            kotlinx.coroutines.internal.n r0 = (kotlinx.coroutines.internal.C2559n) r0
            r3 = r7
            kotlinx.coroutines.internal.f r3 = (kotlinx.coroutines.internal.C2548f) r3
            kotlinx.coroutines.internal.f r0 = (kotlinx.coroutines.internal.C2548f) r0
            if (r0 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            throw r1
        L_0x0034:
            kotlinx.coroutines.internal.n r4 = (kotlinx.coroutines.internal.C2559n) r4
            r4.mo35554a(r2)
            goto L_0x0000
        L_0x003a:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.C2560o
            if (r5 == 0) goto L_0x0054
            if (r3 == 0) goto L_0x004f
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f4183a
            kotlinx.coroutines.internal.o r4 = (kotlinx.coroutines.internal.C2560o) r4
            kotlinx.coroutines.internal.i r4 = r4.f4202a
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L_0x004d
            goto L_0x0000
        L_0x004d:
            r2 = r3
            goto L_0x0006
        L_0x004f:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.i r2 = (kotlinx.coroutines.internal.C2551i) r2
            goto L_0x0007
        L_0x0054:
            if (r4 == 0) goto L_0x005b
            kotlinx.coroutines.internal.i r4 = (kotlinx.coroutines.internal.C2551i) r4
            r3 = r2
            r2 = r4
            goto L_0x0007
        L_0x005b:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            r7.<init>(r0)
            goto L_0x0064
        L_0x0063:
            throw r7
        L_0x0064:
            goto L_0x0063
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C2551i.m4434a(kotlinx.coroutines.internal.n):kotlinx.coroutines.internal.i");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m4436b(C2551i iVar) {
        C2551i iVar2;
        do {
            iVar2 = (C2551i) iVar._prev;
            if (mo35559c() != iVar) {
                return;
            }
        } while (!f4184b.compareAndSet(iVar, iVar2, this));
        if (mo35555f()) {
            iVar.m4434a((C2559n) null);
        }
    }

    @PublishedApi
    /* renamed from: a */
    public final int mo35557a(C2551i iVar, C2551i iVar2, C2552a aVar) {
        f4184b.lazySet(iVar, this);
        f4183a.lazySet(iVar, iVar2);
        aVar.f4186b = iVar2;
        if (!f4183a.compareAndSet(this, iVar2, aVar)) {
            return 0;
        }
        return aVar.mo35554a(this) == null ? 1 : 2;
    }

    /* renamed from: a */
    public final boolean mo35558a(C2551i iVar) {
        f4184b.lazySet(iVar, this);
        f4183a.lazySet(iVar, this);
        while (mo35559c() == this) {
            if (f4183a.compareAndSet(this, this, iVar)) {
                iVar.m4436b(this);
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public final Object mo35559c() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof C2559n)) {
                return obj;
            }
            ((C2559n) obj).mo35554a(this);
        }
    }

    /* renamed from: d */
    public final C2551i mo35560d() {
        return C2550h.m4433a(mo35559c());
    }

    /* renamed from: e */
    public final C2551i mo35561e() {
        C2551i a = m4434a((C2559n) null);
        if (a == null) {
            Object obj = this._prev;
            while (true) {
                a = (C2551i) obj;
                if (!a.mo35555f()) {
                    break;
                }
                obj = a._prev;
            }
        }
        return a;
    }

    /* renamed from: f */
    public boolean mo35555f() {
        return mo35559c() instanceof C2560o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo35556g() {
        /*
            r4 = this;
        L_0x0000:
            java.lang.Object r0 = r4.mo35559c()
            boolean r1 = r0 instanceof kotlinx.coroutines.internal.C2560o
            if (r1 == 0) goto L_0x000d
            kotlinx.coroutines.internal.o r0 = (kotlinx.coroutines.internal.C2560o) r0
            kotlinx.coroutines.internal.i r0 = r0.f4202a
            goto L_0x0034
        L_0x000d:
            if (r0 != r4) goto L_0x0012
            kotlinx.coroutines.internal.i r0 = (kotlinx.coroutines.internal.C2551i) r0
            goto L_0x0034
        L_0x0012:
            if (r0 == 0) goto L_0x003a
            r1 = r0
            kotlinx.coroutines.internal.i r1 = (kotlinx.coroutines.internal.C2551i) r1
            java.lang.Object r2 = r1._removedRef
            kotlinx.coroutines.internal.o r2 = (kotlinx.coroutines.internal.C2560o) r2
            if (r2 == 0) goto L_0x001e
            goto L_0x0028
        L_0x001e:
            kotlinx.coroutines.internal.o r2 = new kotlinx.coroutines.internal.o
            r2.<init>(r1)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f4185c
            r3.lazySet(r1, r2)
        L_0x0028:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f4183a
            boolean r0 = r3.compareAndSet(r4, r0, r2)
            if (r0 == 0) goto L_0x0000
            r0 = 0
            r1.m4434a((kotlinx.coroutines.internal.C2559n) r0)
        L_0x0034:
            if (r0 != 0) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            return r0
        L_0x003a:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            r0.<init>(r1)
            goto L_0x0043
        L_0x0042:
            throw r0
        L_0x0043:
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C2551i.mo35556g():boolean");
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}
