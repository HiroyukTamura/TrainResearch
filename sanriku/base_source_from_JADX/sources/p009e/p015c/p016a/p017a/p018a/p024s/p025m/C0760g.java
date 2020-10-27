package p009e.p015c.p016a.p017a.p018a.p024s.p025m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.C0753c;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0764a;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0765b;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.p026i.C0767d;
import p122k.p123a.p124a.p125a.C2352C;
import p122k.p123a.p124a.p125a.C2453b;
import p122k.p123a.p124a.p125a.C2454c;
import p122k.p123a.p124a.p125a.C2460i;
import p122k.p123a.p124a.p125a.C2462k;
import p122k.p123a.p124a.p125a.p128G.C2443l;
import p122k.p123a.p124a.p125a.p129H.C2444a;
import p122k.p123a.p124a.p125a.p129H.C2446c;
import p122k.p123a.p124a.p125a.p129H.C2447d;
import p122k.p123a.p124a.p125a.p129H.C2450g;

/* renamed from: e.c.a.a.a.s.m.g */
public class C0760g {

    /* renamed from: e.c.a.a.a.s.m.g$a */
    static class C0761a extends C2444a<Void> {

        /* renamed from: a */
        final /* synthetic */ C0753c f468a;

        C0761a(C0753c cVar) {
            this.f468a = cVar;
        }

        /* renamed from: a */
        public Object mo19992a(C2450g gVar) {
            Object obj;
            List<CharSequence> list;
            int type = gVar.mo34274a().getType();
            if (type == -1) {
                return null;
            }
            if (gVar.getParent() instanceof C0767d.C0803c) {
                list = this.f468a.f462a;
                obj = new C0753c.C0756c(gVar.getText());
            } else if (((C2352C) C0765b.f474v).mo34034c(type).startsWith("K_")) {
                list = this.f468a.f462a;
                obj = new C0753c.C0755b(gVar.getText());
            } else {
                this.f468a.f462a.add(gVar.getText());
                return null;
            }
            list.add(obj);
            return null;
        }
    }

    /* renamed from: e.c.a.a.a.s.m.g$b */
    public static class C0762b extends RuntimeException {
        public C0762b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: a */
    public static C0748a m463a(@NonNull String str) {
        C0757d dVar = new C0757d();
        m465a((C0753c) dVar.f464a, (C2446c) m464a(str, (C0764a) dVar));
        return dVar.f464a;
    }

    /* renamed from: a */
    public static C0767d.C0795W m464a(@NonNull String str, @Nullable C0764a aVar) {
        C0767d dVar = new C0767d(new C2460i(new C0765b(new C2453b(str))));
        dVar.mo34326a((C2462k) new C2454c());
        if (aVar != null) {
            dVar.mo34325a((C2447d) aVar);
        }
        try {
            return dVar.mo20216k0();
        } catch (StackOverflowError | C2443l e) {
            throw new C0762b(C0681a.m320a("SQL is too complex to parse: ", str), e);
        }
    }

    /* renamed from: a */
    static void m465a(C0753c cVar, C2446c cVar2) {
        cVar2.mo34269a(new C0761a(cVar));
    }

    /* renamed from: b */
    public static C0749b m466b(@NonNull String str) {
        C0759f fVar = new C0759f();
        m465a((C0753c) fVar.f467b, (C2446c) m464a(str, (C0764a) fVar));
        return fVar.f467b;
    }
}
