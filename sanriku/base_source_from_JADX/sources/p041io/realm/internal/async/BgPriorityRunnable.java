package p041io.realm.internal.async;

import android.os.Process;

/* renamed from: io.realm.internal.async.BgPriorityRunnable */
public class BgPriorityRunnable implements Runnable {
    private final Runnable runnable;

    BgPriorityRunnable(Runnable runnable2) {
        this.runnable = runnable2;
    }

    public void run() {
        Process.setThreadPriority(10);
        this.runnable.run();
    }
}
