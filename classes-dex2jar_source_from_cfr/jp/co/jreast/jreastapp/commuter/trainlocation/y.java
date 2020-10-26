/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import androidx.f.a.i;
import androidx.lifecycle.LiveData;
import jp.co.jreast.jreastapp.commuter.al;
import jp.co.jreast.jreastapp.commuter.common.q;
import jp.co.jreast.jreastapp.commuter.m.f;
import jp.co.jreast.jreastapp.commuter.m.p;
import jp.co.jreast.jreastapp.commuter.m.s;
import jp.co.jreast.jreastapp.commuter.m.u;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.v;
import jp.co.jreast.jreastapp.commuter.webview.o;
import kotlin.Metadata;
import kotlin.e.b.j;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u001bJ\u0010\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u001bH\u0002J\u000e\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u0011J\u000e\u00102\u001a\u00020*2\u0006\u0010.\u001a\u00020\u001bR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "Landroidx/lifecycle/ViewModel;", "historyRepos", "Ljp/co/jreast/jreastapp/commuter/repository/UserTrainLocationHistoryRepository;", "userRepos", "Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;", "siteGenerator", "Ljp/co/jreast/jreastapp/commuter/common/SiteGenerator;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "localRailwayRepository", "Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;", "translationRepository", "Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/UserTrainLocationHistoryRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserSettingsRepository;Ljp/co/jreast/jreastapp/commuter/common/SiteGenerator;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;Ljp/co/jreast/jreastapp/commuter/repository/TranslationRepository;)V", "_appNameTextProperty", "Landroidx/lifecycle/MutableLiveData;", "", "appNameTextProperty", "Landroidx/lifecycle/LiveData;", "getAppNameTextProperty", "()Landroidx/lifecycle/LiveData;", "appNameVisibilityProperty", "", "getAppNameVisibilityProperty", "openStoreEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "getOpenStoreEvent", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "openWebBrowserEvent", "getOpenWebBrowserEvent", "openWebViewEvent", "Ljp/co/jreast/jreastapp/commuter/webview/Site;", "getOpenWebViewEvent", "selectedPageEvent", "getSelectedPageEvent", "getAdapter", "Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "getPage", "", "savePage", "currentPage", "sendAnalyticsOfSearch", "railway", "setAnalyticsName", "setAppName", "appName", "tapRailway", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class y
extends androidx.lifecycle.v {
    private final al<RailwayLineInformation> a;
    private final al<o> b;
    private final al<String> c;
    private final al<Integer> d;
    private final androidx.lifecycle.p<String> e;
    private final LiveData<String> f;
    private final LiveData<Integer> g;
    private final u h;
    private final s i;
    private final q j;
    private final jp.co.jreast.jreastapp.commuter.l.a k;
    private final f l;
    private final p m;

    public y(u liveData, s s2, q q2, jp.co.jreast.jreastapp.commuter.l.a a2, f f2, p p2) {
        j.b(liveData, "historyRepos");
        j.b(s2, "userRepos");
        j.b(q2, "siteGenerator");
        j.b(f2, "localRailwayRepository");
        j.b(p2, "translationRepository");
        this.h = liveData;
        this.i = s2;
        this.j = q2;
        this.k = a2;
        this.l = f2;
        this.m = p2;
        this.a = new al();
        this.b = new al();
        this.c = new al();
        this.d = new al();
        liveData = new androidx.lifecycle.p();
        ((androidx.lifecycle.p)liveData).b("");
        this.e = liveData;
        liveData = androidx.lifecycle.u.a((LiveData)this.e, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    