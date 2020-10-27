package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.C2619h;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: org.greenrobot.eventbus.c */
public class C1126c {

    /* renamed from: s */
    static volatile C1126c f930s;

    /* renamed from: t */
    private static final C2614d f931t = new C2614d();

    /* renamed from: u */
    private static final Map<Class<?>, List<Class<?>>> f932u = new HashMap();

    /* renamed from: a */
    private final Map<Class<?>, CopyOnWriteArrayList<C2629q>> f933a;

    /* renamed from: b */
    private final Map<Object, List<Class<?>>> f934b;

    /* renamed from: c */
    private final Map<Class<?>, Object> f935c;

    /* renamed from: d */
    private final ThreadLocal<C1128b> f936d = new C1127a(this);

    /* renamed from: e */
    private final C2619h f937e;

    /* renamed from: f */
    private final C2624l f938f;

    /* renamed from: g */
    private final C2613b f939g;

    /* renamed from: h */
    private final C2612a f940h;

    /* renamed from: i */
    private final C2627p f941i;

    /* renamed from: j */
    private final ExecutorService f942j;

    /* renamed from: k */
    private final boolean f943k;

    /* renamed from: l */
    private final boolean f944l;

    /* renamed from: m */
    private final boolean f945m;

    /* renamed from: n */
    private final boolean f946n;

    /* renamed from: o */
    private final boolean f947o;

    /* renamed from: p */
    private final boolean f948p;

    /* renamed from: q */
    private final int f949q;

    /* renamed from: r */
    private final C2617g f950r;

    /* renamed from: org.greenrobot.eventbus.c$a */
    class C1127a extends ThreadLocal<C1128b> {
        C1127a(C1126c cVar) {
        }

        /* access modifiers changed from: protected */
        public Object initialValue() {
            return new C1128b();
        }
    }

    /* renamed from: org.greenrobot.eventbus.c$b */
    static final class C1128b {

        /* renamed from: a */
        final List<Object> f951a = new ArrayList();

        /* renamed from: b */
        boolean f952b;

        /* renamed from: c */
        boolean f953c;

        /* renamed from: d */
        Object f954d;

        /* renamed from: e */
        boolean f955e;

