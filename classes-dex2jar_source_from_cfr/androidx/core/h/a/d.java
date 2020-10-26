/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityRecord
 */
package androidx.core.h.a;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

public class d {
    private final AccessibilityRecord a;

    public static void a(AccessibilityRecord accessibilityRecord, int n2) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(n2);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int n2) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(n2);
        }
    }

    @Deprecated
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (d)object;
        return !(this.a == null ? ((d)object).a != null : !this.a.equals((Object)((d)object).a));
    }

    @Deprecated
    public int hashCode() {
        if (this.a == null) {
            return 0;
        }
        return this.a.hashCode();
    }
}

