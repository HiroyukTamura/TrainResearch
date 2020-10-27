package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import p009e.p010a.p011a.p012a.C0681a;

final class AutoValue_CrashlyticsReport_Session_Event extends CrashlyticsReport.Session.Event {
    private final CrashlyticsReport.Session.Event.Application app;
    private final CrashlyticsReport.Session.Event.Device device;
    private final CrashlyticsReport.Session.Event.Log log;
    private final long timestamp;
    private final String type;

    static final class Builder extends CrashlyticsReport.Session.Event.Builder {
        private CrashlyticsReport.Session.Event.Application app;
        private CrashlyticsReport.Session.Event.Device device;
        private CrashlyticsReport.Session.Event.Log log;
        private Long timestamp;
        private String type;

        Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event event) {
            this.timestamp = Long.valueOf(event.getTimestamp());
            this.type = event.getType();
            this.app = event.getApp();
            this.device = event.getDevice();
            this.log = event.getLog();
        }

        public CrashlyticsReport.Session.Event build() {
            String str = this.timestamp == null ? " timestamp" : "";
            if (this.type == null) {
                str = C0681a.m320a(str, " type");
            }
            if (this.app == null) {
                str = C0681a.m320a(str, " app");
            }
            if (this.device == null) {
                str = C0681a.m320a(str, " device");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event(this.timestamp.longValue(), this.type, this.app, this.device, this.log);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }

        public CrashlyticsReport.Session.Event.Builder setApp(CrashlyticsReport.Session.Event.Application application) {
            if (application != null) {
                this.app = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public CrashlyticsReport.Session.Event.Builder setDevice(CrashlyticsReport.Session.Event.Device device2) {
            if (device2 != null) {
                this.device = device2;
                return this;
            }
            throw new NullPointerException("Null device");
        }

        public CrashlyticsReport.Session.Event.Builder setLog(CrashlyticsReport.Session.Event.Log log2) {
            this.log = log2;
            return this;
        }

        public CrashlyticsReport.Session.Event.Builder setTimestamp(long j) {
            this.timestamp = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Event.Builder setType(String str) {
            if (str != null) {
                this.type = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event(long j, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device2, @Nullable CrashlyticsReport.Session.Event.Log log2) {
        this.timestamp = j;
        this.type = str;
        this.app = application;
        this.device = device2;
        this.log = log2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event)) {
            return false;
        }
        CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
        if (this.timestamp == event.getTimestamp() && this.type.equals(event.getType()) && this.app.equals(event.getApp()) && this.device.equals(event.getDevice())) {
            CrashlyticsReport.Session.Event.Log log2 = this.log;
            CrashlyticsReport.Session.Event.Log log3 = event.getLog();
            if (log2 == null) {
                if (log3 == null) {
                    return true;
                }
            } else if (log2.equals(log3)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application getApp() {
        return this.app;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Device getDevice() {
        return this.device;
    }

    @Nullable
    public CrashlyticsReport.Session.Event.Log getLog() {
        return this.log;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    @NonNull
    public String getType() {
        return this.type;
    }

    public int hashCode() {
        long j = this.timestamp;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.app.hashCode()) * 1000003) ^ this.device.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log2 = this.log;
        return (log2 == null ? 0 : log2.hashCode()) ^ hashCode;
    }

    public CrashlyticsReport.Session.Event.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("Event{timestamp=");
        a.append(this.timestamp);
        a.append(", type=");
        a.append(this.type);
        a.append(", app=");
        a.append(this.app);
        a.append(", device=");
        a.append(this.device);
        a.append(", log=");
        a.append(this.log);
        a.append("}");
        return a.toString();
    }
}
