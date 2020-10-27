package p009e.p028d.p030b.p031a.p032i;

import androidx.annotation.Nullable;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.p032i.C0896g;

/* renamed from: e.d.b.a.i.a */
final class C0882a extends C0896g {

    /* renamed from: a */
    private final String f533a;

    /* renamed from: b */
    private final Integer f534b;

    /* renamed from: c */
    private final C0895f f535c;

    /* renamed from: d */
    private final long f536d;

    /* renamed from: e */
    private final long f537e;

    /* renamed from: f */
    private final Map<String, String> f538f;

    /* renamed from: e.d.b.a.i.a$b */
    static final class C0884b extends C0896g.C0897a {

        /* renamed from: a */
        private String f539a;

        /* renamed from: b */
        private Integer f540b;

        /* renamed from: c */
        private C0895f f541c;

        /* renamed from: d */
        private Long f542d;

        /* renamed from: e */
        private Long f543e;

        /* renamed from: f */
        private Map<String, String> f544f;

        C0884b() {
        }

        /* renamed from: a */
        public C0896g.C0897a mo20299a(long j) {
            this.f542d = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C0896g.C0897a mo20300a(C0895f fVar) {
            if (fVar != null) {
                this.f541c = fVar;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        /* renamed from: a */
        public C0896g.C0897a mo20301a(Integer num) {
            this.f540b = num;
            return this;
        }

        /* renamed from: a */
        public C0896g.C0897a mo20302a(String str) {
            if (str != null) {
                this.f539a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C0896g.C0897a mo20303a(Map<String, String> map) {
            if (map != null) {
                this.f544f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        /* renamed from: a */
        public C0896g mo20304a() {
            String str = this.f539a == null ? " transportName" : "";
            if (this.f541c == null) {
                str = C0681a.m320a(str, " encodedPayload");
            }
            if (this.f542d == null) {
                str = C0681a.m320a(str, " eventMillis");
            }
            if (this.f543e == null) {
                str = C0681a.m320a(str, " uptimeMillis");
            }
            if (this.f544f == null) {
                str = C0681a.m320a(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                return new C0882a(this.f539a, this.f540b, this.f541c, this.f542d.longValue(), this.f543e.longValue(), this.f544f, (C0883a) null);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }

        /* renamed from: b */
        public C0896g.C0897a mo20305b(long j) {
            this.f543e = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Map<String, String> mo20306b() {
            Map<String, String> map = this.f544f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
    }

    /* synthetic */ C0882a(String str, Integer num, C0895f fVar, long j, long j2, Map map, C0883a aVar) {
        this.f533a = str;
        this.f534b = num;
        this.f535c = fVar;
        this.f536d = j;
        this.f537e = j2;
        this.f538f = map;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<String, String> mo20290a() {
        return this.f538f;
    }

    @Nullable
    /* renamed from: b */
    public Integer mo20291b() {
        return this.f534b;
    }

    /* renamed from: c */
    public C0895f mo20292c() {
        return this.f535c;
    }

    /* renamed from: d */
    public long mo20293d() {
        return this.f536d;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0896g)) {
            return false;
        }
        C0896g gVar = (C0896g) obj;
        if (this.f533a.equals(((C0882a) gVar).f533a) && ((num = this.f534b) != null ? num.equals(((C0882a) gVar).f534b) : ((C0882a) gVar).f534b == null)) {
            C0882a aVar = (C0882a) gVar;
            if (!this.f535c.equals(aVar.f535c) || this.f536d != aVar.f536d || this.f537e != aVar.f537e || !this.f538f.equals(aVar.f538f)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public String mo20295f() {
        return this.f533a;
    }

    /* renamed from: g */
    public long mo20296g() {
        return this.f537e;
    }

    public int hashCode() {
        int hashCode = (this.f533a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f534b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j = this.f536d;
        long j2 = this.f537e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.f535c.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f538f.hashCode();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("EventInternal{transportName=");
        a.append(this.f533a);
        a.append(", code=");
        a.append(this.f534b);
        a.append(", encodedPayload=");
        a.append(this.f535c);
        a.append(", eventMillis=");
        a.append(this.f536d);
        a.append(", uptimeMillis=");
        a.append(this.f537e);
        a.append(", autoMetadata=");
        a.append(this.f538f);
        a.append("}");
        return a.toString();
    }
}
