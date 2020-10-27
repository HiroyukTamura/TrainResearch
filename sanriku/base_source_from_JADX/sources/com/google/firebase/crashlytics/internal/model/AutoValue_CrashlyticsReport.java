package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import p009e.p010a.p011a.p012a.C0681a;

final class AutoValue_CrashlyticsReport extends CrashlyticsReport {
    private final String buildVersion;
    private final String displayVersion;
    private final String gmpAppId;
    private final String installationUuid;
    private final CrashlyticsReport.FilesPayload ndkPayload;
    private final int platform;
    private final String sdkVersion;
    private final CrashlyticsReport.Session session;

    static final class Builder extends CrashlyticsReport.Builder {
        private String buildVersion;
        private String displayVersion;
        private String gmpAppId;
        private String installationUuid;
        private CrashlyticsReport.FilesPayload ndkPayload;
        private Integer platform;
        private String sdkVersion;
        private CrashlyticsReport.Session session;

        Builder() {
        }

        private Builder(CrashlyticsReport crashlyticsReport) {
            this.sdkVersion = crashlyticsReport.getSdkVersion();
            this.gmpAppId = crashlyticsReport.getGmpAppId();
            this.platform = Integer.valueOf(crashlyticsReport.getPlatform());
            this.installationUuid = crashlyticsReport.getInstallationUuid();
            this.buildVersion = crashlyticsReport.getBuildVersion();
            this.displayVersion = crashlyticsReport.getDisplayVersion();
            this.session = crashlyticsReport.getSession();
            this.ndkPayload = crashlyticsReport.getNdkPayload();
        }

        public CrashlyticsReport build() {
            String str = this.sdkVersion == null ? " sdkVersion" : "";
            if (this.gmpAppId == null) {
                str = C0681a.m320a(str, " gmpAppId");
            }
            if (this.platform == null) {
                str = C0681a.m320a(str, " platform");
            }
            if (this.installationUuid == null) {
                str = C0681a.m320a(str, " installationUuid");
            }
            if (this.buildVersion == null) {
                str = C0681a.m320a(str, " buildVersion");
            }
            if (this.displayVersion == null) {
                str = C0681a.m320a(str, " displayVersion");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport(this.sdkVersion, this.gmpAppId, this.platform.intValue(), this.installationUuid, this.buildVersion, this.displayVersion, this.session, this.ndkPayload);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }

        public CrashlyticsReport.Builder setBuildVersion(String str) {
            if (str != null) {
                this.buildVersion = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public CrashlyticsReport.Builder setDisplayVersion(String str) {
            if (str != null) {
                this.displayVersion = str;
                return this;
            }
            throw new NullPointerException("Null displayVersion");
        }

        public CrashlyticsReport.Builder setGmpAppId(String str) {
            if (str != null) {
                this.gmpAppId = str;
                return this;
            }
            throw new NullPointerException("Null gmpAppId");
        }

        public CrashlyticsReport.Builder setInstallationUuid(String str) {
            if (str != null) {
                this.installationUuid = str;
                return this;
            }
            throw new NullPointerException("Null installationUuid");
        }

        public CrashlyticsReport.Builder setNdkPayload(CrashlyticsReport.FilesPayload filesPayload) {
            this.ndkPayload = filesPayload;
            return this;
        }

        public CrashlyticsReport.Builder setPlatform(int i) {
            this.platform = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Builder setSdkVersion(String str) {
            if (str != null) {
                this.sdkVersion = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        public CrashlyticsReport.Builder setSession(CrashlyticsReport.Session session2) {
            this.session = session2;
            return this;
        }
    }

    private AutoValue_CrashlyticsReport(String str, String str2, int i, String str3, String str4, String str5, @Nullable CrashlyticsReport.Session session2, @Nullable CrashlyticsReport.FilesPayload filesPayload) {
        this.sdkVersion = str;
        this.gmpAppId = str2;
        this.platform = i;
        this.installationUuid = str3;
        this.buildVersion = str4;
        this.displayVersion = str5;
        this.session = session2;
        this.ndkPayload = filesPayload;
    }

    public boolean equals(Object obj) {
        CrashlyticsReport.Session session2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.sdkVersion.equals(crashlyticsReport.getSdkVersion()) && this.gmpAppId.equals(crashlyticsReport.getGmpAppId()) && this.platform == crashlyticsReport.getPlatform() && this.installationUuid.equals(crashlyticsReport.getInstallationUuid()) && this.buildVersion.equals(crashlyticsReport.getBuildVersion()) && this.displayVersion.equals(crashlyticsReport.getDisplayVersion()) && ((session2 = this.session) != null ? session2.equals(crashlyticsReport.getSession()) : crashlyticsReport.getSession() == null)) {
            CrashlyticsReport.FilesPayload filesPayload = this.ndkPayload;
            CrashlyticsReport.FilesPayload ndkPayload2 = crashlyticsReport.getNdkPayload();
            if (filesPayload == null) {
                if (ndkPayload2 == null) {
                    return true;
                }
            } else if (filesPayload.equals(ndkPayload2)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public String getBuildVersion() {
        return this.buildVersion;
    }

    @NonNull
    public String getDisplayVersion() {
        return this.displayVersion;
    }

    @NonNull
    public String getGmpAppId() {
        return this.gmpAppId;
    }

    @NonNull
    public String getInstallationUuid() {
        return this.installationUuid;
    }

    @Nullable
    public CrashlyticsReport.FilesPayload getNdkPayload() {
        return this.ndkPayload;
    }

    public int getPlatform() {
        return this.platform;
    }

    @NonNull
    public String getSdkVersion() {
        return this.sdkVersion;
    }

    @Nullable
    public CrashlyticsReport.Session getSession() {
        return this.session;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.sdkVersion.hashCode() ^ 1000003) * 1000003) ^ this.gmpAppId.hashCode()) * 1000003) ^ this.platform) * 1000003) ^ this.installationUuid.hashCode()) * 1000003) ^ this.buildVersion.hashCode()) * 1000003) ^ this.displayVersion.hashCode()) * 1000003;
        CrashlyticsReport.Session session2 = this.session;
        int i = 0;
        int hashCode2 = (hashCode ^ (session2 == null ? 0 : session2.hashCode())) * 1000003;
        CrashlyticsReport.FilesPayload filesPayload = this.ndkPayload;
        if (filesPayload != null) {
            i = filesPayload.hashCode();
        }
        return hashCode2 ^ i;
    }

    /* access modifiers changed from: protected */
    public CrashlyticsReport.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("CrashlyticsReport{sdkVersion=");
        a.append(this.sdkVersion);
        a.append(", gmpAppId=");
        a.append(this.gmpAppId);
        a.append(", platform=");
        a.append(this.platform);
        a.append(", installationUuid=");
        a.append(this.installationUuid);
        a.append(", buildVersion=");
        a.append(this.buildVersion);
        a.append(", displayVersion=");
        a.append(this.displayVersion);
        a.append(", session=");
        a.append(this.session);
        a.append(", ndkPayload=");
        a.append(this.ndkPayload);
        a.append("}");
        return a.toString();
    }
}
