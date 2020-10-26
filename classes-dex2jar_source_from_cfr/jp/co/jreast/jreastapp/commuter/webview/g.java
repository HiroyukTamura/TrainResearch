/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.webkit.ValueCallback
 *  android.webkit.WebBackForwardList
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package jp.co.jreast.jreastapp.commuter.webview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.w;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.ai;
import jp.co.jreast.jreastapp.commuter.c.ci;
import jp.co.jreast.jreastapp.commuter.c.ck;
import jp.co.jreast.jreastapp.commuter.main.MainActivity;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.webview.WebViewActivity;
import jp.co.jreast.jreastapp.commuter.webview.n;
import kotlin.Metadata;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010,\u001a\u00020-H\u0007J \u0010.\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000200H\u0016J\b\u00103\u001a\u00020-H\u0002J\u0006\u00104\u001a\u00020-J\u0006\u00105\u001a\u00020-J\u000e\u00106\u001a\u00020-2\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020-J\u0006\u0010:\u001a\u00020-J&\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020-H\u0016J+\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u0002082\f\u0010F\u001a\b\u0012\u0004\u0012\u0002000G2\u0006\u0010H\u001a\u00020IH\u0016\u00a2\u0006\u0002\u0010JJ\b\u0010K\u001a\u00020-H\u0016J\u000e\u0010L\u001a\u00020-2\u0006\u0010M\u001a\u00020NJ\u000e\u0010O\u001a\u00020-2\u0006\u0010M\u001a\u00020NJ\u000e\u0010P\u001a\u00020-2\u0006\u0010M\u001a\u00020NJ\u0010\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u000200H\u0016J\u0010\u0010S\u001a\u00020-2\u0006\u0010R\u001a\u000200H\u0016J\u0010\u0010T\u001a\u00020-2\u0006\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u00020-H\u0002J\u0006\u0010X\u001a\u00020-R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006Y"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewFragment;", "Landroidx/fragment/app/Fragment;", "Ljp/co/jreast/jreastapp/commuter/di/Injectable;", "Ljp/co/jreast/jreastapp/commuter/webview/JavaScriptDelegate;", "Ljp/co/jreast/jreastapp/commuter/webview/AudioWaveBeaconDelegate;", "()V", "animDrawable", "Landroid/graphics/drawable/AnimationDrawable;", "getAnimDrawable", "()Landroid/graphics/drawable/AnimationDrawable;", "setAnimDrawable", "(Landroid/graphics/drawable/AnimationDrawable;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/FragmentCommonWebviewBinding;", "getDataBinding", "()Ljp/co/jreast/jreastapp/commuter/databinding/FragmentCommonWebviewBinding;", "setDataBinding", "(Ljp/co/jreast/jreastapp/commuter/databinding/FragmentCommonWebviewBinding;)V", "mainActivity", "Ljp/co/jreast/jreastapp/commuter/main/MainActivity;", "getMainActivity", "()Ljp/co/jreast/jreastapp/commuter/main/MainActivity;", "setMainActivity", "(Ljp/co/jreast/jreastapp/commuter/main/MainActivity;)V", "reloadAnimation", "Landroid/view/animation/Animation;", "removeAnimation", "getRemoveAnimation", "()Landroid/view/animation/Animation;", "setRemoveAnimation", "(Landroid/view/animation/Animation;)V", "translateAnimation", "getTranslateAnimation", "setTranslateAnimation", "viewModel", "Ljp/co/jreast/jreastapp/commuter/webview/CommonWebViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "checkBeacon", "", "checkBeaconWithPermissionCheck", "progressMessage", "", "errorMessage", "denyMessage", "dismissActivity", "doErrorStatusAnimation", "goBackOrFinish", "goBackPages", "step", "", "hideBeaconStatusBar", "hideErrorStatusBar", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "openWebViewModal", "site", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "reloadWebView", "reloadWebViewByErrorView", "saveOffSetScrollPositionJavaScript", "function", "setJavaScript", "settingWebView", "webView", "Landroid/webkit/WebView;", "showBeaconStatusBar", "stopLoadingWebView", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class g
extends androidx.f.a.d
implements jp.co.jreast.jreastapp.commuter.f.s,
jp.co.jreast.jreastapp.commuter.webview.a,
jp.co.jreast.jreastapp.commuter.webview.m {
    public w.b a;
    private HashMap ag;
    public Animation b;
    public Animation c;
    public ai d;
    public MainActivity e;
    public AnimationDrawable f;
    private jp.co.jreast.jreastapp.commuter.webview.j g;
    private Animation h;
    private jp.co.jreast.jreastapp.commuter.f.q i;

    public g() {
        this.i = new jp.co.jreast.jreastapp.commuter.f.q();
    }

    private final void a(WebView webView) {
        webView = webView.getSettings();
        webView.setCacheMode(2);
        webView.setJavaScriptEnabled(true);
        webView.setTextZoom(100);
        webView.setSupportZoom(true);
        webView.setBuiltInZoomControls(true);
        webView.setDisplayZoomControls(false);
        webView.setLoadWithOverviewMode(true);
        webView.setUseWideViewPort(true);
        webView.setSupportMultipleWindows(true);
    }

    private final void ap() {
        Object object = new Animation.AnimationListener(){

            public void onAnimationEnd(Animation object) {
                this.a().setAnimationListener(null);
                g.c(this).a(0);
                object = this.c().d;
                kotlin.e.b.j.a(object, "dataBinding.beaconStatusView");
                ((ViewDataBinding)object).e().clearAnimation();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        Animation animation = this.b;
        if (animation == null) {
            kotlin.e.b.j.b("translateAnimation");
        }
        animation.setAnimationListener((Animation.AnimationListener)object);
        object = this.f;
        if (object == null) {
            kotlin.e.b.j.b("animDrawable");
        }
        object.start();
        object = this.d;
        if (object == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        object = ((ai)object).d;
        kotlin.e.b.j.a(object, "dataBinding.beaconStatusView");
        object = ((ViewDataBinding)object).e();
        animation = this.b;
        if (animation == null) {
            kotlin.e.b.j.b("translateAnimation");
        }
        object.startAnimation(animation);
    }

    private final void aq() {
        Object object;
        if (Build.VERSION.SDK_INT == 24 || Build.VERSION.SDK_INT == 25) {
            object = this.o();
            if (object == null) {
                kotlin.e.b.j.a();
            }
            kotlin.e.b.j.a(object, "activity!!");
            object.getWindow().setBackgroundDrawableResource(17170444);
        }
        if ((object = this.r()) == null) {
            kotlin.e.b.j.a();
        }
        ((androidx.f.a.i)object).b();
    }

    public static final /* synthetic */ jp.co.jreast.jreastapp.commuter.webview.j c(g object) {
        object = ((g)object).g;
        if (object == null) {
            kotlin.e.b.j.b("viewModel");
        }
        return object;
    }

    public static final /* synthetic */ Animation d(g g2) {
        g2 = g2.h;
        if (g2 == null) {
            kotlin.e.b.j.b("reloadAnimation");
        }
        return g2;
    }

    @Override
    public void A() {
        super.A();
        if (this.g != null) {
            jp.co.jreast.jreastapp.commuter.webview.j j2 = this.g;
            if (j2 == null) {
                kotlin.e.b.j.b("viewModel");
            }
            j2.a(false);
            j2 = this.g;
            if (j2 == null) {
                kotlin.e.b.j.b("viewModel");
            }
            j2.R();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public View a(LayoutInflater object, ViewGroup object2, Bundle object3) {
        kotlin.e.b.j.b(object, "inflater");
        if (this.k() != null && (object3 = (object3 = this.k()) != null ? object3.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null) != null) {
            object3 = this.k();
            object3 = object3 != null ? object3.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.a.a()) : null;
            if (object3 == null) throw new kotlin.t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            this.i = (jp.co.jreast.jreastapp.commuter.f.q)object3;
        }
        object3 = this.i;
        Object object4 = this.o();
        if (object4 == null) {
            kotlin.e.b.j.a();
        }
        kotlin.e.b.j.a(object4, "activity!!");
        w.b b2 = this.a;
        if (b2 == null) {
            kotlin.e.b.j.b("viewModelFactory");
        }
        object3 = ((jp.co.jreast.jreastapp.commuter.f.q)object3).a((androidx.f.a.e)object4, b2).a(jp.co.jreast.jreastapp.commuter.webview.j.class);
        kotlin.e.b.j.a(object3, "commuterViewModelProvide\u2026WebViewModel::class.java)");
        this.g = (jp.co.jreast.jreastapp.commuter.webview.j)object3;
        if (this.k() != null && (object3 = (object3 = this.k()) != null ? object3.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.A.a()) : null) != null) {
            object3 = this.k();
            object3 = object3 != null ? object3.getSerializable(jp.co.jreast.jreastapp.commuter.common.b.A.a()) : null;
            if (object3 == null) throw new kotlin.t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.webview.Site");
            object3 = (jp.co.jreast.jreastapp.commuter.webview.o)object3;
        } else {
            object3 = new jp.co.jreast.jreastapp.commuter.webview.o("", "", 0, null, 0, null, 0, null, 0, null, 1020, null);
        }
        object4 = this.g;
        if (object4 == null) {
            kotlin.e.b.j.b("viewModel");
        }
        ((jp.co.jreast.jreastapp.commuter.webview.j)object4).a((jp.co.jreast.jreastapp.commuter.webview.o)object3);
        object = ai.a((LayoutInflater)object, (ViewGroup)object2, false);
        kotlin.e.b.j.a(object, "FragmentCommonWebviewBin\u2026flater, container, false)");
        object2 = this.d = object;
        if (object2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        object = this;
        ((ViewDataBinding)object2).a((androidx.lifecycle.j)object);
        object2 = this.d;
        if (object2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        if ((object4 = this.g) == null) {
            kotlin.e.b.j.b("viewModel");
        }
        ((ai)object2).a((jp.co.jreast.jreastapp.commuter.webview.j)object4);
        object2 = this.d;
        if (object2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        object2 = ((ai)object2).o;
        kotlin.e.b.j.a(object2, "dataBinding.webview");
        this.a((WebView)object2);
        object2 = this.d;
        if (object2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        object2 = ((ai)object2).o;
        kotlin.e.b.j.a(object2, "dataBinding.webview");
        object4 = this.g;
        if (object4 == null) {
            kotlin.e.b.j.b("viewModel");
        }
        object2.setWebViewClient((WebViewClient)new jp.co.jreast.jreastapp.commuter.webview.e((jp.co.jreast.jreastapp.commuter.webview.j)object4, null, 0L, 6, null));
        object2 = this.d;
        if (object2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        object2 = ((ai)object2).o;
        kotlin.e.b.j.a(object2, "dataBinding.webview");
        object2.setWebChromeClient((WebChromeClient)new jp.co.jreast.jreastapp.commuter.webview.d());
        object2 = this.d;
        if (object2 == null) {
            kotlin.e.b.j.b("dataBinding");
        }
        ((ai)object2).o.loadUrl(((jp.co.jreast.jreastapp.commuter.webview.o)object3).b(), new jp.co.jreast.jreastapp.commuter.webview.c(null, 1, null).a());
        object2 = this.g;
        if (object2 == null) {
            kotlin.e.b.j.b("viewModel");
        }
        ((jp.co.jreast.jreastapp.commuter.webview.j)object2).b((jp.co.jreast.jreastapp.commuter.webview.o)object3);
        ((jp.co.jreast.jreastapp.commuter.webview.j)object2).a(8);
        ((jp.co.jreast.jreastapp.commuter.webview.j)object2).b(8);
        ((jp.co.jreast.jreastapp.commuter.webview.j)object2).g().a((androidx.lifecycle.j)object, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    