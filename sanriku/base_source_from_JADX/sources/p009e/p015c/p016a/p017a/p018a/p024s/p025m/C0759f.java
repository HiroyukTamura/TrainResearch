package p009e.p015c.p016a.p017a.p018a.p024s.p025m;

import java.util.Iterator;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p015c.p016a.p017a.p018a.p024s.C0744k;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.C0749b;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.C0753c;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0764a;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0767d;
import p122k.p123a.p124a.p125a.C2471s;
import p122k.p123a.p124a.p125a.p129H.C2446c;

/* renamed from: e.c.a.a.a.s.m.f */
public class C0759f extends C0764a {

    /* renamed from: a */
    C0749b.C0750a f466a;

    /* renamed from: b */
    C0749b f467b;

    /* renamed from: a */
    public void mo19993a(C0767d.C0813h hVar) {
        String str;
        C0749b.C0750a.C0751a aVar = new C0749b.C0750a.C0751a();
        if (hVar.mo34343a(113, 0) == null && hVar.mo34343a(102, 0) == null && hVar.mo34343a(104, 0) == null && hVar.mo34343a(56, 0) != null) {
            List<C2446c> list = hVar.f4058d;
            for (C2446c next : list.subList(1, list.size())) {
                if (aVar.f461b == null) {
                    str = ((StringBuilder) next.mo34269a(new C0758e())).toString();
                } else {
                    str = aVar.f461b + " " + ((StringBuilder) next.mo34269a(new C0758e())).toString();
                }
                aVar.f461b = str;
            }
        }
        C0760g.m465a((C0753c) aVar, (C2446c) hVar);
        this.f466a.f460d.add(aVar);
    }

    /* renamed from: a */
    public void mo19994a(C0767d.C0815i iVar) {
        C0760g.m465a((C0753c) this.f466a, (C2446c) iVar);
        this.f466a = null;
    }

    /* renamed from: b */
    public void mo19998b(C0767d.C0815i iVar) {
        C0749b.C0750a aVar = new C0749b.C0750a();
        this.f466a = aVar;
        this.f467b.f455c.add(aVar);
    }

    /* renamed from: b */
    public void mo19999b(C0767d.C0817j jVar) {
        C0749b.C0750a aVar = this.f466a;
        if (aVar != null && aVar.f458b == null) {
            aVar.f458b = new C0753c.C0756c(jVar.getText());
        }
    }

    /* renamed from: b */
    public void mo20000b(C0767d.C0831q qVar) {
        this.f467b = new C0749b();
    }

    /* renamed from: b */
    public void mo19990b(C0767d.C0838t0 t0Var) {
        this.f467b.f454b = new C0753c.C0756c(t0Var.getText());
    }

    /* renamed from: a */
    public void mo19995a(C0767d.C0831q qVar) {
        if (qVar.mo34343a(33, 0) != null) {
            this.f467b.f457e = new C0763h();
            C0760g.m465a((C0753c) this.f467b.f457e, (C2446c) qVar);
        }
        C0760g.m465a((C0753c) this.f467b, (C2446c) qVar);
    }

    /* renamed from: a */
    public void mo19996a(C0767d.C0834r0 r0Var) {
        C0749b.C0752b bVar = new C0749b.C0752b();
        if (r0Var.mo34343a(49, 0) != null) {
            Class<C0767d.C0792T> cls = C0767d.C0792T.class;
            List<C2446c> list = r0Var.f4058d;
            C2446c cVar = null;
            if (list != null && list.size() > 0) {
                Iterator<C2446c> it = r0Var.f4058d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C2446c next = it.next();
                    if (cls.isInstance(next)) {
                        cVar = cls.cast(next);
                        break;
                    }
                }
            }
            String text = ((C0767d.C0792T) ((C2471s) cVar)).getText();
            StringBuilder a = C0681a.m329a('`');
            a.append(C0744k.m437a(text));
            a.append('`');
            a.toString();
        }
        C0760g.m465a((C0753c) bVar, (C2446c) r0Var);
        this.f467b.f456d.add(bVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        if (r2 == null) goto L_0x0034;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo19997a(p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0767d.C0848y0 r6) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class<e.c.a.a.a.s.m.i.d$T> r1 = p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0767d.C0792T.class
            java.util.List<k.a.a.a.H.c> r6 = r6.f4058d
            if (r6 != 0) goto L_0x000c
            goto L_0x0034
        L_0x000c:
            r2 = 0
            java.util.Iterator r6 = r6.iterator()
        L_0x0011:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L_0x0032
            java.lang.Object r3 = r6.next()
            k.a.a.a.H.c r3 = (p122k.p123a.p124a.p125a.p129H.C2446c) r3
            boolean r4 = r1.isInstance(r3)
            if (r4 == 0) goto L_0x0011
            if (r2 != 0) goto L_0x002a
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x002a:
            java.lang.Object r3 = r1.cast(r3)
            r2.add(r3)
            goto L_0x0011
        L_0x0032:
            if (r2 != 0) goto L_0x0038
        L_0x0034:
            java.util.List r2 = java.util.Collections.emptyList()
        L_0x0038:
            java.util.Iterator r6 = r2.iterator()
        L_0x003c:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r6.next()
            e.c.a.a.a.s.m.i.d$T r1 = (p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0767d.C0792T) r1
            int r2 = r0.length()
            if (r2 == 0) goto L_0x0053
            r2 = 32
            r0.append(r2)
        L_0x0053:
            java.lang.String r1 = r1.getText()
            r0.append(r1)
            goto L_0x003c
        L_0x005b:
            e.c.a.a.a.s.m.b$a r6 = r5.f466a
            java.lang.String r0 = r0.toString()
            r6.f459c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p009e.p015c.p016a.p017a.p018a.p024s.p025m.C0759f.mo19997a(e.c.a.a.a.s.m.i.d$y0):void");
    }
}
