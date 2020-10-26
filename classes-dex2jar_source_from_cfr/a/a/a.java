/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 */
package a.a;

import a.a.b;
import a.a.g;
import a.b.f;
import android.app.Activity;
import android.app.Application;

public final class a {
    public static void a(Activity activity) {
        f.a(activity, "activity");
        Application application = activity.getApplication();
        if (application instanceof g) {
            b<Activity> b2 = ((g)application).d();
            f.a(b2, "%s.activityInjector() returned null", application.getClass());
            b2.a(activity);
            return;
        }
        throw new RuntimeException(String.format("%s does not implement %s", application.getClass().getCanonicalName(), g.class.getCanonicalName()));
    }
}

