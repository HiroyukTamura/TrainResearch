package p009e.p028d.p030b.p031a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: e.d.b.a.b */
public final class C0875b {

    /* renamed from: a */
    private final String f528a;

    private C0875b(@NonNull String str) {
        if (str != null) {
            this.f528a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    /* renamed from: a */
    public static C0875b m1149a(@NonNull String str) {
        return new C0875b(str);
    }

    /* renamed from: a */
    public String mo20281a() {
        return this.f528a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0875b)) {
            return false;
        }
        return this.f528a.equals(((C0875b) obj).f528a);
    }

    public int hashCode() {
        return this.f528a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return C0681a.m324a(C0681a.m330a("Encoding{name=\""), this.f528a, "\"}");
    }
}
