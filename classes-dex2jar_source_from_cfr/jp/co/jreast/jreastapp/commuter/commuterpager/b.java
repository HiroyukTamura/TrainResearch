/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Bundle
 *  android.view.Display
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.WindowManager
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package jp.co.jreast.jreastapp.commuter.commuterpager;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.i;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.io.Serializable;
import java.util.HashMap;
import jp.co.jreast.jreastapp.commuter.ak;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.ak;
import jp.co.jreast.jreastapp.commuter.commuterpager.a;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.q;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u000e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0019J\b\u0010\u001d\u001a\u00020\u0019H\u0002J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\b\u0010'\u001a\u00020\u0019H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0019H\u0002J\b\u0010.\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006/"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "Ljp/co/jreast/jreastapp/commuter/main/RootFragmentMainChild;", "()V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentCommuterPagerBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentCommuterPagerBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentCommuterPagerBinding;)V", "onPageChangeListener", "jp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerFragment$onPageChangeListener$1", "Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerFragment$onPageChangeListener$1;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/commuterpager/CommuterPagerViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "changeViewPage", "", "position", "", "closeMyRouteNoticeView", "createPagerAdapter", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onStart", "setSearchTabAlpha", "setTabsFont", "setUserVisibleHint", "isVisibleToUser", "", "setupCommuterPagerTabs", "updateCommuterPager", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends androidx.f.a.d
implements s,
jp.co.jreast.jreastapp.commuter.main.v {
    public w.b a;
    public ak b;
    private jp.co.jreast.jreastapp.commuter.commuterpager.d c;
    private jp.co.jreast.jreastapp.commuter.f.q d;
    private final g e;
    private HashMap f;

    public b() {
        this.d = new jp.co.jreast.jreastapp.commuter.f.q();
        this.e = new ViewPager.f(){

            @Override
            public void a(int n2) {
                b.b(this).a(n2);
                this.e(n2);
                b.b(this).b(n2);
                Object object = b.b(this).d().a();
                if (object == null) {
                    j.a();
                }
                if (!((Boolean)object).booleanValue()) {
                    object = AnimationUtils.loadAnimation((Context)this.m(), (int)2130771986);
                    j.a(object, "animFadein");
                    object.setStartOffset(500L);
                    object.setAnimationListener(new Animation.AnimationListener(){

                        public void onAnimationEnd(Animation animation) {
                            animation = this.a().g;
                            j.a((Object)animation, "dataBinding.myRouteNoticeView");
                            animation.getAnimation().setAnimationListener(null);
                            this.a().g.clearAnimation();
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    this.a().g.startAnimation(object);
                }
            }

            @Override
            public void a(int n2, float f2, int n3) {
            }

            @Override
            public void b(int n2) {
            }

        };
    }

    private final void ai() {
        Object object = this.b;
        if (object == null) {
            j.b("dataBinding");
        }
        object = ((ak)object).c;
        j.a(object, "dataBinding.commuterPager");
        if (((ViewPager)((Object)object)).getAdapter() == null) {
            object = this.b;
            if (object == null) {
                j.b("dataBinding");
            }
            object = ((ak)object).c;
            j.a(object, "dataBinding.commuterPager");
            i i2 = this.s();
            j.a((Object)i2, "childFragmentManager");
            Object object2 = this.c;
            if (object2 == null) {
                j.b("viewModel");
            }
            object2 = ((jp.co.jreast.jreastapp.commuter.commuterpager.d)object2).n();
            jp.co.jreast.jreastapp.commuter.commuterpager.d d2 = this.c;
            if (d2 == null) {
                j.b("viewModel");
            }
            ((ViewPager)((Object)object)).setAdapter(new jp.co.jreast.jreastapp.commuter.commuterpager.a(i2, (q)object2, d2.o()));
        }
    }

    private final void aj() {
        Object object = this.b;
        if (object == null) {
            j.b("dataBinding");
        }
        object = ((ak)object).d;
        Object object2 = this.b;
        if (object2 == null) {
            j.b("dataBinding");
        }
        ((TabLayout)((Object)object)).setupWithViewPager(((ak)object2).c);
        object = new Point();
        object2 = this.o();
        if (object2 == null) {
            j.a();
        }
        j.a(object2, "activity!!");
        object2 = object2.getWindowManager();
        j.a(object2, "activity!!.windowManager");
        object2.getDefaultDisplay().getSize((Point)object);
        int n2 = ((Point)object).x;
        object = this.b;
        if (object == null) {
            j.b("dataBinding");
        }
        ((ak)object).d.setPadding(0, 0, n2 / 2, 0);
        this.al();
        object = this.b;
        if (object == null) {
            j.b("dataBinding");
        }
        if ((object = ((ak)object).d.a(a.a.b.a())) != null && ((TabLayout.f)object).a() == null) {
            ((TabLayout.f)object).a(2131427457);
            object = this.c;
            if (object == null) {
                j.b("viewModel");
            }
            this.e(((jp.co.jreast.jreastapp.commuter.commuterpager.d)object).b());
        }
    }

    private final void ak() {
        this.aj();
        Object object = this.b;
        if (object == null) {
            j.b("dataBinding");
        }
        object = ((ak)object).f;
        Object object2 = this.b;
        if (object2 == null) {
            j.b("dataBinding");
        }
        ((TabLayout)((Object)object)).setupWithViewPager(((ak)object2).c);
        object = this.b;
        if (object == null) {
            j.b("dataBinding");
        }
        object = ((ak)object).c;
        object2 = this.c;
        if (object2 == null) {
            j.b("viewModel");
        }
        ((ViewPager)((Object)object)).a(((jp.co.jreast.jreastapp.commuter.commuterpager.d)object2).b(), false);
        object = this.b;
        if (object == null) {
            j.b("dataBinding");
        }
        ((ak)object).c.a(this.e);
        object = this.b;
        if (object == null) {
            j.b("dataBinding");
        }
        ((ak)object).c.refreshDrawableState();
    }

    private final void al() {
        ak ak2 = this.b;
        if (ak2 == null) {
            j.b("dataBinding");
        }
        if ((ak2 = ak2.d.getChildAt(0)) != null) {
            ak2 = (ViewGroup)ak2;
            int n2 = ak2.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view = ak2.getChildAt(i2);
                if (view != null) {
                    view = (ViewGroup)view;
                    int n3 = view.getChildCount();
                    for (int i3 = 0; i3 < n3; ++i3) {
                        View view2 = view.getChildAt(i3);
                        if (!(view2 instanceof TextView)) continue;
                        TabLayout tabLayout = (TabLayout)this.d(ak.a.commuterPagerTabs);
                        j.a((Object)tabLayout, "commuterPagerTabs");
                        CalligraphyUtils.applyFontToTextView(tabLayout.getContext(), (TextView)view2, "fonts/TT-UDShinGoPro-Bold.ttf");
                    }
                    continue;
                }
                throw new t("null cannot be cast to non-null type android.view.ViewGroup");
            }
            return;
        }
        throw new t("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final /* synthetic */ jp.co.jreast.jreastapp.commuter.commuterpager.d b(b object) {
        object = ((b)object).c;
        if (object == null) {
            j.b("viewModel");
        }
        return object;
    }

    private final void e(int n2) {
        float f2 = n2 == a.a.b.a() ? 1.0f : 0.6f;
        Object object = this.b;
        if (object == null) {
            j.b("dataBinding");
        }
        if ((object = ((ak)object).d.a(a.a.b.a())) == null) {
            j.a();
        }
        j.a(object, "tab!!");
        object = ((TabLayout.f)object).a();
        if (object == null) {
            j.a();
        }
        j.a(object, "tab!!.customView!!");
        object.setAlpha(f2);
    }

    @Override
    public void A() {
        super.A();
        ak ak2 = this.b;
        if (ak2 == null) {
            j.b("dataBinding");
        }
        ak2.c.b(this.e);
    }

    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        Object object4;
        Object object5;
        j.b(object, "inflater");
        if (this.k() != null) {
            object3 = this.k();
            object4 = null;
            if ((object3 = object3 != null ? object3.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null) != null) {
                object5 = this.k();
                object3 = object4;
                if (object5 != null) {
                    object3 = object5.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a());
                }
                if (object3 != null) {
                    this.d = (jp.co.jreast.jreastapp.commuter.f.q)object3;
                } else {
                    throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
                }
            }
        }
        object3 = this.d;
        object4 = this.o();
        if (object4 == null) {
            j.a();
        }
        j.a(object4, "activity!!");
        object5 = this.a;
        if (object5 == null) {
            j.b("viewModelFactory");
        }
        object3 = ((jp.co.jreast.jreastapp.commuter.f.q)object3).a((androidx.f.a.e)object4, (w.b)object5).a(jp.co.jreast.jreastapp.commuter.commuterpager.d.class);
        j.a(object3, "commuterViewModelProvide\u2026gerViewModel::class.java)");
        this.c = (jp.co.jreast.jreastapp.commuter.commuterpager.d)object3;
        object4 = this.c;
        if (object4 == null) {
            j.b("viewModel");
        }
        object5 = ((jp.co.jreast.jreastapp.commuter.commuterpager.d)object4).e();
        object3 = this;
        ((al)object5).a((androidx.lifecycle.j)object3, (androidx.lifecycle.q)}
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    