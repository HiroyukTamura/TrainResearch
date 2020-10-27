package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0637g;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.C0877d;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.c */
final class C0631c extends C0637g {

    /* renamed from: a */
    private final C0968a f289a;

    /* renamed from: b */
    private final Map<C0877d, C0637g.C0639b> f290b;

    C0631c(C0968a aVar, Map<C0877d, C0637g.C0639b> map) {
        if (aVar != null) {
            this.f289a = aVar;
            if (map != null) {
                this.f290b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0968a mo9554a() {
        return this.f289a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Map<C0877d, C0637g.C0639b> mo9555b() {
        return this.f290b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0637g)) {
            return false;
        }
        C0637g gVar = (C0637g) obj;
        if (!this.f289a.equals(((C0631c) gVar).f289a) || !this.f290b.equals(((C0631c) gVar).f290b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f289a.hashCode() ^ 1000003) * 1000003) ^ this.f290b.hashCode();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("SchedulerConfig{clock=");
        a.append(this.f289a);
        a.append(", values=");
        a.append(this.f290b);
        a.append("}");
        return a.toString();
    }
}
