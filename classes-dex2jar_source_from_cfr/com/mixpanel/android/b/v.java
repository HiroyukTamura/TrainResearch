/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 */
package com.mixpanel.android.b;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class v {
    private final Executor a = Executors.newSingleThreadExecutor();

    public Future<SharedPreferences> a(Context object, String string2, b b2) {
        object = new FutureTask<SharedPreferences>(new a((Context)object, string2, b2));
        this.a.execute((Runnable)object);
        return object;
    }

    private static class a
    implements Callable<SharedPreferences> {
        private final Context a;
        private final String b;
        private final b c;

        public a(Context context, String string2, b b2) {
            this.a = context;
            this.b = string2;
            this.c = b2;
        }

        public SharedPreferences a() {
            SharedPreferences sharedPreferences = this.a.getSharedPreferences(this.b, 0);
            if (this.c != null) {
                this.c.a(sharedPreferences);
            }
            return sharedPreferences;
        }

        @Override
        public /* synthetic */ Object call() {
            return this.a();
        }
    }

    static interface b {
        public void a(SharedPreferences var1);
    }

}

