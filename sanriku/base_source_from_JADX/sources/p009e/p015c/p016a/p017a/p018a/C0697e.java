package p009e.p015c.p016a.p017a.p018a;

import androidx.annotation.NonNull;
import java.io.Closeable;
import p009e.p015c.p016a.p017a.p018a.p019n.C0711a;
import p009e.p015c.p016a.p017a.p018a.p019n.C0713c;
import p009e.p015c.p016a.p017a.p018a.p019n.C0714d;
import p009e.p015c.p016a.p017a.p018a.p020o.C0718a;

/* renamed from: e.c.a.a.a.e */
public class C0697e<Model> implements Closeable {

    /* renamed from: a */
    final C0700h f378a;

    /* renamed from: b */
    final C0707k<Model> f379b;

    /* renamed from: c */
    final boolean f380c;

    /* renamed from: d */
    final C0713c f381d;

    /* renamed from: e */
    final String f382e;

    public C0697e(C0700h hVar, C0707k<Model> kVar, int i, boolean z) {
        C0711a l = hVar.mo19816l();
        this.f378a = hVar;
        this.f379b = kVar;
        this.f380c = z;
        String insertStatement = kVar.getInsertStatement(i, z);
        this.f382e = insertStatement;
        this.f381d = ((C0714d) l).mo19913a(insertStatement);
    }

    /* renamed from: a */
    public long mo19796a(@NonNull Model model) {
        C0700h hVar = this.f378a;
        if (hVar.f392h) {
            hVar.mo19809a((CharSequence) this.f382e, this.f379b.convertToArgs(hVar, model, this.f380c));
        }
        this.f379b.bindArgs(this.f378a, this.f381d, model, this.f380c);
        long b = this.f381d.mo19905b();
        this.f378a.mo19808a(C0718a.C0719a.INSERT, this.f379b);
        return b;
    }

    /* renamed from: b */
    public long mo19797b(@NonNull Model model) {
        try {
            return mo19796a(model);
        } finally {
            this.f381d.close();
        }
    }

    public void close() {
        this.f381d.close();
    }
}
