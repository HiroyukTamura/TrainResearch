/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 */
package jp.co.jreast.jreastapp.commuter.servicestatus;

import a.a.e;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.f;
import androidx.f.a.d;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.u;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.servicestatus.b;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0006\u0010%\u001a\u00020\"J\u0012\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006*"}, d2={"Ljp/co/jreast/jreastapp/commuter/servicestatus/ServiceStatusDetailActivity;", "Ljp/co/jreast/jreastapp/commuter/base/CommuterActivity;", "Ldagger/android/support/HasSupportFragmentInjector;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityServiceStatusDetailBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/ActivityServiceStatusDetailBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/ActivityServiceStatusDetailBinding;)V", "<set-?>", "Ljp/co/jreast/jreastapp/commuter/servicestatus/ServiceStatusDetailViewModel;", "viewModel", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/servicestatus/ServiceStatusDetailViewModel;", "setViewModel", "(Ljp/co/jreast/jreastapp/commuter/servicestatus/ServiceStatusDetailViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "dismissServiceStatusDetailScreen", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "supportFragmentInjector", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class ServiceStatusDetailActivity
extends jp.co.jreast.jreastapp.commuter.b.a
implements a.a.a.d,
androidx.lifecycle.j {
    public e<d> k;
    public w.b l;
    public u m;
    private b n;
    private q o;

    public ServiceStatusDetailActivity() {
        this.o = new q();
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
        this.setResult(-1);
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
        if ((object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.x.a())) != null) {
            object = (RailwayLine)object;
            Object object2 = this.o;
            androidx.f.a.e e2 = this;
            w.b b2 = this.l;
            if (b2 == null) {
                j.b("viewModelFactory");
            }
            object2 = ((q)object2).a(e2, b2).a(b.class);
            j.a(object2, "commuterViewModelProvide\u2026ailViewModel::class.java)");
            this.n = (b)object2;
            object2 = this.n;
            if (object2 == null) {
                j.b("viewModel");
            }
            ((b)object2).a((RailwayLine)object);
            ((b)object2).b().a(this, }
    }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    