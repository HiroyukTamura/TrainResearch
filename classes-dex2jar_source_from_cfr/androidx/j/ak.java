/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.WindowId
 */
package androidx.j;

import android.view.View;
import android.view.WindowId;
import androidx.j.al;

class ak
implements al {
    private final WindowId a;

    ak(View view) {
        this.a = view.getWindowId();
    }

    public boolean equals(Object object) {
        return object instanceof ak && ((ak)object).a.equals((Object)this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

