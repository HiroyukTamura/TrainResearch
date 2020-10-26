/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 */
package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.c;
import androidx.lifecycle.t;
import java.util.concurrent.atomic.AtomicBoolean;

class h {
    private static AtomicBoolean a = new AtomicBoolean(false);

    static void a(Context context) {
        if (a.getAndSet(true)) {
            return;
        }
        ((Application)context.getApplicationContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a());
    }

    static class a
    extends c {
        a() {
        }

        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            t.a(activity);
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override
        public void onActivityStopped(Activity activity) {
        }
    }

}

