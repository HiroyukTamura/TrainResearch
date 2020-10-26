/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.view.View
 *  android.view.inputmethod.InputMethodManager
 */
package jp.co.jreast.jreastapp.commuter.favoriteroute;

import a.a.e;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.f.a.d;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.i;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.model.Route;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0006\u0010$\u001a\u00020!J\b\u0010%\u001a\u00020!H\u0002J\u0012\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020!H\u0014J\b\u0010*\u001a\u00020!H\u0002J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006,"}, d2={"Ljp/co/jreast/jreastapp/commuter/favoriteroute/FavoriteRouteRegistrationActivity;", "Ljp/co/jreast/jreastapp/commuter/base/CommuterActivity;", "Ldagger/android/support/HasSupportFragmentInjector;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityFavoriteRouteRegistrationBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/ActivityFavoriteRouteRegistrationBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/ActivityFavoriteRouteRegistrationBinding;)V", "<set-?>", "Ljp/co/jreast/jreastapp/commuter/favoriteroute/FavoriteRouteRegistrationViewModel;", "viewModel", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/favoriteroute/FavoriteRouteRegistrationViewModel;", "setViewModel", "(Ljp/co/jreast/jreastapp/commuter/favoriteroute/FavoriteRouteRegistrationViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "dismissFavoriteRouteRegistration", "hideKeyboard", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showKeyboard", "supportFragmentInjector", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class FavoriteRouteRegistrationActivity
extends jp.co.jreast.jreastapp.commuter.b.a
implements a.a.a.d {
    public e<d> k;
    public w.b l;
    public i m;
    private jp.co.jreast.jreastapp.commuter.favoriteroute.b n;
    private q o;

    public FavoriteRouteRegistrationActivity() {
        this.o = new q();
    }

    private final void n() {
        if (this.getCurrentFocus() != null) {
            Object object = this.getSystemService("input_method");
            if (object != null) {
                object = (InputMethodManager)object;
                View view = this.getCurrentFocus();
                j.a((Object)view, "currentFocus");
                object.hideSoftInputFromWindow(view.getWindowToken(), 2);
                return;
            }
            throw new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    private final void o() {
        Object object = this.getSystemService("input_method");
        if (object != null) {
            object = (InputMethodManager)object;
            View view = this.getCurrentFocus();
            if (view != null) {
                object.showSoftInput(view, 0);
            }
            return;
        }
        throw new t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext((Context)CalligraphyContextWrapper.wrap(context));
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
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
            object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
            if (object != null) {
                this.o = (q)object;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        if ((object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.v.a())) != null) {
            object = (Route)object;
            Object object2 = this.o;
            Object object3 = this;
            Object object4 = this.l;
            if (object4 == null) {
                j.b("viewModelFactory");
            }
            object2 = ((q)object2).a((androidx.f.a.e)object3, (w.b)object4).a(jp.co.jreast.jreastapp.commuter.favoriteroute.b.class);
            j.a(object2, "commuterViewModelProvide\u2026ionViewModel::class.java)");
            this.n = (jp.co.jreast.jreastapp.commuter.favoriteroute.b)object2;
            object3 = this.n;
            if (object3 == null) {
                j.b("viewModel");
            }
            ((jp.co.jreast.jreastapp.commuter.favoriteroute.b)object3).a((Route)object);
            object4 = ((jp.co.jreast.jreastapp.commuter.favoriteroute.b)object3).b();
            object2 = this;
            ((al)object4).a((androidx.lifecycle.j)object2, (androidx.lifecycle.q)}
    }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    