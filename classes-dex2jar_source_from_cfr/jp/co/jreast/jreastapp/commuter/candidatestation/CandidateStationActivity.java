/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.inputmethod.InputMethodManager
 */
package jp.co.jreast.jreastapp.commuter.candidatestation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.model.Station;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001.B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0002J\u0006\u0010!\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u001dJ\u0012\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u001dH\u0014J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010,J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006/"}, d2={"Ljp/co/jreast/jreastapp/commuter/candidatestation/CandidateStationActivity;", "Ljp/co/jreast/jreastapp/commuter/base/CommuterActivity;", "Ldagger/android/support/HasSupportFragmentInjector;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityCandidateStationBinding;", "getDataBinding$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/databinding/ActivityCandidateStationBinding;", "setDataBinding$app_productRelease", "(Ljp/co/jreast/jreastapp/commuter/databinding/ActivityCandidateStationBinding;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/candidatestation/CandidateStationViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "changeHistoryEditMode", "dismissCandidateStation", "hideKeyboard", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "removeItem", "station", "Ljp/co/jreast/jreastapp/commuter/model/Station;", "returnSelectedStation", "intent", "Landroid/content/Intent;", "supportFragmentInjector", "Companion", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class CandidateStationActivity
extends jp.co.jreast.jreastapp.commuter.b.a
implements a.a.a.d,
androidx.lifecycle.j {
    public static final a n;
    public a.a.e<androidx.f.a.d> k;
    public w.b l;
    public jp.co.jreast.jreastapp.commuter.c.e m;
    private jp.co.jreast.jreastapp.commuter.candidatestation.c o;
    private jp.co.jreast.jreastapp.commuter.f.q p;

    static {
        n = new a(null);
    }

    public CandidateStationActivity() {
        this.p = new jp.co.jreast.jreastapp.commuter.f.q();
    }

    private final void a(Station station) {
        jp.co.jreast.jreastapp.commuter.candidatestation.c c2 = this.o;
        if (c2 == null) {
            j.b("viewModel");
        }
        c2.c(station);
    }

    public static final /* synthetic */ jp.co.jreast.jreastapp.commuter.candidatestation.c b(CandidateStationActivity object) {
        object = ((CandidateStationActivity)object).o;
        if (object == null) {
            j.b("viewModel");
        }
        return object;
    }

    private final void o() {
        Object object = this.m;
        if (object == null) {
            j.b("dataBinding");
        }
        object = ((jp.co.jreast.jreastapp.commuter.c.e)object).k;
        j.a(object, "dataBinding.stationList");
        object = ((RecyclerView)object).getAdapter();
        if (object != null) {
            Object object2 = this.m;
            if (object2 == null) {
                j.b("dataBinding");
            }
            object2 = ((jp.co.jreast.jreastapp.commuter.c.e)object2).k;
            j.a(object2, "dataBinding.stationList");
            object2 = ((RecyclerView)object2).getAdapter();
            int n2 = object2 != null ? ((RecyclerView.a)object2).a() : 0;
            ((RecyclerView.a)object).a(0, n2);
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

    public a.a.e<androidx.f.a.d> l() {
        a.a.e<androidx.f.a.d> e2 = this.k;
        if (e2 == null) {
            j.b("androidInjector");
        }
        return e2;
    }

    public final void m() {
        this.finish();
    }

    public final void n() {
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

    @Override
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        int n2 = this.getIntent().getIntExtra("STATION_TYPE", 0);
        object = androidx.databinding.f.a(this, 2131427358);
        j.a(object, "DataBindingUtil.setConte\u2026tivity_candidate_station)");
        this.m = (jp.co.jreast.jreastapp.commuter.c.e)object;
        Object object2 = this.m;
        if (object2 == null) {
            j.b("dataBinding");
        }
        object = this;
        ((ViewDataBinding)object2).a((androidx.lifecycle.j)object);
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
            object2 = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
            if (object2 != null) {
                this.p = (jp.co.jreast.jreastapp.commuter.f.q)object2;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        object2 = this.p;
        Object object3 = this;
        w.b b2 = this.l;
        if (b2 == null) {
            j.b("viewModelFactory");
        }
        object2 = ((jp.co.jreast.jreastapp.commuter.f.q)object2).a((androidx.f.a.e)object3, b2).a(jp.co.jreast.jreastapp.commuter.candidatestation.c.class);
        j.a(object2, "commuterViewModelProvide\u2026ionViewModel::class.java)");
        this.o = (jp.co.jreast.jreastapp.commuter.candidatestation.c)object2;
        object2 = this.o;
        if (object2 == null) {
            j.b("viewModel");
        }
        ((jp.co.jreast.jreastapp.commuter.candidatestation.c)object2).a(n2);
        ((jp.co.jreast.jreastapp.commuter.candidatestation.c)object2).j().a((androidx.lifecycle.j)object, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    