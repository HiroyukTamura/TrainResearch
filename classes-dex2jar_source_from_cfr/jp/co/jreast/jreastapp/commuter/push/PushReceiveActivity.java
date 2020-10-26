/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.view.Window
 */
package jp.co.jreast.jreastapp.commuter.push;

import a.a.e;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.f.a.d;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.o;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.others.OthersActivity;
import jp.co.jreast.jreastapp.commuter.push.c;
import jp.co.jreast.jreastapp.commuter.webview.g;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u0006\u0010&\u001a\u00020#J\u0012\u0010'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u000e\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006."}, d2={"Ljp/co/jreast/jreastapp/commuter/push/PushReceiveActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/lifecycle/LifecycleOwner;", "Ldagger/android/support/HasSupportFragmentInjector;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityPushReceiveBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/ActivityPushReceiveBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/ActivityPushReceiveBinding;)V", "taskStackBuilder", "Ljp/co/jreast/jreastapp/commuter/generator/TaskStackBuilderGenerator;", "getTaskStackBuilder", "()Ljp/co/jreast/jreastapp/commuter/generator/TaskStackBuilderGenerator;", "setTaskStackBuilder", "(Ljp/co/jreast/jreastapp/commuter/generator/TaskStackBuilderGenerator;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/push/PushReceiveViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "close", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openCommonWebView", "site", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "supportFragmentInjector", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class PushReceiveActivity
extends androidx.appcompat.app.c
implements a.a.a.d,
androidx.lifecycle.j {
    public e<d> k;
    public w.b l;
    public jp.co.jreast.jreastapp.commuter.i.a m;
    public o n;
    private q o;
    private c p;

    public PushReceiveActivity() {
        this.o = new q();
    }

    public final void a(jp.co.jreast.jreastapp.commuter.webview.o object) {
        j.b(object, "site");
        boolean bl2 = ((CharSequence)((jp.co.jreast.jreastapp.commuter.webview.o)object).b()).length() == 0;
        if (bl2) {
            return;
        }
        Context context = (Context)this;
        Intent intent = new Intent(context, g.class);
        intent.putExtra(jp.co.jreast.jreastapp.commuter.common.b.A.a(), (Serializable)object);
        object = this.m;
        if (object == null) {
            j.b("taskStackBuilder");
        }
        object = ((jp.co.jreast.jreastapp.commuter.i.a)object).a(context);
        ((androidx.core.app.g)object).a(new Intent(context, OthersActivity.class));
        ((androidx.core.app.g)object).a(intent);
        ((androidx.core.app.g)object).a();
        this.finish();
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
        Object object2 = "";
        object = "";
        if (this.getIntent() != null) {
            boolean bl2;
            if (this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
                object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
                if (object != null) {
                    this.o = (q)object;
                } else {
                    throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
                }
            }
            object2 = this.getIntent().getStringExtra(jp.co.jreast.jreastapp.commuter.common.b.H.a());
            j.a(object2, "intent.getStringExtra(ArgumentKeys.PUSH_V.key)");
            if (object2 == null || (bl2 = ((CharSequence)object2).length() == 0)) {
                this.finish();
            }
            if ((object = this.getIntent().getStringExtra(jp.co.jreast.jreastapp.commuter.common.b.J.a())) == null) {
                object = "";
            }
        } else {
            this.finish();
        }
        Object object3 = f.a(this, 2131427363);
        j.a(object3, "DataBindingUtil.setConte\u2026ut.activity_push_receive)");
        this.n = (o)object3;
        Object object4 = this.n;
        if (object4 == null) {
            j.b("dataBinding");
        }
        object3 = this;
        ((ViewDataBinding)object4).a((androidx.lifecycle.j)object3);
        object4 = this.o;
        androidx.f.a.e e2 = this;
        w.b b2 = this.l;
        if (b2 == null) {
            j.b("viewModelFactory");
        }
        object4 = ((q)object4).a(e2, b2).a(c.class);
        j.a(object4, "commuterViewModelProvide\u2026iveViewModel::class.java)");
        this.p = (c)object4;
        object4 = this.p;
        if (object4 == null) {
            j.b("viewModel");
        }
        ((c)object4).a((String)object2, (String)object);
        object = this.p;
        if (object == null) {
            j.b("viewModel");
        }
        ((c)object).b().a((androidx.lifecycle.j)object3, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    