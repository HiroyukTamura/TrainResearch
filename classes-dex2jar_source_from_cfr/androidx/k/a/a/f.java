/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 */
package androidx.k.a.a;

import android.animation.TypeEvaluator;

public class f
implements TypeEvaluator {
    private static final f a = new f();

    public static f a() {
        return a;
    }

    public Object evaluate(float f2, Object object, Object object2) {
        int n2 = (Integer)object;
        float f3 = (float)(n2 >> 24 & 255) / 255.0f;
        float f4 = (float)(n2 >> 16 & 255) / 255.0f;
        float f5 = (float)(n2 >> 8 & 255) / 255.0f;
        float f6 = (float)(n2 & 255) / 255.0f;
        n2 = (Integer)object2;
        float f7 = (float)(n2 >> 24 & 255) / 255.0f;
        float f8 = (float)(n2 >> 16 & 255) / 255.0f;
        float f9 = (float)(n2 >> 8 & 255) / 255.0f;
        float f10 = (float)(n2 & 255) / 255.0f;
        f4 = (float)Math.pow(f4, 2.2);
        f5 = (float)Math.pow(f5, 2.2);
        f6 = (float)Math.pow(f6, 2.2);
        f8 = (float)Math.pow(f8, 2.2);
        f9 = (float)Math.pow(f9, 2.2);
        f10 = (float)Math.pow(f10, 2.2);
        f4 = (float)Math.pow(f4 + (f8 - f4) * f2, 0.45454545454545453);
        f5 = (float)Math.pow(f5 + (f9 - f5) * f2, 0.45454545454545453);
        f10 = (float)Math.pow(f6 + f2 * (f10 - f6), 0.45454545454545453);
        n2 = Math.round((f3 + (f7 - f3) * f2) * 255.0f);
        return Math.round(f4 * 255.0f) << 16 | n2 << 24 | Math.round(f5 * 255.0f) << 8 | Math.round(f10 * 255.0f);
    }
}

