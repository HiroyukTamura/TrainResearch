// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import android.widget.TextView;
import android.graphics.Paint;

public class TextViewUtils
{
    public static float getAdjustTextSize(final int n, final String s, float n2, final float n3) {
        final Paint paint = new Paint();
        paint.setTextSize(n2);
        float n4 = paint.measureText(s);
        float n5;
        while (true) {
            n5 = n2;
            if (n >= n4) {
                break;
            }
            --n2;
            if (n3 > 0.0f && n3 >= n2) {
                n5 = n3;
                break;
            }
            paint.setTextSize(n2);
            n4 = paint.measureText(s);
        }
        return n5;
    }
    
    public static void resizeTextView(final TextView textView, final float n) {
        textView.post(TextViewUtils$$Lambda$1.lambdaFactory$(textView, n));
    }
}
