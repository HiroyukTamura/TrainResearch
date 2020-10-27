package com.google.android.datatransport.cct.p006b;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006b.C0600o;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.google.android.datatransport.cct.b.i */
final class C0589i extends C0600o {

    /* renamed from: a */
    private final C0600o.C0603c f186a;

    /* renamed from: b */
    private final C0600o.C0602b f187b;

    /* renamed from: com.google.android.datatransport.cct.b.i$a */
    static final class C0590a extends C0600o.C0601a {

        /* renamed from: a */
        private C0600o.C0603c f188a;

        /* renamed from: b */
        private C0600o.C0602b f189b;

        C0590a() {
        }

        /* renamed from: a */
        public C0600o.C0601a mo9514a(@Nullable C0600o.C0602b bVar) {
            this.f189b = bVar;
            return this;
        }

        /* renamed from: a */
        public C0600o.C0601a mo9515a(@Nullable C0600o.C0603c cVar) {
            this.f188a = cVar;
            return this;
        }

        /* renamed from: a */
        public C0600o mo9516a() {
            return new C0589i(this.f188a, this.f189b);
        }
    }

    /* synthetic */ C0589i(C0600o.C0603c cVar, C0600o.C0602b bVar) {
        this.f186a = cVar;
        this.f187b = bVar;
    }

    @Nullable
    /* renamed from: a */
    public C0600o.C0602b mo9509a() {
        return this.f187b;
    }

    @Nullable
    /* renamed from: b */
    public C0600o.C0603c mo9510b() {
        return this.f186a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0600o)) {
            return false;
        }
        C0600o.C0603c cVar = this.f186a;
        if (cVar != null ? cVar.equals(((C0589i) obj).f186a) : ((C0589i) obj).f186a == null) {
            C0600o.C0602b bVar = this.f187b;
            C0600o.C0602b bVar2 = ((C0589i) obj).f187b;
            if (bVar == null) {
                if (bVar2 == null) {
                    return true;
                }
            } else if (bVar.equals(bVar2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        C0600o.C0603c cVar = this.f186a;
        int i = 0;
        int hashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        C0600o.C0602b bVar = this.f187b;
        if (bVar != null) {
            i = bVar.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("NetworkConnectionInfo{networkType=");
        a.append(this.f186a);
        a.append(", mobileSubtype=");
        a.append(this.f187b);
        a.append("}");
        return a.toString();
    }
}
