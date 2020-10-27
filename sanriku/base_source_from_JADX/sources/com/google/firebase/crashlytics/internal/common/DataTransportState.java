package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;

public enum DataTransportState {
    NONE,
    JAVA_ONLY,
    ALL;
    
    static final int REPORT_UPLOAD_VARIANT_DATATRANSPORT = 2;
    static final int REPORT_UPLOAD_VARIANT_LEGACY = 1;

    @NonNull
    static DataTransportState getState(@NonNull AppSettingsData appSettingsData) {
        boolean z = true;
        boolean z2 = appSettingsData.reportUploadVariant == 2;
        if (appSettingsData.nativeReportUploadVariant != 2) {
            z = false;
        }
        return getState(z2, z);
    }

    @NonNull
    static DataTransportState getState(boolean z, boolean z2) {
        return !z ? NONE : !z2 ? JAVA_ONLY : ALL;
    }
}
