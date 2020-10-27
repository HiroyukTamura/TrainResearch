package p122k.p123a.p124a.p125a.p128G;

import java.io.Serializable;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: k.a.a.a.G.k */
public class C2442k<A, B> implements Serializable {

    /* renamed from: a */
    public final A f4007a;

    /* renamed from: b */
    public final B f4008b;

    public C2442k(A a, B b) {
        this.f4007a = a;
        this.f4008b = b;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2442k)) {
            return false;
        }
        C2442k kVar = (C2442k) obj;
        A a = this.f4007a;
        A a2 = kVar.f4007a;
        if (a == null ? a2 == null : a.equals(a2)) {
            B b = this.f4008b;
            B b2 = kVar.f4008b;
            if (b == null) {
                z = b2 == null;
            } else {
                z = b.equals(b2);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return C1532a.m2119a(C1532a.m2120a(C1532a.m2120a(0, (Object) this.f4007a), (Object) this.f4008b), 2);
    }

    public String toString() {
        return String.format("(%s, %s)", new Object[]{this.f4007a, this.f4008b});
    }
}
