package p041io.realm.internal;

import java.lang.ref.ReferenceQueue;

/* renamed from: io.realm.internal.NativeContext */
public class NativeContext {
    public static final NativeContext dummyContext = new NativeContext();
    private static final Thread finalizingThread = new Thread(new FinalizerRunnable(referenceQueue));
    private static final ReferenceQueue<NativeObject> referenceQueue = new ReferenceQueue<>();

    static {
        finalizingThread.setName("RealmFinalizingDaemon");
        finalizingThread.start();
    }

    public void addReference(NativeObject nativeObject) {
        new NativeObjectReference(this, nativeObject, referenceQueue);
    }
}
