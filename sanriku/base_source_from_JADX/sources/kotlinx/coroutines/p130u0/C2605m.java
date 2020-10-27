package kotlinx.coroutines.p130u0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.C2496E;

/* renamed from: kotlinx.coroutines.u0.m */
public final class C2605m {

    /* renamed from: b */
    private static final AtomicReferenceFieldUpdater f4273b;

    /* renamed from: c */
    private static final AtomicIntegerFieldUpdater f4274c;

    /* renamed from: d */
    private static final AtomicIntegerFieldUpdater f4275d;

    /* renamed from: e */
    private static final AtomicIntegerFieldUpdater f4276e;

    /* renamed from: a */
    private final AtomicReferenceArray<C2600h> f4277a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer = 0;
    private volatile int consumerIndex = 0;
    private volatile Object lastScheduledTask = null;
    private volatile int producerIndex = 0;

    static {
        Class<C2605m> cls = C2605m.class;
        f4273b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f4274c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f4275d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f4276e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    /* renamed from: a */
    private final C2600h m4542a(C2600h hVar) {
        boolean z = true;
        if (hVar.f4266b.mo35624i() != 1) {
            z = false;
        }
        if (z) {
            f4276e.incrementAndGet(this);
        }
        if (mo35627a() == 127) {
            return hVar;
        }
        int i = this.producerIndex & 127;
        while (this.f4277a.get(i) != null) {
            Thread.yield();
        }
        this.f4277a.lazySet(i, hVar);
        f4274c.incrementAndGet(this);
        return null;
    }

    /* renamed from: d */
    private final C2600h m4543d() {
        C2600h andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (f4275d.compareAndSet(this, i, i + 1) && (andSet = this.f4277a.getAndSet(i2, (Object) null)) != null) {
                boolean z = false;
                if (andSet.f4266b.mo35624i() == 1) {
                    int decrementAndGet = f4276e.decrementAndGet(this);
                    if (C2496E.m4305a()) {
                        if (decrementAndGet >= 0) {
                            z = true;
                        }
                        if (!z) {
                            throw new AssertionError();
                        }
                    }
                }
                return andSet;
            }
        }
    }

    /* renamed from: a */
    public final int mo35627a() {
        return this.producerIndex - this.consumerIndex;
    }

    /* renamed from: a */
    public final C2600h mo35629a(C2600h hVar, boolean z) {
        if (z) {
            return m4542a(hVar);
        }
        C2600h hVar2 = (C2600h) f4273b.getAndSet(this, hVar);
        if (hVar2 != null) {
            return m4542a(hVar2);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo35630a(C2596d dVar) {
        boolean z;
        C2600h hVar = (C2600h) f4273b.getAndSet(this, (Object) null);
        if (hVar != null) {
            dVar.mo35563a(hVar);
        }
        do {
            C2600h d = m4543d();
            if (d != null) {
                dVar.mo35563a(d);
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
        } while (z);
    }

    /* renamed from: b */
    public final int mo35631b() {
        return this.lastScheduledTask != null ? mo35627a() + 1 : mo35627a();
    }

    /* renamed from: b */
    public final long mo35632b(C2605m mVar) {
        boolean z = true;
        if (C2496E.m4305a()) {
            if (!(mo35627a() == 0)) {
                throw new AssertionError();
            }
        }
        C2600h d = mVar.m4543d();
        if (d == null) {
            return m4541a(mVar, false);
        }
        C2600h a = mo35629a(d, false);
        if (!C2496E.m4305a()) {
            return -1;
        }
        if (a != null) {
            z = false;
        }
        if (z) {
            return -1;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public final C2600h mo35633c() {
        C2600h hVar = (C2600h) f4273b.getAndSet(this, (Object) null);
        return hVar != null ? hVar : m4543d();
    }

    /* renamed from: a */
    public final long mo35628a(C2605m mVar) {
        if (C2496E.m4305a()) {
            if (!(mo35627a() == 0)) {
                throw new AssertionError();
            }
        }
        int i = mVar.producerIndex;
        AtomicReferenceArray<C2600h> atomicReferenceArray = mVar.f4277a;
        for (int i2 = mVar.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (mVar.blockingTasksInBuffer == 0) {
                break;
            }
            C2600h hVar = atomicReferenceArray.get(i3);
            if (hVar != null) {
                if ((hVar.f4266b.mo35624i() == 1) && atomicReferenceArray.compareAndSet(i3, hVar, (Object) null)) {
                    f4276e.decrementAndGet(mVar);
                    mo35629a(hVar, false);
                    return -1;
                }
            }
        }
        return m4541a(mVar, true);
    }

    /* renamed from: a */
    private final long m4541a(C2605m mVar, boolean z) {
        C2600h hVar;
        do {
            hVar = (C2600h) mVar.lastScheduledTask;
            if (hVar == null) {
                return -2;
            }
            if (z) {
                boolean z2 = true;
                if (hVar.f4266b.mo35624i() != 1) {
                    z2 = false;
                }
                if (!z2) {
                    return -2;
                }
            }
            if (((C2598f) C2603k.f4272e) != null) {
                long nanoTime = System.nanoTime() - hVar.f4265a;
                long j = C2603k.f4268a;
                if (nanoTime < j) {
                    return j - nanoTime;
                }
            } else {
                throw null;
            }
        } while (!f4273b.compareAndSet(mVar, hVar, (Object) null));
        mo35629a(hVar, false);
        return -1;
    }
}
