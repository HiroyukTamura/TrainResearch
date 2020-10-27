package p009e.p015c.p016a.p017a.p018a.p027t;

import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p009e.p015c.p016a.p017a.p018a.C0707k;
import p009e.p015c.p016a.p017a.p018a.C0708l;
import p009e.p015c.p016a.p017a.p018a.p019n.C0711a;
import p009e.p015c.p016a.p017a.p018a.p019n.C0714d;
import p009e.p015c.p016a.p017a.p018a.p020o.C0718a;
import p009e.p015c.p016a.p017a.p018a.p020o.C0720b;
import p078g.p079a.C1710p;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: e.c.a.a.a.t.a */
public class C0851a implements C0720b {

    /* renamed from: a */
    final Map<WeakReference<C1710p<C0718a<?>>>, C0708l<?, ?>> f486a = new ConcurrentHashMap();

    /* renamed from: b */
    Set<C0707k<?>> f487b = null;

    /* renamed from: a */
    public void mo19928a() {
        Set<C0707k<?>> set = this.f487b;
        this.f487b = null;
        if (set != null) {
            for (Map.Entry next : this.f486a.entrySet()) {
                C0708l lVar = (C0708l) next.getValue();
                if (set.contains(lVar.getSchema())) {
                    WeakReference weakReference = (WeakReference) next.getKey();
                    if (weakReference.get() != null) {
                        ((C1710p) weakReference.get()).mo27337a(new C0718a(C0718a.C0719a.TRANSACTION, lVar));
                    } else {
                        this.f486a.remove(weakReference);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public <Model> void mo19929a(C0711a aVar, C0718a.C0719a aVar2, C0707k<Model> kVar) {
        if (!this.f486a.isEmpty()) {
            if (((C0714d) aVar).mo19923f()) {
                if (this.f487b == null) {
                    this.f487b = new HashSet();
                }
                this.f487b.add(kVar);
                return;
            }
            for (Map.Entry next : this.f486a.entrySet()) {
                C0708l lVar = (C0708l) next.getValue();
                if (kVar == lVar.getSchema()) {
                    WeakReference weakReference = (WeakReference) next.getKey();
                    if (weakReference.get() != null) {
                        ((C1710p) weakReference.get()).mo27337a(new C0718a(aVar2, lVar));
                    } else {
                        this.f486a.remove(weakReference);
                    }
                }
            }
        }
    }
}
