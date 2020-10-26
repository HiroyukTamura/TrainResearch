/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.ContentProvider
 */
package a.a;

import a.a.c;
import a.a.e;
import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;

public final class d {
    public static void a(c c2) {
        c2.b();
    }

    public static void a(c c2, e<Activity> e2) {
        c2.a = e2;
    }

    public static void b(c c2, e<BroadcastReceiver> e2) {
        c2.b = e2;
    }

    public static void c(c c2, e<Fragment> e2) {
        c2.c = e2;
    }

    public static void d(c c2, e<Service> e2) {
        c2.d = e2;
    }

    public static void e(c c2, e<ContentProvider> e2) {
        c2.e = e2;
    }
}

