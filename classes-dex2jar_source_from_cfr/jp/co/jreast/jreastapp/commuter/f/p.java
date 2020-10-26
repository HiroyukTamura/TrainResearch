/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 */
package jp.co.jreast.jreastapp.commuter.f;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.f.a.d;
import androidx.f.a.e;
import androidx.f.a.i;
import jp.co.jreast.jreastapp.commuter.f.s;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0005\u00a8\u0006\u0006"}, d2={"handleActivity", "", "activity", "Landroid/app/Activity;", "applyAutoInjector", "Landroid/app/Application;", "app_productRelease"}, k=2, mv={1, 1, 11})
public final class p {
    public static final void a(Application application) {
        j.b((Object)application, "$receiver");
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks(){

            public void onActivityCreated(Activity activity, Bundle bundle) {
                j.b((Object)activity, "activity");
                p.b(activity);
            }

            public void onActivityDestroyed(Activity activity) {
                j.b((Object)activity, "activity");
            }

            public void onActivityPaused(Activity activity) {
                j.b((Object)activity, "activity");
            }

            public void onActivityResumed(Activity activity) {
                j.b((Object)activity, "activity");
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                j.b((Object)activity, "activity");
            }

            public void onActivityStarted(Activity activity) {
                j.b((Object)activity, "activity");
            }

            public void onActivityStopped(Activity activity) {
                j.b((Object)activity, "activity");
            }
        });
    }

    private static final void b(Activity activity) {
        if (activity instanceof s || activity instanceof a.a.a.d) {
            a.a.a.a(activity);
        }
        if (activity instanceof e) {
            ((e)activity).k().a(new i.b(){

                @Override
                public void b(i i2, d d2, Bundle bundle) {
                    j.b(i2, "fm");
                    j.b(d2, "f");
                    if (d2 instanceof s) {
                        a.a.a.a.a(d2);
                    }
                }
            }, true);
        }
    }

}

