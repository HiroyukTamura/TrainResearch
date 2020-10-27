package com.google.android.datatransport.cct.p006b;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006b.C0597m;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.google.android.datatransport.cct.b.g */
final class C0586g extends C0597m {

    /* renamed from: a */
    private final long f171a;

    /* renamed from: b */
    private final long f172b;

    /* renamed from: c */
    private final C0592k f173c;

    /* renamed from: d */
    private final Integer f174d;

    /* renamed from: e */
    private final String f175e;

    /* renamed from: f */
    private final List<C0595l> f176f;

    /* renamed from: g */
    private final C0604p f177g;

    /* renamed from: com.google.android.datatransport.cct.b.g$a */
    static final class C0587a extends C0597m.C0598a {

        /* renamed from: a */
        private Long f178a;

        /* renamed from: b */
        private Long f179b;

        /* renamed from: c */
        private C0592k f180c;

        /* renamed from: d */
        private Integer f181d;

        /* renamed from: e */
        private String f182e;

        /* renamed from: f */
        private List<C0595l> f183f;

        /* renamed from: g */
        private C0604p f184g;

        C0587a() {
        }

        /* renamed from: a */
        public C0597m.C0598a mo9497a(long j) {
            this.f178a = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C0597m.C0598a mo9498a(@Nullable C0592k kVar) {
            this.f180c = kVar;
            return this;
        }

        /* renamed from: a */
        public C0597m.C0598a mo9499a(@Nullable C0604p pVar) {
            this.f184g = pVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0597m.C0598a mo9500a(@Nullable Integer num) {
            this.f181d = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0597m.C0598a mo9501a(@Nullable String str) {
            this.f182e = str;
            return this;
        }

        /* renamed from: a */
        public C0597m.C0598a mo9502a(@Nullable List<C0595l> list) {
            this.f183f = list;
            return this;
        }

        /* renamed from: a */
        public C0597m mo9503a() {
            String str = this.f178a == null ? " requestTimeMs" : "";
            if (this.f179b == null) {
                str = C0681a.m320a(str, " requestUptimeMs");
            }
            if (str.isEmpty()) {
                return new C0586g(this.f178a.longValue(), this.f179b.longValue(), this.f180c, this.f181d, this.f182e, this.f183f, this.f184g);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }

        /* renamed from: b */
        public C0597m.C0598a mo9504b(long j) {
            this.f179b = Long.valueOf(j);
            return this;
        }
    }

    /* synthetic */ C0586g(long j, long j2, C0592k kVar, Integer num, String str, List list, C0604p pVar) {
        this.f171a = j;
        this.f172b = j2;
        this.f173c = kVar;
        this.f174d = num;
        this.f175e = str;
        this.f176f = list;
        this.f177g = pVar;
    }

    @Nullable
    /* renamed from: a */
    public C0592k mo9487a() {
        return this.f173c;
    }

    @Nullable
    @Encodable.Field(name = "logEvent")
    /* renamed from: b */
    public List<C0595l> mo9488b() {
        return this.f176f;
    }

    @Nullable
    /* renamed from: c */
    public Integer mo9489c() {
        return this.f174d;
    }

    @Nullable
    /* renamed from: d */
    public String mo9490d() {
        return this.f175e;
    }

    @Nullable
    /* renamed from: e */
    public C0604p mo9491e() {
        return this.f177g;
    }

    public boolean equals(Object obj) {
        C0592k kVar;
        Integer num;
        String str;
        List<C0595l> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0597m)) {
            return false;
        }
        C0597m mVar = (C0597m) obj;
        if (this.f171a == ((C0586g) mVar).f171a) {
            C0586g gVar = (C0586g) mVar;
            if (this.f172b == gVar.f172b && ((kVar = this.f173c) != null ? kVar.equals(gVar.f173c) : gVar.f173c == null) && ((num = this.f174d) != null ? num.equals(gVar.f174d) : gVar.f174d == null) && ((str = this.f175e) != null ? str.equals(gVar.f175e) : gVar.f175e == null) && ((list = this.f176f) != null ? list.equals(gVar.f176f) : gVar.f176f == null)) {
                C0604p pVar = this.f177g;
                C0604p pVar2 = gVar.f177g;
                if (pVar == null) {
                    if (pVar2 == null) {
                        return true;
                    }
                } else if (pVar.equals(pVar2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: f */
    public long mo9493f() {
        return this.f171a;
    }

    /* renamed from: g */
    public long mo9494g() {
        return this.f172b;
    }

    public int hashCode() {
        long j = this.f171a;
        long j2 = this.f172b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        C0592k kVar = this.f173c;
        int i2 = 0;
        int hashCode = (i ^ (kVar == null ? 0 : kVar.hashCode())) * 1000003;
        Integer num = this.f174d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f175e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<C0595l> list = this.f176f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        C0604p pVar = this.f177g;
        if (pVar != null) {
            i2 = pVar.hashCode();
        }
        return hashCode4 ^ i2;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("LogRequest{requestTimeMs=");
        a.append(this.f171a);
        a.append(", requestUptimeMs=");
        a.append(this.f172b);
        a.append(", clientInfo=");
        a.append(this.f173c);
        a.append(", logSource=");
        a.append(this.f174d);
        a.append(", logSourceName=");
        a.append(this.f175e);
        a.append(", logEvents=");
        a.append(this.f176f);
        a.append(", qosTier=");
        a.append(this.f177g);
        a.append("}");
        return a.toString();
    }
}
