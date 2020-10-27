package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0632d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p009e.p028d.p030b.p031a.C0877d;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.g */
public abstract class C0637g {

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.g$a */
    public static class C0638a {

        /* renamed from: a */
        private C0968a f302a;

        /* renamed from: b */
        private Map<C0877d, C0639b> f303b = new HashMap();

        /* renamed from: a */
        public C0638a mo9571a(C0877d dVar, C0639b bVar) {
            this.f303b.put(dVar, bVar);
            return this;
        }

        /* renamed from: a */
        public C0638a mo9572a(C0968a aVar) {
            this.f302a = aVar;
            return this;
        }

        /* renamed from: a */
        public C0637g mo9573a() {
            if (this.f302a == null) {
                throw new NullPointerException("missing required property: clock");
            } else if (this.f303b.keySet().size() >= C0877d.m1156a().length) {
                Map<C0877d, C0639b> map = this.f303b;
                this.f303b = new HashMap();
                return new C0631c(this.f302a, map);
            } else {
                throw new IllegalStateException("Not all priorities have been configured");
            }
        }
    }

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.g$b */
    public static abstract class C0639b {

        /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.g$b$a */
        public static abstract class C0640a {
            /* renamed from: a */
            public abstract C0640a mo9565a(long j);

            /* renamed from: a */
            public abstract C0640a mo9566a(Set<C0641c> set);

            /* renamed from: a */
            public abstract C0639b mo9567a();

            /* renamed from: b */
            public abstract C0640a mo9568b(long j);
        }

        /* renamed from: d */
        public static C0640a m247d() {
            C0632d.C0634b bVar = new C0632d.C0634b();
            bVar.mo9566a((Set<C0641c>) Collections.emptySet());
            return bVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract long mo9559a();

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract Set<C0641c> mo9560b();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract long mo9561c();
    }

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.g$c */
    public enum C0641c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING;

        static {
            NETWORK_UNMETERED = new C0641c("NETWORK_UNMETERED", 0);
            DEVICE_IDLE = new C0641c("DEVICE_IDLE", 1);
            DEVICE_CHARGING = new C0641c("DEVICE_CHARGING", 2);
        }
    }

    /* renamed from: a */
    public long mo9570a(C0877d dVar, long j, int i) {
        long a = j - mo9554a().mo20396a();
        C0639b bVar = mo9555b().get(dVar);
        return Math.min(Math.max(((long) Math.pow(2.0d, (double) (i - 1))) * bVar.mo9559a(), a), bVar.mo9561c());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C0968a mo9554a();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract Map<C0877d, C0639b> mo9555b();
}
