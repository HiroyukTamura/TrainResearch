package p009e.p028d.p030b.p054b.p055c;

import android.animation.TypeEvaluator;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: e.d.b.b.c.b */
public class C1535b implements TypeEvaluator<Integer> {

    /* renamed from: a */
    private static final C1535b f1773a = new C1535b();

    /* renamed from: a */
    public static C1535b m2151a() {
        return f1773a;
    }

    public Object evaluate(float f, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f2 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & 255)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & 255)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & 255)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & 255)) / 255.0f), 2.2d);
        float a = C0681a.m301a(((float) ((intValue2 >> 24) & 255)) / 255.0f, f2, f, f2);
        float a2 = C0681a.m301a(pow4, pow, f, pow);
        float a3 = C0681a.m301a((float) Math.pow((double) (((float) ((intValue2 >> 8) & 255)) / 255.0f), 2.2d), pow2, f, pow2);
        float a4 = C0681a.m301a((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d), pow3, f, pow3);
        int round = Math.round(((float) Math.pow((double) a2, 0.45454545454545453d)) * 255.0f) << 16;
        return Integer.valueOf(Math.round(((float) Math.pow((double) a4, 0.45454545454545453d)) * 255.0f) | round | (Math.round(a * 255.0f) << 24) | (Math.round(((float) Math.pow((double) a3, 0.45454545454545453d)) * 255.0f) << 8));
    }
}
