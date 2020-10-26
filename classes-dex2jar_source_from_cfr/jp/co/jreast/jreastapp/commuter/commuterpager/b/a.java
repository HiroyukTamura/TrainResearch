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
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.widget.Button
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.b;

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
import android.widget.Button;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.i;
import androidx.f.a.p;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.viewpager.widget.ViewPager;
import java.io.Serializable;
import java.util.HashMap;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.ak;
import jp.co.jreast.jreastapp.commuter.c.aw;
import jp.co.jreast.jreastapp.commuter.candidatestation.CandidateStationActivity;
import jp.co.jreast.jreastapp.commuter.common.r;
import jp.co.jreast.jreastapp.commuter.commuterpager.a;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.timeselect.DepartureArrivalTimeSelectActivity;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\"\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010 H\u0002J\u0012\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u001bH\u0002J\u0010\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u000202H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u00063"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/routesearch/RouteSearchFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRouteSearchBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRouteSearchBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentRouteSearchBinding;)V", "viewModel", "Ljp/co/jreast/jreastapp/commuter/commuterpager/routesearch/RouteSearchViewModel;", "getViewModel", "()Ljp/co/jreast/jreastapp/commuter/commuterpager/routesearch/RouteSearchViewModel;", "setViewModel", "(Ljp/co/jreast/jreastapp/commuter/commuterpager/routesearch/RouteSearchViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "addViaStationAnimation", "", "stationType", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "openCandidateStation", "openDepartureArrivalTimeSelect", "passedIntent", "openRouteSearchResults", "bundle", "removeViaStationAnimation", "state", "setUserVisibleHint", "isVisibleToUser", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a
extends androidx.f.a.d
implements s {
    public aw a;
    public w.b b;
    private jp.co.jreast.jreastapp.commuter.commuterpager.b.c c;
    private jp.co.jreast.jreastapp.commuter.f.q d;
    private HashMap e;

    public a() {
        this.d = new jp.co.jreast.jreastapp.commuter.f.q();
    }

    private final void b(Intent intent) {
        if (intent == null) {
            intent = new Intent(this.m(), DepartureArrivalTimeSelectActivity.class);
        } else {
            intent.setClass(this.m(), DepartureArrivalTimeSelectActivity.class);
        }
        this.a(intent, 2);
    }

    private final void c(int n2) {
        Intent intent = new Intent(this.m(), CandidateStationActivity.class);
        intent.putExtra("STATION_TYPE", n2);
        this.a(intent, 1);
    }

    private final void c(Bundle object) {
        if (object != null) {
            jp.co.jreast.jreastapp.commuter.o.e e2 = new jp.co.jreast.jreastapp.commuter.o.e();
            e2.g((Bundle)object);
            e2.a((Object)new TransitionSet().addTransition(TransitionInflater.from((Context)this.m()).inflateTransition(2131755014)));
            e2.b((Object)new TransitionSet().addTransition(TransitionInflater.from((Context)this.m()).inflateTransition(2131755016)));
            e2.c((Object)new TransitionSet().addTransition(TransitionInflater.from((Context)this.m()).inflateTransition(2131755015)));
            object = this.u();
            if (object != null) {
                i i2 = ((androidx.f.a.d)(object = (jp.co.jreast.jreastapp.commuter.commuterpager.b)object)).r();
                if (i2 == null) {
                    j.a();
                }
                i2.a().b(2131230942, e2).a((String)null).d();
                object = object.a().c;
                j.a(object, "commuterPagerFragment.dataBinding.commuterPager");
                ((ViewPager)((Object)object)).setAdapter(null);
                return;
            }
            throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.commuterpager.CommuterPagerFragment");
        }
    }

    private final void d(final int n2) {
        Object object = AnimationUtils.loadAnimation((Context)this.m(), (int)2130772000);
        Object object2 = AnimationUtils.loadAnimation((Context)this.m(), (int)2130771986);
        j.a(object2, "animFadein");
        object2.setFillAfter(false);
        Object object3 = AnimationUtils.loadAnimation((Context)this.m(), (int)2130771988);
        j.a(object3, "animFadeout");
        object3.setFillAfter(false);
        Animation.AnimationListener animationListener = new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
                animation = new Intent(this.m(), CandidateStationActivity.class);
                animation.putExtra("STATION_TYPE", n2);
                this.a((Intent)animation, 1);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        if (n2 == r.c.a()) {
            object.setAnimationListener(animationListener);
            object3 = this.a;
            if (object3 == null) {
                j.b("dataBinding");
            }
            object3.r.startAnimation(object2);
            object3 = this.a;
            if (object3 == null) {
                j.b("dataBinding");
            }
            object3.n.startAnimation(object2);
            object2 = this.a;
            if (object2 == null) {
                j.b("dataBinding");
            }
            object2.p.startAnimation(object);
            return;
        }
        if (n2 == r.d.a()) {
            object3.setAnimationListener(animationListener);
            object = this.a;
            if (object == null) {
                j.b("dataBinding");
            }
            object.s.startAnimation(object2);
            object = this.a;
            if (object == null) {
                j.b("dataBinding");
            }
            object.o.startAnimation(object2);
            object2 = this.a;
            if (object2 == null) {
                j.b("dataBinding");
            }
            object2.p.startAnimation(object3);
        }
    }

    private final void e(final int n2) {
        Object object = AnimationUtils.loadAnimation((Context)this.m(), (int)2130772001);
        Object object2 = AnimationUtils.loadAnimation((Context)this.m(), (int)2130771988);
        Object object3 = AnimationUtils.loadAnimation((Context)this.m(), (int)2130771986);
        Animation.AnimationListener animationListener = new Animation.AnimationListener(){

            public void onAnimationEnd(Animation object) {
                object = this.b();
                if (object == null) {
                    j.a();
                }
                ((jp.co.jreast.jreastapp.commuter.commuterpager.b.c)object).C();
                this.a().p.clearAnimation();
                switch (n2) {
                    default: {
                        return;
                    }
                    case 1: {
                        this.a().s.clearAnimation();
                        object = this.a().o;
                        break;
                    }
                    case 0: {
                        this.a().r.clearAnimation();
                        object = this.a().n;
                    }
                }
                object.clearAnimation();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        switch (n2) {
            default: {
                return;
            }
            case 1: {
                object3.setAnimationListener(animationListener);
                object = this.a;
                if (object == null) {
                    j.b("dataBinding");
                }
                object.s.startAnimation(object2);
                object = this.a;
                if (object == null) {
                    j.b("dataBinding");
                }
                object.o.startAnimation(object2);
                object2 = this.a;
                if (object2 == null) {
                    j.b("dataBinding");
                }
                object2.p.startAnimation(object3);
                return;
            }
            case 0: 
        }
        object.setAnimationListener(animationListener);
        object3 = this.a;
        if (object3 == null) {
            j.b("dataBinding");
        }
        object3.r.startAnimation(object2);
        object3 = this.a;
        if (object3 == null) {
            j.b("dataBinding");
        }
        object3.n.startAnimation(object2);
        object2 = this.a;
        if (object2 == null) {
            j.b("dataBinding");
        }
        object2.p.startAnimation(object);
    }

    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        androidx.f.a.e e2;
        Object object4;
        j.b(object, "inflater");
        if (this.k() != null) {
            object3 = this.k();
            e2 = null;
            if ((object3 = object3 != null ? object3.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null) != null) {
                object4 = this.k();
                object3 = e2;
                if (object4 != null) {
                    object3 = object4.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a());
                }
                if (object3 != null) {
                    this.d = (jp.co.jreast.jreastapp.commuter.f.q)object3;
                } else {
                    throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
                }
            }
        }
        object3 = this.d;
        e2 = this.o();
        if (e2 == null) {
            j.a();
        }
        j.a((Object)e2, "activity!!");
        object4 = this.b;
        if (object4 == null) {
            j.b("viewModelFactory");
        }
        this.c = ((jp.co.jreast.jreastapp.commuter.f.q)object3).a(e2, (w.b)object4).a(a.a.b.name(), jp.co.jreast.jreastapp.commuter.commuterpager.b.c.class);
        object = aw.a((LayoutInflater)object, (ViewGroup)object2, false);
        j.a(object, "FragmentRouteSearchBindi\u2026flater, container, false)");
        this.a = object;
        object = this.a;
        if (object == null) {
            j.b("dataBinding");
        }
        ((aw)object).a(this.c);
        object2 = this.a;
        if (object2 == null) {
            j.b("dataBinding");
        }
        object = this;
        ((ViewDataBinding)object2).a((androidx.lifecycle.j)object);
        object2 = this.c;
        if (object2 == null) {
            j.a();
        }
        ((jp.co.jreast.jreastapp.commuter.commuterpager.b.c)object2).o().a((androidx.lifecycle.j)object, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    