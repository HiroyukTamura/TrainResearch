package p009e.p028d.p030b.p054b.p055c;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* renamed from: e.d.b.b.c.f */
public class C1539f implements TypeEvaluator<Matrix> {

    /* renamed from: a */
    private final float[] f1778a = new float[9];

    /* renamed from: b */
    private final float[] f1779b = new float[9];

    /* renamed from: c */
    private final Matrix f1780c = new Matrix();

    public Object evaluate(float f, Object obj, Object obj2) {
        ((Matrix) obj).getValues(this.f1778a);
        ((Matrix) obj2).getValues(this.f1779b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.f1779b;
            float f2 = fArr[i];
            float[] fArr2 = this.f1778a;
            fArr[i] = ((f2 - fArr2[i]) * f) + fArr2[i];
        }
        this.f1780c.setValues(this.f1779b);
        return this.f1780c;
    }
}
