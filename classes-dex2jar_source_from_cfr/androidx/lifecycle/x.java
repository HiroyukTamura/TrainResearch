/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 */
package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.f.a.d;
import androidx.f.a.e;
import androidx.lifecycle.j;
import androidx.lifecycle.w;
import androidx.lifecycle.y;

public class x {
    private static Application a(Activity activity) {
        if ((activity = activity.getApplication()) != null) {
            return activity;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    public static w a(d d2) {
        return x.a(d2, null);
    }

    public static w a(d d2, w.b b2) {
        Application application = x.a(x.b(d2));
        w.b b3 = b2;
        if (b2 == null) {
            b3 = w.a.a(application);
        }
        return new w(d2.i(), b3);
    }

    public static w a(e e2, w.b b2) {
        Application application = x.a(e2);
        w.b b3 = b2;
        if (b2 == null) {
            b3 = w.a.a(application);
        }
        return new w(e2.i(), b3);
    }

    private static Activity b(d j2) {
        if ((j2 = j2.o()) != null) {
            return j2;
        }
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }
}

