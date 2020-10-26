/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.inputmethod.InputMethodManager
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\u0012\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020#H\u0014J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u00060"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/CandidateLineActivity;", "Ljp/co/jreast/jreastapp/commuter/base/CommuterActivity;", "Ldagger/android/support/HasSupportFragmentInjector;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "adapter", "Ljp/co/jreast/jreastapp/commuter/trainlocation/CandidateLineListAdapter;", "getAdapter", "()Ljp/co/jreast/jreastapp/commuter/trainlocation/CandidateLineListAdapter;", "setAdapter", "(Ljp/co/jreast/jreastapp/commuter/trainlocation/CandidateLineListAdapter;)V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityCandidateLineBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/ActivityCandidateLineBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/ActivityCandidateLineBinding;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/CandidateLineViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "dismissSearchLine", "hideKeyboard", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "selectRailway", "railwayLineInformation", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "supportFragmentInjector", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class CandidateLineActivity
extends jp.co.jreast.jreastapp.commuter.b.a
implements a.a.a.d,
androidx.lifecycle.j {
    public a.a.e<androidx.f.a.d> k;
    public w.b l;
    public jp.co.jreast.jreastapp.commuter.c.c m;
    public jp.co.jreast.jreastapp.commuter.trainlocation.b n;
    private q o;
    private jp.co.jreast.jreastapp.commuter.trainlocation.d p;

    public CandidateLineActivity() {
        this.o = new q();
    }

    private final void a(RailwayLineInformation railwayLineInformation) {
        Intent intent = new Intent();
        intent.putExtra(jp.co.jreast.jreastapp.commuter.common.b.Q.a(), (Serializable)railwayLineInformation);
        this.setResult(-1, intent);
        this.finish();
    }

    public static final /* synthetic */ jp.co.jreast.jreastapp.commuter.trainlocation.d c(CandidateLineActivity object) {
        object = ((CandidateLineActivity)object).p;
        if (object == null) {
            j.b("viewModel");
        }
        return object;
    }

    private final void n() {
        this.finish();
    }

    private final void o() {
        if (this.getCurrentFocus() != null) {
            Object object = this.getApplicationContext().getSystemService("input_method");
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

    public final jp.co.jreast.jreastapp.commuter.trainlocation.b m() {
        jp.co.jreast.jreastapp.commuter.trainlocation.b b2 = this.n;
        if (b2 == null) {
            j.b("adapter");
        }
        return b2;
    }

    @Override
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = f.a(this, 2131427357);
        j.a(object, "DataBindingUtil.setConte\u2026.activity_candidate_line)");
        this.m = (jp.co.jreast.jreastapp.commuter.c.c)object;
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
            object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
            if (object != null) {
                this.o = (q)object;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        object = this.o;
        Object object2 = this;
        w.b b2 = this.l;
        if (b2 == null) {
            j.b("viewModelFactory");
        }
        object = ((q)object).a((androidx.f.a.e)object2, b2).a(jp.co.jreast.jreastapp.commuter.trainlocation.d.class);
        j.a(object, "commuterViewModelProvide\u2026ineViewModel::class.java)");
        this.p = (jp.co.jreast.jreastapp.commuter.trainlocation.d)object;
        object = this.m;
        if (object == null) {
            j.b("dataBinding");
        }
        if ((object2 = this.p) == null) {
            j.b("viewModel");
        }
        ((jp.co.jreast.jreastapp.commuter.c.c)object).a((jp.co.jreast.jreastapp.commuter.trainlocation.d)object2);
        object = (Context)this;
        object2 = this.p;
        if (object2 == null) {
            j.b("viewModel");
        }
        this.n = new jp.co.jreast.jreastapp.commuter.trainlocation.b((Context)object, (jp.co.jreast.jreastapp.commuter.trainlocation.d)object2, null, 4, null);
        object = this.m;
        if (object == null) {
            j.b("dataBinding");
        }
        object = ((jp.co.jreast.jreastapp.commuter.c.c)object).e;
        j.a(object, "dataBinding.lineList");
        object2 = this.n;
        if (object2 == null) {
            j.b("adapter");
        }
        ((RecyclerView)object).setAdapter((RecyclerView.a)object2);
        object2 = this.m;
        if (object2 == null) {
            j.b("dataBinding");
        }
        object = this;
        ((ViewDataBinding)object2).a((androidx.lifecycle.j)object);
        object2 = this.p;
        if (object2 == null) {
            j.b("viewModel");
        }
        ((jp.co.jreast.jreastapp.commuter.trainlocation.d)object2).b().a((androidx.lifecycle.j)object, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    