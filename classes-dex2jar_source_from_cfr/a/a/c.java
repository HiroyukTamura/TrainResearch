/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Fragment
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.ContentProvider
 *  com.google.errorprone.annotations.ForOverride
 */
package a.a;

import a.a.b;
import a.a.e;
import a.a.g;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import com.google.errorprone.annotations.ForOverride;

public abstract class c
extends Application
implements g {
    e<Activity> a;
    e<BroadcastReceiver> b;
    e<Fragment> c;
    e<Service> d;
    e<ContentProvider> e;
    private volatile boolean f = true;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e() {
        if (!this.f) {
            return;
        }
        synchronized (this) {
            if (this.f) {
                this.a().a(this);
                if (this.f) {
                    throw new IllegalStateException("The AndroidInjector returned from applicationInjector() did not inject the DaggerApplication");
                }
            }
            return;
        }
    }

    @ForOverride
    protected abstract b<? extends c> a();

    void b() {
        this.f = false;
    }

    public e<Activity> c() {
        return this.a;
    }

    public /* synthetic */ b d() {
        return this.c();
    }

    public void onCreate() {
        super.onCreate();
        this.e();
    }
}

