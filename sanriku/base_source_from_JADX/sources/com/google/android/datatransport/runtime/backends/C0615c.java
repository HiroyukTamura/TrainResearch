package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;

/* renamed from: com.google.android.datatransport.runtime.backends.c */
final class C0615c extends C0622h {

    /* renamed from: a */
    private final Context f263a;

    /* renamed from: b */
    private final C0968a f264b;

    /* renamed from: c */
    private final C0968a f265c;

    /* renamed from: d */
    private final String f266d;

    C0615c(Context context, C0968a aVar, C0968a aVar2, String str) {
        if (context != null) {
            this.f263a = context;
            if (aVar != null) {
                this.f264b = aVar;
                if (aVar2 != null) {
                    this.f265c = aVar2;
                    if (str != null) {
                        this.f266d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    /* renamed from: a */
    public Context mo9539a() {
        return this.f263a;
    }

    /* renamed from: b */
    public C0968a mo9540b() {
        return this.f265c;
    }

    /* renamed from: c */
    public C0968a mo9541c() {
        return this.f264b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0622h)) {
            return false;
        }
        C0622h hVar = (C0622h) obj;
        if (this.f263a.equals(((C0615c) hVar).f263a)) {
            C0615c cVar = (C0615c) hVar;
            if (!this.f264b.equals(cVar.f264b) || !this.f265c.equals(cVar.f265c) || !this.f266d.equals(cVar.f266d)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f263a.hashCode() ^ 1000003) * 1000003) ^ this.f264b.hashCode()) * 1000003) ^ this.f265c.hashCode()) * 1000003) ^ this.f266d.hashCode();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("CreationContext{applicationContext=");
        a.append(this.f263a);
        a.append(", wallClock=");
        a.append(this.f264b);
        a.append(", monotonicClock=");
        a.append(this.f265c);
        a.append(", backendName=");
        return C0681a.m324a(a, this.f266d, "}");
    }
}
