/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.o;

import java.util.Date;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.b;
import jp.co.jreast.jreastapp.commuter.m.k;
import jp.co.jreast.jreastapp.commuter.m.o;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.model.ExpressSettings;
import jp.co.jreast.jreastapp.commuter.model.Station;
import jp.co.jreast.jreastapp.commuter.model.TransferTimeSettings;
import jp.co.jreast.jreastapp.commuter.o.c;
import jp.co.jreast.jreastapp.commuter.o.d;
import jp.co.jreast.jreastapp.commuter.o.g;
import jp.co.jreast.jreastapp.commuter.skewscroll.e;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010JB\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010%\u001a\u00020\u0019R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006&"}, d2={"Ljp/co/jreast/jreastapp/commuter/routesearchresults/RouteSearchResultsViewModel;", "Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewModel;", "routeSearchRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkRouteSearchRepository;", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "userSettingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "previousNextRoutesInformationBuilder", "Ljp/co/jreast/jreastapp/commuter/skewscroll/PreviousNextRoutesInformationBuilder;", "commuterDateTimeUtil", "Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljp/co/jreast/jreastapp/commuter/repository/NetworkRouteSearchRepository;Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/skewscroll/PreviousNextRoutesInformationBuilder;Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "backButtonEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getBackButtonEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "getUserSettingsRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "set", "", "scale", "", "departureStation", "Ljp/co/jreast/jreastapp/commuter/model/Station;", "arrivalStation", "selectedDate", "Ljava/util/Date;", "departureOrArrival", "", "viaStation1", "viaStation2", "tapBackButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class h
extends jp.co.jreast.jreastapp.commuter.skewscroll.h {
    private final al<Void> b;
    private final s c;

    public h(k k2, b b2, s s2, p p2, jp.co.jreast.jreastapp.commuter.skewscroll.a a2, jp.co.jreast.jreastapp.commuter.d.a a3, a a4) {
        j.b(k2, "routeSearchRepository");
        j.b(b2, "drawableRepository");
        j.b(s2, "userSettingsRepository");
        j.b(p2, "translationRepository");
        j.b(a2, "previousNextRoutesInformationBuilder");
        j.b(a3, "commuterDateTimeUtil");
        super(k2, b2, s2, p2, a2, a3, a4);
        this.c = s2;
        this.b = new al();
    }

    public final void a(float f2, Station station, Station station2, Date date, int n2, Station station3, Station station4) {
        j.b(station, "departureStation");
        j.b(station2, "arrivalStation");
        j.b(date, "selectedDate");
        super.a(new c(station, station2, date, n2, this.c.a().getValue(), this.c.c().getValue(), station3, station4), new d(), new g(f2, null, 2, null), date);
    }

    public final al<Void> b() {
        return this.b;
    }

    public final void c() {
        this.b.f();
    }
}

