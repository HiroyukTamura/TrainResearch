package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {
    static final String APP_EXCEPTION_EVENT_NAME = "_ae";
    private final CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
    private boolean callbackReceived = false;
    private CountDownLatch eventLatch;
    private final Object latchLock = new Object();
    private final TimeUnit timeUnit;
    private final int timeout;

    public BlockingAnalyticsEventLogger(@NonNull CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i, TimeUnit timeUnit2) {
        this.baseAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
        this.timeout = i;
        this.timeUnit = timeUnit2;
    }

    /* access modifiers changed from: package-private */
    public boolean isCallbackReceived() {
        return this.callbackReceived;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        com.google.firebase.crashlytics.internal.Logger.getLogger().mo25712d("Interrupted while awaiting app exception callback from FA listener.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void logEvent(@androidx.annotation.NonNull java.lang.String r6, @androidx.annotation.Nullable android.os.Bundle r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.latchLock
            monitor-enter(r0)
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = "Logging Crashlytics event to Firebase"
            r1.mo25712d(r2)     // Catch:{ all -> 0x0053 }
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x0053 }
            r2 = 1
            r1.<init>(r2)     // Catch:{ all -> 0x0053 }
            r5.eventLatch = r1     // Catch:{ all -> 0x0053 }
            r1 = 0
            r5.callbackReceived = r1     // Catch:{ all -> 0x0053 }
            com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger r1 = r5.baseAnalyticsEventLogger     // Catch:{ all -> 0x0053 }
            r1.logEvent(r6, r7)     // Catch:{ all -> 0x0053 }
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0053 }
            java.lang.String r7 = "Awaiting app exception callback from FA..."
            r6.mo25712d(r7)     // Catch:{ all -> 0x0053 }
            java.util.concurrent.CountDownLatch r6 = r5.eventLatch     // Catch:{ InterruptedException -> 0x0045 }
            int r7 = r5.timeout     // Catch:{ InterruptedException -> 0x0045 }
            long r3 = (long) r7     // Catch:{ InterruptedException -> 0x0045 }
            java.util.concurrent.TimeUnit r7 = r5.timeUnit     // Catch:{ InterruptedException -> 0x0045 }
            boolean r6 = r6.await(r3, r7)     // Catch:{ InterruptedException -> 0x0045 }
            if (r6 == 0) goto L_0x003e
            r5.callbackReceived = r2     // Catch:{ InterruptedException -> 0x0045 }
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.String r7 = "App exception callback received from FA listener."
        L_0x003a:
            r6.mo25712d(r7)     // Catch:{ InterruptedException -> 0x0045 }
            goto L_0x004e
        L_0x003e:
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ InterruptedException -> 0x0045 }
            java.lang.String r7 = "Timeout exceeded while awaiting app exception callback from FA listener."
            goto L_0x003a
        L_0x0045:
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0053 }
            java.lang.String r7 = "Interrupted while awaiting app exception callback from FA listener."
            r6.mo25712d(r7)     // Catch:{ all -> 0x0053 }
        L_0x004e:
            r6 = 0
            r5.eventLatch = r6     // Catch:{ all -> 0x0053 }
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            return
        L_0x0053:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0053 }
            goto L_0x0057
        L_0x0056:
            throw r6
        L_0x0057:
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger.logEvent(java.lang.String, android.os.Bundle):void");
    }

    public void onEvent(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.eventLatch;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
