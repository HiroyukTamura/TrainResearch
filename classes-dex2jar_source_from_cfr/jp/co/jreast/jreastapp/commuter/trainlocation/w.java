/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Point
 *  android.net.Uri
 *  android.os.Bundle
 *  android.transition.Transition
 *  android.transition.TransitionInflater
 *  android.transition.TransitionSet
 *  android.view.Display
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.WindowManager
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import androidx.f.a.i;
import androidx.f.a.p;
import androidx.lifecycle.q;
import androidx.lifecycle.w;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.io.Serializable;
import java.util.HashMap;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.bg;
import jp.co.jreast.jreastapp.commuter.f.s;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.v;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;
import jp.co.jreast.jreastapp.commuter.webview.g;
import jp.co.jreast.jreastapp.commuter.webview.o;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000*\u0001\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000eJ&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u001bH\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u000eH\u0002J\u0010\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u000204H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u00065"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "Ljp/co/jreast/jreastapp/commuter/main/RootFragmentMainChild;", "()V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTrainLocationPagerBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTrainLocationPagerBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentTrainLocationPagerBinding;)V", "historyPageNumber", "", "onPageChangeListener", "jp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerFragment$onPageChangeListener$1", "Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerFragment$onPageChangeListener$1;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "callBrowser", "", "url", "", "changePage", "page", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "openStore", "railwayLineInformation", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "openWebView", "site", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "setSearchTabAlpha", "position", "setUserVisibleHint", "isVisibleToUser", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class w
extends androidx.f.a.d
implements s,
jp.co.jreast.jreastapp.commuter.main.v {
    public w.b a;
    public bg b;
    private y c;
    private jp.co.jreast.jreastapp.commuter.f.q d;
    private final int e;
    private final e f;
    private HashMap g;

    public w() {
        this.d = new jp.co.jreast.jreastapp.commuter.f.q();
        this.f = new ViewPager.f(){

            @Override
            public void a(int n2) {
                this.d(n2);
                Object object = this.a().f;
                j.a(object, "dataBinding.trainLocationPager");
                object = object.getAdapter();
                if (object != null) {
                    object = ((v)object).e(n2);
                    w.a(this).a((String)object);
                    return;
                }
                throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.trainlocation.TrainLocationPagerAdapter");
            }

            @Override
            public void a(int n2, float f2, int n3) {
            }

            @Override
            public void b(int n2) {
            }
        };
    }

    public static final /* synthetic */ y a(w object) {
        object = ((w)object).c;
        if (object == null) {
            j.b("viewModel");
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void a(RailwayLineInformation railwayLineInformation) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)railwayLineInformation.getSiteUrl()));
        intent.setFlags(268435456);
        try {
            this.a(intent);
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {}
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse((String)railwayLineInformation.getStoreUrl()));
        intent2.setPackage("com.android.vending");
        this.a(intent2);
    }

    private final void a(o object) {
        g g2 = new g();
        Bundle bundle = new Bundle();
        bundle.putSerializable(jp.co.jreast.jreastapp.commuter.common.b.A.a(), (Serializable)object);
        g2.g(bundle);
        g2.a((Object)new TransitionSet().addTransition(TransitionInflater.from((Context)this.m()).inflateTransition(2131755008)));
        g2.b((Object)new TransitionSet().addTransition(TransitionInflater.from((Context)this.m()).inflateTransition(2131755009)));
        object = this.r();
        if (object == null) {
            j.a();
        }
        ((i)object).a().b(2131230942, g2).a((String)null).d();
    }

    private final void c(String string2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)string2));
        this.a(intent);
    }

    private final void d(int n2) {
        float f2 = n2 == this.e ? 1.0f : 0.6f;
        Object object = this.b;
        if (object == null) {
            j.b("dataBinding");
        }
        if ((object = ((bg)object).h.a(this.e)) == null) {
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
        Object object;
        super.A();
        y y2 = this.c;
        if (y2 == null) {
            j.b("viewModel");
        }
        if ((object = this.b) == null) {
            j.b("dataBinding");
        }
        object = ((bg)object).f;
        j.a(object, "dataBinding.trainLocationPager");
        y2.a(((ViewPager)((Object)object)).getCurrentItem());
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
        object3 = ((jp.co.jreast.jreastapp.commuter.f.q)object3).a((androidx.f.a.e)object4, (w.b)object5).a(y.class);
        j.a(object3, "commuterViewModelProvide\u2026gerViewModel::class.java)");
        this.c = (y)object3;
        object3 = this.c;
        if (object3 == null) {
            j.b("viewModel");
        }
        object4 = ((y)object3).b();
        object3 = this;
        ((al)object4).a((androidx.lifecycle.j)object3, (q)}
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    