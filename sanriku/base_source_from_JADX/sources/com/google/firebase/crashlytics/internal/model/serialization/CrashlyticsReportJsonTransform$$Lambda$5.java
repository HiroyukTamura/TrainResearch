package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

final /* synthetic */ class CrashlyticsReportJsonTransform$$Lambda$5 implements CrashlyticsReportJsonTransform.ObjectParser {
    private static final CrashlyticsReportJsonTransform$$Lambda$5 instance = new CrashlyticsReportJsonTransform$$Lambda$5();

    private CrashlyticsReportJsonTransform$$Lambda$5() {
    }

    public static CrashlyticsReportJsonTransform.ObjectParser lambdaFactory$() {
        return instance;
    }

    public Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventBinaryImage(jsonReader);
    }
}
