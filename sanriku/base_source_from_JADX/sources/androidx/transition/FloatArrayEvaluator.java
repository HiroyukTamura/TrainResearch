package androidx.transition;

import android.animation.TypeEvaluator;
import p009e.p010a.p011a.p012a.C0681a;

class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f2 = fArr[i];
            fArr3[i] = C0681a.m301a(fArr2[i], f2, f, f2);
        }
        return fArr3;
    }
}
