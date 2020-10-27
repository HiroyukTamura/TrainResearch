package com.google.android.datatransport.cct.p006b;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006b.C0570a;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.google.android.datatransport.cct.b.c */
final class C0579c extends C0570a {

    /* renamed from: a */
    private final Integer f136a;

    /* renamed from: b */
    private final String f137b;

    /* renamed from: c */
    private final String f138c;

    /* renamed from: d */
    private final String f139d;

    /* renamed from: e */
    private final String f140e;

    /* renamed from: f */
    private final String f141f;

    /* renamed from: g */
    private final String f142g;

    /* renamed from: h */
    private final String f143h;

    /* renamed from: com.google.android.datatransport.cct.b.c$a */
    static final class C0580a extends C0570a.C0571a {

        /* renamed from: a */
        private Integer f144a;

        /* renamed from: b */
        private String f145b;

        /* renamed from: c */
        private String f146c;

        /* renamed from: d */
        private String f147d;

        /* renamed from: e */
        private String f148e;

        /* renamed from: f */
        private String f149f;

        /* renamed from: g */
        private String f150g;

        /* renamed from: h */
        private String f151h;

        C0580a() {
        }

        /* renamed from: a */
        public C0570a.C0571a mo9443a(@Nullable Integer num) {
            this.f144a = num;
            return this;
        }

        /* renamed from: a */
        public C0570a.C0571a mo9444a(@Nullable String str) {
            this.f147d = str;
            return this;
        }

        /* renamed from: a */
        public C0570a mo9445a() {
            return new C0579c(this.f144a, this.f145b, this.f146c, this.f147d, this.f148e, this.f149f, this.f150g, this.f151h);
        }

        /* renamed from: b */
        public C0570a.C0571a mo9446b(@Nullable String str) {
            this.f151h = str;
            return this;
        }

        /* renamed from: c */
        public C0570a.C0571a mo9447c(@Nullable String str) {
            this.f146c = str;
            return this;
        }

        /* renamed from: d */
        public C0570a.C0571a mo9448d(@Nullable String str) {
            this.f150g = str;
            return this;
        }

        /* renamed from: e */
        public C0570a.C0571a mo9449e(@Nullable String str) {
            this.f145b = str;
            return this;
        }

        /* renamed from: f */
        public C0570a.C0571a mo9450f(@Nullable String str) {
            this.f149f = str;
            return this;
        }

        /* renamed from: g */
        public C0570a.C0571a mo9451g(@Nullable String str) {
            this.f148e = str;
            return this;
        }
    }

    /* synthetic */ C0579c(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f136a = num;
        this.f137b = str;
        this.f138c = str2;
        this.f139d = str3;
        this.f140e = str4;
        this.f141f = str5;
        this.f142g = str6;
        this.f143h = str7;
    }

    @Nullable
    /* renamed from: a */
    public String mo9435a() {
        return this.f139d;
    }

    @Nullable
    /* renamed from: b */
    public String mo9436b() {
        return this.f143h;
    }

    @Nullable
    /* renamed from: c */
    public String mo9437c() {
        return this.f138c;
    }

    @Nullable
    /* renamed from: d */
    public String mo9438d() {
        return this.f142g;
    }

    @Nullable
    /* renamed from: e */
    public String mo9439e() {
        return this.f137b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0570a)) {
            return false;
        }
        Integer num = this.f136a;
        if (num != null ? num.equals(((C0579c) obj).f136a) : ((C0579c) obj).f136a == null) {
            String str = this.f137b;
            if (str != null ? str.equals(((C0579c) obj).f137b) : ((C0579c) obj).f137b == null) {
                String str2 = this.f138c;
                if (str2 != null ? str2.equals(((C0579c) obj).f138c) : ((C0579c) obj).f138c == null) {
                    String str3 = this.f139d;
                    if (str3 != null ? str3.equals(((C0579c) obj).f139d) : ((C0579c) obj).f139d == null) {
                        String str4 = this.f140e;
                        if (str4 != null ? str4.equals(((C0579c) obj).f140e) : ((C0579c) obj).f140e == null) {
                            String str5 = this.f141f;
                            if (str5 != null ? str5.equals(((C0579c) obj).f141f) : ((C0579c) obj).f141f == null) {
                                String str6 = this.f142g;
                                if (str6 != null ? str6.equals(((C0579c) obj).f142g) : ((C0579c) obj).f142g == null) {
                                    String str7 = this.f143h;
                                    String str8 = ((C0579c) obj).f143h;
                                    if (str7 == null) {
                                        if (str8 == null) {
                                            return true;
                                        }
                                    } else if (str7.equals(str8)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    /* renamed from: f */
    public String mo9440f() {
        return this.f141f;
    }

    @Nullable
    /* renamed from: g */
    public String mo9441g() {
        return this.f140e;
    }

    @Nullable
    /* renamed from: h */
    public Integer mo9442h() {
        return this.f136a;
    }

    public int hashCode() {
        Integer num = this.f136a;
        int i = 0;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f137b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f138c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f139d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f140e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f141f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f142g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f143h;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode7 ^ i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("AndroidClientInfo{sdkVersion=");
        a.append(this.f136a);
        a.append(", model=");
        a.append(this.f137b);
        a.append(", hardware=");
        a.append(this.f138c);
        a.append(", device=");
        a.append(this.f139d);
        a.append(", product=");
        a.append(this.f140e);
        a.append(", osBuild=");
        a.append(this.f141f);
        a.append(", manufacturer=");
        a.append(this.f142g);
        a.append(", fingerprint=");
        return C0681a.m324a(a, this.f143h, "}");
    }
}
