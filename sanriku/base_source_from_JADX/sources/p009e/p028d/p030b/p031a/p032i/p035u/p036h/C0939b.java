package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.p032i.C0896g;
import p009e.p028d.p030b.p031a.p032i.C0903k;

/* renamed from: e.d.b.a.i.u.h.b */
final class C0939b extends C0946h {

    /* renamed from: a */
    private final long f657a;

    /* renamed from: b */
    private final C0903k f658b;

    /* renamed from: c */
    private final C0896g f659c;

    C0939b(long j, C0903k kVar, C0896g gVar) {
        this.f657a = j;
        if (kVar != null) {
            this.f658b = kVar;
            if (gVar != null) {
                this.f659c = gVar;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    /* renamed from: a */
    public C0896g mo20390a() {
        return this.f659c;
    }

    /* renamed from: b */
    public long mo20391b() {
        return this.f657a;
    }

    /* renamed from: c */
    public C0903k mo20392c() {
        return this.f658b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0946h)) {
            return false;
        }
        C0946h hVar = (C0946h) obj;
        if (this.f657a == ((C0939b) hVar).f657a) {
            C0939b bVar = (C0939b) hVar;
            if (!this.f658b.equals(bVar.f658b) || !this.f659c.equals(bVar.f659c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f657a;
        return this.f659c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f658b.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("PersistedEvent{id=");
        a.append(this.f657a);
        a.append(", transportContext=");
        a.append(this.f658b);
        a.append(", event=");
        a.append(this.f659c);
        a.append("}");
        return a.toString();
    }
}
