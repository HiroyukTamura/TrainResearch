/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.d;
import androidx.f.a.e;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.HashMap;
import jp.co.jreast.jreastapp.commuter.c.aq;
import jp.co.jreast.jreastapp.commuter.common.b;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.trainlocation.m;
import jp.co.jreast.jreastapp.commuter.trainlocation.p;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006("}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/RailwayListFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRailwayListBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRailwayListBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRailwayListBinding;)V", "pagerViewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "getPagerViewModel", "()Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "setPagerViewModel", "(Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/RailwayListViewModel;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/trainlocation/RailwayListViewModel;", "setViewModel", "(Ljp/co/jreast/jreastapp/commuter/trainlocation/RailwayListViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class n
extends d
implements s {
    public aq a;
    public p b;
    public y c;
    public w.b d;
    private q e = new q();
    private HashMap f;

    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        j.b(object, "inflater");
        if (this.k() != null && (object3 = (object3 = this.k()) != null ? object3.getSerializable(b.a.a()) : null) != null) {
            object3 = this.k();
            object3 = object3 != null ? object3.getSerializable(b.a.a()) : null;
            if (object3 != null) {
                this.e = (q)object3;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        object3 = this.e;
        Object object4 = this.o();
        if (object4 == null) {
            j.a();
        }
        j.a(object4, "activity!!");
        w.b b2 = this.d;
        if (b2 == null) {
            j.b("viewModelFactory");
        }
        object3 = ((q)object3).a((e)object4, b2).a(y.class);
        j.a(object3, "commuterViewModelProvide\u2026gerViewModel::class.java)");
        this.c = (y)object3;
        object3 = this.k();
        object3 = object3 != null ? object3.getSerializable(b.N.a()) : null;
        object4 = object3;
        if (!(object3 instanceof Integer)) {
            object4 = null;
        }
        int n2 = (object3 = (Integer)object4) != null ? (Integer)object3 : 1;
        object3 = this.e;
        object4 = this.o();
        if (object4 == null) {
            j.a();
        }
        j.a(object4, "activity!!");
        b2 = this.d;
        if (b2 == null) {
            j.b("viewModelFactory");
        }
        object3 = ((q)object3).a((e)object4, b2);
        object4 = new StringBuilder();
        ((StringBuilder)object4).append(b.M.a());
        ((StringBuilder)object4).append(n2);
        object3 = ((w)object3).a(((StringBuilder)object4).toString(), p.class);
        j.a(object3, "commuterViewModelProvide\u2026istViewModel::class.java)");
        this.b = (p)object3;
        object3 = this.b;
        if (object3 == null) {
            j.b("viewModel");
        }
        ((p)object3).a(n2);
        object = aq.a((LayoutInflater)object, (ViewGroup)object2, false);
        j.a(object, "FragmentRailwayListBindi\u2026flater, container, false)");
        this.a = object;
        object = this.a;
        if (object == null) {
            j.b("dataBinding");
        }
        if ((object2 = this.b) == null) {
            j.b("viewModel");
        }
        ((aq)object).a((p)object2);
        object = this.a;
        if (object == null) {
            j.b("dataBinding");
        }
        object = ((aq)object).c;
        j.a(object, "dataBinding.railwayList");
        object2 = this.b;
        if (object2 == null) {
            j.b("viewModel");
        }
        if ((object3 = this.o()) == null) {
            j.a();
        }
        j.a(object3, "activity!!");
        object3 = object3.getApplicationContext();
        j.a(object3, "activity!!.applicationContext");
        object4 = this.c;
        if (object4 == null) {
            j.b("pagerViewModel");
        }
        ((RecyclerView)object).setAdapter(((p)object2).a((Context)object3, (y)object4));
        object = this.a;
        if (object == null) {
            j.b("dataBinding");
        }
        ((ViewDataBinding)object).a(this);
        object = this.a;
        if (object == null) {
            j.b("dataBinding");
        }
        return ((ViewDataBinding)object).e();
    }

    public void a() {
        if (this.f != null) {
            this.f.clear();
        }
    }

    @Override
    public /* synthetic */ void h() {
        super.h();
        this.a();
    }

    @Override
    public void z() {
        super.z();
        Object object = this.a;
        if (object == null) {
            j.b("dataBinding");
        }
        object = ((aq)object).c;
        j.a(object, "dataBinding.railwayList");
        object = ((RecyclerView)object).getAdapter();
        if (object != null) {
            ((RecyclerView.a)object).c();
        }
    }
}

