package p041io.realm.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/* renamed from: io.realm.internal.NativeObjectReference */
final class NativeObjectReference extends PhantomReference<NativeObject> {
    private static ReferencePool referencePool = new ReferencePool();
    private final NativeContext context;
    private final long nativeFinalizerPtr;
    private final long nativePtr;
    /* access modifiers changed from: private */
    public NativeObjectReference next;
    /* access modifiers changed from: private */
    public NativeObjectReference prev;

    /* renamed from: io.realm.internal.NativeObjectReference$ReferencePool */
    private static class ReferencePool {
        NativeObjectReference head;

        private ReferencePool() {
        }

        /* access modifiers changed from: package-private */
        public synchronized void add(NativeObjectReference nativeObjectReference) {
            NativeObjectReference unused = nativeObjectReference.prev = null;
            NativeObjectReference unused2 = nativeObjectReference.next = this.head;
            if (this.head != null) {
                NativeObjectReference unused3 = this.head.prev = nativeObjectReference;
            }
            this.head = nativeObjectReference;
        }

        /* access modifiers changed from: package-private */
        public synchronized void remove(NativeObjectReference nativeObjectReference) {
            NativeObjectReference access$100 = nativeObjectReference.next;
            NativeObjectReference access$000 = nativeObjectReference.prev;
            NativeObjectReference unused = nativeObjectReference.next = null;
            NativeObjectReference unused2 = nativeObjectReference.prev = null;
            if (access$000 != null) {
                NativeObjectReference unused3 = access$000.next = access$100;
            } else {
                this.head = access$100;
            }
            if (access$100 != null) {
                NativeObjectReference unused4 = access$100.prev = access$000;
            }
        }
    }

    NativeObjectReference(NativeContext nativeContext, NativeObject nativeObject, ReferenceQueue<? super NativeObject> referenceQueue) {
        super(nativeObject, referenceQueue);
        this.nativePtr = nativeObject.getNativePtr();
        this.nativeFinalizerPtr = nativeObject.getNativeFinalizerPtr();
        this.context = nativeContext;
        referencePool.add(this);
    }

    private static native void nativeCleanUp(long j, long j2);

    /* access modifiers changed from: package-private */
    public void cleanup() {
        synchronized (this.context) {
            nativeCleanUp(this.nativeFinalizerPtr, this.nativePtr);
        }
        referencePool.remove(this);
    }
}
