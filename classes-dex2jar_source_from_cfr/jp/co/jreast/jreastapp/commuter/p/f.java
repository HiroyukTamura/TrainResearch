/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.p;

import java.util.Date;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.m.b;
import jp.co.jreast.jreastapp.commuter.m.m;
import jp.co.jreast.jreastapp.commuter.m.o;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.p.a;
import jp.co.jreast.jreastapp.commuter.p.d;
import jp.co.jreast.jreastapp.commuter.p.e;
import jp.co.jreast.jreastapp.commuter.skewscroll.c;
import jp.co.jreast.jreastapp.commuter.skewscroll.h;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001dR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2={"Ljp/co/jreast/jreastapp/commuter/timetable/TimetableViewModel;", "Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewModel;", "routeSearchRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkTimetableSearchRepository;", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "userSettingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "previousNextRoutesInformationBuilder", "Ljp/co/jreast/jreastapp/commuter/skewscroll/PreviousNextRoutesInformationBuilder;", "commuterDateTimeUtil", "Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljp/co/jreast/jreastapp/commuter/repository/NetworkTimetableSearchRepository;Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/skewscroll/PreviousNextRoutesInformationBuilder;Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "backButtonEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getBackButtonEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "favoriteRoute", "Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;", "getFavoriteRoute", "()Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;", "setFavoriteRoute", "(Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;)V", "set", "", "scale", "", "selectedDate", "Ljava/util/Date;", "tapBackButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class f
extends h {
    public FavoriteRoute b;
    private final al<Void> c;

    public f(m m2, b b2, s s2, p p2, jp.co.jreast.jreastapp.commuter.skewscroll.a a2, jp.co.jreast.jreastapp.commuter.d.a a3, jp.co.jreast.jreastapp.commuter.l.a a4) {
        j.b(m2, "routeSearchRepository");
        j.b(b2, "drawableRepository");
        j.b(s2, "userSettingsRepository");
        j.b(p2, "translationRepository");
        j.b(a2, "previousNextRoutesInformationBuilder");
        j.b(a3, "commuterDateTimeUtil");
        super(m2, b2, s2, p2, a2, a3, a4);
        this.c = new al();
    }

    public static /* synthetic */ void a(f f2, float f3, Date date, int n2, Object object) {
        if ((n2 & 2) != 0) {
            date = new Date();
        }
        f2.a(f3, date);
    }

    public final void a(float f2, Date date) {
        j.b(date, "selectedDate");
        FavoriteRoute favoriteRoute = this.b;
        if (favoriteRoute == null) {
            j.b("favoriteRoute");
        }
        super.a(new d(favoriteRoute.getRoute().getPreviousNextKey(), date), new a(), new e(f2, null, 2, null), date);
    }

    public final void a(FavoriteRoute favoriteRoute) {
        j.b(favoriteRoute, "<set-?>");
        this.b = favoriteRoute;
    }

    public final al<Void> b() {
        return this.c;
    }

    public final void c() {
        super.J();
        this.c.f();
    }
}

