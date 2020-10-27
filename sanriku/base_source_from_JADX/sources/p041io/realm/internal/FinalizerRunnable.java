package p041io.realm.internal;

import java.lang.ref.ReferenceQueue;
import p041io.realm.log.RealmLog;

/* renamed from: io.realm.internal.FinalizerRunnable */
class FinalizerRunnable implements Runnable {
    private final ReferenceQueue<NativeObject> referenceQueue;

    FinalizerRunnable(ReferenceQueue<NativeObject> referenceQueue2) {
        this.referenceQueue = referenceQueue2;
    }

    public void run() {
        while (true) {
            try {
                ((NativeObjectReference) this.referenceQueue.remove()).cleanup();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                RealmLog.fatal("The FinalizerRunnable thread has been interrupted. Native resources cannot be freed anymore", new Object[0]);
                return;
            }
        }
    }
}
