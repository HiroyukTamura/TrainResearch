package p009e.p015c.p016a.p017a.p018a.p024s;

import java.util.ArrayList;
import java.util.List;

/* renamed from: e.c.a.a.a.s.h */
public class C0741h implements C0738f {

    /* renamed from: a */
    public String f438a;

    /* renamed from: b */
    public String f439b;

    /* renamed from: c */
    public List<C0741h> f440c = new ArrayList();

    public C0741h() {
    }

    public C0741h(String str, String str2, String str3, String str4) {
        this.f438a = str3;
        this.f439b = str4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0047, code lost:
        if (r2.equals("table") == false) goto L_0x0054;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    @androidx.annotation.NonNull
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, p009e.p015c.p016a.p017a.p018a.p024s.C0741h> m430a(android.database.Cursor r11) {
        /*
            java.util.TreeMap r0 = new java.util.TreeMap
            java.util.Comparator r1 = java.lang.String.CASE_INSENSITIVE_ORDER
            r0.<init>(r1)
            boolean r1 = r11.moveToFirst()
            if (r1 == 0) goto L_0x0087
        L_0x000d:
            r1 = 0
            java.lang.String r2 = r11.getString(r1)
            r3 = 1
            java.lang.String r4 = r11.getString(r3)
            r5 = 2
            java.lang.String r5 = r11.getString(r5)
            r6 = 3
            java.lang.String r6 = r11.getString(r6)
            java.lang.Object r7 = r0.get(r5)
            e.c.a.a.a.s.h r7 = (p009e.p015c.p016a.p017a.p018a.p024s.C0741h) r7
            if (r7 != 0) goto L_0x0031
            e.c.a.a.a.s.h r7 = new e.c.a.a.a.s.h
            r7.<init>()
            r0.put(r5, r7)
        L_0x0031:
            r8 = -1
            int r9 = r2.hashCode()
            r10 = 100346066(0x5fb28d2, float:2.3618922E-35)
            if (r9 == r10) goto L_0x004a
            r10 = 110115790(0x6903bce, float:5.4254655E-35)
            if (r9 == r10) goto L_0x0041
            goto L_0x0054
        L_0x0041:
            java.lang.String r9 = "table"
            boolean r9 = r2.equals(r9)
            if (r9 == 0) goto L_0x0054
            goto L_0x0055
        L_0x004a:
            java.lang.String r1 = "index"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0054
            r1 = 1
            goto L_0x0055
        L_0x0054:
            r1 = -1
        L_0x0055:
            if (r1 == 0) goto L_0x007d
            if (r1 == r3) goto L_0x0070
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "unsupported type:"
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SQLiteMaster"
            android.util.Log.w(r2, r1)
            goto L_0x0081
        L_0x0070:
            if (r6 == 0) goto L_0x0081
            java.util.List<e.c.a.a.a.s.h> r1 = r7.f440c
            e.c.a.a.a.s.h r3 = new e.c.a.a.a.s.h
            r3.<init>(r2, r4, r5, r6)
            r1.add(r3)
            goto L_0x0081
        L_0x007d:
            r7.f438a = r5
            r7.f439b = r6
        L_0x0081:
            boolean r1 = r11.moveToNext()
            if (r1 != 0) goto L_0x000d
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p009e.p015c.p016a.p017a.p018a.p024s.C0741h.m430a(android.database.Cursor):java.util.Map");
    }

    public List<String> getCreateIndexStatements() {
        ArrayList arrayList = new ArrayList();
        for (C0741h hVar : this.f440c) {
            arrayList.add(hVar.f439b);
        }
        return arrayList;
    }

    public String getCreateTableStatement() {
        return this.f439b;
    }

    public String getTableName() {
        return this.f438a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f439b);
        sb.append("; ");
        for (C0741h append : this.f440c) {
            sb.append(append);
            sb.append("; ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}
