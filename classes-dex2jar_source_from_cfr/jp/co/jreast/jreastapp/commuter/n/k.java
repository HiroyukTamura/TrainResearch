/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 */
package jp.co.jreast.jreastapp.commuter.n;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.b;
import jp.co.jreast.jreastapp.commuter.m.c;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.q;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.model.FareSettings;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import jp.co.jreast.jreastapp.commuter.n.l;
import jp.co.jreast.jreastapp.commuter.o.d;
import jp.co.jreast.jreastapp.commuter.r.g;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.m;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iJ\u0006\u0010j\u001a\u00020gJ\u000e\u0010k\u001a\u00020g2\u0006\u0010l\u001a\u00020mJ\u000e\u0010n\u001a\u00020o2\u0006\u0010l\u001a\u00020mJ\u000e\u0010p\u001a\u0002022\u0006\u0010l\u001a\u00020mJ\u000e\u0010q\u001a\u0002022\u0006\u0010l\u001a\u00020mJ\u0006\u0010r\u001a\u000202J\u000e\u0010s\u001a\u00020o2\u0006\u0010l\u001a\u00020mJ\u0006\u0010t\u001a\u00020gJ\u0006\u0010u\u001a\u00020gJ\u0006\u0010v\u001a\u00020gJ\u0006\u0010w\u001a\u00020gJ\u0006\u0010x\u001a\u00020gJ\u0006\u0010y\u001a\u00020gJ\u0006\u0010z\u001a\u00020gJ\u0006\u0010{\u001a\u00020gR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0018X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u00101\u001a\b\u0012\u0004\u0012\u0002020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001bR \u0010:\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001b\"\u0004\b<\u0010!R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0017\u0010D\u001a\b\u0012\u0004\u0012\u0002020@\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010CR\u001a\u0010F\u001a\u00020GX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0017\u0010L\u001a\b\u0012\u0004\u0012\u0002020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010OR \u0010P\u001a\b\u0012\u0004\u0012\u00020A0@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010C\"\u0004\bR\u0010SR \u0010T\u001a\b\u0012\u0004\u0012\u00020A0@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010C\"\u0004\bV\u0010SR\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020A0@\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010CR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R$\u0010a\u001a\u00020`2\u0006\u0010_\u001a\u00020`@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e\u00a8\u0006|"}, d2={"Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "randomizer", "Ljp/co/jreast/jreastapp/commuter/common/Randomizer;", "screenCaptor", "Ljp/co/jreast/jreastapp/commuter/util/ScreenCaptor;", "externalStorageRepository", "Ljp/co/jreast/jreastapp/commuter/repository/ExternalStorageRepository;", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "favoriteRouteRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "userSettingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljp/co/jreast/jreastapp/commuter/common/Randomizer;Ljp/co/jreast/jreastapp/commuter/util/ScreenCaptor;Ljp/co/jreast/jreastapp/commuter/repository/ExternalStorageRepository;Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "getAnalyticsProvider", "()Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "setAnalyticsProvider", "(Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "backButtonEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getBackButtonEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "captureButtonEvent", "getCaptureButtonEvent", "closeScreenCaptureNoticeViewEvent", "getCloseScreenCaptureNoticeViewEvent", "setCloseScreenCaptureNoticeViewEvent", "(Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;)V", "currentCharacter", "Ljp/co/jreast/jreastapp/commuter/common/ToresugoCharacters;", "getCurrentCharacter$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/common/ToresugoCharacters;", "setCurrentCharacter$app_productRelease", "(Ljp/co/jreast/jreastapp/commuter/common/ToresugoCharacters;)V", "delayInfoClickEvent", "Landroid/content/Intent;", "getDelayInfoClickEvent$app_productRelease", "getDrawableRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "setDrawableRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;)V", "getExternalStorageRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/ExternalStorageRepository;", "failSavedCaptureImageEvent", "", "getFailSavedCaptureImageEvent", "getFavoriteRouteRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "setFavoriteRouteRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;)V", "openFavoriteRouteRegistrationScreenEvent", "getOpenFavoriteRouteRegistrationScreenEvent", "openScreenCaptureNoticeEvent", "getOpenScreenCaptureNoticeEvent", "setOpenScreenCaptureNoticeEvent", "getRandomizer", "()Ljp/co/jreast/jreastapp/commuter/common/Randomizer;", "registerRouteButtonEnabled", "Landroidx/lifecycle/MutableLiveData;", "", "getRegisterRouteButtonEnabled", "()Landroidx/lifecycle/MutableLiveData;", "registerRouteButtonTextProperty", "getRegisterRouteButtonTextProperty", "route", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "getRoute", "()Ljp/co/jreast/jreastapp/commuter/model/Route;", "setRoute", "(Ljp/co/jreast/jreastapp/commuter/model/Route;)V", "savedCaptureImageEvent", "getSavedCaptureImageEvent", "getScreenCaptor", "()Ljp/co/jreast/jreastapp/commuter/util/ScreenCaptor;", "screenCaptureNoticeCheck", "getScreenCaptureNoticeCheck", "setScreenCaptureNoticeCheck", "(Landroidx/lifecycle/MutableLiveData;)V", "screenCaptureNoticeHidden", "getScreenCaptureNoticeHidden", "setScreenCaptureNoticeHidden", "showRegisterRouteButton", "getShowRegisterRouteButton", "getTranslationRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "getUserSettingsRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "setUserSettingsRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;)V", "value", "Ljp/co/jreast/jreastapp/commuter/skewscroll/RouteCollectionViewConfig;", "viewConfig", "getViewConfig", "()Ljp/co/jreast/jreastapp/commuter/skewscroll/RouteCollectionViewConfig;", "setViewConfig", "(Ljp/co/jreast/jreastapp/commuter/skewscroll/RouteCollectionViewConfig;)V", "captureScreen", "", "view", "Landroidx/recyclerview/widget/RecyclerView;", "checkScreenCaptureNoticeHidden", "delayInfoClick", "line", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;", "getDelayIcon", "Landroid/graphics/drawable/Drawable;", "getDispDelayMinute", "getDispWalkingTime", "getFareValue", "getLineIcon", "hideScreenCaptureNotice", "refreshRegisterRouteButton", "resetCharacter", "sendViewRouteDetailToAnalytics", "tapBackButton", "tapCaptureButton", "tapRegisterRouteButton", "tapScreenCaptureNoticeCloseButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class k
extends v {
    public Route a;
    private final al<Intent> b;
    private final al<Void> c;
    private jp.co.jreast.jreastapp.commuter.skewscroll.c d;
    private final androidx.lifecycle.p<Boolean> e;
    private final androidx.lifecycle.p<String> f;
    private final androidx.lifecycle.p<Boolean> g;
    private final al<Void> h;
    private final al<Void> i;
    private final al<String> j;
    private final al<String> k;
    private androidx.lifecycle.p<Boolean> l;
    private androidx.lifecycle.p<Boolean> m;
    private al<Void> n;
    private al<Void> o;
    private jp.co.jreast.jreastapp.commuter.common.s p;
    private final jp.co.jreast.jreastapp.commuter.common.l q;
    private final g r;
    private final c s;
    private b t;
    private q u;
    private s v;
    private final p w;
    private a x;

    public k(jp.co.jreast.jreastapp.commuter.common.l object, g g2, c c2, b b2, q q2, s s2, p p2, a a2) {
        j.b(object, "randomizer");
        j.b(g2, "screenCaptor");
        j.b(c2, "externalStorageRepository");
        j.b(b2, "drawableRepository");
        j.b(q2, "favoriteRouteRepository");
        j.b(s2, "userSettingsRepository");
        j.b(p2, "translationRepository");
        this.q = object;
        this.r = g2;
        this.s = c2;
        this.t = b2;
        this.u = q2;
        this.v = s2;
        this.w = p2;
        this.x = a2;
        this.b = new al();
        this.c = new al();
        this.d = new d();
        this.e = new androidx.lifecycle.p();
        this.f = new androidx.lifecycle.p();
        this.g = new androidx.lifecycle.p();
        this.h = new al();
        this.i = new al();
        this.j = new al();
        this.k = new al();
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(true);
        this.l = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(false);
        this.m = object;
        this.n = new al();
        this.o = new al();
        this.p = jp.co.jreast.jreastapp.commuter.common.s.e;
        this.e.b(false);
        this.f.b(this.w.a(2131558553));
        this.g.b(true);
    }

    public final Drawable a(RailwayLine railwayLine) {
        j.b(railwayLine, "line");
        return this.t.a(railwayLine);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void a(RecyclerView object) {
        al<String> al2;
        int n2;
        j.b(object, "view");
        object = this.r.a((RecyclerView)object);
        if (object == null) {
            return;
        }
        if (this.s.a((Bitmap)object)) {
            al2 = this.j;
            object = this.w;
            n2 = 2131558460;
        } else {
            al2 = this.k;
            object = this.w;
            n2 = 2131558454;
        }
        al2.b(((p)object).a(n2));
    }

    public final void a(Route route) {
        j.b(route, "<set-?>");
        this.a = route;
    }

    public final void a(jp.co.jreast.jreastapp.commuter.skewscroll.c c2) {
        j.b(c2, "value");
        this.d = c2;
        this.g.b(c2.b());
    }

    public final Drawable b(RailwayLine railwayLine) {
        j.b(railwayLine, "line");
        return this.t.b(railwayLine);
    }

    public final al<Intent> b() {
        return this.b;
    }

    public final al<Void> c() {
        return this.c;
    }

    public final void c(RailwayLine railwayLine) {
        j.b(railwayLine, "line");
        Intent intent = new Intent();
        intent.putExtra(jp.co.jreast.jreastapp.commuter.common.b.x.a(), (Serializable)railwayLine);
        intent.putExtra(jp.co.jreast.jreastapp.commuter.common.b.y.a(), this.d.e());
        this.b.b(intent);
    }

    public final String d(RailwayLine railwayLine) {
        j.b(railwayLine, "line");
        return this.w.a(2131558481, railwayLine.getServiceStatus().getDelayMinute());
    }

    public final Route d() {
        Route route = this.a;
        if (route == null) {
            j.b("route");
        }
        return route;
    }

    public final androidx.lifecycle.p<Boolean> e() {
        return this.e;
    }

    public final String e(RailwayLine railwayLine) {
        j.b(railwayLine, "line");
        boolean bl2 = ((CharSequence)railwayLine.travelTimeInMinutes()).length() == 0;
        if (bl2) {
            return "";
        }
        return this.w.a(2131558633, railwayLine.travelTimeInMinutes());
    }

    public final androidx.lifecycle.p<String> f() {
        return this.f;
    }

    public final androidx.lifecycle.p<Boolean> g() {
        return this.g;
    }

    public final al<Void> h() {
        return this.h;
    }

    public final al<Void> i() {
        return this.i;
    }

    public final al<String> j() {
        return this.j;
    }

    public final al<String> k() {
        return this.k;
    }

    public final androidx.lifecycle.p<Boolean> l() {
        return this.l;
    }

    public final androidx.lifecycle.p<Boolean> m() {
        return this.m;
    }

    public final al<Void> n() {
        return this.n;
    }

    public final al<Void> o() {
        return this.o;
    }

    public final jp.co.jreast.jreastapp.commuter.common.s p() {
        return this.p;
    }

    public final void q() {
        jp.co.jreast.jreastapp.commuter.common.s[] arrs = this.q;
        arrs = jp.co.jreast.jreastapp.commuter.common.s.values();
        this.p = arrs[new Random().nextInt(arrs.length)];
    }

    public final String r() {
        Object object = this.v.b();
        switch (l.a[((Enum)object).ordinal()]) {
            default: {
                throw new m();
            }
            case 2: {
                object = this.a;
                if (object == null) {
                    j.b("route");
                }
                return ((Route)object).fareIcWithSeparator();
            }
            case 1: 
        }
        object = this.a;
        if (object == null) {
            j.b("route");
        }
        return ((Route)object).fareWithSeparator();
    }

    public final void s() {
        androidx.lifecycle.p<Object> p2 = this.e;
        Object object = this.u;
        Object object2 = this.a;
        if (object2 == null) {
            j.b("route");
        }
        p2.a(((q)object).a((Route)object2) ^ true);
        p2 = this.f;
        object = this.w;
        object2 = this.u;
        Route route = this.a;
        if (route == null) {
            j.b("route");
        }
        p2.a((Boolean)((Object)((p)object).a(((q)object2).b(route))));
    }

    public final void t() {
        a a2 = this.x;
        if (a2 != null) {
            a2.g();
        }
        this.c.f();
    }

    public final void u() {
        a a2 = this.x;
        if (a2 != null) {
            Object object = this.a;
            if (object == null) {
                j.b("route");
            }
            Object object2 = ((Route)object).getLines();
            object = new ArrayList();
            object2 = object2.iterator();
            while (object2.hasNext()) {
                Object e2 = object2.next();
                if (!((RailwayLine)e2).isDelayed()) continue;
                object.add(e2);
            }
            a2.a(((List)object).size(), this.d.e());
        }
    }

    public final void v() {
        this.l.b(true);
    }

    public final void w() {
        if (!this.v.m()) {
            this.n.f();
        }
    }

    public final void x() {
        this.h.f();
    }

    public final void y() {
        this.i.f();
    }

    public final void z() {
        Object t2 = this.m.a();
        if (t2 == null) {
            j.a();
        }
        j.a(t2, "screenCaptureNoticeCheck.value!!");
        if (((Boolean)t2).booleanValue()) {
            this.v.l();
        }
        this.o.b(null);
    }
}

