package com.dinuscxj.refresh;

/* renamed from: com.dinuscxj.refresh.b */
public class C0544b {
    /* renamed from: a */
    public float mo9365a(float f, float f2) {
        float min = Math.min(1.0f, Math.abs(f / f2));
        double max = (double) (Math.max(0.0f, Math.min(Math.abs(f) - f2, f2 * 2.0f) / f2) / 4.0f);
        double pow = Math.pow(max, 2.0d);
        Double.isNaN(max);
        return (float) ((int) ((f2 * min) + (((float) (max - pow)) * 2.0f * f2 * 2.0f)));
    }
}
