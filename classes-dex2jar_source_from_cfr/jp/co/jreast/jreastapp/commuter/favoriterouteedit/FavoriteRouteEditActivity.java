/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.Editable
 *  android.widget.EditText
 */
package jp.co.jreast.jreastapp.commuter.favoriterouteedit;

import a.a.e;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.i;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import com.a.a.b;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.g;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.b;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.d;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.f;
import jp.co.jreast.jreastapp.commuter.favoriterouteedit.h;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.i.n;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0006\u0010 \u001a\u00020\u001dJ\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0015\u0010$\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010&\u00a2\u0006\u0002\u0010'J\u001d\u0010(\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020*\u00a2\u0006\u0002\u0010+J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006-"}, d2={"Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditActivity;", "Ljp/co/jreast/jreastapp/commuter/base/CommuterActivity;", "Landroidx/lifecycle/LifecycleOwner;", "Ldagger/android/support/HasSupportFragmentInjector;", "()V", "adapter", "Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditAdapter;", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityFavoriteRouteEditBinding;", "mItemTouchHelper", "Lcom/loopeer/itemtouchhelperextension/ItemTouchHelperExtension;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/favoriterouteedit/FavoriteRouteEditViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "dismiss", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeItem", "position", "", "(Ljava/lang/Integer;)V", "renameItem", "name", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "supportFragmentInjector", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class FavoriteRouteEditActivity
extends jp.co.jreast.jreastapp.commuter.b.a
implements a.a.a.d,
androidx.lifecycle.j {
    public e<androidx.f.a.d> k;
    public w.b l;
    private f m;
    private q n;
    private g o;
    private d p;
    private com.a.a.b q;

    public FavoriteRouteEditActivity() {
        this.n = new q();
    }

    public static final /* synthetic */ f a(FavoriteRouteEditActivity object) {
        object = ((FavoriteRouteEditActivity)object).m;
        if (object == null) {
            j.b("viewModel");
        }
        return object;
    }

    public final void a(Integer object) {
        d d2 = this.p;
        if (d2 == null) {
            j.b("adapter");
        }
        if (object == null) {
            j.a();
        }
        d2.c((Integer)object);
        object = this.q;
        if (object == null) {
            j.b("mItemTouchHelper");
        }
        ((com.a.a.b)object).a();
    }

    public final void a(Integer object, String string2) {
        j.b(string2, "name");
        f f2 = this.m;
        if (f2 == null) {
            j.b("viewModel");
        }
        if (object == null) {
            j.a();
        }
        f2.a((Integer)object, string2);
        object = this.p;
        if (object == null) {
            j.b("adapter");
        }
        ((RecyclerView.a)object).c();
        object = this.q;
        if (object == null) {
            j.b("mItemTouchHelper");
        }
        ((com.a.a.b)object).a();
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
        this.setResult(-1);
        this.finish();
    }

    @Override
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = androidx.databinding.f.a(this, 2131427359);
        j.a(object, "DataBindingUtil.setConte\u2026vity_favorite_route_edit)");
        this.o = (g)object;
        Object object2 = this.o;
        if (object2 == null) {
            j.b("dataBinding");
        }
        object = this;
        ((ViewDataBinding)object2).a((androidx.lifecycle.j)object);
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
            object2 = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
            if (object2 != null) {
                this.n = (q)object2;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        object2 = this.n;
        Object object3 = this;
        w.b b2 = this.l;
        if (b2 == null) {
            j.b("viewModelFactory");
        }
        object2 = ((q)object2).a((androidx.f.a.e)object3, b2).a(f.class);
        j.a(object2, "commuterViewModelProvide\u2026ditViewModel::class.java)");
        this.m = (f)object2;
        object2 = this.m;
        if (object2 == null) {
            j.b("viewModel");
        }
        ((f)object2).b().a((androidx.lifecycle.j)object, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    