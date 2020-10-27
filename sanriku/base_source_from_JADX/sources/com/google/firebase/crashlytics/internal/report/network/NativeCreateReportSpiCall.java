package com.google.firebase.crashlytics.internal.report.network;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.ResponseParser;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.io.IOException;
import p009e.p010a.p011a.p012a.C0681a;

public class NativeCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    private static final String APP_META_FILE_MULTIPART_PARAM = "app_meta_file";
    private static final String BINARY_IMAGES_FILE_MULTIPART_PARAM = "binary_images_file";
    private static final String DEVICE_META_FILE_MULTIPART_PARAM = "device_meta_file";
    private static final String GZIP_FILE_CONTENT_TYPE = "application/octet-stream";
    private static final String KEYS_FILE_MULTIPART_PARAM = "keys_file";
    private static final String LOGS_FILE_MULTIPART_PARAM = "logs_file";
    private static final String METADATA_FILE_MULTIPART_PARAM = "crash_meta_file";
    private static final String MINIDUMP_FILE_MULTIPART_PARAM = "minidump_file";
    static final String ORGANIZATION_IDENTIFIER_PARAM = "org_id";
    private static final String OS_META_FILE_MULTIPART_PARAM = "os_meta_file";
    private static final String REPORT_IDENTIFIER_PARAM = "report_id";
    private static final String SESSION_META_FILE_MULTIPART_PARAM = "session_meta_file";
    private static final String USER_META_FILE_MULTIPART_PARAM = "user_meta_file";
    private final String version;

    public NativeCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(str, str2, httpRequestFactory, HttpMethod.POST);
        this.version = str3;
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, String str) {
        StringBuilder a = C0681a.m330a(AbstractSpiCall.CRASHLYTICS_USER_AGENT);
        a.append(CrashlyticsCore.getVersion());
        httpRequest.header(AbstractSpiCall.HEADER_USER_AGENT, a.toString()).header(AbstractSpiCall.HEADER_CLIENT_TYPE, AbstractSpiCall.ANDROID_CLIENT_TYPE).header(AbstractSpiCall.HEADER_CLIENT_VERSION, this.version).header(AbstractSpiCall.HEADER_GOOGLE_APP_ID, str);
        return httpRequest;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, @Nullable String str, Report report) {
        String name;
        String str2;
        if (str != null) {
            httpRequest.part("org_id", str);
        }
        httpRequest.part(REPORT_IDENTIFIER_PARAM, report.getIdentifier());
        for (File file : report.getFiles()) {
            if (file.getName().equals("minidump")) {
                name = file.getName();
                str2 = MINIDUMP_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("metadata")) {
                name = file.getName();
                str2 = METADATA_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("binaryImages")) {
                name = file.getName();
                str2 = BINARY_IMAGES_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("session")) {
                name = file.getName();
                str2 = SESSION_META_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("app")) {
                name = file.getName();
                str2 = APP_META_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("device")) {
                name = file.getName();
                str2 = DEVICE_META_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("os")) {
                name = file.getName();
                str2 = OS_META_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("user")) {
                name = file.getName();
                str2 = USER_META_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("logs")) {
                name = file.getName();
                str2 = LOGS_FILE_MULTIPART_PARAM;
            } else if (file.getName().equals("keys")) {
                name = file.getName();
                str2 = KEYS_FILE_MULTIPART_PARAM;
            }
            httpRequest.part(str2, name, GZIP_FILE_CONTENT_TYPE, file);
        }
        return httpRequest;
    }

    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        if (z) {
            HttpRequest applyMultipartDataTo = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), createReportRequest.googleAppId), createReportRequest.organizationId, createReportRequest.report);
            Logger logger = Logger.getLogger();
            StringBuilder a = C0681a.m330a("Sending report to: ");
            a.append(getUrl());
            logger.mo25712d(a.toString());
            try {
                int code = applyMultipartDataTo.execute().code();
                Logger logger2 = Logger.getLogger();
                logger2.mo25712d("Result was: " + code);
                return ResponseParser.parse(code) == 0;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }
}
