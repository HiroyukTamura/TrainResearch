package p122k.p123a.p124a.p125a;

import java.util.Locale;
import p122k.p123a.p124a.p125a.p126E.C2391c;
import p122k.p123a.p124a.p125a.p128G.C2439h;

/* renamed from: k.a.a.a.p */
public class C2467p extends C2473u {

    /* renamed from: f */
    private final int f4047f;

    public C2467p(C2466o oVar, C2457f fVar, int i, C2391c cVar) {
        super(oVar, fVar, (C2471s) null);
        this.f4047f = i;
    }

    public String toString() {
        String str;
        String str2;
        int i = this.f4047f;
        if (i < 0 || i >= ((C2457f) super.mo34347b()).size()) {
            str = "";
        } else {
            int i2 = this.f4047f;
            String a = ((C2457f) super.mo34347b()).mo34281a(C2439h.m4146a(i2, i2));
            StringBuilder sb = new StringBuilder();
            for (char c : a.toCharArray()) {
                if (c == 9) {
                    str2 = "\\t";
                } else if (c == 10) {
                    str2 = "\\n";
                } else if (c == 13) {
                    str2 = "\\r";
                } else {
                    sb.append(c);
                }
                sb.append(str2);
            }
            str = sb.toString();
        }
        return String.format(Locale.getDefault(), "%s('%s')", new Object[]{C2467p.class.getSimpleName(), str});
    }
}
