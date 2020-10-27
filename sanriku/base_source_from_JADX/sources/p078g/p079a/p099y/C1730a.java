package p078g.p079a.p099y;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: g.a.y.a */
public final class C1730a extends RuntimeException {

    /* renamed from: a */
    private final List<Throwable> f2073a;

    /* renamed from: b */
    private final String f2074b;

    /* renamed from: c */
    private Throwable f2075c;

    /* renamed from: g.a.y.a$a */
    static final class C1731a extends RuntimeException {
        C1731a() {
        }

        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    /* renamed from: g.a.y.a$b */
    static abstract class C1732b {
        C1732b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract void mo27447a(Object obj);
    }

    /* renamed from: g.a.y.a$c */
    static final class C1733c extends C1732b {

        /* renamed from: a */
        private final PrintStream f2076a;

        C1733c(PrintStream printStream) {
            this.f2076a = printStream;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27447a(Object obj) {
            this.f2076a.println(obj);
        }
    }

    /* renamed from: g.a.y.a$d */
    static final class C1734d extends C1732b {

        /* renamed from: a */
        private final PrintWriter f2077a;

        C1734d(PrintWriter printWriter) {
            this.f2077a = printWriter;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo27447a(Object obj) {
            this.f2077a.println(obj);
        }
    }

    public C1730a(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Object obj : iterable) {
                if (obj instanceof C1730a) {
                    linkedHashSet.addAll(((C1730a) obj).f2073a);
                } else {
                    linkedHashSet.add(obj == null ? new NullPointerException("Throwable was null!") : obj);
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            this.f2073a = Collections.unmodifiableList(arrayList);
            this.f2074b = this.f2073a.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C1730a(Throwable... thArr) {
        this((Iterable<? extends Throwable>) thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    /* renamed from: a */
    private void m2446a(C1732b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append(10);
        for (StackTraceElement append : getStackTrace()) {
            sb.append("\tat ");
            sb.append(append);
            sb.append(10);
        }
        int i = 1;
        for (Throwable a : this.f2073a) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            m2447a(sb, a, "\t");
            i++;
        }
        bVar.mo27447a(sb.toString());
    }

    /* renamed from: a */
    private void m2447a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append(10);
        for (StackTraceElement append : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(append);
            sb.append(10);
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            m2447a(sb, th.getCause(), "");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:10|(1:(1:13)(1:(2:14|(1:52)(1:(2:53|17)(1:18)))))(0)|19|(4:22|(2:24|55)(2:25|56)|54|20)|26|27|28|29|(1:49)(1:(2:32|50)(3:(2:33|(1:57)(1:(2:58|36)(1:37)))|38|51))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x006d */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0016 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Throwable getCause() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Throwable r0 = r8.f2075c     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x0085
            g.a.y.a$a r0 = new g.a.y.a$a     // Catch:{ all -> 0x0089 }
            r0.<init>()     // Catch:{ all -> 0x0089 }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0089 }
            r1.<init>()     // Catch:{ all -> 0x0089 }
            java.util.List<java.lang.Throwable> r2 = r8.f2073a     // Catch:{ all -> 0x0089 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0089 }
            r3 = r0
        L_0x0016:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x0083
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0089 }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x0089 }
            boolean r5 = r1.contains(r4)     // Catch:{ all -> 0x0089 }
            if (r5 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0029:
            r1.add(r4)     // Catch:{ all -> 0x0089 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0089 }
            r5.<init>()     // Catch:{ all -> 0x0089 }
            java.lang.Throwable r6 = r4.getCause()     // Catch:{ all -> 0x0089 }
            if (r6 == 0) goto L_0x0048
            if (r6 != r4) goto L_0x003a
            goto L_0x0048
        L_0x003a:
            r5.add(r6)     // Catch:{ all -> 0x0089 }
            java.lang.Throwable r7 = r6.getCause()     // Catch:{ all -> 0x0089 }
            if (r7 == 0) goto L_0x0048
            if (r7 != r6) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r6 = r7
            goto L_0x003a
        L_0x0048:
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0089 }
        L_0x004c:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0089 }
            if (r6 == 0) goto L_0x006a
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0089 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0089 }
            boolean r7 = r1.contains(r6)     // Catch:{ all -> 0x0089 }
            if (r7 == 0) goto L_0x0066
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0089 }
            java.lang.String r6 = "Duplicate found in causal chain so cropping to prevent loop ..."
            r4.<init>(r6)     // Catch:{ all -> 0x0089 }
            goto L_0x004c
        L_0x0066:
            r1.add(r6)     // Catch:{ all -> 0x0089 }
            goto L_0x004c
        L_0x006a:
            r3.initCause(r4)     // Catch:{ all -> 0x006d }
        L_0x006d:
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x0016
            if (r3 != r4) goto L_0x0076
            goto L_0x0016
        L_0x0076:
            java.lang.Throwable r3 = r4.getCause()     // Catch:{ all -> 0x0089 }
            if (r3 == 0) goto L_0x0081
            if (r3 != r4) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r4 = r3
            goto L_0x0076
        L_0x0081:
            r3 = r4
            goto L_0x0016
        L_0x0083:
            r8.f2075c = r0     // Catch:{ all -> 0x0089 }
        L_0x0085:
            java.lang.Throwable r0 = r8.f2075c     // Catch:{ all -> 0x0089 }
            monitor-exit(r8)
            return r0
        L_0x0089:
            r0 = move-exception
            monitor-exit(r8)
            goto L_0x008d
        L_0x008c:
            throw r0
        L_0x008d:
            goto L_0x008c
        */
        throw new UnsupportedOperationException("Method not decompiled: p078g.p079a.p099y.C1730a.getCause():java.lang.Throwable");
    }

    public String getMessage() {
        return this.f2074b;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        m2446a(new C1733c(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        m2446a(new C1734d(printWriter));
    }
}
