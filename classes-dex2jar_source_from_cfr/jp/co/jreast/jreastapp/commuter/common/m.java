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
package jp.co.jreast.jreastapp.commuter.common;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.c;
import androidx.f.a.d;
import androidx.f.a.e;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.Serializable;
import java.util.HashMap;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.ac;
import jp.co.jreast.jreastapp.commuter.common.b;
import jp.co.jreast.jreastapp.commuter.common.o;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.f.s;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006$"}, d2={"Ljp/co/jreast/jreastapp/commuter/common/ScalableImageDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/DialogFragmentScalableImageBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/DialogFragmentScalableImageBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/DialogFragmentScalableImageBinding;)V", "targetFrag", "Landroidx/fragment/app/Fragment;", "getTargetFrag", "()Landroidx/fragment/app/Fragment;", "setTargetFrag", "(Landroidx/fragment/app/Fragment;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/common/ScalableImageViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "closeDialog", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class m
extends c
implements s {
    public ac ag;
    public w.b ah;
    private q ai;
    private o aj;
    private d ak;
    private HashMap al;

    public m() {
        this.ai = new q();
    }

    private final void aj() {
        this.a();
        d d2 = this.ak;
        if (d2 != null) {
            d2.a(20, -1, null);
        }
    }

    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        j.b(object, "inflater");
        object = ac.a((LayoutInflater)object, (ViewGroup)object2, false);
        j.a(object, "DialogFragmentScalableIm\u2026flater, container, false)");
        this.ag = object;
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
                    this.ai = (q)object;
                } else {
                    throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
                }
            }
        }
        object = this.ai;
        object2 = this.o();
        if (object2 == null) {
            j.a();
        }
        j.a(object2, "activity!!");
        object3 = this.ah;
        if (object3 == null) {
            j.b("viewModelFactory");
        }
        object = ((q)object).a((e)object2, (w.b)object3).a(o.class);
        j.a(object, "commuterViewModelProvide\u2026ageViewModel::class.java)");
        this.aj = (o)object;
        object = this.ag;
        if (object == null) {
            j.b("dataBinding");
        }
        if ((object2 = this.aj) == null) {
            j.b("viewModel");
        }
        ((ac)object).a((o)object2);
        object = this.aj;
        if (object == null) {
            j.b("viewModel");
        }
        ((o)object).d();
        object = this.aj;
        if (object == null) {
            j.b("viewModel");
        }
        object2 = ((o)object).c();
        object = this;
        ((al)object2).a((androidx.lifecycle.j)object, (androidx.lifecycle.q)}
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    