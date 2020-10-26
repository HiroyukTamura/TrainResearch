/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.VelocityTracker
 */
package androidx.core.h;

import android.view.VelocityTracker;

@Deprecated
public final class s {
    @Deprecated
    public static float a(VelocityTracker velocityTracker, int n2) {
        return velocityTracker.getXVelocity(n2);
    }

    @Deprecated
    public static float b(VelocityTracker velocityTracker, int n2) {
        return velocityTracker.getYVelocity(n2);
    }
}

