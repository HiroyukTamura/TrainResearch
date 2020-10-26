// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.drawer.type;

import android.support.annotation.NonNull;
import android.graphics.Paint;
import com.rd.draw.data.Indicator;

class BaseDrawer
{
    Indicator indicator;
    Paint paint;
    
    BaseDrawer(@NonNull final Paint paint, @NonNull final Indicator indicator) {
        this.paint = paint;
        this.indicator = indicator;
    }
}
