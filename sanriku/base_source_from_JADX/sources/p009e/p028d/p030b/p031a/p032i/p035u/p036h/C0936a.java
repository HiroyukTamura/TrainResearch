package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0941d;

/* renamed from: e.d.b.a.i.u.h.a */
final class C0936a extends C0941d {

    /* renamed from: b */
    private final long f647b;

    /* renamed from: c */
    private final int f648c;

    /* renamed from: d */
    private final int f649d;

    /* renamed from: e */
    private final long f650e;

    /* renamed from: f */
    private final int f651f;

    /* renamed from: e.d.b.a.i.u.h.a$b */
    static final class C0938b extends C0941d.C0942a {

        /* renamed from: a */
        private Long f652a;

        /* renamed from: b */
        private Integer f653b;

        /* renamed from: c */
        private Integer f654c;

        /* renamed from: d */
        private Long f655d;

        /* renamed from: e */
        private Integer f656e;

        C0938b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0941d.C0942a mo20384a(int i) {
            this.f654c = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0941d.C0942a mo20385a(long j) {
            this.f655d = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0941d mo20386a() {
            String str = this.f652a == null ? " maxStorageSizeInBytes" : "";
            if (this.f653b == null) {
                str = C0681a.m320a(str, " loadBatchSize");
            }
            if (this.f654c == null) {
                str = C0681a.m320a(str, " criticalSectionEnterTimeoutMs");
            }
            if (this.f655d == null) {
                str = C0681a.m320a(str, " eventCleanUpAge");
            }
            if (this.f656e == null) {
                str = C0681a.m320a(str, " maxBlobByteSizePerRow");
            }
            if (str.isEmpty()) {
                return new C0936a(this.f652a.longValue(), this.f653b.intValue(), this.f654c.intValue(), this.f655d.longValue(), this.f656e.intValue(), (C0937a) null);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C0941d.C0942a mo20387b(int i) {
            this.f653b = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C0941d.C0942a mo20388b(long j) {
            this.f652a = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C0941d.C0942a mo20389c(int i) {
            this.f656e = Integer.valueOf(i);
            return this;
        }
    }

    /* synthetic */ C0936a(long j, int i, int i2, long j2, int i3, C0937a aVar) {
        this.f647b = j;
        this.f648c = i;
        this.f649d = i2;
        this.f650e = j2;
        this.f651f = i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo20376a() {
        return this.f649d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo20377b() {
        return this.f650e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo20378c() {
        return this.f648c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo20379d() {
        return this.f651f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public long mo20380e() {
        return this.f647b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0941d)) {
            return false;
        }
        C0941d dVar = (C0941d) obj;
        if (this.f647b == ((C0936a) dVar).f647b) {
            C0936a aVar = (C0936a) dVar;
            if (this.f648c == aVar.f648c && this.f649d == aVar.f649d && this.f650e == aVar.f650e && this.f651f == aVar.f651f) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f647b;
        long j2 = this.f650e;
        return this.f651f ^ ((((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f648c) * 1000003) ^ this.f649d) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("EventStoreConfig{maxStorageSizeInBytes=");
        a.append(this.f647b);
        a.append(", loadBatchSize=");
        a.append(this.f648c);
        a.append(", criticalSectionEnterTimeoutMs=");
        a.append(this.f649d);
        a.append(", eventCleanUpAge=");
        a.append(this.f650e);
        a.append(", maxBlobByteSizePerRow=");
        return C0681a.m322a(a, this.f651f, "}");
    }
}
