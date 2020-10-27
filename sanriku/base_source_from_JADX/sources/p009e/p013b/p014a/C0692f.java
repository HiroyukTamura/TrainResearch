package p009e.p013b.p014a;

import p009e.p013b.p014a.C0685c;

/* renamed from: e.b.a.f */
final class C0692f implements C0685c.C0687b {
    C0692f() {
    }

    /* renamed from: a */
    public String mo19776a(String str) {
        return (!str.startsWith("lib") || !str.endsWith(".so")) ? System.mapLibraryName(str) : str;
    }
}
