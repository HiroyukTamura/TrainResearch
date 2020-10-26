/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.a;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import b.a.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.m.b;
import jp.co.jreast.jreastapp.commuter.m.l;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import kotlin.Metadata;
import kotlin.a.af;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\rJ\b\u0010D\u001a\u00020BH\u0002J\u000e\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020GJ\u000e\u0010H\u001a\u00020I2\u0006\u0010F\u001a\u00020GJ\u000e\u0010J\u001a\u00020\u00122\u0006\u0010F\u001a\u00020GJ\u000e\u0010K\u001a\u00020I2\u0006\u0010F\u001a\u00020GJ\b\u0010L\u001a\u00020\rH\u0002J\u0010\u0010M\u001a\u00020B2\u0006\u0010N\u001a\u00020OH\u0002J\u0006\u0010P\u001a\u00020BR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0'8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\r0'8F\u00a2\u0006\u0006\u001a\u0004\b3\u0010)R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\r0'8F\u00a2\u0006\u0006\u001a\u0004\b5\u0010)R#\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110'8F\u00a2\u0006\u0006\u001a\u0004\b7\u0010)R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010@\u00a8\u0006Q"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "serviceStatusRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkServiceStatusRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;Ljp/co/jreast/jreastapp/commuter/repository/NetworkServiceStatusRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "_errorServiceStatusVisibleProperty", "Landroidx/lifecycle/MutableLiveData;", "", "_normalServiceStatusVisibleProperty", "_serviceStatusIndicatorVisibleProperty", "_serviceStatusMapLiveData", "", "", "Ljp/co/jreast/jreastapp/commuter/model/ServiceStatus;", "getAnalyticsProvider", "()Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "setAnalyticsProvider", "(Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "clearServiceStatusEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getClearServiceStatusEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "delayInfoClickEvent", "Landroid/content/Intent;", "getDelayInfoClickEvent$app_productRelease", "getDrawableRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "setDrawableRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;)V", "errorServiceStatusAnimationEvent", "getErrorServiceStatusAnimationEvent$app_productRelease", "errorServiceStatusVisibleProperty", "Landroidx/lifecycle/LiveData;", "getErrorServiceStatusVisibleProperty", "()Landroidx/lifecycle/LiveData;", "favoriteRoute", "Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;", "getFavoriteRoute", "()Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;", "setFavoriteRoute", "(Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;)V", "normalServiceStatusAnimationEvent", "getNormalServiceStatusAnimationEvent$app_productRelease", "normalServiceStatusVisibleProperty", "getNormalServiceStatusVisibleProperty", "serviceStatusIndicatorVisibleProperty", "getServiceStatusIndicatorVisibleProperty", "serviceStatusMapLiveData", "getServiceStatusMapLiveData", "getServiceStatusRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/NetworkServiceStatusRepository;", "setServiceStatusRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/NetworkServiceStatusRepository;)V", "tapTimetableEvent", "Landroid/os/Bundle;", "getTapTimetableEvent", "getTranslationRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "changeUserVisibleHint", "", "isVisibleToUser", "checkServiceStatus", "delayInfoClick", "line", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;", "getDelayIcon", "Landroid/graphics/drawable/Drawable;", "getDispDelayMinute", "getLineIcon", "isExistLinesNotCoveredServiceStatus", "sendViewFavoriteRouteDetailEvent", "numberOfDelayLines", "", "tapTimetable", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class g
extends v {
    public FavoriteRoute a;
    private final al<Intent> b;
    private final al<Void> c;
    private final al<Void> d;
    private final androidx.lifecycle.p<Map<String, ServiceStatus>> e;
    private final androidx.lifecycle.p<Boolean> f;
    private final androidx.lifecycle.p<Boolean> g;
    private final androidx.lifecycle.p<Boolean> h;
    private final al<Void> i;
    private final al<Bundle> j;
    private b k;
    private l l;
    private final p m;
    private jp.co.jreast.jreastapp.commuter.l.a n;

    public g(b object, l l2, p p2, jp.co.jreast.jreastapp.commuter.l.a a2) {
        j.b(object, "drawableRepository");
        j.b(l2, "serviceStatusRepository");
        j.b(p2, "translationRepository");
        this.k = object;
        this.l = l2;
        this.m = p2;
        this.n = a2;
        this.b = new al();
        this.c = new al();
        this.d = new al();
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(af.a());
        this.e = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(false);
        this.f = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(false);
        this.g = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(false);
        this.h = object;
        this.i = new al();
        this.j = new al();
    }

    private final void a(int n2) {
        jp.co.jreast.jreastapp.commuter.l.a a2 = this.n;
        if (a2 != null) {
            a2.b(n2);
        }
    }

    private final void m() {
        l l2 = this.l;
        FavoriteRoute favoriteRoute = this.a;
        if (favoriteRoute == null) {
            j.b("favoriteRoute");
        }
        l2.a(favoriteRoute.getRoute().getLines(), "https://rp.cloudrail.jp/com/api/").a((b.a.g<Map<String, ServiceStatus>>)new b.a.g<Map<String, ? extends ServiceStatus>>(){

            @Override
            public void a(b.a.b.b b2) {
                j.b(b2, "d");
            }

            @Override
            public void a(Throwable throwable) {
                j.b(throwable, "e");
                this.h.b(true);
                this.d().f();
                this.g.b(false);
                this.a(-1);
                jp.co.jreast.jreastapp.commuter.l.a a2 = this.l();
                if (a2 != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(throwable.getClass().getSimpleName());
                    stringBuilder.append(" at FavoriteRouteDetailViewModel : ");
                    stringBuilder.append(throwable.getMessage());
                    a2.a("\u30a8\u30e9\u30fc\u767a\u751f", stringBuilder.toString());
                }
            }

            public void a(Map<String, ServiceStatus> map) {
                j.b(map, "serviceStatusMap");
                this.e.b(map);
            }

            @Override
            public /* synthetic */ void a_(Object object) {
                this.a((Map)object);
            }

            @Override
            public void b_() {
                Map<String, ServiceStatus> map = this.e().a();
                if (map == null) {
                    j.a();
                }
                if (map.isEmpty() && !this.n()) {
                    this.f.b(true);
                    this.c().f();
                }
                this.g.b(false);
                map = this;
                Map<String, ServiceStatus> map2 = this.e().a();
                if (map2 == null) {
                    j.a();
                }
                ((g)((Object)map)).a(map2.size());
            }
        });
    }

    private final boolean n() {
        boolean bl2;
        Object object = this.a;
        if (object == null) {
            j.b("favoriteRoute");
        }
        Object object2 = ((FavoriteRoute)object).getRoute().getLines();
        object = new ArrayList();
        object2 = object2.iterator();
        do {
            boolean bl3;
            Object e2;
            block7 : {
                block6 : {
                    boolean bl4 = object2.hasNext();
                    bl2 = false;
                    boolean bl5 = false;
                    if (!bl4) break;
                    e2 = object2.next();
                    RailwayLine railwayLine = (RailwayLine)e2;
                    CharSequence charSequence = railwayLine.getJrId();
                    bl3 = charSequence == null || charSequence.length() == 0;
                    if (bl3 && !railwayLine.isWalking()) break block6;
                    bl3 = bl5;
                    if (!railwayLine.isNormalPaidExpress()) break block7;
                }
                bl3 = true;
            }
            if (!bl3) continue;
            object.add(e2);
        } while (true);
        if (((Collection)((List)object)).size() > 0) {
            bl2 = true;
        }
        return bl2;
    }

    public final Drawable a(RailwayLine railwayLine) {
        j.b(railwayLine, "line");
        return this.k.a(railwayLine);
    }

    public final void a(FavoriteRoute favoriteRoute) {
        j.b(favoriteRoute, "<set-?>");
        this.a = favoriteRoute;
    }

    public final void a(boolean bl2) {
        if (bl2) {
            this.g.b(true);
            this.m();
            return;
        }
        this.f.b(false);
        this.h.b(false);
        this.i.f();
    }

    public final Drawable b(RailwayLine railwayLine) {
        j.b(railwayLine, "line");
        return this.k.b(railwayLine);
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
        intent.putExtra(jp.co.jreast.jreastapp.commuter.common.b.y.a(), "Favorite");
        this.b.b(intent);
    }

    public final String d(RailwayLine railwayLine) {
        j.b(railwayLine, "line");
        return this.m.a(2131558481, railwayLine.getServiceStatus().getDelayMinute());
    }

    public final al<Void> d() {
        return this.d;
    }

    public final LiveData<Map<String, ServiceStatus>> e() {
        return this.e;
    }

    public final LiveData<Boolean> f() {
        return this.f;
    }

    public final LiveData<Boolean> g() {
        return this.g;
    }

    public final LiveData<Boolean> h() {
        return this.h;
    }

    public final al<Void> i() {
        return this.i;
    }

    public final al<Bundle> j() {
        return this.j;
    }

    public final void k() {
        Object object = new Bundle();
        String string2 = jp.co.jreast.jreastapp.commuter.common.b.B.a();
        FavoriteRoute favoriteRoute = this.a;
        if (favoriteRoute == null) {
            j.b("favoriteRoute");
        }
        object.putSerializable(string2, (Serializable)favoriteRoute);
        this.j.b((Bundle)object);
        object = this.n;
        if (object != null) {
            object.i();
        }
    }

    public final jp.co.jreast.jreastapp.commuter.l.a l() {
        return this.n;
    }

}

