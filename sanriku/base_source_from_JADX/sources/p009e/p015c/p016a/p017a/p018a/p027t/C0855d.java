package p009e.p015c.p016a.p017a.p018a.p027t;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.List;
import p009e.p015c.p016a.p017a.p018a.C0700h;
import p009e.p015c.p016a.p017a.p018a.C0702i;
import p009e.p015c.p016a.p017a.p018a.C0707k;
import p009e.p015c.p016a.p017a.p018a.C0708l;
import p009e.p015c.p016a.p017a.p018a.p020o.C0718a;
import p009e.p015c.p016a.p017a.p018a.p020o.C0720b;
import p078g.p079a.C1706l;
import p078g.p079a.p095D.C1692a;

/* renamed from: e.c.a.a.a.t.d */
public class C0855d extends C0700h {

    /* renamed from: n */
    final C0851a f489n = new C0851a();

    public C0855d(@NonNull C0702i<?> iVar, List<C0707k<?>> list) {
        super(iVar, list);
    }

    /* renamed from: a */
    public <S extends C0708l<?, ?>> C1706l<C0718a<S>> mo20248a(S s) {
        C0851a aVar = this.f489n;
        if (aVar != null) {
            C1692a a = C1692a.m2379a();
            aVar.f486a.put(new WeakReference(a), s);
            return a;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public C0720b mo19815i() {
        return this.f489n;
    }
}
