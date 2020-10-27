package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage */
final class C1307xfe724d07 extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage {
    private final long baseAddress;
    private final String name;
    private final long size;
    private final String uuid;

    /* renamed from: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$Builder */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {
        private Long baseAddress;
        private String name;
        private Long size;
        private String uuid;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage build() {
            String str = this.baseAddress == null ? " baseAddress" : "";
            if (this.size == null) {
                str = C0681a.m320a(str, " size");
            }
            if (this.name == null) {
                str = C0681a.m320a(str, " name");
            }
            if (str.isEmpty()) {
                return new C1307xfe724d07(this.baseAddress.longValue(), this.size.longValue(), this.name, this.uuid);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setBaseAddress(long j) {
            this.baseAddress = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setName(String str) {
            if (str != null) {
                this.name = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setSize(long j) {
            this.size = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setUuid(@Nullable String str) {
            this.uuid = str;
            return this;
        }
    }

    private C1307xfe724d07(long j, long j2, String str, @Nullable String str2) {
        this.baseAddress = j;
        this.size = j2;
        this.name = str;
        this.uuid = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
        if (this.baseAddress == binaryImage.getBaseAddress() && this.size == binaryImage.getSize() && this.name.equals(binaryImage.getName())) {
            String str = this.uuid;
            String uuid2 = binaryImage.getUuid();
            if (str == null) {
                if (uuid2 == null) {
                    return true;
                }
            } else if (str.equals(uuid2)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public long getBaseAddress() {
        return this.baseAddress;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    @Encodable.Ignore
    @Nullable
    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        long j = this.baseAddress;
        long j2 = this.size;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.name.hashCode()) * 1000003;
        String str = this.uuid;
        return (str == null ? 0 : str.hashCode()) ^ hashCode;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("BinaryImage{baseAddress=");
        a.append(this.baseAddress);
        a.append(", size=");
        a.append(this.size);
        a.append(", name=");
        a.append(this.name);
        a.append(", uuid=");
        return C0681a.m324a(a, this.uuid, "}");
    }
}
