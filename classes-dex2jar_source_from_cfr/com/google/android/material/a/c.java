/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 */
package com.google.android.material.a;

import android.animation.TypeEvaluator;

public class c
implements TypeEvaluator<Integer> {
    private static final c a = new c();

    public static c a() {
        return a;
    }

    public Integer a(float f2, Integer n2, Integer n3) {
        int n4 = n2;
        float f3 = (float)(n4 >> 24 & 255) / 255.0f;
        float f4 = (float)(n4 >> 16 & 255) / 255.0f;
        float f5 = (float)(n4 >> 8 & 255) / 255.0f;
        float f6 = (float)(n4 & 255) / 255.0f;
        n4 = n3;
        float f7 = (float)(n4 >> 24 & 255) / 255.0f;
        float f8 = (float)(n4 >> 16 & 255) / 255.0f;
        float f9 = (float)(n4 >> 8 & 255) / 255.0f;
        float f10 = (float)(n4 & 255) / 255.0f;
        f4 = (float)Math.pow(f4, 2.2);
        f5 = (float)Math.pow(f5, 2.2);
        f6 = (float)Math.pow(f6, 2.2);
        f8 = (float)Math.pow(f8, 2.2);
        f9 = (float)Math.pow(f9, 2.2);
        f10 = (float)Math.pow(f10, 2.2);
        f4 = (float)Math.pow(f4 + (f8 - f4) * f2, 0.45454545454545453);
        f5 = (float)Math.pow(f5 + (f9 - f5) * f2, 0.45454545454545453);
        f10 = (float)Math.pow(f6 + f2 * (f10 - f6), 0.45454545454545453);
        n4 = Math.round((f3 + (f7 - f3) * f2) * 255.0f);
        return Math.round(f4 * 255.0f) << 16 | n4 << 24 | Math.round(f5 * 255.0f) << 8 | Math.round(f10 * 255.0f);
    }

    public /* synthetic */ Object evaluate(float f2, Object object, Object object2) {
        return this.a(f2, (Integer)object, (Integer)object2);
    }
}

