package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;
import p009e.p010a.p011a.p012a.C0681a;

final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {
    private final CrashlyticsReport.Session.Application app;
    private final boolean crashed;
    private final CrashlyticsReport.Session.Device device;
    private final Long endedAt;
    private final ImmutableList<CrashlyticsReport.Session.Event> events;
    private final String generator;
    private final int generatorType;
    private final String identifier;

    /* renamed from: os */
    private final CrashlyticsReport.Session.OperatingSystem f1355os;
    private final long startedAt;
    private final CrashlyticsReport.Session.User user;

    static final class Builder extends CrashlyticsReport.Session.Builder {
        private CrashlyticsReport.Session.Application app;
        private Boolean crashed;
        private CrashlyticsReport.Session.Device device;
        private Long endedAt;
        private ImmutableList<CrashlyticsReport.Session.Event> events;
        private String generator;
        private Integer generatorType;
        private String identifier;

        /* renamed from: os */
        private CrashlyticsReport.Session.OperatingSystem f1356os;
        private Long startedAt;
        private CrashlyticsReport.Session.User user;

        Builder() {
        }

        private Builder(CrashlyticsReport.Session session) {
            this.generator = session.getGenerator();
            this.identifier = session.getIdentifier();
            this.startedAt = Long.valueOf(session.getStartedAt());
            this.endedAt = session.getEndedAt();
            this.crashed = Boolean.valueOf(session.isCrashed());
            this.app = session.getApp();
            this.user = session.getUser();
            this.f1356os = session.getOs();
            this.device = session.getDevice();
            this.events = session.getEvents();
            this.generatorType = Integer.valueOf(session.getGeneratorType());
        }

        public CrashlyticsReport.Session build() {
            String str = this.generator == null ? " generator" : "";
            if (this.identifier == null) {
                str = C0681a.m320a(str, " identifier");
            }
            if (this.startedAt == null) {
                str = C0681a.m320a(str, " startedAt");
            }
            if (this.crashed == null) {
                str = C0681a.m320a(str, " crashed");
            }
            if (this.app == null) {
                str = C0681a.m320a(str, " app");
            }
            if (this.generatorType == null) {
                str = C0681a.m320a(str, " generatorType");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session(this.generator, this.identifier, this.startedAt.longValue(), this.endedAt, this.crashed.booleanValue(), this.app, this.user, this.f1356os, this.device, this.events, this.generatorType.intValue());
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }

        public CrashlyticsReport.Session.Builder setApp(CrashlyticsReport.Session.Application application) {
            if (application != null) {
                this.app = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public CrashlyticsReport.Session.Builder setCrashed(boolean z) {
            this.crashed = Boolean.valueOf(z);
            return this;
        }

        public CrashlyticsReport.Session.Builder setDevice(CrashlyticsReport.Session.Device device2) {
            this.device = device2;
            return this;
        }

        public CrashlyticsReport.Session.Builder setEndedAt(Long l) {
            this.endedAt = l;
            return this;
        }

        public CrashlyticsReport.Session.Builder setEvents(ImmutableList<CrashlyticsReport.Session.Event> immutableList) {
            this.events = immutableList;
            return this;
        }

        public CrashlyticsReport.Session.Builder setGenerator(String str) {
            if (str != null) {
                this.generator = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        public CrashlyticsReport.Session.Builder setGeneratorType(int i) {
            this.generatorType = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.Session.Builder setIdentifier(String str) {
            if (str != null) {
                this.identifier = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public CrashlyticsReport.Session.Builder setOs(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.f1356os = operatingSystem;
            return this;
        }

        public CrashlyticsReport.Session.Builder setStartedAt(long j) {
            this.startedAt = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.Session.Builder setUser(CrashlyticsReport.Session.User user2) {
            this.user = user2;
            return this;
        }
    }

    private AutoValue_CrashlyticsReport_Session(String str, String str2, long j, @Nullable Long l, boolean z, CrashlyticsReport.Session.Application application, @Nullable CrashlyticsReport.Session.User user2, @Nullable CrashlyticsReport.Session.OperatingSystem operatingSystem, @Nullable CrashlyticsReport.Session.Device device2, @Nullable ImmutableList<CrashlyticsReport.Session.Event> immutableList, int i) {
        this.generator = str;
        this.identifier = str2;
        this.startedAt = j;
        this.endedAt = l;
        this.crashed = z;
        this.app = application;
        this.user = user2;
        this.f1355os = operatingSystem;
        this.device = device2;
        this.events = immutableList;
        this.generatorType = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        r1 = r7.endedAt;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r1 = r7.user;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        r1 = r7.f1355os;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
        r1 = r7.device;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        r1 = r7.events;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
            r2 = 0
            if (r1 == 0) goto L_0x00b5
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session r8 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session) r8
            java.lang.String r1 = r7.generator
            java.lang.String r3 = r8.getGenerator()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
            java.lang.String r1 = r7.identifier
            java.lang.String r3 = r8.getIdentifier()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
            long r3 = r7.startedAt
            long r5 = r8.getStartedAt()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x00b3
            java.lang.Long r1 = r7.endedAt
            if (r1 != 0) goto L_0x0038
            java.lang.Long r1 = r8.getEndedAt()
            if (r1 != 0) goto L_0x00b3
            goto L_0x0042
        L_0x0038:
            java.lang.Long r3 = r8.getEndedAt()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x0042:
            boolean r1 = r7.crashed
            boolean r3 = r8.isCrashed()
            if (r1 != r3) goto L_0x00b3
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application r1 = r7.app
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application r3 = r8.getApp()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r1 = r7.user
            if (r1 != 0) goto L_0x0061
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r1 = r8.getUser()
            if (r1 != 0) goto L_0x00b3
            goto L_0x006b
        L_0x0061:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r3 = r8.getUser()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x006b:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r1 = r7.f1355os
            if (r1 != 0) goto L_0x0076
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r1 = r8.getOs()
            if (r1 != 0) goto L_0x00b3
            goto L_0x0080
        L_0x0076:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r3 = r8.getOs()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x0080:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r1 = r7.device
            if (r1 != 0) goto L_0x008b
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r1 = r8.getDevice()
            if (r1 != 0) goto L_0x00b3
            goto L_0x0095
        L_0x008b:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r3 = r8.getDevice()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x0095:
            com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event> r1 = r7.events
            if (r1 != 0) goto L_0x00a0
            com.google.firebase.crashlytics.internal.model.ImmutableList r1 = r8.getEvents()
            if (r1 != 0) goto L_0x00b3
            goto L_0x00aa
        L_0x00a0:
            com.google.firebase.crashlytics.internal.model.ImmutableList r3 = r8.getEvents()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x00aa:
            int r1 = r7.generatorType
            int r8 = r8.getGeneratorType()
            if (r1 != r8) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r0 = 0
        L_0x00b4:
            return r0
        L_0x00b5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session.equals(java.lang.Object):boolean");
    }

    @NonNull
    public CrashlyticsReport.Session.Application getApp() {
        return this.app;
    }

    @Nullable
    public CrashlyticsReport.Session.Device getDevice() {
        return this.device;
    }

    @Nullable
    public Long getEndedAt() {
        return this.endedAt;
    }

    @Nullable
    public ImmutableList<CrashlyticsReport.Session.Event> getEvents() {
        return this.events;
    }

    @NonNull
    public String getGenerator() {
        return this.generator;
    }

    public int getGeneratorType() {
        return this.generatorType;
    }

    @NonNull
    @Encodable.Ignore
    public String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    public CrashlyticsReport.Session.OperatingSystem getOs() {
        return this.f1355os;
    }

    public long getStartedAt() {
        return this.startedAt;
    }

    @Nullable
    public CrashlyticsReport.Session.User getUser() {
        return this.user;
    }

    public int hashCode() {
        long j = this.startedAt;
        int hashCode = (((((this.generator.hashCode() ^ 1000003) * 1000003) ^ this.identifier.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l = this.endedAt;
        int i = 0;
        int hashCode2 = (((((hashCode ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.crashed ? 1231 : 1237)) * 1000003) ^ this.app.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user2 = this.user;
        int hashCode3 = (hashCode2 ^ (user2 == null ? 0 : user2.hashCode())) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.f1355os;
        int hashCode4 = (hashCode3 ^ (operatingSystem == null ? 0 : operatingSystem.hashCode())) * 1000003;
        CrashlyticsReport.Session.Device device2 = this.device;
        int hashCode5 = (hashCode4 ^ (device2 == null ? 0 : device2.hashCode())) * 1000003;
        ImmutableList<CrashlyticsReport.Session.Event> immutableList = this.events;
        if (immutableList != null) {
            i = immutableList.hashCode();
        }
        return ((hashCode5 ^ i) * 1000003) ^ this.generatorType;
    }

    public boolean isCrashed() {
        return this.crashed;
    }

    public CrashlyticsReport.Session.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("Session{generator=");
        a.append(this.generator);
        a.append(", identifier=");
        a.append(this.identifier);
        a.append(", startedAt=");
        a.append(this.startedAt);
        a.append(", endedAt=");
        a.append(this.endedAt);
        a.append(", crashed=");
        a.append(this.crashed);
        a.append(", app=");
        a.append(this.app);
        a.append(", user=");
        a.append(this.user);
        a.append(", os=");
        a.append(this.f1355os);
        a.append(", device=");
        a.append(this.device);
        a.append(", events=");
        a.append(this.events);
        a.append(", generatorType=");
        return C0681a.m322a(a, this.generatorType, "}");
    }
}
