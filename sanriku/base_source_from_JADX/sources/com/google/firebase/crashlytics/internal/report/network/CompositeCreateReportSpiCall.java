package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;

public class CompositeCreateReportSpiCall implements CreateReportSpiCall {
    private final DefaultCreateReportSpiCall javaReportSpiCall;
    private final NativeCreateReportSpiCall nativeReportSpiCall;

    /* renamed from: com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall$1 */
    static /* synthetic */ class C13281 {

        /* renamed from: $SwitchMap$com$google$firebase$crashlytics$internal$report$model$Report$Type */
        static final /* synthetic */ int[] f1359xc221d5a6;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.google.firebase.crashlytics.internal.report.model.Report$Type[] r0 = com.google.firebase.crashlytics.internal.report.model.Report.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1359xc221d5a6 = r0
                r1 = 1
                com.google.firebase.crashlytics.internal.report.model.Report$Type r2 = com.google.firebase.crashlytics.internal.report.model.Report.Type.JAVA     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f1359xc221d5a6     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.google.firebase.crashlytics.internal.report.model.Report$Type r2 = com.google.firebase.crashlytics.internal.report.model.Report.Type.NATIVE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall.C13281.<clinit>():void");
        }
    }

    public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall defaultCreateReportSpiCall, NativeCreateReportSpiCall nativeCreateReportSpiCall) {
        this.javaReportSpiCall = defaultCreateReportSpiCall;
        this.nativeReportSpiCall = nativeCreateReportSpiCall;
    }

    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        int ordinal = createReportRequest.report.getType().ordinal();
        if (ordinal == 0) {
            this.javaReportSpiCall.invoke(createReportRequest, z);
            return true;
        } else if (ordinal != 1) {
            return false;
        } else {
            this.nativeReportSpiCall.invoke(createReportRequest, z);
            return true;
        }
    }
}
