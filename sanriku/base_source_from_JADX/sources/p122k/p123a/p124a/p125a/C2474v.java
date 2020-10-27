package p122k.p123a.p124a.p125a;

import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import p122k.p123a.p124a.p125a.p126E.C2387a;
import p122k.p123a.p124a.p125a.p126E.C2400f;

/* renamed from: k.a.a.a.v */
public abstract class C2474v<Symbol, ATNInterpreter extends C2400f> {

    /* renamed from: a */
    private List<C2452a> f4067a = new C2475a(this);

    /* renamed from: b */
    protected ATNInterpreter f4068b;

    /* renamed from: c */
    private int f4069c = -1;

    /* renamed from: k.a.a.a.v$a */
    class C2475a extends CopyOnWriteArrayList<C2452a> {
        C2475a(C2474v vVar) {
            add(C2461j.f4030a);
        }
    }

    static {
        new WeakHashMap();
        new WeakHashMap();
    }

    /* renamed from: a */
    public final void mo34349a(int i) {
        this.f4069c = i;
    }

    /* renamed from: a */
    public boolean mo34331a(C2476w wVar, int i) {
        return true;
    }

    /* renamed from: a */
    public boolean mo20205a(C2476w wVar, int i, int i2) {
        return true;
    }

    /* renamed from: f */
    public abstract C2387a mo20159f();

    /* renamed from: g */
    public C2452a mo34350g() {
        return new C2472t(this.f4067a);
    }

    /* renamed from: h */
    public ATNInterpreter mo34351h() {
        return this.f4068b;
    }

    /* renamed from: i */
    public final int mo34352i() {
        return this.f4069c;
    }
}
