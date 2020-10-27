package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import p009e.p010a.p011a.p012a.C0681a;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution extends CrashlyticsReport.Session.Event.Application.Execution {
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> binaries;
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
    private final CrashlyticsReport.Session.Event.Application.Execution.Signal signal;
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> threads;

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Builder {
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> binaries;
        private CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
        private CrashlyticsReport.Session.Event.Application.Execution.Signal signal;
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> threads;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution build() {
            String str = this.threads == null ? " threads" : "";
            if (this.exception == null) {
                str = C0681a.m320a(str, " exception");
            }
            if (this.signal == null) {
                str = C0681a.m320a(str, " signal");
            }
            if (this.binaries == null) {
                str = C0681a.m320a(str, " binaries");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(this.threads, this.exception, this.signal, this.binaries);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder setBinaries(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList) {
            if (immutableList != null) {
                this.binaries = immutableList;
                return this;
            }
            throw new NullPointerException("Null binaries");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder setException(CrashlyticsReport.Session.Event.Application.Execution.Exception exception2) {
            if (exception2 != null) {
                this.exception = exception2;
                return this;
            }
            throw new NullPointerException("Null exception");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder setSignal(CrashlyticsReport.Session.Event.Application.Execution.Signal signal2) {
            if (signal2 != null) {
                this.signal = signal2;
                return this;
            }
            throw new NullPointerException("Null signal");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder setThreads(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList) {
            if (immutableList != null) {
                this.threads = immutableList;
                return this;
            }
            throw new NullPointerException("Null threads");
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception exception2, CrashlyticsReport.Session.Event.Application.Execution.Signal signal2, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList2) {
        this.threads = immutableList;
        this.exception = exception2;
        this.signal = signal2;
        this.binaries = immutableList2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
        return this.threads.equals(execution.getThreads()) && this.exception.equals(execution.getException()) && this.signal.equals(execution.getSignal()) && this.binaries.equals(execution.getBinaries());
    }

    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> getBinaries() {
        return this.binaries;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution.Exception getException() {
        return this.exception;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution.Signal getSignal() {
        return this.signal;
    }

    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> getThreads() {
        return this.threads;
    }

    public int hashCode() {
        return ((((((this.threads.hashCode() ^ 1000003) * 1000003) ^ this.exception.hashCode()) * 1000003) ^ this.signal.hashCode()) * 1000003) ^ this.binaries.hashCode();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("Execution{threads=");
        a.append(this.threads);
        a.append(", exception=");
        a.append(this.exception);
        a.append(", signal=");
        a.append(this.signal);
        a.append(", binaries=");
        a.append(this.binaries);
        a.append("}");
        return a.toString();
    }
}
