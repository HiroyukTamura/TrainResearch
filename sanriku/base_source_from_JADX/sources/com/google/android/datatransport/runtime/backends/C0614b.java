package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.C0620g;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.google.android.datatransport.runtime.backends.b */
final class C0614b extends C0620g {

    /* renamed from: a */
    private final C0620g.C0621a f261a;

    /* renamed from: b */
    private final long f262b;

    C0614b(C0620g.C0621a aVar, long j) {
        if (aVar != null) {
            this.f261a = aVar;
            this.f262b = j;
            return;
        }
        throw new NullPointerException("Null status");
    }

    /* renamed from: a */
    public long mo9534a() {
        return this.f262b;
    }

    /* renamed from: b */
    public C0620g.C0621a mo9535b() {
        return this.f261a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0620g)) {
            return false;
        }
        C0620g gVar = (C0620g) obj;
        if (!this.f261a.equals(((C0614b) gVar).f261a) || this.f262b != ((C0614b) gVar).f262b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.f262b;
        return ((this.f261a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("BackendResponse{status=");
        a.append(this.f261a);
        a.append(", nextRequestWaitMillis=");
        a.append(this.f262b);
        a.append("}");
        return a.toString();
    }
}
