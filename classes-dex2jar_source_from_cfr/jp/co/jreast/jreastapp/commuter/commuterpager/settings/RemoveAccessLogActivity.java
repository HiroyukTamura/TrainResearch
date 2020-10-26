/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.os.Bundle
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.f.a.i;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.q;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.e;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0002J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u001dH\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006&"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/settings/RemoveAccessLogActivity;", "Ljp/co/jreast/jreastapp/commuter/base/CommuterActivity;", "Ldagger/android/support/HasSupportFragmentInjector;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityRemoveAccessLogBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/ActivityRemoveAccessLogBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/ActivityRemoveAccessLogBinding;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/commuterpager/settings/RemoveAccessLogViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "closeModal", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeAccessLog", "supportFragmentInjector", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class RemoveAccessLogActivity
extends jp.co.jreast.jreastapp.commuter.b.a
implements a.a.a.d,
androidx.lifecycle.j {
    public a.a.e<androidx.f.a.d> k;
    public w.b l;
    public q m;
    private jp.co.jreast.jreastapp.commuter.f.q n;
    private e o;

    public RemoveAccessLogActivity() {
        this.n = new jp.co.jreast.jreastapp.commuter.f.q();
    }

    private final void m() {
        this.finish();
    }

    private final void n() {
        e e2 = this.o;
        if (e2 == null) {
            j.b("viewModel");
        }
        e2.k();
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext((Context)CalligraphyContextWrapper.wrap(context));
    }

    public /* synthetic */ a.a.b c_() {
        return this.l();
    }

    public a.a.e<androidx.f.a.d> l() {
        a.a.e<androidx.f.a.d> e2 = this.k;
        if (e2 == null) {
            j.b("androidInjector");
        }
        return e2;
    }

    @Override
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = f.a(this, 2131427364);
        j.a(object, "DataBindingUtil.setConte\u2026tivity_remove_access_log)");
        this.m = (q)object;
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
            object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
            if (object != null) {
                this.n = (jp.co.jreast.jreastapp.commuter.f.q)object;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        object = this.n;
        Object object2 = this;
        w.b b2 = this.l;
        if (b2 == null) {
            j.b("viewModelFactory");
        }
        object = ((jp.co.jreast.jreastapp.commuter.f.q)object).a((androidx.f.a.e)object2, b2).a(e.class);
        j.a(object, "commuterViewModelProvide\u2026LogViewModel::class.java)");
        this.o = (e)object;
        object = this.m;
        if (object == null) {
            j.b("dataBinding");
        }
        if ((object2 = this.o) == null) {
            j.b("viewModel");
        }
        ((q)object).a((e)object2);
        object2 = this.m;
        if (object2 == null) {
            j.b("dataBinding");
        }
        object = this;
        ((ViewDataBinding)object2).a((androidx.lifecycle.j)object);
        object2 = this.o;
        if (object2 == null) {
            j.b("viewModel");
        }
        ((e)object2).b().a((androidx.lifecycle.j)object, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    