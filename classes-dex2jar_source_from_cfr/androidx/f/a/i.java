/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package androidx.f.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.f.a.d;
import androidx.f.a.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class i {
    public abstract d.d a(d var1);

    public abstract d a(Bundle var1, String var2);

    public abstract d a(String var1);

    public abstract a a(int var1);

    public abstract p a();

    public abstract void a(int var1, int var2);

    public abstract void a(Bundle var1, String var2, d var3);

    public abstract void a(b var1, boolean var2);

    public abstract void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

    public abstract void b();

    public abstract boolean b(int var1, int var2);

    public abstract boolean c();

    public abstract int d();

    public abstract List<d> e();

    public abstract boolean f();

    public static interface a {
        public int a();
    }

    public static abstract class b {
        public void a(i i2, d d2) {
        }

        public void a(i i2, d d2, Context context) {
        }

        public void a(i i2, d d2, Bundle bundle) {
        }

        public void a(i i2, d d2, View view, Bundle bundle) {
        }

        public void b(i i2, d d2) {
        }

        public void b(i i2, d d2, Context context) {
        }

        public void b(i i2, d d2, Bundle bundle) {
        }

        public void c(i i2, d d2) {
        }

        public void c(i i2, d d2, Bundle bundle) {
        }

        public void d(i i2, d d2) {
        }

        public void d(i i2, d d2, Bundle bundle) {
        }

        public void e(i i2, d d2) {
        }

        public void f(i i2, d d2) {
        }

        public void g(i i2, d d2) {
        }
    }

    public static interface c {
        public void a();
    }

}

