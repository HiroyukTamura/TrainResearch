/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Handler
 *  android.transition.Transition
 *  android.transition.TransitionInflater
 *  android.transition.TransitionSet
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.i;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.ay;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.main.MainActivity;
import jp.co.jreast.jreastapp.commuter.model.SearchResultSubTitle;
import jp.co.jreast.jreastapp.commuter.model.Station;
import jp.co.jreast.jreastapp.commuter.o.h;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0019H\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020'H\u0007J\b\u0010+\u001a\u00020\u0019H\u0002J\u0006\u0010,\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006-"}, d2={"Ljp/co/jreast/jreastapp/commuter/routesearchresults/RouteSearchResultsFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRouteSearchResultsBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRouteSearchResultsBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRouteSearchResultsBinding;)V", "isSearched", "", "mainActivity", "Ljp/co/jreast/jreastapp/commuter/main/MainActivity;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/routesearchresults/RouteSearchResultsViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "doAnimationSearchResults", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "openRouteDetail", "arguments", "setSupportActionBar", "tapBackButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e
extends androidx.f.a.d
implements s {
    public w.b a;
    public ay b;
    private h c;
    private MainActivity d;
    private jp.co.jreast.jreastapp.commuter.f.q e;
    private boolean f;
    private HashMap g;

    public e() {
        this.e = new jp.co.jreast.jreastapp.commuter.f.q();
    }

    private final void aj() {
        Object object = this.k();
        ay ay2 = null;
        if ((object = object != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.f.a()) : null) != null) {
            Station station = (Station)object;
            Bundle bundle = this.k();
            object = ay2;
            if (bundle != null) {
                object = bundle.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.i.a());
            }
            if (object != null) {
                object = (Station)object;
                ay2 = this.b;
                if (ay2 == null) {
                    j.b("dataBinding");
                }
                ay2 = ay2.k;
                j.a((Object)ay2, "dataBinding.titleDepartureStation");
                ay2.setText((CharSequence)station.getName());
                ay2 = this.b;
                if (ay2 == null) {
                    j.b("dataBinding");
                }
                ay2 = ay2.j;
                j.a((Object)ay2, "dataBinding.titleArrivalStation");
                ay2.setText((CharSequence)((Station)object).getName());
                if (this.c != null) {
                    object = this.c;
                    if (object == null) {
                        j.b("viewModel");
                    }
                    object = ((jp.co.jreast.jreastapp.commuter.skewscroll.h)object).C();
                    ay2 = this.b;
                    if (ay2 == null) {
                        j.b("dataBinding");
                    }
                    ay2 = ay2.h;
                    j.a((Object)ay2, "dataBinding.subTitleLeft");
                    ay2.setText((CharSequence)((SearchResultSubTitle)object).getLeftTitle());
                    ay2 = this.b;
                    if (ay2 == null) {
                        j.b("dataBinding");
                    }
                    ay2 = ay2.i;
                    j.a((Object)ay2, "dataBinding.subTitleRight");
                    ay2.setVisibility(((SearchResultSubTitle)object).getRightVisibility());
                    ay2 = this.b;
                    if (ay2 == null) {
                        j.b("dataBinding");
                    }
                    ay2 = ay2.i;
                    j.a((Object)ay2, "dataBinding.subTitleRight");
                    ay2.setText((CharSequence)((SearchResultSubTitle)object).getRightTitle());
                }
                return;
            }
            throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.model.Station");
        }
        throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.model.Station");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        j.b(object, "inflater");
        object = ay.a((LayoutInflater)object, object2, false);
        j.a(object, "FragmentRouteSearchResul\u2026flater, container, false)");
        this.b = object;
        object = this.k();
        Object var2_3 = null;
        if (object != null && (object = (object = this.k()) != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null) != null) {
            object = this.k();
            object = object != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null;
            if (object == null) throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            this.e = (jp.co.jreast.jreastapp.commuter.f.q)object;
        }
        object = this.e;
        androidx.f.a.e e2 = this.o();
        if (e2 == null) {
            j.a();
        }
        j.a((Object)e2, "activity!!");
        Object object4 = this.a;
        if (object4 == null) {
            j.b("viewModelFactory");
        }
        object = ((jp.co.jreast.jreastapp.commuter.f.q)object).a(e2, (w.b)object4).a(h.class);
        j.a(object, "commuterViewModelProvide\u2026ltsViewModel::class.java)");
        this.c = (h)object;
        object = this.k();
        object = object != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.f.a()) : null;
        if (object != null && (object = (object = this.k()) != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.i.a()) : null) != null && (object = (object = this.k()) != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.e.a()) : null) != null) {
            h h2;
            object = this.c;
            if (object == null) {
                j.b("viewModel");
            }
            object4 = ((jp.co.jreast.jreastapp.commuter.skewscroll.h)object).d();
            androidx.lifecycle.j j2 = this;
            ((al)object4).a(j2, (q)}
    }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    