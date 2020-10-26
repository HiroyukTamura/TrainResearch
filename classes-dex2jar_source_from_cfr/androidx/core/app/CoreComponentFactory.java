/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AppComponentFactory
 *  android.app.Application
 *  android.app.Service
 *  android.content.BroadcastReceiver
 *  android.content.ContentProvider
 *  android.content.Intent
 */
package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

public class CoreComponentFactory
extends AppComponentFactory {
    static <T> T a(T t2) {
        Object object;
        if (t2 instanceof a && (object = ((a)t2).a()) != null) {
            return (T)object;
        }
        return t2;
    }

    public Activity instantiateActivity(ClassLoader classLoader, String string2, Intent intent) {
        return CoreComponentFactory.a(super.instantiateActivity(classLoader, string2, intent));
    }

    public Application instantiateApplication(ClassLoader classLoader, String string2) {
        return CoreComponentFactory.a(super.instantiateApplication(classLoader, string2));
    }

    public ContentProvider instantiateProvider(ClassLoader classLoader, String string2) {
        return CoreComponentFactory.a(super.instantiateProvider(classLoader, string2));
    }

    public BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String string2, Intent intent) {
        return CoreComponentFactory.a(super.instantiateReceiver(classLoader, string2, intent));
    }

    public Service instantiateService(ClassLoader classLoader, String string2, Intent intent) {
        return CoreComponentFactory.a(super.instantiateService(classLoader, string2, intent));
    }

    public static interface a {
        public Object a();
    }

}

