/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.view.MenuInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.app.d;
import androidx.appcompat.app.f;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.at;

public abstract class e {
    private static int a = -1;

    e() {
    }

    public static e a(Activity activity, d d2) {
        return new f((Context)activity, activity.getWindow(), d2);
    }

    public static e a(Dialog dialog, d d2) {
        return new f(dialog.getContext(), dialog.getWindow(), d2);
    }

    public static void a(boolean bl2) {
        at.a(bl2);
    }

    public static int j() {
        return a;
    }

    public abstract <T extends View> T a(int var1);

    public abstract a a();

    public abstract void a(Configuration var1);

    public abstract void a(Bundle var1);

    public abstract void a(View var1);

    public abstract void a(View var1, ViewGroup.LayoutParams var2);

    public abstract void a(Toolbar var1);

    public abstract void a(CharSequence var1);

    public abstract MenuInflater b();

    public abstract void b(int var1);

    public abstract void b(Bundle var1);

    public abstract void b(View var1, ViewGroup.LayoutParams var2);

    public abstract void c();

    public abstract void c(Bundle var1);

    public abstract boolean c(int var1);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract boolean i();
}

