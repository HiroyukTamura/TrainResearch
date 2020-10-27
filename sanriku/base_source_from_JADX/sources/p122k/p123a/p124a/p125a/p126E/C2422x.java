package p122k.p123a.p124a.p125a.p126E;

import java.util.Arrays;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: k.a.a.a.E.x */
public class C2422x {

    /* renamed from: a */
    private final C2421w[] f3949a;

    /* renamed from: b */
    private final int f3950b;

    public C2422x(C2421w[] wVarArr) {
        this.f3949a = wVarArr;
        int i = 0;
        for (C2421w a : wVarArr) {
            i = C1532a.m2120a(i, (Object) a);
        }
        this.f3950b = C1532a.m2119a(i, wVarArr.length);
    }

    /* renamed from: a */
    public static C2422x m4119a(C2422x xVar, C2421w wVar) {
        if (xVar == null) {
            return new C2422x(new C2421w[]{wVar});
        }
        C2421w[] wVarArr = xVar.f3949a;
        C2421w[] wVarArr2 = (C2421w[]) Arrays.copyOf(wVarArr, wVarArr.length + 1);
        wVarArr2[wVarArr2.length - 1] = wVar;
        return new C2422x(wVarArr2);
    }

    /* renamed from: a */
    public C2422x mo34177a(int i) {
        C2421w[] wVarArr = null;
        int i2 = 0;
        while (true) {
            C2421w[] wVarArr2 = this.f3949a;
            if (i2 >= wVarArr2.length) {
                break;
            }
            if (wVarArr2[i2].mo34037a()) {
                C2421w[] wVarArr3 = this.f3949a;
                if (!(wVarArr3[i2] instanceof C2355B)) {
                    if (wVarArr == null) {
                        wVarArr = (C2421w[]) wVarArr3.clone();
                    }
                    wVarArr[i2] = new C2355B(i, this.f3949a[i2]);
                }
            }
            i2++;
        }
        return wVarArr == null ? this : new C2422x(wVarArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0043  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo34178a(p122k.p123a.p124a.p125a.C2466o r9, p122k.p123a.p124a.p125a.C2457f r10, int r11) {
        /*
            r8 = this;
            int r0 = r10.mo34283b()
            r1 = 0
            k.a.a.a.E.w[] r2 = r8.f3949a     // Catch:{ all -> 0x0040 }
            int r3 = r2.length     // Catch:{ all -> 0x0040 }
            r4 = 0
            r5 = 0
        L_0x000a:
            if (r4 >= r3) goto L_0x003a
            r6 = r2[r4]     // Catch:{ all -> 0x0037 }
            boolean r7 = r6 instanceof p122k.p123a.p124a.p125a.p126E.C2355B     // Catch:{ all -> 0x0037 }
            if (r7 == 0) goto L_0x0027
            r7 = r6
            k.a.a.a.E.B r7 = (p122k.p123a.p124a.p125a.p126E.C2355B) r7     // Catch:{ all -> 0x0037 }
            int r7 = r7.mo34041c()     // Catch:{ all -> 0x0037 }
            int r7 = r7 + r11
            r10.mo34282a(r7)     // Catch:{ all -> 0x0037 }
            k.a.a.a.E.B r6 = (p122k.p123a.p124a.p125a.p126E.C2355B) r6     // Catch:{ all -> 0x0037 }
            k.a.a.a.E.w r6 = r6.mo34040b()     // Catch:{ all -> 0x0037 }
            if (r7 == r0) goto L_0x0030
            r5 = 1
            goto L_0x0031
        L_0x0027:
            boolean r7 = r6.mo34037a()     // Catch:{ all -> 0x0037 }
            if (r7 == 0) goto L_0x0031
            r10.mo34282a(r0)     // Catch:{ all -> 0x0037 }
        L_0x0030:
            r5 = 0
        L_0x0031:
            r6.mo34036a(r9)     // Catch:{ all -> 0x0037 }
            int r4 = r4 + 1
            goto L_0x000a
        L_0x0037:
            r9 = move-exception
            r1 = r5
            goto L_0x0041
        L_0x003a:
            if (r5 == 0) goto L_0x003f
            r10.mo34282a(r0)
        L_0x003f:
            return
        L_0x0040:
            r9 = move-exception
        L_0x0041:
            if (r1 == 0) goto L_0x0046
            r10.mo34282a(r0)
        L_0x0046:
            goto L_0x0048
        L_0x0047:
            throw r9
        L_0x0048:
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: p122k.p123a.p124a.p125a.p126E.C2422x.mo34178a(k.a.a.a.o, k.a.a.a.f, int):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2422x)) {
            return false;
        }
        C2422x xVar = (C2422x) obj;
        return this.f3950b == xVar.f3950b && Arrays.equals(this.f3949a, xVar.f3949a);
    }

    public int hashCode() {
        return this.f3950b;
    }
}
