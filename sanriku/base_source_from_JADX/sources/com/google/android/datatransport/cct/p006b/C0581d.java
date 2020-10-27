package com.google.android.datatransport.cct.p006b;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.google.android.datatransport.cct.b.d */
final class C0581d extends C0591j {

    /* renamed from: a */
    private final List<C0597m> f152a;

    C0581d(List<C0597m> list) {
        if (list != null) {
            this.f152a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    @NonNull
    @Encodable.Field(name = "logRequest")
    /* renamed from: a */
    public List<C0597m> mo9457a() {
        return this.f152a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0591j) {
            return this.f152a.equals(((C0581d) ((C0591j) obj)).f152a);
        }
        return false;
    }

    public int hashCode() {
        return this.f152a.hashCode() ^ 1000003;
    }

    public String toString() {
        return C0681a.m325a(C0681a.m330a("BatchedLogRequest{logRequests="), (List) this.f152a, "}");
    }
}
