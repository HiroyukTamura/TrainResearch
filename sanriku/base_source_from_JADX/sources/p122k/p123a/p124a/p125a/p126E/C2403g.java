package p122k.p123a.p124a.p125a.p126E;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p122k.p123a.p124a.p125a.p128G.C2440i;

/* renamed from: k.a.a.a.E.g */
public abstract class C2403g {

    /* renamed from: a */
    public C2387a f3915a = null;

    /* renamed from: b */
    public int f3916b = -1;

    /* renamed from: c */
    public int f3917c;

    /* renamed from: d */
    public boolean f3918d = false;

    /* renamed from: e */
    protected final List<C2401f0> f3919e = new ArrayList(4);

    /* renamed from: f */
    public C2440i f3920f;

    static {
        Collections.unmodifiableList(Arrays.asList(new String[]{"INVALID", "BASIC", "RULE_START", "BLOCK_START", "PLUS_BLOCK_START", "STAR_BLOCK_START", "TOKEN_START", "RULE_STOP", "BLOCK_END", "STAR_LOOP_BACK", "STAR_LOOP_ENTRY", "PLUS_LOOP_BACK", "LOOP_END"}));
    }

    /* renamed from: a */
    public int mo34153a() {
        return this.f3919e.size();
    }

    /* renamed from: a */
    public C2401f0 mo34154a(int i) {
        return this.f3919e.get(i);
    }

    /* renamed from: a */
    public void mo34155a(C2401f0 f0Var) {
        int size = this.f3919e.size();
        boolean z = true;
        if (this.f3919e.isEmpty()) {
            this.f3918d = f0Var.mo34081b();
        } else if (this.f3918d != f0Var.mo34081b()) {
            System.err.format(Locale.getDefault(), "ATN state %d has both epsilon and non-epsilon transitions.\n", new Object[]{Integer.valueOf(this.f3916b)});
            this.f3918d = false;
        }
        Iterator<C2401f0> it = this.f3919e.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            C2401f0 next = it.next();
            if (next.f3914a.f3916b == f0Var.f3914a.f3916b && ((next.mo34094c() != null && f0Var.mo34094c() != null && next.mo34094c().equals(f0Var.mo34094c())) || (next.mo34081b() && f0Var.mo34081b()))) {
                break;
            }
        }
        if (!z) {
            this.f3919e.add(size, f0Var);
        }
    }

    /* renamed from: b */
    public abstract int mo34062b();

    public boolean equals(Object obj) {
        return (obj instanceof C2403g) && this.f3916b == ((C2403g) obj).f3916b;
    }

    public int hashCode() {
        return this.f3916b;
    }

    public String toString() {
        return String.valueOf(this.f3916b);
    }
}
