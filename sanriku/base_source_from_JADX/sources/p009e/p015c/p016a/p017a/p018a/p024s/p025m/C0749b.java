package p009e.p015c.p016a.p017a.p018a.p024s.p025m;

import java.util.ArrayList;
import java.util.List;
import p009e.p015c.p016a.p017a.p018a.p024s.p025m.C0753c;

/* renamed from: e.c.a.a.a.s.m.b */
public class C0749b extends C0753c {

    /* renamed from: b */
    C0753c.C0756c f454b;

    /* renamed from: c */
    List<C0750a> f455c = new ArrayList();

    /* renamed from: d */
    List<C0752b> f456d = new ArrayList();

    /* renamed from: e */
    C0763h f457e;

    /* renamed from: e.c.a.a.a.s.m.b$a */
    public static class C0750a extends C0753c {

        /* renamed from: b */
        C0753c.C0756c f458b;

        /* renamed from: c */
        String f459c;

        /* renamed from: d */
        List<C0751a> f460d = new ArrayList();

        /* renamed from: e.c.a.a.a.s.m.b$a$a */
        public static class C0751a extends C0753c {

            /* renamed from: b */
            String f461b;
        }

        /* renamed from: a */
        public C0753c.C0756c mo19976a() {
            return this.f458b;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(this.f458b);
            if (this.f459c != null) {
                sb.append(' ');
                sb.append(this.f459c);
            }
            for (C0751a append : this.f460d) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }
    }

    /* renamed from: e.c.a.a.a.s.m.b$b */
    public static class C0752b extends C0753c {
    }

    /* renamed from: a */
    public List<C0750a> mo19973a() {
        return this.f455c;
    }

    /* renamed from: b */
    public List<C0752b> mo19974b() {
        return this.f456d;
    }

    /* renamed from: c */
    public C0753c.C0756c mo19975c() {
        return this.f454b;
    }
}
