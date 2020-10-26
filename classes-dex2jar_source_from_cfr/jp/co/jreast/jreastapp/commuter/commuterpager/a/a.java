/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.transition.Transition
 *  android.transition.TransitionInflater
 *  android.transition.TransitionSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.i;
import androidx.f.a.p;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.am;
import jp.co.jreast.jreastapp.commuter.commuterpager.a.g;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import jp.co.jreast.jreastapp.commuter.servicestatus.ServiceStatusDetailActivity;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020'H\u0002J\"\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020'2\u0006\u00109\u001a\u000207H\u0016J\b\u0010:\u001a\u00020'H\u0016J\u0012\u0010;\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010/H\u0002J\u0010\u0010=\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u000107J\u0010\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020AH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006B"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "commuterPagerViewModel", "Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerViewModel;", "getCommuterPagerViewModel", "()Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerViewModel;", "setCommuterPagerViewModel", "(Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerViewModel;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "passedFavoriteRoute", "Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;", "getPassedFavoriteRoute", "()Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;", "setPassedFavoriteRoute", "(Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;)V", "translateAnimation", "Landroid/view/animation/Animation;", "viewDataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentFavoriteRouteDetailBinding;", "getViewDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentFavoriteRouteDetailBinding;", "setViewDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentFavoriteRouteDetailBinding;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailViewModel;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailViewModel;", "setViewModel", "(Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "clearServiceStatus", "", "doErrorServiceStatusAnimation", "doNormalServiceStatusAnimation", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onStop", "openServiceStatusDetailScreen", "passedIntent", "openTimetable", "passedBundle", "setUserVisibleHint", "isVisibleToUser", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a
extends androidx.f.a.d
implements s {
    public jp.co.jreast.jreastapp.commuter.commuterpager.d a;
    public g b;
    public am c;
    public FavoriteRoute d;
    public w.b e;
    private jp.co.jreast.jreastapp.commuter.f.q f;
    private Animation g;
    private HashMap h;

    public a() {
        this.f = new jp.co.jreast.jreastapp.commuter.f.q();
    }

    private final void ai() {
        Object object = this.c;
        if (object == null) {
            j.b("viewDataBinding");
        }
        object = object.j;
        Animation animation = this.g;
        if (animation == null) {
            j.b("translateAnimation");
        }
        object.startAnimation(animation);
    }

    private final void aj() {
        Object object = this.c;
        if (object == null) {
            j.b("viewDataBinding");
        }
        object = object.e;
        Animation animation = this.g;
        if (animation == null) {
            j.b("translateAnimation");
        }
        object.startAnimation(animation);
    }

    private final void b(Intent intent) {
        if (intent == null) {
            intent = new Intent((Context)this.o(), ServiceStatusDetailActivity.class);
        } else {
            intent.setClass((Context)this.o(), ServiceStatusDetailActivity.class);
        }
        this.a(intent, jp.co.jreast.jreastapp.commuter.r.c.g.a());
    }

    private final void c() {
        Object object = this.c;
        if (object == null) {
            j.b("viewDataBinding");
        }
        ((am)object).j.clearAnimation();
        object = this.c;
        if (object == null) {
            j.b("viewDataBinding");
        }
        ((am)object).e.clearAnimation();
        object = this.c;
        if (object == null) {
            j.b("viewDataBinding");
        }
        object = ((am)object).c;
        j.a(object, "viewDataBinding.detailList");
        object = ((RecyclerView)object).getAdapter();
        if (object != null) {
            ((jp.co.jreast.jreastapp.commuter.commuterpager.a.f)object).d();
            return;
        }
        throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.commuterpager.favoriteroutedetail.FavoriteRouteDetailListAdapter");
    }

    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        Object object4;
        Object object5;
        j.b(object, "inflater");
        object3 = this.k();
        Object object6 = null;
        if (object3 != null && (object3 = (object3 = this.k()) != null ? object3.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null) != null) {
            object3 = this.k();
            object3 = object3 != null ? object3.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null;
            if (object3 != null) {
                this.f = (jp.co.jreast.jreastapp.commuter.f.q)object3;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        if (this.k() != null && (object3 = (object3 = this.k()) != null ? object3.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.B.a()) : null) != null) {
            object5 = this.k();
            object3 = object6;
            if (object5 != null) {
                object3 = object5.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.B.a());
            }
            if (object3 != null) {
                this.d = (FavoriteRoute)object3;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.model.FavoriteRoute");
            }
        }
        object3 = this.f;
        object6 = this.o();
        if (object6 == null) {
            j.a();
        }
        j.a(object6, "activity!!");
        object5 = this.e;
        if (object5 == null) {
            j.b("viewModelFactory");
        }
        object3 = ((jp.co.jreast.jreastapp.commuter.f.q)object3).a((androidx.f.a.e)object6, (w.b)object5);
        object6 = this.d;
        if (object6 == null) {
            j.b("passedFavoriteRoute");
        }
        object5 = ((w)object3).a(String.valueOf(((FavoriteRoute)object6).hashCode()), g.class);
        if (this.x()) {
            object3 = object6 = this.d;
            if (object6 == null) {
                j.b("passedFavoriteRoute");
                object3 = object6;
            }
        } else {
            object6 = this.d;
            if (object6 == null) {
                j.b("passedFavoriteRoute");
            }
            object4 = ((Iterable)((FavoriteRoute)object6).getRoute().getLines()).iterator();
            do {
                object3 = object6;
                if (!object4.hasNext()) break;
                ((RailwayLine)object4.next()).getServiceStatus().clearStatus();
            } while (true);
        }
        ((g)object5).a((FavoriteRoute)object3);
        object6 = ((g)object5).i();
        object3 = this;
        ((al)object6).a((androidx.lifecycle.j)object3, (q<Void>)}
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    