package p009e.p028d.p030b.p031a.p032i;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.C0877d;
import p009e.p028d.p030b.p031a.p032i.C0903k;

/* renamed from: e.d.b.a.i.c */
final class C0888c extends C0903k {

    /* renamed from: a */
    private final String f555a;

    /* renamed from: b */
    private final byte[] f556b;

    /* renamed from: c */
    private final C0877d f557c;

    /* renamed from: e.d.b.a.i.c$b */
    static final class C0890b extends C0903k.C0904a {

        /* renamed from: a */
        private String f558a;

        /* renamed from: b */
        private byte[] f559b;

        /* renamed from: c */
        private C0877d f560c;

        C0890b() {
        }

        /* renamed from: a */
        public C0903k.C0904a mo20326a(C0877d dVar) {
            if (dVar != null) {
                this.f560c = dVar;
                return this;
            }
            throw new NullPointerException("Null priority");
        }

        /* renamed from: a */
        public C0903k.C0904a mo20327a(String str) {
            if (str != null) {
                this.f558a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        /* renamed from: a */
        public C0903k.C0904a mo20328a(@Nullable byte[] bArr) {
            this.f559b = bArr;
            return this;
        }

        /* renamed from: a */
        public C0903k mo20329a() {
            String str = this.f558a == null ? " backendName" : "";
            if (this.f560c == null) {
                str = C0681a.m320a(str, " priority");
            }
            if (str.isEmpty()) {
                return new C0888c(this.f558a, this.f559b, this.f560c, (C0889a) null);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }
    }

    /* synthetic */ C0888c(String str, byte[] bArr, C0877d dVar, C0889a aVar) {
        this.f555a = str;
        this.f556b = bArr;
        this.f557c = dVar;
    }

    /* renamed from: a */
    public String mo20321a() {
        return this.f555a;
    }

    @Nullable
    /* renamed from: b */
    public byte[] mo20322b() {
        return this.f556b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: c */
    public C0877d mo20323c() {
        return this.f557c;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0903k)) {
            return false;
        }
        C0903k kVar = (C0903k) obj;
        if (this.f555a.equals(((C0888c) kVar).f555a)) {
            byte[] bArr2 = this.f556b;
            if (kVar instanceof C0888c) {
                bArr = ((C0888c) kVar).f556b;
            } else {
                bArr = ((C0888c) kVar).f556b;
            }
            if (!Arrays.equals(bArr2, bArr) || !this.f557c.equals(((C0888c) kVar).f557c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f555a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f556b)) * 1000003) ^ this.f557c.hashCode();
    }
}
