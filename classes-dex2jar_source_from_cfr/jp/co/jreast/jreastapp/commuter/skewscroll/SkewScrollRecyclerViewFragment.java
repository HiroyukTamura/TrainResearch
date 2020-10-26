/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Point
 *  android.os.Bundle
 *  android.os.Handler
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.Display
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.WindowManager
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 */
package jp.co.jreast.jreastapp.commuter.skewscroll;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.ak;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.bc;
import jp.co.jreast.jreastapp.commuter.common.view.LockableScrollView;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.model.Route;
import kotlin.Metadata;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0015\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\"H\u0002J\u0010\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020%H\u0002J\b\u00105\u001a\u00020\"H\u0002J\u0010\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\u0013H\u0002J\b\u00108\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00069"}, d2={"Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "()V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentSkewscrollRecyclerviewBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentSkewscrollRecyclerviewBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentSkewscrollRecyclerviewBinding;)V", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "setGestureDetector", "(Landroid/view/GestureDetector;)V", "isPreviousOrNextTransition", "", "mOnGestureListener", "jp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewFragment$mOnGestureListener$1", "Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewFragment$mOnGestureListener$1;", "scale", "", "viewModel", "Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "doAnimationFadeinWhenPreviousNextSearching", "", "doAnimationFadeoutWhenPreviousNextSearching", "getActionBarHeight", "", "getBottomNavigationViewHeight", "getRightPaddingOfRecyclerView", "getViewHeight", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "resetScrollPosition", "setCurrentDateLinePosition", "position", "setRuleLines", "setScrollable", "searching", "showPreviousNextButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class SkewScrollRecyclerViewFragment
extends androidx.f.a.d
implements s {
    public w.b a;
    public bc b;
    public GestureDetector c;
    private jp.co.jreast.jreastapp.commuter.f.q d;
    private jp.co.jreast.jreastapp.commuter.skewscroll.h e;
    private float f;
    private boolean g;
    private final b h;
    private HashMap i;

    public SkewScrollRecyclerViewFragment() {
        this.d = new jp.co.jreast.jreastapp.commuter.f.q();
        this.g = true;
        this.h = new GestureDetector.SimpleOnGestureListener(){

            /*
             * Enabled aggressive block sorting
             */
            public boolean onScroll(MotionEvent object, MotionEvent object2, float f2, float f3) {
                block8 : {
                    void var1_3;
                    boolean bl2;
                    block7 : {
                        jp.co.jreast.jreastapp.commuter.skewscroll.h h2;
                        boolean bl3;
                        void var3_6;
                        block6 : {
                            kotlin.e.b.j.b(object, "e1");
                            kotlin.e.b.j.b(h2, "e2");
                            if (this.g) {
                                return false;
                            }
                            bl3 = ((RecyclerView)this.c(ak.a.recyclerView)).computeHorizontalScrollRange() - ((RecyclerView)this.c(ak.a.recyclerView)).computeHorizontalScrollExtent() == ((RecyclerView)this.c(ak.a.recyclerView)).computeHorizontalScrollOffset();
                            if (((RecyclerView)this.c(ak.a.recyclerView)).computeHorizontalScrollOffset() > 0 || !(var3_6 < (float)-110) || this.g) break block6;
                            SkewScrollRecyclerViewFragment skewScrollRecyclerViewFragment = this;
                            h2 = this.e;
                            if (h2 == null) {
                                kotlin.e.b.j.a();
                            }
                            bl2 = h2.A();
                            break block7;
                        }
                        if (!bl3 || !(var3_6 > (float)75) || this.g) break block8;
                        SkewScrollRecyclerViewFragment skewScrollRecyclerViewFragment = this;
                        h2 = this.e;
                        if (h2 == null) {
                            kotlin.e.b.j.a();
                        }
                        bl2 = h2.B();
                    }
                    SkewScrollRecyclerViewFragment.b((SkewScrollRecyclerViewFragment)var1_3, bl2);
                    return true;
                }
                return false;
            }
        };
    }

    private final void a(boolean bl2) {
        Object object = this.b;
        if (object == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        object = ((bc)object).k;
        kotlin.e.b.j.a(object, "dataBinding.recyclerView");
        ((RecyclerView)object).setLayoutFrozen(bl2);
    }

    private final void aj() {
        int n2 = this.q().getDimensionPixelSize(2131099989);
        int n3 = this.q().getDimensionPixelSize(2131099973);
        int n4 = (int)((float)10 * this.f + 0.5f);
        jp.co.jreast.jreastapp.commuter.skewscroll.h h2 = this.e;
        if (h2 == null) {
            kotlin.e.b.j.a();
        }
        int n5 = h2.F();
        h2 = (LinearLayout)this.c(ak.a.ruleLines);
        kotlin.e.b.j.a((Object)h2, "ruleLines");
        h2 = h2.getLayoutParams();
        if (h2 != null) {
            ((ViewGroup.MarginLayoutParams)h2).setMargins(0, n2 * 2 + n3 + n4 + n5, 0, 0);
            ((LinearLayout)this.c(ak.a.ruleLines)).removeAllViews();
            h2 = this.e;
            if (h2 == null) {
                kotlin.e.b.j.a();
            }
            if (1 <= (n3 = h2.G())) {
                n2 = 1;
                do {
                    h2 = View.inflate((Context)this.m(), (int)2131427449, null);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
                    float f2 = 15;
                    jp.co.jreast.jreastapp.commuter.skewscroll.h h3 = this.e;
                    if (h3 == null) {
                        kotlin.e.b.j.a();
                    }
                    layoutParams.setMargins(0, 0, 0, (int)(f2 * h3.e()) - 1);
                    ((LinearLayout)this.c(ak.a.ruleLines)).addView((View)h2, (ViewGroup.LayoutParams)layoutParams);
                    if (n2 == n3) break;
                    ++n2;
                } while (true);
            }
            return;
        }
        throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final int ak() {
        Point point = new Point();
        androidx.f.a.e e2 = this.o();
        if (e2 == null) {
            kotlin.e.b.j.a();
        }
        kotlin.e.b.j.a((Object)e2, "activity!!");
        e2 = e2.getWindowManager();
        kotlin.e.b.j.a((Object)e2, "activity!!.windowManager");
        e2.getDefaultDisplay().getSize(point);
        int n2 = this.c();
        int n3 = this.al();
        return point.y - n2 - n3;
    }

    private final int al() {
        Object object = this.o();
        if (object == null) {
            kotlin.e.b.j.a();
        }
        object = (TabLayout)object.findViewById(2131231231);
        kotlin.e.b.j.a(object, "bottomNavigationView");
        return object.getLayoutParams().height;
    }

    private final int am() {
        Point point = new Point();
        androidx.f.a.e e2 = this.o();
        if (e2 == null) {
            kotlin.e.b.j.a();
        }
        kotlin.e.b.j.a((Object)e2, "activity!!");
        e2 = e2.getWindowManager();
        kotlin.e.b.j.a((Object)e2, "activity!!.windowManager");
        e2.getDefaultDisplay().getSize(point);
        return point.x - (int)((float)84 * this.f + 0.5f);
    }

    private final void an() {
        bc bc2 = this.b;
        if (bc2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        bc2.k.a(new RecyclerView.m(){

            @Override
            public void a(boolean bl2) {
            }

            @Override
            public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
                kotlin.e.b.j.b(recyclerView, "rv");
                kotlin.e.b.j.b((Object)motionEvent, "e");
                this.b().onTouchEvent(motionEvent);
                return false;
            }

            @Override
            public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
                kotlin.e.b.j.b(recyclerView, "rv");
                kotlin.e.b.j.b((Object)motionEvent, "e");
            }
        });
    }

    private final void ao() {
        Animation animation = AnimationUtils.loadAnimation((Context)((Context)this.o()), (int)2130771988);
        animation.setAnimationListener(new Animation.AnimationListener(){

            public void onAnimationEnd(Animation object) {
                object = this.e;
                if (object != null) {
                    ((jp.co.jreast.jreastapp.commuter.skewscroll.h)object).a(true);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        bc bc2 = this.b;
        if (bc2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        bc2 = bc2.g;
        kotlin.e.b.j.a((Object)bc2, "dataBinding.isNotFounded");
        bc2.setVisibility(4);
        bc2 = this.b;
        if (bc2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        bc2.m.startAnimation(animation);
        bc2 = this.b;
        if (bc2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        bc2.j.startAnimation(animation);
        bc2 = this.b;
        if (bc2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        bc2.h.startAnimation(animation);
    }

    private final void ap() {
        Animation animation = AnimationUtils.loadAnimation((Context)((Context)this.o()), (int)2130771986);
        bc bc2 = this.b;
        if (bc2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        bc2.m.startAnimation(animation);
        bc2 = this.b;
        if (bc2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        bc2.j.startAnimation(animation);
        bc2 = this.b;
        if (bc2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        bc2.h.startAnimation(animation);
    }

    private final void aq() {
        new Handler().postDelayed(new Runnable(){

            @Override
            public final void run() {
                this.a().k.b(0);
            }
        }, 0L);
    }

    public static final /* synthetic */ void b(SkewScrollRecyclerViewFragment skewScrollRecyclerViewFragment, boolean bl2) {
        skewScrollRecyclerViewFragment.g = bl2;
    }

    private final void d(int n2) {
        int n3 = this.q().getDimensionPixelSize(2131099989);
        int n4 = this.q().getDimensionPixelSize(2131099973);
        int n5 = this.q().getDimensionPixelSize(2131099786);
        LinearLayout linearLayout = (LinearLayout)this.c(ak.a.currentDateLine);
        kotlin.e.b.j.a((Object)linearLayout, "currentDateLine");
        linearLayout = linearLayout.getLayoutParams();
        if (linearLayout != null) {
            ((ViewGroup.MarginLayoutParams)linearLayout).setMargins(0, n3 * 2 + n4 - n5 + n2, 0, 0);
            this.aj();
            return;
        }
        throw new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        Object object4;
        kotlin.e.b.j.b(object, "inflater");
        object3 = this.q();
        kotlin.e.b.j.a(object3, "resources");
        this.f = object3.getDisplayMetrics().density;
        this.c = new GestureDetector((Context)this.o(), (GestureDetector.OnGestureListener)this.h);
        if (this.k() != null) {
            object3 = this.k();
            object4 = null;
            if ((object3 = object3 != null ? object3.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null) != null) {
                Bundle bundle = this.k();
                object3 = object4;
                if (bundle != null) {
                    object3 = bundle.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a());
                }
                if (object3 == null) {
                    throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
                }
                this.d = (jp.co.jreast.jreastapp.commuter.f.q)object3;
            }
        }
        if (this.u() instanceof jp.co.jreast.jreastapp.commuter.p.b) {
            object3 = this.d;
            object4 = this.o();
            if (object4 == null) {
                kotlin.e.b.j.a();
            }
            kotlin.e.b.j.a(object4, "activity!!");
            w.b b2 = this.a;
            if (b2 == null) {
                kotlin.e.b.j.b("viewModelFactory");
            }
            object4 = ((jp.co.jreast.jreastapp.commuter.f.q)object3).a((androidx.f.a.e)object4, b2);
            object3 = jp.co.jreast.jreastapp.commuter.p.f.class;
        } else {
            object3 = this.d;
            object4 = this.o();
            if (object4 == null) {
                kotlin.e.b.j.a();
            }
            kotlin.e.b.j.a(object4, "activity!!");
            w.b b3 = this.a;
            if (b3 == null) {
                kotlin.e.b.j.b("viewModelFactory");
            }
            object4 = ((jp.co.jreast.jreastapp.commuter.f.q)object3).a((androidx.f.a.e)object4, b3);
            object3 = jp.co.jreast.jreastapp.commuter.o.h.class;
        }
        object3 = (jp.co.jreast.jreastapp.commuter.skewscroll.h)((w)object4).a(object3);
        this.e = object3;
        object = bc.a((LayoutInflater)object, (ViewGroup)object2, false);
        kotlin.e.b.j.a(object, "FragmentSkewscrollRecycl\u2026flater, container, false)");
        object2 = this.b = object;
        if (object2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        object = this;
        ((ViewDataBinding)object2).a((androidx.lifecycle.j)object);
        object2 = this.e;
        if (object2 != null) {
            object3 = this.b;
            if (object3 == null) {
                kotlin.e.b.j.b("dataBinding");
            }
            ((bc)object3).a(this.e);
            int n2 = this.ak();
            ((jp.co.jreast.jreastapp.commuter.skewscroll.h)object2).a(n2);
            object3 = this.b;
            if (object3 == null) {
                kotlin.e.b.j.b("dataBinding");
            }
            ((bc)object3).m.setScrollingEnabled(false);
            object3 = this.b;
            if (object3 == null) {
                kotlin.e.b.j.b("dataBinding");
            }
            if ((object3 = ((bc)object3).j()) == null) {
                kotlin.e.b.j.a();
            }
            if ((object4 = this.o()) == null) {
                kotlin.e.b.j.a();
            }
            kotlin.e.b.j.a(object4, "activity!!");
            object4 = (Context)object4;
            kotlin.e.b.j.a(object3, "viewModel");
            object3 = new jp.co.jreast.jreastapp.commuter.skewscroll.g((Context)object4, (jp.co.jreast.jreastapp.commuter.skewscroll.h)object3, n2, null, 8, null);
            object4 = this.b;
            if (object4 == null) {
                kotlin.e.b.j.b("dataBinding");
            }
            object4 = ((bc)object4).k;
            kotlin.e.b.j.a(object4, "dataBinding.recyclerView");
            ((RecyclerView)object4).setAdapter((RecyclerView.a)object3);
            ((jp.co.jreast.jreastapp.commuter.skewscroll.h)object2).x().a((androidx.lifecycle.j)object, }
    }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    