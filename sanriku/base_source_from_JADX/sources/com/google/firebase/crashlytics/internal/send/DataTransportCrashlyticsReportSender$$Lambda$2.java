package com.google.firebase.crashlytics.internal.send;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.nio.charset.Charset;
import p009e.p028d.p030b.p031a.C0878e;

final /* synthetic */ class DataTransportCrashlyticsReportSender$$Lambda$2 implements C0878e {
    private static final DataTransportCrashlyticsReportSender$$Lambda$2 instance = new DataTransportCrashlyticsReportSender$$Lambda$2();

    private DataTransportCrashlyticsReportSender$$Lambda$2() {
    }

    public static C0878e lambdaFactory$() {
        return instance;
    }

    public Object apply(Object obj) {
        return DataTransportCrashlyticsReportSender.TRANSFORM.reportToJson((CrashlyticsReport) obj).getBytes(Charset.forName("UTF-8"));
    }
}
