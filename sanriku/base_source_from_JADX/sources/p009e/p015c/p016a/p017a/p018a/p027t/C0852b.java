package p009e.p015c.p016a.p017a.p018a.p027t;

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import p009e.p015c.p016a.p017a.p018a.C0696d;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.C0703j;
import p009e.p015c.p016a.p017a.p018a.p027t.C0852b;
import p078g.p079a.C1714r;

/* renamed from: e.c.a.a.a.t.b */
public abstract class C0852b<Model, D extends C0852b<Model, ?>> extends C0696d<Model, D> {

    /* renamed from: e.c.a.a.a.t.b$a */
    class C0853a implements Callable<Integer> {
        C0853a() {
        }

        public Object call() throws Exception {
            return Integer.valueOf(C0852b.this.execute());
        }
    }

    public C0852b(@NonNull C0700h hVar) {
        super(hVar);
    }

    public C0852b(@NonNull C0703j<Model, ?> jVar) {
        super(jVar);
    }

    public C0852b(@NonNull C0852b<Model, D> bVar) {
        super(bVar);
    }

    @CheckResult
    @NonNull
    public C1714r<Integer> executeAsSingle() {
        return C1714r.m2413a(new C0853a());
    }
}
