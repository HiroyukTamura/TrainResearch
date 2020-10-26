/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package jp.co.jreast.jreastapp.commuter.others;

import a.a.e;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.f;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.m;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.main.v;
import jp.co.jreast.jreastapp.commuter.others.b;
import jp.co.jreast.jreastapp.commuter.others.d;
import jp.co.jreast.jreastapp.commuter.webview.g;
import jp.co.jreast.jreastapp.commuter.webview.o;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&J\u0012\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006+"}, d2={"Ljp/co/jreast/jreastapp/commuter/others/OthersActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/lifecycle/LifecycleOwner;", "Ldagger/android/support/HasSupportFragmentInjector;", "Ljp/co/jreast/jreastapp/commuter/main/RootFragmentMainChild;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityOthersBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/ActivityOthersBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/ActivityOthersBinding;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/others/OthersViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openWebView", "site", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "setSupportActionBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "supportFragmentInjector", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class OthersActivity
extends c
implements a.a.a.d,
androidx.lifecycle.j,
v {
    public e<androidx.f.a.d> k;
    public w.b l;
    public m m;
    private q n;
    private d o;

    public OthersActivity() {
        this.n = new q();
    }

    @Override
    public void a(Toolbar object) {
        super.a((Toolbar)((Object)object));
        if (this.a() != null) {
            object = this.a();
            if (object == null) {
                j.a();
            }
            ((androidx.appcompat.app.a)object).a(false);
        }
    }

    public final void a(o o2) {
        j.b(o2, "site");
        Intent intent = new Intent((Context)this, g.class);
        intent.putExtra(jp.co.jreast.jreastapp.commuter.common.b.A.a(), (Serializable)o2);
        this.startActivityForResult(intent, jp.co.jreast.jreastapp.commuter.r.c.l.a());
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

    @Override
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
            object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
            if (object != null) {
                this.n = (q)object;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        object = f.a(this, 2131427362);
        j.a(object, "DataBindingUtil.setConte\u2026R.layout.activity_others)");
        this.m = (m)object;
        object = this.m;
        if (object == null) {
            j.b("dataBinding");
        }
        this.a(((m)object).d);
        object = this.n;
        Object object2 = this;
        w.b b2 = this.l;
        if (b2 == null) {
            j.b("viewModelFactory");
        }
        object = ((q)object).a((androidx.f.a.e)object2, b2).a(d.class);
        j.a(object, "commuterViewModelProvide\u2026ersViewModel::class.java)");
        this.o = (d)object;
        object = this.o;
        if (object == null) {
            j.b("viewModel");
        }
        ((d)object).b().a(this, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    