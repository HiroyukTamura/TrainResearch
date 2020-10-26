// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.utils;

import android.view.View;
import android.os.Build$VERSION;
import java.util.concurrent.atomic.AtomicInteger;

public class IdUtils
{
    private static final AtomicInteger nextGeneratedId;
    
    static {
        nextGeneratedId = new AtomicInteger(1);
    }
    
    private static int generateId() {
        int value;
        int newValue;
        do {
            value = IdUtils.nextGeneratedId.get();
            if ((newValue = value + 1) > 16777215) {
                newValue = 1;
            }
        } while (!IdUtils.nextGeneratedId.compareAndSet(value, newValue));
        return value;
    }
    
    public static int generateViewId() {
        if (Build$VERSION.SDK_INT < 17) {
            return generateId();
        }
        return View.generateViewId();
    }
}
