/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.app.FragmentTransaction
 *  android.os.Bundle
 */
package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.j;
import androidx.lifecycle.k;
import androidx.lifecycle.l;

public class t
extends Fragment {
    private a a;

    public static void a(Activity activity) {
        if ((activity = activity.getFragmentManager()).findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            activity.beginTransaction().add((Fragment)new t(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            activity.executePendingTransactions();
        }
    }

    private void a(g.a a2) {
        Object object = this.getActivity();
        if (object instanceof l) {
            ((l)object).a().a(a2);
            return;
        }
        if (object instanceof j && (object = ((j)object).g()) instanceof k) {
            ((k)object).a(a2);
        }
    }

    static t b(Activity activity) {
        return (t)activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    private void b(a a2) {
        if (a2 != null) {
            a2.a();
        }
    }

    private void c(a a2) {
        if (a2 != null) {
            a2.b();
        }
    }

    private void d(a a2) {
        if (a2 != null) {
            a2.c();
        }
    }

    void a(a a2) {
        this.a = a2;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.b(this.a);
        this.a(g.a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        this.a(g.a.ON_DESTROY);
        this.a = null;
    }

    public void onPause() {
        super.onPause();
        this.a(g.a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        this.d(this.a);
        this.a(g.a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        this.c(this.a);
        this.a(g.a.ON_START);
    }

    public void onStop() {
        super.onStop();
        this.a(g.a.ON_STOP);
    }

    static interface a {
        public void a();

        public void b();

        public void c();
    }

}

