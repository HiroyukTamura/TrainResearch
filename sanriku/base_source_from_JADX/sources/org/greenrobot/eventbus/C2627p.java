package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;
import org.greenrobot.eventbus.p132s.C2632b;
import org.greenrobot.eventbus.p132s.C2633c;

/* renamed from: org.greenrobot.eventbus.p */
class C2627p {

    /* renamed from: d */
    private static final Map<Class<?>, List<C2626o>> f4328d = new ConcurrentHashMap();

    /* renamed from: e */
    private static final C2628a[] f4329e = new C2628a[4];

    /* renamed from: a */
    private List<C2633c> f4330a;

    /* renamed from: b */
    private final boolean f4331b;

    /* renamed from: c */
    private final boolean f4332c;

    /* renamed from: org.greenrobot.eventbus.p$a */
    static class C2628a {

        /* renamed from: a */
        final List<C2626o> f4333a = new ArrayList();

        /* renamed from: b */
        final Map<Class, Object> f4334b = new HashMap();

        /* renamed from: c */
        final Map<String, Class> f4335c = new HashMap();

        /* renamed from: d */
        final StringBuilder f4336d = new StringBuilder(128);

        /* renamed from: e */
        Class<?> f4337e;

        /* renamed from: f */
        boolean f4338f;

        /* renamed from: g */
        C2632b f4339g;

        C2628a() {
        }

