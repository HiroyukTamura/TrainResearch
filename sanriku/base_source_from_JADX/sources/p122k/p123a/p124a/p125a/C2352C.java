package p122k.p123a.p124a.p125a;

/* renamed from: k.a.a.a.C */
public class C2352C implements C2351B {

    /* renamed from: d */
    private static final String[] f3821d;

    /* renamed from: e */
    public static final C2352C f3822e;

    /* renamed from: a */
    private final String[] f3823a;

    /* renamed from: b */
    private final String[] f3824b;

    /* renamed from: c */
    private final String[] f3825c;

    static {
        String[] strArr = new String[0];
        f3821d = strArr;
        f3822e = new C2352C(strArr, strArr, strArr);
    }

    public C2352C(String[] strArr, String[] strArr2, String[] strArr3) {
        this.f3823a = strArr == null ? f3821d : strArr;
        this.f3824b = strArr2 == null ? f3821d : strArr2;
        strArr3 = strArr3 == null ? f3821d : strArr3;
        this.f3825c = strArr3;
        Math.max(strArr3.length, Math.max(this.f3823a.length, this.f3824b.length));
    }

    /* renamed from: a */
    public String mo34032a(int i) {
        String str;
        if (i >= 0) {
            String[] strArr = this.f3825c;
            if (i < strArr.length && (str = strArr[i]) != null) {
                return str;
            }
        }
        String b = mo34033b(i);
        if (b != null) {
            return b;
        }
        String c = mo34034c(i);
        return c != null ? c : Integer.toString(i);
    }

    /* renamed from: b */
    public String mo34033b(int i) {
        if (i < 0) {
            return null;
        }
        String[] strArr = this.f3823a;
        if (i < strArr.length) {
            return strArr[i];
        }
        return null;
    }

    /* renamed from: c */
    public String mo34034c(int i) {
        if (i >= 0) {
            String[] strArr = this.f3824b;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        if (i == -1) {
            return "EOF";
        }
        return null;
    }
}
