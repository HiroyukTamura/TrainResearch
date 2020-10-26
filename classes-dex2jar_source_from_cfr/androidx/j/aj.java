/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 */
package androidx.j;

import android.os.IBinder;
import androidx.j.al;

class aj
implements al {
    private final IBinder a;

    aj(IBinder iBinder) {
        this.a = iBinder;
    }

    public boolean equals(Object object) {
        return object instanceof aj && ((aj)object).a.equals((Object)this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

