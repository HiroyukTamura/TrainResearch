/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package jp.co.jreast.jreastapp.commuter.selectsetting;

import a.a.e;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.s;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.model.SettingTypes;
import jp.co.jreast.jreastapp.commuter.selectsetting.d;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0006\u0010\u001c\u001a\u00020\u0019J\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0006\u0010 \u001a\u00020\u0019J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\""}, d2={"Ljp/co/jreast/jreastapp/commuter/selectsetting/SelectSettingActivity;", "Ljp/co/jreast/jreastapp/commuter/base/CommuterActivity;", "Landroidx/lifecycle/LifecycleOwner;", "Ldagger/android/support/HasSupportFragmentInjector;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivitySelectSettingBinding;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/selectsetting/SelectSettingViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "dismissSelectSetting", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "refreshScreen", "supportFragmentInjector", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class SelectSettingActivity
extends jp.co.jreast.jreastapp.commuter.b.a
implements a.a.a.d,
androidx.lifecycle.j {
    public e<androidx.f.a.d> k;
    public w.b l;
    private d m;
    private q n;
    private s o;

    public SelectSettingActivity() {
        this.n = new q();
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext((Context)CalligraphyContextWrapper.wrap(context));
    }

    public /* synthetic */ a.a.b c_() {
        return this.l();
    }

    public e<androidx.f.a.d> l() {
        e<androidx.f.a.d> e2 = this.k;
        if (e2 == null) {
            j.b("androidInjector");
        }
        return e2;
    }

    public final void m() {
        Object object = this.o;
        if (object == null) {
            j.b("dataBinding");
        }
        object = ((s)object).d;
        j.a(object, "dataBinding.settingsList");
        object = ((RecyclerView)object).getAdapter();
        if (object != null) {
            ((RecyclerView.a)object).c();
        }
    }

    public final void n() {
        this.setResult(-1);
        this.finish();
    }

    @Override
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = f.a(this, 2131427365);
        j.a(object, "DataBindingUtil.setConte\u2026.activity_select_setting)");
        this.o = (s)object;
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
            object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
            if (object != null) {
                this.n = (q)object;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        object = this.n;
        Object object2 = this;
        Object object3 = this.l;
        if (object3 == null) {
            j.b("viewModelFactory");
        }
        object = ((q)object).a((androidx.f.a.e)object2, (w.b)object3).a(d.class);
        j.a(object, "commuterViewModelProvide\u2026ingViewModel::class.java)");
        this.m = (d)object;
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.z.a()) != null) {
            object = this.m;
            if (object == null) {
                j.b("viewModel");
            }
            if ((object2 = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.z.a())) != null) {
                ((d)object).a((SettingTypes)((Object)object2));
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.model.SettingTypes");
            }
        }
        if ((object2 = this.m) == null) {
            j.b("viewModel");
        }
        ((d)object2).f();
        object3 = ((d)object2).c();
        object = this;
        ((al)object3).a((androidx.lifecycle.j)object, (androidx.lifecycle.q)}
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    