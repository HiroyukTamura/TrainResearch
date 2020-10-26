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
package jp.co.jreast.jreastapp.commuter.p;

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
import java.util.HashMap;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.be;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.main.MainActivity;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import jp.co.jreast.jreastapp.commuter.n.e;
import jp.co.jreast.jreastapp.commuter.p.f;
import jp.co.jreast.jreastapp.commuter.skewscroll.h;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\"\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020%H\u0007J\b\u0010(\u001a\u00020\u0017H\u0002J\u0006\u0010)\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006*"}, d2={"Ljp/co/jreast/jreastapp/commuter/timetable/TimetableFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTimetableBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTimetableBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTimetableBinding;)V", "mainActivity", "Ljp/co/jreast/jreastapp/commuter/main/MainActivity;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/timetable/TimetableViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "doAnimationSearchResults", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "openRouteDetail", "arguments", "setSupportActionBar", "tapBackButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends androidx.f.a.d
implements s {
    public w.b a;
    public be b;
    private f c;
    private MainActivity d;
    private jp.co.jreast.jreastapp.commuter.f.q e;
    private HashMap f;

    public b() {
        this.e = new jp.co.jreast.jreastapp.commuter.f.q();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final void aj() {
        var1_1 = this.b;
        if (var1_1 == null) {
            j.b("dataBinding");
        }
        var3_2 = var1_1.h;
        j.a((Object)var3_2, "dataBinding.timetableTitle");
        if (this.k() == null) ** GOTO lbl-1000
        var1_1 = this.k();
        var2_3 = null;
        if ((var1_1 = var1_1 != null ? var1_1.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.B.a()) : null) != null) {
            var4_4 = this.k();
            var1_1 = var2_3;
            if (var4_4 != null) {
                var1_1 = var4_4.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.B.a());
            }
            if (var1_1 == null) throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.model.FavoriteRoute");
            var1_1 = ((FavoriteRoute)var1_1).getName();
        } else lbl-1000: // 2 sources:
        {
            var1_1 = "My Route";
        }
        var3_2.setText((CharSequence)var1_1);
    }

    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        j.b(object, "inflater");
        object = be.a((LayoutInflater)object, (ViewGroup)object2, false);
        j.a(object, "FragmentTimetableBinding\u2026flater, container, false)");
        this.b = object;
        if (this.k() != null && (object = (object = this.k()) != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null) != null) {
            object = this.k();
            object = object != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null;
            if (object != null) {
                this.e = (jp.co.jreast.jreastapp.commuter.f.q)object;
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            }
        }
        object = this.e;
        object2 = this.o();
        if (object2 == null) {
            j.a();
        }
        j.a(object2, "activity!!");
        object3 = this.a;
        if (object3 == null) {
            j.b("viewModelFactory");
        }
        object = ((jp.co.jreast.jreastapp.commuter.f.q)object).a((androidx.f.a.e)object2, (w.b)object3).a(f.class);
        j.a(object, "commuterViewModelProvide\u2026bleViewModel::class.java)");
        this.c = (f)object;
        if (this.k() != null && (object = (object = this.k()) != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.B.a()) : null) != null) {
            object2 = this.c;
            if (object2 == null) {
                j.b("viewModel");
            }
            if ((object = (object = this.k()) != null ? object.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.B.a()) : null) != null) {
                ((f)object2).a((FavoriteRoute)object);
            } else {
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.model.FavoriteRoute");
            }
        }
        if ((object2 = this.c) == null) {
            j.b("viewModel");
        }
        object3 = ((h)object2).d();
        object = this;
        ((al)object3).a((androidx.lifecycle.j)object, (q)}
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    