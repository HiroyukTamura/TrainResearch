/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package jp.co.jreast.jreastapp.commuter.q.a;

import a.a.e;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.d;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.Serializable;
import java.util.HashMap;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.y;
import jp.co.jreast.jreastapp.commuter.common.b;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.q.a.c;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006*"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainservice/trainserviceinfo/TrainServiceInfoDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityTrainServiceInfoBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/ActivityTrainServiceInfoBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/ActivityTrainServiceInfoBinding;)V", "targetFrag", "getTargetFrag", "()Landroidx/fragment/app/Fragment;", "setTargetFrag", "(Landroidx/fragment/app/Fragment;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/trainservice/trainserviceinfo/TrainServiceInfoViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "closeModal", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a
extends androidx.f.a.c
implements s {
    public e<d> ag;
    public w.b ah;
    public y ai;
    private c aj;
    private q ak;
    private d al;
    private HashMap am;

    public a() {
        this.ak = new q();
    }

    private final void aj() {
        this.a();
        d d2 = this.al;
        if (d2 != null) {
            d2.a(10, -1, null);
        }
    }

    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        j.b(object, "inflater");
        object = y.a((LayoutInflater)object, (ViewGroup)object2, false);
        j.a(object, "ActivityTrainServiceInfo\u2026flater, container, false)");
        this.ai = object;
        if (this.k() != null) {
            object = this.k();
            if (object == null) {
                j.a();
            }
            if (object.getSerializable(b.a.a()) != null) {
                object = this.k();
                if (object == null) {
                    j.a();
                }
                if ((object = object.getSerializable(b.a.a())) != null) {
                    this.ak = (q)object;
                } else {
                    throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
                }
            }
        }
        object = this.ak;
        object2 = this.o();
        if (object2 == null) {
            j.a();
        }
        j.a(object2, "activity!!");
        object3 = this.ah;
        if (object3 == null) {
            j.b("viewModelFactory");
        }
        object = ((q)object).a((androidx.f.a.e)object2, (w.b)object3).a(c.class);
        j.a(object, "commuterViewModelProvide\u2026nfoViewModel::class.java)");
        this.aj = (c)object;
        object = this.ai;
        if (object == null) {
            j.b("dataBinding");
        }
        if ((object2 = this.aj) == null) {
            j.b("viewModel");
        }
        ((y)object).a((c)object2);
        object = this.aj;
        if (object == null) {
            j.b("viewModel");
        }
        object2 = ((c)object).b();
        object = this;
        ((al)object2).a((androidx.lifecycle.j)object, (androidx.lifecycle.q)}
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    