        /* renamed from: b */
        private boolean m4582b(Method method, Class<?> cls) {
            this.f4336d.setLength(0);
            this.f4336d.append(method.getName());
            StringBuilder sb = this.f4336d;
            sb.append(Typography.greater);
            sb.append(cls.getName());
            String sb2 = this.f4336d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f4335c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f4335c.put(sb2, put);
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo35653a() {
            if (!this.f4338f) {
                Class<? super Object> superclass = this.f4337e.getSuperclass();
                this.f4337e = superclass;
                String name = superclass.getName();
                if (!name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("android.") && !name.startsWith("androidx.")) {
                    return;
                }
            }
            this.f4337e = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo35654a(Method method, Class<?> cls) {
            Object put = this.f4334b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (m4582b((Method) put, cls)) {
                    this.f4334b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return m4582b(method, cls);
        }
    }

    C2627p(List<C2633c> list, boolean z, boolean z2) {
        this.f4330a = list;
        this.f4331b = z;
        this.f4332c = z2;
    }

    /* renamed from: a */
    private C2628a m4578a() {
        synchronized (f4329e) {
            for (int i = 0; i < 4; i++) {
                C2628a aVar = f4329e[i];
                if (aVar != null) {
                    f4329e[i] = null;
                    return aVar;
                }
            }
            return new C2628a();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e3, code lost:
        r1 = p009e.p010a.p011a.p012a.C0681a.m330a("Could not inspect methods of ");
        r1.append(r15.f4337e.getName());
        r15 = r1.toString();
        r1 = r14.f4332c;
        r15 = p009e.p010a.p011a.p012a.C0681a.m330a(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fc, code lost:
        if (r1 != false) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fe, code lost:
        r1 = ". Please consider using EventBus annotation processor to avoid reflection.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0101, code lost:
        r1 = ". Please make this class visible to EventBus annotation processor to avoid reflection.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0103, code lost:
        r15.append(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0110, code lost:
        throw new org.greenrobot.eventbus.C2615e(r15.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r1 = r15.f4337e.getMethods();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r15.f4338f = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4579a(org.greenrobot.eventbus.C2627p.C2628a r15) {
        /*
            r14 = this;
            r0 = 1
            java.lang.Class<?> r1 = r15.f4337e     // Catch:{ all -> 0x0008 }
            java.lang.reflect.Method[] r1 = r1.getDeclaredMethods()     // Catch:{ all -> 0x0008 }
            goto L_0x0010
        L_0x0008:
            java.lang.Class<?> r1 = r15.f4337e     // Catch:{ LinkageError -> 0x00e2 }
            java.lang.reflect.Method[] r1 = r1.getMethods()     // Catch:{ LinkageError -> 0x00e2 }
            r15.f4338f = r0
        L_0x0010:
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0013:
            if (r4 >= r2) goto L_0x00e1
            r6 = r1[r4]
            int r5 = r6.getModifiers()
            r7 = r5 & 1
            java.lang.String r8 = "."
            if (r7 == 0) goto L_0x00a6
            r5 = r5 & 5192(0x1448, float:7.276E-42)
            if (r5 != 0) goto L_0x00a6
            java.lang.Class[] r5 = r6.getParameterTypes()
            int r7 = r5.length
            if (r7 != r0) goto L_0x005b
            java.lang.Class<org.greenrobot.eventbus.m> r7 = org.greenrobot.eventbus.C1129m.class
            java.lang.annotation.Annotation r7 = r6.getAnnotation(r7)
            org.greenrobot.eventbus.m r7 = (org.greenrobot.eventbus.C1129m) r7
            if (r7 == 0) goto L_0x00dd
            r8 = r5[r3]
            boolean r5 = r15.mo35654a(r6, r8)
            if (r5 == 0) goto L_0x00dd
            org.greenrobot.eventbus.ThreadMode r9 = r7.threadMode()
            java.util.List<org.greenrobot.eventbus.o> r11 = r15.f4333a
            org.greenrobot.eventbus.o r12 = new org.greenrobot.eventbus.o
            int r10 = r7.priority()
            boolean r13 = r7.sticky()
            r5 = r12
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            r11.add(r12)
            goto L_0x00dd
        L_0x005b:
            boolean r7 = r14.f4331b
            if (r7 == 0) goto L_0x00dd
            java.lang.Class<org.greenrobot.eventbus.m> r7 = org.greenrobot.eventbus.C1129m.class
            boolean r7 = r6.isAnnotationPresent(r7)
            if (r7 != 0) goto L_0x0068
            goto L_0x00dd
        L_0x0068:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r0 = r0.getName()
            r15.append(r0)
            r15.append(r8)
            java.lang.String r0 = r6.getName()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            org.greenrobot.eventbus.e r0 = new org.greenrobot.eventbus.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "@Subscribe method "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r15 = "must have exactly 1 parameter but has "
            r1.append(r15)
            int r15 = r5.length
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L_0x00a6:
            boolean r5 = r14.f4331b
            if (r5 == 0) goto L_0x00dd
            java.lang.Class<org.greenrobot.eventbus.m> r5 = org.greenrobot.eventbus.C1129m.class
            boolean r5 = r6.isAnnotationPresent(r5)
            if (r5 != 0) goto L_0x00b3
            goto L_0x00dd
        L_0x00b3:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r0 = r0.getName()
            r15.append(r0)
            r15.append(r8)
            java.lang.String r0 = r6.getName()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            org.greenrobot.eventbus.e r0 = new org.greenrobot.eventbus.e
            java.lang.String r1 = " is a illegal @Subscribe method: must be public, non-static, and non-abstract"
            java.lang.String r15 = p009e.p010a.p011a.p012a.C0681a.m320a((java.lang.String) r15, (java.lang.String) r1)
            r0.<init>(r15)
            throw r0
        L_0x00dd:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x00e1:
            return
        L_0x00e2:
            r0 = move-exception
            java.lang.String r1 = "Could not inspect methods of "
            java.lang.StringBuilder r1 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r1)
            java.lang.Class<?> r15 = r15.f4337e
            java.lang.String r15 = r15.getName()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            boolean r1 = r14.f4332c
            java.lang.StringBuilder r15 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r15)
            if (r1 == 0) goto L_0x0101
            java.lang.String r1 = ". Please consider using EventBus annotation processor to avoid reflection."
            goto L_0x0103
        L_0x0101:
            java.lang.String r1 = ". Please make this class visible to EventBus annotation processor to avoid reflection."
        L_0x0103:
            r15.append(r1)
            java.lang.String r15 = r15.toString()
            org.greenrobot.eventbus.e r1 = new org.greenrobot.eventbus.e
            r1.<init>(r15, r0)
            goto L_0x0111
        L_0x0110:
            throw r1
        L_0x0111:
            goto L_0x0110
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.C2627p.m4579a(org.greenrobot.eventbus.p$a):void");
    }

    /* renamed from: b */
    private List<C2626o> m4580b(C2628a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f4333a);
        aVar.f4333a.clear();
        aVar.f4334b.clear();
        aVar.f4335c.clear();
        int i = 0;
        aVar.f4336d.setLength(0);
        aVar.f4337e = null;
        aVar.f4338f = false;
        aVar.f4339g = null;
        synchronized (f4329e) {
            while (true) {
                if (i >= 4) {
                    break;
                } else if (f4329e[i] == null) {
                    f4329e[i] = aVar;
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r0.f4337e == r3.mo35660c()) goto L_0x0072;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<org.greenrobot.eventbus.C2626o> mo35652a(java.lang.Class<?> r10) {
        /*
            r9 = this;
            java.util.Map<java.lang.Class<?>, java.util.List<org.greenrobot.eventbus.o>> r0 = f4328d
            java.lang.Object r0 = r0.get(r10)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            boolean r0 = r9.f4332c
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x002c
            org.greenrobot.eventbus.p$a r0 = r9.m4578a()
            r0.f4337e = r10
            r0.f4338f = r2
            r0.f4339g = r1
        L_0x001b:
            java.lang.Class<?> r1 = r0.f4337e
            if (r1 == 0) goto L_0x0026
            r9.m4579a((org.greenrobot.eventbus.C2627p.C2628a) r0)
            r0.mo35653a()
            goto L_0x001b
        L_0x0026:
            java.util.List r0 = r9.m4580b(r0)
            goto L_0x009d
        L_0x002c:
            org.greenrobot.eventbus.p$a r0 = r9.m4578a()
            r0.f4337e = r10
            r0.f4338f = r2
            r0.f4339g = r1
        L_0x0036:
            java.lang.Class<?> r3 = r0.f4337e
            if (r3 == 0) goto L_0x0099
            org.greenrobot.eventbus.s.b r3 = r0.f4339g
            if (r3 == 0) goto L_0x0053
            org.greenrobot.eventbus.s.b r3 = r3.mo35659b()
            if (r3 == 0) goto L_0x0053
            org.greenrobot.eventbus.s.b r3 = r0.f4339g
            org.greenrobot.eventbus.s.b r3 = r3.mo35659b()
            java.lang.Class<?> r4 = r0.f4337e
            java.lang.Class r5 = r3.mo35660c()
            if (r4 != r5) goto L_0x0053
            goto L_0x0072
        L_0x0053:
            java.util.List<org.greenrobot.eventbus.s.c> r3 = r9.f4330a
            if (r3 == 0) goto L_0x0071
            java.util.Iterator r3 = r3.iterator()
        L_0x005b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0071
            java.lang.Object r4 = r3.next()
            org.greenrobot.eventbus.s.c r4 = (org.greenrobot.eventbus.p132s.C2633c) r4
            java.lang.Class<?> r5 = r0.f4337e
            org.greenrobot.eventbus.s.b r4 = r4.getSubscriberInfo(r5)
            if (r4 == 0) goto L_0x005b
            r3 = r4
            goto L_0x0072
        L_0x0071:
            r3 = r1
        L_0x0072:
            r0.f4339g = r3
            if (r3 == 0) goto L_0x0092
            org.greenrobot.eventbus.o[] r3 = r3.mo35658a()
            int r4 = r3.length
            r5 = 0
        L_0x007c:
            if (r5 >= r4) goto L_0x0095
            r6 = r3[r5]
            java.lang.reflect.Method r7 = r6.f4322a
            java.lang.Class<?> r8 = r6.f4324c
            boolean r7 = r0.mo35654a(r7, r8)
            if (r7 == 0) goto L_0x008f
            java.util.List<org.greenrobot.eventbus.o> r7 = r0.f4333a
            r7.add(r6)
        L_0x008f:
            int r5 = r5 + 1
            goto L_0x007c
        L_0x0092:
            r9.m4579a((org.greenrobot.eventbus.C2627p.C2628a) r0)
        L_0x0095:
            r0.mo35653a()
            goto L_0x0036
        L_0x0099:
            java.util.List r0 = r9.m4580b(r0)
        L_0x009d:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x00a9
            java.util.Map<java.lang.Class<?>, java.util.List<org.greenrobot.eventbus.o>> r1 = f4328d
            r1.put(r10, r0)
            return r0
        L_0x00a9:
            org.greenrobot.eventbus.e r0 = new org.greenrobot.eventbus.e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Subscriber "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = " and its super classes have no public methods with the @Subscribe annotation"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.<init>(r10)
            goto L_0x00c6
        L_0x00c5:
            throw r0
        L_0x00c6:
            goto L_0x00c5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.C2627p.mo35652a(java.lang.Class):java.util.List");
    }
}
