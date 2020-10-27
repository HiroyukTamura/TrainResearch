package p041io.realm.internal.android;

import android.os.Looper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import p009e.p010a.p011a.p012a.C0681a;
import p041io.realm.internal.Capabilities;

/* renamed from: io.realm.internal.android.AndroidCapabilities */
public class AndroidCapabilities implements Capabilities {
    @SuppressFBWarnings({"MS_SHOULD_BE_FINAL"})
    public static boolean EMULATE_MAIN_THREAD = false;
    private final boolean isIntentServiceThread = isIntentServiceThread();
    private final Looper looper = Looper.myLooper();

    private boolean hasLooper() {
        return this.looper != null;
    }

    private static boolean isIntentServiceThread() {
        String name = Thread.currentThread().getName();
        return name != null && name.startsWith("IntentService[");
    }

    public boolean canDeliverNotification() {
        return hasLooper() && !this.isIntentServiceThread;
    }

    public void checkCanDeliverNotification(String str) {
        String str2 = "";
        if (!hasLooper()) {
            if (str != null) {
                str2 = C0681a.m321a(str, " ", "Realm cannot be automatically updated on a thread without a looper.");
            }
            throw new IllegalStateException(str2);
        } else if (this.isIntentServiceThread) {
            if (str != null) {
                str2 = C0681a.m321a(str, " ", "Realm cannot be automatically updated on an IntentService thread.");
            }
            throw new IllegalStateException(str2);
        }
    }

    public boolean isMainThread() {
        Looper looper2 = this.looper;
        return looper2 != null && (EMULATE_MAIN_THREAD || looper2 == Looper.getMainLooper());
    }
}
