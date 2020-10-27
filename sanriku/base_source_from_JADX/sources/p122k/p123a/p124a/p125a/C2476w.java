package p122k.p123a.p124a.p125a;

import p009e.p010a.p011a.p012a.C0681a;
import p122k.p123a.p124a.p125a.p129H.C2444a;
import p122k.p123a.p124a.p125a.p129H.C2446c;
import p122k.p123a.p124a.p125a.p129H.C2448e;

/* renamed from: k.a.a.a.w */
public class C2476w implements C2448e {

    /* renamed from: c */
    public static final C2471s f4070c = new C2471s();

    /* renamed from: a */
    public C2476w f4071a;

    /* renamed from: b */
    public int f4072b = -1;

    public C2476w() {
    }

    public C2476w(C2476w wVar, int i) {
        this.f4071a = wVar;
        this.f4072b = i;
    }

    /* renamed from: a */
    public <T> T mo34269a(C2444a<? extends T> aVar) {
        return aVar.mo34268a((C2448e) this);
    }

    /* renamed from: a */
    public C2446c mo34270a(int i) {
        throw null;
    }

    /* renamed from: b */
    public int mo20244b() {
        return -1;
    }

    public int getChildCount() {
        throw null;
    }

    public String getText() {
        if (getChildCount() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getChildCount(); i++) {
            sb.append(mo34270a(i).getText());
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("[");
        for (C2476w wVar = this; wVar != null; wVar = wVar.f4071a) {
            boolean z = false;
            if (!(wVar.f4072b == -1)) {
                a.append(wVar.f4072b);
            }
            C2476w wVar2 = wVar.f4071a;
            if (wVar2 != null) {
                if (wVar2.f4072b == -1) {
                    z = true;
                }
                if (!z) {
                    a.append(" ");
                }
            }
        }
        a.append("]");
        return a.toString();
    }
}
