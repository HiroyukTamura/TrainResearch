package p122k.p123a.p124a.p125a.p127F;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import p009e.p010a.p011a.p012a.C0681a;
import p122k.p123a.p124a.p125a.C2351B;
import p122k.p123a.p124a.p125a.C2352C;
import p122k.p123a.p124a.p125a.p127F.C2428d;

/* renamed from: k.a.a.a.F.c */
public class C2427c {

    /* renamed from: a */
    private final C2426b f3966a;

    /* renamed from: b */
    private final C2351B f3967b;

    public C2427c(C2426b bVar, C2351B b) {
        this.f3966a = bVar;
        this.f3967b = b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo34189a(C2428d dVar) {
        int i = dVar.f3968a;
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(dVar.f3971d ? ":" : str);
        sb.append("s");
        sb.append(i);
        if (dVar.f3974g) {
            str = "^";
        }
        sb.append(str);
        String sb2 = sb.toString();
        if (!dVar.f3971d) {
            return sb2;
        }
        C2428d.C2429a[] aVarArr = dVar.f3975h;
        StringBuilder c = C0681a.m340c(sb2, "=>");
        if (aVarArr != null) {
            c.append(Arrays.toString(dVar.f3975h));
        } else {
            c.append(dVar.f3972e);
        }
        return c.toString();
    }

    public String toString() {
        if (this.f3966a.f3962b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        C2426b bVar = this.f3966a;
        if (bVar != null) {
            ArrayList arrayList = new ArrayList(bVar.f3961a.keySet());
            Collections.sort(arrayList, new C2425a(bVar));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C2428d dVar = (C2428d) it.next();
                C2428d[] dVarArr = dVar.f3970c;
                int length = dVarArr != null ? dVarArr.length : 0;
                for (int i = 0; i < length; i++) {
                    C2428d dVar2 = dVar.f3970c[i];
                    if (!(dVar2 == null || dVar2.f3968a == Integer.MAX_VALUE)) {
                        sb.append(mo34189a(dVar));
                        String a = ((C2352C) this.f3967b).mo34032a(i - 1);
                        sb.append("-");
                        sb.append(a);
                        sb.append("->");
                        sb.append(mo34189a(dVar2));
                        sb.append(10);
                    }
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() == 0) {
                return null;
            }
            return sb2;
        }
        throw null;
    }
}
