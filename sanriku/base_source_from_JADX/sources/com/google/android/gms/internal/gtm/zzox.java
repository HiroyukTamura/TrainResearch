package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzox {
    private final List<zzot> zzatu;
    private final List<zzot> zzatv;
    private final List<zzot> zzatw;
    private final List<zzot> zzatx;
    private final List<zzot> zzava;
    private final List<zzot> zzavb;
    private final List<String> zzavc;
    private final List<String> zzavd;
    private final List<String> zzave;
    private final List<String> zzavf;

    private zzox(List<zzot> list, List<zzot> list2, List<zzot> list3, List<zzot> list4, List<zzot> list5, List<zzot> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
        this.zzatu = Collections.unmodifiableList(list);
        this.zzatv = Collections.unmodifiableList(list2);
        this.zzatw = Collections.unmodifiableList(list3);
        this.zzatx = Collections.unmodifiableList(list4);
        this.zzava = Collections.unmodifiableList(list5);
        this.zzavb = Collections.unmodifiableList(list6);
        this.zzavc = Collections.unmodifiableList(list7);
        this.zzavd = Collections.unmodifiableList(list8);
        this.zzave = Collections.unmodifiableList(list9);
        this.zzavf = Collections.unmodifiableList(list10);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzatu);
        String valueOf2 = String.valueOf(this.zzatv);
        String valueOf3 = String.valueOf(this.zzatw);
        String valueOf4 = String.valueOf(this.zzatx);
        String valueOf5 = String.valueOf(this.zzava);
        String valueOf6 = String.valueOf(this.zzavb);
        StringBuilder b = C0681a.m337b(valueOf6.length() + valueOf5.length() + valueOf4.length() + valueOf3.length() + valueOf2.length() + valueOf.length() + 102, "Positive predicates: ", valueOf, "  Negative predicates: ", valueOf2);
        C0681a.m335a(b, "  Add tags: ", valueOf3, "  Remove tags: ", valueOf4);
        b.append("  Add macros: ");
        b.append(valueOf5);
        b.append("  Remove macros: ");
        b.append(valueOf6);
        return b.toString();
    }

    public final List<zzot> zzlw() {
        return this.zzatu;
    }

    public final List<zzot> zzlx() {
        return this.zzatv;
    }

    public final List<zzot> zzly() {
        return this.zzatw;
    }

    public final List<zzot> zzlz() {
        return this.zzatx;
    }

    public final List<zzot> zzmq() {
        return this.zzava;
    }

    public final List<zzot> zzmr() {
        return this.zzavb;
    }
}
