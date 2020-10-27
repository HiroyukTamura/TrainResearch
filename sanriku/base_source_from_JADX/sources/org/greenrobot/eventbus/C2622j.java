package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* renamed from: org.greenrobot.eventbus.j */
final class C2622j {

    /* renamed from: d */
    private static final List<C2622j> f4313d = new ArrayList();

    /* renamed from: a */
    Object f4314a;

    /* renamed from: b */
    C2629q f4315b;

    /* renamed from: c */
    C2622j f4316c;

    private C2622j(Object obj, C2629q qVar) {
        this.f4314a = obj;
        this.f4315b = qVar;
    }

    /* renamed from: a */
    static C2622j m4571a(C2629q qVar, Object obj) {
        synchronized (f4313d) {
            int size = f4313d.size();
            if (size <= 0) {
                return new C2622j(obj, qVar);
            }
            C2622j remove = f4313d.remove(size - 1);
            remove.f4314a = obj;
            remove.f4315b = qVar;
            remove.f4316c = null;
            return remove;
        }
    }

    /* renamed from: a */
    static void m4572a(C2622j jVar) {
        jVar.f4314a = null;
        jVar.f4315b = null;
        jVar.f4316c = null;
        synchronized (f4313d) {
            if (f4313d.size() < 10000) {
                f4313d.add(jVar);
            }
        }
    }
}
