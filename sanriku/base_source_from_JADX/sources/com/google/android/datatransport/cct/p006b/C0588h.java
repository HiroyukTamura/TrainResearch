package com.google.android.datatransport.cct.p006b;

import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.google.android.datatransport.cct.b.h */
final class C0588h extends C0599n {

    /* renamed from: a */
    private final long f185a;

    C0588h(long j) {
        this.f185a = j;
    }

    /* renamed from: a */
    public long mo9505a() {
        return this.f185a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C0599n) && this.f185a == ((C0588h) ((C0599n) obj)).f185a;
    }

    public int hashCode() {
        long j = this.f185a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("LogResponse{nextRequestWaitMillis=");
        a.append(this.f185a);
        a.append("}");
        return a.toString();
    }
}
