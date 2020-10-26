/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package jp.co.jreast.jreastapp.commuter.webview;

import android.graphics.drawable.Drawable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p;
import androidx.lifecycle.v;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.webview.b;
import jp.co.jreast.jreastapp.commuter.webview.o;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000fJ\u0006\u0010/\u001a\u00020-J\u0006\u00100\u001a\u00020\u0003J\u000e\u00101\u001a\u00020-2\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u00020'2\b\u0010.\u001a\u0004\u0018\u00010\u000fJ\u0010\u00105\u001a\u00020'2\b\u00106\u001a\u0004\u0018\u00010\u000fJ\u0006\u00107\u001a\u00020-J\u0006\u00108\u001a\u00020-R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u001a\u0010&\u001a\u00020'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00069"}, d2={"Ljp/co/jreast/jreastapp/commuter/webview/WebViewModel;", "Landroidx/lifecycle/ViewModel;", "commonJavaScriptInterface", "Ljp/co/jreast/jreastapp/commuter/webview/CommonJavaScriptInterface;", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "(Ljp/co/jreast/jreastapp/commuter/webview/CommonJavaScriptInterface;Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;)V", "_faviconDrawable", "Landroidx/lifecycle/MutableLiveData;", "Landroid/graphics/drawable/Drawable;", "_visibilityFavicon", "", "_visibilityReload", "callBrowserEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "", "getCallBrowserEvent$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "callReloadEvent", "Ljava/lang/Void;", "getCallReloadEvent$app_productRelease", "callRemoveAccessLogModalEvent", "getCallRemoveAccessLogModalEvent$app_productRelease", "dismissWebViewEvent", "getDismissWebViewEvent$app_productRelease", "getDrawableRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "faviconDrawable", "Landroidx/lifecycle/LiveData;", "getFaviconDrawable", "()Landroidx/lifecycle/LiveData;", "titleTextProperty", "getTitleTextProperty", "()Landroidx/lifecycle/MutableLiveData;", "visibilityFavicon", "getVisibilityFavicon", "visibilityReload", "getVisibilityReload", "visibleHint", "", "getVisibleHint", "()Z", "setVisibleHint", "(Z)V", "callBrowser", "", "strUrl", "callRemoveAccessLogModal", "getJavaScriptInterface", "set", "site", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "shouldCallBrowser", "shouldCallRemoveAccessLogModal", "url", "tapCloseButton", "tapReloadButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class r
extends v {
    private final p<String> a;
    private final al<Void> b;
    private final al<String> c;
    private final al<Void> d;
    private final al<Void> e;
    private final p<Integer> f;
    private final p<Drawable> g;
    private final p<Integer> h;
    private final LiveData<Integer> i;
    private final LiveData<Drawable> j;
    private final LiveData<Integer> k;
    private boolean l;
    private final b m;
    private final jp.co.jreast.jreastapp.commuter.m.b n;

    public r(b object, jp.co.jreast.jreastapp.commuter.m.b b2) {
        j.b(object, "commonJavaScriptInterface");
        j.b(b2, "drawableRepository");
        this.m = object;
        this.n = b2;
        object = new p();
        ((p)object).b("");
        this.a = object;
        this.b = new al();
        this.c = new al();
        this.d = new al();
        this.e = new al();
        object = new p();
        ((p)object).b(8);
        this.f = object;
        this.g = new p();
        this.h = new p();
        this.i = this.f;
        this.j = this.g;
        this.k = this.h;
        this.m.a(this);
    }

    public final void a(String string2) {
        j.b(string2, "strUrl");
        this.c.b(string2);
    }

    public final void a(o o2) {
        j.b(o2, "site");
        this.a.a(o2.a());
        this.f.b(o2.c());
        if (o2.c() == 0 && o2.d() != null) {
            this.g.b(this.n.a(o2.d()));
        }
        this.h.b(o2.i());
    }

    public final void a(boolean bl2) {
        this.l = bl2;
    }

    public final p<String> b() {
        return this.a;
    }

    public final boolean b(String string2) {
        int n2;
        return string2 != null && ((n2 = string2.hashCode()) != -840834318 ? n2 == 611994717 && string2.equals("https://mixpanel.com/legal/privacy-policy/") : string2.equals("http://www.jreast.co.jp/site/privacy.html"));
    }

    public final al<Void> c() {
        return this.b;
    }

    public final boolean c(String string2) {
        return j.a((Object)string2, (Object)"android://removeAccessLog");
    }

    public final al<String> d() {
        return this.c;
    }

    public final al<Void> e() {
        return this.d;
    }

    public final al<Void> f() {
        return this.e;
    }

    public final LiveData<Integer> g() {
        return this.i;
    }

    public final LiveData<Drawable> h() {
        return this.j;
    }

    public final LiveData<Integer> i() {
        return this.k;
    }

    public final boolean j() {
        return this.l;
    }

    public final b k() {
        return this.m;
    }

    public final void l() {
        this.b.f();
    }

    public final void m() {
        this.e.f();
    }

    public final void n() {
        this.d.f();
    }
}

