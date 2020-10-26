/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.d;
import androidx.f.a.e;
import androidx.f.a.i;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.HashMap;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.ao;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.r.c;
import jp.co.jreast.jreastapp.commuter.trainlocation.CandidateLineActivity;
import jp.co.jreast.jreastapp.commuter.trainlocation.f;
import jp.co.jreast.jreastapp.commuter.trainlocation.g;
import jp.co.jreast.jreastapp.commuter.trainlocation.j;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;
import kotlin.Metadata;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\"\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020*H\u0016J\b\u00109\u001a\u00020*H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0001X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006:"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/HistorySelectedLineFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentHistorySelectedLineBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentHistorySelectedLineBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentHistorySelectedLineBinding;)V", "manager", "Landroidx/fragment/app/FragmentManager;", "getManager", "()Landroidx/fragment/app/FragmentManager;", "setManager", "(Landroidx/fragment/app/FragmentManager;)V", "nextFragment", "getNextFragment", "()Landroidx/fragment/app/Fragment;", "setNextFragment", "(Landroidx/fragment/app/Fragment;)V", "pagerViewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "getPagerViewModel", "()Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "setPagerViewModel", "(Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/HistorySelectedLineViewModel;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/trainlocation/HistorySelectedLineViewModel;", "setViewModel", "(Ljp/co/jreast/jreastapp/commuter/trainlocation/HistorySelectedLineViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "openCandidateLine", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class h
extends d
implements s {
    public ao a;
    public w.b b;
    public i c;
    private j d;
    private y e;
    private q f;
    private HashMap g;

    public h() {
        this.f = new q();
    }

    private final void c() {
        this.a(new Intent((Context)this.o(), CandidateLineActivity.class), c.m.a());
    }

    @Override
    public View a(LayoutInflater object, ViewGroup viewGroup, Bundle object2) {
        Object object3;
        Object object4;
        kotlin.e.b.j.b(object, "inflater");
        if (this.k() != null) {
            object2 = this.k();
            object3 = null;
            if ((object2 = object2 != null ? object2.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null) != null) {
                object4 = this.k();
                object2 = object3;
                if (object4 != null) {
                    object2 = object4.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a());
                }
                if (object2 != null) {
                    this.f = (q)object2;
                } else {
                    throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
                }
            }
        }
        object2 = this.f;
        object3 = this.o();
        if (object3 == null) {
            kotlin.e.b.j.a();
        }
        kotlin.e.b.j.a(object3, "activity!!");
        object4 = this.b;
        if (object4 == null) {
            kotlin.e.b.j.b("viewModelFactory");
        }
        this.e = ((q)object2).a((e)object3, (w.b)object4).a(y.class);
        object2 = this.f;
        object3 = this.o();
        if (object3 == null) {
            kotlin.e.b.j.a();
        }
        kotlin.e.b.j.a(object3, "activity!!");
        object4 = this.b;
        if (object4 == null) {
            kotlin.e.b.j.b("viewModelFactory");
        }
        this.d = ((q)object2).a((e)object3, (w.b)object4).a(jp.co.jreast.jreastapp.commuter.common.b.L.a(), j.class);
        object3 = this.d;
        if (object3 == null) {
            kotlin.e.b.j.a();
        }
        this.e = this.e;
        object4 = ((j)object3).b();
        object2 = this;
        ((al)object4).a((androidx.lifecycle.j)object2, (androidx.lifecycle.q)}
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    