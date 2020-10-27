package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

public abstract class CrashlyticsReportWithSessionId {
    @NonNull
    public static CrashlyticsReportWithSessionId create(CrashlyticsReport crashlyticsReport, String str) {
        return new AutoValue_CrashlyticsReportWithSessionId(crashlyticsReport, str);
    }

    public abstract CrashlyticsReport getReport();

    public abstract String getSessionId();
}
