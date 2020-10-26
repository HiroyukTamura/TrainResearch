/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.mixpanel.android.d;

import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class k<T> {
    private Set<T> a = new HashSet<T>();

    public Set<T> a() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return Collections.unmodifiableSet(this.a);
        }
        throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }

    public void a(T t2) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.a.remove(t2);
            return;
        }
        throw new RuntimeException("Can't remove an activity when not on the UI thread");
    }

    public void b(T t2) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.a.add(t2);
            return;
        }
        throw new RuntimeException("Can't add an activity when not on the UI thread");
    }
}

