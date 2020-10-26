/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.webkit.WebView
 */
package jp.co.jreast.jreastapp.commuter;

import a.a.b;
import android.app.Application;
import android.webkit.WebView;
import androidx.appcompat.app.e;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.s;
import g.a.a;
import jp.co.jreast.jreastapp.commuter.a;
import jp.co.jreast.jreastapp.commuter.f.o;
import jp.co.jreast.jreastapp.commuter.f.p;
import jp.co.jreast.jreastapp.commuter.f.r;
import kotlin.Metadata;
import kotlin.e.b.j;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Metadata(bv={1, 0, 2}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\n\u001a\u00020\u0005J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0007J\b\u0010\r\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Ljp/co/jreast/jreastapp/commuter/App;", "Ldagger/android/support/DaggerApplication;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "appStateForeground", "", "applicationInjector", "Ljp/co/jreast/jreastapp/commuter/di/AppComponent;", "initTimber", "", "isForeground", "onCreate", "onPause", "onResume", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class App
extends a.a.a.b
implements i {
    private boolean g;

    private final void h() {
        if ("product".equals("dev")) {
            g.a.a.a(new a.a());
        }
    }

    public /* synthetic */ b a() {
        return this.g();
    }

    protected o g() {
        return r.a().a(this).a(new a(this)).a();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        p.a(this);
        this.h();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/TT-UDShinGoPro-Medium.ttf").setFontAttrId(2130903318).build());
        e.a(true);
        if ("product".equals("dev")) {
            WebView.setWebContentsDebuggingEnabled((boolean)true);
        }
        androidx.lifecycle.j j2 = s.a();
        j.a((Object)j2, "ProcessLifecycleOwner.get()");
        j2.g().a(this);
    }

    @androidx.lifecycle.r(a=g.a.ON_PAUSE)
    public final void onPause() {
        this.g = false;
    }

    @androidx.lifecycle.r(a=g.a.ON_RESUME)
    public final void onResume() {
        this.g = true;
    }
}

