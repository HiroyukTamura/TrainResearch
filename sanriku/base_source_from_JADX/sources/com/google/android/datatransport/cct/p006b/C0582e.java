package com.google.android.datatransport.cct.p006b;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006b.C0592k;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.google.android.datatransport.cct.b.e */
final class C0582e extends C0592k {

    /* renamed from: a */
    private final C0592k.C0594b f153a;

    /* renamed from: b */
    private final C0570a f154b;

    /* renamed from: com.google.android.datatransport.cct.b.e$a */
    static final class C0583a extends C0592k.C0593a {

        /* renamed from: a */
        private C0592k.C0594b f155a;

        /* renamed from: b */
        private C0570a f156b;

        C0583a() {
        }

        /* renamed from: a */
        public C0592k.C0593a mo9466a(@Nullable C0570a aVar) {
            this.f156b = aVar;
            return this;
        }

        /* renamed from: a */
        public C0592k.C0593a mo9467a(@Nullable C0592k.C0594b bVar) {
            this.f155a = bVar;
            return this;
        }

        /* renamed from: a */
        public C0592k mo9468a() {
            return new C0582e(this.f155a, this.f156b);
        }
    }

    /* synthetic */ C0582e(C0592k.C0594b bVar, C0570a aVar) {
        this.f153a = bVar;
        this.f154b = aVar;
    }

    @Nullable
    /* renamed from: a */
    public C0570a mo9461a() {
        return this.f154b;
    }

    @Nullable
    /* renamed from: b */
    public C0592k.C0594b mo9462b() {
        return this.f153a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0592k)) {
            return false;
        }
        C0592k.C0594b bVar = this.f153a;
        if (bVar != null ? bVar.equals(((C0582e) obj).f153a) : ((C0582e) obj).f153a == null) {
            C0570a aVar = this.f154b;
            C0570a aVar2 = ((C0582e) obj).f154b;
            if (aVar == null) {
                if (aVar2 == null) {
                    return true;
                }
            } else if (aVar.equals(aVar2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        C0592k.C0594b bVar = this.f153a;
        int i = 0;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        C0570a aVar = this.f154b;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("ClientInfo{clientType=");
        a.append(this.f153a);
        a.append(", androidClientInfo=");
        a.append(this.f154b);
        a.append("}");
        return a.toString();
    }
}
