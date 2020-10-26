/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 */
package jp.co.jreast.jreastapp.commuter.skewscroll;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.m.o;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.model.Accuracy;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.FareSettings;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.model.SearchResultSubTitle;
import jp.co.jreast.jreastapp.commuter.o.d;
import jp.co.jreast.jreastapp.commuter.skewscroll.e;
import jp.co.jreast.jreastapp.commuter.skewscroll.i;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0010J\u0006\u0010|\u001a\u00020}J\u0006\u0010~\u001a\u00020J\u0010\u0010\u0001\u001a\u00020\u001a2\u0007\u0010\u0081\u0001\u001a\u00020\u001fJ\u0007\u0010\u0082\u0001\u001a\u00020\u001aJ\u0010\u0010\u0083\u0001\u001a\u00020!2\u0007\u0010\u0081\u0001\u001a\u00020\u001fJ\u0010\u0010\u0084\u0001\u001a\u00020!2\u0007\u0010\u0081\u0001\u001a\u00020\u001fJ\u0012\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001J\u0007\u0010\u0089\u0001\u001a\u00020\u001aJ\u0007\u0010\u008a\u0001\u001a\u00020\u001aJ\t\u0010\u008b\u0001\u001a\u00020H\u0014J\u0007\u0010\u008c\u0001\u001a\u00020J\u0010\u0010\u008d\u0001\u001a\u000202\u0007\u0010\u0081\u0001\u001a\u00020\u001fJ\u0007\u0010\u008e\u0001\u001a\u00020J\u0007\u0010\u008f\u0001\u001a\u00020\u0015J\u0007\u0010\u0090\u0001\u001a\u00020\u0015J\u0007\u0010\u0091\u0001\u001a\u00020J+\u0010\u0092\u0001\u001a\u000202\u0007\u0010\u0093\u0001\u001a\u00020X2\u0007\u0010\u0094\u0001\u001a\u00020p2\u0007\u0010\u0095\u0001\u001a\u00020x2\u0007\u0010\u0096\u0001\u001a\u00020&J\u0007\u0010\u0097\u0001\u001a\u00020J\u000f\u0010\u0098\u0001\u001a\u000202\u0006\u0010I\u001a\u00020JJ\u0010\u0010\u0099\u0001\u001a\u000202\u0007\u0010\u009a\u0001\u001a\u00020\u0015J\u0015\u0010\u009b\u0001\u001a\u000202\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0017\u0010\u009c\u0001\u001a\u000202\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020!0.8F\u00a2\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u00108\u001a\u0002072\u0006\u00106\u001a\u000207@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00150.8F\u00a2\u0006\u0006\u001a\u0004\b=\u00100R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00150.8F\u00a2\u0006\u0006\u001a\u0004\b>\u00100R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00150.8F\u00a2\u0006\u0006\u001a\u0004\b?\u00100R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00150.8F\u00a2\u0006\u0006\u001a\u0004\b@\u00100R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010B\u001a\u0002072\u0006\u00106\u001a\u000207@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010:\"\u0004\bD\u0010<R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00150.8F\u00a2\u0006\u0006\u001a\u0004\bF\u00100R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001a0.8F\u00a2\u0006\u0006\u001a\u0004\bH\u00100R\u001a\u0010I\u001a\u00020JX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00150.8F\u00a2\u0006\u0006\u001a\u0004\bP\u00100R\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001a0.8F\u00a2\u0006\u0006\u001a\u0004\bR\u00100R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020T0(\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010*R\u001d\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020X0W\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR \u0010[\u001a\b\u0012\u0004\u0012\u00020T0(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010*\"\u0004\b]\u0010,R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020_0(X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0.8F\u00a2\u0006\u0006\u001a\u0004\bb\u00100R\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020T0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020!0.8F\u00a2\u0006\u0006\u001a\u0004\bg\u00100R\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020T0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\bi\u0010eR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020T0(X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bk\u0010*R\u001a\u0010l\u001a\u00020JX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010L\"\u0004\bn\u0010NR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010o\u001a\u00020pX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0017\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00150.8F\u00a2\u0006\u0006\u001a\u0004\bv\u00100R\u000e\u0010w\u001a\u00020xX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010y\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u00103\"\u0004\b{\u00105\u00a8\u0006\u009d\u0001"}, d2={"Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewModel;", "Landroidx/lifecycle/ViewModel;", "routeSearchRepository", "Ljp/co/jreast/jreastapp/commuter/repository/RouteSearchRepository;", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "userSettingsRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "previousNextRoutesInformationBuilder", "Ljp/co/jreast/jreastapp/commuter/skewscroll/PreviousNextRoutesInformationBuilder;", "commuterDateTimeUtil", "Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljp/co/jreast/jreastapp/commuter/repository/RouteSearchRepository;Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;Ljp/co/jreast/jreastapp/commuter/skewscroll/PreviousNextRoutesInformationBuilder;Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "_disposables", "Lio/reactivex/disposables/CompositeDisposable;", "_isError", "Landroidx/lifecycle/MutableLiveData;", "", "_isParseError", "_isSearching", "_nextButtonEnabled", "_nextButtonVisibility", "", "_previousButtonEnabled", "_previousButtonVisibility", "_routes", "", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "_searchPreviousOrNextText", "", "_viewCurrentDateLine", "getAnalyticsProvider", "()Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "currentDate", "Ljava/util/Date;", "currentDateLinePositionEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "getCurrentDateLinePositionEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "setCurrentDateLinePositionEvent", "(Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;)V", "currentDateStr", "Landroidx/lifecycle/LiveData;", "getCurrentDateStr", "()Landroidx/lifecycle/LiveData;", "currentPageNumber", "getCurrentPageNumber", "()I", "setCurrentPageNumber", "(I)V", "<set-?>", "Ljava/util/Calendar;", "earliestDepartureDate", "getEarliestDepartureDate", "()Ljava/util/Calendar;", "setEarliestDepartureDate", "(Ljava/util/Calendar;)V", "isError", "isNotFounded", "isParseError", "isSearching", "isTransitionPreviousOrNext", "latestArrivalDate", "getLatestArrivalDate", "setLatestArrivalDate", "nextButtonEnabled", "getNextButtonEnabled", "nextButtonVisibility", "getNextButtonVisibility", "pixelForMinute", "", "getPixelForMinute", "()F", "setPixelForMinute", "(F)V", "previousButtonEnabled", "getPreviousButtonEnabled", "previousButtonVisibility", "getPreviousButtonVisibility", "refreshSubTitle", "Ljava/lang/Void;", "getRefreshSubTitle", "requestParameter", "", "Ljp/co/jreast/jreastapp/commuter/http/CommuterRequestParameter;", "getRequestParameter", "()Ljava/util/Map;", "resetScrollPositionEvent", "getResetScrollPositionEvent", "setResetScrollPositionEvent", "routeListItemClickEvent", "Landroid/os/Bundle;", "getRouteListItemClickEvent$app_productRelease", "routes", "getRoutes", "searchPreviousOrNextEvent", "getSearchPreviousOrNextEvent", "()Landroidx/lifecycle/MutableLiveData;", "searchPreviousOrNextText", "getSearchPreviousOrNextText", "searchResultsReceived", "getSearchResultsReceived", "showPreviousNextButtonEvent", "getShowPreviousNextButtonEvent$app_productRelease", "topMargin", "getTopMargin", "setTopMargin", "viewConfig", "Ljp/co/jreast/jreastapp/commuter/skewscroll/RouteCollectionViewConfig;", "getViewConfig", "()Ljp/co/jreast/jreastapp/commuter/skewscroll/RouteCollectionViewConfig;", "setViewConfig", "(Ljp/co/jreast/jreastapp/commuter/skewscroll/RouteCollectionViewConfig;)V", "viewCurrentDateLine", "getViewCurrentDateLine", "viewDataSource", "Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewDataSource;", "viewHeight", "getViewHeight", "setViewHeight", "buildSubTitle", "Ljp/co/jreast/jreastapp/commuter/model/SearchResultSubTitle;", "calculateForRoutes", "", "getCheapestVisibility", "route", "getCountOfRuleLines", "getDispTransferCount", "getFareValue", "getLineIcon", "Landroid/graphics/drawable/Drawable;", "line", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLine;", "getRecyclerViewHeight", "getStartPositionOfRuleLines", "onCleared", "reset", "routeListItemClick", "search", "searchNextRoutes", "searchPreviousRoutes", "sendViewEventToAnalytics", "set", "param", "passedViewConfig", "passedViewDataSource", "selectedDate", "setCurrentDateLineIfNeeded", "setCurrentDateLinePosition", "setTransitionPreviousOrNext", "isTransition", "updatePreviousNextButtonVisibilityAfterSearch", "updateTanRakuYasu", "app_productRelease"}, k=1, mv={1, 1, 11})
public abstract class h
extends v {
    private final androidx.lifecycle.p<Void> A;
    private final androidx.lifecycle.p<String> B;
    private final androidx.lifecycle.p<Boolean> C;
    private final o D;
    private final jp.co.jreast.jreastapp.commuter.m.b E;
    private final s F;
    private final p G;
    private final jp.co.jreast.jreastapp.commuter.skewscroll.a H;
    private final jp.co.jreast.jreastapp.commuter.d.a I;
    private final jp.co.jreast.jreastapp.commuter.l.a J;
    public jp.co.jreast.jreastapp.commuter.skewscroll.c a;
    private final al<Bundle> b;
    private final b.a.b.a c;
    private int d;
    private float e;
    private float f;
    private int g;
    private final Map<Integer, jp.co.jreast.jreastapp.commuter.j.a> h;
    private e i;
    private final androidx.lifecycle.p<List<Route>> j;
    private final androidx.lifecycle.p<Boolean> k;
    private final androidx.lifecycle.p<Boolean> l;
    private final androidx.lifecycle.p<Boolean> m;
    private final androidx.lifecycle.p<Date> n;
    private final androidx.lifecycle.p<Boolean> o;
    private al<Integer> p;
    private final androidx.lifecycle.p<Void> q;
    private al<Void> r;
    private final al<Void> s;
    private Calendar t;
    private Calendar u;
    private final al<Void> v;
    private final androidx.lifecycle.p<Boolean> w;
    private final androidx.lifecycle.p<Boolean> x;
    private final androidx.lifecycle.p<Integer> y;
    private final androidx.lifecycle.p<Integer> z;

    public h(o object, jp.co.jreast.jreastapp.commuter.m.b b2, s s2, p p2, jp.co.jreast.jreastapp.commuter.skewscroll.a a2, jp.co.jreast.jreastapp.commuter.d.a a3, jp.co.jreast.jreastapp.commuter.l.a a4) {
        j.b(object, "routeSearchRepository");
        j.b(b2, "drawableRepository");
        j.b(s2, "userSettingsRepository");
        j.b(p2, "translationRepository");
        j.b(a2, "previousNextRoutesInformationBuilder");
        j.b(a3, "commuterDateTimeUtil");
        this.D = object;
        this.E = b2;
        this.F = s2;
        this.G = p2;
        this.H = a2;
        this.I = a3;
        this.J = a4;
        this.b = new al();
        this.c = new b.a.b.a();
        this.h = new LinkedHashMap();
        this.j = new androidx.lifecycle.p();
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(false);
        this.k = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(false);
        this.l = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(false);
        this.m = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(new Date());
        this.n = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(false);
        this.o = object;
        this.p = new al();
        this.q = new androidx.lifecycle.p();
        this.r = new al();
        this.s = new al();
        this.t = this.I.b();
        this.u = this.I.b();
        this.v = new al();
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(true);
        this.w = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(true);
        this.x = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(8);
        this.y = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(8);
        this.z = object;
        this.A = new androidx.lifecycle.p();
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b("");
        this.B = object;
        object = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)object).b(false);
        this.C = object;
    }

    public static final /* synthetic */ void a(h h2, Calendar calendar) {
        h2.t = calendar;
    }

    private final void b(List<Route> object) {
        int n2;
        Route route;
        int n3;
        Object object2;
        Object object3 = (Iterable)object;
        Iterator iterator = object3.iterator();
        if (!iterator.hasNext()) {
            route = null;
        } else {
            object2 = iterator.next();
            n2 = ((Route)object2).getAccuracy().getMinutes();
            do {
                route = (Route)object2;
                if (!iterator.hasNext()) break;
                route = (Route)iterator.next();
                n3 = ((Route)route).getAccuracy().getMinutes();
                if (n2 <= n3) continue;
                object2 = route;
                n2 = n3;
            } while (true);
        }
        iterator = route;
        Object object4 = object3.iterator();
        if (!object4.hasNext()) {
            route = null;
        } else {
            object2 = object4.next();
            n2 = Integer.parseInt(((Route)object2).getFare());
            do {
                route = (Route)object2;
                if (!object4.hasNext()) break;
                route = (Route)object4.next();
                n3 = Integer.parseInt(((Route)route).getFare());
                if (n2 <= n3) continue;
                object2 = route;
                n2 = n3;
            } while (true);
        }
        object4 = route;
        Object object5 = object3.iterator();
        if (!object5.hasNext()) {
            route = null;
        } else {
            object2 = object5.next();
            n2 = Integer.parseInt(((Route)object2).getFareIc());
            do {
                route = (Route)object2;
                if (!object5.hasNext()) break;
                route = (Route)object5.next();
                n3 = Integer.parseInt(((Route)route).getFareIc());
                if (n2 <= n3) continue;
                object2 = route;
                n2 = n3;
            } while (true);
        }
        object5 = route;
        object3 = object3.iterator();
        if (!object3.hasNext()) {
            route = null;
        } else {
            object2 = object3.next();
            n2 = Integer.parseInt(((Route)object2).getTransferCount());
            do {
                route = (Route)object2;
                if (!object3.hasNext()) break;
                route = object3.next();
                n3 = Integer.parseInt(route.getTransferCount());
                if (n2 <= n3) continue;
                object2 = route;
                n2 = n3;
            } while (true);
        }
        object2 = route;
        object = object.iterator();
        while (object.hasNext()) {
            route = (Route)object.next();
            if (iterator == null) {
                j.a();
            }
            boolean bl2 = ((Route)((Object)iterator)).getAccuracy().getMinutes() == route.getAccuracy().getMinutes();
            route.setShortestTime(bl2);
            if (object4 == null) {
                j.a();
            }
            route.setCheapestCash(j.a((Object)((Route)object4).getFare(), (Object)route.getFare()));
            if (object5 == null) {
                j.a();
            }
            route.setCheapestICCard(j.a((Object)((Route)object5).getFareIc(), (Object)route.getFareIc()));
            if (object2 == null) {
                j.a();
            }
            route.setMinimumTransfer(j.a((Object)((Route)object2).getTransferCount(), (Object)route.getTransferCount()));
        }
    }

    public static final /* synthetic */ void b(h h2, Calendar calendar) {
        h2.u = calendar;
    }

    public final boolean A() {
        Object object = this.i().a();
        if (object == null) {
            j.a();
        }
        if (!((Boolean)object).booleanValue()) {
            object = this.w.a();
            if (object == null) {
                j.a();
            }
            if (((Boolean)object).booleanValue() && this.g > -9) {
                if (this.h.get(this.g - 1) == null) {
                    object = this.h;
                    int n2 = this.g;
                    jp.co.jreast.jreastapp.commuter.skewscroll.a a2 = this.H;
                    List<Route> list = this.h().a();
                    if (list == null) {
                        j.a();
                    }
                    j.a(list, "routes.value!!");
                    jp.co.jreast.jreastapp.commuter.j.a a3 = this.h.get(this.g);
                    if (a3 == null) {
                        j.a();
                    }
                    object.put(n2 - 1, a2.a(list, a3));
                }
                --this.g;
                this.B.b(this.G.a(2131558613));
                this.A.b(null);
                this.z();
                this.v.f();
                return true;
            }
        }
        return false;
    }

    public final boolean B() {
        Object object = this.i().a();
        if (object == null) {
            j.a();
        }
        if (!((Boolean)object).booleanValue()) {
            object = this.x.a();
            if (object == null) {
                j.a();
            }
            if (((Boolean)object).booleanValue() && this.g < 9) {
                if (this.h.get(this.g + 1) == null) {
                    object = this.h;
                    int n2 = this.g;
                    jp.co.jreast.jreastapp.commuter.skewscroll.a a2 = this.H;
                    List<Route> list = this.h().a();
                    if (list == null) {
                        j.a();
                    }
                    j.a(list, "routes.value!!");
                    jp.co.jreast.jreastapp.commuter.j.a a3 = this.h.get(this.g);
                    if (a3 == null) {
                        j.a();
                    }
                    object.put(n2 + 1, a2.a(list, a3, this.g));
                }
                ++this.g;
                this.B.b(this.G.a(2131558612));
                this.A.b(null);
                this.z();
                this.v.f();
                return true;
            }
        }
        return false;
    }

    public final SearchResultSubTitle C() {
        jp.co.jreast.jreastapp.commuter.j.a a2 = this.h.get(0);
        if (a2 == null) {
            j.a();
        }
        if (a2 instanceof jp.co.jreast.jreastapp.commuter.o.c) {
            return this.H.a((jp.co.jreast.jreastapp.commuter.o.c)a2, this.g);
        }
        return new SearchResultSubTitle(null, null, 0, 7, null);
    }

    public final void D() {
        e e2 = this.i;
        if (e2 == null) {
            j.b("viewDataSource");
        }
        int n2 = this.d;
        List<Route> list = this.h().a();
        if (list == null) {
            j.a();
        }
        j.a(list, "routes.value!!");
        this.e = e2.a(n2, list);
        e2 = this.i;
        if (e2 == null) {
            j.b("viewDataSource");
        }
        if ((list = this.h().a()) == null) {
            j.a();
        }
        j.a(list, "routes.value!!");
        this.f = e2.a(list, this.e);
    }

    public final void E() {
        androidx.lifecycle.p<Boolean> p2 = this.o;
        jp.co.jreast.jreastapp.commuter.skewscroll.c c2 = this.a;
        if (c2 == null) {
            j.b("viewConfig");
        }
        p2.b(c2.c());
    }

    public final int F() {
        return (int)((float)(this.t.get(12) % 15 * -1) * this.e + this.f);
    }

    public final int G() {
        int n2 = this.t.get(12);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.t.getTime());
        calendar.add(12, n2 % 15 * -1);
        float f2 = new jp.co.jreast.jreastapp.commuter.d.a().a(this.u, calendar);
        n2 = (int)(this.u.getTimeInMillis() % (long)900000) == 0 ? 0 : 1;
        return (int)(f2 / (float)15 + (float)true + (float)n2);
    }

    public final int H() {
        Object object;
        List<Route> list;
        List<Route> list2 = this.h().a();
        if (list2 == null) {
            j.a();
        }
        j.a(list2, "routes.value!!");
        Iterator iterator = ((Iterable)list2).iterator();
        if (!iterator.hasNext()) {
            list2 = null;
        } else {
            list2 = iterator.next();
            object = m.h(((Route)((Object)list2)).getLines()).getTo().dateTime();
            if (object == null) {
                j.a();
            }
            object = ((Calendar)object).getTime();
            while (iterator.hasNext()) {
                list = iterator.next();
                Comparable<Calendar> comparable = m.h(((Route)((Object)list)).getLines()).getTo().dateTime();
                if (comparable == null) {
                    j.a();
                }
                if (object.compareTo(comparable = (Comparable)comparable.getTime()) >= 0) continue;
                list2 = list;
                object = comparable;
            }
        }
        object = (Route)((Object)list2);
        list2 = new jp.co.jreast.jreastapp.commuter.d.a();
        if (object == null) {
            j.a();
        }
        object = m.h(((Route)object).getLines()).getTo().dateTime();
        list = this.h().a();
        if (list == null) {
            j.a();
        }
        j.a(list, "routes.value!!");
        float f2 = (((jp.co.jreast.jreastapp.commuter.d.a)((Object)list2)).a((Calendar)object, m.f(m.f(list).getLines()).getFrom().dateTime()) * this.e + this.f) / 0.7f;
        float f3 = 177;
        list2 = this.i;
        if (list2 == null) {
            j.b("viewDataSource");
        }
        return (int)(f2 + (f3 * ((e)((Object)list2)).a() + 0.5f)) + this.d;
    }

    public final void I() {
        Object object = this.a;
        if (object == null) {
            j.b("viewConfig");
        }
        if (object instanceof d) {
            object = this.J;
            if (object != null) {
                List<Route> list = this.h().a();
                if (list == null) {
                    j.a();
                }
                object.a(list.size());
                return;
            }
        } else {
            object = this.J;
            if (object != null) {
                object.j();
            }
        }
    }

    public final void J() {
        this.g = 0;
        this.y.b(8);
        this.z.b(8);
        this.h.clear();
    }

    public final jp.co.jreast.jreastapp.commuter.l.a K() {
        return this.J;
    }

    public final Drawable a(RailwayLine railwayLine) {
        j.b(railwayLine, "line");
        return this.E.a(railwayLine);
    }

    @Override
    protected void a() {
        this.c.c();
        super.a();
    }

    public final void a(float f2) {
        Calendar calendar = Calendar.getInstance();
        Object t2 = this.n.a();
        if (t2 == null) {
            j.a();
        }
        calendar.setTime((Date)t2);
        float f3 = new jp.co.jreast.jreastapp.commuter.d.a().a(calendar, this.t);
        this.p.b((int)(f3 * f2 + this.f));
    }

    public final void a(int n2) {
        this.d = n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void a(List<Route> var1_1) {
        j.b(var1_1, "routes");
        if (this.h.get(this.g) == null) return;
        var6_2 = this.h.get(this.g);
        if (var6_2 == null) {
            j.a();
        }
        var3_3 = var6_2 instanceof jp.co.jreast.jreastapp.commuter.o.c;
        var5_4 = true;
        var4_5 = true;
        var2_6 = var3_3 != false && ((var2_6 = ((jp.co.jreast.jreastapp.commuter.o.c)var6_2).e()) == jp.co.jreast.jreastapp.commuter.common.c.a.a() || var2_6 == jp.co.jreast.jreastapp.commuter.common.c.b.a()) ? 1 : 0;
        if (!(((Collection)var1_1).isEmpty() ^ true)) ** GOTO lbl-1000
        var1_1 = this.a;
        if (var1_1 == null) {
            j.b("viewConfig");
        }
        if (var1_1.d() && var2_6 != 0) {
            var1_1 = this.w;
            var3_3 = this.g > -9;
            var1_1.b(var3_3);
            var1_1 = this.x;
            var3_3 = this.g < 9 ? var4_5 : false;
            var1_1.b(var3_3);
            this.y.b(0);
            var6_2 = this.z;
            var1_1 = 0;
        } else lbl-1000: // 2 sources:
        {
            var1_1 = this.w;
            var3_3 = this.h.get(this.g - 1) != null;
            var1_1.b(var3_3);
            var6_2 = this.x;
            var3_3 = this.h.get(this.g + 1) != null ? var5_4 : false;
            var1_1 = var3_3;
        }
        var6_2.b(var1_1);
    }

    public final void a(jp.co.jreast.jreastapp.commuter.j.a object, jp.co.jreast.jreastapp.commuter.skewscroll.c c2, e e2, Date date) {
        j.b(object, "param");
        j.b(c2, "passedViewConfig");
        j.b(e2, "passedViewDataSource");
        j.b(date, "selectedDate");
        this.h.put(this.g, (jp.co.jreast.jreastapp.commuter.j.a)object);
        this.a = c2;
        this.i = e2;
        object = this.a;
        if (object == null) {
            j.b("viewConfig");
        }
        if (object.d()) {
            this.s.f();
        }
        this.n.a(date);
    }

    public final void a(Route object) {
        j.b(object, "route");
        Bundle bundle = new Bundle();
        bundle.putSerializable(jp.co.jreast.jreastapp.commuter.common.b.v.a(), (Serializable)object);
        object = jp.co.jreast.jreastapp.commuter.common.b.w.a();
        jp.co.jreast.jreastapp.commuter.skewscroll.c c2 = this.a;
        if (c2 == null) {
            j.b("viewConfig");
        }
        bundle.putSerializable((String)object, (Serializable)c2);
        this.b.b(bundle);
    }

    public final void a(boolean bl2) {
        if (bl2) {
            this.C.b(bl2);
            return;
        }
        this.C.b(bl2);
        this.B.b("");
    }

    public final String b(Route object) {
        j.b(object, "route");
        FareSettings fareSettings = this.F.b();
        switch (i.a[fareSettings.ordinal()]) {
            default: {
                throw new kotlin.m();
            }
            case 2: {
                object = ((Route)object).fareIcWithSeparator();
                break;
            }
            case 1: {
                object = ((Route)object).fareWithSeparator();
            }
        }
        return this.G.a(2131558506, (String)object);
    }

    public final int c(Route route) {
        int n2;
        block7 : {
            j.b(route, "route");
            Object object = this.a;
            if (object == null) {
                j.b("viewConfig");
            }
            boolean bl2 = object.a();
            n2 = 8;
            if (!bl2) {
                return 8;
            }
            object = this.F.b();
            switch (i.b[((Enum)object).ordinal()]) {
                default: {
                    throw new kotlin.m();
                }
                case 2: {
                    if (route.getCheapestICCard()) {
                        break;
                    }
                    break block7;
                }
                case 1: {
                    if (!route.getCheapestCash()) break block7;
                }
            }
            n2 = 0;
        }
        return n2;
    }

    public final String d(Route route) {
        j.b(route, "route");
        return this.G.a(2131558605, route.getTransferCount());
    }

    public final al<Bundle> d() {
        return this.b;
    }

    public final float e() {
        return this.e;
    }

    public final float f() {
        return this.f;
    }

    public final jp.co.jreast.jreastapp.commuter.skewscroll.c g() {
        jp.co.jreast.jreastapp.commuter.skewscroll.c c2 = this.a;
        if (c2 == null) {
            j.b("viewConfig");
        }
        return c2;
    }

    public final LiveData<List<Route>> h() {
        return this.j;
    }

    public final LiveData<Boolean> i() {
        return this.k;
    }

    public final LiveData<Boolean> j() {
        return this.l;
    }

    public final LiveData<Boolean> k() {
        return this.m;
    }

    public final LiveData<Boolean> l() {
        LiveData<Boolean> liveData = u.a((LiveData)this.j, b.a);
        j.a(liveData, "Transformations.switchMa\u2026)\n            }\n        }");
        return liveData;
    }

    public final LiveData<String> m() {
        LiveData<String> liveData = u.a((LiveData)this.n, a.a);
        j.a(liveData, "Transformations.switchMa\u2026)\n            }\n        }");
        return liveData;
    }

    public final LiveData<Boolean> n() {
        return this.o;
    }

    public final al<Integer> o() {
        return this.p;
    }

    public final androidx.lifecycle.p<Void> p() {
        return this.q;
    }

    public final al<Void> q() {
        return this.r;
    }

    public final al<Void> r() {
        return this.s;
    }

    public final al<Void> s() {
        return this.v;
    }

    public final LiveData<Boolean> t() {
        return this.w;
    }

    public final LiveData<Boolean> u() {
        return this.x;
    }

    public final LiveData<Integer> v() {
        return this.y;
    }

    public final LiveData<Integer> w() {
        return this.z;
    }

    public final androidx.lifecycle.p<Void> x() {
        return this.A;
    }

    public final LiveData<String> y() {
        return this.B;
    }

    public final void z() {
        this.l.a(false);
        this.m.a(false);
        this.k.a(true);
        o o2 = this.D;
        jp.co.jreast.jreastapp.commuter.j.a a2 = this.h.get(this.g);
        if (a2 == null) {
            j.a();
        }
        o2.a(a2, "https://rp.cloudrail.jp/com/api/").a((b.a.g<List<Route>>)new b.a.g<List<? extends Route>>(){

            @Override
            public void a(b.a.b.b b2) {
                j.b(b2, "d");
            }

            @Override
            public void a(Throwable throwable) {
                j.b(throwable, "e");
                this.a(false);
                this.k.a(false);
                this.j.b(m.a());
                Object object = !(throwable.getCause() instanceof IllegalArgumentException) && !(throwable instanceof com.b.a.h) ? this.l : this.m;
                ((androidx.lifecycle.p)object).a(true);
                object = this.K();
                if (object != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(throwable.getClass().getSimpleName());
                    stringBuilder.append(" at SkewScrollRecyclerViewModel : ");
                    stringBuilder.append(throwable.getMessage());
                    object.a("\u30a8\u30e9\u30fc\u767a\u751f", stringBuilder.toString());
                }
                this.y.b(8);
                this.z.b(8);
                this.w.b(false);
                this.x.b(false);
            }

            public void a(List<Route> list) {
                j.b(list, "routes");
                this.a(list);
                Object object = this.p();
                Comparable<Calendar> comparable = null;
                ((androidx.lifecycle.p)object).b(null);
                this.b(list);
                if (((Collection)list).isEmpty() ^ true) {
                    Object object2;
                    Object object3;
                    Object object4;
                    h h2 = this;
                    Object object5 = list;
                    Iterator iterator = object5.iterator();
                    if (!iterator.hasNext()) {
                        object4 = null;
                    } else {
                        object = iterator.next();
                        object3 = m.f(((Route)object).getLines()).getFrom().dateTime();
                        if (object3 == null) {
                            j.a();
                        }
                        object3 = ((Calendar)object3).getTime();
                        do {
                            object4 = object;
                            if (!iterator.hasNext()) break;
                            object4 = iterator.next();
                            object2 = m.f(((Route)object4).getLines()).getFrom().dateTime();
                            if (object2 == null) {
                                j.a();
                            }
                            if (object3.compareTo((Calendar)(object2 = (Comparable)((Calendar)object2).getTime())) <= 0) continue;
                            object = object4;
                            object3 = object2;
                        } while (true);
                    }
                    if (object4 == null) {
                        j.a();
                    }
                    if ((object = m.f(((Route)object4).getLines()).getFrom().dateTime()) == null) {
                        j.a();
                    }
                    h.a(h2, (Calendar)object);
                    object2 = this;
                    object5 = object5.iterator();
                    if (!object5.hasNext()) {
                        object4 = comparable;
                    } else {
                        object = object5.next();
                        object3 = m.h(((Route)object).getLines()).getTo().dateTime();
                        if (object3 == null) {
                            j.a();
                        }
                        object3 = ((Calendar)object3).getTime();
                        do {
                            object4 = object;
                            if (!object5.hasNext()) break;
                            object4 = object5.next();
                            comparable = m.h(((Route)object4).getLines()).getTo().dateTime();
                            if (comparable == null) {
                                j.a();
                            }
                            if (object3.compareTo(comparable = (Comparable)comparable.getTime()) >= 0) continue;
                            object = object4;
                            object3 = comparable;
                        } while (true);
                    }
                    if (object4 == null) {
                        j.a();
                    }
                    if ((object = m.h(((Route)object4).getLines()).getTo().dateTime()) == null) {
                        j.a();
                    }
                    h.b((h)object2, (Calendar)object);
                }
                this.j.b(list);
            }

            @Override
            public /* synthetic */ void a_(Object object) {
                this.a((List)object);
            }

            @Override
            public void b_() {
                this.I();
                this.a(false);
                this.k.a(false);
                this.q().f();
            }
        });
    }

}

