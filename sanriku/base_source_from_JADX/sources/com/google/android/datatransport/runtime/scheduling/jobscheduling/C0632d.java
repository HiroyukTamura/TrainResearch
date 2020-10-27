package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0637g;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.d */
final class C0632d extends C0637g.C0639b {

    /* renamed from: a */
    private final long f291a;

    /* renamed from: b */
    private final long f292b;

    /* renamed from: c */
    private final Set<C0637g.C0641c> f293c;

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.d$b */
    static final class C0634b extends C0637g.C0639b.C0640a {

        /* renamed from: a */
        private Long f294a;

        /* renamed from: b */
        private Long f295b;

        /* renamed from: c */
        private Set<C0637g.C0641c> f296c;

        C0634b() {
        }

        /* renamed from: a */
        public C0637g.C0639b.C0640a mo9565a(long j) {
            this.f294a = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C0637g.C0639b.C0640a mo9566a(Set<C0637g.C0641c> set) {
            if (set != null) {
                this.f296c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        /* renamed from: a */
        public C0637g.C0639b mo9567a() {
            String str = this.f294a == null ? " delta" : "";
            if (this.f295b == null) {
                str = C0681a.m320a(str, " maxAllowedDelay");
            }
            if (this.f296c == null) {
                str = C0681a.m320a(str, " flags");
            }
            if (str.isEmpty()) {
                return new C0632d(this.f294a.longValue(), this.f295b.longValue(), this.f296c, (C0633a) null);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }

        /* renamed from: b */
        public C0637g.C0639b.C0640a mo9568b(long j) {
            this.f295b = Long.valueOf(j);
            return this;
        }
    }

    /* synthetic */ C0632d(long j, long j2, Set set, C0633a aVar) {
        this.f291a = j;
        this.f292b = j2;
        this.f293c = set;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo9559a() {
        return this.f291a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Set<C0637g.C0641c> mo9560b() {
        return this.f293c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo9561c() {
        return this.f292b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0637g.C0639b)) {
            return false;
        }
        C0637g.C0639b bVar = (C0637g.C0639b) obj;
        if (this.f291a == ((C0632d) bVar).f291a) {
            C0632d dVar = (C0632d) bVar;
            if (this.f292b != dVar.f292b || !this.f293c.equals(dVar.f293c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f291a;
        long j2 = this.f292b;
        return this.f293c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("ConfigValue{delta=");
        a.append(this.f291a);
        a.append(", maxAllowedDelay=");
        a.append(this.f292b);
        a.append(", flags=");
        a.append(this.f293c);
        a.append("}");
        return a.toString();
    }
}