        C1128b() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0047 A[SYNTHETIC, Splitter:B:13:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1126c() {
        /*
            r5 = this;
            org.greenrobot.eventbus.d r0 = f931t
            r5.<init>()
            org.greenrobot.eventbus.c$a r1 = new org.greenrobot.eventbus.c$a
            r1.<init>(r5)
            r5.f936d = r1
            r1 = 0
            if (r0 == 0) goto L_0x00a5
            boolean r2 = org.greenrobot.eventbus.p131r.C2630a.m4586a()
            if (r2 == 0) goto L_0x0025
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ RuntimeException -> 0x001a }
            goto L_0x001b
        L_0x001a:
            r2 = r1
        L_0x001b:
            if (r2 == 0) goto L_0x0025
            org.greenrobot.eventbus.r.a r2 = new org.greenrobot.eventbus.r.a
            java.lang.String r3 = "EventBus"
            r2.<init>(r3)
            goto L_0x002a
        L_0x0025:
            org.greenrobot.eventbus.g$a r2 = new org.greenrobot.eventbus.g$a
            r2.<init>()
        L_0x002a:
            r5.f950r = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r5.f933a = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r5.f934b = r2
            java.util.concurrent.ConcurrentHashMap r2 = new java.util.concurrent.ConcurrentHashMap
            r2.<init>()
            r5.f935c = r2
            boolean r2 = org.greenrobot.eventbus.p131r.C2630a.m4586a()
            if (r2 == 0) goto L_0x0056
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ RuntimeException -> 0x004c }
            goto L_0x004d
        L_0x004c:
            r2 = r1
        L_0x004d:
            if (r2 != 0) goto L_0x0050
            goto L_0x0056
        L_0x0050:
            org.greenrobot.eventbus.h$a r3 = new org.greenrobot.eventbus.h$a
            r3.<init>(r2)
            goto L_0x0057
        L_0x0056:
            r3 = r1
        L_0x0057:
            r5.f937e = r3
            if (r3 == 0) goto L_0x005f
            org.greenrobot.eventbus.l r1 = r3.mo35645a(r5)
        L_0x005f:
            r5.f938f = r1
            org.greenrobot.eventbus.b r1 = new org.greenrobot.eventbus.b
            r1.<init>(r5)
            r5.f939g = r1
            org.greenrobot.eventbus.a r1 = new org.greenrobot.eventbus.a
            r1.<init>(r5)
            r5.f940h = r1
            java.util.List<org.greenrobot.eventbus.s.c> r1 = r0.f4306j
            if (r1 == 0) goto L_0x0078
            int r1 = r1.size()
            goto L_0x0079
        L_0x0078:
            r1 = 0
        L_0x0079:
            r5.f949q = r1
            org.greenrobot.eventbus.p r1 = new org.greenrobot.eventbus.p
            java.util.List<org.greenrobot.eventbus.s.c> r2 = r0.f4306j
            boolean r3 = r0.f4304h
            boolean r4 = r0.f4303g
            r1.<init>(r2, r3, r4)
            r5.f941i = r1
            boolean r1 = r0.f4297a
            r5.f944l = r1
            boolean r1 = r0.f4298b
            r5.f945m = r1
            boolean r1 = r0.f4299c
            r5.f946n = r1
            boolean r1 = r0.f4300d
            r5.f947o = r1
            boolean r1 = r0.f4301e
            r5.f943k = r1
            boolean r1 = r0.f4302f
            r5.f948p = r1
            java.util.concurrent.ExecutorService r0 = r0.f4305i
            r5.f942j = r0
            return
        L_0x00a5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.C1126c.<init>():void");
    }

    /* renamed from: a */
    private static List<Class<?>> m1632a(Class<?> cls) {
        ArrayList arrayList;
        synchronized (f932u) {
            List<Class<?>> list = f932u.get(cls);
            arrayList = list;
            if (list == null) {
                ArrayList arrayList2 = new ArrayList();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    arrayList2.add(cls2);
                    m1635a((List<Class<?>>) arrayList2, (Class<?>[]) cls2.getInterfaces());
                }
                f932u.put(cls, arrayList2);
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m1633a(Object obj, C1128b bVar) throws Error {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.f948p) {
            List<Class<?>> a = m1632a(cls);
            int size = a.size();
            z = false;
            for (int i = 0; i < size; i++) {
                z |= m1637a(obj, bVar, a.get(i));
            }
        } else {
            z = m1637a(obj, bVar, cls);
        }
        if (!z) {
            if (this.f945m) {
                C2617g gVar = this.f950r;
                Level level = Level.FINE;
                gVar.mo35643a(level, "No subscribers registered for event " + cls);
            }
            if (this.f947o && cls != C2621i.class && cls != C2625n.class) {
                mo21903a((Object) new C2621i(this, obj));
            }
        }
    }

    /* renamed from: a */
    static void m1635a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                m1635a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r5 != null) goto L_0x0045;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1636a(org.greenrobot.eventbus.C2629q r3, java.lang.Object r4, boolean r5) {
        /*
            r2 = this;
            org.greenrobot.eventbus.o r0 = r3.f4341b
            org.greenrobot.eventbus.ThreadMode r0 = r0.f4323b
            int r0 = r0.ordinal()
            if (r0 == 0) goto L_0x0049
            r1 = 1
            if (r0 == r1) goto L_0x0040
            r1 = 2
            if (r0 == r1) goto L_0x003b
            r1 = 3
            if (r0 == r1) goto L_0x0033
            r5 = 4
            if (r0 != r5) goto L_0x001c
            org.greenrobot.eventbus.a r5 = r2.f940h
            r5.mo35639a(r3, r4)
            goto L_0x004c
        L_0x001c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Unknown thread mode: "
            java.lang.StringBuilder r5 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r5)
            org.greenrobot.eventbus.o r3 = r3.f4341b
            org.greenrobot.eventbus.ThreadMode r3 = r3.f4323b
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.<init>(r3)
            throw r4
        L_0x0033:
            if (r5 == 0) goto L_0x0049
            org.greenrobot.eventbus.b r5 = r2.f939g
            r5.mo35639a(r3, r4)
            goto L_0x004c
        L_0x003b:
            org.greenrobot.eventbus.l r5 = r2.f938f
            if (r5 == 0) goto L_0x0049
            goto L_0x0045
        L_0x0040:
            if (r5 == 0) goto L_0x0043
            goto L_0x0049
        L_0x0043:
            org.greenrobot.eventbus.l r5 = r2.f938f
        L_0x0045:
            r5.mo35639a(r3, r4)
            goto L_0x004c
        L_0x0049:
            r2.mo21905a((org.greenrobot.eventbus.C2629q) r3, (java.lang.Object) r4)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.C1126c.m1636a(org.greenrobot.eventbus.q, java.lang.Object, boolean):void");
    }

    /* renamed from: a */
    private boolean m1637a(Object obj, C1128b bVar, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f933a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            C2629q qVar = (C2629q) it.next();
            bVar.f954d = obj;
            try {
                m1636a(qVar, obj, bVar.f953c);
                if (bVar.f955e) {
                    return true;
                }
            } finally {
                bVar.f955e = false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static C1126c m1638c() {
        C1126c cVar = f930s;
        if (cVar == null) {
            synchronized (C1126c.class) {
                cVar = f930s;
                if (cVar == null) {
                    cVar = new C1126c();
                    f930s = cVar;
                }
            }
        }
        return cVar;
    }

    /* renamed from: d */
    private boolean m1639d() {
        C2619h hVar = this.f937e;
        return hVar == null || ((C2619h.C2620a) hVar).mo35646a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ExecutorService mo21902a() {
        return this.f942j;
    }

    /* renamed from: a */
    public void mo21903a(Object obj) {
        C1128b bVar = this.f936d.get();
        List<Object> list = bVar.f951a;
        list.add(obj);
        if (!bVar.f952b) {
            bVar.f953c = m1639d();
            bVar.f952b = true;
            if (!bVar.f955e) {
                while (!list.isEmpty()) {
                    try {
                        m1633a(list.remove(0), bVar);
                    } finally {
                        bVar.f952b = false;
                        bVar.f953c = false;
                    }
                }
                return;
            }
            throw new C2615e("Internal error. Abort state was not reset");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo21904a(C2622j jVar) {
        Object obj = jVar.f4314a;
        C2629q qVar = jVar.f4315b;
        C2622j.m4572a(jVar);
        if (qVar.f4342c) {
            mo21905a(qVar, obj);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo21905a(C2629q qVar, Object obj) {
        try {
            qVar.f4341b.f4322a.invoke(qVar.f4340a, new Object[]{obj});
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (obj instanceof C2625n) {
                if (this.f944l) {
                    C2617g gVar = this.f950r;
                    Level level = Level.SEVERE;
                    StringBuilder a = C0681a.m330a("SubscriberExceptionEvent subscriber ");
                    a.append(qVar.f4340a.getClass());
                    a.append(" threw an exception");
                    gVar.mo35644a(level, a.toString(), cause);
                    C2625n nVar = (C2625n) obj;
                    C2617g gVar2 = this.f950r;
                    Level level2 = Level.SEVERE;
                    StringBuilder a2 = C0681a.m330a("Initial event ");
                    a2.append(nVar.f4320b);
                    a2.append(" caused exception in ");
                    a2.append(nVar.f4321c);
                    gVar2.mo35644a(level2, a2.toString(), nVar.f4319a);
                }
            } else if (!this.f943k) {
                if (this.f944l) {
                    C2617g gVar3 = this.f950r;
                    Level level3 = Level.SEVERE;
                    StringBuilder a3 = C0681a.m330a("Could not dispatch event: ");
                    a3.append(obj.getClass());
                    a3.append(" to subscribing class ");
                    a3.append(qVar.f4340a.getClass());
                    gVar3.mo35644a(level3, a3.toString(), cause);
                }
                if (this.f946n) {
                    mo21903a((Object) new C2625n(this, cause, obj, qVar.f4340a));
                }
            } else {
                throw new C2615e("Invoking subscriber failed", cause);
            }
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        }
    }

    /* renamed from: b */
    public C2617g mo21906b() {
        return this.f950r;
    }

    /* renamed from: b */
    public void mo21907b(Object obj) {
        List<C2626o> a = this.f941i.mo35652a(obj.getClass());
        synchronized (this) {
            for (C2626o a2 : a) {
                m1634a(obj, a2);
            }
        }
    }

    /* renamed from: c */
    public synchronized void mo21908c(Object obj) {
        List<Class> list = this.f934b.get(obj);
        if (list != null) {
            for (Class cls : list) {
                List list2 = this.f933a.get(cls);
                if (list2 != null) {
                    int size = list2.size();
                    int i = 0;
                    while (i < size) {
                        C2629q qVar = (C2629q) list2.get(i);
                        if (qVar.f4340a == obj) {
                            qVar.f4342c = false;
                            list2.remove(i);
                            i--;
                            size--;
                        }
                        i++;
                    }
                }
            }
            this.f934b.remove(obj);
        } else {
            this.f950r.mo35643a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("EventBus[indexCount=");
        a.append(this.f949q);
        a.append(", eventInheritance=");
        a.append(this.f948p);
        a.append("]");
        return a.toString();
    }

    /* renamed from: a */
    private void m1634a(Object obj, C2626o oVar) {
        Object value;
        Class<?> cls = oVar.f4324c;
        C2629q qVar = new C2629q(obj, oVar);
        CopyOnWriteArrayList copyOnWriteArrayList = this.f933a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f933a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            StringBuilder a = C0681a.m330a("Subscriber ");
            a.append(obj.getClass());
            a.append(" already registered to event ");
            a.append(cls);
            throw new C2615e(a.toString());
        }
        int size = copyOnWriteArrayList.size();
        int i = 0;
        while (true) {
            if (i > size) {
                break;
            } else if (i == size || oVar.f4325d > ((C2629q) copyOnWriteArrayList.get(i)).f4341b.f4325d) {
                copyOnWriteArrayList.add(i, qVar);
            } else {
                i++;
            }
        }
        copyOnWriteArrayList.add(i, qVar);
        List list = this.f934b.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f934b.put(obj, list);
        }
        list.add(cls);
        if (!oVar.f4326e) {
            return;
        }
        if (this.f948p) {
            for (Map.Entry next : this.f935c.entrySet()) {
                if (cls.isAssignableFrom((Class) next.getKey()) && (value = next.getValue()) != null) {
                    m1636a(qVar, value, m1639d());
                }
            }
            return;
        }
        Object obj2 = this.f935c.get(cls);
        if (obj2 != null) {
            m1636a(qVar, obj2, m1639d());
        }
    }
}
