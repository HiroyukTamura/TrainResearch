/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 */
package androidx.core.h;

import android.view.MotionEvent;

public final class i {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static int a(MotionEvent motionEvent, int n2) {
        return motionEvent.findPointerIndex(n2);
    }

    @Deprecated
    public static int b(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    public static int b(MotionEvent motionEvent, int n2) {
        return motionEvent.getPointerId(n2);
    }

    @Deprecated
    public static float c(MotionEvent motionEvent, int n2) {
        return motionEvent.getX(n2);
    }

    @Deprecated
    public static float d(MotionEvent motionEvent, int n2) {
        return motionEvent.getY(n2);
    }

    public static boolean e(MotionEvent motionEvent, int n2) {
        return (motionEvent.getSource() & n2) == n2;
    }
}

