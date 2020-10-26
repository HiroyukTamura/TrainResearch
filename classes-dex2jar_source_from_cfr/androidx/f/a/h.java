/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.LayoutInflater
 *  android.view.View
 */
package androidx.f.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.f.a.d;
import androidx.f.a.e;
import androidx.f.a.f;
import androidx.f.a.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class h<E>
extends f {
    private final Activity a;
    final j b = new j();
    private final Context c;
    private final Handler d;
    private final int e;

    h(Activity activity, Context context, Handler handler, int n2) {
        this.a = activity;
        this.c = androidx.core.g.e.a(context, "context == null");
        this.d = androidx.core.g.e.a(handler, "handler == null");
        this.e = n2;
    }

    h(e e2) {
        this(e2, (Context)e2, e2.a, 0);
    }

    @Override
    public View a(int n2) {
        return null;
    }

    public void a(d d2, Intent intent, int n2, Bundle bundle) {
        if (n2 == -1) {
            this.c.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void a(d d2, String[] arrstring, int n2) {
    }

    public void a(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
    }

    @Override
    public boolean a() {
        return true;
    }

    public boolean a(d d2) {
        return true;
    }

    public boolean a(String string2) {
        return false;
    }

    public LayoutInflater b() {
        return LayoutInflater.from((Context)this.c);
    }

    void b(d d2) {
    }

    public void c() {
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.e;
    }

    Activity f() {
        return this.a;
    }

    Context g() {
        return this.c;
    }

    Handler h() {
        return this.d;
    }

    j i() {
        return this.b;
    }
}

