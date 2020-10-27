package p009e.p015c.p016a.p017a.p018a.p027t;

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.C0703j;
import p009e.p015c.p016a.p017a.p018a.C0710m;
import p009e.p015c.p016a.p017a.p018a.p027t.C0869g;
import p078g.p079a.C1714r;

/* renamed from: e.c.a.a.a.t.g */
public abstract class C0869g<Model, U extends C0869g<Model, ?>> extends C0710m<Model, U> {

    /* renamed from: e.c.a.a.a.t.g$a */
    class C0870a implements Callable<Integer> {
        C0870a() {
        }

        public Object call() throws Exception {
            return Integer.valueOf(C0869g.this.execute());
        }
    }

    public C0869g(@NonNull C0700h hVar) {
        super(hVar);
    }

    public C0869g(@NonNull C0703j<Model, ?> jVar) {
        super(jVar);
    }

    public C0869g(@NonNull C0869g<Model, U> gVar) {
        super(gVar);
    }

    @CheckResult
    @NonNull
    public C1714r<Integer> executeAsSingle() {
        return C1714r.m2413a(new C0870a());
    }
}
