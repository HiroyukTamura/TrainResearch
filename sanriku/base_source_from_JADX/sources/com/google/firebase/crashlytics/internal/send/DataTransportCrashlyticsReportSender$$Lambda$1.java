package com.google.firebase.crashlytics.internal.send;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import p009e.p028d.p030b.p031a.C0881h;

final /* synthetic */ class DataTransportCrashlyticsReportSender$$Lambda$1 implements C0881h {
    private final TaskCompletionSource arg$1;
    private final CrashlyticsReportWithSessionId arg$2;

    private DataTransportCrashlyticsReportSender$$Lambda$1(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.arg$1 = taskCompletionSource;
        this.arg$2 = crashlyticsReportWithSessionId;
    }

    public static C0881h lambdaFactory$(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        return new DataTransportCrashlyticsReportSender$$Lambda$1(taskCompletionSource, crashlyticsReportWithSessionId);
    }

    public void onSchedule(Exception exc) {
        DataTransportCrashlyticsReportSender.lambda$sendReport$1(this.arg$1, this.arg$2, exc);
    }
}
