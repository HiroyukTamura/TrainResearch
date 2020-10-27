package p009e.p028d.p030b.p031a.p032i;

import androidx.annotation.NonNull;
import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.C0875b;

/* renamed from: e.d.b.a.i.f */
public final class C0895f {

    /* renamed from: a */
    private final C0875b f574a;

    /* renamed from: b */
    private final byte[] f575b;

    public C0895f(@NonNull C0875b bVar, @NonNull byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.f574a = bVar;
            this.f575b = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    /* renamed from: a */
    public byte[] mo20334a() {
        return this.f575b;
    }

    /* renamed from: b */
    public C0875b mo20335b() {
        return this.f574a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0895f)) {
            return false;
        }
        C0895f fVar = (C0895f) obj;
        if (!this.f574a.equals(fVar.f574a)) {
            return false;
        }
        return Arrays.equals(this.f575b, fVar.f575b);
    }

    public int hashCode() {
        return ((this.f574a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f575b);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("EncodedPayload{encoding=");
        a.append(this.f574a);
        a.append(", bytes=[...]}");
        return a.toString();
    }
}
