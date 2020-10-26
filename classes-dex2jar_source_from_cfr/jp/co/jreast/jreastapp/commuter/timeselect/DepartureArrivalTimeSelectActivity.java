/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.DatePicker
 *  android.widget.TimePicker
 */
package jp.co.jreast.jreastapp.commuter.timeselect;

import a.a.e;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.f.a.d;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.Serializable;
import java.util.Date;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.w;
import jp.co.jreast.jreastapp.commuter.f.q;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0006\u0010 \u001a\u00020\u001dJ\b\u0010!\u001a\u00020\u001dH\u0002J\u0012\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0010\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010'J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006*"}, d2={"Ljp/co/jreast/jreastapp/commuter/timeselect/DepartureArrivalTimeSelectActivity;", "Ljp/co/jreast/jreastapp/commuter/base/CommuterActivity;", "Ldagger/android/support/HasSupportFragmentInjector;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityTimeSelectBinding;", "getDataBinding$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/databinding/ActivityTimeSelectBinding;", "setDataBinding$app_productRelease", "(Ljp/co/jreast/jreastapp/commuter/databinding/ActivityTimeSelectBinding;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/timeselect/DepartureArrivalTimeSelectViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "dismiss", "hideYear", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "returnSelectedDepartureArrivalTime", "intent", "Landroid/content/Intent;", "supportFragmentInjector", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class DepartureArrivalTimeSelectActivity
extends jp.co.jreast.jreastapp.commuter.b.a
implements a.a.a.d,
androidx.lifecycle.j {
    public static final a n;
    public e<d> k;
    public w.b l;
    public w m;
    private jp.co.jreast.jreastapp.commuter.timeselect.b o;
    private q p;

    static {
        n = new a(null);
    }

    public DepartureArrivalTimeSelectActivity() {
        this.p = new q();
    }

    private final void n() {
        int n2 = Resources.getSystem().getIdentifier("year", "id", "android");
        if (n2 != 0) {
            w w2 = this.m;
            if (w2 == null) {
                j.b("dataBinding");
            }
            if ((w2 = w2.e.findViewById(n2)) != null) {
                w2.setVisibility(8);
            }
        }
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext((Context)CalligraphyContextWrapper.wrap(context));
    }

    public final void c(Intent intent) {
        this.setResult(-1, intent);
        this.finish();
    }

    public /* synthetic */ a.a.b c_() {
        return this.l();
    }

    public e<d> l() {
        e<d> e2 = this.k;
        if (e2 == null) {
            j.b("androidInjector");
        }
        return e2;
    }

    public final void m() {
        this.finish();
    }

    @Override
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = f.a(this, 2131427367);
        j.a(object, "DataBindingUtil.setConte\u2026out.activity_time_select)");
        this.m = (w)object;
        Object object2 = this.m;
        if (object2 == null) {
            j.b("dataBinding");
        }
        object = this;
        ((ViewDataBinding)object2).a((androidx.lifecycle.j)object);
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
            object2 = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
            if (object2 != null) {
                this.p = (q)object2;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        object2 = this.p;
        androidx.f.a.e e2 = this;
        w.b b2 = this.l;
        if (b2 == null) {
            j.b("viewModelFactory");
        }
        object2 = ((q)object2).a(e2, b2).a(jp.co.jreast.jreastapp.commuter.timeselect.b.class);
        j.a(object2, "commuterViewModelProvide\u2026ectViewModel::class.java)");
        this.o = (jp.co.jreast.jreastapp.commuter.timeselect.b)object2;
        object2 = this.o;
        if (object2 == null) {
            j.b("viewModel");
        }
        ((jp.co.jreast.jreastapp.commuter.timeselect.b)object2).l().a((androidx.lifecycle.j)object, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    