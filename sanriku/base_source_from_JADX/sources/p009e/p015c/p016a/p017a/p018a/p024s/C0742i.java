package p009e.p015c.p016a.p017a.p018a.p024s;

import java.util.List;
import p009e.p015c.p016a.p017a.p018a.p019n.C0711a;
import p009e.p015c.p016a.p017a.p018a.p019n.C0714d;

/* renamed from: e.c.a.a.a.s.i */
class C0742i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f441a;

    /* renamed from: b */
    final /* synthetic */ C0711a f442b;

    /* renamed from: c */
    final /* synthetic */ C0743j f443c;

    C0742i(C0743j jVar, List list, C0711a aVar) {
        this.f443c = jVar;
        this.f441a = list;
        this.f442b = aVar;
    }

    public void run() {
        for (String str : this.f441a) {
            this.f443c.mo19951a("%s", str);
            ((C0714d) this.f442b).mo19919b(str);
        }
        int b = C0743j.m433c(this.f442b);
        for (String a : this.f441a) {
            this.f443c.mo19969a(this.f442b, b, a, new Object[0]);
        }
    }
}
