/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.Button
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.e;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.HashMap;
import jp.co.jreast.jreastapp.commuter.c.bk;
import jp.co.jreast.jreastapp.commuter.common.b;
import jp.co.jreast.jreastapp.commuter.commuterpager.d;
import jp.co.jreast.jreastapp.commuter.f.q;
import jp.co.jreast.jreastapp.commuter.f.s;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0013\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000200H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u00062"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/tutorial/TutorialFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "animation", "Landroid/view/animation/Animation;", "getAnimation", "()Landroid/view/animation/Animation;", "setAnimation", "(Landroid/view/animation/Animation;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "onScrollListener", "jp/co/jreast/jreastapp/commuter/commuterpager/tutorial/TutorialFragment$onScrollListener$1", "Ljp/co/jreast/jreastapp/commuter/commuterpager/tutorial/TutorialFragment$onScrollListener$1;", "pagerViewModel", "Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerViewModel;", "getPagerViewModel", "()Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerViewModel;", "setPagerViewModel", "(Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerViewModel;)V", "viewDataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTutorialBinding;", "getViewDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTutorialBinding;", "setViewDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTutorialBinding;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onResume", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class c
extends androidx.f.a.d
implements s {
    public bk a;
    public d b;
    public w.b c;
    public LinearLayoutManager d;
    public Animation e;
    private q f = new q();
    private final a g = new RecyclerView.n(){

        @Override
        public void a(RecyclerView recyclerView, int n2, int n3) {
            j.b(recyclerView, "recyclerView");
            super.a(recyclerView, n2, n3);
            recyclerView = this.a().c;
            j.a((Object)recyclerView, "viewDataBinding.tutorialButton");
            if (recyclerView.getVisibility() != 0 && this.b().m() >= 1) {
                recyclerView = this.a().c;
                j.a((Object)recyclerView, "viewDataBinding.tutorialButton");
                recyclerView.setVisibility(0);
                this.a().c.startAnimation(this.c());
            }
        }
    };
    private HashMap h;

    @Override
    public void A() {
        super.A();
        bk bk2 = this.a;
        if (bk2 == null) {
            j.b("viewDataBinding");
        }
        bk2.d.b(this.g);
    }

    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        j.b(object, "inflater");
        object = bk.a((LayoutInflater)object, object2, false);
        j.a(object, "FragmentTutorialBinding.\u2026flater, container, false)");
        this.a = object;
        if (this.k() != null) {
            object = this.k();
            object2 = null;
            if ((object = object != null ? object.getSerializable(b.a.a()) : null) != null) {
                object3 = this.k();
                object = object2;
                if (object3 != null) {
                    object = object3.getSerializable(b.a.a());
                }
                if (object != null) {
                    this.f = (q)object;
                } else {
                    throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
                }
            }
        }
        object = this.f;
        object2 = this.o();
        if (object2 == null) {
            j.a();
        }
        j.a(object2, "activity!!");
        object3 = this.c;
        if (object3 == null) {
            j.b("viewModelFactory");
        }
        object = ((q)object).a((e)object2, (w.b)object3).a(d.class);
        j.a(object, "commuterViewModelProvide\u2026gerViewModel::class.java)");
        this.b = (d)object;
        object = this.a;
        if (object == null) {
            j.b("viewDataBinding");
        }
        if ((object2 = this.b) == null) {
            j.b("pagerViewModel");
        }
        ((bk)object).a((d)object2);
        object = this.a;
        if (object == null) {
            j.b("viewDataBinding");
        }
        object = ((bk)object).d;
        j.a(object, "viewDataBinding.tutorialList");
        object2 = this.m();
        if (object2 == null) {
            j.a();
        }
        j.a(object2, "context!!");
        ((RecyclerView)object).setAdapter(new jp.co.jreast.jreastapp.commuter.commuterpager.c.a((Context)object2));
        object = this.a;
        if (object == null) {
            j.b("viewDataBinding");
        }
        object = ((bk)object).d;
        j.a(object, "viewDataBinding.tutorialList");
        object = ((RecyclerView)object).getLayoutManager();
        if (object != null) {
            this.d = (LinearLayoutManager)object;
            object = AnimationUtils.loadAnimation((Context)this.m(), (int)2130771998);
            j.a(object, "AnimationUtils.loadAnima\u2026m.tutorial_button_fadein)");
            this.e = object;
            object = this.a;
            if (object == null) {
                j.b("viewDataBinding");
            }
            return ((ViewDataBinding)object).e();
        }
        throw new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public final bk a() {
        bk bk2 = this.a;
        if (bk2 == null) {
            j.b("viewDataBinding");
        }
        return bk2;
    }

    public void ai() {
        if (this.h != null) {
            this.h.clear();
        }
    }

    public final LinearLayoutManager b() {
        LinearLayoutManager linearLayoutManager = this.d;
        if (linearLayoutManager == null) {
            j.b("layoutManager");
        }
        return linearLayoutManager;
    }

    public final Animation c() {
        Animation animation = this.e;
        if (animation == null) {
            j.b("animation");
        }
        return animation;
    }

    @Override
    public /* synthetic */ void h() {
        super.h();
        this.ai();
    }

    @Override
    public void z() {
        super.z();
        bk bk2 = this.a;
        if (bk2 == null) {
            j.b("viewDataBinding");
        }
        bk2.d.a(this.g);
    }

}

