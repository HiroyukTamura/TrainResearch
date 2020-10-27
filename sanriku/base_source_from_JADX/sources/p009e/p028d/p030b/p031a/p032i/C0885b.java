package p009e.p028d.p030b.p031a.p032i;

import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.C0875b;
import p009e.p028d.p030b.p031a.C0876c;
import p009e.p028d.p030b.p031a.C0878e;
import p009e.p028d.p030b.p031a.p032i.C0901j;

/* renamed from: e.d.b.a.i.b */
final class C0885b extends C0901j {

    /* renamed from: a */
    private final C0903k f545a;

    /* renamed from: b */
    private final String f546b;

    /* renamed from: c */
    private final C0876c<?> f547c;

    /* renamed from: d */
    private final C0878e<?, byte[]> f548d;

    /* renamed from: e */
    private final C0875b f549e;

    /* renamed from: e.d.b.a.i.b$b */
    static final class C0887b extends C0901j.C0902a {

        /* renamed from: a */
        private C0903k f550a;

        /* renamed from: b */
        private String f551b;

        /* renamed from: c */
        private C0876c<?> f552c;

        /* renamed from: d */
        private C0878e<?, byte[]> f553d;

        /* renamed from: e */
        private C0875b f554e;

        C0887b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0901j.C0902a mo20315a(C0875b bVar) {
            if (bVar != null) {
                this.f554e = bVar;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0901j.C0902a mo20316a(C0876c<?> cVar) {
            if (cVar != null) {
                this.f552c = cVar;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0901j.C0902a mo20317a(C0878e<?, byte[]> eVar) {
            if (eVar != null) {
                this.f553d = eVar;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        /* renamed from: a */
        public C0901j.C0902a mo20318a(C0903k kVar) {
            if (kVar != null) {
                this.f550a = kVar;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        /* renamed from: a */
        public C0901j.C0902a mo20319a(String str) {
            if (str != null) {
                this.f551b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        /* renamed from: a */
        public C0901j mo20320a() {
            String str = this.f550a == null ? " transportContext" : "";
            if (this.f551b == null) {
                str = C0681a.m320a(str, " transportName");
            }
            if (this.f552c == null) {
                str = C0681a.m320a(str, " event");
            }
            if (this.f553d == null) {
                str = C0681a.m320a(str, " transformer");
            }
            if (this.f554e == null) {
                str = C0681a.m320a(str, " encoding");
            }
            if (str.isEmpty()) {
                return new C0885b(this.f550a, this.f551b, this.f552c, this.f553d, this.f554e, (C0886a) null);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }
    }

    /* synthetic */ C0885b(C0903k kVar, String str, C0876c cVar, C0878e eVar, C0875b bVar, C0886a aVar) {
        this.f545a = kVar;
        this.f546b = str;
        this.f547c = cVar;
        this.f548d = eVar;
        this.f549e = bVar;
    }

    /* renamed from: a */
    public C0875b mo20307a() {
        return this.f549e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0876c<?> mo20308b() {
        return this.f547c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0878e<?, byte[]> mo20309c() {
        return this.f548d;
    }

    /* renamed from: d */
    public C0903k mo20310d() {
        return this.f545a;
    }

    /* renamed from: e */
    public String mo20311e() {
        return this.f546b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0901j)) {
            return false;
        }
        C0901j jVar = (C0901j) obj;
        if (this.f545a.equals(((C0885b) jVar).f545a)) {
            C0885b bVar = (C0885b) jVar;
            if (!this.f546b.equals(bVar.f546b) || !this.f547c.equals(bVar.f547c) || !this.f548d.equals(bVar.f548d) || !this.f549e.equals(bVar.f549e)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.f545a.hashCode() ^ 1000003) * 1000003) ^ this.f546b.hashCode()) * 1000003) ^ this.f547c.hashCode()) * 1000003) ^ this.f548d.hashCode()) * 1000003) ^ this.f549e.hashCode();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("SendRequest{transportContext=");
        a.append(this.f545a);
        a.append(", transportName=");
        a.append(this.f546b);
        a.append(", event=");
        a.append(this.f547c);
        a.append(", transformer=");
        a.append(this.f548d);
        a.append(", encoding=");
        a.append(this.f549e);
        a.append("}");
        return a.toString();
    }
}
