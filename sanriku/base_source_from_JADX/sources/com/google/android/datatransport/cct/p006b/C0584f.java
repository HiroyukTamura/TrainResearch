package com.google.android.datatransport.cct.p006b;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006b.C0595l;
import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.google.android.datatransport.cct.b.f */
final class C0584f extends C0595l {

    /* renamed from: a */
    private final long f157a;

    /* renamed from: b */
    private final Integer f158b;

    /* renamed from: c */
    private final long f159c;

    /* renamed from: d */
    private final byte[] f160d;

    /* renamed from: e */
    private final String f161e;

    /* renamed from: f */
    private final long f162f;

    /* renamed from: g */
    private final C0600o f163g;

    /* renamed from: com.google.android.datatransport.cct.b.f$a */
    static final class C0585a extends C0595l.C0596a {

        /* renamed from: a */
        private Long f164a;

        /* renamed from: b */
        private Integer f165b;

        /* renamed from: c */
        private Long f166c;

        /* renamed from: d */
        private byte[] f167d;

        /* renamed from: e */
        private String f168e;

        /* renamed from: f */
        private Long f169f;

        /* renamed from: g */
        private C0600o f170g;

        C0585a() {
        }

        /* renamed from: a */
        public C0595l.C0596a mo9479a(long j) {
            this.f164a = Long.valueOf(j);
            return this;
        }

        /* renamed from: a */
        public C0595l.C0596a mo9480a(@Nullable C0600o oVar) {
            this.f170g = oVar;
            return this;
        }

        /* renamed from: a */
        public C0595l.C0596a mo9481a(@Nullable Integer num) {
            this.f165b = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0595l.C0596a mo9482a(@Nullable String str) {
            this.f168e = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0595l.C0596a mo9483a(@Nullable byte[] bArr) {
            this.f167d = bArr;
            return this;
        }

        /* renamed from: a */
        public C0595l mo9484a() {
            String str = this.f164a == null ? " eventTimeMs" : "";
            if (this.f166c == null) {
                str = C0681a.m320a(str, " eventUptimeMs");
            }
            if (this.f169f == null) {
                str = C0681a.m320a(str, " timezoneOffsetSeconds");
            }
            if (str.isEmpty()) {
                return new C0584f(this.f164a.longValue(), this.f165b, this.f166c.longValue(), this.f167d, this.f168e, this.f169f.longValue(), this.f170g);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }

        /* renamed from: b */
        public C0595l.C0596a mo9485b(long j) {
            this.f166c = Long.valueOf(j);
            return this;
        }

        /* renamed from: c */
        public C0595l.C0596a mo9486c(long j) {
            this.f169f = Long.valueOf(j);
            return this;
        }
    }

    /* synthetic */ C0584f(long j, Integer num, long j2, byte[] bArr, String str, long j3, C0600o oVar) {
        this.f157a = j;
        this.f158b = num;
        this.f159c = j2;
        this.f160d = bArr;
        this.f161e = str;
        this.f162f = j3;
        this.f163g = oVar;
    }

    @Nullable
    /* renamed from: a */
    public Integer mo9469a() {
        return this.f158b;
    }

    /* renamed from: b */
    public long mo9470b() {
        return this.f157a;
    }

    /* renamed from: c */
    public long mo9471c() {
        return this.f159c;
    }

    @Nullable
    /* renamed from: d */
    public C0600o mo9472d() {
        return this.f163g;
    }

    @Nullable
    /* renamed from: e */
    public byte[] mo9473e() {
        return this.f160d;
    }

    public boolean equals(Object obj) {
        Integer num;
        byte[] bArr;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0595l)) {
            return false;
        }
        C0595l lVar = (C0595l) obj;
        if (this.f157a == ((C0584f) lVar).f157a && ((num = this.f158b) != null ? num.equals(((C0584f) lVar).f158b) : ((C0584f) lVar).f158b == null)) {
            C0584f fVar = (C0584f) lVar;
            if (this.f159c == fVar.f159c) {
                byte[] bArr2 = this.f160d;
                if (lVar instanceof C0584f) {
                    bArr = fVar.f160d;
                } else {
                    bArr = fVar.f160d;
                }
                if (Arrays.equals(bArr2, bArr) && ((str = this.f161e) != null ? str.equals(fVar.f161e) : fVar.f161e == null) && this.f162f == fVar.f162f) {
                    C0600o oVar = this.f163g;
                    if (oVar == null) {
                        if (fVar.f163g == null) {
                            return true;
                        }
                    } else if (oVar.equals(fVar.f163g)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    /* renamed from: f */
    public String mo9475f() {
        return this.f161e;
    }

    /* renamed from: g */
    public long mo9476g() {
        return this.f162f;
    }

    public int hashCode() {
        long j = this.f157a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f158b;
        int i2 = 0;
        int hashCode = num == null ? 0 : num.hashCode();
        long j2 = this.f159c;
        int hashCode2 = (((((i ^ hashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f160d)) * 1000003;
        String str = this.f161e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f162f;
        int i3 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        C0600o oVar = this.f163g;
        if (oVar != null) {
            i2 = oVar.hashCode();
        }
        return i3 ^ i2;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("LogEvent{eventTimeMs=");
        a.append(this.f157a);
        a.append(", eventCode=");
        a.append(this.f158b);
        a.append(", eventUptimeMs=");
        a.append(this.f159c);
        a.append(", sourceExtension=");
        a.append(Arrays.toString(this.f160d));
        a.append(", sourceExtensionJsonProto3=");
        a.append(this.f161e);
        a.append(", timezoneOffsetSeconds=");
        a.append(this.f162f);
        a.append(", networkConnectionInfo=");
        a.append(this.f163g);
        a.append("}");
        return a.toString();
    }
}
