/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.webkit.ValueCallback
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package jp.co.jreast.jreastapp.commuter.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.c.aa;
import jp.co.jreast.jreastapp.commuter.commuterpager.settings.RemoveAccessLogActivity;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.webview.m;
import jp.co.jreast.jreastapp.commuter.webview.o;
import jp.co.jreast.jreastapp.commuter.webview.q;
import jp.co.jreast.jreastapp.commuter.webview.r;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.t;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001aJ\u0006\u0010!\u001a\u00020\u001aJ\u0006\u0010\"\u001a\u00020\u001aJ\b\u0010#\u001a\u00020\u001aH\u0016J\u0012\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\u001aH\u0014J\b\u0010(\u001a\u00020\u001aH\u0014J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001fH\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001fH\u0016J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u00060"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/WebViewActivity;", "Ljp/co/jreast/jreastapp/commuter/base/CommuterActivity;", "Landroidx/lifecycle/LifecycleOwner;", "Ldagger/android/support/HasSupportFragmentInjector;", "Ljp/co/jreast/jreastapp/commuter/webview/JavaScriptDelegate;", "()V", "androidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "commuterViewModelProviders", "Ljp/co/jreast/jreastapp/commuter/di/CommuterViewModelProviders;", "dataBinding", "Ljp/co/jreast/jreastapp/commuter/databinding/ActivityWebviewBinding;", "viewModel", "Ljp/co/jreast/jreastapp/commuter/webview/WebViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "callBrowser", "strUrl", "", "callReload", "callRemoveAccessLogModal", "dismissSelectSetting", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "saveOffSetScrollPositionJavaScript", "function", "setJavaScript", "settingWebView", "webView", "Landroid/webkit/WebView;", "supportFragmentInjector", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class WebViewActivity
extends jp.co.jreast.jreastapp.commuter.b.a
implements a.a.a.d,
androidx.lifecycle.j,
m {
    public a.a.e<androidx.f.a.d> k;
    public w.b l;
    private r m;
    private jp.co.jreast.jreastapp.commuter.f.q n;
    private aa o;

    public WebViewActivity() {
        this.n = new jp.co.jreast.jreastapp.commuter.f.q();
    }

    public static final /* synthetic */ aa a(WebViewActivity object) {
        object = ((WebViewActivity)object).o;
        if (object == null) {
            j.b("dataBinding");
        }
        return object;
    }

    private final void a(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        j.a((Object)webSettings, "webView.settings");
        webSettings.setCacheMode(2);
        webSettings = webView.getSettings();
        j.a((Object)webSettings, "webView.settings");
        webSettings.setJavaScriptEnabled(true);
        webSettings = webView.getSettings();
        j.a((Object)webSettings, "webView.settings");
        webSettings.setTextZoom(100);
        webView.getSettings().setSupportZoom(true);
        webSettings = webView.getSettings();
        j.a((Object)webSettings, "webView.settings");
        webSettings.setBuiltInZoomControls(true);
        webSettings = webView.getSettings();
        j.a((Object)webSettings, "webView.settings");
        webSettings.setDisplayZoomControls(false);
        webSettings = webView.getSettings();
        j.a((Object)webSettings, "webView.settings");
        webSettings.setLoadWithOverviewMode(true);
        webSettings = webView.getSettings();
        j.a((Object)webSettings, "webView.settings");
        webSettings.setUseWideViewPort(true);
        webView.getSettings().setSupportMultipleWindows(true);
    }

    public final void a(String string2) {
        j.b(string2, "strUrl");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)string2));
        this.startActivity(intent);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext((Context)CalligraphyContextWrapper.wrap(context));
    }

    @Override
    public void c(final String string2) {
        j.b(string2, "function");
        this.runOnUiThread(new Runnable(){

            @Override
            public final void run() {
                WebViewActivity.a((WebViewActivity)this).h.evaluateJavascript(string2, null);
            }
        });
    }

    public /* synthetic */ a.a.b c_() {
        return this.l();
    }

    @Override
    public void d(String string2) {
        j.b(string2, "function");
    }

    public a.a.e<androidx.f.a.d> l() {
        a.a.e<androidx.f.a.d> e2 = this.k;
        if (e2 == null) {
            j.b("androidInjector");
        }
        return e2;
    }

    public final void m() {
        this.finish();
    }

    public final void n() {
        this.startActivityForResult(new Intent((Context)this, RemoveAccessLogActivity.class), jp.co.jreast.jreastapp.commuter.r.c.r.a());
    }

    public final void o() {
        aa aa2 = this.o;
        if (aa2 == null) {
            j.b("dataBinding");
        }
        aa2.h.reload();
    }

    @Override
    public void onBackPressed() {
        aa aa2 = this.o;
        if (aa2 == null) {
            j.b("dataBinding");
        }
        if (aa2.h.canGoBack()) {
            aa2 = this.o;
            if (aa2 == null) {
                j.b("dataBinding");
            }
            aa2.h.goBack();
            return;
        }
        super.onBackPressed();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = f.a(this, 2131427369);
        j.a(object, "DataBindingUtil.setConte\u2026.layout.activity_webview)");
        this.o = (aa)object;
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a()) != null) {
            object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.a.a());
            if (object == null) throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.di.CommuterViewModelProviders");
            this.n = (jp.co.jreast.jreastapp.commuter.f.q)object;
        }
        object = this.n;
        Object object2 = this;
        Object object3 = this.l;
        if (object3 == null) {
            j.b("viewModelFactory");
        }
        object = ((jp.co.jreast.jreastapp.commuter.f.q)object).a((androidx.f.a.e)object2, (w.b)object3).a(r.class);
        j.a(object, "commuterViewModelProvide\u2026WebViewModel::class.java)");
        this.m = (r)object;
        if (this.getIntent() != null && this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.A.a()) != null) {
            object = this.getIntent().getSerializableExtra(jp.co.jreast.jreastapp.commuter.common.b.A.a());
            if (object == null) throw new t("null cannot be cast to non-null type jp.co.jreast.jreastapp.commuter.webview.Site");
            object = (o)object;
        } else {
            object = new o("", "", 0, null, 0, null, 0, null, 0, null, 1020, null);
        }
        object2 = this.o;
        if (object2 == null) {
            j.b("dataBinding");
        }
        ((aa)object2).h.loadUrl(((o)object).b());
        object2 = this.o;
        if (object2 == null) {
            j.b("dataBinding");
        }
        object2 = ((aa)object2).h;
        j.a(object2, "dataBinding.webview");
        object3 = this.m;
        if (object3 == null) {
            j.b("viewModel");
        }
        object2.setWebViewClient((WebViewClient)new q((r)object3));
        object2 = this.o;
        if (object2 == null) {
            j.b("dataBinding");
        }
        object2 = ((aa)object2).h;
        j.a(object2, "dataBinding.webview");
        this.a((WebView)object2);
        object2 = this.o;
        if (object2 == null) {
            j.b("dataBinding");
        }
        object2 = ((aa)object2).h;
        object3 = this.m;
        if (object3 == null) {
            j.b("viewModel");
        }
        object3 = ((r)object3).k();
        ((jp.co.jreast.jreastapp.commuter.webview.b)object3).a(this);
        object2.addJavascriptInterface(object3, "android");
        object3 = this.m;
        if (object3 == null) {
            j.b("viewModel");
        }
        ((r)object3).a((o)object);
        al<Void> al2 = ((r)object3).c();
        object2 = this;
        al2.a((androidx.lifecycle.j)object2, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    