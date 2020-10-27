package p009e.p013b.p014a;

import android.content.Context;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p013b.p014a.C0685c;

/* renamed from: e.b.a.d */
public class C0689d {

    /* renamed from: a */
    protected final Set<String> f366a = new HashSet();

    /* renamed from: b */
    protected final C0685c.C0687b f367b;

    /* renamed from: c */
    protected final C0685c.C0686a f368c;

    /* renamed from: e.b.a.d$a */
    class C0690a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f369a;

        /* renamed from: b */
        final /* synthetic */ String f370b;

        /* renamed from: c */
        final /* synthetic */ String f371c;

        /* renamed from: d */
        final /* synthetic */ C0685c.C0688c f372d;

        C0690a(Context context, String str, String str2, C0685c.C0688c cVar) {
            this.f369a = context;
            this.f370b = str;
            this.f371c = str2;
            this.f372d = cVar;
        }

        public void run() {
            try {
                C0689d.this.m348b(this.f369a, this.f370b, this.f371c);
                this.f372d.mo19769a();
            } catch (C0684b | UnsatisfiedLinkError e) {
                this.f372d.mo19770a(e);
            }
        }
    }

    protected C0689d() {
        C0692f fVar = new C0692f();
        C0682a aVar = new C0682a();
        this.f367b = fVar;
        this.f368c = aVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a8, code lost:
        if (r2.length > 0) goto L_0x00c4;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m348b(android.content.Context r15, java.lang.String r16, java.lang.String r17) {
        /*
            r14 = this;
            r7 = r14
            r8 = r16
            java.util.Set<java.lang.String> r0 = r7.f366a
            boolean r0 = r0.contains(r8)
            r9 = 0
            r10 = 1
            if (r0 == 0) goto L_0x0019
            java.lang.Object[] r0 = new java.lang.Object[r10]
            r0[r9] = r8
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "%s already loaded previously!"
            java.lang.String.format(r1, r2, r0)
            return
        L_0x0019:
            r11 = 0
            r12 = 2
            e.b.a.c$b r0 = r7.f367b     // Catch:{ UnsatisfiedLinkError -> 0x0038 }
            e.b.a.f r0 = (p009e.p013b.p014a.C0692f) r0     // Catch:{ UnsatisfiedLinkError -> 0x0038 }
            if (r0 == 0) goto L_0x0037
            java.lang.System.loadLibrary(r16)     // Catch:{ UnsatisfiedLinkError -> 0x0038 }
            java.util.Set<java.lang.String> r0 = r7.f366a     // Catch:{ UnsatisfiedLinkError -> 0x0038 }
            r0.add(r8)     // Catch:{ UnsatisfiedLinkError -> 0x0038 }
            java.lang.String r0 = "%s (%s) was loaded normally!"
            java.lang.Object[] r1 = new java.lang.Object[r12]     // Catch:{ UnsatisfiedLinkError -> 0x0038 }
            r1[r9] = r8     // Catch:{ UnsatisfiedLinkError -> 0x0038 }
            r1[r10] = r17     // Catch:{ UnsatisfiedLinkError -> 0x0038 }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ UnsatisfiedLinkError -> 0x0038 }
            java.lang.String.format(r2, r0, r1)     // Catch:{ UnsatisfiedLinkError -> 0x0038 }
            return
        L_0x0037:
            throw r11     // Catch:{ UnsatisfiedLinkError -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r10]
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)
            r1[r9] = r0
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r2 = "Loading the library normally failed: %s"
            java.lang.String.format(r0, r2, r1)
            java.lang.Object[] r0 = new java.lang.Object[r12]
            r0[r9] = r8
            r0[r10] = r17
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "%s (%s) was not loaded normally, re-linking..."
            java.lang.String.format(r1, r2, r0)
            java.io.File r0 = r14.mo19772a(r15, r16, r17)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x0061
            goto L_0x00d5
        L_0x0061:
            java.io.File r1 = r14.mo19771a(r15)
            java.io.File r2 = r14.mo19772a(r15, r16, r17)
            e.b.a.c$b r3 = r7.f367b
            e.b.a.f r3 = (p009e.p013b.p014a.C0692f) r3
            java.lang.String r3 = r3.mo19776a(r8)
            e.b.a.e r4 = new e.b.a.e
            r4.<init>(r14, r3)
            java.io.File[] r1 = r1.listFiles(r4)
            if (r1 != 0) goto L_0x007d
            goto L_0x0097
        L_0x007d:
            int r3 = r1.length
            r4 = 0
        L_0x007f:
            if (r4 >= r3) goto L_0x0097
            r5 = r1[r4]
            java.lang.String r6 = r5.getAbsolutePath()
            java.lang.String r13 = r2.getAbsolutePath()
            boolean r6 = r6.equals(r13)
            if (r6 != 0) goto L_0x0094
            r5.delete()
        L_0x0094:
            int r4 = r4 + 1
            goto L_0x007f
        L_0x0097:
            e.b.a.c$a r1 = r7.f368c
            e.b.a.c$b r2 = r7.f367b
            e.b.a.f r2 = (p009e.p013b.p014a.C0692f) r2
            if (r2 == 0) goto L_0x00f6
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r2 < r3) goto L_0x00ab
            java.lang.String[] r2 = android.os.Build.SUPPORTED_ABIS
            int r3 = r2.length
            if (r3 <= 0) goto L_0x00ab
            goto L_0x00c4
        L_0x00ab:
            java.lang.String r2 = android.os.Build.CPU_ABI2
            boolean r2 = p009e.p013b.p014a.C0685c.m344a(r2)
            if (r2 != 0) goto L_0x00be
            java.lang.String[] r2 = new java.lang.String[r12]
            java.lang.String r3 = android.os.Build.CPU_ABI
            r2[r9] = r3
            java.lang.String r3 = android.os.Build.CPU_ABI2
            r2[r10] = r3
            goto L_0x00c4
        L_0x00be:
            java.lang.String[] r2 = new java.lang.String[r10]
            java.lang.String r3 = android.os.Build.CPU_ABI
            r2[r9] = r3
        L_0x00c4:
            r3 = r2
            e.b.a.c$b r2 = r7.f367b
            e.b.a.f r2 = (p009e.p013b.p014a.C0692f) r2
            java.lang.String r4 = r2.mo19776a(r8)
            e.b.a.a r1 = (p009e.p013b.p014a.C0682a) r1
            r2 = r15
            r5 = r0
            r6 = r14
            r1.mo19768a(r2, r3, r4, r5, r6)
        L_0x00d5:
            e.b.a.c$b r1 = r7.f367b
            java.lang.String r0 = r0.getAbsolutePath()
            e.b.a.f r1 = (p009e.p013b.p014a.C0692f) r1
            if (r1 == 0) goto L_0x00f5
            java.lang.System.load(r0)
            java.util.Set<java.lang.String> r0 = r7.f366a
            r0.add(r8)
            java.lang.Object[] r0 = new java.lang.Object[r12]
            r0[r9] = r8
            r0[r10] = r17
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "%s (%s) was re-linked!"
            java.lang.String.format(r1, r2, r0)
            return
        L_0x00f5:
            throw r11
        L_0x00f6:
            goto L_0x00f8
        L_0x00f7:
            throw r11
        L_0x00f8:
            goto L_0x00f7
        */
        throw new UnsupportedOperationException("Method not decompiled: p009e.p013b.p014a.C0689d.m348b(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public File mo19771a(Context context) {
        return context.getDir("lib", 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public File mo19772a(Context context, String str, String str2) {
        String a = ((C0692f) this.f367b).mo19776a(str);
        return C0685c.m344a(str2) ? new File(mo19771a(context), a) : new File(mo19771a(context), C0681a.m321a(a, ".", str2));
    }

    /* renamed from: a */
    public void mo19773a(Context context, String str, String str2, C0685c.C0688c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (!C0685c.m344a(str)) {
            String.format(Locale.US, "Beginning load of %s...", new Object[]{str});
            if (cVar == null) {
                m348b(context, str, str2);
            } else {
                new Thread(new C0690a(context, str, str2, cVar)).start();
            }
        } else {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
    }
}
